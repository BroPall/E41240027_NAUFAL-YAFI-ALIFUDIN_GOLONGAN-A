package minggu12;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static minggu_10.Koneksi.con;


public class PenyimpananBarang extends javax.swing.JFrame {

    private Connection con;
    private Statement st;
    private ResultSet RSpenyimpanan;
    private String sql = "";
String ks;

    public PenyimpananBarang() {
        initComponents();
        con = Koneksi.getConnection();
        ShowDatamasuk();
        ShowDatakeluar();
    }
    
      private void ShowDatamasuk() {
    DefaultTableModel data = new DefaultTableModel();
    data.addColumn("Kode Barang");
    data.addColumn("Nama Barang");
    data.addColumn("Tanggal Masuk");
    data.addColumn("Jumlah");
    data.addColumn("Kondisi");
      try {
        
        st = con.createStatement();
        sql = "SELECT * FROM barang_masuk";
        RSpenyimpanan = st.executeQuery(sql);
        while (RSpenyimpanan.next()) {
            data.addRow(new Object[]{
                RSpenyimpanan.getString("kd_barang"),
                RSpenyimpanan.getString("nama_barang"),
                RSpenyimpanan.getString("tgl_masuk"),
                RSpenyimpanan.getString("jumlah"),
                RSpenyimpanan.getString("kondisi")
            });
        }
        tabel_masuk.setModel(data); 
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        System.out.println("Error: " + e.getMessage());
    }
      }
      private void ShowDatakeluar() {
    DefaultTableModel data = new DefaultTableModel();
    data.addColumn("Kode Barang");
    data.addColumn("Nama Barang");
    data.addColumn("Tanggal Masuk");
    data.addColumn("Tanggal Keluar");
    data.addColumn("Jumlah");
    data.addColumn("Kondisi");
         try {
      
        st = con.createStatement();
        sql = "SELECT * FROM barang_keluar";
        RSpenyimpanan = st.executeQuery(sql);
        while (RSpenyimpanan.next()) {
            data.addRow(new Object[]{
                RSpenyimpanan.getString("kd_barang"),
                RSpenyimpanan.getString("nama_barang"),
                RSpenyimpanan.getString("tgl_masuk"),
                RSpenyimpanan.getString("tgl_keluar"),
                RSpenyimpanan.getString("jumlah"),
                RSpenyimpanan.getString("kondisi")
            });
        }
        tabel_keluar.setModel(data); 
    } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        System.out.println("Error: " + e.getMessage());
    }
      }
      
          private void Clear() {
        kd_b.setText("");
        nb.setText("");
        Tmsuk.setText("");
        Tkeluar.setText("");
        Jmlh.setText("");
        Jmlh.setText("");
        Jmlh.setText("");
        Jmlh.setText("");
        kd_b.enable(true);
//         ShowDatakeluar(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_masuk = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_keluar = new javax.swing.JTable();
        kd_b = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nb = new javax.swing.JTextField();
        Tmsuk = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Tkeluar = new javax.swing.JTextField();
        Jmlh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        DD = new javax.swing.JComboBox<>();
        BEditMasuk = new javax.swing.JButton();
        BClear = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Bmasuk = new javax.swing.JButton();
        BRefreshDataMasuk = new javax.swing.JButton();
        BHapus = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        BBarangKeluar = new javax.swing.JButton();
        BRefreshDataKeluar = new javax.swing.JButton();
        BHapus2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabel_masuk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel_masuk);

        tabel_keluar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabel_keluar);

        kd_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kd_bActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Kode Barang");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama Barang");

        Tmsuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TmsukActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tanggal Masuk");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tanggal Keluar");

        Tkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TkeluarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Jumlah");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Kondisi");

        DD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "baik", "rusak", "setengah harga" }));
        DD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DDActionPerformed(evt);
            }
        });

        BEditMasuk.setText("Edit Data Masuk");
        BEditMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditMasukActionPerformed(evt);
            }
        });

        BClear.setText("Clear");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Kode Barang");

        Bmasuk.setText("Barang Masuk");

        BRefreshDataMasuk.setText("Refresh Data Masuk");

        BHapus.setText("Hapus");
        BHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHapusActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Barang Keluar");

        BBarangKeluar.setText("Barang Keluar");
        BBarangKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBarangKeluarActionPerformed(evt);
            }
        });

        BRefreshDataKeluar.setText("Refresh Data Keluar");

        BHapus2.setText("Hapus");
        BHapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHapus2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(84, 84, 84)
                        .addComponent(kd_b, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nb, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tmsuk, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(Tkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BEditMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Jmlh)
                            .addComponent(DD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BClear, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(28, 28, 28)
                        .addComponent(Bmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BRefreshDataMasuk)
                        .addGap(18, 18, 18)
                        .addComponent(BHapus))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(28, 28, 28)
                        .addComponent(BBarangKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BRefreshDataKeluar)
                        .addGap(18, 18, 18)
                        .addComponent(BHapus2)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Bmasuk)
                    .addComponent(BRefreshDataMasuk)
                    .addComponent(BHapus))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kd_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tmsuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(BBarangKeluar)
                            .addComponent(BRefreshDataKeluar)
                            .addComponent(BHapus2))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Jmlh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(DD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addComponent(BEditMasuk)
                        .addGap(22, 22, 22)
                        .addComponent(BClear)))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BEditMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditMasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BEditMasukActionPerformed

    private void BHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BHapusActionPerformed

    private void BHapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHapus2ActionPerformed
        // TODO add your handling code here:
         ks = String.valueOf(kd_b.getText());
        try {
            sql = "DELETE FROM barang_keluar" 
                    + " where kd_barang ='"+ ks + "' ";
            st = con.createStatement();
            st.execute(sql);
            Clear();
//            ShowDatakeluar(null);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage());
        }
    }//GEN-LAST:event_BHapus2ActionPerformed

    private void BBarangKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBarangKeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BBarangKeluarActionPerformed

    private void DDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DDActionPerformed

    private void kd_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kd_bActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kd_bActionPerformed

    private void TmsukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TmsukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TmsukActionPerformed

    private void TkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TkeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TkeluarActionPerformed

  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PenyimpananBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenyimpananBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenyimpananBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenyimpananBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenyimpananBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBarangKeluar;
    private javax.swing.JButton BClear;
    private javax.swing.JButton BEditMasuk;
    private javax.swing.JButton BHapus;
    private javax.swing.JButton BHapus2;
    private javax.swing.JButton BRefreshDataKeluar;
    private javax.swing.JButton BRefreshDataMasuk;
    private javax.swing.JButton Bmasuk;
    private javax.swing.JComboBox<String> DD;
    private javax.swing.JTextField Jmlh;
    private javax.swing.JTextField Tkeluar;
    private javax.swing.JTextField Tmsuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kd_b;
    private javax.swing.JTextField nb;
    private javax.swing.JTable tabel_keluar;
    private javax.swing.JTable tabel_masuk;
    // End of variables declaration//GEN-END:variables
}
