package com.jdbc;

import java.time.LocalDate;

public class Match {

	private int mid;
	private String team1;
	private String team2;
	private LocalDate date;
	
	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Match(int mid, String team1, String team2, LocalDate date) {
		super();
		this.mid = mid;
		this.team1 = team1;
		this.team2 = team2;
		this.date = date;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Match [mid=" + mid + ", team1=" + team1 + ", team2=" + team2 + ", date=" + date + "]";
	}
	
	
	
}
