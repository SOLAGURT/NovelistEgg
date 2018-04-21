package main.com.ensemblebox.novelistegg

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
                getFileNameList(NOVELIST_EGG_DIRECTRY)

        if (!stringRegexFind(bootFileNameString, ".*Contents")) {
            fileEdit.createFolder("Contents")
        }
/*
        if (!stringRegexFind(bootFileNameString, ".*AdditionalContentsURL")) {
            fileEdit.createFile("AdditionalContentsURL.json", NOVELIST_EGG_DIRECTRY)
            JsonEdit("../NovelistEgg/AdditionalContentsURL.json", "additionalUrlList")
        }
*/  
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
        val additionalContentURL = AdditionalContentsURL().get()
    }

    fun stringRegexFind(str: String, rgx: String) :Boolean {
        return Pattern
                .compile(rgx)
                .matcher(str)
                .find()
    }

    fun isAddressFormatCorrect(address: String) :Boolean {

        val NAROU = "https://ncode.syosetu.com/n[0-9]{4}[a-z]{2}/$"
        val ALPHAPOLIS = "https://www.alphapolis.co.jp/novel/[0-9]{9}/[0-9]{9}$"
        val KAKUYOMU = "https://kakuyomu.jp/works/[0-9]{19}"
        val R18_NOVEL = "https://novel18.syosetu.com/n[0-9]{4}[a-z]{2}/$"

        if(stringRegexFind(address, NAROU)) return true
        if(stringRegexFind(address, ALPHAPOLIS)) return true
        if(stringRegexFind(address, KAKUYOMU)) return true
        if(stringRegexFind(address, R18_NOVEL)) return true
        return false
    }

    fun getFileNameList(filePath: String) :String {

        val dir = File(filePath)
        val files = dir.listFiles()

        var fileNameBuilder = StringBuilder()

        for (line in files) {

            val fileName = line.toString()

            fileNameBuilder
                    .append(fileName)
                    .append(SEPARATE)
        }
        return fileNameBuilder.toString()
    }

    fun fileExists(filePath: String) :Boolean {

        val file = File(filePath)

        if (file.exists()) {
            return true
        }
        return false
    }

    //ハッシュ関数生成処理

    //比較処理
}