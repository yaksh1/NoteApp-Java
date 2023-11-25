package com.query;

public class Queries {
	public static String insert = "INSERT INTO users(name,email,mobile,password) values(?,?,?,?)";
	public static String update = "";
	public static String delete = "";
	public static String select = "SELECT*FROM users";
	public static String loginSelect = "SELECT * FROM users where email = ? and password = ?";
}
