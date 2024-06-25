package com.shvmsJobs.model;

import java.util.List;

public class GeminiApiUri {

    private List<Content> contents;

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "AIEssayURI{" +
                "contents=" + contents +
                '}';
    }
}
