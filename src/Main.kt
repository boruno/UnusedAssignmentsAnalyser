import helper.Analyser
import helper.FileReader
import parser.Parser

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val reader = FileReader()
        val programContent = reader.read("sample_input.txt")
        val parser = Parser()
        val program = parser.parse(programContent)
        val analyser = Analyser()
        analyser.findUnusedStatements(program).forEach { println(it) }
    }
}