package decryptors;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class A1Z26DecTest {

    A1Z26Dec a1Z26Dec = new A1Z26Dec();

    @Test
    public void decrypt() {
        String s = "123";
        String actualString = a1Z26Dec.decrypt(s);
        int actualInt = actualString.length();
        Assert.assertEquals(3,actualInt);

        Assert.assertEquals("ABC", actualString);
    }

    @Test
    public void printDecryptedResult() {
    }
}