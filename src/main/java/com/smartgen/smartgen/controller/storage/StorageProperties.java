package com.smartgen.smartgen.controller.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "storage")
public class StorageProperties {

    private String location="./src/main/resources/static/uploads";

    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
		
}