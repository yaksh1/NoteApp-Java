package com.query;

public class Queries {
	public static String insert = "INSERT INTO users(name,email,mobile,password) values(?,?,?,?)";
	public static String update = "";
	public static String delete = "";
	public static String select = "SELECT*FROM users";
	public static String loginSelect = "SELECT * FROM users where email = ? and password = ?";
	
	
	public static String addPost = "INSERT INTO posts(postTitle,postContent,uid) values(?,?,?)";
	public static String getNotes = "SELECT * FROM posts where uid = ? ORDER BY postId DESC";
	
}
