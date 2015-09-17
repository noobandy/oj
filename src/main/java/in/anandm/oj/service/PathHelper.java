package in.anandm.oj.service;

import java.util.UUID;

public class PathHelper {

    private static final String SEPERATOR = "/";

    private String storageDirectory;

    private String stagingDirectory;

    /**
     * @param storageDirectory
     * @param stagingDirectory
     */
    public PathHelper(String storageDirectory, String stagingDirectory) {
        super();
        this.storageDirectory = storageDirectory;
        this.stagingDirectory = stagingDirectory;
    }

    public String getStorageDirectory() {
        return storageDirectory;
    }

    public void setStorageDirectory(String storageDirectory) {
        this.storageDirectory = storageDirectory;
    }

    public String getStagingDirectory() {
        return stagingDirectory;
    }

    public void setStagingDirectory(String stagingDirectory) {
        this.stagingDirectory = stagingDirectory;
    }

    public String directoryPath() {
        String uuid = UUID.randomUUID().toString();
        String partOne = uuid.substring(0, 2);
        String partTwo = uuid.substring(2, 4);
        String partThree = uuid.substring(4, 6);
        String partFour = uuid.substring(6, 8);

        String directoryPath = partOne + SEPERATOR + partTwo + SEPERATOR
                + partThree + SEPERATOR + partFour + SEPERATOR
                + System.currentTimeMillis();

        return directoryPath;
    }

    public String absoluteDirectoryPath(String directoryPath) {
        return storageDirectory + SEPERATOR + directoryPath;
    }

    public String filePath(String directoryPath, String fileName) {
        return directoryPath + SEPERATOR + fileName;
    }

    public String absoluteFilePath(String filePath) {
        return storageDirectory + SEPERATOR + filePath;
    }

    public String absoluteStagingDirectoryPath(String stagingDirectoryPath) {
        return stagingDirectory + SEPERATOR + stagingDirectoryPath;
    }

    public String stagingFilePath(String stagingDirectoryPath,
                                  String stagingFileName) {
        return stagingDirectoryPath + SEPERATOR + stagingFileName;
    }

    public String absoluteStagingFilePath(String stagingFilePath) {
        return stagingDirectory + SEPERATOR + stagingFilePath;
    }
}
