package com.github.sakaizawa.ParseTree;

/**
 * Created by sakaisawayuya on 2015/10/15.
 */
public interface ParseTree {

    /**
     * Tree の走査
     */
    public void traverse();

    public boolean search(String word);

    public void getRightChild();

    public void getLeftChild();

    public void getChildren();

    /**
     * リーフノードか否か
     * @return リーフノード → True，それ以外 → False
     */
    public boolean isLeaf();

    public String searchPos(String word);

    public String searchPhrase(String word);
}
