package com.keenpro;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Func {

    public static PrintStream out = System.out;

    public static ArrayList<String> action(ArrayList<String> input, ArrayList<String> inputFiles,
                                           int c, int n) {

        try {

            String fileName;
            ArrayList<String> result = new ArrayList<>();

            for (String element : inputFiles) {

                fileName = element;
                FileReader fr = new FileReader(fileName);         // tail [-c num |-n num] [-o file] file0 file1 file2...
                Scanner fs = new Scanner(fr);

                ArrayList<String> list = new ArrayList<>();

                while (fs.hasNextLine())
                    list.add(fs.nextLine());

                if (c == 0) {
                    for (int k = list.size() - 1 - n; k < (list.size() - 1); k++) {
                        result.add("\n");
                        result.add(list.get(k));
                    }
                } else {
                    int k = list.size() - 1;
                    while (c < list.get(k).length()) {
                        result.add(list.get(k));
                        result.add("\n");
                        c -= list.get(k).length();
                        k++;
                    }

                    String last = list.get(k);
                    if (c > 0) {
                        for (int l = last.length() - 1 - c; l < last.length(); l++) {
                            result.add(Character.toString(last.charAt(l)));
                        }
                    }
                }
                fr.close();
            }
            return result;
        }
        catch (IOException e) {
            out.println("IOException has just been caught (FileReader)");
            return null;
        }
    }


}
