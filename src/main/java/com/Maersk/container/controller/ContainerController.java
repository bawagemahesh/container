package com.Maersk.container.controller;

import com.Maersk.container.model.Booking;
import com.Maersk.container.model.Container;
import com.Maersk.container.model.ContainerAvailabilty;
import com.Maersk.container.model.ContainerBookingId;
import com.Maersk.container.service.BookingService;
import com.Maersk.container.service.ContainerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/bookings/")
@AllArgsConstructor
@RestController
public class ContainerController {

    @Autowired
    ContainerService containerService;

    @Autowired
    BookingService bookingService;

    @Autowired
    ContainerAvailabilty containerAvailabilty;

    @GetMapping
    public int getAvailable() {
        int space = containerService.getAvailableContainers();
        return space;
    }

    @PostMapping(path = "/containers", consumes = "application/json")
    public ContainerAvailabilty save(@RequestBody Container container) {
        containerService.save(container);
        if (getAvailable() == 0) {
            containerAvailabilty.setAvailable(true);
            return containerAvailabilty;
        } else {
            return containerAvailabilty;
        }
    }

    @PostMapping(path = "/bookings", consumes = "application/json")
    public ContainerBookingId book(@RequestBody Booking booking) {
        ContainerBookingId containerBookingId =    bookingService.save(booking);
       return  containerBookingId;
    }

}
