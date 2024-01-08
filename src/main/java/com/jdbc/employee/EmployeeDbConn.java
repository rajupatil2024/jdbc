package com.jdbc.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDbConn {

	public void insert(int id,String name,double sal,String loc,long ph_no) throws Exception,SQLException {
		
		Connection con=DbConn.getConnection();
		
		String iquery="insert into employee values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(iquery);
		
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setDouble(3, sal);
		ps.setString(4, loc);
		ps.setLong(5, ph_no);
		
		int count=ps.executeUpdate();
		
		if(count>0)
		{
			System.out.println("Record has been inserted Successfully");
		}
	}
	
	public void display() throws Exception,SQLException {
		ArrayList<EmployeeDao> al=new ArrayList<EmployeeDao>();
		Connection con=DbConn.getConnection();
		
		String squery="select * from employee;";
		PreparedStatement ps=con.prepareStatement(squery);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			al.add(new EmployeeDao(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getLong(5)));
		}
		
		for(EmployeeDao e:al) {
			System.out.println("id: "+e.getId()+" name: "+e.getName()+" salary: "+e.getSal()+" location: "+e.getLoc()+" phone number: "+e.getPh_no());
		}
		
	}
	
	public void update(int id, String name, double sal, String loc, long ph_no) throws Exception, SQLException {
	    Connection con = DbConn.getConnection();

	    String uquery = "UPDATE employee SET name=?, sal=?, loc=?, ph_no=? WHERE id=?";
	    PreparedStatement ps = con.prepareStatement(uquery);

	    ps.setString(1, name);
	    ps.setDouble(2, sal);
	    ps.setString(3, loc);
	    ps.setLong(4, ph_no);
	    ps.setInt(5, id);

	    int count = ps.executeUpdate();

	    if (count > 0) {
	        System.out.println("Record has been updated successfully.");
	    } else {
	        System.out.println("No record found for the given ID. Update failed.");
	    }
	}
	
	public void delete(int id) throws Exception, SQLException {
	    Connection con = DbConn.getConnection();

	    String dquery = "DELETE FROM employee WHERE id=?";
	    PreparedStatement ps = con.prepareStatement(dquery);

	    ps.setInt(1, id);

	    int count = ps.executeUpdate();

	    if (count > 0) {
	        System.out.println("Record has been deleted successfully.");
	    } else {
	        System.out.println("No record found for the given ID. Delete failed.");
	    }
	}


}
	