package decryptors;

import encryptors.CaesarCipher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CeasarDecTest {

    CeasarDec ceasarDec = new CeasarDec();
    private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String [] cryptoAlphabet;
    String s  = "ABC";

    @Before


    @Test
    public void decrypt() {
        ceasarDec.setDecrypted("");
        String actualString = ceasarDec.decrypt("DEF");
        int actualInt = actualString.length();
        Assert.assertEquals(3,actualInt);

        Assert.assertEquals(s, actualString);

    }

    @Test
    public void printDecryptedResult() {
    }
}