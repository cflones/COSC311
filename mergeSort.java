/*
Cassie Flones
COSC 311 FA19
pp02
12/10/2019
 */

import java.util.Random;
import java.util.Scanner;

public class mergeSort {
static Scanner keyboard = new Scanner(System.in);
static Random random = new Random();

    public static void main(String args[])
    {
        int arrayLength = getArrayLength();
        int[] array;
        array = getArray(arrayLength);
        long startTime = System.nanoTime();
        sort(array, 0, array.length-1);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println(elapsedTime);
    }
    public static int getArrayLength()
    {
        System.out.println("Enter array length: ");
        int length = keyboard.nextInt();
        return length;
    }
    public static int[] getArray(int len)
    {
        int[] arr = new int[len];
        for (int i=0; i<len; i++)
            arr[i] = random.nextInt();
        return arr;
        /*
        Random to generate array
         */
    }
    public static void sort(int arr[], int l, int r)
    {

        if (l < r)
        {
            int m = (l+r)/2;
            sort(arr, l, m);
            sort(arr, m+1, r);
            merge(arr, l, m, r);
        }

    }
    public static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l +1;
        int n2 = r - m;
        int L[] = new int [n1];
        int R[] = new int [n2];
        for (int i=0; i<n1; i++)
        {
            L[i] = arr[l+i];
        }
        for (int j=0; j<n2; j++)
        {
            R[j] = arr[m+1+j];
        }
        int i=0, j=0;
        int k=l;
        while (i<n1 && j<n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
            while (i<n1)
            {
                arr[k] = L[i];
                i++;
                k++;
            }
            while (j<n2)
            {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
    }
}
