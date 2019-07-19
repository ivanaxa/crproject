package com.ivan.rulesdemo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="tbl_Rules")
public class Rules {
	@Id
	@GeneratedValue
	private int id;
	
	private String filename;
	private String customerid;
	private String ruletype;
	
	private int status;
	
	@Lob
	private byte[] drl;
	
	@CreationTimestamp
	private LocalDateTime createdate;
	
	//no arg constructor
	public Rules() {
		super();
	}
	
	public Rules(String filename, byte[] drl) {
		this.filename = filename;
		
		
		String[] arr1= filename.split("_"); //get the first part before the _
		String[] arr2= arr1[1].split("\\."); //get the first part before the .

		this.customerid =arr2[0] ;
		this.ruletype = arr1[0];
		
		this.status = 0;
		
		this.drl = drl;
	}


	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getRuletype() {
		return ruletype;
	}
	public void setRuletype(String ruletype) {
		this.ruletype = ruletype;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public byte[] getDrl() {
		return drl;
	}
	public void setDrl(byte[] drl) {
		this.drl = drl;
	}
	public LocalDateTime getCreatedate() {
		return createdate;
	}
	public void setCreatedate(LocalDateTime createdate) {
		this.createdate = createdate;
	}
	@Override
	public String toString() {
		return "Rules [id=" + id + ", filename=" + filename + ", customerid=" + customerid + ", ruletype=" + ruletype
				+ ", status=" + status + ", drl=" + drl + ", createdate=" + createdate + "]";
	}

	
	
}
