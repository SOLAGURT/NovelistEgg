package main.com.ensemblebox.novelistegg

/**
 * Created by ArcenCiel on 2018/04/04.
 */

import com.fasterxml.jackson.core.JsonFactory
import java.io.PrintWriter

class JsonEdit(filePath: String) {

    val FILEPATH: String = filePath
    val JSON_GENERATOR =
            JsonFactory()
                    .createJsonGenerator(
                            PrintWriter(filePath)
                    )

    constructor(filePath: String, type: String) : this(filePath) {
        callInitialize(type)
    }

    fun callInitialize(type: String) {

        when (type) {

           "config" -> {
               configInitialize()
           }
            
            "additionalUrlList" -> {
                additionalUrlListInitialize()    
            }
            
            else -> {
                otherInitialize()
            }
        }

    }

    fun configInitialize() {

        //インデント処理をくわえる
        JSON_GENERATOR.writeStartObject()
        JSON_GENERATOR.writeBooleanField("autoContentsUpdate",false)
        JSON_GENERATOR.writeBooleanField("autoContentsListImport",false)
        JSON_GENERATOR.writeBooleanField("fullScreen",false)
        JSON_GENERATOR.writeBooleanField("offlineMode",false)
        JSON_GENERATOR.writeStringField("style","default")
        JSON_GENERATOR.writeNumberField("width",1920.0)
        JSON_GENERATOR.writeNumberField("height",1080.0)
        JSON_GENERATOR.writeEndObject()
        JSON_GENERATOR.flush()

    }
    
    fun additionalUrlListInitialize() {
        JSON_GENERATOR.writeStartArray()
        JSON_GENERATOR.writeStartObject()
        JSON_GENERATOR.writeEndObject()
        JSON_GENERATOR.writeEndArray()
    }

    fun otherInitialize() {

        JSON_GENERATOR.writeStartObject()
        JSON_GENERATOR.writeEndObject()
        JSON_GENERATOR.flush()

    }
}