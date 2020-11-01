package com.Maersk.container.service;

import com.Maersk.container.model.Container;

public interface ContainerService  {
     public int getAvailableContainers();
     void save(Container container);
}
