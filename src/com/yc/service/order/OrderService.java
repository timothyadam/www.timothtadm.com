package com.yc.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cplatform.dbhelp.DbHelper;
import com.yc.dao.order.OrderDao;
import com.yc.entity.Order;



@Service
public class OrderService {
	@Autowired
	private DbHelper dbHelper;
	@Autowired
	private OrderDao dao;
	
	//通过产品 Id查询 产品 
	public Order findbyId (Long id){
		return dao.findOne(id);
	}
	
	//增加产品
	public Order addOrUpdateOrder(Order order){
		return dao.save(order);
	}
	
   //删除产品
	public void delOrder(Long id){
    dao.delete(id);		
	}
	
	
}
