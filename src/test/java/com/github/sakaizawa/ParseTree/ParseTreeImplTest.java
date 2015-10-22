package com.github.sakaizawa.ParseTree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sakaisawayuya on 2015/10/22.
 */
public class ParseTreeImplTest {

    @Test
    public void testTraverse() throws Exception {

    }

    // ただ追加して確認しているだけだけどこれでいいのか？
    // ParseTree のコンストラクタでchildren の初期化も済ませているのでこの設計の場合 null の場合は考えなくてよい？
    @Test
    public void testIsLeaf() throws Exception {
        ParseTree parseTreeNull = new ParseTreeImpl(null);
        assertTrue(parseTreeNull.isLeaf());

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

    // 上と同じ疑問に加えて、間違えている場合も考えるべき？ totalNode = 2 の時に False(3 == totalNode など)
    @Test
    public void testTotalNode() throws Exception {
        ParseTree parseTreeNull = new ParseTreeImpl(null);
        assertEquals(1, parseTreeNull);

        ParseTree parseTree = new ParseTreeImpl("ROOT");
        assertEquals(1, parseTree.totalNode());
        parseTree.setChild(new ParseTreeImpl("POS1-1"));
        assertEquals(2, parseTree.totalNode());
        parseTree.setChild(new ParseTreeImpl("POS1-2"));
        assertEquals(3, parseTree.totalNode());
        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-1"));
        assertEquals(4, parseTree.totalNode());
        parseTree.getChild(0).setChild(new ParseTreeImpl("POS2-2"));
        assertEquals(5, parseTree.totalNode());
    }

    @Test
    public void testGetHeight() throws Exception {

    }
}