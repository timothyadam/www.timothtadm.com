package com.yc.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jasig.cas.client.authentication.AttributePrincipalImpl;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.AssertionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.stat.TableStat.Mode;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.cplatform.util2.TimeStamp;
import com.cplatform.util2.security.MD5;
import com.google.gson.Gson;
import com.yc.dao.MemberDao;
import com.yc.entity.JsonResult;
import com.yc.entity.Member;
import com.yc.entity.SessionUser;
import com.yc.service.MemberService;
import com.yc.util.AppConfig;
import com.yc.util.JsonRespWrapper;
import com.yc.validator.UserValidator;

@Controller
@RequestMapping(value="/")
public class MemberController {
	private static Logger log = Logger.getLogger(MemberController.class);
	@Autowired
	private  MemberService service;
	@Autowired
	private MemberDao dao;

	@Autowired
	private UserValidator userValidator;
	@Autowired
	AppConfig appConfig;
	//判断是否 登陆
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
        return "/admin/login";

	}
	
   //登陆校验
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session, Model model) throws SQLException {
		Member member = new Member();
		System.out.println(session.getId());
		member=service.finMemberById(0L);
		model.addAttribute("member", member);
		return "sys/member/list";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Object memberlogin(Model model,String account,String password, HttpSession session) {
		 int flag=  fackLogin(session, account,password,"");
         if(flag==2){
       	 model.addAttribute("msg","用户不存在！");
       	 return "sys/member/list"; 
         }
         if(flag==3){
          return JsonRespWrapper.success("密码错误","sys/member/list");
         }
       return 	JsonRespWrapper.success("登陆成功","sys/member/list"); 
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String userEdit( HttpSession session, Model model) throws SQLException {
		SessionUser sessionUser = (SessionUser) session.getAttribute(SessionUser.SESSION_USER_KEY);
		Member  members = new Member();
		model.addAttribute("member",members);
		return "sys/member/memberrer";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public Object userUpdate(@ModelAttribute("member") Member member, HttpServletRequest request, HttpSession session, BindingResult result) {
		SessionUser sessionUser = (SessionUser) session.getAttribute(SessionUser.SESSION_USER_KEY);
		//注册 1  用户名是否已经 存在  2  邮箱是否已经存在  用户名 是否 为空  
		if(member!=null||"".equals(member)){
		String time = TimeStamp.getTime(TimeStamp.YYYYMMDDhhmmss); 
		 member.setCreate_time(time);  
		 member.setMemberCode(member.getAccount());
 		 member.setPassword(MD5.digest2Str(member.getPassword()));
         try {
        	 service.addorupdateMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return JsonRespWrapper.error(e.getMessage());
		}		
		}
		System.out.println(JsonRespWrapper.success("注册成功", "/sys/member/register"));
		return JsonRespWrapper.success("注册成功", "/login");
	}

/*	@RequestMapping(value = "userDel")
	@ResponseBody
	public Object userDel(@RequestParam(value = "id") Long id) {
		SysUser user = this.userService.findSysUserById(id);
		user.setStatus(3);
		logUtils.logDelete("ɾ���ɫ", "ɾ��ɹ�����ɫ��ţ�" + id);
		this.userService.addOrUpdateSysUser(user);
		return JsonRespWrapper.success("ɾ��ɹ���", "/sys/user/list");
	}

	*/

	
	@RequestMapping(value = "changePwd", method = RequestMethod.GET)
	public String changePwd(Model model) {
		Member  members = new Member();
		model.addAttribute("member",members);
		return "/sys/member/pwd_change";
	}

	@RequestMapping(value = "changePwd", method = RequestMethod.POST)
	@ResponseBody
	public Object changePwd(HttpServletRequest request, String password, String newPass, String confirmPass) {
	if (StringUtils.isEmpty(password) || StringUtils.isEmpty(newPass) || StringUtils.isEmpty(confirmPass)) {
			return JsonRespWrapper.successAlert("密码不为空");
		}
			if (!newPass.equals(confirmPass)) {
			return JsonRespWrapper.successAlert("和确认密码不一致");
		}
		SessionUser sessionUser = (SessionUser) request.getSession().getAttribute(SessionUser.SESSION_USER_KEY);
		if (sessionUser == null) {
			return JsonRespWrapper.successJump("/logout");
		}
     
		Member member = service.finMemberById(sessionUser.getId());
		if(!member.getPassword().equals(MD5.digest2Str(password))){
			return JsonRespWrapper.successAlert("原密码错误");
		}
		if (member.getPassword().equals(MD5.digest2Str(newPass))) {
			return JsonRespWrapper.successAlert("未修改");
		}
		member.setPassword(MD5.digest2Str(newPass));
		 service.addorupdateMember(member);
		return JsonRespWrapper.success("修改成功", "/login");
	}

	//修改用户名 account
	
	@RequestMapping(value = "changeAccount", method = RequestMethod.GET)
	public String changeAccount(Model model) {

		return "/sys/user/account-change";
	}
	
	@RequestMapping(value = "changeAccount", method = RequestMethod.POST)
	@ResponseBody
	public Object changeAccount(HttpServletRequest request, String account) {
     if(StringUtils.isEmpty(account)){
    	 return JsonRespWrapper.successAlert("用户名不能为空"); 
     } 
     
     Member member = service.finMemberAccount(account);
     if(member!=null){
    		return JsonRespWrapper.successAlert("用户名为空");
     }else{
    	 
    	 service.addorupdateMember(member);	 
    	 
     }
		return JsonRespWrapper.success("修改成功", "/login");
	}
	
	
    private int fackLogin(HttpSession session, String uid,String pass,String sign) {
        final String principal = uid;

        if (uid == null || "".equals(uid) ) {
            return 0;
        }
        
        if (pass == null  || "".equals(pass)) {
            return 1;
        }

        Member user = dao.findByMemberCode(uid);

        if (user == null) {
        	 return 2;
        }
        if(null !=sign && !"".equals(sign)){
        	if(!pass.equals(user.getPassword())){
           	   return 3;
              }
        }else{
//        
        	 if(!MD5.digest2Str(pass).equals(user.getPassword())){
          	   return 3;
             }
        }
      
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("id", user.getId());
        attributes.put("FLAG", user.getFlag());
        attributes.put("account", user.getAccount());
        attributes.put("EMAIL", user.getEmail());
        attributes.put("PHONE", user.getPhone());
        attributes.put("MEMBERCODE", user.getMemberCode());
        //attributes.put("STATUS", user.getStatus());
        //attributes.put("CHANGE_PWD_TIME", user.getChangePwdTime());
       // attributes.put("TERMINAL_ID", user.getTerminalId());
        //attributes.put("VALID_TIME", user.getValidTime());
        Assertion assertion = new AssertionImpl(new AttributePrincipalImpl(principal, attributes));
        session.setAttribute("member", attributes);
        session.setAttribute(AbstractCasFilter.CONST_CAS_ASSERTION, assertion);
        return -1;
    }
   
    /*
	 * 用于js脚本的全部
	 */
	@RequestMapping(value = "/static/global.js", produces = { "application/x-javascript", "text/javascript", "application/javascript" })
	@ResponseBody
	public String jsGlobal(WebRequest webRequest) {
		System.out.println("ok look  ");
		StringBuilder sb = new StringBuilder();
		sb.append("var G_CTX_ROOT = '").append(webRequest.getContextPath()).append("';\n");
        System.out.println(sb.toString());
        /*sb.append("var XH_EXT = '").append(appConfig.getXheditorExt()).append("';\n");
		 sb.append("var XH_IMG_EXT = '").append(appConfig.getXheditorImageExt()).append("';\n");
		 sb.append("var XH_DOMAIN = '").append(appConfig.getXheditorDomain()).append("';\n");
		   sb.append("var XH_MAXSIZE = '").append(appConfig.getXheditorMaxSize()).append("';\n");
        */

		return sb.toString();
	}

	
}
