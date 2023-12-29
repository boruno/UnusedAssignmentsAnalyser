package model

class IfStatement(val expression: Expression, val statements: MutableList<Statement?>) : Statement()