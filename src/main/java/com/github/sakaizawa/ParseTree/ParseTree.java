package com.github.sakaizawa.ParseTree;

import java.util.List;

/**
 * Created by sakaisawayuya on 2015/10/15.
 */
public interface ParseTree {

    // この実装だと Tree としての記述はなくなっているが問題あり？

    /**
     * Tree の走査
     */
    public void traverse();

    /**
     * 新しい node を加える
     * @param word 単語
     * @param phrase 句
     */
    public void add(String word, String phrase);

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


    // node インターフェースが必要？　ここにいらない？
    public String getWord();

    public String getPhrase();

    public Node getParent();

    public List<Node> getChildren();

    public void setChild(Node node);

    public void setParent(Node node);
}
