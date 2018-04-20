import java.util.Arrays;
import java.util.List;

/**
 * This is the type AsArrayAsList.
 *
 * @author <a href="mailto:jsvg88@scania.com">jsvg88</a>
 * @since 2017-09-28
 */
public class AsArrayAsList {
    public static void main(String... args) {

        final List<String> strings = Arrays.asList("Hello world".split("(?!^)"));
        final String[] strings2 = (String[]) strings.toArray();
        final List<String> strings3 = Arrays.asList(strings2);
        final String[] strings4 = (String[]) strings3.toArray();

        System.out.println(Boolean.valueOf(strings == strings3));
        System.out.println(Boolean.valueOf(strings2 == strings4));


        System.out.println(Arrays.asList(strings4));


    }
}
