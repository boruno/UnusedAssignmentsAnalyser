package model

class InitStatement(val variable: Variable, val expression: Expression) : Statement() {
    override fun toString(): String {
        return "$variable = $expression"
    }
}