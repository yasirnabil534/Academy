/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author User
 */
class HangmanCheckString {
    public String[] hangmanWords = {"marsh", "swamp","mountain","peninsula","beach"};
	public String hangmanTemp;
	public char[] hangmanBlank = {'-','-','-','-','-','-','-','-','-','-',
			'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-',};
	public char[] hangmanLetters;
	public char[] usedLetterList = {'-','-','-','-','-','-','-','-','-','-',
			'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-',};
	char[]  charArray;
	char[] charArrayTest;
	boolean winOrLoose;
	boolean wrongChoice;
	int wrongGuess;
	boolean usedLetter;

	Random r;

public void chooseWord(){
	r = new Random();
	
	// choose a word from the list of words
    hangmanTemp = hangmanWords[r.nextInt(hangmanWords.length)];
    charArrayTest = hangmanTemp.toCharArray();
    hangmanLetters = hangmanTemp.toCharArray();
    charArray = hangmanTemp.toCharArray();
	for(int i = 0;i < charArray.length;i++){
		charArrayTest[i]=hangmanBlank[i];
		hangmanLetters[i]=hangmanBlank[i];
	}

}
public void checkWord(char ch){
	usedLetter= false;
	wrongChoice = false;
	char c = '-';
	int temp =0;
	for(int i = 0;i < charArray.length;i++){
			if(charArray[i] == ch){
				hangmanLetters[i] = ch; 
			}
	}
	for(int i = 0;i < usedLetterList.length;i++){
		if(usedLetterList[i] == ch){
			usedLetter = true;
		}
	}


	for(int i = 0;i < charArray.length;i++){
		if(charArray[i] == ch && wrongChoice == false){
			wrongChoice = true; 
		}
	}
	if(usedLetter == false){
		for(int i = 0;i < usedLetterList.length;i++){
			if(usedLetterList[i] == c){
				 temp = i;
				 break;
			}
		}
		usedLetterList[temp] = ch;
	}
	if(wrongChoice == false){
		wrongGuess = wrongGuess + 1;
		if(usedLetter == true){
			wrongGuess = wrongGuess - 1;
		}
	}
	winOrLoose = Arrays.equals(charArray,hangmanLetters);
}

}
