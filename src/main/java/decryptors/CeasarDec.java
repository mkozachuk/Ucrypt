package decryptors;

import encryptors.CaesarCipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CeasarDec implements CeasarDecryptor {

    private CaesarCipher cipher = new CaesarCipher();

    private List <String> decryptedMessage;

    public String decrypted ="";

    private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};


    private String [] cryptoAlphabet = cipher.getCryptoAlphabet();
    

    public String decrypt(String userInputForDecrypt, String alphabetDependency) {
        decryptedMessage = new ArrayList<String>();
        char[] userInputChars = userInputForDecrypt.toCharArray();
        cipher.createNewCryptAlphabet(alphabetDependency);
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


    public void printDecryptedResult() {
        if(!decrypted.isEmpty() && !decrypted.equals("")) {
            System.out.println(decrypted);
        }
    }

    public void setDecrypted(String decrypted) {
        this.decrypted = decrypted;
    }
}
