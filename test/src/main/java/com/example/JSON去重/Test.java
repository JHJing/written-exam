package com.example.JSON去重;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;
import java.util.TreeSet;

/**
 * @program: test
 * @description:
 * @author: JJH
 * @create: 2021-04-15 12:49
 **/
public class Test {

    public static void main(String[] args) {
        String a = "[{\n" +
                "    \"name\": \"张三\",\n" +
                "    \"serial\": \"0001\"\n" +
                "  }, {\n" +
                "    \"name\": \"李四\",\n" +
                "    \"serial\": \"0002\"\n" +
                "  }, {\n" +
                "    \"name\": \"王五\",\n" +
                "    \"serial\": \"0003\"\n" +
                "  }, {\n" +
                "    \"name\": \"王五2\",\n" +
                "    \"serial\": \"0003\"\n" +
                "  }, {\n" +
                "    \"name\": \"赵四\",\n" +
                "    \"serial\": \"0004\"\n" +
                "  }, {\n" +
                "    \"name\": \"小明\",\n" +
                "    \"serial\": \"005\"\n" +
                "  }, {\n" +
                "    \"name\": \"小张\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"小李\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"小李2\",\n" +
                "    \"serial\": \"006\"\n" +
                "  }, {\n" +
                "    \"name\": \"赵四2\",\n" +
                "    \"serial\": \"0004\"\n" +
                "  }]";


        List<Serial> serials = JSON.parseArray(a, Serial.class);
        System.out.println(JSON.toJSONString(new TreeSet<>(serials)));

    }


}


@Data
class Serial implements Comparable {
    private String name;
    private String serial;

    @Override
    public int compareTo(Object o) {
        Serial s = (Serial) o;
        return this.getSerial().equals(s.getSerial()) ? 0 : 1;
    }
}