package me.noip.helloworld;

public class HelloWorld {
    public static void main(String[] args) {
        if (args.length != 0) {
            System.out.println(hello(args[0]));
        } else {
            System.out.println(hello("stranger"));
        }
    }

    public static String hello(String name) {
        return "Hello " + name + "!";
    }
}
