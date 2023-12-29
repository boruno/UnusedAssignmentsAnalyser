package parser

import helper.ParserUtils.moveToNotBlank
import model.Variable
import java.util.concurrent.atomic.AtomicInteger

class VariableParser {
    fun parse(s: String, index: AtomicInteger): Variable {
        moveToNotBlank(s, index)
        val sb = StringBuilder()
        while (index.get() < s.length && Character.isAlphabetic(s[index.get()].code)) {
            sb.append(s[index.get()])
            index.incrementAndGet()
        }
        return Variable(sb.toString())
    }
}