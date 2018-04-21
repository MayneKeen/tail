package com.keenpro;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Func {

    public static ArrayList<String> action(ArrayList<String> input) throws Exception{

        String fileName;
        ArrayList<String> result = new ArrayList<>();

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
                        result.add("\n");
                        result.add(list.get(k));
                }
            }
            else {
                int k = list.size()-1;
                while (c>list.get(k).length()) {
                    result.add(list.get(k));
                    result.add("\n");
                    c -= list.get(k).length();
                    k--;
                }

                String last = list.get(k);
                if(c>0) {
                    for(int l=last.length()-1-c; l<last.length(); l++) {
                       result.add(Character.toString(last.charAt(l))); //pls tell me if this line's written incorrect
                    }                                                  //maybe it'll be better to use String.valueOf() ?
                }
            }

            fr.close();
        }
        return result;
    }

}
