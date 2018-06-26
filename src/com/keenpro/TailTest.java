package com.keenpro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TailTest {
    @org.junit.jupiter.api.Test

    void main() throws Exception {
        try {
            FileReader fr1 = new FileReader(new File("output1"));
            BufferedReader reader1 = new BufferedReader(fr1);
            String line1 = reader1.readLine();

            String[] args1 = {"-c", "4", "-o", "output1", "test1"};
            Tail.main(args1);


            FileReader fr2 = new FileReader(new File("output2"));
            BufferedReader reader2 = new BufferedReader(fr2);
            String line2 = reader2.readLine();

            String[] args2 = {"-n", "2", "-o", "output2", "test2"};
            Tail.main(args2);

            assertEquals("иксе", line1);
        }
        catch (IOException e) {
            throw e;
        }

    }

}