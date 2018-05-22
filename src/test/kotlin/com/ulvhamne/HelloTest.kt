package com.ulvhamne

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFalse

class HelloTest {
    @Test fun fail() = assertFalse { false }
}
