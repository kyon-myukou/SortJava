import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(root, 200, 275));
        primaryStage.show();
    }

    public void bubble(Stage Stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("bubble.fxml"));
        Stage.setTitle("BubbleSort");
        Stage.setScene(new Scene(root, 1000, 450));
        Stage.show();
    }

    public void shell(Stage Stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("shell.fxml"));
        Stage.setTitle("ShellSort");
        Stage.setScene(new Scene(root, 1000, 450));
        Stage.show();
    }

    public void merge(Stage Stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("merge.fxml"));
        Stage.setTitle("MergeSort");
        Stage.setScene(new Scene(root, 1000, 450));
        Stage.show();
    }

    public void heap(Stage Stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("heap.fxml"));
        Stage.setTitle("HeapSort");
        Stage.setScene(new Scene(root, 1000, 450));
        Stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void func0ButtonAction(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        bubble(stage);
    }

    public void func1ButtonAction(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        shell(stage);
    }

    public void func2ButtonAction(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        merge(stage);
    }

    public void func3ButtonAction(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        heap(stage);
    }

    public void shuffle(int number[][],int j){
        int i;
        int ran1,ran2,ran;
        for(i = 1; i <= j; i++){
            number[1][i-1] = i;
        }
        Random rnd = new Random();
        for(i = 1; i <= 10; i++) {
            ran1 = rnd.nextInt(j);
            ran2 = rnd.nextInt(j);
            ran = number[1][ran1];
            number[1][ran1] = number[1][ran2];
            number[1][ran2] = ran;
        }
    }

}
