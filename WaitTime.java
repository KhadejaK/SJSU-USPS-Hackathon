package usps;

public class WaitTime
//extends location
{
	private int waitTime;
	
	public WaitTime(int waitTime)
	{
		this.waitTime = waitTime;
	}
	
	public int getWaitTime()
	{
		return this.waitTime;
	}
	
	public void addWaitTime(int taskTime)
	{
		this.waitTime = this.waitTime + taskTime;
	}
	
	public void subtractWaitTime(int taskTime)
	{
		this.waitTime = this.waitTime - taskTime;
	}
	
	public static void main(String[] args)
	{
		WaitTime wt = new WaitTime(50);
	}
}
