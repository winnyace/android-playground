fun main() {
    val celsiusToFahrenheit: (Double) -> Double = {
        (it * 1.8) + 32
    }

    val kelvinToCelsius: (Double) -> Double = {
        it - 273.15
    }

    val fahrenheitToKelvin: (Double) -> Double = {
        (it + 459.67) * 5/9
    }
    printFinalTemperature(
        initialMeasurement = 27.toDouble(),
        initialUnit = "Celsius",
        finalUnit = "Fahrenheit",
        conversionFormula = celsiusToFahrenheit
    )
    printFinalTemperature(
        initialMeasurement = 350.toDouble(),
        initialUnit = "Kelvin",
        finalUnit = "Celsius",
        conversionFormula = kelvinToCelsius
    )
    printFinalTemperature(
        initialMeasurement = 10.toDouble(),
        initialUnit = "Fahrenheit",
        finalUnit = "Kelvin",
        conversionFormula = fahrenheitToKelvin
    )
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}