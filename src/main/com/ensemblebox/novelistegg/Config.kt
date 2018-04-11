package main.com.ensemblebox.novelistegg

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by ArcenCiel on 2018/04/02.
 */

data class Config (

    val autoContentsUpdate: Boolean = false,
    val autoContentsListImport: Boolean = false,
    val fullScreen: Boolean = false,
    val offlineMode: Boolean = false,
    val style: String = "default",
    val width: Double = 1920.0,
    val height: Double = 1080.0

) {
    companion object {
        var config: Config = Config().configLoad("../NovelistEgg/Config.json")
    }

    fun configLoad(filePath: String) :Config {

        val READ_JSON = FileEdit().readFile("../NovelistEgg/Config.json")
        var config: Config? = null

        try {
            config = ObjectMapper().readValue(READ_JSON, Config::class.java)

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return config!!
    }

    fun get():Config {
        return config
    }
}