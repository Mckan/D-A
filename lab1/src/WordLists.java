import java.io.*;
import java.util.*;

// Author:	Martin Augustsson
// Email:	maraugu@student.chalmers.se
// Date:	16-03-2012

public class WordLists {
	
	FileInputStream fileStream;
	DataInputStream in;
	BufferedReader br;
	
	public WordLists(String inputFileName) {
		try
		{
			fileStream = new FileInputStream(inputFileName);
			in = new DataInputStream(fileStream);
			br = new BufferedReader(new InputStreamReader(in));
		}catch (Exception E)
		{}
		
//		String test;
//		try
//		{
//			while( (test=getWord()) != null)
//			{
//		
//				System.out.println(test);
//				reverse(test);
//			}
//		}catch (IOException e){}

	}
	
	private boolean isPunctuationChar(char c) {
	    final String punctChars = ",.:;?!";
	    return punctChars.indexOf(c) != -1;
	}
	
	private String getWord() throws IOException {
		int state = 0;
		int i;
		String word = "";
		while ( true ) {
			i = in.read();
			char c = (char)i;
			switch ( state ) {
			case 0:
				if ( i == -1 )
					return null;
				if ( Character.isLetter( c ) ) {
					word += Character.toLowerCase( c );
					state = 1;
				}
				break;
			case 1:
				if ( i == -1 || isPunctuationChar( c ) || Character.isWhitespace( c ) )
					return word;
				else if ( Character.isLetter( c ) ) 
					word += Character.toLowerCase( c );
				else {
					word = "";
					state = 0;
				}
			}
		}
	}
	
	private String reverse(String s) {
		char[] tmp = new char[s.length()];
		int temp = s.length()-1;
	    for(int i = 0; i < s.length(); i++)
	    {
	    	tmp[i]= s.charAt(temp-i);
	    }
	    String s2 = new String(tmp);
		return s2;
	}
	
	private void computeWordFrequencies() {
		try{
		FileWriter fw = new FileWriter("alfaSorted.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		TreeMap<String,Integer> temp = (TreeMap<String,Integer>)tm.clone();
		while(true){
			if(temp.firstEntry()==null)
        		break;
			
			bw.write("" + temp.pollFirstEntry() + "\n");
		}
		bw.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
	

private void computeFrequencyMap() {
		TreeMap<String,Integer> tm2 = (TreeMap<String,Integer>)tm.clone();		
		TreeMap<Integer, TreeSet<String>> freq = new TreeMap<Integer, TreeSet<String>>();
		TreeSet<String> test = new TreeSet<String>();

		try{
		FileWriter fw = new FileWriter("frequencySorted.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		String word;
		for(String key : tm2.keySet()){
		
			test.add(key);	
			
			if(freq.containsKey(tm2.get(key))){
				TreeSet<String> temp = freq.get(tm2.get(key));
				temp.add(key);
			}
			else{
				TreeSet<String> temp = new TreeSet<String>();
				temp.add(key);
				freq.put(tm2.get(key), temp);
				
			}
		
		}

		while(true){
			if(freq.firstEntry()==null)
				break;
			
			bw.write("\n" + freq.pollFirstEntry() + "\n");
		}
		bw.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
	

	private void computeBackwardsOrder() {
		TreeSet<String> tmp = new TreeSet<String>();

		String s;
		try
		{
			while( (s=getWord()) != null)
			{
				tmp.add(reverse(s));
			}
		}catch (IOException e){}
	    
		try{
			  // Create file 
			  FileWriter fstream = new FileWriter("backwardsSorted.txt");
			  BufferedWriter out = new BufferedWriter(fstream);
			  
			  //Write every word to file
			  Iterator<String> i = tmp.iterator();
			  while(i.hasNext())
			  {
				  out.write(reverse(i.next()) + "\n");
			  }
			  
			  //Close the output stream
			  out.close();
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		
		
		
	}

	public static void main(String[] args) throws IOException {
		WordLists wl = new WordLists(args[0]);  // args[0] contains the input file name
		wl.computeWordFrequencies();
		wl.computeFrequencyMap();
		wl.computeBackwardsOrder();
		
		System.out.println("Finished!");
	}
	
	
}



















