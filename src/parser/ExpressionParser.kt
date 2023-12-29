package parser

import helper.ExpressionReader
import helper.ReversePolishConverter
import model.Const
import model.Expression
import model.Operation
import model.Variable
import model.operators.Operator
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

class ExpressionParser(
    private val expressionReader: ExpressionReader,
    private val reversePolishConverter: ReversePolishConverter
) {
    fun parse(s: String?, index: AtomicInteger?): Expression {
        val expressions = expressionReader.readExpressions(
            s!!,
            index!!
        )
        val reverse = reversePolishConverter.convertToReversePolish(expressions)
        val deque: Deque<Expression> = ArrayDeque()
        for (expression in reverse) {
            if (expression is Variable || expression is Const) {
                deque.addFirst(expression)
            }
            if (expression is Operator) {
                val sec = deque.pollFirst()
                val fir = deque.pollFirst()
                deque.addFirst(Operation(fir, expression, sec))
            }
        }
        return deque.pollFirst()
    }
}