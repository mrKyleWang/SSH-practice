package com.itheima.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="t_person")
public class Person {

	@Id
	@GenericGenerator(name = "myUuid",strategy = "uuid")
	@GeneratedValue(generator= "myUuid")
	private String id;

	private String name;

	@Transient
	private String msg;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}


