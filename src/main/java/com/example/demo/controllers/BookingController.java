package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Booking;
import com.example.demo.models.Hotel;
import com.example.demo.models.SearchCriteria;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;

import java.security.Principal;
import java.util.*;


@Controller
public class BookingController {


	
	@Autowired
	BookingService bookingService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/searchhotel")
	public String searchHotel(Model model, Principal currentUser) {
		
		List<Booking> booking = new ArrayList<Booking>();
        if (currentUser != null) {
			model.addAttribute("message", "Hello, Booking!");
			String username=currentUser.getName();
			booking	= bookingService.findBookings(username);
		
			
			model.addAttribute(booking);
		}else{
			model.addAttribute("message", "Hello, world!");
			model.addAttribute(booking);
        }

		return "searchhotel";
    }
	
	
	@GetMapping("/findhotels")
	public String findhotelslist(SearchCriteria criteria, Model model) {
		List<Hotel> hotellist = bookingService.findHotels(criteria);
		model.addAttribute("hotellist",hotellist);
		//TODO
		String urlhotelview ="hotels/" ;
		for (Hotel hotel : hotellist) {
			System.out.println("**** Hotel  Name = " +hotel.getName());
			System.out.println("Hotel  Adress = " +hotel.getAddress());
			System.out.println("Hotel  City = " +hotel.getCity());
			
		}
		return "hotelslist";
	}

	@GetMapping("/hotels/{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute(bookingService.findHotelById(id));
		return "hotelshow";
	}

	@DeleteMapping("/bookings/{id}")
	public String deleteBooking(@PathVariable Long id) {
		bookingService.cancelBooking(id);;
		return "redirect:../searchhotel";
	}
    

}