package com.user;

import java.util.Date;

public class PostDetails {
	private int postId;
	private String postTile;
	private String postContent;
	private Date date;
	private UserDetails user;
	/**
	 * @param postId
	 * @param postTile
	 * @param postContent
	 * @param date
	 * @param user
	 */
	public PostDetails(int postId, String postTile, String postContent, Date date, UserDetails user) {
		super();
		this.postId = postId;
		this.postTile = postTile;
		this.postContent = postContent;
		this.date = date;
		this.user = user;
	}
	/**
	 * 
	 */
	public PostDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}
	/**
	 * @return the postTile
	 */
	public String getPostTile() {
		return postTile;
	}
	/**
	 * @param postTile the postTile to set
	 */
	public void setPostTile(String postTile) {
		this.postTile = postTile;
	}
	/**
	 * @return the postContent
	 */
	public String getPostContent() {
		return postContent;
	}
	/**
	 * @param postContent the postContent to set
	 */
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the user
	 */
	public UserDetails getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserDetails user) {
		this.user = user;
	}
	
	
}
