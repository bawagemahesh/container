package com.Maersk.container.service;

import com.Maersk.container.dao.CassandraContainerStorage;
import com.Maersk.container.model.Container;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

class ContainerServiceImpl implements ContainerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContainerServiceImpl.class);

    @Autowired
    CassandraContainerStorage cassandraContainerStorage;

    @Override
    public int getAvailableContainers() {
        final String uri = "https://maersk.com/api/bookings/checkAvailable";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        String size = null;
        try {
            JSONObject objJsonObject = new JSONObject(result);
            size = objJsonObject.getString("status");
        } catch (JSONException e) {
            LOGGER.error("Unable to parse Json response ", e);
        }
        return Integer.valueOf(size);
    }

    @Override
    public void save(Container container) {
        cassandraContainerStorage.saveContainer(container);
    }


}