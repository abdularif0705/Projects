public class SpecialList {
    private String name;
    private String specialty;
    private ContactNumber cn;
    private Address addy;

    SpecialList(){
        this.name = "";
        this.specialty = "";
        this.cn = new ContactNumber();
        this.addy = new Address();
    }

    SpecialList(String name, String specialty, Address addy, ContactNumber cn){
        this.name = name;
        this.specialty = specialty;
        this.cn = cn;
        this.addy = addy;
    }

    public String getName() {
        return name;
    }
    public String getSpecialty(){
        return specialty;
    }
    public Address getAddy(){
        return addy;
    }
    public ContactNumber getCn(){
        return cn;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSpecialty(String specialty){
        this.specialty = specialty;
    }
    public void setAddy(Address addy){
        this.addy = addy;
    }
    public void setCn(ContactNumber cn){
        this.cn = cn;
    }
}