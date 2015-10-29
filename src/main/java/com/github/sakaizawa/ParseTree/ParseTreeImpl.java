package com.github.sakaizawa.ParseTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sakaisawayuya on 2015/10/20.
 */
public class ParseTreeImpl
    implements ParseTree {


    private String label;
    private ParseTree parent;
    private List<ParseTree> children;

    /**
     *
     * @param label
     */
    public ParseTreeImpl (String label) {
        this.label = label;
        parent = null;
        children = new ArrayList<ParseTree>();
    }


    public Iterator<ParseTree> traverse(TraversalStrategy traversalStrategy){
        Iterator<ParseTree> iterator = null;
        if (traversalStrategy == TraversalStrategy.DEPTH) {
            iterator = new DepthFirstTreeIterator(this);
        } else if (traversalStrategy == TraversalStrategy.BREADTH) {
            iterator = new BreadthFirstTreeIterator(this);
        }
        return iterator;
    }

    /**
     * リーフノードか否か
     *
     * @return リーフノード → True，それ以外 → False
     */
    public boolean isLeaf() {
        return children.size() == 0;
    }

    /**
     * ROOT node か否か
     *
     * @return ROOT node → True, otherwise → False
     */
    public boolean isROOT() {
        return this.parent == null;
    }

    /**
     * 現在の node 以下の  node の総数を返す
     *
     * @return node の総数
     */
    public int totalNode() {
        int totalNumber = 0;
        Iterator<ParseTree> parseTreeIterator = this.traverse(TraversalStrategy.BREADTH);
        while (parseTreeIterator.hasNext()) {
            totalNumber++;
            parseTreeIterator.next();
        }
        return totalNumber;
    }

    /**
     * その木の高さを返す
     *
     * @return 木の高さ
     */
    public int getHeight() {
        int height = 1;
        ParseTree parseTree = this;
        while (!parseTree.isLeaf()) {
            height++;
            parseTree = parseTree.getChild(0);
        }
        return height;
    }

    /**
     * 現在の node に子ノードを加える
     *
     * @param parseTree 加える子ノード
     */
    public void addNode(ParseTree parseTree) {
        this.setChild(parseTree);
        parseTree.setParent(this);
    }

    /**
     * i 番目の子ノードを返す
     *
     * @param i インデックス
     * @return i 番目の子ノード
     */
    public ParseTree getChild(int i) {
        return children.get(i);
    }

    /**
     * label を返す
     *
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * 親を返す
     *
     * @return 親
     */
    public ParseTree getParent() {
        return parent;
    }

    /**
     * 子ノードのリストを返す
     *
     * @return 子ノードのリスト
     */
    public List<ParseTree> getChildren() {
        return children;
    }

    /**
     * 親ノードをセットする
     *
     * @param parentNode 親ノード
     */
    public void setParent(ParseTree parentNode) {
        parent = parentNode;
    }

    /**
     * 子ノードを加える（右に）
     *
     * @param child 子ノード
     */
    public void setChild(ParseTree child) {
        children.add(child);
    }

    /**
     * ラベルセットする
     * @param label ラベル
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
