```java
public static void main(String[] arg){
        // random alphabet array
        Random random = new Random();
        char[] abc = new char[100];
        for(int i=0; i<abc.length; i++){
            abc[i] = (char)(random.nextInt(26) + 97);
        }
        
        // Alphabet array that counts each occurence of letters in random alphabet array
        // Goes from 0-26 because there are 26 letters in English alphabet (so 0 is a, 1 is b, and so on)
        int[] abcCounter = new int[26];       
        for(int i=0; i<abcCounter.length; i++){
            int counter = 1;
            for(int j=0; j<abc.length; j++){
                //(i+97) is the ascii value; Example 0+97=='a'
                if((i+97) == (int) abc[j]){
                    abcCounter[i] += counter;
                }
            }
        }
        
        // Print Array; Program output
        for(int i=0; i<abcCounter.length; i++){
            char charInt = (char)(i+97);
            System.out.println(charInt + " - " + abcCounter[i]);
        }
        System.out.println("Here are the random letters: ");
        System.out.println(abc);   
    } 
```
