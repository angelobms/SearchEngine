package br.com.luizalabs.searchengine;

import br.com.luizalabs.searchengine.domain.model.SeachSetenceFilter;
import br.com.luizalabs.searchengine.userstories.SearchSentenceFileUserStory;
import br.com.luizalabs.searchengine.userstories.factories.SearchSentenceFileUserStoryFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {

    private final String sentence;
    private final String directoryName;
    private final SearchSentenceFileUserStoryFactory searchSentenceFileUserStoryFactory;

    public SearchEngine(String sentence, String directoryName, SearchSentenceFileUserStoryFactory searchSentenceFileUserStoryFactory) {
        this.sentence = sentence;
        this.directoryName = directoryName;
        this.searchSentenceFileUserStoryFactory = searchSentenceFileUserStoryFactory;
    }

    public static void main(String[] args) {

        String sentences = Arrays.asList(args).stream().collect(Collectors.joining(" "));
        System.out.println("Sentence = " + sentences);

        String directoryName = System.getProperty("user.dir");

        System.out.println("Current Working Directory is = " + directoryName);

        SearchSentenceFileUserStory searchSentenceFileUserStory = new SearchSentenceFileUserStoryFactory(
                new SeachSetenceFilter(directoryName, sentences)).create();

        List<String> files = searchSentenceFileUserStory.execute();
        if (files != null) {
            String occurrences = String.valueOf(files.size());
            System.out.println(String.format("Foram encontradas %s ocorrencias pelo termo \"%s\"", occurrences, sentences));

            System.out.println(String.format("Os arquivos que possuem \"%s\" são:", sentences));
            files.stream().map(filePath -> filePath.replaceAll(directoryName,"data"))
                    .forEach(System.out::println);
        } else {
            System.out.println("A pasta está vazia.");
        }
    }

    public List<String> searchFiles() {
        SearchSentenceFileUserStory searchSentenceFileUserStory = searchSentenceFileUserStoryFactory.create();
        return searchSentenceFileUserStory.execute();
    }

    public String getSentence() {
        return sentence;
    }

    public String getDirectoryName() {
        return directoryName;
    }
}
