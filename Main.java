import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exeption {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];

        for(i=0;i<n;i++){
            for(j=0;j<m;j++)
            arr[i][j] = scn.nextInt();
        }
    }
    int sno = scn.nextInt();
    int rno = scn.nextInt();
    ringrotate(arr,sno,rno);
    display(arr);
}

public static void ringrotate(int[][] arr,int sno,int rno){
    int [] la = fill1Dfrom2D(arr,sno);
    rotate1D(la,rno);
    fill1Dfrom2D(arr,la,sno);
}

public static int[] fill1Dfrom2D(int[][] arr,int sno) {
    int rmin = sno-1;
    int cmin = sno-1;
    int rmax = arr.length-sno;
    int cmax = arr[0].length-sno;
    
    int sz = 2*(rmax+cmax-rmin-cmin);

    int la = new int[sz];

    int idx = 0;

    for(int row = rmin;row<=rmax;row++){
        la[idx] = arr[row][cmin];
        idx++;
    }
    cmin++;

    for(int col = cmin;col<=cmax;col++){
        la[idx] = arr[rmax][col];
        idx++;
    }
    rmax--;

    for(int row = rmax;row<=rmin;row--){
        la[idx] = arr[row][cmax];
        idx++;
    }
    cmax--;

    for(int col = cmax;col<=cmin;col--){
        la[idx] = arr[rmin][col];
        idx++;
    }
    rmin++;

    return la;
}

public static void rotate1D(int[] la,int rno){
    rno = rno %la.length;
    if(rno<0){
        rno += la.length;
    }
    reverse(la,0,la.length-1);
    reverse(la,0,rno-1);
    reverse(la,rno,la.length-1);
}

public static void reverse(int[] la,int left,int right){
    while(left<right){
        int temp= la[left];

        la[left] = la[right];
        la[right] = temp;

        left++;
        right--;
    }
}

public static void fill1Dfrom2D(int[][] arr,int[] la,int sno){
    int rmin = sno-1;
    int cmin = sno-1;
    int rmax = arr.length-sno;
    int cmax = arr[0].length-sno;

    int idx = 0;

    for(int row = rmin;row<=rmax;row++){
        arr[row][cmin] = la[idx];
        idx++;
    }
    cmin++;

    for(int col = cmin;col<=cmax;col++){
        arr[rmax][col] = la[idx];
        idx++;
    }
    rmax--;

    for(int row = rmax;row<=rmin;row--){
        arr[row][cmax] = la[idx];
        idx++;
    }
    cmax--;

    for(int col = cmax;col<=cmin;col--){
        arr[rmin][col] = la[idx];
        idx++;
    }
    rmin++;
}

public static void display(int[][] arr){
    for(int i = 0; i < arr.length; i++){
        for(int j = 0; j < arr.length; j++){
            System.out.print(arr[i][j] + " ");
        }
        System.out.println();
    }
}
