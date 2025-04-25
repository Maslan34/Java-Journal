package CapstoneProjects.IMS;

public class InvalidAuthenticationException extends Exception {
    public InvalidAuthenticationException() {
        super("Your credentials are incorrect. Please try again.");
    }
}
