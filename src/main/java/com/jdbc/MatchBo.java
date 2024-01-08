package com.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MatchBo {

	public boolean insertMatch(Match m) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/match1","root","root1234");
		
		Statement st=con.createStatement();
	
		boolean b=st.execute("insert into match1 values("+m.getMid()+",'"+m.getTeam1()+"','"+m.getTeam2()+"','"+m.getDate()+"')");
		return b;
	}
	
	public List<Match>getAllMatches() throws Exception {
		List<Match> li=new ArrayList<Match>();
		
		//Step 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Step 2
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/match1","root","root1234");
		//Step 3
		PreparedStatement ps=con.prepareStatement("select * from match1");
		//Step 3.a
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			li.add(new Match(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate()));
		}
		return li;

	}
	public Match getMatchById(int mid) throws Exception {
		Match m=new Match();
		//select * from match2 where mid=?
		Class.forName("com.mysql.cj.jdbc.Driver");
		//step2
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/match1","root","root1234");
		
		PreparedStatement ps=con.prepareStatement("select * from match1 where mid=?");
		//Step 3.a
		ps.setInt(1, mid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			m=new Match(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate());
		}
		return m;
	}

	public boolean updateMatch(Match m)throws Exception {
		
		//update set team1=m.getTeam1() team2=m.getTeam2() date=m.getMatchDate() where mid=m.getMatchId()
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/match1", "root", "root1234");

	    // Use a PreparedStatement to update match information
	    PreparedStatement ps = con.prepareStatement("UPDATE match1 SET team1 = ?, team2 = ?, date = ? WHERE mid = ?");
	    ps.setString(1, m.getTeam1());
	    ps.setString(2, m.getTeam2());
	    ps.setDate(3, Date.valueOf(m.getDate()));
	    ps.setInt(4, m.getMid());

	    int rowsAffected = ps.executeUpdate();
	    return rowsAffected > 0;
	}

	public List<Match> getAvailableMatches() throws Exception {
		//your logic
		List<Match> li = new ArrayList<Match>();

	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/match1", "root", "root1234");

	    // Get the current date
	    LocalDate currentDate = LocalDate.now();

	    // Use a PreparedStatement to select upcoming matches
	    PreparedStatement ps = con.prepareStatement("SELECT * FROM match1 WHERE date > ?");
	    ps.setDate(1, Date.valueOf(currentDate));

	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) {
	        li.add(new Match(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate()));
	    }
		return li;
	}
	 
	public boolean deleteMatchInformation(int mid) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/match1", "root", "root1234");

	    // Use a PreparedStatement to delete a match by its ID
	    PreparedStatement ps = con.prepareStatement("DELETE FROM match1 WHERE mid = ?");
	    ps.setInt(1, mid);

	    int rowsAffected = ps.executeUpdate();
	    return rowsAffected > 0;
	}
}
