package com.sachinmukharjee.concepts.dto;

import java.util.Date;
import java.util.UUID;

public record CreateBookingRequest(UUID customerId, UUID itemId) {}
