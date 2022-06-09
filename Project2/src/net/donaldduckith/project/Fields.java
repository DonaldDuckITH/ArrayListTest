package net.donaldduckith.project;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class Fields extends Main {
    private int id;
    private String name;

    public Fields (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void givenListOfFields_whenSerializing_thenCorrect() {
        List<Fields> list = Arrays.asList(new Fields(1, "name1"), new Fields(2, "name2"));

        Gson gson = new Gson();
        String jsonString = list.toString();
        String expectedString = "[{\"id\":1,\"name\":\"name1\"},{\"id\":2,\"name\":\"name2\"}]";

    }
}
