public class Address{
    
   private int houseNum, postal, apartmentNum;
   private String street, city, province;

   public Address(){
       this.houseNum = 0;//This. is not needed as Java automatically sets it and uses this. but it's good practice as other classes don't
       this.postal = 0;
       this.apartmentNum = 0;
       this.street = "";
       this.city = "";
       this.province = "";
   }
   public Address(int inpHouse, String inpStreet, int inpPostal, String inpCity, String inpProv){
    this.houseNum = inpHouse;
    this.postal = inpPostal;
    this.street = inpStreet;
    this.city = inpCity;
    this.province = inpProv;
    this.apartmentNum = 0;
}
   public Address(int inpHouse, String inpStreet, int inpApart, int inpPostal, String inpCity, String inpProv){
       this.houseNum = inpHouse;
       this.postal = inpPostal;
       this.apartmentNum = inpApart;
       this.street = inpStreet;
       this.city = inpCity;
       this.province = inpProv;
   }
   public void changeHouseNum(int newHouse){
       this.houseNum = newHouse;
   }
   public void changePostal(int newPostal){
       this.postal = newPostal;
   }
   public void changeApart(int newApart){
       this.apartmentNum = newApart;
   }
   public void changeStreet(String newStreet){
       this.street = newStreet;
   }
   public void changeCity(String newCity){
       this.city = newCity;
   }
   public void changeProv(String newProv){
       this.province = newProv;
   }
   public int getHouseNum(){
       return houseNum;
   }
   public int getPostal(){
       return postal;
   }
   public int getApartment(){
       return apartmentNum;
   }
   public String getStreet(){
       return street;
   }
   public String getCity(){
       return city;
   }
   public String getProvince(){
       return province;
   }
}