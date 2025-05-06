package DesignPatterns.Creational.Prototype;

public class Person implements Cloneable {

    private String firstName;
    private String lastName;
    private int age;
    private Contact contact;

    public Person(String firstName, String lastName, int age, Contact contact) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.contact = contact;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    protected Person cloneDeep() throws CloneNotSupportedException {
        Person clone = (Person) super.clone();
        clone.setContact(new Contact("-","-","-"));
        return clone;
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", contact=" + contact +
                '}';
    }
}
