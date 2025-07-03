package com.example.hellofx;

import com.example.hellofx.Jugadores.Jugador;
import com.example.hellofx.Serializable.Serializacion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Screen4 {
    @FXML
    private TableView<Jugador> tablaJugadores;
    @FXML private TableColumn<Jugador, String> colNombre;
    @FXML private TableColumn<Jugador, Integer> colGanadas;
    @FXML private TableColumn<Jugador, Integer> colPerdidas;
    @FXML private TableColumn<Jugador, Integer> colEmpatadas;
    @FXML private TableColumn<Jugador, Integer> colPuntuacion;

    public Button button;
    private String userName;
    public void setUserName(String userName) {
        this.userName = userName;
        System.out.println("Nombre de usuario recibido en Screen3: " + userName);
    }
    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreJugador"));
        colGanadas.setCellValueFactory(new PropertyValueFactory<>("partidasGanadas"));
        colPerdidas.setCellValueFactory(new PropertyValueFactory<>("partidasPerdidas"));
        colEmpatadas.setCellValueFactory(new PropertyValueFactory<>("partidasEmpatadas"));
        colPuntuacion.setCellValueFactory(new PropertyValueFactory<>("puntuacion"));

        Serializacion serializacion = new Serializacion();
        ArrayList<Jugador> jugadores = serializacion.getAllJugadores();
        System.out.println("Jugadores cargados: " + jugadores.size());
        for (Jugador j : jugadores) {
            System.out.println(j.getNombreJugador());
        }
        tablaJugadores.getItems().setAll(jugadores);
    }
    public void exit() throws IOException {
      Stage stage = (Stage) button.getScene().getWindow() ;
      showScene1(stage);
    }
    public void showScene1(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hellofx/Screen1.fxml"));
        Parent root = loader.load();

        // Obtener el controlador y pasar el nombre de usuario
        Screen1 controller = loader.getController();
        controller.setUserName(userName);
        stage.hide();
        stage.setScene(new Scene(root));
        stage.setMaximized(true);
        stage.show();
    }

}
