package encryptors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    private String userInputString;

    private void userInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            userInputString = reader.readLine().toUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public java.lang.String getUserInputString() {
        userInput();
        return userInputString;
    }
}
