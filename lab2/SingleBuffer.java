
public class SingleBuffer<T> 
{
	private T value;
	public SingleBuffer()
	{
		this.value = null;
		
	}
	
	public boolean put(T x)
	{
		if(value==null)
		{
			this.value = x;
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public T get()
	{
		T tmp;
		if(value != null)
		{	tmp = value;
			value = null;
			return tmp;
		}
		else
		{
			return null;
		}
	}
	
	
}
