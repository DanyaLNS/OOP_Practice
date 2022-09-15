package customer;

public final class Customer {
    private final int MATURE_AGE = 18;
    private String firstName;
    private String secondName;

    private int age;
    private Address address;

    private Customer MATURE_UNKNOWN_CUTOMER = new Customer("", "", MATURE_AGE, Address.EMPTY_ADDRESS);
    private Customer NON_MATURE_UNKNOWN_CUTOMER = new Customer("", "", MATURE_AGE - 1, Address.EMPTY_ADDRESS);

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isMature() {
        return age >= MATURE_AGE;
    }

}
