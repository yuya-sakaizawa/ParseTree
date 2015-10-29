package com.github.sakaizawa.ParseTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sakaisawayuya on 2015/10/26.
 */
public class DepthFirstTreeIterator
    implements Iterator<ParseTree> {

    private List<ParseTree> parseTreeList;

    public DepthFirstTreeIterator (ParseTree parseTree) {
        parseTreeList = new ArrayList<ParseTree>();
        buildList(parseTree);
    }

    private void buildList (ParseTree parseTree) {
        parseTreeList.add(parseTree);
        ArrayList<ParseTree> children = (ArrayList<ParseTree>) parseTree.getChildren();
        for (ParseTree child : children) {
            buildList(child);
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
