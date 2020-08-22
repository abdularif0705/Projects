import java.util.ArrayList;

public class PatientList{

    private int patientCount = 0;
    private String uniqueSignature;

    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> birthdates = new ArrayList<String>();
    private ArrayList<String> genders = new ArrayList<String>();
    private ArrayList<String> previousdiseases = new ArrayList<String>();

    private ArrayList<Visit> previousVisit = new ArrayList<Visit>();
    private ArrayList<Visit> upcomingVisit = new ArrayList<Visit>();
    private ArrayList<ContactNumber> contacts = new ArrayList<ContactNumber>();
    private ArrayList<SpecialList> listofSpecialists = new ArrayList<SpecialList>();
    private ArrayList<Relative> listOfRelatives = new ArrayList<Relative>();
    private ArrayList<Address>  addresses = new ArrayList<Address>();
  

    public PatientList(){
        this.uniqueSignature = "DOCTOR LITTLE";
    }

    public void add1(){
        names.add("Jaquan The Third");
        birthdates.add("December 27");
        genders.add("Male");
        previousVisit.add(new Visit("02/22/2019", "Fever", "Minor effects but will be ok", "Advil"));
        upcomingVisit.add(new Visit("03/12/2020", "AIDS", "It came back", "N/A"));
        previousdiseases.add("SARS");
        contacts.add(new ContactNumber("+519", 9781814));
        listofSpecialists.add(new SpecialList("Donny Jones", "Anime Tiddies Expert", new Address(9873, "Apple Lane", 48084, "Toronto", "ON"), new ContactNumber("+226", 9018285)));
        listOfRelatives.add(new Relative("Shaquan The Thecond", "Sister", 2 , new ContactNumber("+91", 822435)));
        addresses.add(new Address(9815,"Asgard Street", 99123, "Windsor", "ON"));
        patientCount++;  
    }
    public void add2(){
        names.add("Seana");
        birthdates.add("April 6");
        genders.add("Female");
        previousVisit.add(new Visit("11/05/2019", "Flu", "Could barely walk", "Tylonel 3"));
        upcomingVisit.add(new Visit("04/17/2020", "Check-Up", "Status on Flu", "N/A"));
        previousdiseases.add("N/A");
        contacts.add(new ContactNumber("+212", 9137270));
        listofSpecialists.add(new SpecialList("Danny Special", "Toenail Expert", new Address(11525, "Walker Road", 11626, "Brooklyn", "NY"), new ContactNumber("+212", 9085285)));
        listOfRelatives.add(new Relative("Dawna", "Mother", 1 , new ContactNumber("+212", 6618457)));
        addresses.add(new Address(2216,"York Street", 6, 11552, "Brooklyn", "NY"));
        patientCount++;  
    }

    public void showAll(){
        for(int index = 0; index < patientCount; index++){
            System.out.println("\nData #" + index + "\n\n");
            System.out.println("Patient Name: " + names.get(index));
            System.out.println("Patient DOB: " + birthdates.get(index));
            System.out.println("Patient Gender: " + genders.get(index));

            System.out.println("Previous Visit date: " + previousVisit.get(index).getDate());
            System.out.println("Previous visit note: " + previousVisit.get(index).getNote());
            System.out.println("Previous diseases: " + previousdiseases.get(index));

            System.out.println("Area code: " + contacts.get(index).getCode());
            System.out.println("Phone number: " + contacts.get(index).getNumber());

            System.out.println("Street Name: " + addresses.get(index).getStreet());
            System.out.println("House Number: " + addresses.get(index).getHouseNum());
            System.out.println("Postal Code: " + addresses.get(index).getCity());
            System.out.println("Apartment (0 means no apartment): " + addresses.get(index).getApartment());
            System.out.println("City: " + addresses.get(index).getCity());
            System.out.println("Province: " + addresses.get(index).getProvince());

            System.out.println("Relatives Name: " + listOfRelatives.get(index).getRelativeName());
            System.out.println("Relatives Relation: " + listOfRelatives.get(index).getRelation());
            System.out.println("Relatives Priority: " + listOfRelatives.get(index).getRank());
            System.out.println("Relatives Number: " + listOfRelatives.get(index).getRelativeContact().getNumber());
            System.out.println("Relatives Area Code: " + listOfRelatives.get(index).getRelativeContact().getCode());

            System.out.println("Signature: " + uniqueSignature);
            System.out.println();
        }
    }

    public void showAt(String inpName){
        for(int index = 0; index < patientCount; index++) {
            if (inpName.equals(names.get(index))) {
                System.out.println("\nData #" + index + "\n\n");
                System.out.println("Patient Name: " + names.get(index));
                System.out.println("Patient DOB: " + birthdates.get(index));
                System.out.println("Patient Gender: " + genders.get(index));

                System.out.println("Previous Visit date: " + previousVisit.get(index).getDate());
                System.out.println("Previous visit note: " + previousVisit.get(index).getNote());
                System.out.println("Previous diseases: " + previousdiseases.get(index));

                System.out.println("Area code: " + contacts.get(index).getCode());
                System.out.println("Phone number: " + contacts.get(index).getNumber());

                System.out.println("Street Name: " + addresses.get(index).getStreet());
                System.out.println("House Number: " + addresses.get(index).getHouseNum());
                System.out.println("Postal Code: " + addresses.get(index).getCity());
                System.out.println("Apartment (0 means no apartment): " + addresses.get(index).getApartment());
                System.out.println("City: " + addresses.get(index).getCity());
                System.out.println("Province: " + addresses.get(index).getProvince());

                System.out.println("Relatives Name: " + listOfRelatives.get(index).getRelativeName());
                System.out.println("Relatives Relation: " + listOfRelatives.get(index).getRelation());
                System.out.println("Relatives Priority: " + listOfRelatives.get(index).getRank());
                System.out.println("Relatives Number: " + listOfRelatives.get(index).getRelativeContact().getNumber());
                System.out.println("Relatives Area Code: " + listOfRelatives.get(index).getRelativeContact().getCode());

                System.out.println("Signature: " + uniqueSignature);
                System.out.println();
            }
        }
    }

    public void deleteData(int index){
        if(index < patientCount){
            names.remove(index);
            birthdates.remove(index);
            genders.remove(index);
            previousVisit.remove(index);
            upcomingVisit.remove(index);
            previousdiseases.remove(index);
            contacts.remove(index);
            listOfRelatives.remove(index);
            listofSpecialists.remove(index);
            addresses.remove(index);
            patientCount--;
        }
    }

    public void updateNum(int newNum, String inpName){
        for(int i = 0; i < names.size(); i++){
            if(inpName.equals(names.get(i))){
                contacts.get(i).changeNum(newNum);
            }
        }
    }
    public void updateCode(String newCode, String inpName){
        for(int i = 0; i < names.size(); i++){
            if(inpName.equals(names.get(i))){
                contacts.get(i).changeCode(newCode);
            }
        }
    }
    public void updateCity(String newCity, String inpName){
        for(int i = 0; i < names.size(); i++){
            if(inpName.equals(names.get(i))){
                addresses.get(i).changeCity(newCity);
            }
        }
    }
    public void updateProv(String newProv, String inpName){
        for(int i = 0; i < names.size(); i++){
            if(inpName.equals(names.get(i))){
                addresses.get(i).changeProv(newProv);
            }
        }
    }
    public void changeSignature(String newSig){
        this.uniqueSignature = newSig;
    }
}