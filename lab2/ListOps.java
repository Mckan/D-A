
import java.util.*;

import javax.swing.text.html.MinimalHTMLWriter;

public class ListOps {

    // Put your code for print here ...
	public static <T> void print(List<T> x)
	{
		int count = x.size()-1;
		if(x.size() > 0)
		{	
			System.out.print("[");
			for(T y : x)
			{
				System.out.print(y.toString());
				if(count > 0)
					System.out.print(",");
				
				count--;
			}
			System.out.print("]");
		}
	}
    
    // Put your code for reverse here ...
	public static <T> List<T> reverse (List<T> l)
	{
		int i,k;
		k = l.size()-1;
		i = 0;
		while(k > i)
		{
			T temp = l.get(i);
			l.set(i,l.get(k));
			l.set(k,temp);
			k--;
			i++;
		}
		return l;
	}

    
    // Example
    public static <T1,T2> List<T2>
    map(UnaryOp<T1,T2> functor,List<T1> l) 
    {
        // Determine the dynamic type of the list
        Class<? extends List> c = l.getClass();
        try {
            // Create a result list of the same List type
            List<T2> result = c.newInstance();
            //type.cast(type.newInstance());
            // Copy elements satifying p
            for ( T1 x : l )
                result.add(functor.op(x));
            return result;   
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static <T> boolean less(Collection<T> c1,Collection<T> c2,
    Comparator<T> comp)
    {
    	
    	if( comp.compare( Collections.max(c1,comp) ,  Collections.min(c2, comp) ) < 0)
    		return true;
    	
    	else
    		return false;
    }
    
    // Put your code for filter here ...

}
