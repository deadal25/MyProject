/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author USER
 */
public class Produk {
    private String NoFaktur;
    private String ID_Barang;
    private String Nama_Barang;
    private int Jumlah;
    private int Harga;
    
    public Produk(String noFaktur, String iD_Barang, String nama_Barang, int jumlah, int harga) {
        NoFaktur = noFaktur;
        ID_Barang = iD_Barang;
        Nama_Barang = nama_Barang;
        Jumlah = jumlah;
        Harga = harga;
    }
    public String getNoFaktur() {
        return NoFaktur;
    }
    public void setNoFaktur(String noFaktur) {
        NoFaktur = noFaktur;
    }
    public String getID_Barang() {
        return ID_Barang;
    }
    public void setID_Barang(String iD_Barang) {
        ID_Barang = iD_Barang;
    }
    public String getNama_Barang() {
        return Nama_Barang;
    }
    public void setNama_Barang(String nama_Barang) {
        Nama_Barang = nama_Barang;
    }
    public int getJumlah() {
        return Jumlah;
    }
    public void setJumlah(int jumlah) {
        Jumlah = jumlah;
    }
    public int getHarga() {
        return Harga;
    }
    public void setHarga(int harga) {
        Harga = harga;
    }
}
