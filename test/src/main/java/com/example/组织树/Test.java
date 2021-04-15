package com.example.组织树;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: test
 * @description:
 * @author: JJH
 * @create: 2021-04-15 12:54
 **/
public class Test {


    public static void main(String[] args) {
        String s = "[\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"name\": \"中国\",\n" +
                "      \"code\": \"110\",\n" +
                "      \"parent\": \"\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2\",\n" +
                "      \"name\": \"北京市\",\n" +
                "      \"code\": \"110000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"3\",\n" +
                "      \"name\": \"河北省\",\n" +
                "      \"code\": \"130000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"4\",\n" +
                "      \"name\": \"四川省\",\n" +
                "      \"code\": \"510000\",\n" +
                "      \"parent\": \"110\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"5\",\n" +
                "      \"name\": \"石家庄市\",\n" +
                "      \"code\": \"130001\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"6\",\n" +
                "      \"name\": \"唐山市\",\n" +
                "      \"code\": \"130002\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"7\",\n" +
                "      \"name\": \"邢台市\",\n" +
                "      \"code\": \"130003\",\n" +
                "      \"parent\": \"130000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"8\",\n" +
                "      \"name\": \"成都市\",\n" +
                "      \"code\": \"510001\",\n" +
                "      \"parent\": \"510000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"9\",\n" +
                "      \"name\": \"简阳市\",\n" +
                "      \"code\": \"510002\",\n" +
                "      \"parent\": \"510000\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"10\",\n" +
                "      \"name\": \"武侯区\",\n" +
                "      \"code\": \"51000101\",\n" +
                "      \"parent\": \"510001\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"11\",\n" +
                "      \"name\": \"金牛区\",\n" +
                "      \"code\": \"51000102\",\n" +
                "      \"parent\": \"510001\"\n" +
                "    }\n" +
                "  ]";


        List<JsonRootBean> jsonRootBeans = JSON.parseArray(s, JsonRootBean.class);
        JsonRootBean root = null;
        for (JsonRootBean json : jsonRootBeans) {
            String parent = json.getParent();
            if ("".equals(parent)) {
                root = json;
                break;
            }
        }
        JsonRootBean jsonRootBean = rootBean(jsonRootBeans, root);
        System.out.println(JSON.toJSONString(jsonRootBean));

    }


    public static JsonRootBean rootBean(List<JsonRootBean> jsonRootBeans, JsonRootBean temp) {
        String code = temp.getCode();
        jsonRootBeans.forEach(jsonRootBean -> {
            if (jsonRootBean.getParent().equals(code)) {
                temp.getChildren().add(rootBean(jsonRootBeans, jsonRootBean));
            }
        });
        return temp;
    }


}


@Data
class JsonRootBean {
    private String id;
    private String name;
    private String code;
    private String parent;
    private List<JsonRootBean> children = new ArrayList<>();
}
