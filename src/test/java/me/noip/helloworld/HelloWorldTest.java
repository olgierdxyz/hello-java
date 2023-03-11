package me.noip.helloworld;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /*
    @Test
    public void testMain() {
        String[] args = {"Alex"};
        HelloWorld.main(args);
        assertEquals("Hello Alex!".stripTrailing(), outContent.toString().stripTrailing());
    }
    */

    @Test
    public void testHello() {
        String name = "Fred";
        String expResult = "Hello Fred!";
        String result = HelloWorld.hello(name);
        assertEquals(expResult, result);
    }
}