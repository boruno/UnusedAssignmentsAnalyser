package model.operators

class Add : Operator() {
    override val priority: Int
        get() = 2

    override fun toString(): String {
        return "+"
    }
}