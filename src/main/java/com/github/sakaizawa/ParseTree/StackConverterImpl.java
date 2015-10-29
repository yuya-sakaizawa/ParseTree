package com.github.sakaizawa.ParseTree;

import java.util.Stack;

/**
 * Created by sakaisawayuya on 2015/10/28.
 */
public class StackConverterImpl
    implements StackConverter{

    public StackConverterImpl () {
    }

    /**
     * 入れ子になった文字列を separate して stack に入れる
     * @param formula 入れ子になっている文字列
     * @return stack
     */
    public Stack<String> string2Stack(String formula) {
        Stack<String> stack = new Stack<String>();
        Character character = null;
        String label = "";
        for (int i = formula.length()-1; i > -1; i--) {
            character = formula.charAt(i);
            if (character.equals('(') || character.equals(')')) {
                if (!label.isEmpty()) {
                    stack.push(reverseString(label));
                    label = "";
                }
                stack.push(character.toString());
            } else if (character.equals(' ')) {
                stack.push(reverseString(label));
                stack.push(character.toString());
                label = "";
            } else {
                label += character.toString();
            }
        }
        return stack;
    }

    /**
     * 受け取った文字列を逆順にして返す
     * @param label 文字列
     * @return labelを逆順にした文字列
     */
    private String reverseString(String label) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = label.length()-1; i > -1; i--) {
            stringBuffer.append(label.charAt(i));
        }
        return stringBuffer.toString();
    }
}
