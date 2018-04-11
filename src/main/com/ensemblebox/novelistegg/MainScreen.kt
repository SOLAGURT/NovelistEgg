package main.com.ensemblebox.novelistegg

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * Created by ArcenCiel on 2018/04/02.
 */

class MainScreen: Application() {

    val conf  = Config().get()

    override fun start(primaryStage: Stage?) {

        //スプラッシュ画面で本で卵を潰すアニメーションを作る
        primaryStage?.title = "小説家のたまご"
        primaryStage?.scene =
                Scene(
                        FXMLLoader.load<Parent>(
                                this.javaClass.getResource(
                                        "/resources/MainScreen.fxml")
                        ),
                        conf.width,
                        conf.height
                )
        primaryStage?.setFullScreen(conf.fullScreen)
        primaryStage?.show()
    }

}

fun main(args: Array<String>) {

    FileCheck().bootFileConfirm()
    FileCheck().addtionalUrlConfirm()

    Application.launch(MainScreen::class.java, *args)
}