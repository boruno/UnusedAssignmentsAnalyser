package model.operators

class RightBracket : Operator() {
    override val priority: Int
        get() = 0

    override fun toString(): String {
        return ")"
    }
}