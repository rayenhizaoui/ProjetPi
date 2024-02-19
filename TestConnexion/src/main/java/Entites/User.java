/*package Entites;

public class User {
}*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Entity;
package Entites;
/**
 *
 * @author ASUS
 */
public class User{
    private int id;
    private int cin;
    private String username;
    private int numero;
    private String email;
    private String adresse;
    private String password;
    private String roles;
    public static User Current_User;


    public User(){
    }

    public User(int id, int cin, String username, int numero, String email, String adresse, String password, String roles) {
        this(cin, username, numero, email, adresse, password, roles);
        this.id = id;

    }
/*
    public User(int CIN, String UserName, int Numero, String Email, String Adresse, String Password) {
        this.CIN = CIN;
        this.UserName = UserName;
        this.Numero = Numero;
        this.Email = Email;
        this.Adresse = Adresse;
        this.Password = Password;
    }
    public User(int CIN, String UserName, int Numero, String Email, String Adresse) {
        this.CIN = CIN;
        this.UserName = UserName;
        this.Numero = Numero;
        this.Email = Email;
        this.Adresse = Adresse;

    }
    public User(int id,int CIN, String UserName, int Numero, String Email, String Adresse) {
        this.id = id;
        this.CIN = CIN;
        this.UserName = UserName;
        this.Numero = Numero;
        this.Email = Email;
        this.Adresse = Adresse;

    }
*/
    public User(int cin, String username, int numero, String email, String adresse, String password, String roles
    ) {

        this.cin = cin;
        this.username = username;
        this.numero = numero;
        this.email = email;
        this.adresse = adresse;
        this.password = password;
        this.roles= roles;
    }


    public static User getCurrent_User() {
        return Current_User;
    }

    public static void setCurrent_User(User Current_User) {
        User.Current_User = Current_User;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Users{" + "CIN=" + cin + ", UserName=" + username + ", Numero=" + numero + ", Email=" + email + ", Adresse=" + adresse + ", Password=" + password + ",Roles="+roles+'}';
    }


}