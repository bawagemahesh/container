package com.Maersk.container.dao;

import com.Maersk.container.model.Booking;
import com.Maersk.container.model.Container;
import com.Maersk.container.model.ContainerBookingId;
import org.springframework.beans.factory.annotation.Autowired;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

import static com.datastax.driver.mapping.Mapper.Option.saveNullFields;

import javax.annotation.PostConstruct;

public class CassandraContainerStorage implements ContainerDao, BookingDao{

    @Autowired
    private MappingManager manager;

    private Mapper<Container> containerMapper;

    private Mapper<Booking> bookingMapper;

    @PostConstruct
    public void init() {
        containerMapper = manager.mapper(Container.class);
        bookingMapper = manager.mapper(Booking.class);
        bookingMapper.setDefaultSaveOptions(saveNullFields(false));
        containerMapper.setDefaultSaveOptions(saveNullFields(false));
    }

    @Override
    public void saveContainer(Container container) {
        containerMapper.save(container);
    }

    @Override
    public ContainerBookingId saveBooking(Booking booking) {
        ContainerBookingId containerBookingId= (ContainerBookingId) bookingMapper.saveAsync(booking);
        return containerBookingId;
    }
}


