package decryptors;

public interface DecryptorWithKey {
    String decrypt(String secretKey, String userInputForDecrypt);

    void printDecryptedResult();
}
