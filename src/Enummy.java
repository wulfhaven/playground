/**
 * This is the type Enummy.
 *
 * @author <a href="mailto:jsvg88@scania.com">jsvg88</a>
 * @since 2018-03-12
 */
public class Enummy {
    public static void main(String... args) {
        System.out.println(StakeholderReason.CREATOR.name());

    }

    public enum StakeholderReason {
        CREATOR,
        EDITOR,
        PURCHASER,
        OTHER;
    }
}
