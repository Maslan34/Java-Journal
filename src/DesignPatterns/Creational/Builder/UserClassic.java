package DesignPatterns.Creational.Builder;

public class UserClassic {

    private String name;
    private int age;
    private String passowrd;
    private String email;



    private UserClassic(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.passowrd = builder.password;
        this.email = builder.email;
    }

    public static class Builder {
        // Required
        private final String password;
        private final String email;
        // Optinal
        private String name="";
        private int age=0;

        public Builder(String email, String password) {
            this.password = password;
            this.email = email;
        }


        public Builder name(String name) {
            this.name = name;
            return this; // Returning Builder object to function chanining
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }


        public UserClassic build() {
            return new UserClassic(this);
        }
    }

    @Override
    public String toString() {
        return "UserClassic{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", passowrd='" + passowrd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
