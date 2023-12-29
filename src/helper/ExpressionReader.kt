package helper

import helper.ParserUtils.moveToNotBlank
import model.Expression
import model.operators.LeftBracket
import model.operators.Operator
import model.operators.RightBracket
import parser.ConstParser
import parser.OperatorParser
import parser.VariableParser
import java.util.concurrent.atomic.AtomicInteger

class ExpressionReader(
    private val operatorParser: OperatorParser,
    private val constParser: ConstParser,
    private val variableParser: VariableParser
) {
    fun readExpressions(s: String, index: AtomicInteger): List<Expression?> {
        val readExpressions = ArrayList<Expression?>()
        var exp: Expression? = null
        while ((readExpression(s, index, exp).also { exp = it }) != null) {
            readExpressions.add(exp)
        }
        return readExpressions
    }

    private fun readExpression(s: String, index: AtomicInteger, lastRead: Expression?): Expression? {
        moveToNotBlank(s, index)
        if (index.get() >= s.length) {
            return null
        }
        val firstChar = s[index.get()]
        if (Operator.isOperator(firstChar)) {
            return operatorParser.parse(s, index)
        }
        if (firstChar == '(') {
            index.incrementAndGet()
            return LeftBracket()
        }
        if (firstChar == ')') {
            index.incrementAndGet()
            return RightBracket()
        }
        if (lastRead == null || (lastRead is Operator && lastRead !is RightBracket)) {
            if (Character.isDigit(firstChar)) {
                return constParser.parse(s, index)
            }
            if (Character.isAlphabetic(firstChar.code)) {
                return variableParser.parse(s, index)
            }
        }
        return null
    }
}