package com.hasanatasoy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class HtmlContainerService {

    ObjectMapper objectMapper = new ObjectMapper();

    public String convertDataToJson(List<String> data){
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
