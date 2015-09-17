package in.anandm.oj;

import in.anandm.oj.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class MultiPartFileStub implements MultipartFile {

    private File file;

    /**
     * 
     */
    public MultiPartFileStub(String filePath) {
        super();

        file = new File(filePath);

    }

    @Override
    public String getName() {

        throw new UnsupportedOperationException();
    }

    @Override
    public String getOriginalFilename() {

        throw new UnsupportedOperationException();
    }

    @Override
    public String getContentType() {

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {

        throw new UnsupportedOperationException();
    }

    @Override
    public long getSize() {

        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] getBytes() throws IOException {

        throw new UnsupportedOperationException();
    }

    @Override
    public InputStream getInputStream() throws IOException {

        return new FileInputStream(file);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        FileUtils.copyFile(file, dest, 1024);
    }

}
