package code.primitiveobsession.contactphone;

public class PhoneNumber {
    private String value;

    public PhoneNumber(String value) {
        if (!value.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}