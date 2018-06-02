package com.keenpro;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tail {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;


    public static void main(String[] args) {
        try {

            Pattern p = Pattern.compile("[0-9]+");


            ArrayList<String> input = new ArrayList<>();
            ArrayList<String> inputFiles = new ArrayList<>();
            for (int i = 0; i < args.length; i++) {

                input.add(args[i]);
                Matcher m = p.matcher(args[i]);
                if (!m.matches() && !args[i].equals("tail") && !args.equals("-c") &&
                        !args.equals("-n") && !args.equals("-o") && args[i - 1] != "-o")
                    inputFiles.add(args[i]);
            }

            int c = 0;
            int n = 0;
            String ofile = "";
            if (input.contains("-o")) {
                ofile = input.get(input.indexOf("-o") + 1);
            }

            if (input.contains("-c") && input.contains("-n")) {
                out.print("-c and -n flags are used together");
            } else {

                if (input.contains("-c")) {
                    c = Integer.parseInt(input.get(input.indexOf("-c") + 1));
                } else if (input.contains("-n")) {
                    n = Integer.parseInt(input.get(input.indexOf("-n") + 1));
                }
            }

            if (!inputFiles.isEmpty()) {
                if (ofile != "") {
                    FileWriter fw = new FileWriter(ofile);
                    LinkedList<String> result = Func.action(input, inputFiles, c, n, false);
                    for (int i = 0; i < result.size(); i++) {
                        fw.write(result.get(i) + " ");
                    }
                    fw.close();

                } else {
                    LinkedList<String> result = Func.action(input, inputFiles, c, n, false);
                    for (int i = 0; i < result.size(); i++) {
                        out.println(result.get(i) + " ");
                    }

                }

            } else {

                LinkedList<String> text = new LinkedList<>();
                out.println("Please, enter your text here, after it please write \"-s\" in a new line");
                String temp = in.nextLine();
                while (temp != "-s") {
                    text.addLast(temp);
                    temp = in.nextLine();
                }

                if (ofile != "") {
                    FileWriter fw = new FileWriter(ofile);
                    LinkedList<String> result = Func.consoleAction(text, c, n);
                    for (int i = 0; i < result.size(); i++) {
                        fw.write(result.get(i) + " ");
                    }
                    fw.close();

                } else {
                    LinkedList<String> result = Func.consoleAction(text, c, n);
                    for (int i = 0; i < result.size(); i++) {
                        out.println(result.get(i) + " ");
                    }

                }
            }
        } catch (IOException e) {
            out.println("IOException has just been caught (FileWriter)");
        } catch (Exception e) {
            out.println("The action() method did smth wrong");
        }


    }
}
