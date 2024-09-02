public class Calendar {
    public long days;
    public long totalHours;
    public int hours;
    public int minutes;

    Calendar(){
        this.days = 0;
        this.hours = 0;
        this.minutes = 0;
        this.totalHours = 0;
    }
    Calendar(long days, int hours, int minutes){
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
    }

    public void print(){
        System.out.println("days: " + days);
        System.out.println("hours: " + hours);
        System.out.println("totalHours: " + totalHours);
        System.out.println("minutes: " + minutes);
    }
}
