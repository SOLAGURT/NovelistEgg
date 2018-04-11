package main.com.ensemblebox.novelistegg

/**
 * Created by ArcenCiel on 2018/04/04.
 */

import com.fasterxml.jackson.core.JsonFactory
import java.io.PrintWriter

class JsonEdit(filePath: String) {

    val FILEPATH: String = filePath
    val JsonGenerator =
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
}