public class Pair<K, V>{
    private K object1;
    private V object2;

    public Pair(){
        object1 = null;
        object2 = null;
    }

    public Pair(K object1, V object2){
        this.object1 = object1;
        this.object2 = object2;
    }

    public K getObject1() {
        return object1;
    }

    public V getObject2() {
        return object2;
    }

    public void setObject1(K object1) {
        this.object1 = object1;
    }

    public void setObject2(V object2) {
        this.object2 = object2;
    }

    @Override
    public String toString(){
        return "[" + object1 + "," + object2 + "]";
    }
}
