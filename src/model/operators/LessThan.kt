package model.operators

class LessThan : Operator() {
    override val priority: Int
        get() = 1

    override fun toString(): String {
        return "<"
    }
}