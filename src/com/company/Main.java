package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Welcome to Calculator!
                Instruction for using: e.g 'num1 'math action' 'num2.
                List of math actions: '+'=+, '-'=-, '*'=*, '/'=/, '√'=√, '^'=^, 'cos'=c, 'sin'=s, 'tan'=t, 'log'=l, 'arcCos'=ac, 'arcSin'=as, 'arcTan'=at.
                For exit type 'exit'.
                """);
        do {
            System.out.println('\n' + "Input your statement");
            System.out.println(new Main().calculation(scanner.nextLine()));
        } while (true);

    }

    /**
     * function for universal calculation for almost all actions
     * @param task your statement that need to be calculated
     * @return your result
     */
    public String calculation(String task) {
        if (task.strip().equalsIgnoreCase("exit")) {
            System.out.println("Thanks for using!");
            System.exit(2);

        } else {
            String[] operands = task.strip().toLowerCase().split(" ");
            switch (operands.length) {
                case 2 -> {
                    List<Character> action = new ArrayList<>();
                    action.add(operands[1].charAt(0));
                    double operand1;
                    try {
                        operand1 = Double.parseDouble(operands[0]);
                    } catch (Exception e) {
                        return "Incorect num1";
                    }
                    try {
                        action.add(operands[1].charAt(1));
                    } catch (Exception ignored) {
                    }
                    switch (action.size()) {
                        case 2:
                            //noinspection UnnecessaryCallToStringValueOf casting from int to char
                            String actionS = Character.toString(action.get(0)) + Character.toString(action.get(1));
                            switch (actionS) {
                                case "ac":
                                    if (operand1 >= -1 && operand1 < 1) {
                                        return '\n' + "result is:" + Math.acos(operand1);
                                    } else
                                        return '\n' + "Incorect num1 value for arc function(must be:  -1<=num1>=1)Try again";

                                case "as":
                                    if (operand1 >= -1 && operand1 < 1) {
                                        return '\n' + "result is:" + Math.asin(operand1);
                                    } else
                                        return '\n' + "Incorect num1 value for arc function(must be:  -1<=num1>=1)Try again";

                                case "at":
                                    return '\n' + "result is:" + Math.atan(operand1);

                                default:
                                    return '\n' + "Incorrect math action!Try again";
                            }
                        case 1:
                            return switch (action.get(0)) {
                                case '√' -> '\n' + "result is:" + Math.sqrt(operand1);
                                case 'c' -> '\n' + "result is:" + Math.cos(operand1);
                                case 's' -> '\n' + "result is:" + Math.sin(operand1);
                                case 't' -> '\n' + "result is:" + Math.tan(operand1);
                                case 'l' -> '\n' + "result is:" + Math.log(operand1);
                                default -> '\n' + "Incorrect math action!Try again";
                            };


                    }

                }
                case 3 -> {
                    Double operand1;
                    Double operand2;
                    try {
                        operand1 = Double.parseDouble(operands[0]);
                    } catch (Exception e) {
                        return "Incorect num1";
                    }
                    try {
                        operand2 = Double.parseDouble(operands[2]);
                    } catch (Exception e) {
                        return "Incorect num2";
                    }
                    switch (operands[1].charAt(0)) {
                        case '+':
                            return "result is:" + (operand1 + operand2);

                        case '-':
                            return "result is:" + (operand1 - operand2);

                        case '*':
                            return "result is:" + (operand1 * operand2);

                        case '/':
                            if (operand2 == 0) {
                                return "Error: division by 0";
                            } else {
                                return "result is:" + (operand1 / operand2);
                            }
                        case '^':
                            return "result is:" + (Math.pow(operand1, operand2));

                        default:
                            return "Incorrect math action!Try again";

                    }

                }

            }
        }

        return "Incorect statement";
    }
}