package com.yc.dao;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.yc.entity.Member;
/**
 * Title. <br>
 * Description.
 * <p/>
 * Copyright: Copyright (c) 13-5-21 ����2:53
 * <p/>
 * <p/>
 * Author: wangxin
 * <p/>
 * Version: 1.0
 * <p/>
 */
public interface MemberDao extends PagingAndSortingRepository<Member, Long>  {
	
	Member findByMemberCode(String memberCode);
	Member findByEmail(String email);
	Member findByIdNotAndEmail(Long id, String email);
	Member findByAccount(String account);
	
	
}
