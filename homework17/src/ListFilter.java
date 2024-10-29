import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
public interface ListFilter<T> {
    List<T> filter(List<T> elements, Predicate<T> predicate);
}
