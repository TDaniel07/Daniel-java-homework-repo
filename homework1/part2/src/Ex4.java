public class Ex4 {
    public static void main(String[] argv){
        int intVar;
        double doubleVar;

        intVar = 5;
        doubleVar = intVar;
        System.out.println(doubleVar);

        doubleVar = 7.2d;
        intVar = (int)doubleVar;

        System.out.println(intVar);
    }
}
