package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public ComboBox towns;

    public TextField ime;
    public TextField prezime;
    public TextField brojIndeksa;
    public TextField datum;
    public TextField eMail;
    public TextField telefon;
    public TextField adresa;
    public TextField JMBG;

    public ChoiceBox studij;
    public ChoiceBox status;
    public ChoiceBox smjer;

    public ToggleGroup godina;
    public boolean pritisnuto = false;
    public ToggleGroup posebnaGrupa;
    public Button button;


    public boolean validnoimeiprezime(String x) {
        boolean validno = true;
        int br = 0;
        if (x.length() > 20) {
            validno = false;
        }
        for (int i = 0; i < x.length(); i++) {
            if (Character.isAlphabetic(x.charAt(i))) {
                br++;
                break;
            }

        }
        if (br < 1) validno = false;
        return validno;
    }

    public boolean validanmejl(String x) {
        boolean validno1 = false;
        boolean validno2 = false;
        int br = 0;

        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i)=='.') validno1 = true;
            if (x.charAt(i)=='@') validno2 = true;
        }
        return validno1 && validno2;
    }





    public boolean validanindex(String x) {
        boolean p = true;
        if (x.length() == 0 || x.length() > 5) return false;
        for (int i = 0; i < x.length(); i++) {
            if (!Character.isDigit(x.charAt(i))) p = false;

        }
        return p;
    }

    @FXML
    public void initialize() {
        ime.getStyleClass().add("poljeNijeIspravno");
        prezime.getStyleClass().add("poljeNijeIspravno");
        brojIndeksa.getStyleClass().add("poljeNijeIspravno");
        datum.getStyleClass().add("poljeNijeIspravno");
        eMail.getStyleClass().add("poljeNijeIspravno");
        JMBG.getStyleClass().add("poljeNijeIspravno");


        eMail.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (validanmejl(newValue)) {
                    eMail.getStyleClass().removeAll("poljeNijeIspravno");
                    eMail.getStyleClass().add("poljeIspravno");
                } else {
                    eMail.getStyleClass().removeAll("poljeIspravno");
                    eMail.getStyleClass().add("poljeNijeIspravno");
                }


            }
        });



        ime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (validnoimeiprezime(newValue)) {
                    ime.getStyleClass().removeAll("poljeNijeIspravno");
                    ime.getStyleClass().add("poljeIspravno");
                } else {
                    ime.getStyleClass().removeAll("poljeIspravno");
                    ime.getStyleClass().add("poljeNijeIspravno");
                }


            }
        });

           prezime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (validnoimeiprezime(newValue)) {
                    prezime.getStyleClass().removeAll("poljeNijeIspravno");
                    prezime.getStyleClass().add("poljeIspravno");
                } else {
                    prezime.getStyleClass().removeAll("poljeIspravno");
                    prezime.getStyleClass().add("poljeNijeIspravno");
                }

            }
        });

        brojIndeksa.textProperty().addListener((new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (validanindex(newValue)) {
                    brojIndeksa.getStyleClass().removeAll("poljeNijeIspravno");
                    brojIndeksa.getStyleClass().add("poljeIspravno");
                } else {
                    brojIndeksa.getStyleClass().removeAll("poljeIspravno");
                    brojIndeksa.getStyleClass().add("poljeNijeIspravno");
                }
            }
        }));


     /*   JMBG.textProperty().addListener((new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if ( L = 11 - (( 7*(A+E) + 6*(B+Ž) + 5*(V+Z) + 4*(G+I) + 3*(D+J) + 2*(Đ+K) ) % 11) ) {
                    JMBG.getStyleClass().removeAll("poljeNijeIspravno");
                    JMBG.getStyleClass().add("poljeIspravno");
                } else {
                    JMBG.getStyleClass().removeAll("poljeIspravno");
                    JMBG.getStyleClass().add("poljeNijeIspravno");
                }
            }
        })); */


        godina.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                pritisnuto = true;
            }
        });





    }


    public void pritisnuto(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();

    }
}
