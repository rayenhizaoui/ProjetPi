package controllers;
import Entites.User;
import Service.ServiceUserCrud;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.SQLException;

public class AjouterUserController {



    @FXML
    private TextField txtusername;

    @FXML
    private TextField txtnumero;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtadresse;

    @FXML
    private TextField txtpassword;

    @FXML
    private TextField txtrole;

    @FXML
    private TextField txtcin;

    @FXML
    private TextField txtpassword1;

    @FXML
    private TextField txtusername1;

    private final ServiceUserCrud ser=new ServiceUserCrud();


    @FXML
    void AjouterUser(ActionEvent event) {
int CIN=Integer.parseInt(txtcin.getText());
String username=txtusername.getText();
int numero=Integer.parseInt(txtnumero.getText());
String email=txtemail.getText();
String adresse=txtadresse.getText();
String password=txtpassword.getText();
String roles=txtrole.getText();
User u4=new User(CIN,username,numero,email,adresse,password,roles);

        Alert alert1=new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation");
        alert1.setContentText("User ajoute avec succes");
        alert1.showAndWait();

try {
    ser.ajouter(u4);
}catch (SQLException e){
    Alert alert=new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setContentText(e.getMessage());
    alert.showAndWait();
}



    }





    @FXML
    void afficherUser(ActionEvent event) {

        try{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/AfficherUser.fxml"));
        Parent root=loader.load();
        txtcin.getScene().setRoot(root);
        AfficherUserController dc = loader.getController();

    }   catch (IOException e){
        throw new RuntimeException(e);}
    }








/*
    @FXML
    void ConnecterUser(ActionEvent event) {
        String username = txtusername1.getText();
        String password = txtpassword1.getText();

        try {
            // Utiliser votre service pour vérifier l'authentification
            boolean authentifie = ServiceUserCrud.authentifierUtilisateur(username, password);

            if (authentifie) {
                // Authentification réussie
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succès");
                alert.setHeaderText(null);
                alert.setContentText("Authentification réussie !");
                alert.showAndWait();
                // Vous pouvez ajouter ici des actions supplémentaires, comme changer de scène
            } else {
                // Authentification échouée
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Échec");
                alert.setHeaderText(null);
                alert.setContentText("Nom d'utilisateur ou mot de passe incorrect !");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            // Gérer les erreurs liées à l'accès à la base de données
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de base de données");
            alert.setContentText("Erreur lors de l'authentification : " + e.getMessage());
            alert.showAndWait();
        }
    }
*/




    @FXML
    void ConnecterUser(ActionEvent event) {
        String username = txtusername1.getText();
        String password = txtpassword1.getText();

        try {
            boolean authentifie = ServiceUserCrud.authentifierUtilisateur(username, password);

            if (authentifie) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succès");
                alert.setHeaderText(null);
                alert.setContentText("Authentification réussie !");
                alert.showAndWait();
                // Authentification réussie, charger la nouvelle interface
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/AfficherUser.fxml"));
                Parent root = loader.load();
                txtcin.getScene().setRoot(root);
                AfficherUserController dc = loader.getController();

                // Fermer la fenêtre actuelle de connexion
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Échec");
                alert.setHeaderText(null);
                alert.setContentText("Nom d'utilisateur ou mot de passe incorrect !");
                alert.showAndWait();
            }
        } catch (SQLException | IOException e) {
            System.out.println("Erreur lors de l'authentification : " + e.getMessage());
        }
    }






}








