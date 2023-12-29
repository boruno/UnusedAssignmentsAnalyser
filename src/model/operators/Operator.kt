package model.operators

import model.Expression

abstract class Operator : Expression() {
    abstract val priority: Int

    companion object {
        fun isOperator(c: Char): Boolean {
            return setOf('+', '-', '*', '/', '>', '<').contains(c)
        }
    }
}