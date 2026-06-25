package com.entity;

import java.util.Date;

public class Hotel {

	private int reservationId;
	private String guestName;
	private int roomNo;
	private String contactNo;
	private String reservationDate;
	
	public Hotel(String guestName, int roomNo, String contactNo, String reservationDate) {
		super();
		this.reservationId = reservationId;
		this.guestName = guestName;
		this.roomNo = roomNo;
		this.contactNo = contactNo;
		this.reservationDate = reservationDate;
	}
	public Hotel(int rid, String rname, int roomNo2, String name, String name2) {
		// TODO Auto-generated constructor stub
	}
	public int getReservationId() {
		return reservationId;
	}
	
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	
}