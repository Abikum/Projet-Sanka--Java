package com.example.frontend_javaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DBUtils {

    public static void changescene(ActionEvent event,String fxmlFile,String title,String admin_name,String mat) throws IOException {
        Parent root=null;
        if(admin_name!=null && mat!=null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                loggedin_admincontroller loggedin_admincontroller = loader.getController();
                loggedin_admincontroller.setuser_info(admin_name);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));;

        }

        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static  void signUpAdmin(ActionEvent actionEvent,String admin_mat,String admin_name,String pwd) throws SQLException, IOException {
        Connection connection=null;
        PreparedStatement psInsert=null;
        PreparedStatement checkUserExist=null;
        ResultSet resultSet=null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","1430");
            checkUserExist= connection.prepareStatement("SELECT * FROM administrator WHERE Name=?");
            checkUserExist.setString(1,admin_name);
            resultSet=checkUserExist.executeQuery();
            if(resultSet.isBeforeFirst()){
                System.out.println("admin already Exist");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot add this administrator");
                alert.show();
            }else{
                psInsert=connection.prepareStatement("INSERT INTO administrator(admin_mat,admin_name,pwd VALUES(?,?,?)");
                psInsert.setString(1,admin_mat);
                psInsert.setString(2,admin_name);
                psInsert.setString(3,pwd);
                psInsert.executeUpdate();

                changescene(actionEvent,"logged_admin.fxml","Welcome","admin_name","admin_mat");

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null || psInsert != null || checkUserExist != null) {
                    resultSet.close();
                    psInsert.close();
                    checkUserExist.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
}
