import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Ex6 {

    //TIL that Java has iterators for its data structures kind of like C++ has for its STL library data structures.
    //Initially tried to do this by iterating using a for loop for(String student: studentNames) but apparently since I am doing mutating operations that change the structure of the list it throws an error (fun fact: when I was first learning C++ I had a very similar issue first time I used the Vector class, so I guess I am bound to make the same mistake no matter the language).
    //Linked lists do have a method to delete a specific element depending on its value but it only deletes the first occurrence

    public static void removeStudent(LinkedList<String> studentNames, String name){
        Iterator<String> iterator = studentNames.iterator();

        while(iterator.hasNext()){
            String student = iterator.next();
            if(student.equals(name))
                iterator.remove();
        }
    }

    public static void main(String[] args) {
        String[] names = {"Daniel", "Andrei", "Marcel", "Alex", "Ioan", "Cosmin", "Andreea"};
        LinkedList<String> studentNames = new LinkedList<>(Arrays.asList(names));



        System.out.println(studentNames);

        removeStudent(studentNames, "Daniel");
        removeStudent(studentNames, "Costel");
        removeStudent(studentNames, "Alex");

        System.out.println(studentNames);
    }
}
