package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.*;

import java.time.*;
import java.util.Arrays;

@Entity
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	private String name;
	private String dob;
	private String address;
	private String contact;
	private String email;
	private String pancard;
	private String aadhar;
	
	private String accno;
	private String ifsc;
	private String branch;
	private String acctype;
	private String minbal;
	private String username;
	private String password;
	private String oldPassword;

	public LocalDate getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(LocalDate uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	@Lob
	private byte[] panFileData;

	private String panFileName;

	@Lob
	private byte[] aadharFileData;

	private String aadharFileName;

	public byte[] getPanFileData() {
		return panFileData;
	}

	public void setPanFileData(byte[] panFileData) {
		this.panFileData = panFileData;
	}

	public String getPanFileName() {
		return panFileName;
	}

	public void setPanFileName(String panFileName) {
		this.panFileName = panFileName;
	}

	public byte[] getAadharFileData() {
		return aadharFileData;
	}

	public void setAadharFileData(byte[] aadharFileData) {
		this.aadharFileData = aadharFileData;
	}

	public String getAadharFileName() {
		return aadharFileName;
	}

	public void setAadharFileName(String aadharFileName) {
		this.aadharFileName = aadharFileName;
	}

	private LocalDate uploadedDate;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime creationDate;
	@UpdateTimestamp
	private LocalDateTime lastUpdated;

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public String getMinbal() {
		return minbal;
	}

	public void setMinbal(String minbal) {
		this.minbal = minbal;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Accounts [userID=" + userID + ", name=" + name + ", dob=" + dob + ", address=" + address + ", contact="
				+ contact + ", email=" + email + ", pancard=" + pancard + ", aadhar=" + aadhar + ", accno=" + accno
				+ ", ifsc=" + ifsc + ", branch=" + branch + ", acctype=" + acctype + ", minbal=" + minbal
				+ ", username=" + username + ", password=" + password + ", oldPassword=" + oldPassword
				+ ", panFileData=" + Arrays.toString(panFileData) + ", panFileName=" + panFileName + ", aadharFileData="
				+ Arrays.toString(aadharFileData) + ", aadharFileName=" + aadharFileName + ", uploadedDate="
				+ uploadedDate + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated
				+ ", getUploadedDate()=" + getUploadedDate() + ", getOldPassword()=" + getOldPassword()
				+ ", getPanFileData()=" + Arrays.toString(getPanFileData()) + ", getPanFileName()=" + getPanFileName()
				+ ", getAadharFileData()=" + Arrays.toString(getAadharFileData()) + ", getAadharFileName()="
				+ getAadharFileName() + ", getCreationDate()=" + getCreationDate() + ", getLastUpdated()="
				+ getLastUpdated() + ", getUserID()=" + getUserID() + ", getName()=" + getName() + ", getDob()="
				+ getDob() + ", getAddress()=" + getAddress() + ", getContact()=" + getContact() + ", getEmail()="
				+ getEmail() + ", getPancard()=" + getPancard() + ", getAadhar()=" + getAadhar() + ", getAccno()="
				+ getAccno() + ", getIfsc()=" + getIfsc() + ", getBranch()=" + getBranch() + ", getAcctype()="
				+ getAcctype() + ", getMinbal()=" + getMinbal() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
