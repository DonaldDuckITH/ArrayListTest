package net.donaldduckith.project;

import com.google.gson.*;
import com.google.gson.reflect.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.net.*;

public class Fields extends Main {
        public static int getPostId() {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a postId.");
            int input = scanner.nextInt();

            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/comments");
                URLConnection request = url.openConnection();
                request.connect();
                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

                Gson gson = new Gson();
                Type postListType = new TypeToken<ArrayList<Fields>>() {}.getType();
                ArrayList<Fields> postArray = gson.fromJson(root, postListType);

                for (Fields post : postArray) {
                    System.out.println(post);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return input;
        }
}
