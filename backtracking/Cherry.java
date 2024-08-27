import java.util.*;

public class Cherry 
{
static boolean valid(int i, int j, int n, int m)
{
    if (i >= n || j>= m) 
    {
         return false;
    }


    return true;
}

    static int print(int arr[][], int i, int j, int n, int m) 
    {
        boolean choice1 = valid(i+1, j, n, m);
        boolean choice2 = valid(i, j+1, n, m);
 
        if (i == n - 1 && j == m - 1) {
            return arr[i][j];
        }

       if (choice1 && choice2) 
       {
          int cal1 = print(arr, i+1, j, n, m) ;
          int cal2 = print(arr, i, j+1, n, m);

          return arr[i][j] + Math.min(cal1, cal2);
       }

       if (choice1) 
       {
        int cal1 = print(arr, i+1, j, n, m) ;

          return arr[i][j] + cal1;
           
       }

       int cal2 = print(arr, i, j+1, n, m) ;

       return arr[i][j] + cal2;
        

     

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        int n = sc.nextInt();
       
        int m = sc.nextInt();
        int arr[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(print(arr, 0, 0, n, m));
    }
}
