package com.company;

public class Main {

    public static void main(String[] args) {

        String encryptedKey = "zbx gcb dbzx rob eleb res xbybegbbe";
        decrptionWithOutKey(encryptedKey);

    }


    public static String decrptionWithOutKey(String encryptedText){
        String decryptedText = "";

        // outer loop for k1 iteration

        for (int i = 1; i <= 26; i++){

            // 1st inner loop for k2 iteration
            for (int j = 1; j <= 26; j++){

                //2nd inner loop for string iteration so that the string can be decrypted letter by letter
                for (int k = 0; k<= encryptedText.length()-1; k++){

                    // if condition placed so that if space occurs between words it prints a space in the result directly NEEDLESS to say no calulations are performed once a space or ' ' is seen
                    if (encryptedText.charAt(k) != ' ') {

                        //converts letter to corresponding position
                        int letterToPosition = conversionOfLetterToPosition(Character.toString(encryptedText.charAt(k)));

                        //converts the k1 to inverse modulus
                        int inverseModulo = moduloInverseCalculator(i);

                        // adds 26 if the expected value of letterToPosition - j is negative means modulus will be in negative thus making the current position negative so adding 26 in it if negative value arrives.
                        if (letterToPosition - j < 0) {
                            letterToPosition = letterToPosition + 26;
                        }

                        //decryption formula

                        int currentPosition = (inverseModulo * (letterToPosition - j)) % 26;

                        //converting decrypted position to text
                        String currentDecryptedText = conversionOfPositionToLetter(currentPosition);

                        //concatenating the string
                        decryptedText += currentDecryptedText;

                    }
                    // if a ' ' occurs it will add a space in the decrypted text
                    else {

                        decryptedText += " ";
                    }

                }
                System.out.println("Decrypted Text: " + decryptedText + "  and key is " + "( " + i + ", " + j + " )");
                decryptedText = "";
            }
        }



        return decryptedText;
    }




    public static int conversionOfLetterToPosition(String encryptedText ){

        String arrayforAlpha[] = {"a","b","c","d","e","f", "g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int position= 0;

        for (int i = 0; i <= 25; i++){
            if (arrayforAlpha[i].equals(encryptedText)){
                position = i;
                break;
            }
        }

        return position;
    }

    public static String conversionOfPositionToLetter(int position ){

        String[] arrayAlpha = {"a","b","c","d","e","f", "g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String alpha= arrayAlpha[position] ;
        return alpha;
    }

    public static int moduloInverseCalculator(int k1){

        int m = 26;

        for (int x = 1; x < m; x++)
            if (((k1%m) * (x%m)) % m == 1)
                return x;
        return 1;
    }
}
