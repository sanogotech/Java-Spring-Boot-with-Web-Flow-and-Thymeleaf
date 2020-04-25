package com.example.demo.repository;

import java.util.List;
import com.example.demo.models.Booking;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;


/**
 * A service interface for retrieving hotels and bookings from a backing repository. Also supports the ability to cancel
 * a booking.
 */
@Repository
public interface BookingRepository  extends  JpaRepository<Booking, Long>  {

    /**
     * Find bookings made by the given user
     * @param username the user's name
     * @return their bookings
     */
    List<Booking> findByUser_username(String username);


}
