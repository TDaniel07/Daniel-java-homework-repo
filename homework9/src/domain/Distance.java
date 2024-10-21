package domain;

public class Distance {
    private int kilometers;
    private int meters;
    private int totalMeters;

    public Distance(){
        this.kilometers = 0;
        this.meters = 0;
        this.totalMeters = 0;
    }

    public Distance(int meters){
        totalMeters = meters;
        separateIntoParts();
    }

    public int getKilometers() {
        return kilometers;
    }

    public int getMeters(){
        return meters;
    }

    public int getTotalMeters(){
        return totalMeters;
    }

    public void addMeters(int meters){
        totalMeters += meters;
        separateIntoParts();
    }

    public void addKilometers(int kilometers){
        totalMeters += kilometers * 1000;
        separateIntoParts();
    }

    public void setMeters(int meters){
        totalMeters = meters;
        separateIntoParts();
    }

    private void separateIntoParts(){
        kilometers = totalMeters / 1000;
        meters = totalMeters % 1000;
    }
}
