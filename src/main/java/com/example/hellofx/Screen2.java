package com.example.hellofx;

import com.example.hellofx.Jugadores.Jugador;
import com.example.hellofx.Serializable.Serializacion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Screen2 {
    String nameUser;
    String nameUser2;
    Jugador player1;
    Jugador player2;

    public TextField inputField;
    public Label SecondOption;
    public void initialize() {
        inputField.setOnAction(event -> showScreen3());
    }

    public void showScreen3() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hellofx/Screen3.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) inputField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setMaximized(true);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void option(){
        Serializacion serializacion = new Serializacion();

        int optionUser = Integer.parseInt(inputField.getText());
        if (optionUser==1){
            inputField.setText("Ingrese el nombre de J2: ");
            nameUser2 = inputField.getText();
            if (serializacion.encontrarJugador(nameUser2)){
                SecondOption.setText("Jugador Encontrado");

            }else{
                SecondOption.setText("Jugador Creado: "+nameUser2);
            }
            SecondOption.setText("¡Jugador creado!\n¡Bienvenido, " + nameUser2 + "!");

        }

    }

    public void setPlayer1(Jugador player1) {
        this.player1 = player1;
    }
}