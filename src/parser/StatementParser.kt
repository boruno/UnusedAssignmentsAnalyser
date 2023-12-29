package parser

import helper.ParserUtils.moveToNotBlank
import model.IfStatement
import model.InitStatement
import model.Statement
import model.WhileStatement
import java.util.concurrent.atomic.AtomicInteger

class StatementParser(private val expressionParser: ExpressionParser, private val variableParser: VariableParser) {
    fun parse(s: String, index: AtomicInteger): Statement? {
        moveToNotBlank(s, index)
        if (index.get() >= s.length) {
            return null
        }
        if (s.startsWith("if", index.get())) {
            index.set(index.get() + 2)
            val exp = expressionParser.parse(s, index)
            val statements: MutableList<Statement?> = ArrayList()
            while (!s.startsWith("end", index.get())) {
                statements.add(parse(s, index))
                moveToNotBlank(s, index)
            }
            index.set(index.get() + 3)
            return IfStatement(exp, statements)
        }
        if (s.startsWith("while", index.get())) {
            index.set(index.get() + 5)
            val exp = expressionParser.parse(s, index)
            val statements: MutableList<Statement?> = ArrayList()
            while (!s.startsWith("end", index.get())) {
                statements.add(parse(s, index))
                moveToNotBlank(s, index)
            }
            index.set(index.get() + 3)
            return WhileStatement(exp, statements)
        }
        val variable = variableParser.parse(s, index)
        moveToNotBlank(s, index)
        index.incrementAndGet()
        val exp = expressionParser.parse(s, index)
        return InitStatement(variable, exp)
    }
}