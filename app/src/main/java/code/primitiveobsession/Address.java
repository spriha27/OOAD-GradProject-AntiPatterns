package java.code.primitiveobsession;

public class Address {
    private Street street;
    private City city;
    private PostalCode postalCode;

    public Address(Street street, City city, PostalCode postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Street getStreet() {
        return street;
    }

    public City getCity() {
        return city;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public static void main(String[] args) {
        Street street = new Street("123 Main St");
        City city = new City("New York");
        PostalCode postalCode = new PostalCode("10001");
        Address address = new Address(street, city, postalCode);

        System.out.println("Address: " + address.getStreet().getName() + ", " + address.getCity().getName() + ", " + address.getPostalCode().getCode());
    }
}

class Street {
    private String name;

    public Street(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Street name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class City {
    private String name;

    public City(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("City name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class PostalCode {
    private String code;

    public PostalCode(String code) {
        if (!code.matches("\\d{5}")) {
            throw new IllegalArgumentException("Invalid postal code");
        }
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}