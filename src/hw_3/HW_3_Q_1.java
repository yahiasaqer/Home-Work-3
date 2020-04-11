/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package H3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Comparator;
import java.util.List;
import javafx.collections.transformation.SortedList;
/**
 *
 * @author hp
 */
public class HW_3_Q_1 extends Application{
    
    ObservableList<Integer> items =FXCollections.observableArrayList();
    
    List<Integer> Numbers = new ArrayList(items);
    
    ListView<Integer> Rands = new ListView<>();
    
    Random rand = new Random();
    
    Label Result = new Label();
    
    int sum = 0;
    
    double avg; 
    
    @Override
    public void start(Stage primaryStage){
        
        
        Button getRandom = new Button("Get Rndom Number");
        
        getRandom.setOnAction(new Add());
        
        VBox V = new VBox(getRandom,Result);
        HBox H = new HBox(V,Rands);
        StackPane root = new StackPane();
        root.getChildren().add(H);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
        class Add implements EventHandler<ActionEvent>
            {
            @Override
            public void handle(ActionEvent event)
            {
                items.clear();
                sum = 0;
                avg = 0;
                for (int i = 0; i < 30; i++) {
                    int j = rand.nextInt(100);
                    items.add(i,j);
                    sum += items.get(i);
                }
                Collections.sort(items);
                Rands.setItems(items);
                avg = sum/30;
                
                Result.setText("Sum = "+sum+"\nAvg"+avg);
            }
            }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
