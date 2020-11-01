package com.Maersk.container.dao;

import com.Maersk.container.model.Booking;
import com.Maersk.container.model.ContainerBookingId;

public interface BookingDao {
    ContainerBookingId saveBooking(Booking booking);
}
