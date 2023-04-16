package app;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import repository.UsuariosRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FormController {

    @FXML
    private ImageView imageViewLogo;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ImageView imageViewLeftPane;
    @FXML
    private Button buttonLogin;

    @FXML
    private Hyperlink hyperlinkCrearCuenta;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/teamder";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private UsuariosRepository usuariosRepository;
    private Connection connection;

    public void initialize() throws SQLException {
        //Creamos la conexion a la BBDD y creamos el Repositorio de Usuarios
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        usuariosRepository = new UsuariosRepository(connection);

        //insertamos el logo del login
        Image logoFormulario = new Image("file:src/main/resources/logo/logo_sin_fondo.png");
        imageViewLogo.setImage(logoFormulario);

        //insertamos el fondo del left pane
        Image imagenFondo = new Image("file:src/main/resources/backgrounds/fondo_left_pane.png");
        imageViewLeftPane.setImage(imagenFondo);

        //Colocamos el focus en el boton
        Platform.runLater(() -> buttonLogin.requestFocus());


        buttonLogin.setOnAction(actionEvent ->
                handleLogin()
        );

        hyperlinkCrearCuenta.setOnMouseClicked(mouseEvent ->
                    formRegistro()
                );
    }

    private void formRegistro() {
        try {
            //Cargamos la vista home
            FXMLLoader formLoader = new FXMLLoader(getClass().getResource("registro.fxml"));
            AnchorPane registro = formLoader.load();
            Scene registroScene = new Scene(registro);
            //Recuperamos y mostramos la vista registro
            Stage stage = (Stage) buttonLogin.getScene().getWindow();
            stage.setScene(registroScene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Metodo que carga la vista home y la muestra.
     * Establece la propiedad de redimensionar a verdadero.
     */
    private void iniciarSesion() {
        try {
            //Cargamos la vista home
            FXMLLoader formLoader = new FXMLLoader(getClass().getResource("home.fxml"));
            AnchorPane home = formLoader.load();
            Scene homeScene = new Scene(home);
            //Recuperamos y mostramos la vista home
            Stage stage = (Stage) buttonLogin.getScene().getWindow();
            stage.setResizable(true);//Permitimos la redimension de la ventana
            stage.setScene(homeScene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        //TODO validar usuario
        //Si es correcto cambiar scene


        iniciarSesion(); //TODO llamar unicamente si la validacion es correcta


    }
}