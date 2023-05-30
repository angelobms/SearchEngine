package br.com.luizalabs.searchengine.userstories;

import br.com.luizalabs.searchengine.domain.model.SeachSetenceFilter;
import br.com.luizalabs.searchengine.domain.service.FileService;
import br.com.luizalabs.searchengine.infrastructure.exception.FileException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SearchSentenceFileUserStory implements UserStory<List<String>> {

    private SeachSetenceFilter seachSetenceFilter;
    private FileService fileService;

    public SearchSentenceFileUserStory(SeachSetenceFilter seachSetenceFilter, FileService fileService) {
        this.seachSetenceFilter = seachSetenceFilter;
        this.fileService = fileService;
    }

    @Override
    public List<String> execute() {

        File folder = new File(this.seachSetenceFilter.getDirectoryName());
        System.out.println(folder);

        List<String> matchingFiles = new ArrayList<>();

        if (folder.exists() && folder.isDirectory()) {
                Arrays.stream(folder.listFiles()).forEach(filePath -> {
                    boolean found = false;
                    try {
                        found = this.fileService.searchSentenceInFile(String.valueOf(filePath.toString()),
                                seachSetenceFilter.getSentence());
                    } catch (Exception e) {
                        throw new FileException(e.getMessage(), e.getCause());
                    }
                    if (found) {
                        matchingFiles.add(String.valueOf(filePath));
                    }
                });

            matchingFiles.sort(Comparator.naturalOrder());
        } else {
            System.out.println("O path especificado não é uma pasta válida.");
        }
        return matchingFiles;
    }
    
}
