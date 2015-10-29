package com.github.sakaizawa.ParseTree;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by sakaisawayuya on 2015/10/28.
 */
public class StackConverterImplTest {

    @Test
    public void testString2Stack() throws Exception {
        String sentence = "(ROOT(FRAG(ADJP(RB often)(JJ hilarious))(. .)))";
        StackConverterImpl stackConverter = new StackConverterImpl();
        Stack<String> stack = stackConverter.string2Stack(sentence);
        assertEquals("(", stack.pop());
        assertEquals("ROOT", stack.pop());
        assertEquals("(", stack.pop());
        assertEquals("FRAG", stack.pop());
        assertEquals("(", stack.pop());
        assertEquals("ADJP", stack.pop());
        assertEquals("(", stack.pop());
        assertEquals("RB", stack.pop());
        assertEquals(" ", stack.pop());
        assertEquals("often", stack.pop());
        assertEquals(")", stack.pop());
        assertEquals("(", stack.pop());
        assertEquals("JJ", stack.pop());
        assertEquals(" ", stack.pop());
        assertEquals("hilarious", stack.pop());
        assertEquals(")", stack.pop());
        assertEquals(")", stack.pop());
        assertEquals("(", stack.pop());
        assertEquals(".", stack.pop());
        assertEquals(" ", stack.pop());
        assertEquals(".", stack.pop());
        assertEquals(")", stack.pop());
        assertEquals(")", stack.pop());
        assertEquals(")", stack.pop());
    }
}