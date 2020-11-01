package com.Maersk.container.model;

import com.datastax.driver.mapping.annotations.Column;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.EmbeddedId;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Table("bookings")
public class Booking implements Serializable {

    @PrimaryKey
    @EmbeddedId
    ContainerBookingId containerBookingId;

    @Pattern(regexp = "10|20")
    int containerSize;

    @Size(min = 5, max = 20)
    String origin;

    @Size(min = 5, max = 20)
    String destination;

    @Size(min = 1, max = 100)
    int quantity;

    ContainerType containerType;

    String timestamp;

    @Column(name = "container_booking_id")
    public ContainerBookingId getContainerBookingId() {
        return containerBookingId;
    }
    public void setContainerBookingId(ContainerBookingId containerBookingId) {
        this.containerBookingId = containerBookingId;
    }

    @Column(name = "container_size")
    public int getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(int containerSize) {
        this.containerSize = containerSize;
    }

    @Column(name = "origin")
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Column(name = "destination")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "container_type")
    public ContainerType getContainerType() {
        return containerType;
    }
    public void setContainerType(ContainerType containerType) {
        this.containerType = containerType;
    }

    @Column(name = "timestamp")
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
