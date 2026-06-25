package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entity.Hotel;
import com.util.JdbcConnection;

public class HotelDao {
	
	static Connection connection=JdbcConnection.createConnection();
	
	public String addReservation(Hotel hotel ) {
		try {
			PreparedStatement pst = connection.prepareStatement("insert into reservation values(?,?,?,?,?)");
			pst.setInt(1, hotel.getReservationId());
			pst.setString(2,hotel.getGuestName());
			pst.setInt(3, hotel.getRoomNo());
			pst.setString(4,hotel.getContactNo());
			pst.setString(5,hotel.getReservationDate());
			pst.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "Reservation Added Successfully";
	}

	
	//to get data from db//
	public ArrayList<Hotel> getAllReservation() {
		ArrayList<Hotel> hotel=new ArrayList<Hotel>();
		try {
			PreparedStatement pst = connection.prepareStatement("select * from reservation");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int int1 = rs.getInt("reservationId");
				String string = rs.getString("guestName");
				int int2 = rs.getInt("roomNo");
				String string2 = rs.getString("contactNo");
				String string3 = rs.getString("reservationDate");
				
				Hotel hotel1 =new Hotel( string, int2, string2, string3);
				hotel.add(hotel1);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return hotel;
	}
	
	
	//get reservation by name//
	public Hotel getByName(String guestName) {
		Hotel hotel=null;
		try {
			PreparedStatement pst = connection.prepareStatement("select * from reservation where guestName=?");
			pst.setString(1, guestName);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String string = rs.getString("guestName");
				int int2 = rs.getInt("roomNo");
				String string2 = rs.getString("contactNo");
				String string3 = rs.getString("reservationDate");
				
			 hotel =new Hotel( string, int2, string2, string3);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return hotel;
	}
	
	
	//update Reservation//
	public String update(Hotel hotel) {
		try {
			PreparedStatement pst = connection.prepareStatement("update reservation set guestName=?,roomNo=?,contactNo=?,reservationDate=? where reservationId=?");
			pst.setString(1,hotel.getGuestName());
			pst.setInt(2,hotel.getRoomNo());
			pst.setString(3,hotel.getContactNo());
			pst.setString(4,hotel.getReservationDate());
			pst.setInt(5,hotel.getReservationId());

			pst.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "RESERVATION UPDATED SUCCESSFULLY";
	}
	
	
	//delete//
	public String delete(int roomNo) {
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("delete from reservation where roomNo=?");
			pst.setInt(1, roomNo);
			pst.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "RESERVATION DELETED SUCCESSFULLY";
	}


	}

