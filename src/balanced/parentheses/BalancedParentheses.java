/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balanced.parentheses;

import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.File;// Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;

/**
 *
 * @author Escola
 */
public class BalancedParentheses {

    /**
     * @param args the command line arguments
     */
    public static String validarLinha(String x) {
        Stack stack = new Stack();

        for (Character input : x.toCharArray()) {
            switch (input) {
                case '[':
                    stack.push(input);
                    break;
                case '{':
                    stack.push(input);
                    break;
                case '(':
                    stack.push(input);
                    break;
                case ')':
                    if (!stack.empty() && stack.peek().equals('(')) {
                        stack.pop();
                    } else {
                        return atribuirValidacao(x, false);
                    }
                    break;
                case ']':
                    if (!stack.empty() && stack.peek().equals('[')) {
                        stack.pop();
                    } else {
                        return atribuirValidacao(x, false);
                    }
                    break;
                case '}':
                    if (!stack.empty() && stack.peek().equals('{')) {
                        stack.pop();
                    } else {
                        return atribuirValidacao(x, false);
                    }
                    break;
                default:
                    break;
            }
        }

        return stack.empty() ? atribuirValidacao(x, true) : atribuirValidacao(x, false);
    }

    public static String atribuirValidacao(String x, Boolean a) {
        String txt;

        txt = a ? x + " - Válido\n" : x + " - Inválido\n";

        return txt;
    }

    public static void main(String[] args) {
        String txt = "";

        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                txt = txt + validarLinha(myReader.nextLine());
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred reading.");
            e.printStackTrace();
        }

        try {
            File myObj = new File("output.txt");
            myObj.createNewFile();
            FileWriter myWriter = new FileWriter("output.txt");
            myWriter.write(txt);
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred writing.");
            e.printStackTrace();
        }

    }
}
