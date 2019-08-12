import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class ShellController {

    int [][] number = new int[15][13];
    int i,j,k;
    int num,max;
    int swapcount,comparecount;
    Main shuffle =new Main();

    public void shellsort(){
        num = 1;
        int inc = 4;
        for(; inc > 0; inc /= 2){
            for(i = inc; i < 8; i++){
                j = i;
                comparecount++;
                while(j >= inc && number[num][j-inc] > number[num][j]){
                    swapcount++;
                    save(j,j-inc);
                    int temp = number[num][j];
                    number[num][j] = number[num][j-inc];
                    number[num][j-inc] = temp;
                    j -= inc;
                }
            }
        }
    }

    public void save(int i, int j){
        for(k = 1; k <= 8; k++){
            number[num+1][k-1] = number[num][k-1];
        }
        number[num][8] = i;
        number[num][9] = j;
        number[num][10] = i-j;
        number[num][11] = swapcount;
        number[num][12] = comparecount;
        num++;
    }


    public void menu1Action(ActionEvent event) {
        shuffle.shuffle(number,8);
        swapcount = 0;
        comparecount = 0;
        shellsort();
        max = num;
        num = 1;
        show(num);
    }

    public void menu2Action(ActionEvent event) {
        num = 1;
        show(num);
    }

    public void func1ButtonAction(ActionEvent event) {
        if(num > 1) {
            num--;
            show(num);
        }
    }

    public void func2ButtonAction(ActionEvent event) {
        if(num < max) {
            num++;
            show(num);
        }
    }

    @FXML
    Label l_0;
    @FXML
    Label l_1;
    @FXML
    Label l_2;
    @FXML
    Label l_3;
    @FXML
    Label l_4;
    @FXML
    Label l_5;
    @FXML
    Label l_6;
    @FXML
    Label l_7;
    @FXML
    Label l_8;
    @FXML
    Label l_9;

    Label [] label;

    @FXML
    void initialize() {
        label = new Label[]{l_0,l_1,l_2,l_3,l_4,l_5,l_6,l_7,l_8,l_9};
    }

    public void show(int num){
        for(i = 0; i < 8; i++) {
            label[i].setText(number[num][i] + "");
        }
        if(num == max) {
            label[8].setText("\n\n\n swapcount:" + number[num - 1][11] + "\n comparecount:" + number[num - 1][12]);
        }else{
            label[8].setText(number[num][10] + "つずつ離れたデータを比較\n"
                    + number[num][number[num][9]] + "と" + number[num][number[num][8]] + "を入れ替える\n"
                    + "\n swapcount:" + number[num - 1][11] + "\n comparecount:" + number[num - 1][12]);
        }
        label[9].setText("inc ← 4\n" +
                "for inc = inc/2 to 0 do\n" +
                "   for i = inc to < 8 do\n" +
                "      j ← i\n" +
                "      while j >= inc and number[j-inc] > number[j]\n" +
                "         temp ← number[j]\n" +
                "         number[j] ← number[j-inc]\n" +
                "         number[j-inc] ← temp\n" +
                "         j ← j - inc");
        color(number[num][8],number[num][9]);
    }

    public void color(int i, int j){
        for(k = 0; k < 8; k++) {
            label[k].setStyle("-fx-text-fill: black; -fx-font-size: 40");
        }
        label[i].setStyle("-fx-text-fill: red; -fx-font-size: 40");
        label[j].setStyle("-fx-text-fill: red; -fx-font-size: 40");
    }
}
