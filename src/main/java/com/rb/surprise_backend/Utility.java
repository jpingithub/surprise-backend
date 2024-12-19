package com.rb.surprise_backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class Utility {
    private final static ObjectMapper objectMapper = new ObjectMapper();
    public static Wish toWish(WishDTO dto){
        return objectMapper.convertValue(dto,Wish.class);
    }
}
