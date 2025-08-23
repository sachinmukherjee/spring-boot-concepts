package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.BookingResponse;
import com.sachinmukharjee.concepts.dto.CreateBookingRequest;
import com.sachinmukharjee.concepts.dto.UuidResponse;
import com.sachinmukharjee.concepts.entity.Bookings;
import com.sachinmukharjee.concepts.exception.APIException;
import com.sachinmukharjee.concepts.repository.IBookingRepository;
import com.sachinmukharjee.concepts.service.client.HttpBinAPi;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class BookingService implements IBookingService {

  private final HttpBinAPi httpBinAPi;
  private final IBookingRepository bookingRepository;

  @Override
  public BookingResponse createBooking(CreateBookingRequest bookingRequest) {
    UuidResponse bookingId = null;
    try {
      bookingId = httpBinAPi.getBookingId();
    } catch (Exception e) {
      throw new APIException("Error while generaing UUID");
    }

    Bookings booking =
        new Bookings(
            bookingId.getUuid().toString(),
            bookingRequest.itemId().toString(),
            bookingRequest.customerId().toString());

    bookingRepository.save(booking);

    return new BookingResponse(booking.getId(), booking.getItemId(), booking.getCustomerId());
  }
}
