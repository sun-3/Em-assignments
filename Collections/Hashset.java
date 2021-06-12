import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Set<String> set = new HashSet<String>();
        
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        
        for(int i = 0;i < t;i++){
            String s1 = in.next();
            String s2 = in.next();
            set.add(s1 + " " + s2);
            System.out.println(set.size());
        }
        
    }
}
