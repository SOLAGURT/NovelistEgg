package main.com.ensemblebox.novelistegg

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by ArcenCiel on 2018/04/02.
 */

data class Config (

    var autoContentsUpdate: Boolean = false,
    var autoContentsListImport: Boolean = false,
    var fullScreen: Boolean = false,
    var offlineMode: Boolean = false,
    var style: String = "default",
    var width: Double = 1920.0,
    var height: Double = 1080.0

) {
    companion object {

        var config: Config =
                Config().configLoad("../NovelistEgg/Config.json")

    }

    fun configLoad(filePath: String) :Config {

        val READ_JSON = FileEdit().readFile(filePath)
        var config: Config? = null

        try {
            config = ObjectMapper().readValue(READ_JSON, Config::class.java)

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return config!!
    }

    fun get() :Config {
        return config
    }
}