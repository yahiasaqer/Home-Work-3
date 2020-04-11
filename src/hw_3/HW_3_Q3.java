/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package H3;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class HW_3_Q3 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException{
        

        

        
        Label wel = new Label("Welcome");
        wel.setId("wel");
        Label L_Name = new Label("User Name");
        Text F = new Text();
        F.setStyle( "-fx-font-style: italic;\n" +
                    "    -fx-font-size: 10;\n" +
                    "    -fx-color:red;\n" +
                    "    -fx-float: left;");
        Label L_Pass = new Label("User Password");
        

        
        TextField Name = new TextField();
        PasswordField Password = new PasswordField();
        

        
        Button Login = new Button("Login");
        Button Exit = new Button("Exit");
       

        
        HBox HBtn = new HBox(8,Login,Exit);
        
        GridPane GP1 = new GridPane();
        

   GP1.add(wel,0,0);
  GP1.add(L_Name,0,1);    GP1.add(Name,1,1);      
  GP1.add(L_Pass,0,2);    GP1.add(Password,1,2);  
   GP1.add(F,0,3);         GP1.add(HBtn,1,3);
        
        GP1.setAlignment(Pos.CENTER);
        StackPane root1 = new StackPane();
        
        root1.getChildren().add(GP1);
        
        Scene scene1 = new Scene(root1,300, 250);
        

        
        Button View = new Button("View All Students");
        
        Button Add = new Button("Add Student");
        

        
        HBox H3 = new HBox(10,View,Add);
        
        StackPane root2 = new StackPane();
        
        root2.getChildren().add(H3);
        
        H3.setAlignment(Pos.CENTER);
        
        Scene scene2 = new Scene(root2,300, 250);
        

        
        ObservableList<Student> group =FXCollections.observableArrayList();
        
        ListView LV = new ListView();
        
        List STDs = new ArrayList<Student>(group);
        
        
        
        Label L1 = new Label("Student Data");
        L1.setId("wel");
        
        Label id_L = new Label("ID");
        Label name_L = new Label("Name");
        Label major_L = new Label("Major");
        Label Grade_L = new Label("Grade");


      
        
        TextField ID2 = new TextField();
        TextField Name2 = new TextField();
        TextField Major = new TextField();
        TextField Grade = new TextField();
        
        
        Button Add2 = new Button("Add");
        
        Button rest = new Button("Rest");
        
        Button exit = new Button("Exit");
       
        HBox btn = new HBox(Add2,rest,exit);
        btn.setSpacing(10);
        GridPane GP3 = new GridPane();
        
        
              
           GP3.add(L1, 0, 0);
          GP3.add(id_L, 0, 1);        GP3.add(ID2, 1, 1);            
         GP3.add(name_L, 0, 2);      GP3.add(Name2, 1, 2);
          GP3.add(major_L, 0, 3);     GP3.add(Major, 1, 3);
         GP3.add(Grade_L, 0, 4);     GP3.add(Grade, 1, 4);
                                     GP3.add(btn, 1, 5);
        
        HBox Coll = new HBox(GP3,LV);
        StackPane Screen3 = new  StackPane(Coll);
        Screen3.setAlignment(Pos.CENTER);
        Scene scene3 = new  Scene(Screen3);
        

        Login.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene2);
            }
        });
        
        
        Exit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {    
                
                Platform.exit();
                System.exit(0);
            }
        });
        
        
        Add.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene1);
            }
        });
        
        
        View.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene3);
            }
        });
        
        
        Add2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                int i = Integer.parseInt(ID2.getText());
                double g = Double.parseDouble(Grade.getText());
                Student STD = new Student(g, i, Name2.getText(), Major.getText());
                group.add(STD);
                Collections.sort(group, (Student o1, Student o2) -> (-Double.compare(o2.Grade, o1.Grade)));
                LV.setItems(group);
            }
        });
        
        
        rest.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                ID2.setText(null);
                Name2.setText(null);
                Grade.setText(null);
                Major.setText(null);
                
            }
        });
        
        
        exit.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene1);
            }
        });
        
        
        primaryStage.setTitle("");
        primaryStage.setScene(scene2);
        scene1.getStylesheets().add("Style.css");
        scene2.getStylesheets().add("Style.css");
        scene3.getStylesheets().add("Style.css");
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
