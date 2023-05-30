package br.com.luizalabs.searchengine.infrastructure.service;

import br.com.luizalabs.searchengine.domain.repository.FileRepository;
import br.com.luizalabs.searchengine.domain.service.FileService;
import br.com.luizalabs.searchengine.infrastructure.exception.FileException;

public class FileServiceImpl implements FileService {

    private FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public boolean searchSentenceInFile(String filePath, String sentence) throws FileException {
        return fileRepository.searchSentenceInFile(filePath, sentence);
    }
}
