import java.util.Arrays;
import java.util.List;

public class AtbashCipher implements Cryptor {
    private String crypted = "";
    private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String[] cryptoAlphabet = new String[26];
    private List<String> cryptedMessage;

    @Override
    public String crypt(String userInputForCrypt) {

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

    }
}
