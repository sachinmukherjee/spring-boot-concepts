package com.sachinmukharjee.concepts.controller;

import com.sachinmukharjee.concepts.dto.BookingResponse;
import com.sachinmukharjee.concepts.dto.CreateBookingRequest;
import com.sachinmukharjee.concepts.service.IBookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/bookings")
@AllArgsConstructor
public class BookingController {

    private final IBookingService bookingService;

    public ResponseEntity<BookingResponse> createBooking(@RequestBody CreateBookingRequest bookingRequest){
        return ResponseEntity.ok(bookingService.createBooking(bookingRequest));
    }
}
