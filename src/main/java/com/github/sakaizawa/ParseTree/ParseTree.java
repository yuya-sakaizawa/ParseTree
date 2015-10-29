package com.github.sakaizawa.ParseTree;

import java.util.Iterator;
import java.util.List;

/**
 * Created by sakaisawayuya on 2015/10/15.
 */
public interface ParseTree {


    /**
     * 現在の node からの木の走査
     * @param traversalStrategy 深さ優先探索か幅優先探索か
     * @return イテレータ
     */
    public Iterator<ParseTree> traverse(TraversalStrategy traversalStrategy);

    /**
     * リーフノードか否か
     * @return リーフノード → True，それ以外 → False
     */
    public boolean isLeaf();

    // test なし
    /**
     * ROOT node か否か
     * @return ROOT node → True, otherwise → False
     */
    public boolean isROOT();

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

    // test　なし
    /**
     * 現在の node に子ノードを加える
     * @param parseTree 加える子ノード
     */
    public void addNode(ParseTree parseTree);

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

    /**
     * ラベルをセットする
     * @param label ラベル
     */
    public void setLabel(String label);

}
