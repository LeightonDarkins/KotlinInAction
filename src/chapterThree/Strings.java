package chapterThree;

import strings.*;
import java.util.ArrayList;

class Strings {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("test");
        strings.add("test");
        strings.add("test");

        System.out.println(StringFunctions.joinToString(strings, ";", "+", "+"));

        char c = StringFunctions.firstChar("test");

        System.out.println(c);
    }
}



