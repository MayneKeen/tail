package com.keenpro;

import java.io.*;
import java.util.*;


public class Main  {





    public static void main(String[] args) throws Exception {


        Scanner in = new Scanner(System.in);



        String line = in.nextLine();
        String[] input = line.split(" ");


        String ofile = input[3] + ".txt";
        FileWriter fw = new FileWriter(ofile);



        if(input[1] == "-c" && input[3] == "-n") {
            throw new Exception("-c and -n flags r used together");
        }

        String fileName;



        for(int i=5; i<input.length; i++) {
            fileName = input[i] + ".txt";
            FileReader fr = new FileReader(fileName);             // tail [-c num|-n num] [-o file] file0 file1 file2...
            Scanner fs = new Scanner(fr);

            int c = 0;
            int n = 0;

            switch (input[2]) {
                case "-c": {
                    c = Integer.parseInt(input[2]);
                    break;
                }
                case "-n": {
                    n = Integer.parseInt(input[2]);
                    break;
                }
            }

            fr.close();
        }






        fw.close();
    }

}
