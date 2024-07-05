package com.yourname.calculator;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter operation (+, -, *, /, ! for factorial, pow, sqrt, log, log10, sin, cos, tan, perm) or 'exit' to quit:");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }

            if (operation.equals("!")) {
                System.out.println("Enter a number:");
                int num = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Result: " + factorial(num));
            } else if (operation.equals("pow")) {
                System.out.println("Enter base:");
                double base = scanner.nextDouble();
                System.out.println("Enter exponent:");
                double exponent = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                System.out.println("Result: " + power(base, exponent));
            } else if (operation.equals("sqrt") || operation.equals("log") || operation.equals("log10")
                    || operation.equals("sin") || operation.equals("cos") || operation.equals("tan")) {
                System.out.println("Enter number:");
                double num = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                switch (operation.toLowerCase()) {
                    case "sqrt":
                        System.out.println("Result: " + sqrt(num));
                        break;
                    case "log":
                        System.out.println("Result: " + log(num));
                        break;
                    case "log10":
                        System.out.println("Result: " + log10(num));
                        break;
                    case "sin":
                        System.out.println("Result: " + sin(num));
                        break;
                    case "cos":
                        System.out.println("Result: " + cos(num));
                        break;
                    case "tan":
                        System.out.println("Result: " + tan(num));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            } else if (operation.equals("perm")) {
                // Permutations calculation
                System.out.println("Enter total number of items:");
                int totalItems = scanner.nextInt();
                System.out.println("Enter number of items to select:");
                int selectedItems = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                try {
                    long result = permutationsRecursive(totalItems, selectedItems);
                    System.out.println("Permutations: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Enter two numbers:");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                scanner.nextLine(); // Consume newline
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
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            }
        }

        scanner.close();
    }

    public static long factorial(int num) {
        if (num < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        return factorialHelper(num, num);
    }

    private static long factorialHelper(int originalNum, int num) {
        if (num <= 1) {
            System.out.print("\rCalculating factorial: 100%");
            return 1;
        }

        int progress = (int) (((originalNum - num + 1) / (double) originalNum) * 100);
        System.out.print("\rCalculating factorial: " + progress + "%");
        return num * factorialHelper(originalNum, num - 1);
    }

    public static long permutationsRecursive(int totalItems, int selectedItems) {
        // Error handling for invalid inputs
        if (selectedItems < 0 || selectedItems > totalItems || selectedItems > 100) {
            throw new IllegalArgumentException("Invalid number of selected items.");
        }
        
        // Base case
        if (selectedItems == 0) {
            return 1;
        }
        
        // Recursive calculation
        return totalItems * permutationsRecursive(totalItems - 1, selectedItems - 1);
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double sqrt(double number) {
        return Math.sqrt(number);
    }

    public static double log(double number) {
        return Math.log(number);
    }

    public static double log10(double number) {
        return Math.log10(number);
    }

    public static double sin(double angleDegrees) {
        double angleRadians = Math.toRadians(angleDegrees);
        return Math.sin(angleRadians);
    }

    public static double cos(double angleDegrees) {
        double angleRadians = Math.toRadians(angleDegrees);
        return Math.cos(angleRadians);
    }

    public static double tan(double angleDegrees) {
        double angleRadians = Math.toRadians(angleDegrees);
        return Math.tan(angleRadians);
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
}
