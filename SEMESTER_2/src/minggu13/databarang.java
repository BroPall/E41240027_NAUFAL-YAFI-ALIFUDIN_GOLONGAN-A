package minggu13;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import minggu13.koneksi;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

public class databarang extends javax.swing.JFrame {

    private JLabel labelBarcode;

    public databarang() {
        initComponents();
        labelBarcode = new JLabel();
        labelBarcode.setBackground(Color.WHITE);
        labelBarcode.setOpaque(true);
        labelBarcode.setHorizontalAlignment(JLabel.CENTER);
        labelBarcode.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        jPanel2.remove(textfieldbarcode);
        jPanel2.add(labelBarcode);

        labelBarcode.setBounds(textfieldbarcode.getBounds());
        labelBarcode.setVisible(false);
        tampilDataBarang();
    }

    private void tampilDataBarang() {
        try {
            DefaultTableModel model = (DefaultTableModel) tabeldatabarang.getModel();
            model.setRowCount(0);

            Connection conn = koneksi.getConnection();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM inputdata");

            while (res.next()) {
                String kode = res.getString("kode_barang");
                String nama = res.getString("nama_barang");
                String stok = res.getString("stok");
                String hargabeli = res.getString("hargabeli");
                String hargajual = res.getString("hargajual");
                String catatan = res.getString("catatan");

                model.addRow(new Object[]{kode, nama, stok, hargabeli, hargajual, catatan});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Menampilkan Data: " + e.getMessage());
        }
    }

    private String generateKodeBarang() {
        StringBuilder kode = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int digit = (int) (Math.random() * 10);
            kode.append(digit);
        }
        return kode.toString();
    }

    private BufferedImage generateBarcodeWithText(String barcodeText) {
        Code128Bean barcodeGenerator = new Code128Bean();
        final int dpi = 160;

        barcodeGenerator.setModuleWidth(0.3);
        barcodeGenerator.doQuietZone(false);
        barcodeGenerator.setFontSize(0);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                    out, "image/png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

            // Generate barcode 
            barcodeGenerator.generateBarcode(canvas, barcodeText);
            canvas.finish();

            BufferedImage barcodeImage = canvas.getBufferedImage();

            // Buat gambar baru untuk menambahkan teks manual
            BufferedImage finalImage = new BufferedImage(
                    barcodeImage.getWidth(), barcodeImage.getHeight() + 20,
                    BufferedImage.TYPE_INT_RGB);

            Graphics2D g2d = finalImage.createGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, finalImage.getWidth(), finalImage.getHeight());

            // Gambar barcode
            g2d.drawImage(barcodeImage, 0, 0, null);

            // Tambahkan teks manual
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.PLAIN, 14));
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(barcodeText);
            int x = (finalImage.getWidth() - textWidth) / 2;
            int y = barcodeImage.getHeight() + 15;
            g2d.drawString(barcodeText, x, y);

            g2d.dispose();
            return finalImage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private void clearForm() {
    // Reset semua field ke default
    textfieldkodebarang.setText("");
    textfieldnamabarang.setText("");
    textfieldstok.setText("");
    textfieldhargabeli.setText("");
    textfieldhargajual.setText("");
    textfieldcatatan.setText("");
    
    // Sembunyikan dan hapus icon barcode
    labelBarcode.setIcon(null);
    labelBarcode.setVisible(false);
    labelBarcode.putClientProperty("barcodeText", null);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textfieldkodebarang = new javax.swing.JTextField();
        textfieldcatatan = new javax.swing.JTextField();
        textfieldbarcode = new javax.swing.JTextField();
        textfieldstok = new javax.swing.JTextField();
        textfieldnamabarang = new javax.swing.JTextField();
        buttonsave = new javax.swing.JButton();
        buttonedit = new javax.swing.JButton();
        buttonclear = new javax.swing.JButton();
        buttondelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeldatabarang = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        textfieldhargabeli = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textfieldhargajual = new javax.swing.JTextField();
        buttonnew = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(14, 36, 140));

        jPanel2.setBackground(new java.awt.Color(14, 36, 140));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Supplier");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kode Barang");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nama Barang");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Stok");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Catatan");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Barcode");

        textfieldkodebarang.setBackground(new java.awt.Color(204, 204, 204));
        textfieldkodebarang.setFocusable(false);
        textfieldkodebarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldkodebarangActionPerformed(evt);
            }
        });
        textfieldkodebarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textfieldkodebarangKeyPressed(evt);
            }
        });

        textfieldcatatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldcatatanActionPerformed(evt);
            }
        });

        textfieldbarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldbarcodeActionPerformed(evt);
            }
        });

        textfieldstok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldstokActionPerformed(evt);
            }
        });

        textfieldnamabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldnamabarangActionPerformed(evt);
            }
        });

        buttonsave.setText("SAVE");
        buttonsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonsaveActionPerformed(evt);
            }
        });

        buttonedit.setText("EDIT");
        buttonedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttoneditActionPerformed(evt);
            }
        });

        buttonclear.setText("CLEAR");

        buttondelete.setText("DELETE");
        buttondelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttondeleteActionPerformed(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tabeldatabarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Stock", "Harga Beli", "Harga Jual", "Catatan"
            }
        ));
        tabeldatabarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeldatabarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeldatabarang);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Harga Beli ");

        textfieldhargabeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldhargabeliActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Harga Jual");

        textfieldhargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldhargajualActionPerformed(evt);
            }
        });

        buttonnew.setText("NEW");
        buttonnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonnewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textfieldhargajual, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(buttonnew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonedit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonclear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttondelete))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textfieldhargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfieldkodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfieldnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfieldstok, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(44, 44, 44)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfieldbarcode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfieldcatatan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(304, 304, 304))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textfieldkodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfieldcatatan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textfieldnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfieldstok, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfieldhargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(textfieldbarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textfieldhargajual, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonsave)
                                .addComponent(buttonedit)
                                .addComponent(buttonclear)
                                .addComponent(buttondelete)
                                .addComponent(buttonnew))
                            .addComponent(jLabel12)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel9)
                        .addGap(108, 108, 108)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textfieldkodebarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldkodebarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldkodebarangActionPerformed

    private void textfieldkodebarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfieldkodebarangKeyPressed

    }//GEN-LAST:event_textfieldkodebarangKeyPressed

    private void textfieldbarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldbarcodeActionPerformed

    }//GEN-LAST:event_textfieldbarcodeActionPerformed

    private void textfieldstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldstokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldstokActionPerformed

    private void textfieldnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldnamabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldnamabarangActionPerformed

    private void buttonsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsaveActionPerformed
        try {
            // Ambil data dari field
            String kodeBarang = textfieldkodebarang.getText();
            String namaBarang = textfieldnamabarang.getText();
            String stok = textfieldstok.getText();
            String hargaBeli = textfieldhargabeli.getText();
            String hargaJual = textfieldhargajual.getText();
            String catatan = textfieldcatatan.getText();
            String barcode = textfieldbarcode.getText();

            // Validasi data
            if (kodeBarang.isEmpty() || namaBarang.isEmpty() || stok.isEmpty()
                    || hargaBeli.isEmpty() || hargaJual.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi kecuali catatan!");
                return;
            }

            // Cek apakah ada barcode yang sudah dibuat
            if (labelBarcode.getIcon() == null) {
                // Secara buatan, kita membuat error tentang barcode
                throw new SQLException("Field 'barcode' doesn't have a default value");
            }

            // Koneksi ke database
            Connection conn = koneksi.getConnection();

            // Cek apakah data sudah ada
            PreparedStatement pstCheck = conn.prepareStatement(
                    "SELECT * FROM inputdata WHERE kode_barang = ?");
            pstCheck.setString(1, kodeBarang);
            ResultSet rs = pstCheck.executeQuery();

            if (rs.next()) {
                // Jika data sudah ada, konfirmasi update
                int option = JOptionPane.showConfirmDialog(this,
                        "Data dengan kode " + kodeBarang + " sudah ada. Update data?",
                        "Konfirmasi", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    // Update data
                    PreparedStatement pstUpdate = conn.prepareStatement(
                            "UPDATE inputdata SET nama_barang=?, stok=?, hargabeli=?, hargajual=?, catatan=? "
                            + "WHERE kode_barang=?");
                    pstUpdate.setString(1, namaBarang);
                    pstUpdate.setString(2, stok);
                    pstUpdate.setString(3, hargaBeli);
                    pstUpdate.setString(4, hargaJual);
                    pstUpdate.setString(5, catatan);
                    pstUpdate.setString(6, kodeBarang);

                    pstUpdate.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Data berhasil diupdate!");
                }
            } else {
                // Jika data belum ada, insert data baru
                PreparedStatement pstInsert = conn.prepareStatement(
                        "INSERT INTO inputdata (kode_barang, nama_barang, stok, hargabeli, hargajual, catatan) "
                        + "VALUES (?, ?, ?, ?, ?, ?)");
                pstInsert.setString(1, kodeBarang);
                pstInsert.setString(2, namaBarang);
                pstInsert.setString(3, stok);
                pstInsert.setString(4, hargaBeli);
                pstInsert.setString(5, hargaJual);
                pstInsert.setString(6, catatan);

                pstInsert.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
            }

            // Refresh tabel
            tampilDataBarang();
            clearForm();

        } catch (SQLException e) {
            // Menampilkan pesan error spesifik tentang field barcode
            if (e.getMessage().contains("barcode")) {
                JOptionPane.showMessageDialog(this, "Error: java.sql.SQLException: Field 'barcode' doesn't have a default value",
                        "Database Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(),
                        "Database Error", JOptionPane.ERROR_MESSAGE);
            }
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_buttonsaveActionPerformed

    private void buttoneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttoneditActionPerformed

    }//GEN-LAST:event_buttoneditActionPerformed

    private void buttondeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttondeleteActionPerformed
    try {
        // Ambil kode barang yang sedang dipilih
        String kodeBarang = textfieldkodebarang.getText();
        
        // Validasi apakah ada data yang dipilih
        if (kodeBarang.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Tidak ada data yang dipilih untuk dihapus!", 
                "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Konfirmasi penghapusan
        int option = JOptionPane.showConfirmDialog(this,
                "Apakah Anda yakin ingin menghapus data dengan kode " + kodeBarang + "?",
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            // Koneksi ke database
            Connection conn = koneksi.getConnection();
            
            // Buat statement untuk hapus data
            PreparedStatement pstDelete = conn.prepareStatement(
                    "DELETE FROM inputdata WHERE kode_barang = ?");
            pstDelete.setString(1, kodeBarang);
            
            // Eksekusi query
            int rowsDeleted = pstDelete.executeUpdate();
            
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, 
                        "Data dengan kode " + kodeBarang + " berhasil dihapus!", 
                        "Informasi", JOptionPane.INFORMATION_MESSAGE);
     
                clearForm();
                
                // Refresh tabel
                tampilDataBarang();
            } else {
                JOptionPane.showMessageDialog(this, 
                        "Data tidak ditemukan di database!", 
                        "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, 
                "Error saat menghapus data: " + e.getMessage(), 
                "Database Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, 
                "Error: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_buttondeleteActionPerformed

    private void textfieldhargabeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldhargabeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldhargabeliActionPerformed

    private void textfieldhargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldhargajualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldhargajualActionPerformed

    private void textfieldcatatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldcatatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldcatatanActionPerformed

    private void buttonnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonnewActionPerformed
        // Generate kode barang otomatis
        String kodeOtomatis = generateKodeBarang();
        textfieldkodebarang.setText(kodeOtomatis);
        
         // Tampilkan label barcode jika masih tersembunyi
    if (!labelBarcode.isVisible()) {
        labelBarcode.setVisible(true);
    }
        try {
            // Generate barcode image
            BufferedImage barcodeImage = generateBarcodeWithText(kodeOtomatis);
            if (barcodeImage != null) {
                // Resize image agar sesuai dengan label
                int width = labelBarcode.getWidth();
                int height = labelBarcode.getHeight();
                if (width > 0 && height > 0) {
                    Image resizedImage = barcodeImage.getScaledInstance(width - 10, height - 10, Image.SCALE_SMOOTH);
                    ImageIcon barcodeIcon = new ImageIcon(resizedImage);

                    // Set icon ke label
                    labelBarcode.setIcon(barcodeIcon);

                    // Simpan kode barcode sebagai property dari label
                    labelBarcode.putClientProperty("barcodeText", kodeOtomatis);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal membuat barcode: " + e.getMessage());
        }

    }//GEN-LAST:event_buttonnewActionPerformed

    private void tabeldatabarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeldatabarangMouseClicked
        try {
            int row = tabeldatabarang.getSelectedRow();

            if (row >= 0) {
                // Ambil data dari tabel
                String kodeBarang = tabeldatabarang.getValueAt(row, 0).toString();
                String namaBarang = tabeldatabarang.getValueAt(row, 1).toString();
                String stok = tabeldatabarang.getValueAt(row, 2).toString();
                String hargaBeli = tabeldatabarang.getValueAt(row, 3).toString();
                String hargaJual = tabeldatabarang.getValueAt(row, 4).toString();
                String catatan = tabeldatabarang.getValueAt(row, 5).toString();

                textfieldkodebarang.setText(kodeBarang);
                textfieldnamabarang.setText(namaBarang);
                textfieldstok.setText(stok);
                textfieldhargabeli.setText(hargaBeli);
                textfieldhargajual.setText(hargaJual);
                textfieldcatatan.setText(catatan);

                // Tampilkan label barcode jika masih tersembunyi
                if (!labelBarcode.isVisible()) {
                    labelBarcode.setVisible(true);
                }

                // Generate dan tampilkan barcode berdasarkan kode barang
                BufferedImage barcodeImage = generateBarcodeWithText(kodeBarang);

                if (barcodeImage != null) {
                    int width = labelBarcode.getWidth();
                    int height = labelBarcode.getHeight();
                    if (width > 0 && height > 0) {
                        Image resizedImage = barcodeImage.getScaledInstance(width - 10, height - 10, Image.SCALE_SMOOTH);
                        ImageIcon barcodeIcon = new ImageIcon(resizedImage);

                        labelBarcode.setIcon(barcodeIcon);
                        labelBarcode.putClientProperty("barcodeText", kodeBarang);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saat memuat data: " + e.getMessage());
        }
    }//GEN-LAST:event_tabeldatabarangMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(databarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(databarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(databarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(databarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new databarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonclear;
    private javax.swing.JButton buttondelete;
    private javax.swing.JButton buttonedit;
    private javax.swing.JButton buttonnew;
    private javax.swing.JButton buttonsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabeldatabarang;
    private javax.swing.JTextField textfieldbarcode;
    private javax.swing.JTextField textfieldcatatan;
    private javax.swing.JTextField textfieldhargabeli;
    private javax.swing.JTextField textfieldhargajual;
    private javax.swing.JTextField textfieldkodebarang;
    private javax.swing.JTextField textfieldnamabarang;
    private javax.swing.JTextField textfieldstok;
    // End of variables declaration//GEN-END:variables
}
