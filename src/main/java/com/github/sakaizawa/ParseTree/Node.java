package com.github.sakaizawa.ParseTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sakaisawayuya on 2015/10/16.
 */
public class Node {

    protected String word;
    protected String phrase;
    protected Node parent;
    protected List<Node> children;

    public Node(){}
    public Node (String word, String phrase) {
        this.word = word;
        this.phrase = phrase;
        this.parent = null;
        this.children = new ArrayList<Node>();
    }

    // protected にすれば必要ない？

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


    public void setChild(Node node) {
        children.add(node);
    }

    public void setParent(Node node) {
        parent = node;
    }
}
