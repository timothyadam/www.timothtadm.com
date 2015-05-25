package com.yc.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 订单类
 * @author 王鑫
 * @修改日期 2015-5-25下午1:29:53
 */
@Entity
@Table(name = "yc_order")
public class Order implements Serializable{
	  Long  id;         
	  String orderId;//订单Id
	  int memberId;//用户Id
	  String ip;//用户IP
	  String productId;//产品Id
	  String guser;//操作人员
	  String gidn;//身份证件
	  String gtel;//安装人电话
	  String name;//姓名
	  String tel;
	  String address;//地址
	  String email;
	  String guige;
	  float totalPrice;//总价
	  String remark;//标记
	  int  status;//订单状态
	  String create_Time;//订单开始 时间
	  String end_Time;
	  @Id  
      @Basic(optional = false)   
      @GeneratedValue(strategy = GenerationType.IDENTITY)   
      @Column(name = "id", nullable = false)   
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    @Column(name = "orderid")   
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
    @Column(name = "memberid")   
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
    @Column(name = "ip")   
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
    @Column(name = "productid")   
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
    @Column(name = "guser")   
	public String getGuser() {
		return guser;
	}
	public void setGuser(String guser) {
		this.guser = guser;
	}
    @Column(name = "gidn")   
	public String getGidn() {
		return gidn;
	}
	public void setGidn(String gidn) {
		this.gidn = gidn;
	}
    @Column(name = "gtel")   
	public String getGtel() {
		return gtel;
	}
	public void setGtel(String gtel) {
		this.gtel = gtel;
	}   
	@Column(name = "name")   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "tel")   
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(name = "address")   
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "email")   
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "guige")   
	public String getGuige() {
		return guige;
	}
	public void setGuige(String guige) {
		this.guige = guige;
	}
	@Column(name = "totalprice")   
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Column(name = "remark")   
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name = "status")   
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Column(name = "create_time")   
	public String getCreate_Time() {
		return create_Time;
	}
	public void setCreate_Time(String create_Time) {
		this.create_Time = create_Time;
	}
	@Column(name = "end_time")   
	public String getEnd_Time() {
		return end_Time;
	}
	public void setEnd_Time(String end_Time) {
		this.end_Time = end_Time;
	}
}
