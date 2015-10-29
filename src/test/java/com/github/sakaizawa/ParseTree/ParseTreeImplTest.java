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
        TraversalStrategy traversalStrategyDepth = TraversalStrategy.DEPTH;
        TraversalStrategy traversalStrategyBreadth = TraversalStrategy.BREADTH;
        ParseTree parseTree = new ParseTreeImpl("ROOT");
        Iterator<ParseTree> DepthIterator = parseTree.traverse(traversalStrategyDepth);
        Iterator<ParseTree> BreadthIterator = parseTree.traverse(traversalStrategyBreadth);
        assertEquals("ROOT", DepthIterator.next().getLabel());
        assertEquals("ROOT", BreadthIterator.next().getLabel());

        parseTree.addNode(new ParseTreeImpl("POS1-1"));
        DepthIterator = parseTree.traverse(traversalStrategyDepth);
        BreadthIterator = parseTree.traverse(traversalStrategyBreadth);
        assertEquals("ROOT", DepthIterator.next().getLabel());
        assertEquals("POS1-1", DepthIterator.next().getLabel());
        assertEquals("ROOT", BreadthIterator.next().getLabel());
        assertEquals("POS1-1", BreadthIterator.next().getLabel());

        parseTree.addNode(new ParseTreeImpl("POS1-2"));
        DepthIterator = parseTree.traverse(traversalStrategyDepth);
        BreadthIterator = parseTree.traverse(traversalStrategyBreadth);
        assertEquals("ROOT", DepthIterator.next().getLabel());
        assertEquals("POS1-1", DepthIterator.next().getLabel());
        assertEquals("POS1-2", DepthIterator.next().getLabel());
        assertEquals("ROOT", BreadthIterator.next().getLabel());
        assertEquals("POS1-1", BreadthIterator.next().getLabel());
        assertEquals("POS1-2", BreadthIterator.next().getLabel());

        parseTree.getChild(0).addNode(new ParseTreeImpl("POS2-1"));
        DepthIterator = parseTree.traverse(traversalStrategyDepth);
        BreadthIterator = parseTree.traverse(traversalStrategyBreadth);
        assertEquals("ROOT", DepthIterator.next().getLabel());
        assertEquals("POS1-1", DepthIterator.next().getLabel());
        assertEquals("POS2-1", DepthIterator.next().getLabel());
        assertEquals("POS1-2", DepthIterator.next().getLabel());
        assertEquals("ROOT", BreadthIterator.next().getLabel());
        assertEquals("POS1-1", BreadthIterator.next().getLabel());
        assertEquals("POS1-2", BreadthIterator.next().getLabel());
        assertEquals("POS2-1", BreadthIterator.next().getLabel());

        parseTree.getChild(0).addNode(new ParseTreeImpl("POS2-2"));
        DepthIterator = parseTree.traverse(traversalStrategyDepth);
        BreadthIterator = parseTree.traverse(traversalStrategyBreadth);
        assertEquals("ROOT", DepthIterator.next().getLabel());
        assertEquals("POS1-1", DepthIterator.next().getLabel());
        assertEquals("POS2-1", DepthIterator.next().getLabel());
        assertEquals("POS2-2", DepthIterator.next().getLabel());
        assertEquals("POS1-2", DepthIterator.next().getLabel());
        assertEquals("ROOT", BreadthIterator.next().getLabel());
        assertEquals("POS1-1", BreadthIterator.next().getLabel());
        assertEquals("POS1-2", BreadthIterator.next().getLabel());
        assertEquals("POS2-1", BreadthIterator.next().getLabel());
        assertEquals("POS2-2", BreadthIterator.next().getLabel());

        DepthIterator = parseTree.getChild(0).traverse(traversalStrategyDepth);
        BreadthIterator = parseTree.getChild(0).traverse(traversalStrategyBreadth);
        assertEquals("POS1-1", DepthIterator.next().getLabel());
        assertEquals("POS2-1", DepthIterator.next().getLabel());
        assertEquals("POS2-2", DepthIterator.next().getLabel());
        assertEquals("POS1-1", BreadthIterator.next().getLabel());
        assertEquals("POS2-1", BreadthIterator.next().getLabel());
        assertEquals("POS2-2", BreadthIterator.next().getLabel());
    }

    @Test
    public void testAddNode() throws Exception {
        ParseTree parseTree = new ParseTreeImpl("ROOT");
        parseTree.addNode(new ParseTreeImpl("POS1-1"));
        assertEquals("POS1-1", parseTree.getChild(0).getLabel());
        assertEquals("ROOT", parseTree.getChild(0).getParent().getLabel());

        parseTree.addNode(new ParseTreeImpl("POS1-2"));
        assertEquals("POS1-1", parseTree.getChild(0).getLabel());
        assertEquals("POS1-2", parseTree.getChild(1).getLabel());
        assertEquals("ROOT", parseTree.getChild(0).getParent().getLabel());
        assertEquals("ROOT", parseTree.getChild(1).getParent().getLabel());

        parseTree.getChild(0).addNode(new ParseTreeImpl("POS2-1"));
        assertEquals("POS1-1", parseTree.getChild(0).getLabel());
        assertEquals("POS1-2", parseTree.getChild(1).getLabel());
        assertEquals("POS2-1", parseTree.getChild(0).getChild(0).getLabel());
        assertEquals("ROOT", parseTree.getChild(0).getParent().getLabel());
        assertEquals("ROOT", parseTree.getChild(1).getParent().getLabel());
        assertEquals("POS1-1", parseTree.getChild(0).getChild(0).getParent().getLabel());

        parseTree.getChild(1).addNode(new ParseTreeImpl("POS2-2"));
        assertEquals("POS1-1", parseTree.getChild(0).getLabel());
        assertEquals("POS1-2", parseTree.getChild(1).getLabel());
        assertEquals("POS2-1", parseTree.getChild(0).getChild(0).getLabel());
        assertEquals("POS2-2", parseTree.getChild(1).getChild(0).getLabel());
        assertEquals("ROOT", parseTree.getChild(0).getParent().getLabel());
        assertEquals("ROOT", parseTree.getChild(1).getParent().getLabel());
        assertEquals("POS1-1", parseTree.getChild(0).getChild(0).getParent().getLabel());
        assertEquals("POS1-2", parseTree.getChild(1).getChild(0).getParent().getLabel());
    }

    @Test
    public void testIsLeaf() throws Exception {
        ParseTree parseTree = new ParseTreeImpl("ROOT");
        assertTrue(parseTree.isLeaf());
        parseTree.addNode(new ParseTreeImpl("POS1-1"));
        parseTree.addNode(new ParseTreeImpl("POS1-2"));
        assertFalse(parseTree.isLeaf());
        assertTrue(parseTree.getChild(0).isLeaf());
        assertTrue(parseTree.getChild(1).isLeaf());

        parseTree.getChild(0).addNode(new ParseTreeImpl("POS2-1"));
        parseTree.getChild(0).addNode(new ParseTreeImpl("POS2-1"));
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

        parseTree.addNode(new ParseTreeImpl("POS1-1"));
        assertEquals(2, parseTree.totalNode());
        assertEquals(1, parseTree.getChild(0).totalNode());

        parseTree.addNode(new ParseTreeImpl("POS1-2"));
        assertEquals(3, parseTree.totalNode());
        assertEquals(1, parseTree.getChild(0).totalNode());
        assertEquals(1, parseTree.getChild(0).totalNode());

        parseTree.getChild(0).addNode(new ParseTreeImpl("POS2-1"));
        assertEquals(4, parseTree.totalNode());
        assertEquals(2, parseTree.getChild(0).totalNode());
        assertEquals(1, parseTree.getChild(1).totalNode());
        assertEquals(1, parseTree.getChild(0).getChild(0).totalNode());

        parseTree.getChild(0).addNode(new ParseTreeImpl("POS2-2"));
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

        parseTree.addNode(new ParseTreeImpl("POS1-1"));
        assertEquals(2, parseTree.getHeight());
        assertEquals(1, parseTree.getChild(0).getHeight());

        parseTree.addNode(new ParseTreeImpl("POS1-2"));
        assertEquals(2, parseTree.getHeight());
        assertEquals(1, parseTree.getChild(0).getHeight());
        assertEquals(1, parseTree.getChild(1).getHeight());

        parseTree.getChild(0).addNode(new ParseTreeImpl("POS2-1"));
        assertEquals(3, parseTree.getHeight());
        assertEquals(2, parseTree.getChild(0).getHeight());
        assertEquals(1, parseTree.getChild(1).getHeight());
        assertEquals(1, parseTree.getChild(0).getChild(0).getHeight());
    }

    @Test
    public void testIsROOT() throws Exception {
        ParseTree parseTree = new ParseTreeImpl("ROOT");
        assertTrue(parseTree.isROOT());

        parseTree.addNode(new ParseTreeImpl("POS1-1"));
        assertTrue(parseTree.isROOT());
        assertFalse(parseTree.getChild(0).isROOT());

        parseTree.addNode(new ParseTreeImpl("POS1-2"));
        parseTree.getChild(0).addNode(new ParseTreeImpl("POS2-1"));
        assertTrue(parseTree.isROOT());
        assertFalse(parseTree.getChild(0).isROOT());
        assertFalse(parseTree.getChild(1).isROOT());
        assertFalse(parseTree.getChild(0).getChild(0).isROOT());
    }
}