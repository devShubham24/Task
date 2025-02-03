package com.sb.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
		 
//		// equals() method
	 String a="shubham";
	     String b="shubham";     
     System.out.println(a);
     System.out.println(b);
     System.out.println(b==a);    //compair the addresses between two object 
     System.out.println(a.equals(b));           
//  String str = new String("shubham");  
//   String str1 =new String("shubham");   
//    System.out.println(str);          
//   System.out.println(str1);        // Default Behavior: For most objects, System.out.println(object) will implicitly call object.toString().
//  System.out.println(str==str1);     // it will give you false value because of mutability of String i am trying to implement string through the the new keyword
//  System.out.println(str.equals(str1));    //    equals method comparing the value  of object
//	            // Printing memory addresses (pseudo-addresses via System.identityHashCode)
	    //   System.out.println("Address of a: " + System.identityHashCode(a));
	      //  System.out.println("Address of b: " + System.identityHashCode(b));
	     
	}

}
