package com.yc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 订单类
 * @author 王鑫
 * @修改日期 2015-5-25下午1:29:53
 */
@Entity
@Table(name = "yc_product")
public class Product implements Serializable {

	Long id;//产品Id
	int catId;//
	String title;//商品标题
	String thumb;//商品图片
	float  price;//商品单价
	
	
	
	
	
}
