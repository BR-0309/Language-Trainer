package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.data.LRUHashMap;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCharacters implements Initializable{

    public ComboBox<String> comboBox;

    private LRUHashMap<Integer, Character> map = new LRUHashMap<>(20);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //comboBox.setItems();
    }



}
