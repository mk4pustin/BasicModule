package ru.sber.kapustin.homework2.part1.additional1;

import java.util.Random;

public class PasswordGenerator {
    private static final char[] SPECIAL_SYMBOLS = {'_', '*', '-'};

    private static final int UPPERCASE_A_CODE = 'A';
    private static final int ALPHABET_LETTERS_COUNT = 25;
    private static final int MAX_NUMBER = 9;
    private static final int CHARACTER_TYPES = 4;

    public static String createPassword(int passwordLength) {
        if (passwordLength < 8) {
            throw new IllegalArgumentException();
        }

        int[] typeCounts = {0, 0, 0, 0};
        int maxNumberSameTypeChars = determinateCurrentMax(passwordLength, typeCounts);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            addNextChar(sb, maxNumberSameTypeChars, typeCounts);
            maxNumberSameTypeChars = determinateCurrentMax(passwordLength, typeCounts);
        }

        return sb.toString();
    }

    private static void addNextChar(StringBuilder sb, int maxCount, int[] typeCounts) {
        Random random = new Random();

        int curLength = sb.length(), type = 0;
        while (curLength == sb.length()) {
            type = random.nextInt(CHARACTER_TYPES);
            if (typeCounts[type] >= maxCount) {
                continue;
            }

            switch (type) {
                case 0 -> sb.append(SPECIAL_SYMBOLS[random.nextInt(SPECIAL_SYMBOLS.length)]);
                case 1 -> sb.append((char) (UPPERCASE_A_CODE + random.nextInt(ALPHABET_LETTERS_COUNT)));
                case 2 -> sb.append(Character.toLowerCase((char) (UPPERCASE_A_CODE +
                        random.nextInt(ALPHABET_LETTERS_COUNT))));
                case 3 -> sb.append(random.nextInt(MAX_NUMBER + 1));
            }
        }

        typeCounts[type]++;
    }

    private static int determinateCurrentMax(int passLength, int[] typeCounts) {
        int maxTypesCount = 0, notMetTypes = 0, charsLeft = passLength;

        for (int count : typeCounts) {
            if (count > 0) {
                charsLeft -= count;

                if (count > maxTypesCount) {
                    maxTypesCount = count;
                }
            } else {
                notMetTypes++;
            }
        }

        if (notMetTypes == 4) {
            return passLength - (notMetTypes - 1);
        }

        return charsLeft == notMetTypes? 1 : maxTypesCount + (charsLeft - notMetTypes);
    }
}
