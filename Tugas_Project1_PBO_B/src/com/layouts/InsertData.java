package com.layouts;

import java.util.Scanner;

import com.controller.ControllerDB;

public class InsertData {
    public static void showInsertData(){
        try {
            ////AL QADRI H071221052
            Scanner sc = new Scanner(System.in);
            System.out.println("====================================");
            System.out.println("SILAHKAN INPUTKI PRODUKTA KANDA ");
            System.out.println("====================================");
            System.out.println("NAMA");
            String name = sc.nextLine();
            System.out.println("HARGA");
            long harga = sc.nextInt();
            System.out.println("STOK");
            int stok = sc.nextInt();
            System.out.println("====================================");
            if (ControllerDB.insertDB(name, harga, stok)) {
                System.out.println("BERHASIL INSERT DATA");
                
            }else{
                System.out.println("GAGAL MENAMBAHKAN DATA");
            }
            System.out.println("------------------------------------");
            Menu.showMenu();
            sc.close();
        
        } catch (Exception e) {
            InsertData.showInsertData();
        }
    }
}
