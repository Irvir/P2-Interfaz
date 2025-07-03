package com.example.hellofx;

import com.example.hellofx.Jugadores.Jugador;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


public class Screen1 {
    private String userName;
    private Jugador player1;
    @FXML
    private Label label;
    @FXML
    public void setUserName(String userName) {
        this.userName = userName;
        System.out.println("Nombre de usuario recibido: " + userName);
    }
    @FXML
    public void exit() {
        label.setText("¡Adiós, " + userName + "!");
        System.out.println("Saliendo de la aplicación...");
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> System.exit(0));
        pause.play();
    }
    @FXML
    public void showScreenStadistics() throws IOException {
        label.setText("¡Bienvenido a la pantalla de estadísticas, " + userName + "!");
        System.out.println("Mostrando pantalla de estadísticas...");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hellofx/Screen4.fxml"));
        Parent root = loader.load();

        Screen4 controller = loader.getController();
        Stage stage = (Stage) label.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setMaximized(true);
        stage.show();
    }
    public void showScreenStart() throws IOException {
        label.setText("¡Bienvenido a la pantalla de Partida " + userName + "!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hellofx/Screen2.fxml"));
        Parent root = loader.load();

        Screen2 controller = loader.getController();
        Stage stage = (Stage) label.getScene().getWindow();

        // Crear solo UNA escena
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
    public void setuserName(String userName){
        this.userName = userName;
    }

    public void setPlayer1(Jugador player1) {
        this.player1 = player1;
    }

    public String getUserName() {
        return userName;
    }
}