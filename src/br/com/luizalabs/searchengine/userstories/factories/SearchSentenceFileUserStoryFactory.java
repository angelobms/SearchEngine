package br.com.luizalabs.searchengine.userstories.factories;

import br.com.luizalabs.searchengine.domain.model.SeachSetenceFilter;
import br.com.luizalabs.searchengine.domain.repository.FileRepository;
import br.com.luizalabs.searchengine.infrastructure.repository.FileRepositoryImpl;
import br.com.luizalabs.searchengine.domain.service.FileService;
import br.com.luizalabs.searchengine.infrastructure.service.FileServiceImpl;
import br.com.luizalabs.searchengine.userstories.SearchSentenceFileUserStory;

public class SearchSentenceFileUserStoryFactory implements UserStoryFactory<SearchSentenceFileUserStory>{

    private SeachSetenceFilter seachSetenceFilter;

    public SearchSentenceFileUserStoryFactory(SeachSetenceFilter seachSetenceFilter) {
        this.seachSetenceFilter = seachSetenceFilter;
    }

    @Override
    public SearchSentenceFileUserStory create() {

        FileRepository fileRepository = new FileRepositoryImpl();
        FileService fileService = new FileServiceImpl(fileRepository);

        return new SearchSentenceFileUserStory(
            this.seachSetenceFilter,
            fileService
        );

    }
}
