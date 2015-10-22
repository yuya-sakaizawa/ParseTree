package com.github.sakaizawa.ParseTree;

/**
 * Created by sakaisawayuya on 2015/10/21.
 */
public class Demo {
    public static void main(String[] args) {
        ParseTree parseTree = new ParseTreeImpl("test");
        parseTree.setChild(new ParseTreeImpl("POS"));
        System.out.println(parseTree.getLabel());
        System.out.println();
    }
}
