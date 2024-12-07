package java.code.primitiveobsession.useremail;

public class Email {
    private String value;

    public Email(String value) {
        if (!value.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}