import java.io.*;

public class TestSingleBuffer {
	
    public static void main(String[] args) throws IOException  {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		
        //  Define the object stringBuf of type SingleBuffer here...
        
        SingleBuffer<String> stringBuf = new SingleBuffer<String>();


        while ( true ) {
            System.out.print("Command (p/g/q): "); 
            String command = in.readLine();
            if (command.equals("p")) {
                System.out.print("Text: "); System.out.flush();
                String s = in.readLine();
                if ( ! stringBuf.put(s))
                    System.out.println("Buffer was full!");
            } else if (command.equals("g")) {
                String s = stringBuf.get();
                if ( s == null )
                    System.out.println("Buffer was empty!");
                else
                    System.out.println("contents: " + s);
            } else if (command.equals("q"))
                return;
            else
                System.out.println("Unknown command");
        }
    }
}
