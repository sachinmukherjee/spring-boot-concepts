package com.sachinmukharjee.concepts.repository;

import com.sachinmukharjee.concepts.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookingRepository extends JpaRepository<Bookings,String> {}
