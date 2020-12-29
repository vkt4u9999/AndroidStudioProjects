package com.vkt4u9999.reversewords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HalfReverse {
    public static String halfReverse(String string, Character... ignoreChar) {
        char[] charArray = string.toCharArray();
        List<Character> ignoreList = Arrays.asList(ignoreChar);
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++)
            if (!Character.isDigit(charArray[i]) && !ignoreList.contains(charArray[i])) {
                charList.add(charArray[i]);
                charArray[i] = 0;
            }
        Collections.reverse(charList);
        for (int i = 0, j = 0; i < charArray.length; i++)
            if (charArray[i] == 0)
                charArray[i] = charList.get(j++);
        return new String(charArray);
    }
}
