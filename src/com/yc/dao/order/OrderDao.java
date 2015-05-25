package com.yc.dao.order;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.yc.entity.ComBo;
import com.yc.entity.Member;
import com.yc.entity.Order;
/**
 * Title. <br>
 * Description.
 * <p/>
 * Copyright: Copyright (c) 15-05-25 
 * <p/>
 * <p/>
 * Author: wangxin
 * <p/>
 * Version: 1.0
 * <p/>
 */
public interface OrderDao extends PagingAndSortingRepository<Order, Long>  {
	

	
	
}
