package ru.sber.kapustin.homework2.part1.additional1;

import java.util.Arrays;
import java.util.Random;

public class PasswordGenerator {
    public static final int MIN_PASSWORD_LENGTH = 8;

    private static final char[] SPECIAL_SYMBOLS = {'_', '*', '-'};

    private static final int UPPERCASE_A_CODE = 'A';
    private static final int ALPHABET_LETTERS_COUNT = 25;
    private static final int MAX_NUMBER = 9;
    private static final int CHARACTER_TYPES = 4;

    public static String createPassword(int passwordLength) {
        if (passwordLength < MIN_PASSWORD_LENGTH) {
            throw new IllegalArgumentException();
        }

        final var typeCounts = new int[]{0, 0, 0, 0};
        var maxNumberSameTypeChars = determinateCurrentMax(passwordLength, typeCounts);

        final var sb = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            addNextChar(sb, maxNumberSameTypeChars, typeCounts);
            maxNumberSameTypeChars = determinateCurrentMax(passwordLength, typeCounts);
        }

        return sb.toString();
    }

    private static void addNextChar(StringBuilder sb, int maxCount, int[] typeCounts) {
        final var random = new Random();

        final var curLength = sb.length();
        var type = 0;

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
        var notMetTypes = 0;
        var charsLeft = passLength;

        for (var count : typeCounts) {
            if (count > 0) {
                charsLeft -= count;
            } else {
                notMetTypes++;
            }
        }

        return charsLeft == notMetTypes? 1 : passLength - (CHARACTER_TYPES - 1);
    }
}
