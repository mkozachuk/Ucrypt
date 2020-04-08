package encryptors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MorseCode implements Cryptor {

    private String crypted = "";
    private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String[] cryptoAlphabet = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
    "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
    "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    private int[] numbers = {1,2,3,4,5,6,7,8,9,0};
    //TODO add numbers to crypt
    private String[] morseNumbers = {".----", "..---", "...--", "....-", ".....", "-....", "--...",
    "---..", "----.", "-----"};
    private List<String> cryptedMessage;

    @Override
    public String crypt(String userInputForCrypt) {
        cryptedMessage = new ArrayList<String>();
        char[] userInputChars = userInputForCrypt.toCharArray();
        for(int i = 0; i < userInputForCrypt.length(); i++){
            cryptedMessage.add(String.valueOf(userInputChars[i]));
            if(!cryptedMessage.get(i).equals(" ")) {
                int ind = Arrays.asList(alphabet).indexOf(cryptedMessage.get(i));
                cryptedMessage.set(i, cryptoAlphabet[ind]);
            }
        }

        for(String letters : cryptedMessage) {
            crypted += letters + " ";
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
    public void printAlphabet() {
        for(int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i] + " -> " + cryptoAlphabet[i]);
        }
    }

    public String[] getCryptoAlphabet() {
        return cryptoAlphabet;
    }

    public String[] getAlphabet() {
        return alphabet;
    }
}
