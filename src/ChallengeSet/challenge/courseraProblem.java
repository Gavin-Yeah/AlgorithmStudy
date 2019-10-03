package ChallengeSet.challenge;


	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	/**
	 *boolean question_wildcard_match(text, query)
	 * 
	> question_wildcard_match("hello world", "hell?o")
	True

	> question_wildcard_match("hello world", "helll?o")
	True

	> question_wildcard_match("hello world", ".?ell?l?l?o?o?")
	True

	> question_wildcard_match("hello world", "h??ello")
	False

	> question_wildcard_match("hello world", "?hello")
	False
	 * 
	 * */


	public class courseraProblem {
	    public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        
	        // System.out.println(wildcard_match("hello world", "..llo wor"));
	        // System.out.println(wildcard_match("hello world", "..l.o"));
	        // System.out.println(wildcard_match("hello world", "...llo"));
	        System.out.println(question_wildcard_match("hello world", "?hello"));
	         System.out.println(question_wildcard_match("hello world", "h??ello"));
	          System.out.println(question_wildcard_match("hello world", ".?ell?l?l?o?o?"));
	           System.out.println(question_wildcard_match("hello world", "helll?o"));
	           System.out.println(question_wildcard_match("hello world", "hell?o"));
	           System.out.println(question_wildcard_match("hello world", "hel?o"));  //"l?" -> "l" or "" helo heo
	           
	           System.out.println("result "+Pattern.matches(".*.?ell?l?l?o?o?.*", "hello world"));	
	    }
	    public static boolean exact_match(String text, String query){
	        if(query==null&&text==null) return true;
	        if(query.length()==0&&text.length()==0)return true;
	        
	        tag:for(int i=0;i<text.length();i++){
	            int count=i;
	            for(int j=0;j<query.length();j++){
	                
	                if(text.charAt(count)==query.charAt(j)){
	                    count++;
	                    continue;
	                    
	                }else{
	                    continue tag;
	                }
	                
	                
	            }
	            return true;
	        }
	        
	        return false;
	    }
	    
	    
	    
	    
	    
	    
	    
	    public static boolean wildcard_match(String text, String query){
	          if(query==null&&text==null) return true;
	        if(query.length()==0&&text.length()==0)return true;
	        
	        tag:for(int i=0;i<text.length();i++){
	            int count=i;
	            
	            for(int j=0;j<query.length();j++){
	                
	                if(text.charAt(count)==query.charAt(j)){
	                    count++;
	                    continue;
	                    
	                }else if(count>query.length()-1){
	                    return false;
	                }
	                if(query.charAt(count)=='.'){
	                   
	                    count++;
	                    
	                    
	                }else
	                {
	                    continue tag;
	                }
	            }
	            
	                 return true;  
	            }
	              return false;
	    }
	    //> question_wildcard_match("hello world", ".?ell?l?l?o?o?")
	    public static boolean question_wildcard_match(String text, String query){
	         if(query==null&&text==null) return true;
	        if(query.length()==0&&text.length()==0)return true;
	        
	        tag:for(int i=0;i<text.length();i++){
	            int count=i;
	            if(text.charAt(0)=='?'){
	                return false;
	            }
	            
	            for(int j=0;j<query.length();j++){
	                
	                if(j+2<=query.length()&&query.substring(j,j+2).equals("??")){
	        
	                    return false;
	                    
	                }else if(j+1<query.length()&&query.charAt(j+1)=='?'){
	                   if(text.charAt(count)==query.charAt(j)){
	                        count++;
	                        j++;
	                        continue;
	                    }
	                    else{
	                            j++;
	                        continue;
	                    }
	                }
	             
	                    else if(text.charAt(count)==query.charAt(j)){
	                    count++;
	                    continue;
	                    
	                }else if(count>query.length()-1){
	                    return false;
	                }
	                if(query.charAt(count)=='.'){
	                   
	                    count++;
	                    
	                    
	                } 
	                else
	                {
	                    continue tag;
	                }
	            }
	            
	                 return true;  
	            }
	              return false;
	    }
	         
	    
	}


