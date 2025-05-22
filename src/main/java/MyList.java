import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-05-22 20:47
 */
public record MyList<T>(T head, MyList<T> tail) {

    static <T> MyList<T> of(T... elements) {
        MyList<T> list = null;

        for (int i = elements.length - 1; i >= 0; i--) {
            list = new MyList<>(elements[i], list);
        }
        return list;
    }

    static <T, U> MyList<U> map(MyList<T> list, Function<T, U> mapper) {
        if (list == null) {
            return null;
        }
        return new MyList<>(mapper.apply(list.head), map(list.tail, mapper));
    }

    static <T> MyList<T> filter(MyList<T> list, Predicate<T> predicate) {
        if (list == null) {
            return null;
        }
        if (predicate.test(list.head)) {
            return new MyList<>(list.head, filter(list.tail, predicate));
        }
        return filter(list.tail, predicate);
    }

    static <T, U> U reduce(MyList<T> list, U initialValue, BiFunction<U, T, U> reducer) {
        if (list == null) {
            return initialValue;
        }
        return reducer.apply(reduce(list.tail, initialValue, reducer), list.head);
    }

    static String join(MyList<String> list, String delimiter) {
        if (list == null) {
            return "";
        }
        if (list.tail == null) {
            return list.head;
        }
        return list.head + delimiter + join(list.tail, delimiter);
    }
}
