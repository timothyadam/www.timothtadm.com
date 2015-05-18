package com.yc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cplatform.dbhelp.DbHelper;
import com.yc.dao.MemberDao;
import com.yc.entity.Member;


@Service
public class MemberService {
	@Autowired
	private DbHelper dbHelper;
	@Autowired
	private MemberDao memberdao;
	
	//删除
	public void delMember(Long id) {
		memberdao.delete(id);
	}
	//增加
	public Member addorupdateMember(Member member){
		return memberdao.save(member);
	}
    //查找
   public Member finMemberById(Long id){
	  
	   return memberdao.findOne(id);
   }	
	
   //查找
   public Member finMemberAccount(String account){
	   return memberdao.findByMemberCode(account);
   }	
	
}
