import kotlin.math.pow

// Extension function for task 1
fun Int.pow(exponent: Int): Int {
    return this.toDouble().pow(exponent).toInt()
}

// Extension function for task 2
fun Int.pow(exponent: Int, action: (Int) -> Unit) {
    val result = this.toDouble().pow(exponent).toInt()
    action(result)
}

// Extension function for task 3
fun <T> T.displayTypeInfo() {
    when (this) {
        is Int -> println("это Int")
        is String -> println("это String")
        else -> println("тип у $this неизвестен")
    }
}

// Sealed class for task 4
sealed class DataType {
    data class DoubleType(val value: Double) : DataType()
    object UnitType : DataType()
}

// Extension function for DataType
fun DataType.displayTypeInfo() {
    when (this) {
        is DataType.DoubleType -> println("это DoubleType со значением $value")
        DataType.UnitType -> println("это Unit")
    }
}

// Function to display menu
fun displayMenu() {
    println("Выберите задачу для выполнения:")
    println("1. Возвести число в степень")
    println("2. Возвести число в степень и передать результат в лямбду")
    println("3. Отобразить информацию о типе")
    println("4. Отобразить информацию о DataType")
    println("0. Выйти")
}

fun main(args: Array<String>) {
    while (true) {
        displayMenu()
        val choice = readLine()?.toIntOrNull() ?: -1

        when (choice) {
            1 -> {
                println("Введите число:")
                val number = readLine()?.toIntOrNull() ?: continue
                println("Введите степень:")
                val exponent = readLine()?.toIntOrNull() ?: continue
                println("Результат: ${number.pow(exponent)}")
            }
            2 -> {
                println("Введите число:")
                val number = readLine()?.toIntOrNull() ?: continue
                println("Введите степень:")
                val exponent = readLine()?.toIntOrNull() ?: continue
                number.pow(exponent) {
                    println("Результат: $it")
                }
            }
            3 -> {
                println("Введите значение (можно число, строку, логическое значение):")
                val input = readLine()
                when {
                    input?.toIntOrNull() != null -> input.toInt().displayTypeInfo()
                    input?.toBooleanStrictOrNull() != null -> input.toBooleanStrict().displayTypeInfo()
                    else -> input.displayTypeInfo()
                }
            }
            4 -> {
                println("Выберите тип DataType:")
                println("1. DoubleType")
                println("2. UnitType")
                val typeChoice = readLine()?.toIntOrNull() ?: continue
                when (typeChoice) {
                    1 -> {
                        println("Введите значение Double:")
                        val value = readLine()?.toDoubleOrNull() ?: continue
                        DataType.DoubleType(value).displayTypeInfo()
                    }
                    2 -> {
                        DataType.UnitType.displayTypeInfo()
                    }
                }
            }
            0 -> return
            else -> println("Неверный выбор. Попробуйте снова.")
        }
    }
}
