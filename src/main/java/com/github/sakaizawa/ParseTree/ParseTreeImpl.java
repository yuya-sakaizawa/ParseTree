package com.github.sakaizawa.ParseTree;

import java.util.List;

/**
 * Created by sakaisawayuya on 2015/10/20.
 */
public class ParseTreeImpl
    extends Node
    implements ParseTree {

    public ParseTreeImpl(String word, String phrase) {
        super(word, phrase);
    }

    // コンストラクタで必要？？
    public ParseTreeImpl(String sFormula) {
        // TODO
    }

    /**
     * Tree の走査
     */
    public void traverse(){}

    /**
     * 葉ノードのリストを返す
     */
    public List<ParseTree> getLeaves() {
        return null;
    }

    /**
     * 新しい node を加える
     * @param word 単語
     * @param phrase 句
     */
    public void add(String word, String phrase) {
        Node child = new ParseTreeImpl(word, phrase);
        setChild(child);
        child.setParent(this);
    }

    /**
     * リーフノードか否か
     *
     * @return リーフノード → True，それ以外 → False
     */
    public boolean isLeaf() {
        return  children.size() == 0;
    }

    /**
     *
     * @return
     */
    public boolean isRoot() {
        return parent == null;
    }

    /**
     * node の総数を返す
     *
     * @return node の総数
     */
    public int totalNode() {
        return 0;
    }

    /**
     * その木の高さを返す
     * @return 木の高さ
     */
    public int getHeight() {return 0;}

    //public String getWord() {
    //    return word;
    //}
}
