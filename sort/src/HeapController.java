import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class HeapController {

    int [][] number = new int[20][9];
    int i, j;
    int num, max;
    int swapcount, comparecount;
    Main shuffle =new Main();
    
    public void swap(int[][] a, int n1, int n2) {
        int t = a[1][n1];
        a[1][n1] = a[1][n2];
        a[1][n2] = t;
        swapcount++;
    }
    
    public void downHeap(int[][] a, int left, int right){
        int temp = a[1][left];
        int child;
        int parent;
        
        for(parent = left; parent < (right + 1)/2; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl + 1;
            comparecount++;
            if(cr <= right && a[1][cr] > a[1][cl]) {
                child = cr;
            } else {
                child = cl;
            }
            comparecount++;
            if(temp >= a[1][child]){
                break;
            }
            a[1][parent] = a[1][child];
        }
        a[1][parent] = temp;
        num++;
        save(a, num);
    }
    
    public void heapsort(int[][] a) {
        num = 1;
        int n = 7;
        for(i = (n - 1)/2; i >= 0; i--) {
            downHeap(a, i, n - 1);
        }
        for(i = n - 1; i > 0; i--) {
            swap(a, 0, i);
            num++;
            save(a, num);
            downHeap(a, 0, i - 1);
        }
    }

    public void save(int[][] a,int b){
        for(j = 0; j < 7; j++){
            number[b][j] = a[1][j];
        }
        number[b][7] = swapcount;
        number[b][8] = comparecount;
    }

    public void leftButtonAction(ActionEvent event) {
        if(num > 2) {
            num--;
            show(num);
        }
    }

    public void rightButtonAction(ActionEvent event) {
        if(num < max) {
            num++;
            show(num);
        }
    }

    public void menu1Action(ActionEvent event) {
        shuffle.shuffle(number,7);
        swapcount = 0;
        comparecount = 0;
        heapsort(number);
        max = num;
        num = 1;
        show(num);
    }

    public void menu2Action(ActionEvent event) {
        num = 2;
        show(num);
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

    public void show(int num) {
        int x = 7 - number[num][7];
        for(i = 0; i < 7; i++) {
            label[i].setText(number[num][i] + "");
        }
        label[7].setText(number[num][0] + "  " + number[num][1] + "  " + number[num][2] + "  " + number[num][3] + "  "
                + number[num][4] + "  "  + number[num][5] + "  "  + number[num][6]);
        color();
        if(number[num][7] > number[num - 1][7]) {
            label[8].setText("最大の要素は" + x + "\n" + (x + 1) + "を整列済みにする" +
                    "\n swapcount:" + number[num][7] + "\n comparecount:" + number[num][8]);
        } else {
            label[8].setText("最大の要素は" + x + "\n" +
                    "\n swapcount:" + number[num][7] + "\n comparecount:" + number[num][8]);
        }
        label[9].setText("heapSort(int[] a)\n" +
                "    n ← a.length\n" +
                "    for i = (n - 1) / 2 to 0 do \n" +
                "        downHeap(a, i, n - 1)\n" +
                "    for i = n - 1 to 0 do\n" +
                "        swap(a, 0, i)\n" +
                "        downHeap(a, 0, i - 1)\n" +
                "\n" +
                "downHeap(int[] a, int left, int right) \n" +
                "    temp ← a[left]\n" +
                "    for  parent = left to child  < (right + 1) / 2 do\n" +
                "        cl ← parent * 2 + 1\n" +
                "        cr ← cl + 1\n" +
                "        if  cr <= right and a[cr] > a[cl] then\n" +
                "            child ← cr\n" +
                "        else\n" +
                "            child ← cl\n" +
                "        if  temp >= a[child] then\n" +
                "            break\n" +
                "        a[parent] ← a[child]\n" +
                "    a[parent] ← temp\n" +
                "\n" +
                "swap(int[] a, int i1, int i2) \n" +
                "     t ← a[i1]\n" +
                "     a[i1] ← a[i2]\n" +
                "     a[i2] ← t");
    }

    public void color(){
        int x = 7 - number[num][7];
        for(i = 0; i < 7; i++) {
            if(number[num][i] == x) {
                label[i].setStyle("-fx-text-fill: red; -fx-font-size: 30");
            }else if(number[num][i] > x){
                label[i].setStyle("-fx-text-fill: blue; -fx-font-size: 30");
            }else {
                label[i].setStyle("-fx-text-fill: black; -fx-font-size: 30");
            }

        }

    }

}
