package ExtensionFunctionsTest;

public class TestExtensionsRunner {
    public static void main(String... args) {
        TestExtensionsPOJO obj = new TestExtensionsPOJO();
        //System.out.println(obj.add()); <-- dNO WORKYWORKY
        System.out.println(TestExtensionsFunctionsKt.add(obj));
    }
}
