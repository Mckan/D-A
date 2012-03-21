import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

import javax.swing.text.StringContent;

public class Main {
	    
    public static void main(String[] args) {    
         ArrayList<String> names = new ArrayList<String>();

         // Test print for an empty list
         ListOps.print(names); System.out.println();

         // Test print for a list containing one element
         names.add("a");
         ListOps.print(names); System.out.println();

         // Test print for a list containing more than one elment
         names.add("b");
         names.add("c");
         ListOps.print(names); System.out.println();
         
         // Test the return value from reverse
         ListOps.print(ListOps.reverse(names));
         System.out.println();
         // Test that reverse mutates its argument
         ListOps.print(names);
         System.out.println();


         // Write code to test less here
         
         IntegerComparator intcomp = new IntegerComparator();
       
         Integer[] i ={4,2,5,1,3};
         List<Integer> li1 = Arrays.asList(i);
        
         Integer[] j ={8,6,7,9};
         List<Integer> li2 = Arrays.asList(j);
         
         Integer[] k ={97,5,123,18};
         List<Integer> li3 = Arrays.asList(k);
         
         StringComparator stringcomp = new StringComparator();
         String[] s = {"HC2", "ED", "HC3"};
         List<String> johanneberg = Arrays.asList(s);
         
         String[] s2 = {"Saga", "Svea", "Jupiter"};
         List<String> lindholmen = Arrays.asList(s2);
         
         System.out.println(ListOps.less(li1,li2,intcomp));
         System.out.println(ListOps.less(li1,li3,intcomp));
         System.out.println(ListOps.less(johanneberg,lindholmen,stringcomp));

         // Write code to test filter here

         
         // Write code to test map here

    }
    
    public static class IntegerComparator implements Comparator<Integer> {
    	  public int compare(Integer obj1, Integer obj2) {
    	       	    	
    	    return obj1 - obj2;
    	  
    	  }
    }
    	  
    public static class StringComparator implements Comparator<String> {
    	
    	public int compare(String obj1, String obj2) {
    	
    		return obj1.compareTo(obj2);

    	}
    }


}














