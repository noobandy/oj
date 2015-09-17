package in.anandm.oj.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class FileUtils {

    /**
     * 
     */
    private FileUtils() {
        super();

    }

    public static final void copyFile(File source,
                                      File destination,
                                      int bufferSize) throws IOException {
        copy(
                new FileInputStream(source), new FileOutputStream(destination),
                bufferSize);

    }

    public static final void copy(InputStream is,
                                  OutputStream os,
                                  int bufferSize) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(is);

        BufferedOutputStream bos = new BufferedOutputStream(os);

        byte[] buffer = new byte[bufferSize];
        int len = -1;

        while ((len = bis.read(buffer)) > 0) {
            bos.write(buffer, 0, len);
        }

        bis.close();

        bos.close();
    }

    public static final boolean hasSameContent(File firstFile, File secondFile)
            throws IOException {

        BufferedReader firstReader = new BufferedReader(new FileReader(
                firstFile));

        String firstLine = null;
        StringBuilder firstBuilder = new StringBuilder();

        while ((firstLine = firstReader.readLine()) != null) {
            firstBuilder.append(firstLine);
        }

        firstReader.close();

        String secondLine = null;

        BufferedReader secondReader = new BufferedReader(new FileReader(
                secondFile));

        StringBuilder secondBuilder = new StringBuilder();

        while ((secondLine = secondReader.readLine()) != null) {
            secondBuilder.append(secondLine);
        }

        secondReader.close();

        return firstBuilder.toString().equals(secondBuilder.toString());

    }
}
