package ExtensionFunctionsTest;

public class TestExtensionsRunner {
    public static void main(String... args) {
        TestExtensionsPOJO obj = new TestExtensionsPOJO();
        //System.out.println(obj.add()); <-- NO WORKYWORKY
        System.out.println(KotlinExtension.add(obj));
    }
}
