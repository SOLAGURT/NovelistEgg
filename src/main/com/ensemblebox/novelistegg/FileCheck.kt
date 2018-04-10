package main.com.ensemblebox.novelistegg

import com.intellij.icons.AllIcons
import java.io.File
import java.util.regex.Pattern

/**
 * Created by ArcenCiel on 2018/04/10.
 */
class FileCheck {

    private val SEPARATE = System.getProperty("line.separator")
    private val NOVELIST_EGG_DIRECTRY = "../NovelistEgg"
    private val fileEdit = FileEdit()

    //起動時に必要なファイルの存在確認処理呼び出し。ない場合は作成処理の呼び出し
    fun bootFileConfirm() {

        val bootFileNameString =
                getFilenameList(NOVELIST_EGG_DIRECTRY).toString()

        if (!stringRegexFind(bootFileNameString, ".*Contents")) {
            fileEdit.createFolder("Contents")
        }

        if (!stringRegexFind(bootFileNameString, ".*AdditionalContentURL")) {
            fileEdit.createFile("AdditionalContentURL.json", NOVELIST_EGG_DIRECTRY)
            JsonEdit("../NovelistEgg/AdditionalContentURL.json", "other")
        }

        if (!stringRegexFind(bootFileNameString, ".*Config")) {
            fileEdit.createFile("Config.json", NOVELIST_EGG_DIRECTRY)
            JsonEdit("../NovelistEgg/Config.json", "config")
        }

        if (!stringRegexFind(bootFileNameString, ".*ContentsList")) {
            fileEdit.createFile("ContentsList.json", NOVELIST_EGG_DIRECTRY)
            JsonEdit("../NovelistEgg/ContentsList.json", "other")
        }

        if (!stringRegexFind(bootFileNameString, ".*Index")) {
            fileEdit.createFile("Index.json", NOVELIST_EGG_DIRECTRY)
            JsonEdit("../NovelistEgg/Index.json", "other")
        }
    }

    fun addtionalUrlConfirm() {

    }

    fun stringRegexFind(str: String, rgx: String) :Boolean {
        return Pattern
                .compile(rgx)
                .matcher(str)
                .find()
    }

    fun getFilenameList(filePath: String) :StringBuilder {

        val dir = File(filePath)
        val files = dir.listFiles()

        var fileNameBuilder = StringBuilder()

        for (line in files) {

            val fileName = line.toString()

            fileNameBuilder
                    .append(fileName)
                    .append(SEPARATE)
        }
        return fileNameBuilder
    }

    fun fileExists(filePath: String) :Boolean {

        val file = File(filePath)

        if (file.exists()) {
            return true
        }
        return false
    }
}