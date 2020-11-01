package com.Maersk.container.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Table("Container")
public class Container implements Serializable {

    @Pattern(regexp = "10|20")
    int containerSize;

    @Size(min = 5, max = 20)
    String origin;

    @Size(min = 5, max = 20)
    String destination;

    @Size(min = 1, max = 100)
    int quantity;

    ContainerType containerType;

    public int getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(int containerSize) {
        this.containerSize = containerSize;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ContainerType getContainerType() {
        return containerType;
    }

    public void setContainerType(ContainerType containerType) {
        this.containerType = containerType;
    }
}
