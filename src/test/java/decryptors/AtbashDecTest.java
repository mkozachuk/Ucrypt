package decryptors;

import encryptors.AtbashCipher;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtbashDecTest {

    AtbashDec atbashDec = new AtbashDec();

    @Test
    public void decrypt() {
        String actualString = atbashDec.decrypt("ZYX");
        int actualInt = actualString.length();
        String expected = "ABC";
        Assert.assertEquals(3,actualInt);

        Assert.assertEquals(expected, actualString);
    }

    @Test
    public void printDecryptedResult() {
    }
}