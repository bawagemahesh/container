package com.Maersk.container.model;
import lombok.Data;

@Data
public class ContainerAvailabilty {

    private boolean available;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
