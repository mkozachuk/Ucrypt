public interface Cryptor {
    String crypt(String userInputForCrypt);
    void printCryptedResult();
    void createNewCryptAlphabet(String alphabetDependency); //Homophonic substitution cipher only
    void printAlphabet();

}
