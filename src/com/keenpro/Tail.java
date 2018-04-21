package com.keenpro;

import java.io.*;
import java.util.*;


public class Tail  {

    public static void main(String[] args) throws Exception {
        //Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        ArrayList<String> input = new ArrayList<>();
        for(String element: args) {
            input.add(element);
        }

        if(input.contains("-c") && input.contains("-n")) {
            throw new Exception("-c and -n options r used together");
        }

        if(input.contains("-o")) {
            String ofile = input.get(input.indexOf("-o") + 1);
            FileWriter fw = new FileWriter(ofile);
            ArrayList<String> result = Func.action(input);
            fw.write(result.toString());
            fw.close();

        }

        else {
            ArrayList<String> result = Func.action(input);
            out.println(result.toString());
        }

       /* String fileName;


        for(int i=5; i<input.size(); i++) {

            fileName = input.get(5);
            FileReader fr = new FileReader(fileName);             // tail [-c num|-n num] [-o file] file0 file1 file2...
            Scanner fs = new Scanner(fr);

            int c = 0;
            int n = 0;

            if(input.contains("-c")) {
                c = Integer.parseInt(input.get(input.indexOf("-c")+1));
            }
            else if(input.contains("-n")) {
                n = Integer.parseInt(input.get(input.indexOf("-n")+1));
            }

            ArrayList<String> list = new ArrayList<>();

            while (fs.hasNextLine())
                list.add(fs.nextLine());




            if(c == 0) {
                for (int k = list.size() - 1 - n; k < (list.size() - 1); k++) {
                    if(ofile!=null) {
                        fw.write("\n");
                        fw.write(list.get(k));
                    }
                    else out.println(list.get(k));
                }
            }
            else {
                int k = list.size()-1;
                while (c>list.get(k).length()) {
                    if(ofile!=null) {
                        fw.write(list.get(k));
                        fw.write("\n");
                    }
                    else
                        out.println(list.get(k));
                    c -= list.get(k).length();
                    k--;
                }
                String last = list.get(k);
                if(c>0) {
                    for(int l=last.length()-1-c; l<last.length(); l++) {
                        if(ofile!=null)
                            fw.write(last.charAt(l));
                        else
                            out.println(last.charAt(l));
                    }
                }
            }

            fr.close();
        } */
    }

}
