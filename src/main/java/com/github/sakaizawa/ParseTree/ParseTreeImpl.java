package com.github.sakaizawa.ParseTree;

import java.util.List;

/**
 * Created by sakaisawayuya on 2015/10/20.
 */
public class ParseTreeImpl
    implements ParseTree{

    /**
     * parseTree の初期化
     */
    public void initialize() {
    }

    /**
     * Tree の走査
     */
    public void traverse() {

    }

    /**
     * 現在の node に新しい node を加える
     *
     * @param node 加える node
     */
    public void add(Node node) {

    }

    /**
     * 現在の node を返す
     *
     * @return 現在のノード
     */
    public Node getCurrentNode() {
        return null;
    }

    /**
     * i 番目の Node を返す
     *
     * @param i インデックス
     * @return i 番目の Node
     */
    public Node getNode(int i) {
        return null;
    }

    /**
     * 現在の Node の子ノードを返す
     *
     * @return 子ノード
     */
    public List<Node> getChildren() {
        return null;
    }

    /**
     * 現在の Node の親ノードを返す
     *
     * @return 親ノード
     */
    public Node getParent() {
        return null;
    }

    /**
     * リーフノードか否か
     *
     * @return リーフノード → True，それ以外 → False
     */
    public boolean isLeaf() {
        return false;
    }

    /**
     * node の総数を返す
     *
     * @return node の総数
     */
    public int totalNode() {
        return 0;
    }
}
