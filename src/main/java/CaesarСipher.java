import java.util.Arrays;

public class CaesarСipher implements Cryptor {

    private String crypted;
    private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String[] cryptoAlphabet = new String[26];


    @Override
    public String crypt(String userInputForCrypt) {


        return crypted;
    }

    @Override
    public void createNewCryptAlphabet(String alphabetDependency) {
        int latterNum = 0;
        int num = 3; // Default value
        try {
            num = Integer.parseInt(alphabetDependency);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("Not number");
        }
        for(int i = 0; i < alphabet.length; i++){
            if (i <= alphabet.length - num - 1) {
                cryptoAlphabet[i] = alphabet[i + num ];
            }
            else if(cryptoAlphabet[i - latterNum - 1].equals("Z")){
                    cryptoAlphabet[i] = alphabet[latterNum];
                    latterNum++;

            }
        }

//        for(int i = alphabet.length - num + 1; i <=alphabet.length; i++){
//            cryptoAlphabet[i] = alphabet[]
//        }


        System.out.println(Arrays.toString(cryptoAlphabet));

    }


    @Override
    public void printCryptedResult() {
        if(!crypted.isEmpty()) {
            System.out.println(crypted);
        }
    }




}
