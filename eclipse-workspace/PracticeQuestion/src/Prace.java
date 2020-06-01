import java.util.*;
class JGenClass { 
	static <T> T take(T s[], int index) {  
		if (index > s.length) {   
			System.out.println("ÀÎµ¦½º°¡ ¹üÀ§¸¦ ¹þ¾î³µ½À´Ï´Ù.");   
			return null;  
		}  
		return s[index];
	} 
}

public class Prace {
	public static void main(String[] args) {
		String str[]= {"a","b","c","d","e","f","h"};
		System.out.println(JGenClass.take(str, 3));
	}
}