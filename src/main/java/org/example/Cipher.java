package org.example;

public class Cipher {
    private TypeCipher type;
    private String word;

    public Cipher(){
        word="";
        type=null;
    }
    public Cipher(String str, TypeCipher nameClass){
        word=str;
        type = nameClass;
    }

    //operator copy
    //peregruska =
    public String encryption(){
        String result="";
        result=type.encryption(word);
        return result;
    }
    public String decryption(){
        String result="";
        result=type.decryption(word);
        return result;
    }

}
