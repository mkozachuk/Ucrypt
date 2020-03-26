public class MainClass {
    public static void main(String[] args) {
    Cryptor cryptor = new MorseCode();
//        cryptor.createNewCryptAlphabet("1");
////        cryptor.crypt("HELLO WORLD");
////        cryptor.printCryptedResult();
        cryptor.printAlphabet();
        cryptor.crypt("SOS");
        cryptor.printCryptedResult();
    }
}
