package decryptors;

import encryptors.A1Z26Cipher;
import encryptors.CaesarCipher;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A1Z26Dec implements Decryptor {

    private A1Z26Cipher cipher = new A1Z26Cipher();

    private List<String> decryptedMessage;

    public String decrypted = "";

    private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};


    private int[] cryptoAlphabet = cipher.getCryptoAlphabet();

    @Override
    public String decrypt(String userInputForDecrypt) {
        decryptedMessage = new ArrayList<String>();

        String[] userInput;
        String delimeter = " ";
        userInput = userInputForDecrypt.split(delimeter);

        // char[] userInputChars = userInputForDecrypt.toCharArray();
        cipher.createNewCryptAlphabet();
        for (int i = 0; i < userInput.length; i++) {
            decryptedMessage.add(String.valueOf(userInput[i]));
            if (!decryptedMessage.get(i).equals(" ")) {
                int currentIntIndex = Integer.parseInt(decryptedMessage.get(i)) - 1;
                decryptedMessage.set(i, alphabet[currentIntIndex]);
            }
        }

        for (String letters : decryptedMessage) {
            decrypted += letters;

        }
        return decrypted;
    }

    @Override
    public void printDecryptedResult() {

    }
}
