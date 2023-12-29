package model.operators

class Divide : Operator() {
    override val priority: Int
        get() = 3

    override fun toString(): String {
        return "/"
    }
}