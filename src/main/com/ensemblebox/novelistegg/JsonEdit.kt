package main.com.ensemblebox.novelistegg

/**
 * Created by ArcenCiel on 2018/04/04.
 */

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import java.io.File
import java.io.IOException
import java.io.PrintWriter

class JsonEdit(filePath: String) {

    val JsonGenerator =
            JsonFactory()
                    .createJsonGenerator(
                            PrintWriter(filePath)
                    )

    constructor(filePath: String, type: String) : this(filePath) {
        callInitialize(type)
    }
/*
    private val node :JsonNode =
            ObjectMapper()
                    .readTree(
                            File(filePath)
                    )
*/
    fun callInitialize(type: String) {

        when (type) {

           "config" -> {
               configInitialize()
           }
            else -> {
                otherInitialize()
            }
        }

    }

    fun configInitialize() {

        //インデント処理をくわえる
        JsonGenerator.writeStartObject()
        JsonGenerator.writeBooleanField("autoContentsUpdate",false)
        JsonGenerator.writeBooleanField("autoContentsListImport",false)
        JsonGenerator.writeBooleanField("fullScreen",false)
        JsonGenerator.writeBooleanField("offlineMode",false)
        JsonGenerator.writeStringField("style","default")
        JsonGenerator.writeNumberField("width",1920.0)
        JsonGenerator.writeNumberField("height",1080.0)
        JsonGenerator.writeEndObject()
        JsonGenerator.flush()

    }

    fun otherInitialize() {

        JsonGenerator.writeStartObject()
        JsonGenerator.writeEndObject()
        JsonGenerator.flush()

    }
/*
    fun getStringJsonElement(key: String) :String {
        return node.get(key).toString()
    }

    fun getIntJsonElement(key: String) :Int {
        return node.get(key).asInt()
    }

    fun getDoubleJsonElement(key: String) :Double {
        return node.get(key).asDouble()
    }

    fun getBooleanJsonElement(key: String) :Boolean {
        return node.get(key).asBoolean()
    }
    */
    /*
    //Config.jsonから設定を読みだす
    fun ConfigLoad() {

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

    fun ConfigInitialize() {

        mapper.enable(SerializationFeature.INDENT_OUTPUT)

        try {
            val default = mapper.writeValueAsString(Config())

            FileEdit().overWriteFile("../NovelistEgg/Config.json", default)

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    */
}