/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5: 5
        Comment: Yes I double checked

 2. Did I indent the code appropriately?

        Mark out of 5: 5
        Comment:  Yes I looked through my code to make sure

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20: 20
        Comment:  Yes I have coded createCipher in accordance with the brief

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  20
        Comment: Yes I have coded encrypt in accordance with the brief

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  20
        Comment: Yes I have coded decrypt in accordance with the brief

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

       Mark out of 25: 25
        Comment: Yes I have coded the main function in accordance with the brief

 7. How well did I complete this self-assessment?

        Mark out of 5: 5
        Comment: I believe I have completed this self assessment to a good standard

 Total Mark out of 100 (Add all the previous marks): 100

*/ 

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Cipher {

	public static void main(String[] args) {
		
		char[] alphabet = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 
	                       'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		char[] cipher = alphabet.clone();
		createCipher(cipher);
		
		Scanner inputScanner = new Scanner(System.in);
		boolean exit = false;
		
		while(!exit)
		{
			System.out.print("Enter text to be encrypted here (or type 'EXIT' in all caps) -> ");
			String originalUserInput = inputScanner.nextLine();
			if(!originalUserInput.equals("EXIT"))
			{
			String userInput = originalUserInput.toLowerCase();
			
			char[] userText = userInput.toCharArray();
			System.out.println("\nYour message encrypted looks like this -> " + encrypt(cipher, userText, alphabet));
			
			char[] encryptedText = encrypt(cipher, userText, alphabet).toCharArray();
			System.out.println("\nYour message decrypted looks like this -> " + decrypt(cipher, encryptedText, alphabet));
			
			}
			else
			{
				System.out.print("\nGoodbye!");
				exit = true;
			}
		}
	}
	

	public static void createCipher(char[] cipher) {
		
		if(cipher != null)
		{
			Random generator = new Random();
			int randomIndex = 0;
			char tempChar;
			
			for(int index = 1; index < cipher.length; index++)
			{
				do {
					randomIndex = generator.nextInt(cipher.length - 1) + 1;
				}
				while(cipher[randomIndex] == cipher[index]);
				
				tempChar = cipher[index];
				cipher[index] = cipher[randomIndex];
				cipher[randomIndex] = tempChar;
			}
		}
	}
	
	public static String encrypt(char[] cipher, char[] userText, char[] alphabet)
	{
		char[] encryptedText = userText.clone();
		
		for(int index = 0; index < userText.length; index++) 
		{
			
			for(int index2 = 0; index2 < alphabet.length; index2++) 
			{
				if(userText[index] == alphabet[index2])
					encryptedText[index] = cipher[index2];
			}
			
		}
		
		String encryptedString = new String(encryptedText);
		
		return encryptedString;
		
	}
	
	public static String decrypt(char[] cipher, char[] encryptedText, char[] alphabet)
	{
		char[] decryptedText = encryptedText.clone();
		
		for(int index = 0; index < encryptedText.length; index++) 
		{
			
			for(int index2 = 0; index2 < alphabet.length; index2++) 
			{
				if(encryptedText[index] == cipher[index2])
					decryptedText[index] = alphabet[index2];
			}
			
		}
		
		String decryptedString = new String(decryptedText);
		
		return decryptedString;
	}

}
