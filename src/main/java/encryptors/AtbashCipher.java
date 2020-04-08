package encryptors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AtbashCipher implements HomophonicCryptor {
    private String crypted = "";
    private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String[] cryptoAlphabet = new String[26];
    private List<String> cryptedMessage;

    @Override
    public String crypt(String userInputForCrypt) {
        cryptedMessage = new ArrayList<String>();
        char[] userInputChars = userInputForCrypt.toCharArray();
        for(int i = 0; i <= userInputForCrypt.length() - 1; i++){
            cryptedMessage.add(String.valueOf(userInputChars[i]));
            if(!cryptedMessage.get(i).equals(" ")) {
                int ind = Arrays.asList(alphabet).indexOf(cryptedMessage.get(i));
                cryptedMessage.set(i, cryptoAlphabet[ind]);
            }
        }

        for(String letters : cryptedMessage) {
            crypted += letters;
        }

        return crypted;
    }

    @Override
    public void printCryptedResult() {
        if(!crypted.isEmpty() && !crypted.equals("")) {
            System.out.println(crypted);
        }
    }

    @Override
    public void createNewCryptAlphabet(String alphabetDependency) {

        for( int i = 0; i < alphabet.length; i++){
            cryptoAlphabet[i] = alphabet[alphabet.length - i - 1];
        }
    }

    @Override
    public void printAlphabet() {
        for(int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i] + " -> " + cryptoAlphabet[i]);
        }
    }

    public String[] getAlphabet() {
        return alphabet;
    }

    public String[] getCryptoAlphabet() {
        return cryptoAlphabet;
    }
}
