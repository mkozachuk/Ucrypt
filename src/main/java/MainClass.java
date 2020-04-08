import decryptors.*;
import encryptors.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pgp.RSAKeyPairGenerator;

import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) throws Exception {

       //RSAKeyPairGenerator mykpg = new RSAKeyPairGenerator();

        Security.addProvider(new BouncyCastleProvider());

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", "BC");

        kpg.initialize(1024);

        KeyPair kp = kpg.generateKeyPair();

//        if (args.length < 2) {
//            System.out.println("RSAKeyPairGenerator [-a] identity passPhrase");
//            System.exit(0);
//        }

//        if (args[0].equals("-a")) {
//            if (args.length < 3) {
//                System.out.println("RSAKeyPairGenerator [-a] identity passPhrase");
//                System.exit(0);
//            }


        String arg1 = "-a";
        String arg2 = "Pass";

            FileOutputStream out1 = new FileOutputStream("secret.asc");
            FileOutputStream out2 = new FileOutputStream("pub.asc");

            RSAKeyPairGenerator.exportKeyPair(out1, out2, kp, arg1, arg2.toCharArray(), true);
//        } else {
//            FileOutputStream out1 = new FileOutputStream("secret.bpg");
//            FileOutputStream out2 = new FileOutputStream("pub.bpg");
//
//            RSAKeyPairGenerator.exportKeyPair(out1, out2, kp, args[0], args[1].toCharArray(), false);
//        }


        InputReader reader = new InputReader();
        String userInput = reader.getUserInputString();

        System.out.println("Hello");


        A1Z26Cipher a1Z26Cipher = new A1Z26Cipher();
        a1Z26Cipher.createNewCryptAlphabet();
        String a1z26 = a1Z26Cipher.crypt(userInput);
        System.out.println("A1Z26 : " + a1z26);


        AtbashCipher atbashCipher = new AtbashCipher();
        atbashCipher.createNewCryptAlphabet("0");
        String atbash = atbashCipher.crypt(userInput);
        System.out.println("atbash : " + atbash);

        CaesarCipher caesarCipher = new CaesarCipher();
        caesarCipher.createNewCryptAlphabet("3");
        String ceasar = caesarCipher.crypt(userInput);
        System.out.println("ceasar : " + ceasar);

        MorseCode morseCode = new MorseCode();
        String morse = morseCode.crypt(userInput);
        System.out.println("Morse : " + morse);

        VigenereCipher vigenereCipher = new VigenereCipher();
        vigenereCipher.createTabulaRecta();
        vigenereCipher.setSecretKey("ABC");
        String vigenere = vigenereCipher.crypt(userInput);
        System.out.println("Vigenere : " + vigenere);

        A1Z26Dec a1Z26Dec = new A1Z26Dec();
        System.out.println("A1Z26 : " + a1Z26Dec.decrypt(a1z26));

        AtbashDec atbashDec = new AtbashDec();
        System.out.println("Atbash : " + atbashDec.decrypt(atbash));

        CeasarDec ceasarDec = new CeasarDec();
        System.out.println("Ceasar : " + ceasarDec.decrypt(ceasar));

        MorseDec morseDec = new MorseDec();
        System.out.println("Morse : " + morseDec.decrypt(morse));

        VigenereDec vigenereDec = new VigenereDec();
        System.out.println(vigenereDec.decrypt(vigenereCipher.getSecretKey(), vigenere));

        System.out.println("END");

        System.out.println();
    }
}


