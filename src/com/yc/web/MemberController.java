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
import com.yc.util.JsonRespWrapper;
import com.yc.validator.UserValidator;

@Controller
@RequestMapping(value="/sys")
public class MemberController {
	private static Logger log = Logger.getLogger(MemberController.class);
	@Autowired
	private  MemberService service;
	@Autowired
	private MemberDao dao;

	@Autowired
	private UserValidator userValidator;
	
	//判断是否 登陆
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		System.out.println("进来了1");
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
         if(flag==0){
       	  model.addAttribute("msg","请输入用户名！");
       	  System.out.println("请输入用户名！");
       	  return "sys/member/list"; 
         }
         if(flag==1){
       	  model.addAttribute("msg","请输入用户密码！");
       	  System.out.println("请输入用户密码！！");
       	 return "sys/member/list"; 
         }
         if(flag==2){
       	  model.addAttribute("msg","用户不存在！");
       	  System.out.println("用户不存在！！");
       	 return "sys/member/list"; 
         }
         if(flag==3){
       	  model.addAttribute("msg","密码不正确！");
    	  System.out.println("密码不正确！");
       	 return "sys/member/list"; 
         }
       return 	  "sys/member/list"; 
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
		return JsonRespWrapper.success();	
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

		return "/sys/user/pwd-change";
	}

	@RequestMapping(value = "changePwd", method = RequestMethod.POST)
	@ResponseBody
	public Object changePwd(HttpServletRequest request, String orgPwd, String dstPwd, String confirmPwd) {
	if (StringUtils.isEmpty(orgPwd) || StringUtils.isEmpty(dstPwd) || StringUtils.isEmpty(confirmPwd)) {
			return JsonRespWrapper.successAlert("密码信息不为空");
		}
			if (!dstPwd.equals(confirmPwd)) {
			return JsonRespWrapper.successAlert("和确认密码不一致");
		}
		SessionUser sessionUser = (SessionUser) request.getSession().getAttribute(SessionUser.SESSION_USER_KEY);
		if (sessionUser == null) {
			return JsonRespWrapper.successJump("/logout");
		}
     
		Member member = service.finMemberById(sessionUser.getId());
		if(!member.getPassword().equals(MD5.digest2Str(orgPwd))){
			return JsonRespWrapper.successAlert("原密码错误");
		}
		if (member.getPassword().equals(MD5.digest2Str(dstPwd))) {
			return JsonRespWrapper.successAlert("未修改");
		}
		member.setPassword(MD5.digest2Str(dstPwd));
		 service.addorupdateMember(member);
		return JsonRespWrapper.success("修改成功", "/menu/welcome");
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
		return JsonRespWrapper.success("修改成功", "/menu/welcome");
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
        sb.append("var XH_MAXSIZE = '").append(appConfig.getXheditorMaxSize()).append("';\n");
        sb.append("var XH_DOMAIN = '").append(appConfig.getXheditorDomain()).append("';\n");*/

		return sb.toString();
	}

	
}
