package app.javafxgui;

import app.javafxgui.HelloApplication;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button send;
    @FXML
    private Label mess1;
    @FXML
    private Label mess2;
    @FXML
    private Label mess3;

    @FXML
    private Label mess4;
    @FXML
    private TextField messenger;

    @FXML
    private AnchorPane view;


    private static int countMess = 0;

    @FXML
    protected void show(KeyCode key) {
        if (key == KeyCode.ENTER) {
            send(new ActionEvent());
        }
    }

    @FXML
    protected void send(ActionEvent actionEvent) {
        if (messenger.getText() == null) return;

        Label sending = new Label(messenger.getText());
        sending.layout();

        sending.setMaxWidth(200);
        sending.setMaxHeight(200);

        sending.setFont(new Font("System",13));
        sending.setStyle("-fx-background-color:  #F4A460;-fx-background-radius: 20;-fx-text-fill: black");


        //sending.setLayoutX(0);
        sending.setLayoutY(0 + countMess * 45);
        sending.setWrapText(true);
        sending.setAlignment(Pos.CENTER_RIGHT);
        sending.setPadding(new Insets(10, 10, 10, 10)); // Top right bottom left


        view.getChildren().add(sending);

        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT); // Đặt màu nền của ảnh chụp
        WritableImage snapshot = sending.snapshot(params, null);

        // Lấy kích thước của ảnh chụp để xác định chiều rộng thực tế của label
        double labelWidth = snapshot.getWidth();

        // Thiết lập vị trí bắt đầu từ bên phải
        sending.setLayoutX(view.getWidth() - labelWidth - 20); // view là AnchorPane hoặc Parent của label

        countMess ++;
        messenger.clear();



    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mess1.setPadding(new Insets(0, 0, 0, 15));
        mess2.setPadding(new Insets(0, 0, 0, 15));
        mess3.setPadding(new Insets(0, 0, 0, 15));
        mess4.setPadding(new Insets(0, 0, 0, 15));
    }
}