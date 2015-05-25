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
 * 产品类
 * 
 * @author 王鑫
 * @修改日期 2015-5-25下午1:29:53
 */
@Entity
@Table(name = "yc_combo")
public class ComBo implements Serializable {
	Long id;// 产品id
	int proId;// 产品类Id
	float price;// 产品Id
	String guige;// 规格
	String combo;// 产品
	String remark;// 产品备注
	String title;// 产品标题
	String comboName;// 产品
	String ipTv;// 1 是iptv 0 不含iptv

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
	@Column(name = "proid")
	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}
	@Column(name = "price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	@Column(name = "guige")
	public String getGuige() {
		return guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}
	@Column(name = "combo")
	public String getCombo() {
		return combo;
	}

	public void setCombo(String combo) {
		this.combo = combo;
	}
	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "comboname")
	public String getComboName() {
		return comboName;
	}

	public void setComboName(String comboName) {
		this.comboName = comboName;
	}
	@Column(name = "iptv")
	public String getIpTv() {
		return ipTv;
	}

	public void setIpTv(String ipTv) {
		this.ipTv = ipTv;
	}

}
