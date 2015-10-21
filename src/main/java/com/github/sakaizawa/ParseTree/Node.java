package com.github.sakaizawa.ParseTree;

import java.util.List;

/**
 * Created by sakaisawayuya on 2015/10/16.
 */
public class Node {

    private String word;
    private String phrase;
    private Node parent;
    private List<Node> children;

    public Node (String word, String phrase) {
        this.word = word;
        this.phrase = phrase;
    }

    public String getWord() {
        return word;
    }

    public String getPhrase() {
        return phrase;
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getChildren() {
        return children;
    }
}
