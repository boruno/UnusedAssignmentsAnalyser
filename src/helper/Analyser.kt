package helper

import model.*

class Analyser {
    fun findUnusedStatements(program: Program): List<InitStatement> {
        return findUnusedStatements(program.statements, ArrayList())
    }

    private fun findUnusedStatements(
        statements: MutableList<Statement?>,
        list: MutableList<InitStatement>
    ): List<InitStatement> {
        for (i in statements.indices) {
            val curStatement = statements[i]
            if (curStatement is InitStatement) {
                if (!find(curStatement.variable, statements.subList(i + 1, statements.size))) {
                    list.add(curStatement)
                }
            } else if (curStatement is IfStatement) {
                findUnusedStatements(curStatement.statements, list)
            } else if (curStatement is WhileStatement) {
                findUnusedStatements(curStatement.statements, list)
            }
        }
        return list
    }

    private fun find(`var`: Variable, statements: MutableList<Statement?>): Boolean {
        return statements.stream().anyMatch { statement: Statement? ->
            find(
                `var`,
                statement
            )
        }
    }

    private fun find(`var`: Variable, statement: Statement?): Boolean {
        if (statement is InitStatement) {
            return find(`var`, statement.expression)
        }
        if (statement is IfStatement) {
            return (find(`var`, statement.expression)
                    || find(`var`, statement.statements))
        }
        if (statement is WhileStatement) {
            return (find(`var`, statement.expression)
                    || find(`var`, statement.statements))
        }
        return false
    }

    private fun find(`var`: Variable, expression: Expression): Boolean {
        if (expression is Variable) {
            return `var`.variable == expression.variable
        }
        if (expression is Operation) {
            return find(`var`, expression.first) || find(`var`, expression.second)
        }
        return false
    }
}