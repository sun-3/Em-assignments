import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        ArrayList a[] = new ArrayList[n]; 
        int size = 0;
        int x = 0;
        int y = 0;
        int result =0;
        for (int i=0; i < n; i++){
            a[i] = new ArrayList();
        }
        
        for (int i = 0; i < n; i++){
            size = sc.nextInt();
            for (int j = 0; j < size; j++){
                a[i].add(sc.nextInt());
            }            
        }
        
        int q = sc.nextInt();
        
        for (int i = 0; i < q; i++){
            x = sc.nextInt();
            y = sc.nextInt();  
            try{
            System.out.println(a[x-1].get(y-1));                         
            }
            catch (Exception e){
                System.out.println("ERROR!");
            }
            
        }       
        
    }
}
