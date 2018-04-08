package main.com.ensemblebox.novelistegg

/**
 * Created by ArcenCiel on 2018/04/02.
 */

data class Config (
        val autoContentsUpdate :Boolean = false,
        val autoContentsListImport :Boolean = false,
        val fullScreen :Boolean = false,
        val offlineMode :Boolean = false,
        val style :String = "default",
        val width :Double = 1920.0,
        val height :Double = 1080.0
        ) {
/*
    private var autoContentsUpdate = false
    private var autoContentsListImport = false
    private var fullScreen = false
    private var offlineMode = false
    private var style = "default"
    private var width :Double = 1920.0
    private var height :Double = 1080.0
*/

/*
    fun getAutoContentsUpdate() :Boolean {
        return this.autoContentsUpdate
    }

    fun setAutoContentsUpdate(bool: Boolean) {
        this.autoContentsUpdate = bool
    }

    fun getAutoContentsListImport() :Boolean {
        return this.autoContentsListImport
    }

    fun setAutoContentsListImport(bool: Boolean) {
        this.autoContentsListImport = bool
    }
    fun getFullScreen() :Boolean {
        return this.fullScreen
    }

    fun setFullScreen(bool :Boolean) {
        this.fullScreen = bool
    }

    fun getOfflineMode() :Boolean {
        return this.offlineMode
    }

    fun setOfflineMode(bool :Boolean) {
        this.fullScreen = bool
    }

    fun getStyle() :String {
        return this.style
    }

    fun setStyle(style :String) {
        this.style = style
    }

    fun getWidth() :Double {
        return this.width
    }

    fun setWidth(width :Double) {
        this.width = width
    }

    fun getHeight() :Double {
        return this.height
    }

    fun setHeight(height :Double) {
        this.height = height
    }
*/
}