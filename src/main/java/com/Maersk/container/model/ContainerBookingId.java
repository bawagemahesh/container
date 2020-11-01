package com.Maersk.container.model;


import javax.persistence.*;

@SequenceGenerator(name="tab", initialValue=957000001)
public class ContainerBookingId {

    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
    @Id long bookingRef;

}
