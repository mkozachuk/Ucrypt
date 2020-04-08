package decryptors;

import encryptors.MorseCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MorseDec implements Decryptor {

    MorseCode cipher = new MorseCode();

    private List<String> decryptedMessage;

    public String decrypted ="";

    private String[] cryptoAlphabet = cipher.getCryptoAlphabet();

    private String[] alphabet = cipher.getAlphabet();

    @Override
    public String decrypt(String userInputForDecrypt) {
        decryptedMessage = new ArrayList<String>();
        char[] userInputChars = userInputForDecrypt.toCharArray();


        String[] userInput;
        String delimeter = " ";
        userInput = userInputForDecrypt.split(delimeter);


        for(int i = 0; i <userInput.length; i++){
            decryptedMessage.add(String.valueOf(userInput[i]));
            if(!decryptedMessage.get(i).equals(" ")) {
                int ind = Arrays.asList(cryptoAlphabet).indexOf(decryptedMessage.get(i));
                decryptedMessage.set(i, alphabet[ind]);
            }
        }

        for(String letters : decryptedMessage) {
            decrypted += letters;

        }

        return decrypted;
    }

    @Override
    public void printDecryptedResult() {

    }
}
