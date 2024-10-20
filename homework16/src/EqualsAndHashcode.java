public class EqualsAndHashcode {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(100, 100);
        Rectangle rectangle2 = new Rectangle(100, 100);

        testClassEqualsAndHashcode(rectangle1, rectangle2);

        Person person1 = new Person("Daniel", 17, "test1");
        Person person2 = new Person("Daniel", 17, "test2");

        testClassEqualsAndHashcode(person1, person2);

        Student student1 = new Student(1, "Andrei", 20, "test");
        Student student2 = new Student(2, "Andrei", 20, "test");

        testClassEqualsAndHashcode(student1, student2);

    }
    public static <T> void testClassEqualsAndHashcode(T object1, T object2){
        System.out.printf("==== %s ====\n", object1.getClass());
        System.out.printf("object1 equals object2: %b\n", object1.equals(object2));
        System.out.printf("object1 hashcode: %d\n", object1.hashCode());
        System.out.printf("object2 hashcode: %d\n", object2.hashCode());
    }
}