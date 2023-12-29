package model.operators

class LeftBracket : Operator() {
    override val priority: Int
        get() = 0

    override fun toString(): String {
        return "("
    }
}