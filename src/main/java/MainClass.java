import decryptors.*;
import encryptors.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;
import pgp.KeyBasedFileProcessor;
import pgp.RSAKeyPairGenerator;

import java.io.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {


    static String userInput = "";
    static int sCase = 0;
    static int num = 1;

    static InputReader reader = new InputReader();

    public static void main(String[] args){


        List<String> classNames = new ArrayList<>();
        classNames.add("A1z26");
        classNames.add("Atbash");
        classNames.add("Ceasar");
        classNames.add("Morse");
        classNames.add("Vigenere");


        System.out.println("Welcome to UCrypt ");

        while (!userInput.equals("EXIT") && !userInput.equals("E")){
            System.out.println("1. Encrypt message");
            System.out.println("2. Decrypt message");
            System.out.println("3. PGP");

            userInput = reader.getUserInputString();

            parseInt();


            switch (sCase){
             case (1):
                 while (!userInput.equals("EXIT") && !userInput.equals("E")){
                      System.out.println("Choose cipher :");
                     for(String cipher : classNames){
                         System.out.println(num + ". " + cipher);
                         num++;
                     }
                     userInput = reader.getUserInputString();
                     sCase = 0;
                     parseInt();
                     switch (sCase){
                         case (1):
                             A1Z26Cipher a1Z26Cipher = new A1Z26Cipher();
                             a1Z26Cipher.createNewCryptAlphabet();
                             askForUserInput();
                             String a1z26 = a1Z26Cipher.crypt(userInput);
                             System.out.println("Encrypted message by " + classNames.get(sCase - 1) + ": " + a1z26 + "\n" + "\n");
                             break;
                         case (2):
                             AtbashCipher atbashCipher = new AtbashCipher();
                             atbashCipher.createNewCryptAlphabet("0");
                             askForUserInput();
                             String atbash = atbashCipher.crypt(userInput);
                             System.out.println("Encrypted message by " + classNames.get(sCase - 1) + ": " + atbash + "\n" + "\n");
                             break;
                         case (3):
                             CaesarCipher caesarCipher = new CaesarCipher();
                             System.out.println("Provide alphabet dependency. ex: 3 -> A = D, 4 -> A = E etc");
                             askForUserInput();
                             caesarCipher.createNewCryptAlphabet(userInput);
                             askForUserInput();
                             String ceasar = caesarCipher.crypt(userInput);
                             System.out.println("Encrypted message by " + classNames.get(sCase - 1) + ": " + ceasar + "\n" + "\n");
                             break;
                         case (4):
                             MorseCode morseCode = new MorseCode();
                             askForUserInput();
                             String morse = morseCode.crypt(userInput);
                             System.out.println("Encrypted message by " + classNames.get(sCase - 1) + ": " + morse + "\n" + "\n");
                             break;
                         case (5):
                             VigenereCipher vigenereCipher = new VigenereCipher();
                             vigenereCipher.createTabulaRecta();
                             System.out.println("Provide secret Key: ");
                             askForUserInput();
                             vigenereCipher.setSecretKey(userInput);
                             askForUserInput();
                             String vigenere = vigenereCipher.crypt(userInput);
                             System.out.println("Encrypted message by " + classNames.get(sCase - 1) + ": " + vigenere + "\n" + "\n");
                             break;
                     }
                    }
                 break;
                case (2):
                    while (!userInput.equals("EXIT") && !userInput.equals("E")) {
                        System.out.println("Choose cipher :");
                        for (String cipher : classNames) {
                            System.out.println(num + ". " + cipher);
                            num++;
                        }
                        userInput = reader.getUserInputString();
                        sCase = 0;
                        parseInt();
                        switch (sCase){
                            case (1):
                                A1Z26Dec a1Z26Dec = new A1Z26Dec();
                                System.out.print("Using spaces ");
                                askForUserInput();
                                System.out.println("Decrypted message by " + classNames.get(sCase - 1) + ": " + a1Z26Dec.decrypt(userInput) + "\n" + "\n");
                                break;
                            case (2):
                                AtbashDec atbashDec = new AtbashDec();
                                askForUserInput();
                                System.out.println("Decrypted message by " + classNames.get(sCase - 1) + ": " + atbashDec.decrypt(userInput) + "\n" + "\n");
                                break;
                            case (3):
                                CeasarDec ceasarDec = new CeasarDec();
                                System.out.println("Provide alphabet dependency. ex: 3 -> A = D, 4 -> A = E etc");
                                askForUserInput();
                                String alphabetDep = userInput;
                                System.out.println("Provide message to decrypt");
                                askForUserInput();
                                System.out.println("Decrypted message by " + classNames.get(sCase - 1) + ": " + ceasarDec.decrypt(userInput, alphabetDep)+ "\n" + "\n");
                                break;
                            case (4):
                                MorseDec morseDec = new MorseDec();
                                askForUserInput();
                                System.out.println("Decrypted message by " + classNames.get(sCase - 1) + ": " + morseDec.decrypt(userInput)+ "\n" + "\n" );
                                break;
                            case (5):
                                VigenereDec vigenereDec = new VigenereDec();
                                System.out.println("Provide secret Key");
                                askForUserInput();
                                String secretKey = userInput;
                                System.out.println("Provide message to decrypt");
                                askForUserInput();
                                System.out.println("Decrypted message by " + classNames.get(sCase - 1) + ": " + vigenereDec.decrypt(secretKey, userInput)+ "\n" + "\n");
                                break;

                    }
                    }

                 break;
                case (3):
                    while (!userInput.equals("EXIT") && !userInput.equals("E")) {
                        System.out.println("What we could do gor you :");
                        System.out.println("1. Generate Pub and Secret ASC Keys");
                        System.out.println("2. Encrypt file");
                        System.out.println("3. Decrypt file");
                        userInput = reader.getUserInputString();
                        sCase = 0;
                        parseInt();
                        switch (sCase) {
                            case (1):
                                try {
                                    Security.addProvider(new BouncyCastleProvider());

                                    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", "BC");

                                    kpg.initialize(1024);

                                    KeyPair kp = kpg.generateKeyPair();

                                    String arg1 = "-a";
                                    System.out.println("Provide secret phrase to protect secret key");
                                    askForUserInput();
                                    String arg2 = userInput;

                                    FileOutputStream out1 = new FileOutputStream("secret.asc");
                                    FileOutputStream out2 = new FileOutputStream("pub.asc");
                                    RSAKeyPairGenerator.exportKeyPair(out1, out2, kp, arg1, arg2.toCharArray(), true);
                                    arg2 = "";
                                }catch (Exception e){
                                    System.out.println("Something go wrong, check stack trace");
                                    e.printStackTrace();
                                }
                                break;
                            case (2):
                                Security.addProvider(new BouncyCastleProvider());

                                System.out.println("Provide/Paste path to public key file");
                                askForUserInput();
                                String fullPathToPubKeyFile = userInput;

                                System.out.println("Provide/Paste path to file that must be encrypted");
                                askForUserInput();
                                String fileToEncryption = userInput;

                                System.out.println("Provide new file name");
                                askForUserInput();
                                String encryptedFileName = userInput;

                                try {
                                    KeyBasedFileProcessor.encryptFile(encryptedFileName + ".asc", fileToEncryption, fullPathToPubKeyFile, true, true);
                                } catch (IOException | NoSuchProviderException | PGPException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case (3):
                                System.out.println("Provide/Paste path to file that must be decrypted");
                                askForUserInput();
                                String fileToDecription = userInput;

                                System.out.println("Provide/Paste path to secret key file");
                                askForUserInput();
                                String secretKeyPath = userInput;

                                System.out.println("Provide secret phrase for secret key");
                                askForUserInput();
                                String secretPhrase = userInput;

                                try {
                                    KeyBasedFileProcessor.decryptFile(fileToDecription, secretKeyPath, secretPhrase.toCharArray(), new File("newOutFile") + ".out");
                                    secretPhrase = "";
                                } catch (IOException | NoSuchProviderException e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                    }

            }
        }
    }

    private static void parseInt(){
        if(userInput.equalsIgnoreCase("e") || userInput.equalsIgnoreCase("exit")){
            System.out.println("Thank you for using");
            System.exit(0);
        }else {
            try {
                sCase = Integer.parseInt(userInput);
                num = 1;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input data. ex: for A1Z26 type 1");
            }
        }
    }

    private static void askForUserInput(){
        System.out.println("Print or Paste your message");
        userInput = reader.getUserInputString();
    }
}


