package main.com.ensemblebox.novelistegg

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea

/**
 * Created by ArcenCiel on 2018/04/16.
 */

class AddUrlController {

    @FXML
    private lateinit var AddUrlArea: TextArea

    @FXML
    private lateinit var Status: Label

    @FXML
    private lateinit var addUrlCommitButton: Button

    @FXML
    private lateinit var cancelButton: Button

    fun addUrlCommitAction(event: ActionEvent) {

        val LINE_SEPARATOR_PATTERN =  "\r\n|[\n\r\u2028\u2029\u0085]"
        val INPUT_ADDRESS =
                AddUrlArea
                .getText()
                .replace(LINE_SEPARATOR_PATTERN, "\n")

        var lineAddress = INPUT_ADDRESS.split("\n")
        var result = StringBuilder()
        var index = 1

        for(address in lineAddress) {

            if (FileCheck()
                            .isAddressFormatCorrect(address)
            ) {
                closeAddUrlScreenAction(event)
            } else {
                result
                        .append(index.toString())
                        .append(":")
            }
            index++
        }
        Status.setText(result.append("行目のアドレスが不正です。").toString())

    }

    fun closeAddUrlScreenAction(event: ActionEvent) {
        cancelButton.getScene().getWindow().hide()
    }

}