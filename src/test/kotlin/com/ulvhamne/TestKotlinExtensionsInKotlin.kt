package com.ulvhamne

import com.ulvhamne.extensionfunctionstest.TestExtensionsPOJO
import com.ulvhamne.extensionfunctionstest.add
import org.junit.Test
import kotlin.test.assertEquals

class TestKotlinExtensionsInKotlin {
    @Test
    fun testThatExtensionExistsInKotlin() = assertEquals(TestExtensionsPOJO().add(), 8, "No extension function found")
}