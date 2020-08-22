public class Relative{

   private String relativeName, relation;
   private int patientRank;
   private ContactNumber patientContact;

   public Relative(){
       this.relativeName = "";
       this.relation = "";
       this.patientRank = 0;
   }

   public Relative(String inpName, String inpRelation, int inpRank, ContactNumber inpContact){
       this.relativeName = inpName;
       this.relation = inpRelation;
       this.patientRank = inpRank;
       this.patientContact = inpContact;
   }

   public void changeRelativeName(String newRelative){
       this.relativeName = newRelative;
   }
   public void changeRelation(String newRelation){
       this.relation = newRelation;
   }
   public void changeRank(int newRank){
       this.patientRank = newRank;
   }
   public void changeRelativeContact(ContactNumber newContact){
       this.patientContact = newContact;
   }
   public String getRelativeName(){
       return relativeName;
   }
   public String getRelation(){
       return relation;
   }
   public int getRank(){
       return patientRank;
   }
   public ContactNumber getRelativeContact(){
       return patientContact;
   }
}