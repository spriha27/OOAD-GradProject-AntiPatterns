package code.primitiveobsession.useremail;

public class User {
    private Email email;

    public User(Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    public static void main(String[] args) {
        Email email = new Email("test@example.com");
        User user = new User(email);
        System.out.println("User email: " + user.getEmail().getValue());
    }
}