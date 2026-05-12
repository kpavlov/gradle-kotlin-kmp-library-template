package com.example.library

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class CalculatorJvmTest {

    private val calculator = Calculator()

    @Test
    fun `formatResult should round to specified decimal places`() {
        calculator.formatResult(3.14159, 2) shouldBe "3.14"
        calculator.formatResult(3.14159, 4) shouldBe "3.1416"
        calculator.formatResult(1.0, 0) shouldBe "1"
    }

    @Test
    fun `formatResult should handle negative numbers`() {
        calculator.formatResult(-5.678, 1) shouldBe "-5.7"
    }

    @Test
    fun `formatResult should handle zero`() {
        calculator.formatResult(0.0, 2) shouldBe "0.00"
    }
}
