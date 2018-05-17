package com.zkai.financial.dto.bonus;

import java.io.Serializable;

/**
 * 用户红包DTO
 * @author caojian
 *
 */
public class UserBonusDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -65347773128118878L;

	private String id;
	
	private String uid;
	
	private String name;
	
	private double money;

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

}
