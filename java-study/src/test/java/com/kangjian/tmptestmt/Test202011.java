package com.kangjian.tmptestmt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kangjian.commons.TestJson;
import jdk.internal.org.objectweb.asm.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;

@Slf4j
public class Test202011 {

    @SneakyThrows
    @Test
    public void testJsonString() {
        ObjectMapper mapper = new ObjectMapper();
        String       s      = mapper.writeValueAsString(new TestJson());
        log.info(s);
    }

    @Test
    public void customDateFormat() throws IOException {
        String       json         = " {\"age\":1,\"name\":\"kj\"}";
        System.out.println(json);
        ObjectMapper objectMapper = new ObjectMapper();
        TestJson     testJson     = objectMapper.readValue(json, TestJson.class);
        System.out.println(testJson.toString());
    }


    @Test
    public void testToJson() throws Exception {
        String       json         = "{\"name\": \"{\\\"age\\\":1,\\\"name\\\":\\\"kj\\\"}\", \"age\": 12}";
        System.out.println(json);
        ObjectMapper JACKSON_MAPPER = new ObjectMapper();
        // 1. 忽略不识别对象
        JACKSON_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 2.\n 解析
        JACKSON_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        // 3. 允许非双引号属性标记
        JACKSON_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 4. 允许单引号来包住属性名称和字符串值
        JACKSON_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 5. NAN 作为合法浮点数
        JACKSON_MAPPER.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
        // 6. 使用bigdecimal 序列化float
        JACKSON_MAPPER.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);

        JACKSON_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        JACKSON_MAPPER.setDateFormat(format);
        TestJson     testJson     = JACKSON_MAPPER.readValue(json, TestJson.class);
        System.out.println(testJson.toString());
        System.out.println(JACKSON_MAPPER.writeValueAsString(testJson));


        TestJson     testJson1     = JACKSON_MAPPER.readValue(JACKSON_MAPPER.writeValueAsString(testJson), TestJson.class);
        System.out.println(testJson1.toString());
    }

    @Test
    public void testJson() {
        String  s  = "{\n" +
                "    \"appkey\": \"com.sankuai.inf.hulk.robotserver\",\n" +
                "    \"env\": \"dev\",\n" +
                "    \"imageType\": 0,\n" +
                "    \"secondImageType\": 1,\n" +
                "    \"sendMsg\": true,\n" +
                "    \"groupName\": \"beijing\",\n" +
                "    \"cell\": \"hulk-strategy-test\",\n" +
                "    \"swimlane\": null,\n" +
                "    \"groupScaleRecordId\": 8,\n" +
                "    \"quota\": 30,\n" +
                "    \"achieveQuota\": false,\n" +
                "    \"actionId\": \"4d89fea6-870e-4518-853b-5f3fa39a7bfd\",\n" +
                "    \"expectNum\": 1,\n" +
                "    \"actualScaleNum\": 0,\n" +
                "    \"machineList\": \"set-xr-hulk-hulk-robotserver-dev32\",\n" +
                "    \"completedTime\": 1596806538000,\n" +
                "    \"image\": \"registry-hulk.sankuai.com/plus_dev/com.sankuai.inf.hulk.robotserver:74d6d7e_1594644387374\",\n" +
                "    \"reason\": \"定时策略触发\",\n" +
                "    \"failReason\": {\n" +
                "        \"xr\": \"物理机资源不足\"\n" +
                "    },\n" +
                "    \"scheduleInfo\": {\n" +
                "        \"xr\": 3001\n" +
                "    }\n" +
                "}";
        System.out.println(s);
    }


}
