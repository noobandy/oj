import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        /*
         * while (true) {
         * 
         * }
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));

        String name = reader.readLine();
        reader.close();
        System.out.println("Hello' " + name);
    }

}
