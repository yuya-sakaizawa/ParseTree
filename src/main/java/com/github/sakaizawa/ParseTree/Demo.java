package com.github.sakaizawa.ParseTree;

/**
 * Created by sakaisawayuya on 2015/10/21.
 */
public class Demo {
    public static void main(String[] args) {
        ParseTree parseTree = new ParseTreeImpl("test", "test");
        //ParseTreeImpl parseTree = new ParseTreeImpl("", "");
        parseTree.add("have", "");
        System.out.println(parseTree.getWord());
        System.out.println();
    }
}
