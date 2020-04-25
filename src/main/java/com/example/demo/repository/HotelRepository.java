
package com.example.demo.repository;

import java.util.List;
import com.example.demo.models.Hotel;
import com.example.demo.models.SearchCriteria;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public  interface HotelRepository extends  JpaRepository<Hotel, Long> {
	
	
	/**
     * Find hotels by their identifier.
     * @param id the hotel id
     * @return the hotel
     */
    public Optional<Hotel> findById(Long id);

    /**
     * Find hotels available for booking by some criteria.
     * @param criteria the search criteria
     * @return a list of hotels meeting the criteria
     */
    @Query("select h from Hotel h where lower(h.name) like :pattern or lower(h.city) like :pattern "
					+ " or lower(h.zip) like :pattern or lower(h.address) like :pattern")
    public List<Hotel> retrieveHotelsBySearchCriteria(@Param("pattern") String pattern);
 

     /**
     *Manual Custom Queries
    @Query("SELECT f FROM Foo f WHERE LOWER(f.name) = LOWER(:name)")
    Foo retrieveByName(@Param("name") String name);
    **/

 



}