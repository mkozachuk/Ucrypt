package decryptors;

import encryptors.VigenereCipher;

import java.util.Arrays;

public class VigenereDec implements DecryptorWithKey {

    VigenereCipher cipher = new VigenereCipher();

    private String[][] tabulaRecta;

    private String decrypted = "";

    private char[] encryptedMessage;


    @Override
    public String decrypt(String secretKey, String userInputForDecrypt) {
        String correctUserInput = userInputForDecrypt.toUpperCase().replaceAll(" ", "");
        int userInputLength = correctUserInput.length();
        int secretKeyLength = secretKey.length();
        char[] longKey = new char[userInputLength];
        StringBuilder longKeyString = new StringBuilder();
        encryptedMessage = new char[userInputLength];

        char userInputChar;
        char secretKeyChar;
        String decryptedChar;

        cipher.createTabulaRecta();
        tabulaRecta = cipher.getTabulaRecta();

        int s;

        for (int i = 0; i < userInputLength / secretKeyLength + 1; i++) {
            longKeyString.append(secretKey);
        }

        for (int i = 0; i < longKey.length; i++) {
            longKey[i] = longKeyString.charAt(i);
        }

        for (int i = 0; i < userInputLength; i++) {
            userInputChar = userInputForDecrypt.charAt(i);
            secretKeyChar = longKey[i];
            s = Arrays.asList(tabulaRecta[0]).indexOf(String.valueOf(secretKeyChar));

            for (int j = 0; j < tabulaRecta.length; j++) {
                int indx = Arrays.asList(tabulaRecta[j]).indexOf(String.valueOf(userInputChar));
                if (indx == s) {
                    decryptedChar = tabulaRecta[j][0];
                    decrypted += decryptedChar;
                }
            }

        }

        return decrypted;
    }

    @Override
    public void printDecryptedResult() {

    }
}
