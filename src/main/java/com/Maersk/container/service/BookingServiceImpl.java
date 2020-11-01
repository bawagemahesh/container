package com.Maersk.container.service;

import com.Maersk.container.dao.CassandraContainerStorage;
import com.Maersk.container.model.Booking;
import com.Maersk.container.model.Container;
import com.Maersk.container.model.ContainerBookingId;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

class BookingServiceImpl implements BookingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);

    @Autowired
    CassandraContainerStorage cassandraContainerStorage;

    @Override
    public ContainerBookingId save(Booking booking) {
        ContainerBookingId containerBookingId= new ContainerBookingId();
        try {
            containerBookingId =  cassandraContainerStorage.saveBooking(booking);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Sorry there was a problem processing your request", e);
        }
        return  containerBookingId;
    }


}