package main.com.ensemblebox.novelistegg

/**
 * Created by ArcenCiel on 2018/04/02.
 */

import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.PrintWriter
import java.io.FileNotFoundException
import java.io.IOException
import java.io.BufferedReader
import java.io.BufferedWriter

class FileEdit {

    private val SEPARATE = System.getProperty("line.separator")

    fun createFolder(filePath: String) {

        val folder = File(filePath)

        try {
            folder.mkdir()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun createFile(fileName: String, filePath: String = "") {

        val file = File(filePath, fileName)

        try {
            file.createNewFile()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun overWriteFile(filePath: String, contents: String) {

        try {
            val file = FileWriter(filePath)
            val pw = PrintWriter(BufferedWriter(file))

            pw.println(contents)
            pw.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun addWriteFile(filePath: String, contents: String) {

        try {
            val file = FileWriter(filePath, true)
            val pw = PrintWriter(BufferedWriter(file))

            pw.println(contents)
            pw.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun readFile(filePath: String) :String {

        val fileContents = StringBuilder()

        try {
            val br =
                    BufferedReader(
                            FileReader(
                                    File(filePath)
                            )
                    )

            for (line in br.lines()) {
                fileContents
                        .append(line)
                        .append(SEPARATE)
            }

        } catch (e: FileNotFoundException) {
            e.printStackTrace()

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return fileContents.toString()
    }

}