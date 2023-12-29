package parser

import helper.ExpressionReader
import helper.ReversePolishConverter
import model.Program

class Parser {
    fun parse(program: String?): Program {
        val variableParser = VariableParser()
        val constParser = ConstParser()
        val operatorParser = OperatorParser()
        val expressionReader = ExpressionReader(operatorParser, constParser, variableParser)
        val reversePolishConverter = ReversePolishConverter()
        val expressionParser = ExpressionParser(expressionReader, reversePolishConverter)
        val statementParser = StatementParser(expressionParser, variableParser)
        val programParser = ProgramParser(statementParser)
        return programParser.parse(program)
    }
}