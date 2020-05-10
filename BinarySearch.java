import java.util.Scanner;
import java.lang.Math;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        int arr[] = new int[100];
        int length = 0;
        for (int i = 0; i < 10; i++) {
            arr[i] = i+1;
            length++;
        }
        
        while(true) {
            System.out.println("1. Tampilkan semua data");
            System.out.println("2. Search data");
            System.out.println("3. Insert data");
            System.out.println("4. Exit");
            System.out.println("Masukkan pilihan: ");
            int pilihan = inp.nextInt();
            if (pilihan==1) {
                for (int i = 0; i < length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.print("\n");
            } else if (pilihan==2) {
                System.out.println("Masukkan angka yang ingin disearch: ");
                int searched = inp.nextInt();
                if (search(arr, searched, length) == -1)
                    System.out.println("Angka tidak ditemukan");
                else 
                    System.out.println(search(arr, searched, length) + " ditemukan");
            } else if (pilihan==3) {
                System.out.println("Masukkan angka yang ingin diinsert: ");
                int inserted = inp.nextInt();
                insert(arr, inserted, length);
                length++;
                System.out.println(inserted + " ditambahkan");
            } else if (pilihan==4) {
                break;
            }
            System.out.println();
        }
        

    }

    private static int search(int arr[], int searched, int length) {
        int mid = length/2;
        int bot = 0;
        int top = length;
        int log2 = (int)(Math.log(length) / Math.log(2));
        int i = 0;
        
        while (i <= log2) {
            if (searched == arr[mid] )
                return searched;
            else if (searched > arr[mid]){
                bot = mid;
                mid = (bot+top)/2;
            }                
            else if (searched < arr[mid]){
                top = mid;
                mid = (bot+top)/2;
            }
            i++;
        }

        return -1;
    }

    private static void insert(int arr[], int inserted, int length) {
        int mid = length/2;
        int bot = 0;
        int top = length;
        int log2 = (int)(Math.log(length) / Math.log(2));
        int i = 0;
        
        //mencari index yang akan diinsert agar sesuai urutan
        if (inserted > arr[top-1]){
            arr[length++] = inserted;
            return;
        }
        while (i <= log2) {
            if (inserted == arr[mid] )
                break;
            else if (inserted > arr[mid]){
                bot = mid;
                mid = (bot+top)/2;
            }                
            else if (inserted < arr[mid]){
                top = mid;
                mid = (bot+top)/2;
            }
            i++;
        }
        length++;
        mid++;
        
        //menggeser semua data disebelah kanan
        for (int j = length; j > mid; j--) {
            arr[j] = arr[j-1];
        }        
        arr[mid] = inserted;
    }
}