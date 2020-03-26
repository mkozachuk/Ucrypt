import java.util.Arrays;
import java.util.List;

public class VigenereCipher implements Cryptor {

    private String secretKey;
    private String crypted = "";
    private String[][] tabulaRecta;
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

    public void createTabulaRecta(){
        tabulaRecta = new String[26][26];
        for (int i = 0; i < alphabet.length; i++){
            for (int j = 0; j < tabulaRecta[i].length; j++){
                tabulaRecta[i][j] = alphabet[j];
            }
        }

        for(int i = 0; i < tabulaRecta.length; i++) {
            System.out.println(Arrays.toString(tabulaRecta[i]));
        }
    }

    public static int[] shiftLeft(int[] a, int shift) {
        if (a != null) {
            int length = a.length;
            int[] b = new int[length];
            // шаг 1
            System.arraycopy(a, shift, b, 0, length - shift);
            // шаг 2
            System.arraycopy(a, 0, b, length - shift, shift);
            return b;
        } else {
            return null;
        }
    }
}
