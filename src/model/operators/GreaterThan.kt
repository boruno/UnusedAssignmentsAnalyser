package model.operators

class GreaterThan : Operator() {
    override val priority: Int
        get() = 1

    override fun toString(): String {
        return ">"
    }
}