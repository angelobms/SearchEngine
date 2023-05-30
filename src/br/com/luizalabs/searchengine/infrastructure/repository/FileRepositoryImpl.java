package br.com.luizalabs.searchengine.infrastructure.repository;

import br.com.luizalabs.searchengine.domain.repository.FileRepository;
import br.com.luizalabs.searchengine.infrastructure.exception.FileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileRepositoryImpl implements FileRepository {

    @Override
    public boolean searchSentenceInFile(String filePath, String sentence) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(sentence)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new FileException(e.getMessage(), e.getCause());
        }
        return false;
    }

    public List<String> searchSentenceInFiles(List<String> filePaths, String sentence) {
        List<String> matchingFiles = new ArrayList<>();

        filePaths.forEach(filePath -> {
            boolean found = false;
            try {
                found = searchSentenceInFile(filePath, sentence);
            } catch (Exception e) {
                throw new FileException(e.getMessage(), e.getCause());
            }

            if (found) {
                matchingFiles.add(filePath);
            }
        });

        matchingFiles.sort(Comparator.naturalOrder());
        return matchingFiles;
    }
}
