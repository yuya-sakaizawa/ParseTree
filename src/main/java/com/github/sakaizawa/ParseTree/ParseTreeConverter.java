package com.github.sakaizawa.ParseTree;

import java.util.Stack;

/**
 * Created by sakaisawayuya on 2015/10/15.
 */
public interface ParseTreeConverter {

    public ParseTree buildParseTree(Stack<String> sentence);
}
