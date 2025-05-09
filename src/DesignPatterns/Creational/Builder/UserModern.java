package DesignPatterns.Creational.Builder;

public class UserModern {

    private String name;
    private int age;
    private String password;
    private String email;


    public UserModern(){

    }

    private UserModern(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.password = builder.password;
        this.email = builder.email;
    }

    public Builder builder(String firstName, String lastName) {
        return new Builder(firstName, lastName);
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


        public UserModern build() {
            return new UserModern(this);
        }
    }

    @Override
    public String toString() {
        return "UserModern{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", passowrd='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
