import java.util.function.Function;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-05-22 20:45
 */
public class FunctionalUtils {

    private FunctionalUtils() {}

    static <T, U> U pipe(T value, Function<T, U> f) {
        return f.apply(value);
    }

    static <T, U, V> V pipe(T value, Function<T, U> f, Function<U, V> g) {
        return g.apply(f.apply(value));
    }

    static <T, U, V, W> W pipe(T value, Function<T, U> f, Function<U, V> g, Function<V, W> h) {
        return h.apply(g.apply(f.apply(value)));
    }
}
