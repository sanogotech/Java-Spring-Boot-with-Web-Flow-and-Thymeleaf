
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

 
@Repository
public  interface UserRepository extends JpaRepository<User, String> {



    /*
    @Query("SELECT t FROM Todo t where t.title = :title AND t.description = :description")
    public Optional<Todo> findByTitleAndDescription(@Param("title") String title, 
                                                    @Param("description") String description);

    */

    /*
    @Async
    @Query("SELECT t.title FROM Todo t where t.id = :id") 
    Future<Optional<String>> findTitleById(@Param("id") Long id);
    */







}