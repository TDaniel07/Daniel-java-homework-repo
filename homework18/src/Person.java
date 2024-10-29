public class Person {
    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString(){
        StringBuilder personString = new StringBuilder();

        personString.append("\n");
        personString.append("firstName: ").append(firstName).append("\n");
        personString.append("lastName: ").append(lastName).append("\n");
        personString.append("age: ").append(age).append("\n");

        return personString.toString();
    }
}
