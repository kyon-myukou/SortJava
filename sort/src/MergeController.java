import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MergeController {

    int [][] number = new int[30][8];
    int [][] number_1 = new int[30][8];
    int [] a = new int[8];
    int [][] b1 = new int[25][4];
    int [][] b2 = new int[25][4];
    int i,j,k;
    int num,max;
    Main shuffle = new Main();

    public void merge(int[] a1,int[] a2,int[] a){
        i=0;
        j=0;
        while(i<a1.length || j<a2.length){
            if(j>=a2.length || (i<a1.length && a1[i]<a2[j])){
                a[i+j]=a1[i];
                save1(a1);
                i++;
            }
            else{
                a[i+j]=a2[j];
                save2(a2);
                j++;
            }
            num++;
        }
    }

    public void mergesort(int[] a) {
        if(a.length>1){
            int m=a.length/2;
            int n=a.length-m;
            int[] a1=new int[m];
            int[] a2=new int[n];
            for(i=0;i<m;i++) a1[i]=a[i];
            for(i=0;i<n;i++) a2[i]=a[m+i];
            mergesort(a1);
            mergesort(a2);
            merge(a1,a2,a);
        }
    }

    public void save1(int[] c){
        for(k = 0; k < 4; k++){
            b1[num][k] = 0;
        }
        b1[num][i] = c[i];
    }
    public void save2(int[] c){
        for(k = 0; k < 4; k++){
            b2[num][k] = 0;
        }
        b2[num][j] = c[j];
    }

    public void save(){
        num = 2;
        i = 0;
        j = 0;
        int b = 0;
        while(num != max + 1) {
            for (k = 0; k < 8; k++) {
                number_1[num][k] = number_1[num-1][k];
                number[num][k] = number[num-1][k];
            }
            for (k = 0; k < 4; k++) {
                if(num > 4) {
                    if (b1[num - 4][k] != 0) b = b1[num - 4][k];
                    if (b2[num - 4][k] != 0) b = b2[num - 4][k];
                }
            }
            if((num > 4 && num < 9) || (num > 12 && num < 17)){
                number_1[num][i] = b;
                i++;
                if(i == 8){
                    i = 0;
                }
            }
            if((num > 8 && num < 13) || (num > 16 && num < 21)){
                number[num][j] = b;
                j++;
            }
            if(num > 20 && num < 29){
                number_1[num][i] = b;
                i++;
            }
            num++;
        }
    }

    public void menu1Action(ActionEvent event) {
        shuffle.shuffle(number,8);
        for(i = 0; i < 8; i++){
            a[i] = number[1][i];
        }
        num = 1;
        mergesort(a);
        max = num + 3;
        save();
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
    @FXML
    Label l_10;
    @FXML
    Label l_11;
    @FXML
    Label l_12;
    @FXML
    Label l_13;
    @FXML
    Label l_14;
    @FXML
    Label l_15;
    @FXML
    Label l_16;
    @FXML
    Label l_17;

    Label [] label;

    @FXML
    void initialize() {
        label = new Label[]{l_0,l_1,l_2,l_3,l_4,l_5,l_6,l_7,l_8,
                l_9,l_10,l_11,l_12,l_13,l_14,l_15,l_16,l_17};
    }

    public void show(int num){
        for(i = 0; i < 8; i++) {
            label[i+1].setText(number[num][i] + " ");
            label[i+9].setText(number_1[num][i] + " ");
            if(num == 2 && i == 3){
                label[i+1].setText(number[num][i] + " |");
            }
            if(num == 3 && i%2 == 1 && i != 7){
                label[i+1].setText(number[num][i] + " |");
            }
            if(num >= 4 && i != 7){
                label[i+1].setText(number[num][i] + " |");
            }
            if(num >= 9 && i < 3){
                label[i+1].setText(number[num][i] + " ");
            }
            if(num >= 17 && i != 3){
                label[i+1].setText(number[num][i] + " ");
            }

        }
        if(num < 21) {
            if (num >= 6) {
                label[10].setText(number_1[num][1] + " |");
            }
            if (num >= 8) {
                label[12].setText(number_1[num][3] + " |");
            }
            if (num >= 14) {
                label[14].setText(number_1[num][5] + " |");
            }
        }

        label[0].setText("mergesort(int[] a) \n" +
                "    if a.length > 1 then\n" +
                "        m ← a.length / 2\n" +
                "        n ← a.length - m\n" +
                "        for i = 0 to m do\n" +
                "            a1[i] ← a[i]\n" +
                "        for i = 0 to n\n" +
                "            a2[i] ← a[m+i]\n" +
                "        mergesort(a1)\n" +
                "        mergesort(a2)\n" +
                "        merge(a1,a2,a)\n" +
                "\n" +
                "merge(int[] a1,int[] a2,int[] a)\n" +
                "    i ← 0\n" +
                "    j ← 0\n" +
                "    while i < a1.length or j < a2.length\n" +
                "        if j >= a2.length or ( i < a1.length and a1[i] < a2[j] ) then\n" +
                "            a[i+j] ← a1[i]\n" +
                "            i ← i + 1\n" +
                "        else\n" +
                "            a[i+j] ← a2[j]\n" +
                "            j ← j + 1");
    }
}
