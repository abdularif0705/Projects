public class ContactNumber{

   private String areacode;
   private int number;

   public ContactNumber(){
       this.areacode = "";
       this.number = 0;
   }

   public  ContactNumber(String inpArea, int inpNum){
       this.areacode = inpArea;
       this.number = inpNum;
   }

   public void changeCode(String newCode){
       this.areacode = newCode;
   }
   public void changeNum(int newNum){
       this.number = newNum;
   }
   public String getCode(){
       return areacode;
   }
   public int getNumber(){
       return number;
   }
}