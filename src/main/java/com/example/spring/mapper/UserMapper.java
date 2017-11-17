package com.example.spring.mapper;

import com.example.spring.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class UserMapper extends ObjectMapper {
    public UserMapper() {
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 设置 SerializationFeature.FAIL_ON_EMPTY_BEANS 为 falsess
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }
}
