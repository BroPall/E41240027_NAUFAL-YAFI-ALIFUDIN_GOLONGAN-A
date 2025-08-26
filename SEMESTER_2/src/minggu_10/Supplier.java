package minggu_10;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Supplier extends javax.swing.JFrame {

    private Connection con;
    private Statement st;
    private ResultSet RSsupplier;
    private String sql = "";

    private String ks, np, brg, almt, tlp, km;

    public Supplier() {
        initComponents();
        KoneksiDB();
    }

    private void KoneksiDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/penjualan", "root", "");
        } catch (Exception e) {
            System.out.println("Koneksi gagal /n" + e);
        }
    }

  private void ShowData(String km) {
    DefaultTableModel data = new DefaultTableModel();
    data.addColumn("No");
    data.addColumn("Kode Supplier");
    data.addColumn("Nama Perusahaan");
    data.addColumn("Barang di Jual");
    data.addColumn("No TLP");
    data.addColumn("Alamat");

    try {
        int i = 1;
        st = con.createStatement();

        if (km != null && !km.isEmpty()) {
            sql = "SELECT * FROM supplier"
                    + " WHERE kd_supplier LIKE '%" + km + "%'";
        } else {
            sql = "SELECT * FROM supplier";
        }

        RSsupplier = st.executeQuery(sql);
        while (RSsupplier.next()) {
            data.addRow(new Object[]{
                ("" + i++),
                RSsupplier.getString(1),
                RSsupplier.getString(2),
                RSsupplier.getString(3),
                RSsupplier.getString(4),
                RSsupplier.getString(5)
            });
        }
        tabelsupplier.setModel(data); 
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        System.out.println("Error: " + e.getMessage());
    }
}
    private void Clear() {
        jTextField1.setText("");
        textfieldnamabarang.setText("");
        textfieldstok.setText("");
        textfieldcatatan.setText("");
        textfieldbarcode.setText("");
        jTextField1.enable(true);
        ShowData(null);
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
        tabelsupplier = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        textfieldhargabeli = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textfieldhargajual = new javax.swing.JTextField();
        buttonnew = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        textfieldkodebarang1 = new javax.swing.JTextField();
        textfieldcatatan1 = new javax.swing.JTextField();
        textfieldbarcode1 = new javax.swing.JTextField();
        textfieldstok1 = new javax.swing.JTextField();
        textfieldnamabarang1 = new javax.swing.JTextField();
        buttonsave1 = new javax.swing.JButton();
        buttonedit1 = new javax.swing.JButton();
        buttonclear1 = new javax.swing.JButton();
        buttondelete1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelsupplier1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        textfieldhargabeli1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        textfieldhargajual1 = new javax.swing.JTextField();
        buttonnew1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        textfieldkodebarang2 = new javax.swing.JTextField();
        textfieldcatatan2 = new javax.swing.JTextField();
        textfieldbarcode2 = new javax.swing.JTextField();
        textfieldstok2 = new javax.swing.JTextField();
        textfieldnamabarang2 = new javax.swing.JTextField();
        buttonsave2 = new javax.swing.JButton();
        buttonedit2 = new javax.swing.JButton();
        buttonclear2 = new javax.swing.JButton();
        buttondelete2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelsupplier2 = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        textfieldhargabeli2 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        textfieldhargajual2 = new javax.swing.JTextField();
        buttonnew2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(14, 36, 140));

        jPanel1.setBackground(new java.awt.Color(14, 36, 140));

        jPanel2.setBackground(new java.awt.Color(14, 36, 140));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Input Data Barang ");
        jLabel1.setToolTipText("");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kode Barang");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nama Barang");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Stock");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Catatan");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Barcode");

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

        tabelsupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Barang", "Nama Barang", "Stok", "Harga Beli", "Harga Jual", "Catatan"
            }
        ));
        jScrollPane1.setViewportView(tabelsupplier);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Harga Beli");

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
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textfieldhargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(411, 411, 411))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textfieldhargajual, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonnew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonsave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonedit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(buttonclear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttondelete))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfieldkodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfieldnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfieldstok, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textfieldcatatan, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textfieldbarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(292, 292, 292))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textfieldkodebarang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(textfieldcatatan, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textfieldnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfieldstok, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(textfieldbarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textfieldhargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textfieldhargajual, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonsave)
                        .addComponent(buttonedit)
                        .addComponent(buttonclear)
                        .addComponent(buttondelete)
                        .addComponent(buttonnew))
                    .addComponent(jLabel12))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(14, 36, 140));

        jPanel4.setBackground(new java.awt.Color(14, 36, 140));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Input Data Barang ");
        jLabel3.setToolTipText("");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kode Barang");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nama Barang");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Stock");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Catatan");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Barcode");

        textfieldkodebarang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldkodebarang1ActionPerformed(evt);
            }
        });
        textfieldkodebarang1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textfieldkodebarang1KeyPressed(evt);
            }
        });

        textfieldcatatan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldcatatan1ActionPerformed(evt);
            }
        });

        textfieldbarcode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldbarcode1ActionPerformed(evt);
            }
        });

        textfieldstok1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldstok1ActionPerformed(evt);
            }
        });

        textfieldnamabarang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldnamabarang1ActionPerformed(evt);
            }
        });

        buttonsave1.setText("SAVE");
        buttonsave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonsave1ActionPerformed(evt);
            }
        });

        buttonedit1.setText("EDIT");
        buttonedit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonedit1ActionPerformed(evt);
            }
        });

        buttonclear1.setText("CLEAR");

        buttondelete1.setText("DELETE");
        buttondelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttondelete1ActionPerformed(evt);
            }
        });

        tabelsupplier1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Barang", "Nama Barang", "Stok", "Harga Beli", "Harga Jual", "Catatan"
            }
        ));
        jScrollPane2.setViewportView(tabelsupplier1);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Harga Beli");

        textfieldhargabeli1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldhargabeli1ActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Harga Jual");

        textfieldhargajual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldhargajual1ActionPerformed(evt);
            }
        });

        buttonnew1.setText("NEW");
        buttonnew1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonnew1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(textfieldhargabeli1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(411, 411, 411))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(textfieldhargajual1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonnew1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonsave1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonedit1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonclear1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttondelete1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfieldkodebarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfieldnamabarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfieldstok1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textfieldcatatan1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textfieldbarcode1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(292, 292, 292))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textfieldkodebarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(textfieldcatatan1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(textfieldnamabarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfieldstok1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addComponent(textfieldbarcode1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textfieldhargabeli1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textfieldhargajual1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonsave1)
                        .addComponent(buttonedit1)
                        .addComponent(buttonclear1)
                        .addComponent(buttondelete1)
                        .addComponent(buttonnew1))
                    .addComponent(jLabel18))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(14, 36, 140));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Input Data Barang ");
        jLabel5.setToolTipText("");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kode Barang");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Nama Barang");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Stock");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Catatan");

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Barcode");

        textfieldkodebarang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldkodebarang2ActionPerformed(evt);
            }
        });
        textfieldkodebarang2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textfieldkodebarang2KeyPressed(evt);
            }
        });

        textfieldcatatan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldcatatan2ActionPerformed(evt);
            }
        });

        textfieldbarcode2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldbarcode2ActionPerformed(evt);
            }
        });

        textfieldstok2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldstok2ActionPerformed(evt);
            }
        });

        textfieldnamabarang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldnamabarang2ActionPerformed(evt);
            }
        });

        buttonsave2.setText("SAVE");
        buttonsave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonsave2ActionPerformed(evt);
            }
        });

        buttonedit2.setText("EDIT");
        buttonedit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonedit2ActionPerformed(evt);
            }
        });

        buttonclear2.setText("CLEAR");

        buttondelete2.setText("DELETE");
        buttondelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttondelete2ActionPerformed(evt);
            }
        });

        tabelsupplier2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode Barang", "Nama Barang", "Stok", "Harga Beli", "Harga Jual", "Catatan"
            }
        ));
        jScrollPane3.setViewportView(tabelsupplier2);

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Harga Beli");

        textfieldhargabeli2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldhargabeli2ActionPerformed(evt);
            }
        });

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Harga Jual");

        textfieldhargajual2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldhargajual2ActionPerformed(evt);
            }
        });

        buttonnew2.setText("NEW");
        buttonnew2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonnew2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(textfieldhargabeli2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(411, 411, 411))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(textfieldhargajual2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonnew2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonsave2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonedit2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonclear2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttondelete2))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textfieldkodebarang2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfieldnamabarang2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textfieldstok2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textfieldcatatan2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textfieldbarcode2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(292, 292, 292))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textfieldkodebarang2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(textfieldcatatan2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(textfieldnamabarang2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textfieldstok2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addComponent(textfieldbarcode2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textfieldhargabeli2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textfieldhargajual2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonsave2)
                        .addComponent(buttonedit2)
                        .addComponent(buttonclear2)
                        .addComponent(buttondelete2)
                        .addComponent(buttonnew2))
                    .addComponent(jLabel24))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textfieldcatatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldcatatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldcatatanActionPerformed

    private void textfieldbarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldbarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldbarcodeActionPerformed

    private void buttoneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttoneditActionPerformed
    //Edit Data
    
    ks = String.valueOf(jTextField1.getText());
    np = String.valueOf(textfieldnamabarang.getText());
    brg = String.valueOf(textfieldstok.getText());
    tlp = String.valueOf(textfieldcatatan.getText());
    almt = String.valueOf(textfieldbarcode.getText());

    try {
         sql = "update supplier set nama_toko ='" + np + "',barang_dijual='"+ brg + "',no_tlp='" + tlp + "',alamat_supplier='" + almt + "' where kd_supplier = '" + ks +"'";
         st = con.createStatement();
         st.execute(sql);
         Clear();
         ShowData(null);
         JOptionPane.showMessageDialog(null, "Data Berhasil Di Edit");
    }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage());
    }
    }//GEN-LAST:event_buttoneditActionPerformed

    private void buttonsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsaveActionPerformed
        // TODO add your handling code here:
        ks = String.valueOf(jTextField1.getText());
        np = String.valueOf(textfieldnamabarang.getText());
        brg = String.valueOf(textfieldstok.getText());
        tlp = String.valueOf(textfieldcatatan.getText());
        almt = String.valueOf(textfieldbarcode.getText());

        try {
            sql = "INSERT INTO supplier (kd_supplier, nama_toko, barang_dijual, no_tlp, alamat_supplier)value"
                    +"('" + ks + "','" + np + "','" + brg + "','" + tlp + "','" + almt + "')";
            st = con.createStatement();
            st.execute(sql);
            Clear();
            ShowData(null);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage());
        }
    }//GEN-LAST:event_buttonsaveActionPerformed

    private void buttondeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttondeleteActionPerformed
        ks = String.valueOf(jTextField1.getText());
        try {
            sql = "DELETE FROM supplier" 
                    + " where kd_supplier ='"+ ks + "' ";
            st = con.createStatement();
            st.execute(sql);
            Clear();
            ShowData(null);
            JOptionPane.showMessageDialog(null, "Data Berhasil DI Hapus");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR \n" + e.getMessage());
        }
    }//GEN-LAST:event_buttondeleteActionPerformed

    private void buttonnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonnewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonnewActionPerformed

    private void textfieldkodebarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldkodebarang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldkodebarang1ActionPerformed

    private void textfieldkodebarang1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfieldkodebarang1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldkodebarang1KeyPressed

    private void textfieldcatatan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldcatatan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldcatatan1ActionPerformed

    private void textfieldbarcode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldbarcode1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldbarcode1ActionPerformed

    private void textfieldstok1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldstok1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldstok1ActionPerformed

    private void textfieldnamabarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldnamabarang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldnamabarang1ActionPerformed

    private void buttonsave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonsave1ActionPerformed

    private void buttonedit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonedit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonedit1ActionPerformed

    private void buttondelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttondelete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttondelete1ActionPerformed

    private void textfieldhargabeli1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldhargabeli1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldhargabeli1ActionPerformed

    private void textfieldhargajual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldhargajual1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldhargajual1ActionPerformed

    private void buttonnew1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonnew1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonnew1ActionPerformed

    private void textfieldkodebarang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldkodebarang2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldkodebarang2ActionPerformed

    private void textfieldkodebarang2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfieldkodebarang2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldkodebarang2KeyPressed

    private void textfieldcatatan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldcatatan2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldcatatan2ActionPerformed

    private void textfieldbarcode2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldbarcode2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldbarcode2ActionPerformed

    private void textfieldstok2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldstok2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldstok2ActionPerformed

    private void textfieldnamabarang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldnamabarang2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldnamabarang2ActionPerformed

    private void buttonsave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsave2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonsave2ActionPerformed

    private void buttonedit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonedit2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonedit2ActionPerformed

    private void buttondelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttondelete2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttondelete2ActionPerformed

    private void textfieldhargabeli2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldhargabeli2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldhargabeli2ActionPerformed

    private void textfieldhargajual2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldhargajual2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldhargajual2ActionPerformed

    private void buttonnew2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonnew2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonnew2ActionPerformed

    private void textfieldhargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldhargajualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldhargajualActionPerformed

    private void textfieldhargabeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldhargabeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldhargabeliActionPerformed

    private void textfieldstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldstokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldstokActionPerformed

    private void textfieldnamabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldnamabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldnamabarangActionPerformed

    private void textfieldkodebarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfieldkodebarangKeyPressed
        ks = textfieldkodebarang.getText();
        int tekanenter = evt.getKeyCode();
        if (tekanenter == 10){
            try {
                sql = " SELECT * FROM supplier "
                + "where kd_supplier='" + ks + "'";
                st = con.createStatement();
                RSsupplier = st.executeQuery(sql);
                while (RSsupplier.next()) {
                    textfieldnamabarang.setText(RSsupplier.getString("nama_toko"));
                    textfieldstok.setText(RSsupplier.getString(3));
                    textfieldcatatan.setText(RSsupplier.getString(4));
                    textfieldbarcode.setText(RSsupplier.getString(5));
                    JOptionPane.showMessageDialog (null,"Data Ditemukan");
                }
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR \n Data tidak ada / tidak ditemukan" + e.getMessage());
            }
        }
    }//GEN-LAST:event_textfieldkodebarangKeyPressed

    private void textfieldkodebarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldkodebarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldkodebarangActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonclear;
    private javax.swing.JButton buttonclear1;
    private javax.swing.JButton buttonclear2;
    private javax.swing.JButton buttondelete;
    private javax.swing.JButton buttondelete1;
    private javax.swing.JButton buttondelete2;
    private javax.swing.JButton buttonedit;
    private javax.swing.JButton buttonedit1;
    private javax.swing.JButton buttonedit2;
    private javax.swing.JButton buttonnew;
    private javax.swing.JButton buttonnew1;
    private javax.swing.JButton buttonnew2;
    private javax.swing.JButton buttonsave;
    private javax.swing.JButton buttonsave1;
    private javax.swing.JButton buttonsave2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelsupplier;
    private javax.swing.JTable tabelsupplier1;
    private javax.swing.JTable tabelsupplier2;
    private javax.swing.JTextField textfieldbarcode;
    private javax.swing.JTextField textfieldbarcode1;
    private javax.swing.JTextField textfieldbarcode2;
    private javax.swing.JTextField textfieldcatatan;
    private javax.swing.JTextField textfieldcatatan1;
    private javax.swing.JTextField textfieldcatatan2;
    private javax.swing.JTextField textfieldhargabeli;
    private javax.swing.JTextField textfieldhargabeli1;
    private javax.swing.JTextField textfieldhargabeli2;
    private javax.swing.JTextField textfieldhargajual;
    private javax.swing.JTextField textfieldhargajual1;
    private javax.swing.JTextField textfieldhargajual2;
    private javax.swing.JTextField textfieldkodebarang;
    private javax.swing.JTextField textfieldkodebarang1;
    private javax.swing.JTextField textfieldkodebarang2;
    private javax.swing.JTextField textfieldnamabarang;
    private javax.swing.JTextField textfieldnamabarang1;
    private javax.swing.JTextField textfieldnamabarang2;
    private javax.swing.JTextField textfieldstok;
    private javax.swing.JTextField textfieldstok1;
    private javax.swing.JTextField textfieldstok2;
    // End of variables declaration//GEN-END:variables
}
