package in.anandm.oj.service;

import in.anandm.oj.model.Problem;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.springframework.context.ApplicationContextException;
import org.springframework.web.multipart.MultipartFile;

public class ProblemUploadHelper {

    Problem uploadProblem(String storageDirectory, MultipartFile problemFile) {
        try {
            String uuid = UUID.randomUUID().toString();
            String partOne = uuid.substring(0, 2);
            String partTwo = uuid.substring(2, 4);
            String partThree = uuid.substring(4, 6);
            String partFour = uuid.substring(6, 8);

            String problemDirectoryPath = storageDirectory + File.separator
                    + partOne + File.separator + partTwo + File.separator
                    + partThree + File.separator + partFour + File.separator
                    + System.currentTimeMillis();

            File problemDirectory = new File(problemDirectoryPath);

            problemDirectory.mkdirs();

            ZipInputStream zipInputStream = new ZipInputStream(
                    problemFile.getInputStream());

            ZipEntry zipEntry = null;
            List<String> testCaseFiles = new ArrayList<String>();

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {

                if (zipEntry.getName().matches("^test[0-9]*\\.in\\.txt$")) {
                    testCaseFiles.add(zipEntry.getName());
                }

                File file = new File(problemDirectoryPath + File.separator
                        + zipEntry.getName());
                BufferedOutputStream os = new BufferedOutputStream(
                        new FileOutputStream(file));
                int len = -1;
                byte[] buffer = new byte[1024];
                while ((len = zipInputStream.read(buffer)) > 0) {
                    os.write(buffer, 0, len);
                }
                os.close();

            }

            zipInputStream.close();

            File constraintsFile = new File(problemDirectoryPath
                    + File.separator + "constraints.txt");

            BufferedReader reader = new BufferedReader(new FileReader(
                    constraintsFile));

            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("=");

            }

            Problem problem = new Problem();

            problem.setProblemStatementFilePath(storageDirectory
                    + File.separator + "statement.md");

        }
        catch (IOException e) {

            throw new ApplicationContextException("failed to upload problem", e);
        }

        return null;
    }
}
