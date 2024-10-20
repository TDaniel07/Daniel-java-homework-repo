import java.util.Objects;

public class Rectangle {
    int width, height;

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object object){
        if(object == null)
            return false;
        if(object == this)
            return true;
        if(!(object instanceof Rectangle))
            return false;

        Rectangle rectangle = (Rectangle) object;

        return rectangle.width == this.width && rectangle.height == this.height;
    }
    @Override
    public int hashCode(){
        return Objects.hash(width, height);
    }
}
