/**
 *  an util to diff  to json return 0-100 as percentage
 *  based on jackson
 */
package com.kangjian.util;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDiff {


    private static final ObjectMapper mapper = new ObjectMapper();
    /**
     *
     * @param json1 base json
     * @param json2 target json to diff
     * @return diff (ratio * 100)
     */
    public static int diff(String json1, String json2) {

        JsonNode json1rootNode = null;
        JsonNode json2rootNode = null;
        try {
            json1rootNode = mapper.readTree(json1);
            json2rootNode = mapper.readTree(json2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator it = json1rootNode.elements();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        return 0;
    }

    /**
     *
     * @param json1 base json
     * @param json2 target json to diff
     * @param key  target json key to diff
     * @return  diff (ratio * 100)
     */
    public static int diff(String json1, String json2, String key) {
        return 0;
    }

}
