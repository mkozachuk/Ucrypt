import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
    VigenereCipher cryptor = new VigenereCipher();
//        cryptor.createNewCryptAlphabet("1");
////        cryptor.crypt("HELLO WORLD");
////        cryptor.printCryptedResult();
//
//        ((VigenereCipher) cryptor).createTabulaRecta();
//        cryptor.crypt("dawdad1 2dawda");
        cryptor.createTabulaRecta();
        String[][] tabulaRecta = cryptor.getTabulaRecta();
        int userInputLength = 10;
        char userInputChar;
        char secretKeyChar;
        int u;
        int s;
        String userInputForCrypt = "ATTACKATDA";
        char[] longKey = new char[10];
        String longKeyString = "LEMONLEMON";
        for(int i = 0; i < longKey.length; i++){
            longKey[i] = longKeyString.charAt(i);
        }
        String encryptedChat = "";



        for (int i = 0; i < userInputLength; i++){
            userInputChar = userInputForCrypt.charAt(i);
            secretKeyChar = longKey[i];
            u = Arrays.asList(tabulaRecta[0]).indexOf(String.valueOf(userInputChar));
            s = Arrays.asList(tabulaRecta[0]).indexOf(String.valueOf(secretKeyChar));
            encryptedChat = tabulaRecta[u][s];
//            System.out.println(" U " + u);
//            System.out.println(" S " + s);

            System.out.print(encryptedChat);
        }
        System.out.print(encryptedChat);
    }
}
