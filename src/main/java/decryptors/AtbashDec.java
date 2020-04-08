package decryptors;

import encryptors.AtbashCipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AtbashDec implements Decryptor {

    AtbashCipher cipher = new AtbashCipher();

    private List<String> decryptedMessage;

    public String decrypted ="";

    String [] alphabet = cipher.getAlphabet();
    String[] cryptoAlphabet = cipher.getCryptoAlphabet();

    @Override
    public String decrypt(String userInputForDecrypt) {
        decryptedMessage = new ArrayList<String>();
        char[] userInputChars = userInputForDecrypt.toCharArray();
        cipher.createNewCryptAlphabet("3");
        for(int i = 0; i <userInputForDecrypt.length(); i++){
            decryptedMessage.add(String.valueOf(userInputChars[i]));
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
