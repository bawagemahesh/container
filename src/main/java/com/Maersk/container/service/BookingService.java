package com.Maersk.container.service;

import com.Maersk.container.model.Booking;
import com.Maersk.container.model.Container;
import com.Maersk.container.model.ContainerBookingId;

public interface BookingService {
     ContainerBookingId save(Booking booking);
}
