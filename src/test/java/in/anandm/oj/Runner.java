package in.anandm.oj;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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

        ProcessBuilder builder = new ProcessBuilder(
                "E:\\WorkData\\workspace\\online-judge\\src\\test\\java\\test-runner.bat",
                "Main",
                "E:\\WorkData\\workspace\\online-judge\\src\\test\\java\\Main.in.txt",
                "E:\\WorkData\\workspace\\online-judge\\src\\test\\java\\Main.out.txt");

        builder.redirectErrorStream(true);

        builder.directory(new File(
                "E:\\WorkData\\workspace\\online-judge\\src\\test\\java"));

        final Process process = builder.start();

        final Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                int exitValue = -1;
                try {
                    exitValue = process.exitValue();

                }
                catch (IllegalThreadStateException e) {
                    System.out.println(e);
                }

                if (exitValue != 0) {
                    process.destroy();
                    System.out.println("TLE");
                }

                timer.cancel();

            }
        }, 1000);

    }

    public static void main(String[] args) throws IOException {

        Runner runner = new Runner();
        runner.compile();
        runner.run();
    }

}
