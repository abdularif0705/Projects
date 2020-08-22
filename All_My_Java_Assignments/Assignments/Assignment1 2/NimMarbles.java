import java.util.Random;

public class NimMarbles{
	
	private int TotalMarbles;
	private Random randNumber = new Random();
	
	
	public NimMarbles()
	{
		this.TotalMarbles = randNumber.nextInt(91)+10;//Creates our marble pile between 10-100 marbles
	}
	
	public void setMarbles(int marblesTaken)//removes a certain amount of marbles
	{
		if(marblesTaken>1 && marblesTaken<= TotalMarbles/2)
			TotalMarbles-=marblesTaken;
	}
	

}
