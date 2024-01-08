package com.jdbc;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MatchMain {

	public static void main(String[] args) throws Exception  {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1. Insert match info:");
		System.out.println("2. View all Matches info:");
		System.out.println("3. View Upcoming Matches:");
		System.out.println("4. Update match info:");
		System.out.println("5. Delete Match details:");
		System.out.println("=========================");
		System.out.println("--Choose Above Options--");
		
		int choice=sc.nextInt();
		MatchBo mb=new MatchBo();
		switch(choice) {
		case 1:
//			insert operation
			System.out.println("Insert match info:");
			System.out.println("Enter match id");
			int mid=sc.nextInt();
			System.out.println("Enter team1 name");
			String team1=sc.next();
			System.out.println("Enter team2 name");
			String team2=sc.next();
			System.out.println("Enter the date(yyyy-mm-dd)");
			String date=sc.next();
			LocalDate ld=LocalDate.parse(date);
			
			Match m1=new Match(mid,team1,team2,ld);
			boolean b=mb.insertMatch(m1);
			if(b==false) {
				System.out.println("Match inserted successfully");
			}
			break;
			
		case 2:
//			view all match info
			System.out.println("All Match Information");
			List<Match>li=mb.getAllMatches();
			for(Match m2:li) {
				System.out.println(m2);
			}
			break;
			
		case 3:
//			view upcoming match
			System.out.println("Upcoming Matches Information");
		    List<Match> upcomingMatches = mb.getAvailableMatches();
		    if (upcomingMatches.isEmpty()) {
		        System.out.println("No upcoming matches.");
		    } 
		    else {
		        for (Match m2 : upcomingMatches) {
		            System.out.println(m2);
		        }
		    }
			break;
			
		case 4:
//			update match info
			System.out.println("Enter the Match ID to update:");
		    int matchIdToUpdate = sc.nextInt();
		    Match matchToUpdate = mb.getMatchById(matchIdToUpdate);
		    System.out.println(matchToUpdate);

		    System.out.println("Do you want to update team1 (Y/N) " + matchToUpdate.getTeam1());
		    String ch1 = sc.next();
		    if (ch1.equalsIgnoreCase("y")) {
		        System.out.println("Enter the new team1 name:");
		        String team1u = sc.next();
		        matchToUpdate.setTeam1(team1u);
		    }

		    System.out.println("Do you want to update team2 (Y/N) " + matchToUpdate.getTeam2());
		    String ch2 = sc.next();
		    if (ch2.equalsIgnoreCase("y")) {
		        System.out.println("Enter the new team2 name:");
		        String team2u = sc.next();
		        matchToUpdate.setTeam2(team2u);
		    }

		    boolean updated = mb.updateMatch(matchToUpdate);
		    if (updated) {
		        System.out.println("Match with ID " + matchIdToUpdate + " has been updated.");
		    } 
		    else {
		        System.out.println("Match not found or update failed.");
		    }

			break;
		case 5:
//			delete match info
			System.out.println("Enter the Match ID to delete:");
		    int matchIdToDelete = sc.nextInt();
		    boolean deleted = mb.deleteMatchInformation(matchIdToDelete);
		    if (deleted) {
		        System.out.println("Match with ID " + matchIdToDelete + " has been deleted.");
		    } 
		    else {
		        System.out.println("Match not found or deletion failed.");
		    }
			break;
		default:
			System.out.println("please choose correct option");
		}
	}

}
