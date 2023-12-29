package model

import model.operators.Operator

class Operation(val first: Expression, private val operator: Operator, val second: Expression) : Expression() {
    override fun toString(): String {
        return "$first $operator $second"
    }
}