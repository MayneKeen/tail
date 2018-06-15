package com.keenpro;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Func {

    public static PrintStream out = System.out;

    public static LinkedList<String> action(ArrayList<String> input, ArrayList<String> inputFiles,
                                            int c, int n, boolean consoleInput) throws Exception{


            String fileName;
            LinkedList<String> result = new LinkedList<>();

            for (String element : inputFiles) {

                out.println("Filename is " + element);

                fileName = element;
                FileReader fr = new FileReader(fileName);         // tail [-c num |-n num] [-o file] file0 file1 file2...
                Scanner fs = new Scanner(fr);

                ArrayList<String> list = new ArrayList<>();

                while (fs.hasNextLine())
                    list.add(fs.nextLine());

                if (c == 0) {
                    for (int k = list.size() - 1 - n; k < (list.size() - 1); k++) {
                        result.add(list.get(k));
                    }
                }


                else {
                    int k = list.size() - 1;
                    while (c < list.get(k).length()) {
                        result.addFirst(list.get(k));
                        c -= list.get(k).length();
                        k++;
                    }

                    String last = list.get(k);
                    if (c > 0) {
                        for (int l = last.length() - 1 - c; l < last.length(); l++) {
                            result.addFirst(Character.toString(last.charAt(l)));
                        }
                    }
                }
                fr.close();
            }
            return result;
    }


    public static LinkedList<String> consoleAction(LinkedList<String> input,
                                                   int c, int n) {

        LinkedList<String> result = new LinkedList<>();

        if (c == 0) {
            for (int k = input.size() - 1 - n; k < (input.size() - 1); k++) {
                result.add(input.get(k));
            }
        } else {
            int k = input.size() - 1;
            while (c < input.get(k).length()) {
                result.addFirst(input.get(k));
                c -= input.get(k).length();
                k++;
            }

            String last = input.get(k);
            if (c > 0) {
                for (int l = last.length() - 1 - c; l < last.length(); l++) {
                    result.addFirst(Character.toString(last.charAt(l)));
                }
            }
        }
        return result;
    }

}
