package com.github.sakaizawa.ParseTree;

import java.util.Stack;

/**
 * Created by sakaisawayuya on 2015/10/16.
 */
public interface StackConverter {

    /**
     * 入れ子になった文字列を separate して stack に入れる
     * @param sentence 入れ子になっている文字列
     * @return stack
     */
    public Stack<String> string2Stack(String sentence);
}
