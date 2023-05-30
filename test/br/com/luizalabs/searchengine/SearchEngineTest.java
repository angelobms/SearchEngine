package br.com.luizalabs.searchengine;

import br.com.luizalabs.searchengine.userstories.SearchSentenceFileUserStory;
import br.com.luizalabs.searchengine.userstories.factories.SearchSentenceFileUserStoryFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

class SearchEngineTest {

    @Mock
    private SearchSentenceFileUserStoryFactory searchSentenceFileUserStoryFactory;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSearchFiles_WhenFilesFound() {
        String sentence = "example sentence";
        String directoryName = "data";
        List<String> expectedFiles = Arrays.asList("file1.txt", "file2.txt", "file2.txt");

        Mockito.when(searchSentenceFileUserStoryFactory.create()).thenReturn(Mockito.mock(SearchSentenceFileUserStory.class));
        Mockito.when(searchSentenceFileUserStoryFactory.create().execute()).thenReturn(expectedFiles);

        SearchEngine searchEngine = new SearchEngine(sentence, directoryName, searchSentenceFileUserStoryFactory);
        List<String> actualFiles = searchEngine.searchFiles();

        Assertions.assertEquals(expectedFiles, actualFiles);
    }

    @Test
    void testSearchFiles_WhenNoFilesFound() {
        String sentence = "example sentence";
        String directoryName = "example/directory";

        Mockito.when(searchSentenceFileUserStoryFactory.create()).thenReturn(Mockito.mock(SearchSentenceFileUserStory.class));
        Mockito.when(searchSentenceFileUserStoryFactory.create().execute()).thenReturn(null);

        SearchEngine searchEngine = new SearchEngine(sentence, directoryName, searchSentenceFileUserStoryFactory);
        List<String> actualFiles = searchEngine.searchFiles();

        Assertions.assertNull(actualFiles);
    }
}
