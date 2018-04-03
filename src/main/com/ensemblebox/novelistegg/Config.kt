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
    private var width :Double = 1920.0
    private var height :Double = 1080.0

    private val mapper = ObjectMapper()
    private val node :JsonNode = mapper.readTree(File("Config.json"))

    public fun getAutoContentsUpdate() :Boolean {

        return this.autoContentsUpdate

    }

    public fun setAutoContentsUpdate(bool: Boolean) {

        this.autoContentsUpdate = bool

    }

    public fun getAutoContentsListImport() :Boolean {

        return this.autoContentsListImport

    }

    public fun setAutoContentsListImport(bool: Boolean) {

        this.autoContentsListImport = bool

    }

    public fun getFullScreen() :Boolean {

        return this.fullScreen

    }

    public fun setFullScreen(bool :Boolean) {

        this.fullScreen = bool

    }

    public fun getOfflineMode() :Boolean {

        return this.offlineMode

    }

    public fun setOfflineMode(bool :Boolean) {

        this.fullScreen = bool

    }

    public fun getStyle() :String {

        return this.style

    }

    public fun setStyle(style :String) {

        this.style = style

    }

    public fun getWidth() :Double {

        return this.width

    }

    public fun setWidth(width :Double) {

        this.width = width

    }

    public fun getHeight() :Double {

        return this.height

    }

    public fun setHeight(height :Double) {

        this.height = height

    }

    //Config.jsonから設定を読みだす
    public fun ConfigLoad() {

        try {
            this.autoContentsUpdate = node.get("autoContentsUpdate").asBoolean()
            this.autoContentsListImport = node.get("autoContentsListImport").asBoolean()
            this.fullScreen = node.get("fullScreen").asBoolean()
            this.offlineMode = node.get("offLineMode").asBoolean()
            this.style = node.get("style").toString()
            this.width = node.get("width").asDouble()
            this.height = node.get("height").asDouble()

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    public fun ConfigInitialize() {

        mapper.enable(SerializationFeature.INDENT_OUTPUT)

        try {
            val default = mapper.writeValueAsString(Config())

            FileEdit().overWriteFile("Config.json", default)

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}