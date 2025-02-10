package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

public class Userdao 
{
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","root");
	
		} catch (Exception e) {
			System.out.println(e);// TODO: handle exception
		}
		return con;
	}
	public static int saveUser(User u) {
		int status=0;
		u.setUtype("user");
		try {
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("insert into user(fname,lname,state)values(?,?,?)");
			ps.setString(1,u.getFname());
			ps.setString(2,u.getLname());
			ps.setString(3,u.getState());
			status=ps.executeUpdate();
			PreparedStatement ps1=con.prepareStatement("select max(id)from user");
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				u.setId(rs.getInt(1));
			}
			PreparedStatement ps2=con.prepareStatement("insert into login(email,password,utype,userid)values(?,?,?,?)");
			ps2.setString(1,u.getEmail());
			ps2.setString(2,u.getPassword());
			ps2.setString(3,u.getUtype());
			ps2.setInt(4,u.getId());
			status+=ps2.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static User userDetails(String email,String password)
	{
		User u=null;
		
		try 
		{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select user.id,user.fname,user.lname,user.state,login.email,login.utype from user inner join login on user.id=login.userid where login.email=? and login.password=?");
			ps.setString(1,email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				 u = new User();
				u.setId(rs.getInt("id"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setState(rs.getString("state"));
				u.setEmail(rs.getString("email"));
				u.setUtype(rs.getString("utype"));
			}
		}
			catch (Exception e) 
		{
			System.out.println(e);
		}
		return u;
	}
	public static List<User> viewAll() {
	    List<User> us = new ArrayList<User>();
	    try {
	        Connection con = getConnection();
	        PreparedStatement ps = con.prepareStatement("select user.id,user.fname,user.lname,user.state,login.email,login.password from user inner join login on user.id=login.userid ");
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            User user = new User();
	            user.setId(rs.getInt("id"));
	            user.setFname(rs.getString("fname"));
	            user.setLname(rs.getString("lname"));
	            user.setState(rs.getString("state"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            us.add(user);
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return us;
	}
	public static User edit(int id)
	{
		User u = new User();
		try 
		{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select user.id,user.fname,user.lname,user.state,login.email,login.password  from user left join login on user.id=login.userid where user.id=? ");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				u.setId(rs.getInt(1));
				u.setFname(rs.getString(2));
				u.setLname(rs.getString(3));
				u.setState(rs.getString(4));
				u.setEmail(rs.getString(5));
				u.setPassword(rs.getString(6));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return u;
	}
	public static int updateUser(User u)
	{
	int status=0;
	try
	{
	Connection con=getConnection();
	PreparedStatement ps=con.prepareStatement("update login set email=?,password=? where userid=?");
	ps.setString(1,u.getEmail());
	ps.setString(2,u.getPassword());
	ps.setInt(3,u.getId());
	status =ps.executeUpdate();
	PreparedStatement ps1=con.prepareStatement("update user set fname=?,lname=?,state=? where id=?");
	ps1.setString(1,u.getFname());
	ps1.setString(2,u.getLname());
	ps1.setString(3,u.getState());
	ps1.setInt(4,u.getId());
	status+=ps1.executeUpdate();
	} catch (Exception e) 
	{
		System.out.println(e);
		// TODO: handle exception
	}
	return status;
	}
	public static int deleteUser(int id)
	{
	int status=0;
	try
	{
		Connection con=getConnection();
		
		 PreparedStatement ps = con.prepareStatement("delete from login where userid=?");
		  ps.setInt(1, id);
		  status +=ps.executeUpdate();
		  
		  PreparedStatement ps1 = con.prepareStatement("delete from user where id=?");  
		  ps1.setInt(1, id);
		  status += ps1.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return status;
	}
	
	
}
