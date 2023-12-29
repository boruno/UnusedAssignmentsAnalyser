package helper

import java.util.concurrent.atomic.AtomicInteger

object ParserUtils {
    fun moveToNotBlank(s: String, index: AtomicInteger) {
        while (index.get() < s.length && isBlank(s[index.get()])) {
            index.incrementAndGet()
        }
    }

    private fun isBlank(c: Char): Boolean {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t'
    }
}