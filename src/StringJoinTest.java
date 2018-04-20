import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is the type StringJoinTest.
 *
 * @author <a href="mailto:jsvg88@scania.com">jsvg88</a>
 * @since 2018-03-09
 */
public class StringJoinTest {
    public static void main(String... args){
        final List<String> strings = Arrays.asList("One", "Two", "Three");
        System.out.println(String.join(",", strings));
        System.out.println(String.join(",", Collections.emptyList()));
        System.out.println(String.join(",", Collections.emptyList()).length());

        List<Tuple> list = new ArrayList<>(10);
        for( int i = 0; i<10; ++i) {
            list.add(new Tuple("first", String.valueOf(i)));
        }

        final String collect = list.stream().map(Tuple::getSecond).collect(Collectors.joining(","));
        System.out.println(collect);
        List<Tuple> derp = Collections.emptyList();
        final String collect1 = derp.stream().map(Tuple::getSecond).collect(Collectors.joining(","));
        System.out.println(collect1);
        System.out.println(collect1.length());

    }

}

