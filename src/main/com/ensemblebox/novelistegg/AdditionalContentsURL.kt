package main.com.ensemblebox.novelistegg

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by ArcenCiel on 2018/04/12.
 */


//後々消えるであろうクラスです

class AdditionalContentsURL {

    var additionalUrlList = mutableListOf("")

    companion object {

        var additionalContentsUrl: AdditionalContentsURL =
                AdditionalContentsURL()
                        .additionalUrlLoad("../NovelistEgg/AdditionalContentsURL.json")

    }

    fun additionalUrlLoad(filePath: String) :AdditionalContentsURL  {

            val READ_JSON = FileEdit().readFile(filePath)
            var addtionalUrl: AdditionalContentsURL? = null

            try {
                addtionalUrl = ObjectMapper().readValue(READ_JSON, AdditionalContentsURL::class.java)

            } catch (e: Exception) {
                e.printStackTrace()
            }
            return addtionalUrl!!
    }

    fun get() :AdditionalContentsURL {
        return additionalContentsUrl
    }

}