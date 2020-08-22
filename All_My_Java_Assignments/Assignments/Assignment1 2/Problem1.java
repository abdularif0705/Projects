public class Problem1{

  public static void main(String[] args){
      
    double s, s0, v0, t, g, tCubed, G, pi, a, m1, m2, p; //Initialize variables all doubles for accuracy
      
    s0 = 76;
    v0 = 27;
    t = 8;
    g = 9.81; //random values for variables



    a = 8;
    p = 10;
    m1 = 55;
    m2 = 82;

    s = s0*v0-0.5*g*t*t*t;//Calculate t^3 and s
    G = (3.0/4)*(Math.PI*Math.PI)*((a*a*a)/(p*.5*(m1-m2)));
    System.out.println("G = " + G);
    System.out.println("s = " + s); //Output s
  }
}
