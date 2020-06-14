package com.kangjian.util;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDiffTest {

    @Test
    public void jsonDiffTest(){
        String json1 = "";
        String json2 = "";
        ObjectMapper mapper = new ObjectMapper();
        Json1Bean json1Bean = new Json1Bean();
        Json2Bean json2Bean = new Json2Bean();

        try {
           json1 = mapper.writeValueAsString(json1Bean);
           json2 = mapper.writeValueAsString(json2Bean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        int ans = JsonDiff.diff(json1, json2);
        System.out.println(ans);
    }

}
