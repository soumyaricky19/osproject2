package edu.utdallas.taskExecutorImpl;

import edu.utdallas.blockingFIFO.BlockingFiniteQueue;
import edu.utdallas.blockingFIFO.Producer;
import edu.utdallas.blockingFIFO.Consumer;
import edu.utdallas.taskExecutor.Task;
import edu.utdallas.taskExecutor.TaskExecutor;

public class TaskExecutorImpl implements TaskExecutor
{
	public TaskExecutorImpl(int n)
	{
	
	}
	

	@Override
	public void addTask(Task task)
	{
		// TODO Complete the implementation
				BlockingFiniteQueue buffer = new BlockingFiniteQueue();

				Producer producer= new Producer(buffer,10);
				Thread t1 = new Thread(producer, "Producer");
				t1.start();

				for(int i = 0; i < 10; i++) {
					Consumer consumer = new Consumer(buffer);
					Thread t2 = new Thread(consumer, "Consumer"  + i);
					t2.start();
				}
	}

}
