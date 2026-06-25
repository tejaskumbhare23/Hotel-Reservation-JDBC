package com.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.controller.HotelController;
import com.entity.Hotel;
import com.exception.ReservationNotFoundException;

public class Main {
	public static void main(String[] args) {
		
	

	HotelController controller=new HotelController();
	

	int choice=0;
	do {
	Scanner sc=new Scanner(System.in);
	
	System.out.println("1.ADD RESERVATION");
	System.out.println("2.GET BY GUEST-NAME");
	System.out.println("3.GET ALL RESERVATION");
	System.out.println("4.UPDATE RESERVATION"); 
	System.out.println("5.DELETE RESERVATION");
	System.out.println("6.EXIT");
	
	System.out.println("ENTER YOUR CHOICE ");
	 choice=sc.nextInt();
	 sc.nextLine();
	 
	 
	switch(choice)
	{
	case 1:
		System.out.println("Enter Guest-Name :");
		String name0=sc.nextLine();
		System.out.println("Enter Room-No :");
		int roomNo=sc.nextInt();
		System.out.println("Enter Contact No :");
		String cn=sc.next();
		System.out.println("Enter Reservation Date :");
		String rd=sc.next();
		
		Hotel hotel=new Hotel(name0, roomNo, cn, rd);
		String r = controller.addReservation(hotel);
		System.out.println(r);
		break;
		
	case 2:
		try {
		System.out.println("Enter GuestName to get Reservation Details");
		String name1=sc.next();
		Hotel byName = controller.getByName(name1);
		System.out.println("GUEST_NAME :"+byName.getGuestName());
		System.out.println("ROOM_NO :"+byName.getContactNo());
		System.out.println("CONTACT_NO :"+byName.getContactNo());
		System.out.println("RESERVATION_DATE :"+byName.getReservationDate());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}catch(ReservationNotFoundException e) {
			System.out.println(e.getMessage());
			}
		break;
		
	case 3:
		ArrayList<Hotel> allReservation = controller.getAllReservation();
		for(Hotel h:allReservation) {
			System.out.println("GUEST_NAME :"+h.getGuestName());
			System.out.println("ROOM_NO :"+h.getContactNo());
			System.out.println("CONTACT_NO :"+h.getContactNo());
			System.out.println("RESERVATION_DATE :"+h.getReservationDate());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
		}
			break;
		
	case 4:
		System.out.println("Enter ReservationID to update: ");
		int rid=sc.nextInt();
		sc.nextLine();

		System.out.println("Enter New Guest-Name :");
		String rname=sc.nextLine();
		System.out.println("Enter New Room-No :");
		int rroomNo=sc.nextInt();
		System.out.println("Enter New Contact No :");
		String rcn=sc.next();
		System.out.println("Enter New Reservation Date :");
		String rrd=sc.next();
		
		Hotel hotel1=new Hotel(rid,rname, rroomNo,rcn,rrd);
		hotel1.setReservationId(rid);
		hotel1.setGuestName(rname);
		hotel1.setRoomNo(rroomNo);
		hotel1.setContactNo(rcn);
		hotel1.setReservationDate(rrd);
		controller.update(hotel1);
		System.err.println("RESERVATION UPDATED SUCCESSFULLY...");
		break;
		
	case 5:
		System.out.println("Enter RoomID to delete: ");
		int roomid=sc.nextInt();
		String delete = controller.delete(roomid);
		System.err.println(delete);
		
	case 6:
		System.out.println("THANK YOU");
		break;
		
	
	default:System.out.println("INVALID CHOICE...");
	}

	}while(choice!=6);

	
	
	
	
	
	
	//without using case choice//
//	Hotel hotel=new Hotel("Hardik Pandya",117,"7855778189","2026-06-16");
//	
//	String r =controller.addReservation(hotel);
//	System.out.println(r);

	
	
//	ArrayList<Hotel> allReservation = controller.getAllReservation();
//	for(Hotel h:allReservation) {
//		System.out.println("GUEST_NAME :"+h.getGuestName());
//		System.out.println("ROOM_NO :"+h.getContactNo());
//		System.out.println("CONTACT_NO :"+h.getContactNo());
//		System.out.println("RESERVATION_DATE :"+h.getReservationDate());
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		System.out.println();
//
//	}

//	try {
//	Hotel byName = controller.getByName("Rahul Sharma");
//	System.out.println("GUEST_NAME :"+byName.getGuestName());
//	System.out.println("ROOM_NO :"+byName.getContactNo());
//	System.out.println("CONTACT_NO :"+byName.getContactNo());
//	System.out.println("RESERVATION_DATE :"+byName.getReservationDate());
//	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
//	}catch(ReservationNotFoundException e) {
//		System.out.println(e.getMessage());
//		}
	
	
//	Hotel hotel=new Hotel("Harbhajan",111,"78955525557","2026-06-19");
//	hotel.setReservationId(1);
//	String update = controller.update(hotel);
//	System.out.println(update);
//	
	
	
//	
//	String delete = controller.delete(117);
//	System.out.println(delete);
//	
	
	
	
	}
}
