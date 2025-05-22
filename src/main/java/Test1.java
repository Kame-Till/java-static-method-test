/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-05-22 20:54
 */
public class Test1 {
    public static void main(String[] args) {
        var people = MyList.of(
                new Person("John", "Doe", 31, null),
                new Person("Jane", "Smith", 25, "janesmith@example.com"),
                new Person("Alice", "Johnson", 22, null),
                new Person("Bob", "Brown", 27, "bobbrown@example.com")
        );

        var names = FunctionalUtils.pipe(people,
                it -> MyList.filter(it, person -> person.age() < 30),
                it -> MyList.map(it, person -> person.firstName() + " " + person.lastName()),
                it -> MyList.join(it, ", "));

        System.out.println(names);
    }
}
