package main.com.ensemblebox.novelistegg

/**
 * Created by ArcenCiel on 2018/04/02.
 */

import java.io.File
import java.io.IOException

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature


class Config {

    private var autoContentsUpdate = false
    private var autoContentsListImport = false
    private var fullScreen = false
    private var offlineMode = false
    private var style = "default"
    private var width = 1920
    private var height = 1080

    private val mapper = ObjectMapper()

    //Config.jsonから設定を読みだす

    public fun ConfigLoad() {

        try {

            val node :JsonNode = mapper.readTree(File("Config.json"))

            autoContentsUpdate = node.get("autoContentsUpdate").asBoolean()
            autoContentsListImport = node.get("autoContentsListImport").asBoolean()
            fullScreen = node.get("fullScreen").asBoolean()
            offlineMode = node.get("offLineMode").asBoolean()
            style = node.get("style").toString()
            width = node.get("width").asInt()
            height = node.get("height").asInt()

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    public fun ConfigInitialize() {

        mapper.enable(SerializationFeature.INDENT_OUTPUT)

        try {

            val defaultConfig = mapper.writeValueAsString(Config())
            FileEdit().overWriteFile("Config.json", defaultConfig)
        
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

}