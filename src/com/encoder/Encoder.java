package com.encoder;

/**
 * Encodes strings.
 */
public class Encoder implements IEncoder {
    private final IConverter converter;

    /**
     * Instantiates a new Encoder.
     *
     * @param charBank the char bank
     */
    public Encoder(CharBank charBank) {
        this.converter = new Converter(charBank::encode);
    }

    @Override
    public String encode(String plainText) {
        return converter.convert(plainText);
    }
}
