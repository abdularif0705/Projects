public class NimAi {
	
	private boolean EasyMode = true;
	
	
	public NimAi(boolean difficulty)
	{
		this.EasyMode = difficulty;
	}
	
	public void setDifficulty(boolean difficulty)
	{
		this.EasyMode = difficulty;
	}
	
	public boolean getDifficulty()
	{
		return this.EasyMode;
	}
	
	public void takeMarblesEasy()
	{
		//takes a random number of marbles from the pile
	}
	
	public void takeMarblesHard()
	{
		//takes a number of marbles from the pile 
	}
	
	
}
