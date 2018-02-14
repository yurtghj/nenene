package com.newlecture.jspweb.entity;

public class Comment {

	private String content;
	private String price;
	
	
	public Comment(String content, String price) {
		super();
		this.content = content;
		this.price = price;
	}
	public Comment() {
		
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
