package com.example.demo;

import java.util.HashMap;
import java.util.Hashtable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UpperLinkAssignmentApplication {
	
	static final int MAX_CHAR = 256;

	public static void main(String[] args) {
		SpringApplication.run(UpperLinkAssignmentApplication.class, args);
		
		printDuplicate("jaamess");
		
		Character c = findFirstNonRepeated("jaassmes");
		
		System.out.println( "The first non repeated Char : " + c);
		
		
		printRepeatedCharAndCounts("jaammmess");

	}
	
	static void printDuplicate(String str) {
	    String duplicates = "";
	    for (int i = 0; i < str.length() - 1; i++) {
	    	
	        for (int j = i + 1; j < str.length(); j++)

	        {
	            if (str.charAt(i) == str.charAt(j)) {
	            	 

	                if (!duplicates.contains(String.valueOf(str.charAt(j)))) {
	                    duplicates += str.charAt(j);
	                    
	                    break;
	                }

	            }
	        }
	    }

	    System.out.println( "The duplicate characters in "+ str + " are:  "+ duplicates);
	   
	}
	
	public static Character findFirstNonRepeated(String input) {
	    Hashtable<Character, Object> hashChar = new Hashtable<Character, Object>();

	    int j, strLength;
	    Character chr;
	    Object oneTime = new Object();
	    Object twoTimes = new Object();

	    strLength = input.length();

	    for (j = 0; j < strLength; j++) {
	        chr = new Character(input.charAt(j));
	        Object o = hashChar.get(chr);
	        if (o == null) {
	            hashChar.put(chr, oneTime);
	        }

	        else if (o == oneTime) {
	            hashChar.put(chr, twoTimes);
	        }
	    }

	

	    int length = strLength;
	    for (j = 0; j < length; j++) {
	        chr = new Character(input.charAt(j));
	        Object c = null;
	        if (hashChar.get(chr) == oneTime)
	            return chr;
	    }
	    //not found.
	    return null;

	}
	
	
	static void printRepeatedCharAndCounts(String str) {

        int count[] = new int[MAX_CHAR]; 
  
        int len = str.length(); 

        for (int i = 0; i < len; i++) 
            count[str.charAt(i)]++; 
  
        char ch[] = new char[str.length()]; 
        for (int i = 0; i < len; i++) { 
            ch[i] = str.charAt(i); 
            int find = 0; 
            for (int j = 0; j <= i; j++) { 
  
                // If any matches found 
                if (str.charAt(i) == ch[j])  
                    find++;                 
            } 
  
            if (find == 1)  
            	if(count[str.charAt(i)] != 1) {
            		 System.out.println("Number of Occurrence of " + 
                             str.charAt(i) + " is:" + count[str.charAt(i)]);   
            	}
                         
        } 
	   
	}
	


}
