package decryptors;

public interface CeasarDecryptor {
    String decrypt(String userInputForDecrypt, String alphabetDependency);

    void printDecryptedResult();
}
