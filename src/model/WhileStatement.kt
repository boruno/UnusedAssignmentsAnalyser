package model

class WhileStatement(val expression: Expression, val statements: MutableList<Statement?>) : Statement()