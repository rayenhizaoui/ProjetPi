/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


        import Entites.User;
        //import Util.MyConnection;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.logging.Level;
        import java.util.logging.Logger;


        import Entites.Personne;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;
        import Utils.DataSource;

    public class ServiceUserCrud implements IService<User> {

    private static Connection con=DataSource.getInstance().getCon();
    private Statement ste;


    public ServiceUserCrud() {
        try {
            ste= con.createStatement();
        }catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    @Override
        public void ajouter(User u1) throws SQLException {


            String req="INSERT INTO `user` (`id`, `cin`, `username`, `numero`, `email`, `adresse`, `password`, `roles`) VALUES ('"+u1.getId()+"', '"+u1.getCin()+"', '"+u1.getUsername()+"','"+u1.getNumero()+"', '"+u1.getEmail()+"','"+u1.getAdresse()+"','"+u1.getPassword()+"','"+u1.getRoles()+"');";
            ste.executeUpdate(req);
        }

        public void ajouterPST(User user) throws SQLException {

            String req="INSERT INTO `personne` ( `id`, `cin`, `username`, `numero`, `email`, `adresse`, `password`, `roles`) VALUES ( ?,?,?,?,?,?,?,?);";
            PreparedStatement pre=con.prepareStatement(req);

            pre.setInt(1,user.getId());
            pre.setInt(2,user.getCin());
            pre.setString(3,user.getUsername());
            pre.setInt(4,user.getNumero());
            pre.setString(5,user.getEmail());
            pre.setString(6,user.getAdresse());
            pre.setString(7,user.getPassword());
            pre.setString(8,user.getRoles());

            pre.executeUpdate();
        }





/////////////////////////////////////////////////////////////////////////////
/*
@Override
    public void supprimerUtilisateur(User user) {
        try {
            String requete="delete from user where id=?";
            PreparedStatement pst = con.prepareStatement(requete);
            pst.setInt(1,user.getId());
            pst.executeUpdate();

            System.out.println("Utlisateur est supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }}
*//////////////////////////////////////////////////////////////



        @Override
        public void supprimerUtilisateur(User user) {
            try {
                // Préparer la requête SQL pour supprimer l'utilisateur par son ID
                String requete = "DELETE FROM user WHERE id=?";
                PreparedStatement pst = con.prepareStatement(requete);
                pst.setInt(1, user.getId());
                // Exécuter la requête de suppression
                int rowsDeleted = pst.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Utilisateur supprimé avec succès.");
                } else {
                    System.out.println("Échec de la suppression de l'utilisateur.");
                }
            } catch (SQLException ex) {
                System.out.println("Erreur lors de la suppression de l'utilisateur : " + ex.getMessage());
            }
        }







    @Override
    public void modifierUtilisateur(User user) {
        try {
            String requete2="update user set cin=?,username=?,numero=?,email=?,adresse=? where id=?";
            PreparedStatement pst = con.prepareStatement(requete2);
            pst.setInt(1, user.getCin());
            pst.setString(2, user.getUsername());
            pst.setInt(3, user.getNumero());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.getAdresse());
            pst.setInt(6, user.getId());
            pst.executeUpdate();

            System.out.println("Utlisateur est modifié");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }}






    @Override
    public User findById(int id) throws SQLException {
        return null;
    }

    public List<User> readAll() throws SQLException {

        List<User> list=new ArrayList<>();
        ResultSet res=ste.executeQuery("SELECT * FROM `user`");
        while (res.next()) {

            int id=res.getInt(1);
            int cin=res.getInt(2);
            String username=res.getString("username");
            int numero=res.getInt(4);
            String email=res.getString("email");
            String adresse=res.getString("adresse");
            String password=res.getString("password");
            String roles=res.getString("roles");
            User u1=new User(id,cin,username,numero,email,adresse,password,roles);
            list.add(u1);
        }

        return list;
    }













        public static boolean authentifierUtilisateur(String username, String password) throws SQLException {
            String req = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = con.prepareStatement(req);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Si une ligne est renvoyée par la requête, cela signifie que les informations d'identification sont correctes
            return resultSet.next();
        }






    }