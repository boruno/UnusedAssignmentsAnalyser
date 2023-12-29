package helper

import model.Const
import model.Expression
import model.Variable
import model.operators.LeftBracket
import model.operators.Operator
import model.operators.RightBracket
import java.util.*

class ReversePolishConverter {
    fun convertToReversePolish(expressions: List<Expression?>): List<Expression> {
        val result: MutableList<Expression> = ArrayList()
        val operators: Deque<Operator> = ArrayDeque()
        for (expression in expressions) {
            if (expression is Variable || expression is Const) {
                result.add(expression)
            } else if (expression is LeftBracket) {
                operators.addFirst(expression)
            } else if (expression is RightBracket) {
                while (!operators.isEmpty() && operators.peekFirst() !is LeftBracket) {
                    result.add(operators.pollFirst())
                }
                operators.pollFirst()
            } else if (expression is Operator) {
                if (!operators.isEmpty() && operators.peekFirst().priority > expression.priority) {
                    while (!operators.isEmpty() && operators.peekFirst().priority >= expression.priority) {
                        result.add(operators.pollFirst())
                    }
                }
                operators.addFirst(expression)
            }
        }
        while (!operators.isEmpty()) {
            result.add(operators.pollFirst())
        }
        return result
    }
}