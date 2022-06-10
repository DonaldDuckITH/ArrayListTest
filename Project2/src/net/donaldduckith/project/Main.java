package net.donaldduckith.project;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String sURL = "https://jsonplaceholder.typicode.com/posts/1/comments";

        try {
            URL url = new URL(sURL);
            URLConnection request = url.openConnection();
            request.connect();

            @Deprecated
            JsonParser jp = new JsonParser();
            @Deprecated
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonArray rootObj = root.getAsJsonArray();
            //System.out.println(rootObj.get());
            System.out.println(sURL);
            //System.out.println(rootObj);
            //System.out.println(rootObj.get(1));
            System.out.println("Size of JSONArray = " + rootObj.size());

            for (int i = 0; i < rootObj.size(); ++i) {
                JsonElement je = rootObj.get(i);
                System.out.println(je);

                for (String field : je.getAsJsonObject().keySet()) {
                    JsonObject jo = je.getAsJsonObject();
                    System.out.println(field + "=" + jo.get(field));
                }
            }

            Fields.getPostId();

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
