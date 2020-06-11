package encryptors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaesarCipher implements HomophonicCryptor {

    private String crypted = "";
    private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};


    private String[] cryptoAlphabet = new String[26];
    private List<String> cryptedMessage;


    @Override
    public String crypt(String userInputForCrypt) {
        cryptedMessage = new ArrayList<String>();
        char[] userInputChars = userInputForCrypt.toCharArray();
        for (int i = 0; i < userInputForCrypt.length(); i++) {
            cryptedMessage.add(String.valueOf(userInputChars[i]));
            if (!cryptedMessage.get(i).equals(" ")) {
                int ind = Arrays.asList(alphabet).indexOf(cryptedMessage.get(i));
                cryptedMessage.set(i, cryptoAlphabet[ind]);
            }
        }

        for (String letters : cryptedMessage) {
            crypted += letters;
        }

        return crypted;
    }

    @Override
    public void createNewCryptAlphabet(String alphabetDependency) {
        int latterNum = 0;
        int num = 3; // Default value
        try {
            num = Integer.parseInt(alphabetDependency);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("Not number");
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (num == 26 || num == 0) {
                cryptoAlphabet = alphabet.clone();
            } else if (i <= alphabet.length - num - 1) {
                cryptoAlphabet[i] = alphabet[i + num];
            } else if (cryptoAlphabet[i - latterNum - 1].equals("Z")) {
                cryptoAlphabet[i] = alphabet[latterNum];
                latterNum++;
            }
        }

    }

    @Override
    public void printAlphabet() {
        for (int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i] + " -> " + cryptoAlphabet[i]);
        }
    }

    @Override
    public void printCryptedResult() {
        if (!crypted.isEmpty() && !crypted.equals("")) {
            System.out.println(crypted);
        }
    }

    public String[] getCryptoAlphabet() {
        return cryptoAlphabet;
    }


}
