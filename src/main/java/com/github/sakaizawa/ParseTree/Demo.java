package com.github.sakaizawa.ParseTree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by sakaisawayuya on 2015/10/21.
 */
public class Demo {
    public static void main(String[] args) {
        String sentence = "(ROOT(NP(NNP John))(VP(VBZ loves)(NP(NNP Mary))))";
        ParseTree parseTree = new ParseTreeConverterImpl().buildParseTree(sentence);

        TraversalStrategy traversalStrategy = TraversalStrategy.DEPTH;
        Iterator<ParseTree> parseTreeIterator = parseTree.traverse(traversalStrategy);
        while (parseTreeIterator.hasNext()) {
            ParseTree parseTree1 = parseTreeIterator.next();
            System.out.println(parseTree1.getLabel());
        }

        System.out.println();
        TraversalStrategy traversalStrategy1 = TraversalStrategy.BREADTH;
        Iterator<ParseTree> parseTreeIterator1 = parseTree.traverse(traversalStrategy1);
        while (parseTreeIterator1.hasNext()) {
            ParseTree parseTree2 = parseTreeIterator1.next();
            System.out.println(parseTree2.getLabel());
        }
    }
}
