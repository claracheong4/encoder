import com.encoder.CharBank;
import com.encoder.Decoder;
import com.encoder.Encoder;
import com.encoder.IDecoder;
import com.encoder.IEncoder;

public class Main {
    private static void test(char offset, String input) {
        input = input.toUpperCase();

        CharBank charBank = new CharBank(offset);
        IEncoder encoder = new Encoder(charBank);
        IDecoder decoder = new Decoder(charBank);
        String output;

        System.out.println("Encoding with " + offset);
        output = encoder.encode(input);
        System.out.printf("\"%s\" -> \"%s\"\n\n", input, output);

        System.out.println("Decoding with " + offset);
        input = output;
        output = decoder.decode(input);
        System.out.printf("\"%s\" -> \"%s\"\n\n", input, output);
    }

    public static void main(String[] args) {
        test('B', "Hello World");
//        Encoding with B
//        "HELLO WORLD" -> "GDKKN VNQKC"
//
//        Decoding with B
//        "GDKKN VNQKC" -> "HELLO WORLD"

        test('F', "Hello World");
//        Encoding with F
//        "HELLO WORLD" -> "C/GGJ RJMG."
//
//        Decoding with F
//        "C/GGJ RJMG." -> "HELLO WORLD"

        test('B', "abcdefghijklmnopqrstuvwxyz0123456789()*,-./` ?");
//        Encoding with B
//        "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*,-./` ?" ->
//        "/ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()+,-.` ?"
//
//        Decoding with B
//        "/ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()+,-.` ?" ->
//        "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*,-./` ?"

        test('F', "abcdefghijklmnopqrstuvwxyz0123456789()*,-./` ?");
//        Encoding with F
//        "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*,-./` ?" -> "+,-
//        ./ABCDEFGHIJKLMNOPQRSTUVWXYZ012345679()*` ?"
//
//        Decoding with F
//        "+,-./ABCDEFGHIJKLMNOPQRSTUVWXYZ012345679()*` ?" ->
//        "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*,-./` ?"
    }
}
