package model

class Const(private val number: Int) : Expression() {
    override fun toString(): String {
        return number.toString()
    }
}