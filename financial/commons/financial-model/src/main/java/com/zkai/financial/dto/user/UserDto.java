package com.zkai.financial.dto.user;

import java.io.Serializable;
import java.util.List;

import com.zkai.financial.dto.bonus.UserBonusDto;

/**
 * 用户DTO
 * @author caojian
 *
 */
public class UserDto  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -65347773128118878L;

	private String id;
	
	private String name;
	
	private String mobile;
	
	private String address;
	
	private List<UserBonusDto> bonusList;

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<UserBonusDto> getBonusList() {
		return bonusList;
	}

	public void setBonusList(List<UserBonusDto> bonusList) {
		this.bonusList = bonusList;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
