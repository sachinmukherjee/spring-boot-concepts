package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.BookingResponse;
import com.sachinmukharjee.concepts.dto.CreateBookingRequest;

public interface IBookingService {

  BookingResponse createBooking(CreateBookingRequest bookingRequest);
}
