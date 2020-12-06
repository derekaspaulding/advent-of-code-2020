package day4

private val YEAR_REGEX = Regex("^\\d{4}\$")
private val INCHES_REGEX = Regex("^\\d+in\$")
private val CENTIMETERS_REGEX = Regex("^\\d+cm\$")
private val HAIR_COLOR_REGEX = Regex("^#[a-f0-9]{6}\$")
private val EYE_COLOR_REGEX = Regex("^(amb|blu|brn|gry|grn|hzl|oth)\$")
private val PASSPORT_ID_REGEX = Regex("^\\d{9}\$")

class Passport(rawPassport: String, validate: Boolean = false) {
    private val missingRequiredProperties = mutableListOf(
        "byr",
        "iyr",
        "eyr",
        "hgt",
        "hcl",
        "ecl",
        "pid",
    )

    init {
        val fields = rawPassport.replace("\n", " ").split(" ")
        for (field in fields) {
            val (fieldCode, value) = field.split(":")
            val isValid = when (fieldCode) {
                "byr" -> !validate || YEAR_REGEX.matches(value) && value.toInt() in 1920..2002
                "iyr" -> !validate || YEAR_REGEX.matches(value) && value.toInt() in 2010..2020
                "eyr" -> !validate || YEAR_REGEX.matches(value) && value.toInt() in 2020..2030
                "hgt" -> !validate || when {
                    INCHES_REGEX.matches(value) -> value.removeSuffix("in").toInt() in 59..76
                    CENTIMETERS_REGEX.matches(value) -> value.removeSuffix("cm").toInt() in 150..193
                    else -> false
                }
                "hcl" -> !validate || HAIR_COLOR_REGEX.matches(value)
                "ecl" -> !validate || EYE_COLOR_REGEX.matches(value)
                "pid" -> !validate || PASSPORT_ID_REGEX.matches(value)
                "cid" -> true
                else -> { false }
            }

            if (isValid) {
                missingRequiredProperties.remove(fieldCode)
            }
        }
    }

    fun isValid() = missingRequiredProperties.size == 0


}