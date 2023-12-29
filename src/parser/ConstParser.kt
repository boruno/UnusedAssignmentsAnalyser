package parser

import helper.ParserUtils.moveToNotBlank
import model.Const
import java.util.concurrent.atomic.AtomicInteger

class ConstParser {
    fun parse(s: String, index: AtomicInteger): Const {
        moveToNotBlank(s, index)
        val sb = StringBuilder()
        while (index.get() < s.length && Character.isDigit(s[index.get()])) {
            sb.append(s[index.get()])
            index.incrementAndGet()
        }
        return Const(sb.toString().toInt())
    }
}