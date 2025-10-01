open class Phone(open var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    open fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(override var isScreenLightOn: Boolean = false, var isFolded: Boolean = false) :
    Phone(isScreenLightOn) {
    override fun switchOn() {
        if (isFolded) {
            isScreenLightOn = true
        }
    }

    fun fold() {
        isFolded = true
    }

    fun unfold() {
        isFolded = false
    }

    fun checkIfPhoneIsFolded() {
        val phoneFolded = if (isFolded) "folded" else "open"
        println("The phone is $phoneFolded")
    }
}