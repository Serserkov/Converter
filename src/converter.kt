package converter
import java.util.Scanner

enum class Weight(val ratio: Double, val nameOne: String, val nameMany: String, val mark: Int) {
    M(1.0, "meter", "meters", 1), METER(1.0, "meter", "meters", 1),
    METERS (1.0, "meter", "meters", 1),
    KM(1000.0, "kilometer", "kilometers", 1), KILOMETER(1000.0, "kilometer", "kilometers", 1),
    KILOMETERS (1000.0, "kilometer", "kilometers", 1),
    CM(0.01,"centimeter", "centimeters", 1), CENTIMETER(0.01,"centimeter", "centimeters", 1),
    CENTIMETERS(0.01,"centimeter", "centimeters", 1),
    MM(0.001, "millimeter", "millimeters", 1), MILLIMETER(0.001, "millimeter", "millimeters", 1),
    MILLIMETERS(0.001, "millimeter", "millimeters", 1),
    MI(1609.35, "mile", "miles", 1), MILE(1609.35, "mile", "miles", 1),
    MILES(1609.35, "mile", "miles", 1),
    YD(0.9144, "yard", "yards", 1), YARD(0.9144, "yard", "yards", 1),
    YARDS(0.9144, "yard", "yards", 1),
    FT(0.3048, "foot", "feet", 1), FOOT(0.3048, "foot", "feet", 1),
    FEET(0.3048, "foot", "feet", 1),
    IN(0.0254, "inch", "inches", 1), INCH(0.0254, "inch", "inches", 1),
    INCHES(0.0254, "inch", "inches", 1),
    G(1.0, "gram", "grams", 2), GRAM(1.0, "gram", "grams", 2),
    GRAMS(1.0, "gram", "grams", 2),
    KG(1000.0, "kilogram", "kilograms", 2), KILOGRAM(1000.0, "kilogram", "kilograms", 2),
    KILOGRAMS(1000.0, "kilogram", "kilograms", 2),
    MG(0.001, "milligram", "milligrams", 2),  MILLIGRAM(0.001, "milligram", "milligrams", 2),
    MILLIGRAMS(0.001, "milligram", "milligrams", 2),
    LB(453.592, "pound", "pounds", 2), POUND(453.592, "pound", "pounds", 2),
    POUNDS(453.592, "pound", "pounds", 2),
    OZ(28.3495, "ounce", "ounces", 2), OUNCE(28.3495, "ounce", "ounces", 2),
    OUNCES(28.3495, "ounce", "ounces", 2),
    CELSIUS(0.0, "degree Celsius", "degrees Celsius", 3), DC(0.0, "degree Celsius", "degrees Celsius", 3),
    C(0.0, "degree Celsius", "degrees Celsius", 3),
    FAHRENHEIT(0.0, "degree Fahrenheit", "degrees Fahrenheit", 3), DF(0.0, "degree Fahrenheit", "degrees Fahrenheit", 3),
    F(0.0, "degree Fahrenheit", "degrees Fahrenheit", 3),
    KELVIN(0.0, "Kelvin", "Kelvins", 3), KELVINS(0.0, "Kelvin", "Kelvins", 3),
    K(0.0, "Kelvin", "Kelvins", 3)
}



fun main() {
    val scan = Scanner(System.`in`)
    var escape = "begin"
    var quantityIn: Double
    var quantityOut: Double
    loop@ while (escape != "exit") {
        print("Enter what you want to convert (or exit): ")
        var measureInOne = "???"
        var measureInMany = "???"
        var measureOutOne = "???"
        var measureOutMany = "???"
        var ratioIn = -1.0
        var ratioOut = -1.0
        var markIn = 0
        var markOut = 0
        var input = scan.nextLine().trim().split(" ")
        if (input[0] == "exit") {
            escape = "exit"
            continue
        }
        try {
            quantityIn = input[0].toDouble()
        } catch (e: NumberFormatException) {
            println("Parse error")
            continue
        }
        when (input.size) {
            4 -> {
                for (enum in Weight.values()) {
                    if (input[1].toUpperCase() == enum.name) {
                        measureInOne = enum.nameOne
                        measureInMany = enum.nameMany
                        ratioIn = enum.ratio
                        markIn = enum.mark
                    }
                    if (input[3].toUpperCase() == enum.name) {
                        measureOutOne = enum.nameOne
                        measureOutMany = enum.nameMany
                        ratioOut = enum.ratio
                        markOut = enum.mark
                    }
                }
            }
            5 -> {
                if (input[1].toLowerCase() == "degree" || input[1].toLowerCase() == "degrees") {
                    for (enum in Weight.values()) {
                        if (input[2].toUpperCase() == enum.name) {
                            measureInOne = enum.nameOne
                            measureInMany = enum.nameMany
                            ratioIn = enum.ratio
                            markIn = enum.mark
                        }
                        if (input[4].toUpperCase() == enum.name) {
                            measureOutOne = enum.nameOne
                            measureOutMany = enum.nameMany
                            ratioOut = enum.ratio
                            markOut = enum.mark
                        }
                    }
                }
                else {
                    if (input[3].toLowerCase() == "degree" || input[3].toLowerCase() == "degrees") {
                        for (enum in Weight.values()) {
                            if (input[1].toUpperCase() == enum.name) {
                                measureInOne = enum.nameOne
                                measureInMany = enum.nameMany
                                ratioIn = enum.ratio
                                markIn = enum.mark
                            }
                            if (input[4].toUpperCase() == enum.name) {
                                measureOutOne = enum.nameOne
                                measureOutMany = enum.nameMany
                                ratioOut = enum.ratio
                                markOut = enum.mark
                            }
                        }
                    }
                    else {
                        println("Parse error")
                        continue@loop
                    }
                }
            }
            6 -> {
                if ((input[1].toLowerCase() == "degree" || input[1].toLowerCase() == "degrees") && (input[4].toLowerCase() == "degree" || input[4].toLowerCase() == "degrees")) {
                    for (enum in Weight.values()) {
                        if (input[2].toUpperCase() == enum.name) {
                            measureInOne = enum.nameOne
                            measureInMany = enum.nameMany
                            ratioIn = enum.ratio
                            markIn = enum.mark
                        }
                        if (input[5].toUpperCase() == enum.name) {
                            measureOutOne = enum.nameOne
                            measureOutMany = enum.nameMany
                            ratioOut = enum.ratio
                            markOut = enum.mark
                        }
                    }
                } else {
                    println("Parse error")
                    continue@loop
                }
            }
            else -> {
                println("Parse error")
                continue@loop
            }
        }
        if (markIn == 1 && input[0].toDouble() < 0.0) {
            println("Length shouldn't be negative")
            continue@loop
        }
        if (markIn == 2 && input[0].toDouble() < 0.0) {
            println("Weight shouldn't be negative")
            continue@loop
        }
        if (markIn == markOut) {
            when {
                ratioIn > 0.0 && ratioOut > 0.0 -> {
                    quantityOut = quantityIn * ratioIn / ratioOut
                    print("$quantityIn ")
                    print(if (quantityIn == 1.0) measureInOne else measureInMany)
                    print(" is $quantityOut ")
                    println(if (quantityOut == 1.0) measureOutOne else measureOutMany)
                }
                ratioIn == 0.0 && ratioOut == 0.0 -> {
                    when {
                        measureInOne == "degree Celsius" && measureOutOne == "degree Fahrenheit" -> quantityOut = quantityIn * 9 / 5 + 32
                        measureInOne == "degree Fahrenheit" && measureOutOne == "degree Celsius" -> quantityOut = (quantityIn - 32) * 5 / 9
                        measureInOne == "Kelvin" && measureOutOne == "degree Celsius" -> quantityOut = quantityIn - 273.15
                        measureInOne == "degree Celsius" && measureOutOne == "Kelvin" -> quantityOut = quantityIn + 273.15
                        measureInOne == "degree Fahrenheit" && measureOutOne == "Kelvin" -> quantityOut = (quantityIn + 459.67) * 5 / 9
                        measureInOne == "Kelvin" && measureOutOne == "degree Fahrenheit" -> quantityOut = quantityIn * 9 / 5 - 459.67
                        else -> quantityOut = quantityIn
                    }
                    print("$quantityIn ")
                    print(if (quantityIn == 1.0) measureInOne else measureInMany)
                    print(" is $quantityOut ")
                    println(if (quantityOut == 1.0) measureOutOne else measureOutMany)
                }
            }
        }
        //else println("Conversion from $measureInMany to $measureOutMany is impossible")
        if ((markIn == 0 && markOut == 0) || (markIn != markOut)) println("Conversion from $measureInMany to $measureOutMany is impossible")
    }
}

