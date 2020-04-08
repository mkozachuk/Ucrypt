package encryptors;

public interface HomophonicCryptor extends Cryptor {
    void createNewCryptAlphabet(String alphabetDependency); //Homophonic substitution cipher only
}
