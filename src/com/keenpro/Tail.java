package com.keenpro;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tail {
    private static Scanner in = new Scanner(System.in);
    private static PrintStream out = System.out;


    public static void main(String[] args) {
        try {

            Pattern p = Pattern.compile("[0-9]+");


            List<String> input = new LinkedList<>();
            List<String> inputFiles = new ArrayList<>();
            for (int i = 0; i < args.length; i++) {

                input.add(args[i]);
                //Matcher m = p.matcher(args[i]);
                if (!(args[i].equals("-c")  && args[i - 1].equals("-c"))
                        && !(args[i].equals("-n")  && args[i - 1].equals("-n"))
                        && !(args[i].equals("-o") && args[i - 1].equals("-o")))
                    inputFiles.add(args[i]);
            }

            int c = 0;
            int n = 0;
            String ofile = "";
            if (input.contains("-o")) {
                ofile = input.get(input.indexOf("-o") + 1);
            }



            if (input.contains("-c") && input.contains("-n") ) {
                out.print("-c and -n flags are used together");
                System.exit(0);
            }
            else {


                if (input.contains("-c")) {
                    Matcher m = p.matcher(input.get(input.indexOf("-c") + 1));
                    if(!m.matches()) {
                        out.print("You should place a number after using -c flag");
                        System.exit(0);
                    }
                    c = Integer.parseInt(input.get(input.indexOf("-c") + 1));
                }

                else if (input.contains("-n")) {
                    Matcher m = p.matcher(input.get(input.indexOf("-n") + 1));
                    if(!m.matches()) {
                        out.print("You should place a number after using -n flag");
                        System.exit(0);
                    }
                    n = Integer.parseInt(input.get(input.indexOf("-n") + 1));
                }
            }

            if (!inputFiles.isEmpty()) {
                for (String element : inputFiles) {

                        out.print("Filename is " + element);

                        LinkedList<String> text = new LinkedList<>();

                        FileReader fr = new FileReader(element);
                        BufferedReader reader = new BufferedReader(fr);
                        String line;
                        while ((line = reader.readLine()) != null) {
                            text.addLast(line);
                        }
                        reader.close();



                    if (!ofile.equals("")) {
                        FileWriter fw = new FileWriter(ofile);
                        try {
                            LinkedList<String> result = Func.action(text, c, n);
                            if (result == null) {
                                out.print("No text found");
                                System.exit(0);
                            }
                            for (String tmp : result) {
                                fw.write(tmp);
                            }
                        } catch (IOException e) {
                            out.print("IOException has just been caught (FW)");
                        }

                        fw.close();

                    }
                    else {
                        LinkedList<String> result = Func.action(text, c, n);
                        if (result == null) {
                            out.print("No text found");
                            System.exit(0);
                        }
                        for (String tmp : result) {
                            out.println(tmp);
                        }
                    }

                }
            }
            else {

                LinkedList<String> text = new LinkedList<>();
                String temp = in.nextLine();
                while (in.hasNext()) {
                    text.addLast(temp);
                    temp = in.nextLine();
                }

                if (!ofile.equals("")) {
                    FileWriter fw = new FileWriter(ofile);
                    LinkedList<String> result = Func.action(text, c, n);
                    if(result == null) {
                        out.print("No text found");
                        System.exit(0);
                    }
                    for (String tmp : result) {
                        fw.write(tmp);
                    }
                    fw.close();

                } else {
                    LinkedList<String> result = Func.action(text, c, n);
                    if(result == null) {
                        out.print("No text found");
                        System.exit(0);
                    }
                    for (String tmp : result) {
                        out.println(tmp);
                    }

                }
            }
        } catch (IOException e) {
            out.println("IOException has just been caught (FileWriter)");
        } catch (Exception e) {
            out.println("Unexpected Exception");
            e.printStackTrace(out);
        }


    }
}
