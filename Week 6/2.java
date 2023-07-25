import java.util.*;

public class MergeArray
{
    public static void main(String args[])
    {
        int i = 0, k=0 , j=0;
        Scanner sc = new Scanner(System.in);
        String inputline = sc.nextLine();
        String[] a = inputline.split(" ");
        int n1 = Integer.parseInt(a[0]);
        int n2 = Integer.parseInt(a[1]);
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int[] merge = new int[n1+n2];
        for(int b=0;b<n1;b++)
        {
            arr1[b]=sc.nextInt();
        }
        for(int c=0;c<n2;c++)
        {
            arr2[c]=sc.nextInt();
        }
        while(i<n1 && j<n2)
        {
            if(arr1[i] < arr2[j])
                merge[k++] = arr1[i++];
            else
                merge[k++] = arr2[j++];
        }
        while(i<n1)
        {
            merge[k++] = arr1[i++];
        }
        while(j<n2)
        {
            merge[k++] = arr2[j++];
        }
        for(int d = 0; d<(n1+n2);d++)
            System.out.print(merge[d] + " ");
    }
}