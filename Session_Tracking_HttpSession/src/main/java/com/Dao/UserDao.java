package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	
	String result = "";
	
	public String signupUser(String name, String pass, Connection con)
	{
		try
		{
			String sql = "insert into users values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, pass);
			
			int row = ps.executeUpdate();
			if(row==1)
			{
				result = "inserted";
			}
			else
			{
				result = "failed";
			}
		}
		catch (Exception e) {
			result = "failed";
			System.out.println(e);
		}
		finally
		{
			return result;
		}
	}
	
	
	
	public String loginUser(String name, String pass, Connection con)
	{
		try
		{
			String sql = "select * from users where Username = ? and Password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			int count=0;
			while(rs.next())
			{
				count++;
			}
			if(count==1)
			{
				result="exists";
			}
			else
			{
				result="not exists";
			}
		}
		catch (Exception e) {
			result="not exists";
			System.out.println(e);
		}
		finally
		{
			return result;
		}
	}

}
