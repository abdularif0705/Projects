public class Lab1 {
        public static void main(String[] args){
                float bank = 10000;
                float interest = 0;
                int month = 0;
                while(bank >= 0){
                        interest += 500;
                        bank -= 500 +interest*0.5;
                        month++;
                }
                System.out.println("The account is undepleted for "+month+"'s");
        }
}
