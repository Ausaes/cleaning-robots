/*
 * This source file was generated by the Gradle 'init' task
 */

import infrastructure.InputProcessor;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {

            new InputProcessor(new Scanner(System.in)).process();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
