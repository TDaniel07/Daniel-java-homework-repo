public enum LightColor {
    RED("Stop", 30),
    YELLOW("Caution", 5),
    GREEN("Go", 45);

    private final String instruction;
    private final int duration;

    LightColor(String instruction, int duration){
        this.instruction = instruction;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public String getInstruction(){
        return instruction;
    }
}
