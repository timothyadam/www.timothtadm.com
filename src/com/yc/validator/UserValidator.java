package com.yc.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.yc.dao.MemberDao;
import com.yc.entity.Member;

@Component
public class UserValidator implements Validator {

    @Autowired
    MemberDao dao;


    @Override
    public boolean supports(Class<?> clazz) {
        return Member.class.equals(clazz);
    }

    private final Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

    @Override
    public void validate(Object target, Errors errors) {
    	Member member = (Member) target;

        boolean isCreate = (member.getId() == null);

        if (isCreate) {
        	validateMemberCode(member, errors);
        }
        validatePass(member, errors);
        //validateEmail(user, errors);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account", null, "用户名不能为空");
        if (!errors.hasFieldErrors("userName")) {
            if (member.getAccount().length() > 10) {
                errors.rejectValue("account", null, "用户名长度不能为10");
            }
        }




    }


    private void validateMemberCode(Member member, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberCode", null, "验证码为空");
        if (!errors.hasFieldErrors("memberCode")) {
            String memberCode = member.getMemberCode();
            Member obj = dao.findByMemberCode(memberCode);
            if (obj != null) {
                errors.rejectValue("memberCode", null, "用户验证码");
            }
        }
    }

    private void validatePass(Member member, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "密码不能为空");
        if (!errors.hasFieldErrors("password") && member.getId()==null) {
            if (member.getPassword().length() < 6 || member.getPassword().length() > 25) {
                errors.rejectValue("password", null, "密码不能小于6且大于25");
            }
        }

        if (!StringUtils.equals(member.getPassword(), member.getConfirmPass())) {
            errors.rejectValue("confirmPass", null, "确认密码不能为空");
        }
    }


    private void validateEmail(Member member, Errors errors) {

        if (member.getId() != null) {
        	Member di = dao.findOne(member.getId());
            if (di != null && StringUtils.equals(di.getEmail(), member.getEmail())) {
                return;
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "email不能为空");
        if (!errors.hasFieldErrors("email")) {
            Matcher matcher = emailPattern.matcher(member.getEmail());
            if (!matcher.matches()) {
                errors.rejectValue("email", null, "email格式不正确");
            } else if (member.getEmail().length() > 50) {
                errors.rejectValue("email", null, "email长度过长");
            } else {
                if (member.getId() != null) {
                	Member obj = dao.findByIdNotAndEmail(member.getId(), member.getEmail());
                    if (obj != null) {
                        errors.rejectValue("email", null, "该邮箱已使用");
                    }
                } else {
                	Member obj = dao.findByEmail(member.getEmail());
                    if (obj != null) {
                        errors.rejectValue("email", null, "该邮箱不存在");
                    }
                }
            }
        }
    }
}