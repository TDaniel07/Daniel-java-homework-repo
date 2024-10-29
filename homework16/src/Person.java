import java.util.Objects;

public class Person {
    String name, email;
    int age;
    public Person(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public boolean equals(Object object){
        if(object == null)
            return false;
        if(object == this)
            return true;
        if(!(object instanceof Person person))
            return false;
        return person.name.equals(this.name) && person.age == this.age;
    }
    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }
}
