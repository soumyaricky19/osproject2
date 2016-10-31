
package edu.utdallas.blockingFIFO;

public class Producer implements Runnable
{
	private BlockingFiniteQueue buffer;
	static private int limit; 
	
	public Producer(BlockingFiniteQueue buffer, int limit)
	{
		this.buffer = buffer;
		this.limit = limit;
	}

	
	public void run()
	{
		for(int i = 1; i <= limit; i++) 
		{
			try {
				String item = produceString(i);
				buffer.append(item);
				System.out.println("Appended " + item);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private String produceString(int i)
	{	
		return "Now Is The Time For All Good Men " + i;
	}

}
