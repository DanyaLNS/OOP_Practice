package customer;

public final class Address {
    private String city;
    private String street;

    private int zipCode;
    private int building;
    private int apartment;
    private char buildingLetter;

    public static final Address EMPTY_ADDRESS = new Address("", "", 0, 0, 0, '0');

    public Address(String city, String street, int zipCode,
                   int building, int apartment, char buildingLetter) {
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.building = building;
        this.apartment = apartment;
        this.buildingLetter = buildingLetter;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public int getBuilding() {
        return building;
    }

    public int getApartment() {
        return apartment;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }
}
