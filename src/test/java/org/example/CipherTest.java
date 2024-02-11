package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CipherTest {

    @Test
    void encryptionTestMorse(){
        Cipher obj= new Cipher("\"hello world\" - this is classic sentence", new MorseCode());
        String result = obj.encryption();
        assertEquals(".-..-. .... . .-.. .-.. ---  .-- --- .-. .-.. -.. .-..-.  -....-  - .... .. ...  .. ...  -.-. .-.. .- ... ... .. -.-.  ... . -. - . -. -.-. . ",result);
    }

    @Test
    void decryptionTestMorse(){
        Cipher obj= new Cipher(".-..-. .... . .-.. .-.. ---  .-- --- .-. .-.. -.. .-..-.  -....-  - .... .. ...  .. ...  -.-. .-.. .- ... ... .. -.-.  ... . -. - . -. -.-. . ", new MorseCode());
        String result = obj.decryption();
        assertEquals("\"hello world\" - this is classic sentence", result);
    }


}