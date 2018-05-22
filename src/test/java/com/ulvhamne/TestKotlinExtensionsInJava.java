package com.ulvhamne;

import com.ulvhamne.extensionfunctionstest.KotlinExtension;
import com.ulvhamne.extensionfunctionstest.TestExtensionsPOJO;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestKotlinExtensionsInJava {
    @Test
    public void testThatExtensionFunctionIsAvailable() {
        TestExtensionsPOJO obj = new TestExtensionsPOJO();
        //System.out.println(obj.add()); <-- NO WORKYWORKY
        assertEquals("It did not do the magic!",  KotlinExtension.add(obj), 8); //This workyworky!

    }
}
