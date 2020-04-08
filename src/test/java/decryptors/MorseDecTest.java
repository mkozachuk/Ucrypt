package decryptors;

import encryptors.MorseCode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MorseDecTest {

    MorseDec morseDec = new MorseDec();

    @Test
    public void decrypt() {
        String stringFromInput = ".- -... -.-.";
        String actualStringFromInput = morseDec.decrypt(stringFromInput);


        int actualInt = actualStringFromInput.length();
        String s = "ABC";
        Assert.assertEquals(3,actualInt);

        Assert.assertEquals(s, actualStringFromInput);

    }

    @Test
    public void printDecryptedResult() {
    }
}