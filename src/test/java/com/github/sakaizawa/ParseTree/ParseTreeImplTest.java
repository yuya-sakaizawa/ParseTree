package com.github.sakaizawa.ParseTree;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by sakaisawayuya on 2015/10/22.
 */
public class ParseTreeImplTest {


    @Test
    public void testTraverse() throws Exception {
        // 深さ優先の場合のテスト
        TraversalStrategy traversalStrategy = TraversalStrategy.DEPTH;
        ParseTree parseTree = new ParseTreeImpl("ROOT");
        Iterator<ParseTree> parseTreeIterator = parseTree.traverse(traversalStrategy);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());

        parseTree.setChild(new ParseTreeImpl("POS1-1"));
        parseTreeIterator = parseTree.traverse(traversalStrategy);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());

        parseTree.setChild(new ParseTreeImpl("POS1-2"));
        parseTreeIterator = parseTree.traverse(traversalStrategy);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS1-2", parseTreeIterator.next().getLabel());

        parseTree.setChild(new ParseTreeImpl("POS1-3"));
        parseTreeIterator = parseTree.traverse(traversalStrategy);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS1-2", parseTreeIterator.next().getLabel());
        assertEquals("POS1-3", parseTreeIterator.next().getLabel());

        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-1"));
        parseTreeIterator = parseTree.traverse(traversalStrategy);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS2-1", parseTreeIterator.next().getLabel());
        assertEquals("POS1-2", parseTreeIterator.next().getLabel());
        assertEquals("POS1-3", parseTreeIterator.next().getLabel());

        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-2"));
        parseTreeIterator = parseTree.traverse(traversalStrategy);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS2-1", parseTreeIterator.next().getLabel());
        assertEquals("POS2-2", parseTreeIterator.next().getLabel());
        assertEquals("POS1-2", parseTreeIterator.next().getLabel());
        assertEquals("POS1-3", parseTreeIterator.next().getLabel());

        parseTreeIterator = parseTree.getChild(0).traverse(traversalStrategy);
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS2-1", parseTreeIterator.next().getLabel());
        assertEquals("POS2-2", parseTreeIterator.next().getLabel());

        // 幅優先探索の場合のテスト
        traversalStrategy = TraversalStrategy.BREADTH;
        parseTree = new ParseTreeImpl("ROOT");
        parseTreeIterator = parseTree.traverse(traversalStrategy);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());

        parseTree.setChild(new ParseTreeImpl("POS1-1"));
        parseTreeIterator = parseTree.traverse(traversalStrategy);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());

        parseTree.setChild(new ParseTreeImpl("POS1-2"));
        parseTreeIterator = parseTree.traverse(traversalStrategy);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS1-2", parseTreeIterator.next().getLabel());

        parseTree.setChild(new ParseTreeImpl("POS1-3"));
        parseTreeIterator = parseTree.traverse(traversalStrategy);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS1-2", parseTreeIterator.next().getLabel());
        assertEquals("POS1-3", parseTreeIterator.next().getLabel());

        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-1"));
        parseTreeIterator = parseTree.traverse(traversalStrategy);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS1-2", parseTreeIterator.next().getLabel());
        assertEquals("POS1-3", parseTreeIterator.next().getLabel());
        assertEquals("POS2-1", parseTreeIterator.next().getLabel());

        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-2"));
        parseTreeIterator = parseTree.traverse(traversalStrategy);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS1-2", parseTreeIterator.next().getLabel());
        assertEquals("POS1-3", parseTreeIterator.next().getLabel());
        assertEquals("POS2-1", parseTreeIterator.next().getLabel());
        assertEquals("POS2-2", parseTreeIterator.next().getLabel());

        parseTreeIterator = parseTree.getChild(0).traverse(traversalStrategy);
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS2-1", parseTreeIterator.next().getLabel());
        assertEquals("POS2-2", parseTreeIterator.next().getLabel());
    }

    @Test
    public void testIsLeaf() throws Exception {
        ParseTree parseTree = new ParseTreeImpl("ROOT");
        assertTrue(parseTree.isLeaf());
        parseTree.setChild(new ParseTreeImpl("POS1-1"));
        parseTree.setChild(new ParseTreeImpl("POS1-2"));
        assertFalse(parseTree.isLeaf());
        assertTrue(parseTree.getChild(0).isLeaf());
        assertTrue(parseTree.getChild(1).isLeaf());

        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-1"));
        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-1"));
        assertFalse(parseTree.isLeaf());
        assertFalse(parseTree.getChild(0).isLeaf());
        assertTrue(parseTree.getChild(1).isLeaf());
        assertTrue(parseTree.getChild(0).getChild(0).isLeaf());
        assertTrue(parseTree.getChild(0).getChild(1).isLeaf());
    }

    @Test
    public void testTotalNode() throws Exception {
        ParseTree parseTree = new ParseTreeImpl("ROOT");
        assertEquals(1, parseTree.totalNode());

        parseTree.setChild(new ParseTreeImpl("POS1-1"));
        assertEquals(2, parseTree.totalNode());
        assertEquals(1, parseTree.getChild(0).totalNode());

        parseTree.setChild(new ParseTreeImpl("POS1-2"));
        assertEquals(3, parseTree.totalNode());
        assertEquals(1, parseTree.getChild(0).totalNode());
        assertEquals(1, parseTree.getChild(0).totalNode());

        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-1"));
        assertEquals(4, parseTree.totalNode());
        assertEquals(2, parseTree.getChild(0).totalNode());
        assertEquals(1, parseTree.getChild(1).totalNode());
        assertEquals(1, parseTree.getChild(0).getChild(0).totalNode());

        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-2"));
        assertEquals(5, parseTree.totalNode());
        assertEquals(3, parseTree.getChild(0).totalNode());
        assertEquals(1, parseTree.getChild(1).totalNode());
        assertEquals(1, parseTree.getChild(0).getChild(0).totalNode());
        assertEquals(1, parseTree.getChild(0).getChild(1).totalNode());
    }

    @Test
    public void testGetHeight() throws Exception {
        ParseTree parseTree = new ParseTreeImpl("ROOT");
        assertEquals(1, parseTree.getHeight());

        parseTree.setChild(new ParseTreeImpl("POS1-1"));
        assertEquals(2, parseTree.getHeight());
        assertEquals(1, parseTree.getChild(0).getHeight());

        parseTree.setChild(new ParseTreeImpl("POS1-2"));
        assertEquals(2, parseTree.getHeight());
        assertEquals(1, parseTree.getChild(0).getHeight());
        assertEquals(1, parseTree.getChild(1).getHeight());

        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-1"));
        assertEquals(3, parseTree.getHeight());
        assertEquals(2, parseTree.getChild(0).getHeight());
        assertEquals(1, parseTree.getChild(1).getHeight());
        assertEquals(1, parseTree.getChild(0).getChild(0).getHeight());
    }
}