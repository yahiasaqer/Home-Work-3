/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package H3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class HW_3_2 extends Application {
    HashMap<String,Integer> HM = new HashMap<String,Integer>();
    String Text1 = "";
    String Text2 = "";
    TextField Text = new TextField();
    Label Result = new Label();
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        File F = new File("C:\\Users\hp\\Documents\\For Test.txt");
        Scanner S = new Scanner(F);
        Button btn = new Button("the number of occurrences");
        
        btn.setOnAction((ActionEvent event) -> {
            while(!Text1.equals(Text.getText()+"")){
                Text1 = Text.getText()+"";
            }
            int Count = 0;
            if(Text1.length() != 1){
                while (S.hasNext()){
                    while(S.hasNext()){
                        Text2 = S.next();
                        if(Text1.equals(Text2)){
                            ++Count;
                        }
                    }
                }
            }else{
                char T = Text.getText().charAt(0);
                while(S.hasNext()){
                    char T2;
                    Text2 = S.next();
                    for (int i = 0; i < Text2.length(); i++) {
                        T2 = Text2.charAt(i);
                        if(T == T2){
                            ++Count;
                        }
                    }
                    
                }
            }
            HM.put(Text1,Count);
            Text1 = Text.getText()+"";
            
//               if(!Text.getText().equals("")){
Result.setText(Text1+" is occurrences : "+HM.get(Text1)+" Time/s");

//               }
        });
        VBox V = new VBox(Text,btn,Result);
        StackPane root = new StackPane();
        root.getChildren().add(V);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
