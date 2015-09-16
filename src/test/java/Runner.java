import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Timer;
import java.util.TimerTask;

public class Runner {

    public void compile() throws IOException {
        ProcessBuilder builder = new ProcessBuilder("javac", "Main.java");

        builder.redirectErrorStream(true);
        builder.directory(new File(
                "E:\\WorkData\\workspace\\online-judge\\src\\test\\java"));

        Process process = builder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                process.getInputStream()));

        String line = null;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void run() throws IOException {

        ProcessBuilder builder = new ProcessBuilder("java", "Main");

        builder.redirectErrorStream(true);
        builder.directory(new File(
                "E:\\WorkData\\workspace\\online-judge\\src\\test\\java"));

        final Process process = builder.start();
        BufferedReader reader = new BufferedReader(
                new FileReader(
                        "E:\\WorkData\\workspace\\online-judge\\src\\test\\java\\Main.in.txt"));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                process.getOutputStream()));

        String inputLine = null;

        while ((inputLine = reader.readLine()) != null) {
            writer.write(inputLine);
        }

        reader.close();
        writer.close();

        final Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                int exitValue = -1;
                try {
                    exitValue = process.exitValue();

                }
                catch (IllegalThreadStateException e) {

                }

                if (exitValue != 0) {
                    process.destroy();
                    System.out.println("TLE");
                }

                timer.cancel();

            }
        }, 1000);

        BufferedReader processOutputReader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        String line = null;

        while ((line = processOutputReader.readLine()) != null) {
            System.out.println(line);
        }
        processOutputReader.close();
    }

    public static void main(String[] args) throws IOException {

        Runner runner = new Runner();
        runner.compile();
        runner.run();
    }

}
