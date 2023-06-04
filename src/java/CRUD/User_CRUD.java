package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.ResultSet;
import common.Db_connection;
import common.LoginBean;
import common.User_Bean;

public class User_CRUD {
	public static Connection conn;

	public static void main(String args[]) {
		System.out.println("halo user add");
	}

	public boolean loginDao(LoginBean loginbean) {
		Db_connection db = new Db_connection();
		conn = db.getConnection();
		boolean status = false;
		PreparedStatement userlogin;
		 
		try {
			userlogin = conn.prepareStatement("select * from user where email=? and password=?");
			userlogin.setString(1, loginbean.getEmail());
			userlogin.setString(2, loginbean.getPassword());

			ResultSet rs = userlogin.executeQuery();
			status = rs.next();
			if (status) {
				loginbean.setName(rs.getString("name"));}
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

	public int userCount() {
		Db_connection db = new Db_connection();
		conn = db.getConnection();
		int count = 0;
		PreparedStatement alluser;
		try {
			alluser = conn.prepareStatement("select * from user");
			ResultSet rs = alluser.executeQuery();
			while (rs.next()) {
				count++;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("total user=" + count);
		return count;
	}

	public int addUser(User_Bean obj_user_bean) {
		Db_connection db = new Db_connection();
		conn = db.getConnection();
		int status = 0;
		try {
			PreparedStatement insert = conn
					.prepareStatement("insert into user(name,password,email,sex,country) values(?,?,?,?,?)");
			insert.setString(1, obj_user_bean.getName());
			insert.setString(2, obj_user_bean.getPassword());
			insert.setString(3, obj_user_bean.getEmail());
			insert.setString(4, obj_user_bean.getSex());
			insert.setString(5, obj_user_bean.getCountry());
			status = insert.executeUpdate();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public static ArrayList<ArrayList<String>> getAllUser() {
		Db_connection db = new Db_connection();
		conn = db.getConnection();
		ArrayList<ArrayList<String>> user = new ArrayList<ArrayList<String>>();
		try {
			PreparedStatement alluser = conn.prepareStatement("select * from user");
			ResultSet rs = alluser.executeQuery();
			int i = 0;
			while (rs.next()) {
				user.add(new ArrayList<String>());
				user.get(i).add(0, String.valueOf(rs.getInt("id")));
				user.get(i).add(1, rs.getString("name"));
				user.get(i).add(2, rs.getString("password"));
				user.get(i).add(3, rs.getString("email"));
				user.get(i).add(4, rs.getString("sex"));
				user.get(i).add(5, rs.getString("country"));
				i++;
			}
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public static ArrayList<String> getUserById(int id) {
		Db_connection db = new Db_connection();
		conn = db.getConnection();
		ArrayList<String> user = new ArrayList<String>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from user where id=" + id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.add(String.valueOf(rs.getString("id")));
				user.add(rs.getString("name"));
				user.add(rs.getString("password"));
				user.add(rs.getString("email"));
				user.add(rs.getString("sex"));
				user.add(rs.getString("country"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public int delete_user(int id) {
		Db_connection db = new Db_connection();
		conn = db.getConnection();
		int status = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("delete from user where id=" + id);
			status = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	public static int updateUser(int id, String name, String password, String email, String sex, String country) {
		Db_connection db = new Db_connection();
		conn = db.getConnection();
		int status = 0;
		try {
			PreparedStatement ps = conn
					.prepareStatement("update user set name=?,password=?,email=?,sex=?,country=? where id=" + id);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, sex);
			ps.setString(5, country);
			status = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public List<User_Bean> allUserByDao() {
		List<User_Bean> list = new ArrayList<User_Bean>();
		Db_connection db = new Db_connection();
		conn = db.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User_Bean obj_user_bean = new User_Bean();
				obj_user_bean.setId(rs.getInt("id"));
				obj_user_bean.setName(rs.getString("name"));
				obj_user_bean.setPassword(rs.getString("password"));
				obj_user_bean.setEmail(rs.getString("email"));
				obj_user_bean.setSex(rs.getString("sex"));
				obj_user_bean.setCountry(rs.getString("country"));
				list.add(obj_user_bean);
			}
             conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
