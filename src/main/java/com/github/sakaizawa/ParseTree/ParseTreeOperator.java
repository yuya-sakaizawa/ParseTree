package com.github.sakaizawa.ParseTree;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by sakaisawayuya on 2015/10/16.
 */
public interface ParseTreeOperator {

    /**
     * word がその Tree の中にあるか否か
     * @param word 単語
     * @return 単語がある → True, ない →　False
     */
    public boolean search(String word);

    /**
     * word の品詞を返す
     * @param word 単語
     * @return 品詞
     */
    public String searchPos(String word);

    /**
     * 単語の句を返す
     * @param word 単語
     * @return 句
     */
    public String searchPhrase(String word);
}
