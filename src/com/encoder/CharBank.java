package com.encoder;

import java.util.HashMap;
import java.util.Map;

/**
 * Stores characters to be used in encoding, and decodes or encodes them.
 */
public class CharBank {
    private final int offsetIndex;
    private final char[] chars = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', '(', ')', '*', '+', ',', '-', '.', '/'
    };
    private final Map<Character, Integer> charTable = new HashMap<>();

    /**
     * Instantiates a new Char bank.
     *
     * @param c the character to be used as an offset
     */
    public CharBank(char c) {
        initCharTable();
        this.offsetIndex = toIndex(c);
    }

    /**
     * Decodes character.
     *
     * @param c the c to decode
     * @return the char decoded
     */
    protected char decode(char c) {
        return getChar(c, offsetIndex);
    }

    /**
     * Encodes character.
     *
     * @param c the c tp encode
     * @return the char encoded
     */
    protected char encode(char c) {
        return getChar(c, -offsetIndex);
    }

    private void initCharTable() {
        for (int i = 0; i < chars.length; i++) {
            charTable.put(chars[i], i);
        }
    }

    private boolean isEncoded(char c) {
        return charTable.containsKey(c);
    }

    private int toIndex(char c) {
        return charTable.get(c);
    }

    private char toChar(int i) {
        if (i < 0) {
            i += chars.length;
        }

        if (i > chars.length - 1) {
            i -= chars.length;
        }

        return chars[i];
    }

    private char getChar(char c, int offset) {
        if (!isEncoded(c)) {
            return c;
        }

        int i = toIndex(c) + offset;
        return toChar(i);
    }
}
