package com.github.sakaizawa.ParseTree;

import java.util.List;

/**
 * Created by sakaisawayuya on 2015/10/15.
 */
public interface ParseTree {

    /**
     * Tree の走査
     */
    public void traverse();

    /**
     * 現在の node を返す
     * @return 現在のノード
     */
    public Node getCurrentNode();

    /**
     * i 番目の Node を返す
     * @param i インデックス
     * @return i 番目の Node
     */
    public Node getNode(int i);

    /**
     * 現在の Node の子ノードを返す
     * @return 子ノード
     */
    public List<Node> getChildren();

    /**
     * 現在の Node の親ノードを返す
     * @return 親ノード
     */
    public Node getParent();

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
}
