package parser

import model.Program
import model.Statement
import java.util.concurrent.atomic.AtomicInteger

class ProgramParser(private val statementParser: StatementParser) {
    fun parse(s: String?): Program {
        val index = AtomicInteger()
        val statements: MutableList<Statement?> = ArrayList()
        while (true) {
            val st: Statement = statementParser.parse(s!!, index) ?: break
            statements.add(st)
        }
        return Program(statements)
    }
}