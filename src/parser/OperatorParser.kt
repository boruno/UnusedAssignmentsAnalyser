package parser

import helper.ParserUtils.moveToNotBlank
import model.operators.*
import java.util.concurrent.atomic.AtomicInteger

class OperatorParser {
    fun parse(s: String, index: AtomicInteger): Operator {
        moveToNotBlank(s, index)
        val operator = s[index.get()]
        index.incrementAndGet()
        return when (operator) {
            '+' -> Add()
            '-' -> Subtract()
            '*' -> Multiply()
            '/' -> Divide()
            '>' -> GreaterThan()
            '<' -> LessThan()
            else -> throw RuntimeException("Invalid operator: $operator")
        }
    }
}