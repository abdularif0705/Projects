public class Visit{
   private String date, reason, note, presciptions;

   public Visit(){
       this.date = "";
       this.reason = "";
       this.note = "";
       this.presciptions = "";
   }

   public Visit(String inpDate, String inpReason, String inpNote, String inpPer){
       this.date = inpDate;
       this.reason = inpReason;
       this.note = inpNote;
       this.presciptions = inpPer;
   }

   public void changeDate(String newDate){
       this.date = newDate;
   }
   public void changeReason(String newReason){
       this.reason = newReason;
   }
   public void changeNote(String newNote){
       this.note = newNote;
   }
   public void changePrescrip(String newPrescrip){
       this.presciptions = newPrescrip;
   }
   public String getDate(){
       return date;
   }
   public String getReason(){
       return reason;
   }
   public String getNote(){
       return note;
   }
   public String getPrescrip(){
       return presciptions;
   }
}