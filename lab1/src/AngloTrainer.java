import java.io.*;
import java.util.*;
import java.util.Random;

// Author: lol
// Email:	
// Date:	

public class AngloTrainer {
	
	
	private ArrayList<String> dictionary = new ArrayList<String>();
	private Random randomGenerator = new Random();
	private String letters;
	private String sortedLetters;
	private String playerInput;
	private String playerInputSorted;
	private int length = 0;
	

	public AngloTrainer(String dictionaryFile) throws IOException {
		 
		loadDictionary(dictionaryFile);
		runAT(dictionaryFile);

		
		
		
	}

	private void loadDictionary( String fileName ) {
	    // Read the dictionary into a suitable container.
	    // The file is a simple text file. One word per line.
		
		try{
		FileInputStream fileStream = new FileInputStream(fileName);
		DataInputStream in = new DataInputStream(fileStream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String strLine;
		  
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
		  
			dictionary.add(strLine);
		}
		  //Close the input stream
		  in.close();
		
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		  }
	}

	private String randomLetters( int length ) {
	    // this makes vovels a little more likely
	    String letters = "aabcdeefghiijklmnoopqrstuuvwxyyz";  
	    StringBuffer buf = new StringBuffer(length);
	    for ( int i = 0; i < length; i++ ) 
		    buf.append( letters.charAt(randomGenerator.nextInt(letters.length())));
	
	    return buf.toString();
	}
	
	
	/* Def. includes	
	 * Let #(x,s) = the number of occurrences of the charcter x in the string s.
	 * includes(a,b) holds iff for every character x in b, #(x,b) <= #(x,a)
	 * 
	 * A neccessary precondition for includes is that both strings are sorted
	 * in ascending order.
	 */
	private boolean includes( String a, String b ) {
		if ( b == null || b.length() == 0 )
			return true;
		else if ( a == null || a.length() == 0 )
			return false;
		
		//precondition: a.length() > 0 && b.length() > 0
		int i = 0, j = 0;
		while ( j < b.length() ) {
			if (i >= a.length() || b.charAt(j) < a.charAt(i))
				return false;
			else if (b.charAt(j) == a.charAt(i)) {
				i++; j++;
			} else if (b.charAt(j) > a.charAt(i))
				i++;
		}
		//postcondition: j == b.length()
		return true;
	}
	
	
	
	private void testIncludes() { 
		//                                            expected value
		System.out.println(includes("abc",""));		//t
		System.out.println(includes("","abc"));		//f
		System.out.println(includes("abc","abc"));	//t
		System.out.println(includes("abc","bcd"));	//f
		System.out.println(includes("abc","a"));	//t
		System.out.println(includes("abc","b"));	//t
		System.out.println(includes("abc","c"));	//t
		System.out.println(includes("abc","ab"));	//t
		System.out.println(includes("abc","bc"));	//t
		System.out.println(includes("abc","ac"));	//t
		System.out.println(includes("abc","abcd"));	//f
		System.out.println(includes("abc","abd"));	//f
		System.out.println(includes("abc","d"));	//f
		System.out.println(includes("",""));		//t
		System.out.println(includes("abc","ca"));	//f
		System.out.println(includes("abc","bac"));	//f
		System.out.println(includes("abc","abbc"));	//f
		System.out.println(includes("abbc","abc"));	//t
		System.out.println(includes(null,null));    //t
		System.out.println(includes(null,""));	    //t
		System.out.println(includes(null,"abc"));	//f
		System.out.println(includes("",null));		//t
		System.out.println(includes("abc",null));   //t
	}

    public static void main(String[] args) {
        // ... define!
    	try{
    	new AngloTrainer("dictionary.txt");
    	}catch (Exception e){
    		
    	}
    }
    
    
    private String sort(String a)
	{
		char[] temp = new char[a.length()];
		for(int i = 0; i < a.length(); i++)
			temp[i] = a.charAt(i);
		
		Arrays.sort(temp);
		String sortedString = new String(temp);
		
		return sortedString;
	}
    
    private void printWords(String letters)
    {
    	for(String x : dictionary)
    	{
    		if( includes(sort(letters) , sort(x) ) )
    		System.out.println(x);
    	}
    	
    }
    
    private void runAT(String dictionaryFile)
    {
    	for(String x : dictionary)
		{
			int temp = x.length();
			if(temp > length)
				length = temp;
			
		}
		letters = randomLetters(length);
		
		System.out.println(dictionary.size() + " words loaded from " + dictionaryFile);
		System.out.println("The random letters are: " + letters);
		System.out.println("Try to build as many words from these letters as you can!");
		
		BufferedReader input = new BufferedReader(
                new InputStreamReader(System.in));
		
		sortedLetters = sort(letters);
		playerInput = null;
		while( playerInput != "^Z")
		{
			try{
			playerInput = input.readLine();
			}catch (Exception e)
			{}
			playerInputSorted = sort(playerInput);

			if( (includes(sortedLetters, playerInputSorted))  && dictionary.contains(playerInput))
				System.out.println("Okey!");	

			else
			{
				System.out.println("Your suggestion was not found in the dictionary.");
				System.out.println("I found: ");
				printWords(letters);

				break;
			}
						
		}
    }
}












