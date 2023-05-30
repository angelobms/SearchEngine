package br.com.luizalabs.searchengine.domain.model;

public class SeachSetenceFilter {

    private String directoryName;
    private String sentence;

    public SeachSetenceFilter(String directoryName, String sentence) {
        this.directoryName = directoryName;
        this.sentence = sentence;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
