package com.github.sakaizawa.ParseTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by sakaisawayuya on 2015/10/26.
 */
public class BreadthFirstTreeIterator
        implements Iterator<ParseTree> {

    private List<ParseTree> parseTreeList;
    private Queue<ParseTree> queue;

    public BreadthFirstTreeIterator(ParseTree parseTree) {
        parseTreeList = new ArrayList<ParseTree>();
        queue = new ConcurrentLinkedQueue<ParseTree>();
        queue.add(parseTree);
        buildList();
    }

    private void buildList() {
        while (!queue.isEmpty()) {
            ParseTree parseTree = queue.poll();
            if (!parseTree.getChildren().isEmpty()) {
                for (int i = 0; i < parseTree.getChildren().size(); i++) {
                    queue.add(parseTree.getChild(i));
                }
            }
            parseTreeList.add(parseTree);
        }
    }

    public boolean hasNext() {
        return !parseTreeList.isEmpty();
    }

    public ParseTree next() {
        ParseTree parseTree = parseTreeList.get(0);
        parseTreeList.remove(0);
        return parseTree;
    }

    public void remove() {

    }
}
