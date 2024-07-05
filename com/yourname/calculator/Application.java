package com.yourname.calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        if (args.length == 0) {
            // Interactive mode
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter operation (+, -, *, /, ! for factorial) or 'exit' to quit:");
                String operation = scanner.nextLine();
                if (operation.equals("exit")) {
                    break;
                }
                handleOperation(operation, scanner);
            }
            scanner.close();
        } else {
            // CLI arguments mode
            handleCLIArgs(args);
        }
    }

    public static void handleOperation(String operation, Scanner scanner) {
        int a, b;
        switch (operation) {
            case "+":
                System.out.println("Enter two numbers:");
                a = scanner.nextInt();
                b = scanner.nextInt();
                System.out.println("Result: " + add(a, b));
                break;
            case "-":
                System.out.println("Enter two numbers:");
                a = scanner.nextInt();
                b = scanner.nextInt();
                System.out.println("Result: " + subtract(a, b));
                break;
            case "*":
                System.out.println("Enter two numbers:");
                a = scanner.nextInt();
                b = scanner.nextInt();
                System.out.println("Result: " + multiply(a, b));
                break;
            case "/":
                System.out.println("Enter two numbers:");
                a = scanner.nextInt();
                b = scanner.nextInt();
                try {
                    System.out.println("Result: " + divide(a, b));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "!":
                System.out.println("Enter a number:");
                a = scanner.nextInt();
                System.out.println("Result: " + factorial(a));
                break;
            default:
                System.out.println("Invalid operation");
        }
        scanner.nextLine(); // Clear the buffer
    }

    public static void handleCLIArgs(String[] args) {
        String operation = args[0];
        int a = Integer.parseInt(args[1]);
        int b = args.length > 2 ? Integer.parseInt(args[2]) : 0;

        switch (operation) {
            case "+":
                System.out.println("Result: " + add(a, b));
                break;
            case "-":
                System.out.println("Result: " + subtract(a, b));
                break;
            case "*":
                System.out.println("Result: " + multiply(a, b));
                break;
            case "/":
                try {
                    System.out.println("Result: " + divide(a, b));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "!":
                System.out.println("Result: " + factorial(a));
                break;
            default:
                System.out.println("Invalid operation");
        }
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return (double) a / b;
    }

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
