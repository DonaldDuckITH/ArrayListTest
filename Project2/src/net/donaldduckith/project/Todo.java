package net.donaldduckith.project;

public class Todo {
    public static int userId;
    public static int num;
    public static String title;
    public static boolean comp;

    public static void getTodo(int user, int id, String name, boolean completed) {
        userId = user;
        num = id;
        title = name;
        comp = completed;
    }
}
