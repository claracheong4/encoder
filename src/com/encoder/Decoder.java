package com.encoder;

/**
 * Decodes strings.
 */
public class Decoder implements IDecoder {
    private final IConverter converter;

    /**
     * Instantiates a new Decoder.
     *
     * @param charBank the char bank
     */
    public Decoder(CharBank charBank) {
        this.converter = new Converter(charBank::decode);
    }

    @Override
    public String decode(String encodedText) {
        return converter.convert(encodedText);
    }
}
