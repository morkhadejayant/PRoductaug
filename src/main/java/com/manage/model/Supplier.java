package com.manage.model;

public class Supplier {
	private int sId;
	private int sContact;
	private String sName;
	private String sType;
	private String sLocation;

	public Supplier(int sId, int sContact, String sName, String sType, String sLocation) {
		super();
		this.sId = sId;
		this.sContact = sContact;
		this.sName = sName;
		this.sType = sType;
		this.sLocation = sLocation;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getsContact() {
		return sContact;
	}

	public void setsContact(int sContact) {
		this.sContact = sContact;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public String getsLocation() {
		return sLocation;
	}

	public void setsLocation(String sLocation) {
		this.sLocation = sLocation;
	}

	public Supplier() {
		super();
	}

	@Override
	public String toString() {
		return "Supplier [sId=" + sId + ", sContact=" + sContact + ", sName=" + sName + ", sType=" + sType
				+ ", sLocation=" + sLocation + "]";
	}
}
