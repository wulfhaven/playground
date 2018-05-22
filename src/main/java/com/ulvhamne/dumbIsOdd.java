package com.ulvhamne;

/**
 * This is the type com.ulvhamne.dumbIsOdd.
 *
 * @author <a href="mailto:jsvg88@scania.com">jsvg88</a>
 * @since 2017-11-01
 */
public class dumbIsOdd {

    public static void main(String... args) {
        System.out.println(isOdd(5));
    }

    private static boolean isOdd(int num) {
        if(num == 2147483647) return true;
        else if (num == 0) return false;
        return isOdd(num+2);
    }
}
