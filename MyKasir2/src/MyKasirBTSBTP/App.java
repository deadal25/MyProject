/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MyKasirBTSBTP;

import com.config.MyConfig;
import controller.ControllerDB;
import java.awt.Color;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import models.Produk;

/**
 *
 * @author USER
 */
public class App extends javax.swing.JFrame {

    String Tanggal;
    private DefaultTableModel model;
    private boolean isReadMode = true;

    private void setComponentStatus() {
        txtID.setEnabled(!isReadMode);
        btnSIMPAN.setEnabled(!isReadMode);
        btnCLEAR.setEnabled(isReadMode);
        btnEDIT.setEnabled(!isReadMode);
        btnTAMBAH.setEnabled(!isReadMode);
    }

    public void totalBiaya() {
        int jumlahBaris = TabelMakanan.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(TabelMakanan.getValueAt(i, 3).toString());
            hargaBarang = Integer.parseInt(TabelMakanan.getValueAt(i, 4).toString());
            totalBiaya = (jumlahBarang * hargaBarang);
        }
        txtTotalBayar.setText(String.valueOf(totalBiaya));
        txtTOTAL.setText("Rp" + totalBiaya + ",00");
    }

    private void autonumber() {
        try {
            Connection c = MyConfig.connection();
            String sql = "SELECT * FROM `db_warungbtsbtp` ORDER BY NoFaktur DESC ";
            PreparedStatement s = c.prepareStatement(sql);
            ResultSet r = s.executeQuery();
            if (r.next()) {
                String NoFaktur = r.getString("NoFaktur").substring(2);
                String TR = "" + (Integer.parseInt(NoFaktur) + 1);
                String No1 = "";

                if (TR.length() == 1) {
                    No1 = "000";
                } else if (TR.length() == 2) {
                    No1 = "00";
                } else if (TR.length() == 3) {
                    No1 = "0";
                } else if (TR.length() == 4) {
                    No1 = "";
                }
                txtID.setText("TR" + No1 + TR);
            } else {
                txtID.setText("TR0001");
            }

            r.close();
            s.close();
        } catch (Exception e) {
            System.out.println("AutoNumberEror");
        }
    }

    public void loadData() {
        DefaultTableModel model = (DefaultTableModel) TabelMakanan.getModel();
        model.addRow(new Object[] {
                txtID.getText(),
                txtIDMakanan.getText(),
                txtNamaMakanan.getText(),
                txtHargaMakanan.getText(),
                txtJumlahMakanan.getText(),
                txtTotalBayar.getText(),
        });
    }

    public void kosong() {
        DefaultTableModel model = (DefaultTableModel) TabelMakanan.getModel();

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public void utama() {
        txtID.setText("");
        txtIDMakanan.setText("");
        txtNamaMakanan.setText("");
        txtHargaMakanan.setText("");
        autonumber();
    }

    public void clear() {
        txtNoCS.setText("");
        txtNamaCS.setText("");
        txtTotalBayar.setText("");
        txtBayar.setText("");
        txtTOTAL.setText("");
    }

    public void clear2() {
        txtIDMakanan.setText("");
        txtNamaMakanan.setText("");
        txtHargaMakanan.setText("");
        txtJumlahMakanan.setText("");
    }

    public void tambahTransaksi() {
        int jumlah, harga, total;

        jumlah = Integer.valueOf(txtJumlahMakanan.getText());
        harga = Integer.valueOf(txtHargaMakanan.getText());
        total = jumlah * harga;

        txtTotalBayar.setText(String.valueOf(total));

        loadData();
        totalBiaya();
        clear2();
        txtIDMakanan.requestFocus();
    }

    public void editApp() {
        loadData();
        kosong();
        totalBiaya();
    }

    /**
     * Creates new form App
     */
    public App() {
        initComponents();

        // modelTabel();

        // buat Model
        model = new DefaultTableModel();

        TabelMakanan.setModel(model);

        model.addColumn("No Transaksi");
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        model.addColumn("Total");

        utama();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");

        txtTanggal.setText(s.format(date));
        txtTotalBayar.setText("0");
        txtBayar.setText("0");
        txtKembalian.setText("0");
        txtNoCS.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txNoCS = new javax.swing.JLabel();
        txID1 = new javax.swing.JLabel();
        txNamaCS = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNoCS = new javax.swing.JTextField();
        txtNamaCS = new javax.swing.JTextField();
        txTanggal = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        txIDMakanan = new javax.swing.JLabel();
        txtIDMakanan = new javax.swing.JTextField();
        txNamaMakanan = new javax.swing.JLabel();
        txtNamaMakanan = new javax.swing.JTextField();
        txNamaMakanan1 = new javax.swing.JLabel();
        txtHargaMakanan = new javax.swing.JTextField();
        txJumlahMakanan = new javax.swing.JLabel();
        txtJumlahMakanan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelMakanan = new javax.swing.JTable();
        btnTAMBAH = new javax.swing.JButton();
        btnCLEAR = new javax.swing.JButton();
        btnEDIT = new javax.swing.JButton();
        btnEXIT = new javax.swing.JButton();
        btnSIMPAN = new javax.swing.JButton();
        txtTOTAL = new javax.swing.JTextField();
        txTotalBayar = new javax.swing.JLabel();
        txBayar = new javax.swing.JLabel();
        txKembalian = new javax.swing.JLabel();
        txtTotalBayar = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        txtKembalian = new javax.swing.JTextField();
        btnREAD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("WARUNG MAKAN BTS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        txNoCS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txNoCS.setText("No Customer");

        txID1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txID1.setText("ID Transaksi");

        txNamaCS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txNamaCS.setText("Nama Customer");

        txtID.setEnabled(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtNamaCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaCSActionPerformed(evt);
            }
        });

        txTanggal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txTanggal.setText("Tanggal");

        txtTanggal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTanggal.setEnabled(false);

        txIDMakanan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txIDMakanan.setText("ID Makanan");

        txtIDMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDMakananActionPerformed(evt);
            }
        });

        txNamaMakanan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txNamaMakanan.setText("Nama Makanan");

        txtNamaMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaMakananActionPerformed(evt);
            }
        });

        txNamaMakanan1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txNamaMakanan1.setText("Harga Makanan");

        txtHargaMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaMakananActionPerformed(evt);
            }
        });

        txJumlahMakanan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txJumlahMakanan.setText("Jumlah Makanan");

        txtJumlahMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahMakananActionPerformed(evt);
            }
        });

        TabelMakanan.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "ID", "NAMA", "HARGA", "JUMLAH"
                }));
        jScrollPane1.setViewportView(TabelMakanan);

        btnTAMBAH.setBackground(new java.awt.Color(0, 153, 153));
        btnTAMBAH.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnTAMBAH.setText("TAMBAH");
        btnTAMBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTAMBAHActionPerformed(evt);
            }
        });

        btnCLEAR.setBackground(new java.awt.Color(0, 153, 153));
        btnCLEAR.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCLEAR.setForeground(new java.awt.Color(204, 0, 51));
        btnCLEAR.setText("CLEAR");
        btnCLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLEARActionPerformed(evt);
            }
        });

        btnEDIT.setBackground(new java.awt.Color(0, 153, 153));
        btnEDIT.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEDIT.setText("EDIT");
        btnEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEDITActionPerformed(evt);
            }
        });

        btnEXIT.setBackground(new java.awt.Color(255, 0, 51));
        btnEXIT.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btnEXIT.setText("EXIT");
        btnEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXITActionPerformed(evt);
            }
        });

        btnSIMPAN.setBackground(new java.awt.Color(0, 255, 51));
        btnSIMPAN.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnSIMPAN.setText("SIMPAN");
        btnSIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSIMPANActionPerformed(evt);
            }
        });

        txtTOTAL.setBackground(new java.awt.Color(255, 102, 102));
        txtTOTAL.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        txtTOTAL.setText("Rp. 0");
        txtTOTAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTOTALActionPerformed(evt);
            }
        });

        txTotalBayar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txTotalBayar.setText("Total Bayar");

        txBayar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txBayar.setText("Bayar");

        txKembalian.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txKembalian.setText("Kembalian");

        txtTotalBayar.setEnabled(false);
        txtTotalBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalBayarActionPerformed(evt);
            }
        });

        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });

        txtKembalian.setEnabled(false);
        txtKembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKembalianActionPerformed(evt);
            }
        });

        btnREAD.setBackground(new java.awt.Color(0, 153, 153));
        btnREAD.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnREAD.setText("READ");
        btnREAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREADActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtIDMakanan,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txIDMakanan,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txID1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txNoCS, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txNamaCS, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(txtID,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                140, Short.MAX_VALUE)
                                                                        .addComponent(txtNoCS)
                                                                        .addComponent(txtNamaCS))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(txTanggal,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 76,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtTanggal,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 141,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(30, 30, 30))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtNamaMakanan,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txNamaMakanan,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                100,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(32, 32, 32)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtHargaMakanan,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txNamaMakanan1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                100,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtJumlahMakanan,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txJumlahMakanan))
                                                                .addGap(17, 17, 17))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnSIMPAN,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 112,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtTOTAL,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 210,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(26, 26, 26)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(txKembalian,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(txBayar,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(txTotalBayar,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtTotalBayar)
                                                                        .addComponent(txtBayar)
                                                                        .addComponent(txtKembalian)))
                                                        .addComponent(jScrollPane1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 544,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(btnCLEAR, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnEDIT, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnTAMBAH, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnEXIT, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnREAD, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                116, Short.MAX_VALUE))
                                                .addContainerGap())))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txID1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txNoCS, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNoCS, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txNamaCS, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNamaCS, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txIDMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txNamaMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txNamaMakanan1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txJumlahMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtIDMakanan, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNamaMakanan, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtHargaMakanan, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtJumlahMakanan, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(btnSIMPAN,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE, 50,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(txtTOTAL))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(txTotalBayar)
                                                                        .addComponent(txtTotalBayar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(6, 6, 6)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(txBayar)
                                                                        .addComponent(txtBayar,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txKembalian)
                                                        .addComponent(txtKembalian,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnREAD, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16,
                                                        Short.MAX_VALUE)
                                                .addComponent(btnTAMBAH, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(btnEDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(btnCLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEXIT, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)))));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaCSActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNamaCSActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtNamaCSActionPerformed

    private void txtHargaMakananActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtHargaMakananActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtHargaMakananActionPerformed

    private void btnTAMBAHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTAMBAHActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }// GEN-LAST:event_btnTAMBAHActionPerformed

    private void btnCLEARActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCLEARActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) TabelMakanan.getModel();
        int selectedRow = TabelMakanan.getSelectedRow();

        if (selectedRow != -1) {
            String noFaktur = (String) model.getValueAt(selectedRow, 0);

            try {
                Connection c = MyConfig.connection();

                // Hapus data dari tabel tb_warunngbtsbtp
                String deleteSql = "DELETE FROM tb_warunngbtsbtp WHERE NoFaktur = ?";
                PreparedStatement deleteStatement = c.prepareStatement(deleteSql);
                deleteStatement.setString(1, noFaktur);
                deleteStatement.executeUpdate();
                deleteStatement.close();

                // Hapus baris dari JTable
                model.removeRow(selectedRow);

                // Hitung total biaya dan tampilkan
                totalBiaya();

                // Reset input bayar dan kembalian
                txtBayar.setText("0");
                txtKembalian.setText("0");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

    }// GEN-LAST:event_btnCLEARActionPerformed

    private void btnEDITActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEDITActionPerformed
        // TODO add your handling code here:
        // DefaultTableModel model = (DefaultTableModel) TabelMakanan.getModel();
        int selectedRow = TabelMakanan.getSelectedRow();

        // Periksa jika ada baris yang dipilih
        if (selectedRow != -1) {
            String noFaktur = (String) model.getValueAt(selectedRow, 0);
            String idMakanan = (String) model.getValueAt(selectedRow, 1);
            String namaMakanan = (String) model.getValueAt(selectedRow, 2);
            String harga = (String) model.getValueAt(selectedRow, 3);
            String jumlah = (String) model.getValueAt(selectedRow, 4);
            String total = (String) model.getValueAt(selectedRow, 5);

            txtID.setText(noFaktur);
            txtIDMakanan.setText(idMakanan);
            txtNamaMakanan.setText(namaMakanan);
            txtHargaMakanan.setText(harga);
            txtJumlahMakanan.setText(jumlah);
            txtTotalBayar.setText(total);

            // Nonaktifkan tombol Edit
            btnEDIT.setEnabled(true);
            // Aktifkan tombol Simpan
            btnSIMPAN.setEnabled(true);

            editApp();
        }
    }// GEN-LAST:event_btnEDITActionPerformed

    private void btnEXITActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEXITActionPerformed
        // TODO add your handling code here:
        System.exit(0);

    }// GEN-LAST:event_btnEXITActionPerformed

    private void btnSIMPANActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSIMPANActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) TabelMakanan.getModel();

        String noTransaksi = txtID.getText();
        String tanggal = txtTanggal.getText();
        String idCustomer = txtID.getText();
        String total = txtTotalBayar.getText();

        try {
            Connection c = MyConfig.connection();
            String sql = "INSERT INTO `db_warungbtsbtp` VALUES (?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, noTransaksi);
            p.setString(2, tanggal);
            p.setString(3, idCustomer);
            p.setString(4, total);
            p.executeUpdate();
            p.close();

        } catch (Exception e) {
            System.out.println("Simpan Penjualan Eror");
        }
        try {
            Connection c = MyConfig.connection();
            int baris = TabelMakanan.getRowCount();

            for (int i = 0; i < baris; i++) {
                String sql = "INSERT INTO `tb_warunngbtsbtp` (NoFaktur, ID_Barang, Nama_Barang, Jumlah, Harga, Total) VALUES ('"
                        + TabelMakanan.getValueAt(i, 0) + "','" + TabelMakanan.getValueAt(i, 1) + "','"
                        + TabelMakanan.getValueAt(i, 2)
                        + "','" + TabelMakanan.getValueAt(i, 3) + "','" + TabelMakanan.getValueAt(i, 4) + "','"
                        + TabelMakanan.getValueAt(i, 5) + "')";

                PreparedStatement p = c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            }
        } catch (Exception e) {
            System.out.println("Simpanki Penjualan Eror");
        }
        clear();
        utama();
        autonumber();
        kosong();
        txtTOTAL.setText("RP. 0");
    }// GEN-LAST:event_btnSIMPANActionPerformed

    private void txtTOTALActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtTOTALActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtTOTALActionPerformed

    private void txtJumlahMakananActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtJumlahMakananActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtJumlahMakananActionPerformed

    private void btnREADActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnREADActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        isReadMode = true;
        setComponentStatus();
        DefaultTableModel model = (DefaultTableModel) TabelMakanan.getModel();

        try {
            Connection c = MyConfig.connection();
            String sql = "SELECT * FROM tb_warunngbtsbtp";
            PreparedStatement p = c.prepareStatement(sql);
            ResultSet rs = p.executeQuery();

            // Membersihkan tabel sebelum menampilkan data baru
            model.setRowCount(0);

            // Menambahkan data ke tabel
            while (rs.next()) {
                Object[] row = {
                        rs.getString("NoFaktur"),
                        rs.getString("ID_Barang"),
                        rs.getString("Nama_Barang"),
                        rs.getString("Jumlah"),
                        rs.getString("Harga"),
                        rs.getString("Total")
                };
                model.addRow(row);
            }

            rs.close();
            p.close();
            setComponentStatus();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }// GEN-LAST:event_btnREADActionPerformed

    private void txtNamaMakananActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtNamaMakananActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtNamaMakananActionPerformed

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtBayarActionPerformed
        // TODO add your handling code here:
        int total, bayar, kembalian;

        total = Integer.valueOf(txtTotalBayar.getText());
        bayar = Integer.valueOf(txtBayar.getText());

        if (total > bayar) {
            JOptionPane.showMessageDialog(null, "Uang Tidak Cukup");

        } else {
            kembalian = bayar - total;
            txtKembalian.setText(String.valueOf(kembalian));
        }
    }// GEN-LAST:event_txtBayarActionPerformed

    private void txtKembalianActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtKembalianActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtKembalianActionPerformed

    private void txtTotalBayarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtTotalBayarActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtTotalBayarActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
        autonumber();
    }// GEN-LAST:event_txtIDActionPerformed

    private void txtIDMakananActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtIDMakananActionPerformed
        // TODO add your handling code here:
        txtIDMakanan.selectAll();
    }// GEN-LAST:event_txtIDMakananActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelMakanan;
    private javax.swing.JButton btnCLEAR;
    private javax.swing.JButton btnEDIT;
    private javax.swing.JButton btnEXIT;
    private javax.swing.JButton btnREAD;
    private javax.swing.JButton btnSIMPAN;
    private javax.swing.JButton btnTAMBAH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txBayar;
    private javax.swing.JLabel txID1;
    private javax.swing.JLabel txIDMakanan;
    private javax.swing.JLabel txJumlahMakanan;
    private javax.swing.JLabel txKembalian;
    private javax.swing.JLabel txNamaCS;
    private javax.swing.JLabel txNamaMakanan;
    private javax.swing.JLabel txNamaMakanan1;
    private javax.swing.JLabel txNoCS;
    private javax.swing.JLabel txTanggal;
    private javax.swing.JLabel txTotalBayar;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHargaMakanan;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDMakanan;
    private javax.swing.JTextField txtJumlahMakanan;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtNamaCS;
    private javax.swing.JTextField txtNamaMakanan;
    private javax.swing.JTextField txtNoCS;
    private javax.swing.JTextField txtTOTAL;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTotalBayar;
    // End of variables declaration//GEN-END:variables
}
