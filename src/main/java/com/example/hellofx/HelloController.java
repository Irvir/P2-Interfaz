package com.example.hellofx;

import com.example.hellofx.Jugadores.Jugador;
import com.example.hellofx.Jugadores.JugadorFactory;
import com.example.hellofx.Serializable.Serializacion;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.io.Serializable;

public class HelloController {
    String nombreUsuario;
    Jugador player1;
    @FXML
    private Label welcomeText;
    @FXML
    private Label FirstOption;
    @FXML
    private TextField inputField;
    @FXML
    public void initialize() {
        FirstOption.setVisible(false);
        inputField.setOnAction(event -> nameUser());

    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    void Menu(){

    }
    private void showScreen1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hellofx/Screen1.fxml"));
        Parent root = loader.load();

        Screen1 controller = loader.getController();
        controller.setUserName(nombreUsuario);
        controller.setPlayer1(player1);
        controller.setUserName(inputField.getText());

        Stage stage = (Stage) welcomeText.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setMaximized(true);
        stage.show();
    }
    @FXML
    private void nameUser() {
        Serializacion serializacion = new Serializacion();

        nombreUsuario = inputField.getText();
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            welcomeText.setText("Por favor, ingrese un nombre de usuario.");
            FirstOption.setVisible(false);
            return;
        }
        if (serializacion.encontrarJugador(nombreUsuario)){
            welcomeText.setText("¡Bienvenido, " + nombreUsuario + "!");
            player1 = serializacion.recuperarJugador(nombreUsuario);
            FirstOption.setText(player1.toString());

        }
        else {
            welcomeText.setText("¡Jugador creado!\n¡Bienvenido, " + nombreUsuario + "!");
            player1 = JugadorFactory.crearJugador(nombreUsuario,"Humano")            ;
            serializacion.agregarJugador(player1);
        }
        FirstOption.setVisible(true);
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            try {

                showScreen1();
            } catch (IOException e) {
                e.printStackTrace();
                welcomeText.setText("Error al cargar la pantalla.");
            }
        });
        pause.play();
    }




}





