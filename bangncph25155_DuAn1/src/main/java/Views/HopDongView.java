/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.HopDong;
import Models.ChuNha;
import Models.DichVu;
import Models.DichVuPhong;
import Models.NguoiThue;
import Models.Phong;
import Service.IsvDichVuImpl;
import Service.IsvDichVuPhongImpl;
import Service.IsvHopDongImpl;
import Service.IsvNhaTroImpl;
import Service.IsvPhongImpl;
import Service.IsvTienPhongImpl;
import Service.impl.DichVuImpl;
import Service.impl.DichVuPhongImpl;
import Service.impl.HopDongImpl;
import Service.impl.NhaTroImpl;
import Service.impl.PhongImpl;
import Service.impl.TienPhongImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author MSI
 */
public class HopDongView extends javax.swing.JFrame {
    private DefaultTableModel dtm;
    private IsvHopDongImpl hdR = new HopDongImpl();
    private IsvPhongImpl pR = new PhongImpl();
    private IsvNhaTroImpl ntR = new NhaTroImpl();
    private IsvTienPhongImpl tpR = new TienPhongImpl();
    private IsvDichVuImpl dvR = new DichVuImpl();
    private IsvDichVuPhongImpl dvpR = new DichVuPhongImpl();
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Creates new form HopDongView
     */
    private String tenphong;
    public HopDongView(String tenphong) {
        initComponents();
        this.tenphong = tenphong;
        txt_phonghopdong.setText(tenphong);
        LoadHopDong(hdR.getAllData());
        LoadDichVu(dvR.getAllData());
        LoadDichVuPhong(dvpR.getAllData());
        loc();
    }
    
    private void LoadHopDong(List<HopDong> list) {
        dtm = (DefaultTableModel) tb_banghopdong.getModel();
        dtm.setRowCount(0);
        for (HopDong hd : list) {
            dtm.addRow(new Object[]{
                hd.getChuNha().getHoTen(), hd.getNguoiThue().getHoTen(), hd.getPhong().getTenPhong(), hd.getGiaPhong(),hd.getNoiThatPhong(),
                hd.getHienTrang(), hd.getSoXe(), hd.getNoiDung(),hd.getNgayBatDau(), hd.getNgayHetHan(), hd.getNgaySua(),hd.getTrangThai(), hd.getMa()});
        }
    }
    
    private void LoadDichVu(List<DichVu> list) {
        dtm = (DefaultTableModel) tb_bangdichvu.getModel();
        dtm.setRowCount(0);
        for (DichVu dv : list) {
            dtm.addRow(new Object[]{
                dv.getTenDichVu(), dv.getDonGia()});
        }
    }
    
    private void LoadDichVuPhong(List<DichVuPhong> list) {
        dtm = (DefaultTableModel) tb_bangdichvuphong.getModel();
        dtm.setRowCount(0);
        for (DichVuPhong dvp : list) {
            dtm.addRow(new Object[]{
                dvp.getPhong().getTenPhong(), dvp.getDichVu().getTenDichVu(), dvp.getDonGia(), dvp.getNgayBatdau(), dvp.getNgayHetHan()});
        }
    }
    
    private void loc(){
        DefaultTableModel dmt = (DefaultTableModel) tb_banghopdong.getModel();
        DefaultTableModel dmt1 = (DefaultTableModel) tb_bangdichvuphong.getModel();
        String search = tenphong;
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        TableRowSorter<DefaultTableModel> tr1 = new TableRowSorter<DefaultTableModel>(dmt1);
        tb_banghopdong.setRowSorter(tr);
        tb_bangdichvuphong.setRowSorter(tr1);
        tr.setRowFilter(RowFilter.regexFilter(search));
        tr1.setRowFilter(RowFilter.regexFilter(search));
    }
    private HopDongView() {
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_chunhahopdong = new javax.swing.JTextField();
        txt_nguoithuehopdong = new javax.swing.JTextField();
        txt_phonghopdong = new javax.swing.JTextField();
        txt_ngaybatdauhopdong = new javax.swing.JTextField();
        txt_ngayhethanhopdong = new javax.swing.JTextField();
        txt_ngaysuahopdong = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txt_noidunghopdong = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txt_noithathopdong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_hientranghopdong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_giaphonghopdong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_soxehopdong = new javax.swing.JTextField();
        cb_trangthai = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        tb_banghopdong = new javax.swing.JTable();
        btn_themhopdong = new javax.swing.JButton();
        btn_suahopdong = new javax.swing.JButton();
        btn_clearhopdong = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_bangdichvu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_bangdichvuphong = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setText("Chu nha :");

        jLabel23.setText("Nguoi thue :");

        jLabel24.setText("Phong ;");

        jLabel25.setText("Ngay bat dau :");

        jLabel26.setText("Ngay het han :");

        jLabel27.setText("Ngay sua :");

        jLabel28.setText("Trang thai :");

        jLabel29.setText("Noi dung :");

        txt_phonghopdong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_phonghopdongKeyReleased(evt);
            }
        });

        txt_noidunghopdong.setColumns(20);
        txt_noidunghopdong.setRows(5);
        jScrollPane6.setViewportView(txt_noidunghopdong);

        jLabel1.setText("Noi that :");

        jLabel2.setText("Hien trang :");

        jLabel3.setText("Gia phong :");

        jLabel4.setText("So xe :");

        cb_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phòng trống", "Đã có người thuê" }));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_chunhahopdong, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(txt_nguoithuehopdong)
                    .addComponent(txt_phonghopdong)
                    .addComponent(txt_noithathopdong)
                    .addComponent(txt_hientranghopdong)
                    .addComponent(cb_trangthai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ngaybatdauhopdong)
                    .addComponent(txt_ngayhethanhopdong)
                    .addComponent(txt_ngaysuahopdong)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(txt_giaphonghopdong)
                    .addComponent(txt_soxehopdong))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25)
                    .addComponent(txt_chunhahopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaybatdauhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel26)
                    .addComponent(txt_nguoithuehopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngayhethanhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txt_phonghopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_giaphonghopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_noithathopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_soxehopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_hientranghopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txt_ngaysuahopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(cb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tb_banghopdong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Chu nha", "Nguoi thue", "Phong", "Gia phong", "Noi that phong", "Hien trang", "So xe", "Noi dung", "Ngay bat dau", "Ngay het han", "Ngay sua", "Trang thai"
            }
        ));
        tb_banghopdong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_banghopdongMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tb_banghopdong);

        btn_themhopdong.setText("Them");
        btn_themhopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themhopdongActionPerformed(evt);
            }
        });

        btn_suahopdong.setText("Sua");
        btn_suahopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suahopdongActionPerformed(evt);
            }
        });

        btn_clearhopdong.setText("Clear");
        btn_clearhopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearhopdongActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dich vu nha tro"));

        tb_bangdichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ten dich vu", "Don gia"
            }
        ));
        tb_bangdichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bangdichvuMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tb_bangdichvu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dich vu phong"));

        tb_bangdichvuphong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Phong", "Ten dich vu", "Don gia", "Ngay bat dau", "Ngay ket thuc"
            }
        ));
        jScrollPane1.setViewportView(tb_bangdichvuphong);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btn_themhopdong)
                        .addGap(164, 164, 164)
                        .addComponent(btn_suahopdong)
                        .addGap(146, 146, 146)
                        .addComponent(btn_clearhopdong))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_themhopdong)
                            .addComponent(btn_suahopdong)
                            .addComponent(btn_clearhopdong))
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themhopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themhopdongActionPerformed
        try {
            // TODO add your handling code here:
            HopDong hd = new HopDong();
            ChuNha cn = new ChuNha();
            NguoiThue nt = new NguoiThue();
            Phong p = new Phong();

            int index = tb_banghopdong.getRowCount() + 1;
            String ma = "HopDong" + String.valueOf(index);
            String tencn = txt_chunhahopdong.getText().trim();
            String tennt = txt_nguoithuehopdong.getText().trim();
            String tenp = txt_phonghopdong.getText().trim();
            int giaP = Integer.parseInt(txt_giaphonghopdong.getText().trim());
            String noithat = txt_noithathopdong.getText().trim();
            int soxe = Integer.parseInt(txt_soxehopdong.getText().trim());
            String hientrang = txt_hientranghopdong.getText().trim();
            Date ngaybatdau = sdf.parse(txt_ngaybatdauhopdong.getText().trim());
            Date ngayhethan = sdf.parse(txt_ngayhethanhopdong.getText().trim());
            Date ngaysua = java.util.Calendar.getInstance().getTime();
            String noidung = txt_noidunghopdong.getText().trim();
            String trangthai = cb_trangthai.getSelectedItem().toString();

            UUID idcn = ntR.findByIdCN(tencn);
            cn.setId(idcn);

            UUID idp = tpR.findByIdPhong(tenp);
            p.setId(idp);

            UUID idnt = pR.findByIdNT(tennt);
            nt.setId(idnt);

            hd.setMa(ma);
            hd.setNguoiThue(nt);
            hd.setChuNha(cn);
            hd.setPhong(p);
            hd.setGiaPhong(giaP);
            hd.setNoiThatPhong(noithat);
            hd.setSoXe(soxe);
            hd.setHienTrang(hientrang);
            hd.setNgayBatDau(ngaybatdau);
            hd.setNgayHetHan(ngayhethan);
            hd.setNgaySua(ngaysua);
            hd.setNoiDung(noidung);
            hd.setTrangThai(trangthai);
            hdR.save(hd);
            JOptionPane.showMessageDialog(this, "thanh cong");
            LoadHopDong(hdR.getAllData());
        } catch (ParseException ex) {
            Logger.getLogger(HopDongView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_themhopdongActionPerformed

    private void btn_suahopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suahopdongActionPerformed
        try {
            // TODO add your handling code here:
            int index = tb_banghopdong.getSelectedRow();
            HopDong hd = hdR.getAllData().get(index);
            ChuNha cn = new ChuNha();
            NguoiThue nt = new NguoiThue();
            Phong p = new Phong();

            String tencn = txt_chunhahopdong.getText().trim();
            String tennt = txt_nguoithuehopdong.getText().trim();
            String tenp = txt_phonghopdong.getText().trim();
            Date ngaybatdau = sdf.parse(txt_ngaybatdauhopdong.getText().trim());
            Date ngayhethan = sdf.parse(txt_ngayhethanhopdong.getText().trim());
            Date ngaysua = java.util.Calendar.getInstance().getTime();
            String noidung = txt_noidunghopdong.getText().trim();
            String trangthai = cb_trangthai.getSelectedItem().toString();

            UUID idcn = ntR.findByIdCN(tencn);
            cn.setId(idcn);

            UUID idp = tpR.findByIdPhong(tenp);
            p.setId(idp);

            UUID idnt = pR.findByIdNT(tennt);
            nt.setId(idnt);

            hd.setNguoiThue(nt);
            hd.setChuNha(cn);
            hd.setPhong(p);
            hd.setNgayBatDau(ngaybatdau);
            hd.setNgayHetHan(ngayhethan);
            hd.setNgaySua(ngaysua);
            hd.setNoiDung(noidung);
            hd.setTrangThai(trangthai);
            hdR.update(hd);
            JOptionPane.showMessageDialog(this, "thanh cong");
            LoadHopDong(hdR.getAllData());
        } catch (ParseException ex) {
            Logger.getLogger(HopDongView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_suahopdongActionPerformed

    private void btn_clearhopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearhopdongActionPerformed
        // TODO add your handling code here:
        txt_chunhahopdong.setText("");
        txt_nguoithuehopdong.setText("");
        txt_phonghopdong.setText("");
        txt_ngaybatdauhopdong.setText("");
        txt_ngayhethanhopdong.setText("");
        txt_ngaysuahopdong.setText("");
        txt_noidunghopdong.setText("");
        cb_trangthai.setSelectedItem(0);
    }//GEN-LAST:event_btn_clearhopdongActionPerformed

    private void tb_bangdichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangdichvuMouseClicked
        try {
            // TODO add your handling code here:
            int row = tb_bangdichvu.getSelectedRow();
            if (row == -1) {
                return;
            }
            
            Phong p = new Phong();
            DichVuPhong dvp = new DichVuPhong();
            DichVu dv = new DichVu();
            
            String tenphong = txt_phonghopdong.getText().trim();
            String tendichvu = tb_bangdichvu.getValueAt(row, 0).toString();
            int dongia = Integer.parseInt(tb_bangdichvu.getValueAt(row, 1).toString());
            Date ngaybatdau = sdf.parse(JOptionPane.showInputDialog("Ngay bat dau :"));
            Date ngayketthuc = sdf.parse(JOptionPane.showInputDialog("Ngay ket thuc :"));
            
            String ma = JOptionPane.showInputDialog("Ma dich vu phong de dang ki :");
            
            UUID idp = tpR.findByIdPhong(tenphong);
            p.setId(idp);
            
            UUID iddv = dvpR.findByIdDichVu(tendichvu);
            dv.setId(iddv);
            
            dvp.setPhong(p);
            dvp.setDichVu(dv);
            dvp.setDonGia(dongia);
            dvp.setNgayBatdau(ngaybatdau);
            dvp.setNgayHetHan(ngayketthuc);
            dvp.setMa(ma);
            dvpR.save(dvp);
            LoadDichVuPhong(dvpR.getAllData());
            
        } catch (ParseException ex) {
            Logger.getLogger(HopDongView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_tb_bangdichvuMouseClicked

    private void tb_banghopdongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_banghopdongMouseClicked
        // TODO add your handling code here:
        int index = tb_banghopdong.getSelectedRow();
        HopDong hd = hdR.getAllData().get(index);
        txt_chunhahopdong.setText(hd.getChuNha().getHoTen());
        txt_nguoithuehopdong.setText(hd.getNguoiThue().getHoTen());
        txt_phonghopdong.setText(hd.getPhong().getTenPhong());
        txt_giaphonghopdong.setText(String.valueOf(hd.getGiaPhong()));
        txt_noithathopdong.setText(hd.getNoiThatPhong());
        txt_hientranghopdong.setText(hd.getHienTrang());
        txt_soxehopdong.setText(String.valueOf(hd.getSoXe()));
        txt_noidunghopdong.setText(hd.getNoiDung());
        txt_ngaybatdauhopdong.setText(String.valueOf(hd.getNgayBatDau()));
        txt_ngayhethanhopdong.setText(String.valueOf(hd.getNgayHetHan()));
        txt_ngaysuahopdong.setText(String.valueOf(hd.getNgaySua()));
        cb_trangthai.setSelectedItem(hd.getTrangThai());
    }//GEN-LAST:event_tb_banghopdongMouseClicked

    private void txt_phonghopdongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_phonghopdongKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_phonghopdongKeyReleased

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
            java.util.logging.Logger.getLogger(HopDongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HopDongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HopDongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HopDongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HopDongView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clearhopdong;
    private javax.swing.JButton btn_suahopdong;
    private javax.swing.JButton btn_themhopdong;
    private javax.swing.JComboBox<String> cb_trangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tb_bangdichvu;
    private javax.swing.JTable tb_bangdichvuphong;
    private javax.swing.JTable tb_banghopdong;
    private javax.swing.JTextField txt_chunhahopdong;
    private javax.swing.JTextField txt_giaphonghopdong;
    private javax.swing.JTextField txt_hientranghopdong;
    private javax.swing.JTextField txt_ngaybatdauhopdong;
    private javax.swing.JTextField txt_ngayhethanhopdong;
    private javax.swing.JTextField txt_ngaysuahopdong;
    private javax.swing.JTextField txt_nguoithuehopdong;
    private javax.swing.JTextArea txt_noidunghopdong;
    private javax.swing.JTextField txt_noithathopdong;
    private javax.swing.JTextField txt_phonghopdong;
    private javax.swing.JTextField txt_soxehopdong;
    // End of variables declaration//GEN-END:variables
}
