package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.query.Queries;
import com.user.PostDetails;

public class PostDAO {
	private Connection conn;

	/**
	 * @param conn
	 */
	public PostDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addPost(String title, String content, int uid) {

		boolean done = false;

		String query = Queries.addPost;
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, title);
			st.setString(2, content);
			st.setInt(3, uid);

			int count = st.executeUpdate();

			if (count > 0) {
				done = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return done;

	}

	public List<PostDetails> getNotes(int id) {
		List<PostDetails> list = new ArrayList<>();
		
		try {
			String query = Queries.getNotes;
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				PostDetails post = new PostDetails();
				post.setPostId(rs.getInt(1));
				post.setPostTile(rs.getString("postTitle"));
				post.setPostContent(rs.getString("postContent"));
				post.setDate(rs.getTimestamp("date"));
				list.add(post);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public PostDetails getDataById(int editId) {
		PostDetails post=null;
		try {
			String query = Queries.editPost;
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, editId);

			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				post = new PostDetails();
				post.setPostId(rs.getInt(1));
				post.setPostTile(rs.getString(2));
				post.setPostContent(rs.getString(3));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return post;
	}
	
	public boolean postEdit(int nid,String title,String content) {
		boolean done=false;
		try {
			String query = Queries.postEditedNote;
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, title);
			st.setString(2, content);
			st.setInt(3, nid);
			
			int count = st.executeUpdate();
			if(count>0) {
				done=true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return done;
	}
	
	

}
