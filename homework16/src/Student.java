import java.util.Objects;

public class Student {
    String name, email;
    int age, studentId;

    public Student(int studentId, String name, int age, String email){
        this.studentId = studentId;
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
        if(!(object instanceof Student))
            return false;
        Student student = (Student) object;

        return name.equals(student.name) && email.equals(student.email) && age == student.age;
    }
    @Override
    public int hashCode(){
        return Objects.hash(name, email, age);
    }
}
