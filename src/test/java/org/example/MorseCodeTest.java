package org.example;

import org.junit.jupiter.api.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static org.junit.jupiter.api.Assertions.*;

class MorseCodeTest {
    /* @Test
     void UnnecessarySpacesTest(){
         String word="   hello world   bitch    .  ";
         MorseCode obj = new MorseCode();
         word = obj.removingUnnecessarySpaces(word);
         assertEquals("hello world bitch .",word);
     }
     */
    @Test
    void encryptionTest(){
        String word=" \"hello world\" - this is classic     sentence    ";
        MorseCode obj = new MorseCode();
        String result= obj.encryption(word);
        assertEquals(".-..-. .... . .-.. .-.. ---  .-- --- .-. .-.. -.. .-..-.  -....-  - .... .. ...  .. ...  -.-. .-.. .- ... ... .. -.-.  ... . -. - . -. -.-. . ",result);

    }
    @Test
    void decryptionTest(){
        String word=".-..-. .... . .-.. .-.. ---  .-- --- .-. .-.. -.. .-..-.  -....-  - .... .. ...  .. ...  -.-. .-.. .- ... ... .. -.-.  ... . -. - . -. -.-. . ";
        MorseCode obj = new MorseCode();
        String result= obj.decryption(word);
        assertEquals("\"hello world\" - this is classic sentence",result);

    }

}