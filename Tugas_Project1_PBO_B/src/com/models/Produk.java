package com.models;


public class Produk {
    
    private String NoFaktur;
    private int ID_Barang;
    private String Nama_Barang;
    private int Jumlah;
    private int Harga;
    
    public Produk(String noFaktur, int iD_Barang, String nama_Barang, int jumlah, int harga) {
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
    public int getID_Barang() {
        return ID_Barang;
    }
    public void setID_Barang(int iD_Barang) {
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
    // private int id;
    // private String nama;
    // private long harga;
    // private int stok;
    // public Produk(int id, String nama, long harga, int stok) {
    //     this.id = id;
    //     this.nama = nama;
    //     this.harga = harga;
    //     this.stok = stok;
    // }
    // public int getId() {
    //     return id;
    // }
    // public void setId(int id) {
    //     this.id = id;
    // }
    // public String getNama() {
    //     return nama;
    // }
    // public void setNama(String nama) {
    //     this.nama = nama;
    // }
    // public long getHarga() {
    //     return harga;
    // }
    // public void setHarga(long harga) {
    //     this.harga = harga;
    // }
    // public int getStok() {
    //     return stok;
    // }
    // public void setStok(int stok) {
    //     this.stok = stok;
    // }

}
