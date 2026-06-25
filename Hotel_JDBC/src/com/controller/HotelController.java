package com.controller;

import java.util.ArrayList;

import com.entity.Hotel;
import com.service.HotelService;

public class HotelController {

	HotelService service=new HotelService();
	
	public String addReservation(Hotel hotel) {
		String r = service.addReservation(hotel);
		return r;
	}
	
	public ArrayList<Hotel>getAllReservation() {
		ArrayList<Hotel> allReservation = service.getAllReservation();
		return allReservation;
	}
	
	public Hotel getByName(String guestName){
		Hotel byName = service.getByName(guestName);
		return byName;
	}
	
	public String update(Hotel hotel) {
		String update = service.update(hotel);
		return update;
	}
	
	
	public String delete(int roomId)
	{
		String delete=service.delete(roomId);
		return delete;
	}
}
