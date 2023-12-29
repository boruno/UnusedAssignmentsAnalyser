package model.operators

class Subtract : Operator() {
    override val priority: Int
        get() = 2

    override fun toString(): String {
        return "-"
    }
}