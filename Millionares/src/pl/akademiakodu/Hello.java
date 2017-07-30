package pl.akademiakodu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by michalos on 11.07.2017.
 */
public class Hello {
    public static void main(String[] args) throws FileNotFoundException {

  //      URL url = Hello.class.getClassLoader().getResource("hello.txt");
//        System.out.println(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader("hello.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
