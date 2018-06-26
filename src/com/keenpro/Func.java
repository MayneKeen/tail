package com.keenpro;

import java.util.*;

class Func {

    static LinkedList<String> action(LinkedList<String> text,
                                     int c, int n) {
        LinkedList<String> result = new LinkedList<>();
            if (c == 0) {
                for (int k = text.size() - 1 - n; k < (text.size() - 1); k++) {
                    result.add(text.get(k));
                }
            } else {
                int k = text.size() - 1;
                while (c < text.get(k).length()) {
                    result.addFirst(text.get(k));
                    c -= text.get(k).length();
                    k++;
                }

                String last = text.get(k);
                if (c > 0) {
                    result.addFirst(last.substring(last.length() - 1 - c));
                }
            }

        return result;
    }
}
