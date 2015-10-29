package com.github.sakaizawa.ParseTree;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by sakaisawayuya on 2015/10/28.
 */
public class ParseTreeConverterImplTest {

    @Test
    public void testBuildParseTree() throws Exception {
        String sentence = "(ROOT(FRAG(NP(PRP I))))";
        Stack<String> stack = new StackConverterImpl().string2Stack(sentence);
        ParseTree parseTree = new ParseTreeConverterImpl().buildParseTree(stack);
        assertEquals("ROOT", parseTree.getLabel());
        parseTree = parseTree.getChild(0);
        assertEquals("FRAG", parseTree.getLabel());
        parseTree = parseTree.getChild(0);
        assertEquals("NP", parseTree.getLabel());
        parseTree = parseTree.getChild(0);
        assertEquals("PRP", parseTree.getLabel());
        parseTree = parseTree.getChild(0);
        assertEquals("I", parseTree.getLabel());

        sentence = "(ROOT(NP(DT a)(JJ vivid)(JJ cinematic)(NN portrait)(. .)))";
        stack = new StackConverterImpl().string2Stack(sentence);
        parseTree = new ParseTreeConverterImpl().buildParseTree(stack);
        assertEquals("ROOT", parseTree.getLabel());
        parseTree = parseTree.getChild(0);
        assertEquals("NP", parseTree.getLabel());
        assertEquals("DT", parseTree.getChild(0).getLabel());
        assertEquals("JJ", parseTree.getChild(1).getLabel());
        assertEquals("JJ", parseTree.getChild(2).getLabel());
        assertEquals("NN", parseTree.getChild(3).getLabel());
        assertEquals(".", parseTree.getChild(4).getLabel());
        assertEquals("a", parseTree.getChild(0).getChild(0).getLabel());
        assertEquals("vivid", parseTree.getChild(1).getChild(0).getLabel());
        assertEquals("cinematic", parseTree.getChild(2).getChild(0).getLabel());
        assertEquals("portrait", parseTree.getChild(3).getChild(0).getLabel());
        assertEquals(".", parseTree.getChild(4).getChild(0).getLabel());
    }
}