package com.layouts;

import java.util.Scanner;

import com.controller.ControllerDB;

public class ReadData {


    public static void showReadData(){
        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("DATA PRODUK BANG");
        System.out.println("====================================");
        ControllerDB.getDatabase();
        System.out.println("====================================");
        
        System.out.println("1. MENU ");
        System.out.println("2. EXIT "); 
        System.out.print("Pilih bang: ");
        try {
            int selectMenu = sc.nextInt();
            switch (selectMenu) {
                case 1:
                Menu.showMenu();
                    break;
                case 2:
                System.out.println("==========================================");
                System.out.println("SAMPAI JUMPA KEMBALI...");
                System.out.println("==========================================");
                System.exit(selectMenu);
                break;
            
                default:
                System.out.println("==============================================");
                System.out.println("MAAF MENU YANG DIPILIH TIDAK TERSEDIA");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                ReadData.showReadData();
                    break;
            }
            
        } catch (Exception e) {
            System.out.println("==============================================");
               System.out.println("MASUKKAN INPUTAN ANGKA BANG");
               System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
               ReadData.showReadData();
        }
        
        
        
        
        System.out.println("--------------------------------");
        Menu.showMenu();
        sc.close();
    }
    
}
