package com.example.library.examples

import com.example.library.Calculator
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class CalculatorExampleTest : FunSpec({

    test("calculate sum of numbers") {
        // Sample list of numbers to process
        val numbers = listOf(10.0, 5.0, 7.5, 3.2, 9.8, 6.4)

        // Create a calculator instance
        val calculator = Calculator()

        // Calculate the sum of all numbers
        var sum = 0.0
        for (number in numbers) {
            sum = calculator.add(sum, number)
        }

        // Verify the sum
        sum shouldBe 41.9

        // Calculate the average
        val average = calculator.divide(sum, numbers.size.toDouble())

        // Verify the average
        average shouldBe 41.9 / 6.0
    }

    test("calculate sum of squares") {
        // Sample list of numbers to process
        val numbers = listOf(10.0, 5.0, 7.5, 3.2, 9.8, 6.4)

        // Create a calculator instance
        val calculator = Calculator()

        // Calculate the sum of squares
        var sumOfSquares = 0.0
        for (number in numbers) {
            val square = calculator.power(number, 2.0)
            sumOfSquares = calculator.add(sumOfSquares, square)
        }

        // Verify the sum of squares
        val expected = 10.0*10.0 + 5.0*5.0 + 7.5*7.5 + 3.2*3.2 + 9.8*9.8 + 6.4*6.4
        sumOfSquares shouldBe expected
    }

    test("test with mocks") {
        // Create a mock of the Calculator class
        val calculatorMock = mockk<Calculator>()

        // Define behavior for the mock
        every { calculatorMock.add(any(), any()) } answers { arg<Double>(0) + arg<Double>(1) }
        every { calculatorMock.power(any(), 2.0) } answers { arg<Double>(0) * arg<Double>(0) }

        // Sample list of numbers to process
        val numbers = listOf(10.0, 5.0, 7.5)

        // Calculate the sum of squares using the mock
        var sumOfSquares = 0.0
        for (number in numbers) {
            val square = calculatorMock.power(number, 2.0)
            sumOfSquares = calculatorMock.add(sumOfSquares, square)
        }

        // Verify the sum of squares
        val expected = 10.0*10.0 + 5.0*5.0 + 7.5*7.5
        sumOfSquares shouldBe expected

        // Verify that the methods were called the expected number of times
        verify(exactly = 3) { calculatorMock.power(any(), 2.0) }
        verify(exactly = 3) { calculatorMock.add(any(), any()) }
    }
})
