package br.com.luizalabs.searchengine.domain.service;

import br.com.luizalabs.searchengine.infrastructure.exception.FileException;

public interface FileService {

    public boolean searchSentenceInFile(String filePath, String sentence) throws FileException;
}
