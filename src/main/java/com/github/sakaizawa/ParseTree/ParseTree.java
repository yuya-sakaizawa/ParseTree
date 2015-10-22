package com.github.sakaizawa.ParseTree;

import java.util.List;

/**
 * Created by sakaisawayuya on 2015/10/15.
 */
public interface ParseTree {


    // 深さ優先？幅優先？ enum で管理するべき？
    // イテレータを用意する？
    /**
     * Tree の走査
     */
    public void traverse();

    /**
     * リーフノードか否か
     * @return リーフノード → True，それ以外 → False
     */
    public boolean isLeaf();

    /**
     * node の総数を返す
     * @return node の総数
     */
    public int totalNode();

    /**
     * その木の高さを返す
     * @return 木の高さ
     */
    public int getHeight();

    /**
     * i 番目の子ノードを返す
     * @param i インデックス
     * @return i 番目の子ノード
     */
    public ParseTree getChild(int i);

    /**
     * label を返す
     * @return label
     */
    public String getLabel();

    /**
     * 親を返す
     * @return 親
     */
    public ParseTree getParent();

    /**
     * 子ノードのリストを返す
     * @return 子ノードのリスト
     */
    public List<ParseTree> getChildren();

    /**
     * 親ノードをセットする
     * @param parentNode 親ノード
     */
    public void setParent(ParseTree parentNode);

    /**
     * 子ノードを加える（右に）
     * @param child 子ノード
     */
    public void setChild(ParseTree child);

}
