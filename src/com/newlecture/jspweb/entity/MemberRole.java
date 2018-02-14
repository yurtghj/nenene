package com.newlecture.jspweb.entity;

public class MemberRole {
	private String member_id;
	private String role_id;
	
	public MemberRole(String member_id, String role_id) {
		super();
		this.member_id = member_id;
		this.role_id = role_id;
	}
	public MemberRole() {
		
	}
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	
	
}
