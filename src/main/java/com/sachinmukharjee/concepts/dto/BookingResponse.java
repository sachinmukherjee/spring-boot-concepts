package com.sachinmukharjee.concepts.dto;

import java.util.Date;
import java.util.UUID;

public record BookingResponse(String id, String customerId, String itemId) {
}