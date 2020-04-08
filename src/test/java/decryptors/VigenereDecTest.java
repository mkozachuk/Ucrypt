package decryptors;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VigenereDecTest {

    VigenereDec vigenereDec = new VigenereDec();

  //vigenereDec.cipher.setSecretKey("LEMONL");

    String forDecrypt = "LXFOPV";
    String actual = vigenereDec.decrypt("LEMONL",forDecrypt);
    String expected = "ATTACK";

    @Test
    public void decrypt() {
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void printDecryptedResult() {
    }
}