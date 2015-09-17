package in.anandm.oj.service;

import in.anandm.oj.utils.FileUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.context.ApplicationContextException;
import org.springframework.web.multipart.MultipartFile;

public class SolutionUploadHelper {

    private PathHelper pathHelper;

    /**
     * @param pathHelper
     */
    public SolutionUploadHelper(PathHelper pathHelper) {
        super();
        this.pathHelper = pathHelper;
    }

    public String uploadSolution(MultipartFile solutionFile) {
        try {

            String solutionDirectoryPath = pathHelper.directoryPath();

            File solutionDirectory = new File(
                    pathHelper.absoluteDirectoryPath(solutionDirectoryPath));

            solutionDirectory.mkdirs();

            String filePath = pathHelper.filePath(
                    solutionDirectoryPath, "solution");

            File flle = new File(pathHelper.absoluteFilePath(filePath));

            solutionFile.transferTo(flle);

            return filePath;

        }
        catch (IOException e) {

            throw new ApplicationContextException("failed to upload solution",
                    e);
        }
    }

    public String uploadSolution(String content) {
        try {

            String solutionDirectoryPath = pathHelper.directoryPath();

            File solutionDirectory = new File(
                    pathHelper.absoluteDirectoryPath(solutionDirectoryPath));

            solutionDirectory.mkdirs();

            String filePath = pathHelper.filePath(
                    solutionDirectoryPath, "solution");

            File flle = new File(pathHelper.absoluteFilePath(filePath));

            FileUtils.copy(
                    new ByteArrayInputStream(content.getBytes()),
                    new FileOutputStream(flle), 1024);

            return filePath;

        }
        catch (IOException e) {

            throw new ApplicationContextException("failed to upload solution",
                    e);

        }
    }

}
