package com.jdbc.employee;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) throws Exception, SQLException {
		
		EmployeeDao e=new EmployeeDao();
		EmployeeDbConn db=new EmployeeDbConn();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter your Option: ");
		System.out.println(" 1.Insert\n 2.Display\n 3.Update\n 4.Delete");
		int opt=sc.nextInt();
		
		switch(opt) {
		case 1:
//			insert
			System.out.print("Enter Employee id: ");
			e.setId(sc.nextInt());
			System.out.print("Enter Employee Name: ");
			e.setName(sc.next());
			System.out.print("Enter Employee Salary: ");
			e.setSal(sc.nextDouble());
			System.out.print("Enter Employee Location: ");
			e.setLoc(sc.next());
			System.out.print("Enter Employee Phone Number: ");
			e.setPh_no(sc.nextLong());
			
			db.insert(e.getId(), e.getName(), e.getSal(), e.getLoc(), e.getPh_no());
			break;
		case 2:
//			display
			db.display();
			break;
		case 3:
//			update
		    System.out.print("Enter Employee ID to update: ");
		    int id = sc.nextInt();
		    System.out.print("Enter Employee Name: ");
		    String name = sc.next();
		    System.out.print("Enter Employee Salary: ");
		    double sal = sc.nextDouble();
		    System.out.print("Enter Employee Location: ");
		    String loc = sc.next();
		    System.out.print("Enter Employee Phone Number: ");
		    long ph_no = sc.nextLong();

		    db.update(id, name, sal, loc, ph_no);
		    break;
		case 4:
//			delete
		    System.out.print("Enter Employee ID to delete: ");
		    int deleteId = sc.nextInt();

		    db.delete(deleteId);
		    break;
		default:
			System.err.println("invalid input...");
		}

	}

}
