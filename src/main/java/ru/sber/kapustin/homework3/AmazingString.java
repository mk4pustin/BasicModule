package ru.sber.kapustin.homework3;

import java.util.ArrayList;

public class AmazingString {
    private char[] string;

    public AmazingString(char[] string) {
        this.string = string;
    }

    public AmazingString(String string) {
        this.string = new char[string.length()];
        fillArray(string);
    }

    private void fillArray(String string) {
        for (var index = 0; index < string.length(); index++) {
            this.string[index] = string.charAt(index);
        }
    }

    public int length() {
        return string.length;
    }

    public void print() {
        for (var ch : string) {
            System.out.print(ch);
        }

        System.out.println();
    }

    public char get(int i) {
        return string[i];
    }

    public boolean contains(char[] substring) {
        checkingSubstringFromEachChar:
        for (var index = 0; index < string.length - substring.length; index++) {
            for (var subIndex = 0; subIndex < substring.length; subIndex++) {
                if (string[index + subIndex] != substring[subIndex]) {
                    continue checkingSubstringFromEachChar;
                }
            }
            return true;
        }

        return false;
    }

    public boolean contains(String substring) {
        checkingSubstringFromEachChar:
        for (var index = 0; index < string.length - substring.length(); index++) {
            for (var subIndex = 0; subIndex < substring.length(); subIndex++) {
                if (string[index + subIndex] != substring.charAt(subIndex)) {
                    continue checkingSubstringFromEachChar;
                }
            }
            return true;
        }

        return false;
    }

    public void removeSpaces() {
        var spacesIndices = new ArrayList<Integer>();
        for (var index = 0; index < string.length; index++) {
            if (string[index] == ' ') {
                spacesIndices.add(index);
            }
        }

        var newString = new char[string.length - spacesIndices.size()];
        var fillableNewStringIndex = 0;
        var oldStringIndex = 0;

        while(fillableNewStringIndex < newString.length) {
            if (spacesIndices.size() == 0) {
                for (; fillableNewStringIndex < newString.length; fillableNewStringIndex++, oldStringIndex++) {
                    newString[fillableNewStringIndex] = string[oldStringIndex];
                }
                break;
            }

            switch (Integer.compare(oldStringIndex, spacesIndices.get(0))) {
                case -1 -> newString[fillableNewStringIndex++] = string[oldStringIndex];
                case 0 -> spacesIndices.remove(0);
            }

            oldStringIndex++;
        }

        string = newString;
    }

    public void reverse() {
        var swapIndex = string.length - 1;
        var temp = string[0];

        for (var index = 0; index < string.length / 2; index++, swapIndex--) {
            string[index] = string[swapIndex];
            string[swapIndex] = temp;
            temp = string[index + 1];
        }
    }
}
