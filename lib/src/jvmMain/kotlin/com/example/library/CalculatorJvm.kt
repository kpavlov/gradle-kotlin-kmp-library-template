package com.example.library

public fun Calculator.formatResult(value: Double, decimals: Int = 2): String {
    require(decimals >= 0) { "decimals must be non-negative" }
    return "%.${decimals}f".format(value)
}

private fun Double.pow(n: Int): Double {
    var result = 1.0
    repeat(n) { result *= this }
    return result
}
