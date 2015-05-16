package com.yc.entity;


import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.annotate.JsonProperty;



/**
 * 统一定义id的entity基类.
 * 
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * 子类可重载getId()函数重定义id的列名映射和生成策略.
 * 
 * @author calvin
 */
//JPA 基类的标识

@MappedSuperclass
public abstract class IdEntity implements Serializable {

	protected Long id;

	@SequenceGenerator(name="seq_comm", sequenceName="SEQ_SYS_COMM_ID")
	@Id @GeneratedValue(generator="seq_comm")
	@JsonProperty 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
