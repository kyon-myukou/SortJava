import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BubbleController {

    int [][] number = new int[30][12];
    int i,k;
    int num,max;
    int swapcount,comparecount;
    Main shuffle =new Main();

    public void bubblesort() {
        num = 1;
        for(int i = 7; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                comparecount++;            
                if(number[num][j] > number[num][j+1]) {
                    save(j,j+1);
                    int tmp = number[num][j];
                    number[num][j] = number[num][j+1];
                    number[num][j+1] = tmp;
                    swapcount++;
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
        number[num][10] = swapcount;
        number[num][11] = comparecount;
        num++;
    }

    public void menu1Action(ActionEvent event) {
        shuffle.shuffle(number,8);
        swapcount = 0;
        comparecount = 0;
        bubblesort();
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
            label[8].setText("\n\n swapcount:" + number[num - 1][10] + "\n comparecount:" + number[num - 1][11]);
        }else{
            label[8].setText(number[num][number[num][8]] + "と" + number[num][number[num][9]] + "を入れ替える\n"
                    + "\n swapcount:" + number[num - 1][10] + "\n comparecount:" + number[num - 1][11]);
        }
        label[9].setText("num ← 1\n" +
        "for i = 7 to 0 do\n" +
        "    for j = 0 to i do\n" +
        "        if number [j] > number[j+1] then\n" +
        "            tmp ← number[j]\n" +
        "            number[j] ← number[j+1]\n" +
        "            number[j+1] ← tmp\n"
        );
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
