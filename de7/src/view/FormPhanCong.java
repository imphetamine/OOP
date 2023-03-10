/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controller.IOFile;
import controller.TrongException;
import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.PhanCong;
import javax.swing.*;
import model.DuAn;
import model.NhanVien;
/**
 *
 * @author ADMIN
 */
public class FormPhanCong extends javax.swing.JPanel {

    DefaultTableModel d;
    private boolean them, sua;
    String file = "src/controller/PHANCONG.dat";
    String file1 = "src/controller/DA.dat";
    String file2 = "src/controller/NV.dat";
    List <PhanCong> list = new ArrayList<>();
    List <DuAn> list1 = new ArrayList<>();
    List <NhanVien> list2 = new ArrayList<>();
    public FormPhanCong() {
        initComponents();
        them = false;
        sua = false;
        String [] cols = {"Ma NV", "Ho ten", "Ma du an", "So ngay", 
        "Vi tri cong viec"};
        d = new DefaultTableModel(cols, 0);
        jTable1.setModel(d);
        loadData();
        loadMa();
        buttonState(true);
    }
    
    public void buttonState(boolean b)
    {
        btThem.setEnabled(b);
//        btSua.setEnabled(b);
        btCapNhat.setEnabled(!b);
        btBoQua.setEnabled(!b);
    }

    public void loadMa()
    {
        list1 = IOFile.doc(file1);
        list2 = IOFile.doc(file2);
        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        for(DuAn i : list1)
        {
            jComboBox1.addItem(i.getId() + "");
        }
        for(NhanVien i : list2)
        {
            jComboBox2.addItem(i.getId() + "");
        }
    }
    public void loadData()
    {
        File f = new File(file);
        if(f.exists())
            list = IOFile.doc(file);
        else
            IOFile.viet(file, list);
        d.setRowCount(0);
        for(PhanCong i : list)
        {
            d.addRow(i.toObjects());
        }
    }
    
    public DuAn getDuAn(int ma)
    {
        list1 = IOFile.doc(file1);
        for(DuAn i : list1)
        {
            if(i.getId() == ma)
                return i;
        }
        return null;
    }
    public NhanVien getNhanVien(int ma)
    {
        list1 = IOFile.doc(file2);
        for(NhanVien i : list2)
        {
            if(i.getId() == ma)
                return i;
        }
        return null;
    }
    
    public boolean ktTrung(int maDA, int maNV)
    {
        list1 = IOFile.doc(file1);
        list2 = IOFile.doc(file2);
        list = IOFile.doc(file);
        for(PhanCong i : list)
        {
            if(i.getD().getId() == maDA && i.getN().getId() == maNV)
                return false;
        }
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        btSapXep = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btThem = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btCapNhat = new javax.swing.JButton();
        btDoc = new javax.swing.JButton();
        btGhi = new javax.swing.JButton();
        btBoQua = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Ma du an: ");

        jLabel2.setText("Ma nhan vien: ");

        jLabel3.setText("So ngay: ");

        jLabel4.setText("Vi tri: ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField5.setText("jTextField5");

        jTextField6.setText("jTextField6");

        jButton1.setText("Lam moi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo ho ten", "Theo so ngay tham gia(giam)" }));

        btSapXep.setText("Sap xep");
        btSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSapXepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jButton1))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btSapXep)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btSapXep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        btThem.setText("Them");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btXoa.setText("Xoa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btCapNhat.setText("Cap nhat");
        btCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapNhatActionPerformed(evt);
            }
        });

        btDoc.setText("Doc file");
        btDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDocActionPerformed(evt);
            }
        });

        btGhi.setText("Ghi file");
        btGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGhiActionPerformed(evt);
            }
        });

        btBoQua.setText("Bo qua");
        btBoQua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBoQuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btThem)
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btXoa)
                    .addComponent(btCapNhat))
                .addGap(111, 111, 111)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btDoc)
                        .addGap(107, 107, 107)
                        .addComponent(btBoQua))
                    .addComponent(btGhi))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem)
                    .addComponent(btXoa)
                    .addComponent(btDoc)
                    .addComponent(btBoQua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCapNhat)
                    .addComponent(btGhi))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        them = true;
        buttonState(false);
        jComboBox1.requestFocus();
        if(sua)
            sua = false;
    }//GEN-LAST:event_btThemActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        int row = jTable1.getSelectedRow();
        if(row < 0 || row > jTable1.getRowCount() - 1)
        {
            JOptionPane.showMessageDialog(this, "Chon dong trong bang!");
        }
        else
        {
            d.removeRow(row);
            list.remove(row);
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void btDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDocActionPerformed
        list = IOFile.doc(file);
        d.setRowCount(0);
        for(PhanCong i : list)
        {
            d.addRow(i.toObjects());
        }
    }//GEN-LAST:event_btDocActionPerformed

    private void btGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGhiActionPerformed
        IOFile.viet(file, list);
    }//GEN-LAST:event_btGhiActionPerformed

    private void btBoQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBoQuaActionPerformed
       them = false;
       sua = false;
        buttonState(true);
    }//GEN-LAST:event_btBoQuaActionPerformed

    private void btCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapNhatActionPerformed
        int maDuAn = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        int maNV = Integer.parseInt(jComboBox2.getSelectedItem().toString());
        if(them)
        {
            them = false;
            if(ktTrung(maDuAn, maNV))
            {
                try {
                    int ngay = Integer.parseInt(jTextField5.getText());
                    String vt = jTextField6.getText();
                    if(vt.isEmpty())
                        throw new TrongException();
                    PhanCong temp = new PhanCong(getDuAn(maDuAn), getNhanVien(maNV), 
                            ngay, vt);
                    list.add(temp);
                    d.addRow(temp.toObjects());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Nhap vao so!");
                    jTextField5.requestFocus();
                } catch (TrongException ex) {
                    JOptionPane.showMessageDialog(this, "Khong de trong!");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Trung du lieu!");
            }
        }
        
        if(sua)
        {
            int row = jTable1.getSelectedRow();
            sua = false;
            if(ktTrung(maDuAn, maNV))
            {
                    try {
                   int ngay = Integer.parseInt(jTextField5.getText());
                   String vt = jTextField6.getText();
                   if(vt.isEmpty())
                       throw new TrongException();
                   PhanCong temp = new PhanCong(getDuAn(maDuAn), getNhanVien(maNV), 
                           ngay, vt);
                   list.set(row, temp);
                   d.setValueAt(maNV, row, 0);
                   d.setValueAt(getNhanVien(maNV).getTen(), row, 1);
                   d.setValueAt(maDuAn, row, 2);
                   d.setValueAt(ngay, row, 3);
                   d.setValueAt(vt, row, 4);
               } catch (NumberFormatException e) {
                   JOptionPane.showMessageDialog(this, "Nhap vao so!");
                   jTextField5.requestFocus();
               } catch (TrongException ex) {
                   JOptionPane.showMessageDialog(this, "Khong de trong!");
               }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Trung du lieu!");
            }
        }
        buttonState(true);
    }//GEN-LAST:event_btCapNhatActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        jComboBox1.setSelectedItem(d.getValueAt(row, 2));
        jComboBox2.setSelectedItem(d.getValueAt(row, 0));
        jTextField5.setText(d.getValueAt(row, 3).toString());
        jTextField6.setText(d.getValueAt(row, 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loadMa();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSapXepActionPerformed
        if(jComboBox3.getSelectedIndex() == 0)
        {
            sortHoTen();
        }
        else
        {
            sortNgay();
        }
        d.setRowCount(0);
        for(PhanCong i : list)
        {
            d.addRow(i.toObjects());
        }
    }//GEN-LAST:event_btSapXepActionPerformed

    public void sortHoTen()
    {
        Collections.sort(list, new Comparator<PhanCong>(){
            @Override
            public int compare(PhanCong o1, PhanCong o2) {
                String t1 = o1.getN().getTen();
                String t2 = o2.getN().getTen();
                String ten1 = t1.substring(t1.lastIndexOf(" ") + 1) + t1;
                String ten2 = t2.substring(t2.lastIndexOf(" ") + 1) + t2;
                return ten1.compareToIgnoreCase(ten2);
            }
        });
        IOFile.viet(file, list);
    }
    public void sortNgay()
    {
        Collections.sort(list, new Comparator<PhanCong>(){
            @Override
            public int compare(PhanCong o1, PhanCong o2) {
                return o2.getNgay() - o1.getNgay();
            }
        });
        IOFile.viet(file, list);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBoQua;
    private javax.swing.JButton btCapNhat;
    private javax.swing.JButton btDoc;
    private javax.swing.JButton btGhi;
    private javax.swing.JButton btSapXep;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
