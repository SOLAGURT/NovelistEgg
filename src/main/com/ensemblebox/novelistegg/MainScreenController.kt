package main.com.ensemblebox.novelistegg

import javafx.event.ActionEvent
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Modality
import javafx.stage.Stage

/**
 * Created by ArcenCiel on 2018/04/13.
 */

public class MainScreenController {

    fun addUrlButtonAction(event: ActionEvent) {

        if(Config().get().offlineMode) {
            return
        }

        val stage = Stage()

        stage?.initModality(Modality.APPLICATION_MODAL)

        stage?.title = "コンテンツの追加"
        stage?.scene =
                Scene(
                        FXMLLoader.load<Parent>(
                                this.javaClass.getResource(
                                        "/resources/AddUrlScreen.fxml")
                       )
                )
        //stage?.initStyle(StageStyle.UNDECORATED)
        stage?.show()
    }

}