package helper

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path

class FileReader {
    fun read(fileName: String): String {
        val data: ByteArray
        try {
            data = Files.readAllBytes(Path.of(fileName))
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        return String(data)
    }
}