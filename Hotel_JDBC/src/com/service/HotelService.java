package com.service;

import java.util.ArrayList;

import com.dao.HotelDao;
import com.entity.Hotel;
import com.exception.ReservationNotFoundException;

public class HotelService {

	HotelDao dao=new HotelDao();
	
	public String addReservation(Hotel hotel) {
		String r = dao.addReservation(hotel);
		
		return r;
		
	}
	
	public ArrayList<Hotel> getAllReservation() {
		ArrayList<Hotel> allReservation = dao.getAllReservation();
		return allReservation;
	}
	
	
	public Hotel getByName(String guestName) {
		Hotel byName = dao.getByName(guestName);
		if(byName!=null) {
		return byName;
		}
		else {
			throw new ReservationNotFoundException("RESERVATION NOT FOUND WITH GUEST-NAME :"+guestName);
		}
		}
	
	
	
	public String update(Hotel hotel) {
		String update = dao.update(hotel);
		return update;
	}
	
	
	public String delete(int roomId) {
		String delete = dao.delete(roomId);
		return delete;
	}
}
