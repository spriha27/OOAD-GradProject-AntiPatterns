package code.primitiveobsession.contactphone;

public class Contact {
    private PhoneNumber phoneNumber;

    public Contact(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber("1234567890");
        Contact contact = new Contact(phoneNumber);
        System.out.println("Contact phone number: " + contact.getPhoneNumber().getValue());
    }
}