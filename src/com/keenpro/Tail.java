package com.keenpro;

import java.io.*;
import java.util.*;


public class Tail  {

    public static void main(String[] args) throws Exception {
        //Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        ArrayList<String> input = new ArrayList<>();
        ArrayList<String> inputFiles = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {

            input.add(args[i]);
            if(args[i].endsWith(".txt") && args[i-1] != "-o")
                inputFiles.add(args[i]);
        }


        String ofile = "";
        if (input.contains("-o")) {
            ofile = input.get(input.indexOf("-o") + 1);
        }

        if (input.contains("-c") && input.contains("-n")) {
            if(ofile != "") {
                FileWriter fw = new FileWriter(ofile);
                fw.write("-c and -n flags are used together");
            }
            else {
                out.print("-c and -n flags are used together");
            }
        }

        else {
            int c = 0;
            int n = 0;
            if (input.contains("-c")) {
                c = Integer.parseInt(input.get(input.indexOf("-c") + 1));
            } else if (input.contains("-n")) {
                n = Integer.parseInt(input.get(input.indexOf("-n") + 1));
            }

            if (ofile != "") {
                FileWriter fw = new FileWriter(ofile);
                ArrayList<String> result = Func.action(input, inputFiles, c, n);
                fw.write(result.toString());
                fw.close();

            } else {
                ArrayList<String> result = Func.action(input, inputFiles, c, n);
                out.println(result.toString());
            }

        }
    }
}
