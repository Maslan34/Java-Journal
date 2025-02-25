package Entity;

public class Customer {
    private String id;
    private String name;
    private String phone;
    private String mail;
    private String address;
    private ETYPE type;

    public enum ETYPE{
        PERSON,
        COMPANY
    }
    public Customer(){}
    public Customer(int id, String name, String phone, String mail, String address) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ETYPE getType() {
        return type;
    }

    public void setType(ETYPE type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", address='" + address + '\'' +
                ", type=" + type +
                '}';
    }
}
