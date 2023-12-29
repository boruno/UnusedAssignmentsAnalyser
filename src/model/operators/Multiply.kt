package model.operators

class Multiply : Operator() {
    override val priority: Int
        get() = 3

    override fun toString(): String {
        return "*"
    }
}