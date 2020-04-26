package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Booking;
import com.example.demo.models.Hotel;
import com.example.demo.models.SearchCriteria;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.HotelRepository;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public List<Booking> findBookings(String username) {
		List<Booking> booking =bookingRepository.findByUser_username(username);
		return booking;
	}

	@Override
	public List<Hotel> findHotels(SearchCriteria criteria) {
		String paramsearch = criteria.getSearchString();
		//TODO Pagination
		int page = criteria.getPage();
		int pagesize= criteria.getPageSize();
		List<Hotel> listhotels = hotelRepository.retrieveHotelsBySearchCriteria(paramsearch);
		System.out.println("----list hotel :"+ listhotels);
		return listhotels;
	}

	@Override
	public Hotel findHotelById(Long id) {

		return hotelRepository.findById(id).get();
	}

	@Override
	public Booking createBooking(Long hotelId, String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persistBooking(Booking booking) {
		bookingRepository.save(booking);

	}

	@Override
	public void cancelBooking(Long id) {
		bookingRepository.deleteById(id);

	}

}
