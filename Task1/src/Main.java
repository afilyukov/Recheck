public class Main {
    public static void main(String[] args) {
        try {
            Person person1 = new Person.PersonBuilder().firstName("Alexander").lastName("Ivanov").country("Russia").gender("Unknown").build();
            System.out.println(person1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Person person2 = new Person.PersonBuilder().firstName("Ivan").country("Ukraine").gender("Male").age(27).build();
            System.out.println(person2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
