package controllers;
import Entites.User;
import Service.ServiceUserCrud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;

import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.List;

public class AfficherUserController {


    @FXML
    private Label lbname;


    @FXML
    private TableView<User> tableview;

    @FXML
    private TableColumn<User, Integer> colcin;

    @FXML
    private TableColumn<User, String> colusername;

    @FXML
    private TableColumn<User, Integer> colnumero;

    @FXML
    private TableColumn<User, String> colemail;

    @FXML
    private TableColumn<User, String> coladresse;

    @FXML
    private TableColumn<User, String> colpassword;

    @FXML
    private TableColumn<User, String> colrole;

    private final ServiceUserCrud ser=new ServiceUserCrud();
/*
    @FXML
    void initialize() {
        try {
            List<User> list = ser.readAll();
            ObservableList<User> obers = FXCollections.observableList(list);

            // Rendre le TableView éditable
            tableview.setEditable(true);

            // Rendre les colonnes éditables si nécessaire
            colusername.setCellFactory(TextFieldTableCell.forTableColumn());
            colnumero.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            colemail.setCellFactory(TextFieldTableCell.forTableColumn());
            coladresse.setCellFactory(TextFieldTableCell.forTableColumn());
            colpassword.setCellFactory(TextFieldTableCell.forTableColumn());
            colrole.setCellFactory(TextFieldTableCell.forTableColumn());

            // Associer les données à la TableView
            tableview.setItems(obers);

            // Associer les propriétés de l'entité User aux colonnes de la TableView
            colcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
            colusername.setCellValueFactory(new PropertyValueFactory<>("username"));
            colnumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            coladresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            colpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
            colrole.setCellValueFactory(new PropertyValueFactory<>("roles"));

            // Écouter les modifications dans les cellules éditables et mettre à jour la base de données
            colusername.setOnEditCommit(event -> {
                User user = event.getRowValue();
                user.setUsername(event.getNewValue());
                updateDatabase(user);
            });
            // Répétez le même processus pour les autres colonnes si nécessaire
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateDatabase(User user) {
        ser.modifierUtilisateur(user); // Utilisez votre service pour mettre à jour les données dans la base de données
        // Affichez un message de confirmation à l'utilisateur si nécessaire
    }
*/













    @FXML
    void initialize() {
        try {
            List<User> list = ser.readAll();
            ObservableList<User> obers = FXCollections.observableList(list);

            // Rendre le TableView éditable
            tableview.setEditable(true);

            // Rendre les colonnes éditables si nécessaire
            colusername.setCellFactory(TextFieldTableCell.forTableColumn());
            colnumero.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            colemail.setCellFactory(TextFieldTableCell.forTableColumn());
            coladresse.setCellFactory(TextFieldTableCell.forTableColumn());
            colpassword.setCellFactory(TextFieldTableCell.forTableColumn());
            colrole.setCellFactory(TextFieldTableCell.forTableColumn());

            // Associer les données à la TableView
            tableview.setItems(obers);

            // Associer les propriétés de l'entité User aux colonnes de la TableView
            colcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
            colusername.setCellValueFactory(new PropertyValueFactory<>("username"));
            colnumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
            colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
            coladresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            colpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
            colrole.setCellValueFactory(new PropertyValueFactory<>("roles"));

            // Écouter les modifications dans les cellules éditables et mettre à jour la base de données
            colusername.setOnEditCommit(event -> {
                User user = event.getRowValue();
                user.setUsername(event.getNewValue());
                updateDatabase(user);
            });
            colnumero.setOnEditCommit(event -> {
                User user = event.getRowValue();
                user.setNumero(event.getNewValue());
                updateDatabase(user);
            });
            colemail.setOnEditCommit(event -> {
                User user = event.getRowValue();
                user.setEmail(event.getNewValue());
                updateDatabase(user);
            });
            coladresse.setOnEditCommit(event -> {
                User user = event.getRowValue();
                user.setAdresse(event.getNewValue());
                updateDatabase(user);
            });
            colpassword.setOnEditCommit(event -> {
                User user = event.getRowValue();
                user.setPassword(event.getNewValue());
                updateDatabase(user);
            });
            colrole.setOnEditCommit(event -> {
                User user = event.getRowValue();
                user.setRoles(event.getNewValue());
                updateDatabase(user);
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateDatabase(User user) {
        ser.modifierUtilisateur(user); // Utilisez votre service pour mettre à jour les données dans la base de données
        // Affichez un message de confirmation à l'utilisateur si nécessaire
    }









    @FXML
    private TextField txtcins;

    public void SupprimerUser(ActionEvent actionEvent) {


        // Récupérer l'utilisateur sélectionné dans le TableView
        User selectedUser = tableview.getSelectionModel().getSelectedItem();

        if (selectedUser != null) {
            // Appeler la méthode supprimerUtilisateur de votre service avec l'utilisateur sélectionné
            ser.supprimerUtilisateur(selectedUser);
            // Suppression réussie, rafraîchir le TableView pour refléter les changements
            refreshTableView();
            // Affichez un message de confirmation à l'utilisateur si nécessaire
            System.out.println("Utilisateur supprimé avec succès.");
        } else {
            // Affichez un message à l'utilisateur indiquant qu'aucun utilisateur n'est sélectionné
            System.out.println("Veuillez sélectionner un utilisateur à supprimer.");
        }
    }

// Méthode pour rafraîchir le TableView après la suppression
        private void refreshTableView() {
            try {
                // Effacer la liste actuelle des utilisateurs dans le TableView
                tableview.getItems().clear();
                // Recharger la liste des utilisateurs à partir de la base de données
                List<User> userList = ser.readAll();
                // Mettre à jour le TableView avec la nouvelle liste des utilisateurs
                tableview.getItems().addAll(userList);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }



















