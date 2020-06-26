package com.example.demo;

import java.util.HashMap;
import java.util.Hashtable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UpperLinkAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpperLinkAssignmentApplication.class, args);
		
		printDuplicate("jaamess");
		
		Character c = findFirstNonRepeated("jaassmes");
		
		System.out.println(c);
		
		
		printRepeatedCharAndCount("jaammmess");

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

	    System.out.print(duplicates);
	   
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
	
	
	static void printRepeatedCharAndCount(String str) {
	    String duplicates = "";
	    int count = 0;
	    HashMap<String, Integer> mp = new HashMap<String, Integer>();
	    for (int i = 0; i < str.length() - 1; i++) {
	    	
	        for (int j = i + 1; j < str.length(); j++)

	        {
	            if (str.charAt(i) == str.charAt(j)) {
	            	 
	            	  
	                if (!duplicates.contains(String.valueOf(str.charAt(j)))) {
	                	char val = str.charAt(j);
	                    duplicates += val;
	                    if(mp.size() > 0) {
	                    	if(mp.containsKey(""+val)) {
	                    		int count1 = mp.get(""+val);
	                    		count1 = count1 + 1;
	                    		mp.remove(""+val);
	                    		mp.put(""+val, count);
	                    	}else {
	                    		mp.put(""+val, 1);
	                    	}
	                    }
	                    
	                    break;
	                }

	            }
	        }
	    }

	    //System.out.print(duplicates);
	    mp.forEach((k, v)->{
	    	System.out.printf("%s = %s", k, v);
	    });
	   
	}

	


}
