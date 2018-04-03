package main.com.ensemblebox.novelistegg

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * Created by ArcenCiel on 2018/04/02.
 */

public class MainScreen: Application() {

    val conf = Config()

    override fun start(primaryStage: Stage?) {

        primaryStage?.title = "Hello World"
        primaryStage?.scene =
                Scene(
                        FXMLLoader.load<Parent>(
                                this.javaClass.getResource(
                                        "MainScreen.fxml")
                        ),
                        conf.getWidth(),
                        conf.getHeight()
                )
        primaryStage?.show()
    }

}

fun main(args: Array<String>) {

    FileEdit().BootFileConfirm()

    val conf = Config()

    conf.ConfigInitialize()
    conf.ConfigLoad()

    Application.launch(MainScreen::class.java, *args)
    println("Hello Kotlin")
}