package com.github.sakaizawa.ParseTree;

import java.util.Stack;

/**
 * Created by sakaisawayuya on 2015/10/15.
 */
public interface ParseTreeConverter {

    /**
     * parseTree を構築する
     * @param sentence 入れ子になっている文字列
     * @return parseTree
     */
    public ParseTree buildParseTree(String sentence);

    /**
     * parseTree を構築する
     * @param sentence stack に入った文字列
     * @return parseTree
     */
    public ParseTree buildParseTree(Stack<String> sentence);
}
