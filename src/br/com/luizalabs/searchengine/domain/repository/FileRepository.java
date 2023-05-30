package br.com.luizalabs.searchengine.domain.repository;

import br.com.luizalabs.searchengine.infrastructure.exception.FileException;

public interface FileRepository {

    public boolean searchSentenceInFile(String filePath, String sentence) throws FileException;
}
