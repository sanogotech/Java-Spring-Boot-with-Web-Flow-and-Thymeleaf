package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Booking;
import com.example.demo.repository.BookingRepository;

import java.security.Principal;
import java.util.*;


@Controller
public class BookingController {

	@Autowired
	BookingRepository bookingRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/searchhotel")
	public String searchHotel(Model model, Principal currentUser) {
		
		List<Booking> booking = new ArrayList<Booking>();
        if (currentUser != null) {
			model.addAttribute("message", "Hello, Booking!");
			//TODO
			//booking	= bookingService.findBookings(currentUser.getName());
			model.addAttribute(booking);
		}else{
			model.addAttribute("message", "Hello, world!");
			model.addAttribute(booking);
        }

		return "searchhotel";
    }
    

}