/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.config.MyConfig;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Produk;

/**
 *
 * @author USER
 */
public class ControllerDB extends MyConfig {
    public static List<Produk> getDatabase() {
        List<Produk> produkList = new ArrayList<>();
        connection();
        try {
            query = "SELECT NoFaktur,ID_Barang,Nama_Barang, Jumlah, Harga, Total FROM tb_warunngbtsbtp";
            preparedStatement = connect.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String NoFaktur = resultSet.getString("NoFaktur");
                String ID_Barang = resultSet.getString("ID_Barang");
                String Nama_Barang = resultSet.getString("Nama_Barang");
                int Jumlah = resultSet.getInt("Jumlah");
                int Harga = resultSet.getInt("Harga");

                Produk produk = new Produk(NoFaktur, ID_Barang, Nama_Barang, Jumlah, Harga);
                produkList.add(produk);
            }
            // preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produkList;
    }

    public static void updateNamaDB(String ID_Barang, String Nama_Barang) {
        connection();
        query = "UPDATE tb_warunngbtsbtp SET Nama_Barang=? WHERE ID_Barang=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, Nama_Barang);
            preparedStatement.setString(2, ID_Barang);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateHargaDB(String ID_Barang, Long Harga) {
        connection();
        query = "UPDATE tb_warunngbtsbtp SET Harga=? WHERE ID_Barang=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setLong(1, Harga);
            preparedStatement.setString(2, ID_Barang);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateJumlahDB(String ID_Barang, Long Jumlah) {
        connection();
        query = "UPDATE tb_warunngbtsbtp SET Jumlah=? WHERE ID_Barang=?";
        try {
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setLong(1, Jumlah);
            preparedStatement.setString(2, ID_Barang);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
