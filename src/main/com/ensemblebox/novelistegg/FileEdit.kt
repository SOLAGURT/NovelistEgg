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

    //起動時に必要なファイルの存在チェック。ない場合は作成する。
    public fun BootFileConfirm() {

        if(!fileExists("Contents")) {

            createFolder("Contents")

        }

        if(!fileExists("AdditionalContentURL.json")) {

            createFile("AdditionalContentURL.json")

        }

        if(!fileExists("Config.json")) {

            createFile("Config.json")
            Config().ConfigInitialize()

        }

        if(!fileExists("Contents.json")) {

            createFile("Contents.json")

        }

        if(!fileExists("index.json")) {

            createFile("index.json")

        }
    }

    public fun fileExists(filePath: String) :Boolean {

        val file = File(filePath)

        if (file.exists()) {
            return true
        }
        return false
    }

    public fun createFolder(filePath: String) {

        val folder = File(filePath)

        folder.mkdir()
    }

    public fun createFile(fileName: String, filePath: String = "") {

        val file = File(filePath, fileName)

        file.createNewFile()
    }

    public fun overWriteFile(filePath: String, contents: StringBuilder) {

        try {
            val file = FileWriter(filePath)
            val pw = PrintWriter(BufferedWriter(file))

            pw.println(contents)
            pw.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    public fun addWriteFile(filePath: String, contents: StringBuilder) {

        try {
            val file = FileWriter(filePath, true)
            val pw = PrintWriter(BufferedWriter(file))

            pw.println(contents)
            pw.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    public fun readFile(filePath: String) :StringBuilder {

        val fileContents = StringBuilder()

        try {
            val file = File(filePath)
            val fr = FileReader(file)
            val br = BufferedReader(fr)

            for (line in br.lines()) {
                fileContents.append(line)
                        .append(SEPARATE)
            }

        } catch (e: FileNotFoundException) {
            e.printStackTrace()

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return fileContents
    }

}