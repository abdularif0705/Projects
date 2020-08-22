public class Microwave{
    private int power;
    private int time;
    private String status;


    //Constructor
    public Microwave(){
      this.time = 0;
      this.power = 1;
      this.status = "OFF";
    }

    //Increases time by 30 seconds
    public void increaseTime(){
      this.time += 30;
    }

    //Cycles through power
    public void switchLevel(){
        if(this.status == "ON" && this.time>0){
            if(this.power==1)
                System.out.println("Cooking for "+ time + " seconds on low");
            if(this.power==2)
                System.out.println("Cooking for "+ time + " seconds on medium");
            if(this.power==3)
                System.out.println("Cooking for "+ time + " seconds on High");
            this.time = 0;
        }
        if(this.power>=3)
            this.power-=2;
        else
            this.power++;
    }

    // Starts microwaving process, changes status, and displays starting info to user

    public void startButton(){
      this.status = "ON";
      System.out.println("Status: " + status);
    }

    // Stops microwaving process, changes status, and displays ending info to user

    public void stopButton(){
        if(status=="ON"){
            this.status = "OFF";
            System.out.println("Status: " + status + "\nCooking stopped.");
        }

    }
    //Resets microwave elements to initial values
    public void resetButton(){
      this.time = 0;
      this.power = 1;
      this.status = "OFF";
      System.out.println("Reset microwave.");
    }

  }
