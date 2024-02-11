package org.example;

public class MorseCode implements TypeCipher{
    private String removingUnnecessarySpaces(String word){//public только для проверки юнит тестом
        if(word=="")
            return "";

        while(word.charAt(0)==' ')//удаляем все пробелы в начале
            word = word.substring(1);


        while(word.charAt(word.length()-1)==' ')
            word = word.substring(0,word.length()-1);

        boolean oneSpace = false;
        String result = "";
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==' ' && oneSpace==false) {
                result+=" ";
                oneSpace = true;
            }

            else if(word.charAt(i)==' ' && oneSpace==true){}//если один пробел уже записали то ничего не делаем, идем дальше
            else {
                result+= word.charAt(i);
                oneSpace = false;
            }
        }
        return result;
    }

    public String encryption(String word){
        String result="";
        MorseCode obj= new MorseCode();
        String str = obj.removingUnnecessarySpaces(word);
        //фраза гарантированно не начинается с пробела
        //между словами один пробел
        for(int i=0; i<str.length();i++){
            char x= str.charAt(i);
            switch(x){
                case ' ':
                case '\n':{
                    result+=x;
                    break;
                }
                case 'A':
                case 'a':{
                    result+=".- ";
                    break;
                }
                case 'B':
                case 'b':{
                    result+="-... ";
                    break;
                }
                case 'C':
                case 'c':{
                    result+="-.-. ";
                    break;
                }
                case 'D':
                case 'd':{
                    result+="-.. ";
                    break;
                }
                case 'E':
                case 'e':{
                    result+=". ";
                    break;
                }
                case 'F':
                case 'f':{
                    result+="..-. ";
                    break;
                }
                case 'G':
                case 'g':{
                    result+="--. ";
                    break;
                }
                case 'H':
                case 'h':{
                    result+=".... ";
                    break;
                }
                case 'I':
                case 'i':{
                    result+=".. ";
                    break;
                }
                case 'J':
                case 'j':{
                    result+=".--- ";
                    break;
                }
                case 'K':
                case 'k':{
                    result+="-.- ";
                    break;
                }
                case 'L':
                case 'l':{
                    result+=".-.. ";
                    break;
                }
                case 'M':
                case 'm':{
                    result+="-- ";
                    break;
                }
                case 'N':
                case 'n':{
                    result+="-. ";
                    break;
                }
                case 'O':
                case 'o':{
                    result+="--- ";
                    break;
                }
                case 'P':
                case 'p':{
                    result+=".--. ";
                    break;
                }
                case 'Q':
                case 'q':{
                    result+="--.- ";
                    break;
                }
                case 'R':
                case 'r':{
                    result+=".-. ";
                    break;
                }
                case 'S':
                case 's':{
                    result+="... ";
                    break;
                }
                case 'T':
                case 't':{
                    result+="- ";
                    break;
                }
                case 'U':
                case 'u':{
                    result+="..- ";
                    break;
                }
                case 'V':
                case 'v':{
                    result+="...- ";
                    break;
                }
                case 'W':
                case 'w':{
                    result+=".-- ";
                    break;
                }
                case 'X':
                case 'x':{
                    result+="-..- ";
                    break;
                }
                case 'Y':
                case 'y':{
                    result+="-.-- ";
                    break;
                }
                case 'Z':
                case 'z':{
                    result+="--.. ";
                    break;
                }
                case '1':{
                    result+=".---- ";
                    break;
                }
                case '2':{
                    result+="..--- ";
                    break;
                }
                case '3':{
                    result+="...-- ";
                    break;
                }
                case '4':{
                    result+="....- ";
                    break;
                }
                case '5':{
                    result+="..... ";
                    break;
                }
                case '6':{
                    result+="-.... ";
                    break;
                }
                case '7':{
                    result+="--... ";
                    break;
                }
                case '8':{
                    result+="---.. ";
                    break;
                }
                case '9':{
                    result+="----. ";
                    break;
                }
                case '0':{
                    result+="----- ";
                    break;
                }
                case '.':{
                    result+="...... ";
                    break;
                }
                case ',':{
                    result+=".-.-.- ";
                    break;
                }
                case ';':{
                    result+="-.-.-. ";
                    break;
                }
                case ':':{
                    result+="---... ";
                    break;
                }
                case '?':{
                    result+="..--.. ";
                    break;
                }
                case '!':{
                    result+="--..-- ";
                    break;
                }
                case '-':{
                    result+="-....- ";
                    break;
                }
                case '\"':{
                    result+=".-..-. ";
                    break;
                }
                case '/':{
                    result+="-..-. ";
                    break;
                }
                default:{
                    throw new NumberFormatException();
                }
            }
        }
        return result;
    }
    public String decryption(String word){
        if(word.charAt(0)==' '||word.charAt(word.length()-1)!=' ')//минимальная проверка на правильность записи морзе
            throw new NumberFormatException();
        if (word.length()>1)
            for(int i=0;i<word.length()-2;i++)
                if(word.charAt(i)==' '&&word.charAt(i+1)==' '&&word.charAt(i+2)==' ')//подряд может быть только два пробела
                    throw new NumberFormatException();

        String result="";

        for (int i=0; i<word.length();i++){
            String symbol="";
            boolean flag=false;
            while(word.charAt(i)!=' '&&word.charAt(i)!='\n'){
                flag=true;
                symbol+=word.charAt(i);
                i++;
            }
            if(flag==false){
                if(word.charAt(i)==' ')
                    symbol=" ";
                if(word.charAt(i)=='\n')
                    symbol="\n";
            }
            switch (symbol){
                case " ":
                case "\n":{
                    result+=symbol;
                    break;
                }
                case ".-":{
                    result+="a";
                    break;
                }
                case "-...":{
                    result+="b";
                    break;
                }
                case "-.-.":{
                    result+="c";
                    break;
                }
                case "-..":{
                    result+="d";
                    break;
                }
                case ".":{
                    result+="e";
                    break;
                }
                case "..-.":{
                    result+="f";
                    break;
                }
                case "--.":{
                    result+="g";
                    break;
                }
                case "....":{
                    result+="h";
                    break;
                }
                case "..":{
                    result+="i";
                    break;
                }
                case ".---":{
                    result+="j";
                    break;
                }
                case "-.-":{
                    result+="k";
                    break;
                }
                case ".-..":{
                    result+="l";
                    break;
                }
                case "--":{
                    result+="m";
                    break;
                }
                case "-.":{
                    result+="n";
                    break;
                }
                case "---":{
                    result+="o";
                    break;
                }
                case ".--.":{
                    result+="p";
                    break;
                }
                case "--.-":{
                    result+="q";
                    break;
                }
                case ".-.":{
                    result+="r";
                    break;
                }
                case "...":{
                    result+="s";
                    break;
                }
                case "-":{
                    result+="t";
                    break;
                }
                case "..-":{
                    result+="u";
                    break;
                }
                case "...-":{
                    result+="v";
                    break;
                }
                case ".--":{
                    result+="w";
                    break;
                }
                case "-..-":{
                    result+="x";
                    break;
                }
                case "-.--":{
                    result+="y";
                    break;
                }
                case "--..":{
                    result+="z";
                    break;
                }
                case ".----":{
                    result+="1";
                    break;
                }
                case "..---":{
                    result+="2";
                    break;
                }
                case "...--":{
                    result+="3";
                    break;
                }
                case "....-":{
                    result+="4";
                    break;
                }
                case ".....":{
                    result+="5";
                    break;
                }
                case "-....":{
                    result+="6";
                    break;
                }
                case "--...":{
                    result+="7";
                    break;
                }
                case "---..":{
                    result+="8";
                    break;
                }
                case "----.":{
                    result+="9";
                    break;
                }
                case "-----":{
                    result+="0";
                    break;
                }
                case "......":{
                    result+=".";
                    break;
                }
                case ".-.-.-":{
                    result+=",";
                    break;
                }
                case "-.-.-.":{
                    result+=";";
                    break;
                }
                case "---...":{
                    result+=":";
                    break;
                }
                case "..--..":{
                    result+="?";
                    break;
                }
                case "--..--":{
                    result+="!";
                    break;
                }
                case "-....-":{
                    result+="-";
                    break;
                }
                case ".-..-.":{
                    result+= "\"";
                    break;
                }
                case "-..-.":{
                    result+= "/";
                    break;
                }
                default:{
                    throw new NumberFormatException();
                }
            }

        }

        return result;
    }
}
