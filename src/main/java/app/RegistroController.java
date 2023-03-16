package app;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroController {

    @FXML
    private Hyperlink hyperlinkIniciarSesion;
    @FXML
    private Button buttonVolver;
    @FXML
    private ImageView imageViewLeftPane;

    @FXML
    private Button buttonRegistro;


    public void initialize() {
        //insertamos el fondo del left pane
        Image imagenFondo = new Image("file:src/main/resources/backgrounds/fondo_left_pane.png");
        imageViewLeftPane.setImage(imagenFondo);

        Image imageBackArrow = new Image("file:src/main/resources/back_arrow.png");
        buttonVolver.setBackground(new Background(new BackgroundImage(imageBackArrow, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        //Colocamos el focus en el boton
        Platform.runLater(() -> buttonRegistro.requestFocus());

        //Evento de boton volver
        buttonVolver.setOnAction(actionEvent ->
                formIniciarSesion()
        );

        //Evento de click en hyperlink Inicia tu sesion
        hyperlinkIniciarSesion.setOnMouseClicked(mouseEvent ->
                formIniciarSesion()
        );

        //Evento de boton Registrate
        buttonRegistro.setOnAction(actionEvent ->
                handleRegister()
        );

    }

    //Metodo que envia al inicio de sesion
    private void formIniciarSesion() {
        try{
            FXMLLoader formLoader = new FXMLLoader(getClass().getResource("login-vista.fxml"));
            AnchorPane form = formLoader.load();
            Scene formScene = new Scene(form);

            //Recuperamos y mostramos la vista registro
            Stage stage = (Stage) buttonVolver.getScene().getWindow();
            stage.setScene(formScene);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //Metodo que manejara los datos del registro, comprueba en la base de datos por coincidencias.
    //Y almacenara el usuario nuevo.
    private void handleRegister() {
    }
}
