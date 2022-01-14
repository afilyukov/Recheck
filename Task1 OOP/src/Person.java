public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public Person(PersonBuilder personBuilder) {
        if (personBuilder == null) {
            throw new IllegalArgumentException("Please provide person builder to build person object.");
        }
         if (personBuilder.firstName == null || personBuilder.firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("Please provide person name.");
        }
        this.firstName = personBuilder.firstName;
        this.lastName = personBuilder.lastName;
        this.middleName = personBuilder.middleName;
        this.country = personBuilder.country;
        this.address = personBuilder.address;
        this.phone = personBuilder.phone;
        this.age = personBuilder.age;
        this.gender = personBuilder.gender;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getMiddleName() {
        return this.middleName;
    }
    public String getCountry() {
        return this.country;
    }
    public String getAddress() {
        return this.address;
    }
    public String getPhone() {
        return this.phone;
    }

    public int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public static class PersonBuilder {
        protected String firstName;
        protected String lastName;
        protected String middleName;
        protected String country;
        protected String address;
        protected String phone;
        protected int age;
        protected String gender;

        public PersonBuilder() {
            super();
        }

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public PersonBuilder country(String country) {
            this.country = country;
            return this;
        }

        public PersonBuilder address(String address) {
            this.address = address;
            return this;
        }

        public PersonBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        // StringBuilder тоже builder?
        StringBuilder builder = new StringBuilder();
        builder.append("Person [FirstName=").append(firstName).append(", LastName=").append(lastName)
                .append(", MiddleName=").append(middleName).append(",  Country=").append(country)
                .append(", Address=").append(address).append(", Phone=").append(phone)
                .append(", Age=").append(age).append(", Gender=").append(gender)
                .append("]");
        return builder.toString();
    }
}