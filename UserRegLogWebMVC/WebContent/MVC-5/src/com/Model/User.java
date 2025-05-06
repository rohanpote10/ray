package com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	private String uname;

	private String uaddress;

	private String unumber;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getUnumber() {
		return unumber;
	}

	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uaddress=" + uaddress + ", unumber=" + unumber + "]";
	}

}
