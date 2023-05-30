package br.com.luizalabs.searchengine.repository;

import br.com.luizalabs.searchengine.infrastructure.repository.FileRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

class FileRepositoryImplTest {

    private final FileRepositoryImpl fileRepository = new FileRepositoryImpl();

    @Test
    void testSearchSentenceInFile() throws IOException {

        File tempFile = createTempFile("testFile.txt", "This is a test file.\nIt contains some text.");

        boolean found = fileRepository.searchSentenceInFile(tempFile.getAbsolutePath(), "test file");
        Assertions.assertTrue(found);

        found = fileRepository.searchSentenceInFile(tempFile.getAbsolutePath(), "nonexistent sentence");
        Assertions.assertFalse(found);

        tempFile.delete();
    }

    @Test
    void testSearchSentenceInFiles() throws IOException {
        File tempFile1 = createTempFile("file1.txt", "This is file 1.");
        File tempFile2 = createTempFile("file2.txt", "This is file 2.");
        File tempFile3 = createTempFile("file3.txt", "This is file 3.");

        List<String> filePaths = Arrays.asList(
                tempFile1.getAbsolutePath(),
                tempFile2.getAbsolutePath(),
                tempFile3.getAbsolutePath()
        );

        List<String> matchingFiles = fileRepository.searchSentenceInFiles(filePaths, "file");
        Assertions.assertEquals(3, matchingFiles.size());
        Assertions.assertEquals(tempFile1.getAbsolutePath(), matchingFiles.get(0));
        Assertions.assertEquals(tempFile2.getAbsolutePath(), matchingFiles.get(1));
        Assertions.assertEquals(tempFile3.getAbsolutePath(), matchingFiles.get(2));

        matchingFiles = fileRepository.searchSentenceInFiles(filePaths, "nonexistent sentence");
        Assertions.assertTrue(matchingFiles.isEmpty());

        tempFile1.delete();
        tempFile2.delete();
        tempFile3.delete();
    }

    private File createTempFile(String fileName, String content) throws IOException {
        File tempFile = File.createTempFile(fileName, null);
        tempFile.deleteOnExit();
        Files.write(tempFile.toPath(), content.getBytes());
        return tempFile;
    }
}
