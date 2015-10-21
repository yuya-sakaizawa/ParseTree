package com.github.sakaizawa.ParseTree;

import static org.junit.Assert.*;

/**
 * Created by sakaisawayuya on 2015/10/20.
 */
public class ParseTreeTest {

    @org.junit.Test
    public void testInitialize() throws Exception {

    }

    @org.junit.Test
    public void testTraverse() throws Exception {

    }

    @org.junit.Test
    public void testAdd() throws Exception {

    }

    @org.junit.Test
    public void testGetCurrentNode() throws Exception {

    }

    @org.junit.Test
    public void testGetNode() throws Exception {

    }

    @org.junit.Test
    public void testGetChildren() throws Exception {

    }

    @org.junit.Test
    public void testGetParent() throws Exception {

    }

    @org.junit.Test
    public void testIsLeaf() throws Exception {
        ParseTree parseTree = new ParseTreeImpl();
        assertEquals(false, parseTree.isLeaf());

        // メソッドに工夫が必要？
        parseTree.add(new Node("I", null));
        assertEquals(true, parseTree.isLeaf());
    }

    @org.junit.Test
    public void testTotalNode() throws Exception {
        ParseTree parseTree = new ParseTreeImpl();
        assertEquals(1, parseTree.totalNode());

        parseTree.add(new Node("I", null));
        assertEquals(2, parseTree.totalNode());

        parseTree.add(new Node("like", null));
        assertEquals(3, parseTree.totalNode());
    }
}