import java.util.Arrays;
import java.util.List;

public class VigenereCipher implements Cryptor {

    private String secretKey;
    private String crypted = "";
    private String[][] tabulaRecta;
    private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private int uniqueAlphabetLetters = 26;
    private String[] cryptoAlphabet = new String[26];
    //private List<String> cryptedMessage;
    private char[] encryptedMessage;

    @Override
    public String crypt(String userInputForCrypt) {
        String correctUserInput = userInputForCrypt.toUpperCase().replaceAll(" ", "");
        int userInputLength = correctUserInput.length();
        int secretKeyLength = getSecretKey().length();
        char[] longKey = new char[userInputLength];
        StringBuilder longKeyString = new StringBuilder();
        encryptedMessage = new char[userInputLength];

        char userInputChar;
        char secretKeyChar;
        String encryptedChat;

        int u;
        int s;
        int e;


        for (int i = 0; i < userInputLength/secretKeyLength + 1; i++ ) {
           longKeyString.append(getSecretKey());
        }

        for(int i = 0; i < longKey.length; i++){
            longKey[i] = longKeyString.charAt(i);
        }

        for (int i = 0; i < userInputLength; i++){
            userInputChar = userInputForCrypt.charAt(i);
            secretKeyChar = longKey[i];
            u = Arrays.asList(tabulaRecta).indexOf(userInputChar);
            s = Arrays.asList(tabulaRecta).indexOf(secretKeyChar);
            encryptedChat = tabulaRecta[u][s];
        }


        System.out.println(correctUserInput);
        return null;
    }

    @Override
    public void printCryptedResult() {

    }

    @Override
    public void createNewCryptAlphabet(String alphabetDependency) {

    }


    @Override
    public void printAlphabet() {
        System.out.println("Tabula Recta: ");
        for(int i = 0; i < tabulaRecta.length; i++) {
            System.out.println(Arrays.toString(tabulaRecta[i]));
        }
    }

    public void createTabulaRecta(){
        tabulaRecta = new String[26][26];
        for (int i = 0; i < uniqueAlphabetLetters; i++){
            for (int j = 0; j < uniqueAlphabetLetters; j++){
                tabulaRecta[i][j] = alphabet[j + i];
            }
        }

    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String[][] getTabulaRecta() {
        return tabulaRecta;
    }
}
