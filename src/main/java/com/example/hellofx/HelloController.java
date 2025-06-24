package com.example.hellofx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label FirstOption;
    @FXML
    private Label SecondOption;
    @FXML
    private TextField inputField;
    @FXML
    private TextField inputField2;
    @FXML
    public void initialize() {
        FirstOption.setVisible(false);
        inputField2.setVisible(false);

        inputField.setVisible(true);
        SecondOption.setVisible(false);
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    void Menu(){
        Menu menu = new Menu();
        menu.menu();
    }
    @FXML
    private void nameUser() {
        String userName = inputField.getText();
        if (userName == null || userName.isEmpty()) {
            welcomeText.setText("Por favor, ingrese un nombre de usuario.");
            FirstOption.setVisible(false);
            return;
        }
        welcomeText.setText("¡Bienvenido, " + userName + "!");
        FirstOption.setVisible(true);
        inputField2.setVisible(true);

        String optionText = inputField2.getText();
        int option = -1;
        try {
            if (!optionText.isEmpty()) {
                option = Integer.parseInt(optionText);
            }
        } catch (NumberFormatException e) {
            welcomeText.setText("Por favor, ingrese una opción válida (número).");
            SecondOption.setVisible(false);
            return;
        }

        switch (option) {
            case 1:
                // Acción para opción 1
                break;
            case 2:
                // Acción para opción 2
                break;
            case 3:
                // Acción para opción 3
                break;
            default:
                if (option != -1) {
                    welcomeText.setText("Opción no válida, por favor ingrese una opción válida.");
                }
                break;
        }
        if (option != -1 && option >= 1 && option <= 3) {
            SecondOption.setVisible(true);
        }
    }
    protected void onOption1() throws Exception {
        System.out.println("Opción 1 seleccionada");
    }



}