import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This is the type Java9Tests.
 *
 * @author <a href="mailto:jsvg88@scania.com">jsvg88</a>
 * @since 2017-09-28
 */
public class Java9Tests {
    public static void main(String... args) {
        testNewJava9();
        testSubstring();
    }

    private static void testSubstring() {
        String derp = "1234567890";
        String herp = derp.substring(0, derp.length()>30?30:derp.length());
        System.out.println(herp);
        derp = "12345678901234567890";
        herp = derp.substring(0, derp.length()>30?30:derp.length());
        System.out.println(herp);
        derp = "123456789012345678901234567890";
        herp = derp.substring(0, derp.length()>30?30:derp.length());
        System.out.println(herp);
        derp = "1234567890123456789012345678901234567890";
        herp = derp.substring(0, derp.length()>30?30:derp.length());
        System.out.println(herp);
        derp = "";
        herp = derp.substring(0, derp.length()>30?30:derp.length());
        System.out.println(herp);

    }

    private static void testNewJava9() {
        List<Integer> list = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        final List<Integer> collect = list.stream().dropWhile(x -> x < 5).collect(Collectors.toList());
        System.out.println(collect);

        final List<Integer> collect1 = list.stream().filter(x -> x >= 5).collect(Collectors.toList());
        System.out.println(collect1);
    }

}

