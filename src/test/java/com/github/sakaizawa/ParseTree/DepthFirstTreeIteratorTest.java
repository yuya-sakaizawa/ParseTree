package com.github.sakaizawa.ParseTree;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by sakaisawayuya on 2015/10/28.
 */
public class DepthFirstTreeIteratorTest {

    @Test
    public void testHasNext() throws Exception {
        ParseTree parseTree = new ParseTreeImpl("ROOT");
        DepthFirstTreeIterator parseTreeIterator = new DepthFirstTreeIterator(parseTree);
        assertTrue(parseTreeIterator.hasNext());
        parseTreeIterator.next();
        assertFalse(parseTreeIterator.hasNext());

        parseTree.setChild(new ParseTreeImpl("POS1-1"));
        parseTreeIterator = new DepthFirstTreeIterator(parseTree);
        assertTrue(parseTreeIterator.hasNext());
        parseTreeIterator.next();
        assertTrue(parseTreeIterator.hasNext());
        parseTreeIterator.next();
        assertFalse(parseTreeIterator.hasNext());

        parseTree.setChild(new ParseTreeImpl("POS1-2"));
        parseTreeIterator = new DepthFirstTreeIterator(parseTree);
        assertTrue(parseTreeIterator.hasNext());
        parseTreeIterator.next();
        assertTrue(parseTreeIterator.hasNext());
        parseTreeIterator.next();
        assertTrue(parseTreeIterator.hasNext());
        parseTreeIterator.next();
        assertFalse(parseTreeIterator.hasNext());

        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-1"));
        parseTreeIterator = new DepthFirstTreeIterator(parseTree);
        assertTrue(parseTreeIterator.hasNext());
        parseTreeIterator.next();
        assertTrue(parseTreeIterator.hasNext());
        parseTreeIterator.next();
        assertTrue(parseTreeIterator.hasNext());
        parseTreeIterator.next();
        assertTrue(parseTreeIterator.hasNext());
        parseTreeIterator.next();
        assertFalse(parseTreeIterator.hasNext());
    }

    @Test
    public void testNext() throws Exception {
        ParseTree parseTree = new ParseTreeImpl("ROOT");
        DepthFirstTreeIterator parseTreeIterator = new DepthFirstTreeIterator(parseTree);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());

        parseTree.setChild(new ParseTreeImpl("POS1-1"));
        parseTreeIterator = new DepthFirstTreeIterator(parseTree);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());

        parseTree.setChild(new ParseTreeImpl("POS1-2"));
        parseTreeIterator = new DepthFirstTreeIterator(parseTree);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS1-2", parseTreeIterator.next().getLabel());

        parseTree.setChild(new ParseTreeImpl("POS1-3"));
        parseTreeIterator = new DepthFirstTreeIterator(parseTree);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS1-2", parseTreeIterator.next().getLabel());
        assertEquals("POS1-3", parseTreeIterator.next().getLabel());

        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-1"));
        parseTreeIterator = new DepthFirstTreeIterator(parseTree);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS2-1", parseTreeIterator.next().getLabel());
        assertEquals("POS1-2", parseTreeIterator.next().getLabel());
        assertEquals("POS1-3", parseTreeIterator.next().getLabel());

        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-2"));
        parseTreeIterator = new DepthFirstTreeIterator(parseTree);
        assertEquals("ROOT", parseTreeIterator.next().getLabel());
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS2-1", parseTreeIterator.next().getLabel());
        assertEquals("POS2-2", parseTreeIterator.next().getLabel());
        assertEquals("POS1-2", parseTreeIterator.next().getLabel());
        assertEquals("POS1-3", parseTreeIterator.next().getLabel());

        parseTreeIterator = new DepthFirstTreeIterator(parseTree.getChild(0));
        assertEquals("POS1-1", parseTreeIterator.next().getLabel());
        assertEquals("POS2-1", parseTreeIterator.next().getLabel());
        assertEquals("POS2-2", parseTreeIterator.next().getLabel());
    }
}