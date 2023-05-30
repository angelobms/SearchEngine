package br.com.luizalabs.searchengine.model;

import br.com.luizalabs.searchengine.domain.model.SeachSetenceFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SeachSentenceFilterTest {

    @Test
    void testGetDirectoryName() {
        String directoryName = "example/directory";
        String sentence = "example sentence";
        SeachSetenceFilter filter = new SeachSetenceFilter(directoryName, sentence);

        String result = filter.getDirectoryName();

        Assertions.assertEquals(directoryName, result);
    }

    @Test
    void testSetDirectoryName() {
        String directoryName = "example/directory";
        String sentence = "example sentence";
        SeachSetenceFilter filter = new SeachSetenceFilter("", sentence);

        filter.setDirectoryName(directoryName);
        String result = filter.getDirectoryName();

        Assertions.assertEquals(directoryName, result);
    }

    @Test
    void testGetSentence() {
        String directoryName = "example/directory";
        String sentence = "example sentence";
        SeachSetenceFilter filter = new SeachSetenceFilter(directoryName, sentence);

        String result = filter.getSentence();

        Assertions.assertEquals(sentence, result);
    }

    @Test
    void testSetSentence() {
        String directoryName = "example/directory";
        String sentence = "example sentence";
        SeachSetenceFilter filter = new SeachSetenceFilter(directoryName, "");

        filter.setSentence(sentence);
        String result = filter.getSentence();

        Assertions.assertEquals(sentence, result);
    }
}
