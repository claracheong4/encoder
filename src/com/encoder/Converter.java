package com.encoder;

import java.util.function.Function;

/**
 * Converts characters.
 */
public class Converter implements IConverter {
    private final Function<Character, Character> charConverter;

    /**
     * Instantiates a new Converter.
     *
     * @param charConverter the char converter
     */
    public Converter(Function<Character, Character> charConverter) {
        this.charConverter = charConverter;
    }

    @Override
    public String convert(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char newChar = charConverter.apply(c);
            sb.append(newChar);
        }

        return sb.toString();
    }
}
