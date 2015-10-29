package com.github.sakaizawa.ParseTree;

import java.util.Stack;

/**
 * Created by sakaisawayuya on 2015/10/28.
 */
public class ParseTreeConverterImpl
    implements ParseTreeConverter{

    public ParseTreeConverterImpl () {
    }

    /**
     * parseTree を構築する
     * @param sentence 入れ子になっている文字列
     * @return parseTree
     */
    public ParseTree buildParseTree(String sentence) {
        Stack<String> stack = new StackConverterImpl().string2Stack(sentence);
        ParseTree parseTree = buildParseTree(stack);
        return parseTree;
    }

    /**
     * parseTree を構築する
     * @param formula stack に入った文字列
     * @return parseTree
     */
    public ParseTree buildParseTree(Stack<String> formula) {
        ParseTree parseTree = new ParseTreeImpl("");
        String label = "";
        int flag = 0;
        while (!formula.empty()) {
            label = formula.pop();
            if (label.equals("(")) {
                parseTree.addNode(new ParseTreeImpl(""));
                flag = 1;
                continue;
            } else if (label.equals(" ")) {
                parseTree.addNode(new ParseTreeImpl(""));
                parseTree = parseTree.getChild(parseTree.getChildren().size()-1);
                flag = 2;
                continue;
            } else if (label.equals(")")) {
                if (parseTree.isROOT()) {
                    break;
                }
                parseTree = parseTree.getParent();
                continue;
            } else if (flag == 1) {
                parseTree.getChild(parseTree.getChildren().size() - 1).setLabel(label);
                parseTree = parseTree.getChild(parseTree.getChildren().size()-1);
                flag = 0;
                continue;
            } else if (flag == 2) {
                parseTree.setLabel(label);
                flag = 0;
                parseTree = parseTree.getParent();
                continue;
            }
        }
        parseTree = parseTree.getChild(0);
        parseTree.setParent(null);
        return parseTree;
    }
}
