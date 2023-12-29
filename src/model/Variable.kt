package model

class Variable(val variable: String) : Expression() {
    override fun toString(): String {
        return variable
    }
}