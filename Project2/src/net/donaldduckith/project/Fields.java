package net.donaldduckith.project;

import com.google.gson.*;
import com.google.gson.reflect.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.net.*;
import org.junit.*;

public class Fields extends Main {

    int postId;
    public static int getPostId() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a postId.");
//        int input = scanner.nextInt();

        try {
            String inline = "";

            URL url = new URL("https://jsonplaceholder.typicode.com/comments");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();
            System.out.println(responsecode);
            System.out.println(conn.getContent());

            Scanner sc = new Scanner(url.openStream());
            while(sc.hasNext()) {
                inline+=sc.nextLine();
            }
            sc.close();

            Gson gson = new Gson();
            JsonParser parser = new JsonParser();


//            System.out.println(outputList);

            Type postListType = new TypeToken<ArrayList<Fields>>(){}.getType();
            List<Fields> outputList = gson.fromJson(inline, postListType);
//            ArrayList<Fields> postArray = gson.fromJson(root, postListType);
//            System.out.println(postListType);

            for (Fields post : outputList) {
//                System.out.println(post);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}
