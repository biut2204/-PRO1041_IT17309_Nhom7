/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.ChiTietTienPhong;
import Models.ChuNha;
import Models.DichVuPhong;
import Models.HopDong;
import Models.NguoiThue;
import Models.Phong;
import Models.SuCoKH;
import Models.TaiKhoan;
import Models.TienPhong;
import Repo.PhongRepo;
import Repo.TraPhongRepo;
import Service.IsvCttpImpl;
import Service.IsvDichVuPhongImpl;
import Service.IsvHopDongImpl;
import Service.IsvNguoiThueImpl;
import Service.IsvNhaTroImpl;
import Service.IsvPhongImpl;
import Service.IsvSuCoKH;
import Service.IsvTaiKhoanImpl;
import Service.IsvTienPhongImpl;
import Service.impl.CttpImpl;
import Service.impl.DichVuPhongImpl;
import Service.impl.HopDongImpl;
import Service.impl.NguoiThueImpl;
import Service.impl.NhaTroImpl;
import Service.impl.PhongImpl;
import Service.impl.SuCoKHImpl;
import Service.impl.TaiKhoanImpl;
import Service.impl.TienPhongImpl;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author MSI
 */
public class NguoiThueView extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private IsvNguoiThueImpl ntR = new NguoiThueImpl();
    private IsvNhaTroImpl nR = new NhaTroImpl();
    private IsvTienPhongImpl tpR = new TienPhongImpl();
    private IsvCttpImpl cttpR = new CttpImpl();
    private IsvDichVuPhongImpl dvpR = new DichVuPhongImpl();
    private IsvPhongImpl pR = new PhongImpl();
    private IsvSuCoKH sckhR = new SuCoKHImpl();
    private IsvTaiKhoanImpl tkR = new TaiKhoanImpl();
    private TraPhongRepo traphongR = new TraPhongRepo();
    private PhongRepo test = new PhongRepo();
    private IsvNhaTroImpl nhatroR = new NhaTroImpl();
    private IsvHopDongImpl hdR = new HopDongImpl();

    /**
     * Creates new form NguoiThue
     */
    private String dataNguoiThue;

    public NguoiThueView(String dataNguoiThue) throws ParseException {
        initComponents();
        this.dataNguoiThue = dataNguoiThue;
        HienThi();
        LoadChiTietTienPhong(cttpR.getAllData());
        LoadDichVuPhong(dvpR.getAllData());
        shotDichVu(tpR.findTenPhong(dataNguoiThue));
        shotCttp(tpR.findTenPhong(dataNguoiThue));

        LoadSuCoKH(sckhR.getAllData());
        shotSuCoKH(tpR.findTenPhong(dataNguoiThue));
        txtPhongSCKH.setText(tpR.findTenPhong(dataNguoiThue));
    }

    private NguoiThueView() {

    }

    private void shotDichVu(String ten) {
        DefaultTableModel dmt = (DefaultTableModel) tb_bangdichvuphong.getModel();
        String search = ten;
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_bangdichvuphong.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }

    private void shotCttp(String ten) {
        DefaultTableModel dmt = (DefaultTableModel) tb_chitiettienphong.getModel();
        String search = ten;
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_chitiettienphong.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }

    private void shotSuCoKH(String ten) {
        DefaultTableModel dmt = (DefaultTableModel) tb_SuCoKH.getModel();
        String search = ten;
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_SuCoKH.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }

    private void LoadChiTietTienPhong(List<ChiTietTienPhong> list) {
        dtm = (DefaultTableModel) tb_chitiettienphong.getModel();
        dtm.setRowCount(0);
        for (ChiTietTienPhong cttp : list) {
            dtm.addRow(new Object[]{
                cttp.getTienPhong().getPhong().getTenPhong(), cttp.getTienPhong().getNgayTao(), cttp.getBangKeDien(), cttp.getDonGiaDien(),
                cttp.getBangKeNuoc(), cttp.getDonGiaNuoc(), cttp.getDichVu(), cttp.getThoiGianBatDau(), cttp.getThoiGianKetThuc(),
                cttp.getDonGia(), cttp.getHinhAnhDien(), cttp.getHinhAnhNuoc(), cttp.getTienPhong().getHinhThucThanhToan(),
                cttp.getTienPhong().getNgayThanhToan(), cttp.getTienPhong().getTrangThai(), cttp.getTienPhong().getMa()});
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

    private void LoadSuCoKH(List<SuCoKH> list) {
        dtm = (DefaultTableModel) tb_SuCoKH.getModel();
        dtm.setRowCount(0);
        for (SuCoKH sckh : list) {
            dtm.addRow(new Object[]{
                sckh.getMa(), sckh.getTenSuCo(), sckh.getThoiGianThongBao(), sckh.getMoTa(), sckh.getTrangThai(), sckh.getPhong().getTenPhong()});
        }
    }

    private void HienThi() {
        String ten = ntR.findHoTen(dataNguoiThue);
        Date ngaysinh = ntR.findNgaySinh(dataNguoiThue);
        String gioitinh = ntR.findGioiTinh(dataNguoiThue);
        String sdt = ntR.findSdt(dataNguoiThue);
        String diachi = ntR.findDiaChi(dataNguoiThue);
        String dixe = ntR.findDiXe(dataNguoiThue);
        String trangthai = ntR.findTrangThai(dataNguoiThue);

        txt_ma.setText(dataNguoiThue);
        txt_hoten.setText(ten);
        txt_ngaysinh.setText(sdf.format(ngaysinh));
        txt_gioitinh.setText(gioitinh);
        txt_sdt.setText(sdt);
        txt_diachi.setText(diachi);
        txt_dixe.setText(dixe);
        txt_trangthai.setText(trangthai);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_hoten = new javax.swing.JTextField();
        txt_ngaysinh = new javax.swing.JTextField();
        txt_gioitinh = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        txt_diachi = new javax.swing.JTextField();
        txt_dixe = new javax.swing.JTextField();
        txt_trangthai = new javax.swing.JTextField();
        btn_traphong = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtPhongSCKH = new javax.swing.JTextField();
        txtTenSuCoKH = new javax.swing.JTextField();
        txtMaSCKH = new javax.swing.JTextField();
        txtTimeSuCo = new javax.swing.JTextField();
        txtMoTaSuCo = new javax.swing.JTextField();
        txtTrangThaiSuCo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_SuCoKH = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_bangdichvuphong = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_chitiettienphong = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_tenphong = new javax.swing.JTextField();
        txt_ngaytao = new javax.swing.JTextField();
        txt_sodien = new javax.swing.JTextField();
        txt_sonuoc = new javax.swing.JTextField();
        txt_dichvu = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_thoigianbatdau = new javax.swing.JTextField();
        txt_thoigianketthuc = new javax.swing.JTextField();
        txt_dongiadien = new javax.swing.JTextField();
        txt_dongianuoc = new javax.swing.JTextField();
        txt_tongtien = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_hinhthucthanhtoan = new javax.swing.JTextField();
        txt_ngaythanhtoan = new javax.swing.JTextField();
        btn_thanhtoan = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        lbl_anhsodien = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbl_anhsonuoc = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_matienphong = new javax.swing.JTextField();
        txt_timkiem = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        txtMkCu = new javax.swing.JPasswordField();
        txtMkMoi = new javax.swing.JPasswordField();
        txtNhapLaiMK = new javax.swing.JPasswordField();
        btnLuuMK = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Ma :");

        jLabel3.setText("Ho ten :");

        jLabel4.setText("Ngay sinh :");

        jLabel5.setText("Gioi tinh :");

        jLabel6.setText("Sdt :");

        jLabel7.setText("Dia chi :");

        jLabel8.setText("Di xe :");

        jLabel9.setText("Trang thai :");

        txt_ngaysinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngaysinhActionPerformed(evt);
            }
        });

        txt_diachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_diachiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ma, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(txt_hoten)
                    .addComponent(txt_ngaysinh)
                    .addComponent(txt_diachi))
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dixe, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_dixe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        btn_traphong.setText("Trả phòng");
        btn_traphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_traphongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(343, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_traphong, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(531, 531, 531))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(btn_traphong, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );

        jTabbedPane5.addTab("Thong tin", jPanel1);

        jLabel22.setText("Mã");

        jLabel23.setText("Phòng");

        jLabel25.setText("Tên sự cố");

        jLabel26.setText("Thời gian thông báo");

        jLabel27.setText("Mô tả");

        jLabel28.setText("Trạng thái");

        jButton1.setText("Thong bao");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sua");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tb_SuCoKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên sự cố", "Thời gian thông báo", "Mô tả", "Trạng thái", "Phòng"
            }
        ));
        tb_SuCoKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SuCoKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_SuCoKH);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSuCoKH, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhongSCKH, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSCKH, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTrangThaiSuCo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtMoTaSuCo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtTimeSuCo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(43, 43, 43)
                                    .addComponent(jButton1))))))
                .addContainerGap(556, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel26)
                    .addComponent(txtMaSCKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimeSuCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel27)
                    .addComponent(txtPhongSCKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMoTaSuCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtTrangThaiSuCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txtTenSuCoKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Su co phong", jPanel2);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Dich vu phong"));

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
        tb_bangdichvuphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bangdichvuphongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_bangdichvuphong);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tb_chitiettienphong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Phong", "Ngay tao", "So dien", "Don gia dien", "So nuoc", "Don gia nuoc", "Tien dich vu", "Thoi gian bat dau", "Thoi gian ket thuc", "Tong tien", "Anh so dien", "Anh so nuoc", "Hinh thuc thanh toan", "Ngay thanh toan", "Trang thai", "Ma tien phong"
            }
        ));
        tb_chitiettienphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_chitiettienphongMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tb_chitiettienphong);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Phong :");

        jLabel10.setText("Ngay tao :");

        jLabel11.setText("So dien :");

        jLabel12.setText("So nuoc :");

        jLabel13.setText("Dich vu :");

        jLabel14.setText("Thoi gian bat dau :");

        jLabel15.setText("Thoi gian ket thuc :");

        jLabel16.setText("Don gia dien :");

        jLabel17.setText("Don gia nuoc :");

        jLabel18.setText("Tong tien :");

        jLabel19.setText("Hinh thuc thanh toan :");

        jLabel20.setText("Ngay thanh toan :");

        btn_thanhtoan.setText("Thanh toan");
        btn_thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhtoanActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Anh so dien"));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhsodien, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lbl_anhsodien, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Anh so nuoc"));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhsonuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(lbl_anhsonuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel21.setText("Ma tien phong :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_tenphong)
                    .addComponent(txt_ngaytao)
                    .addComponent(txt_sodien)
                    .addComponent(txt_sonuoc)
                    .addComponent(txt_dichvu)
                    .addComponent(txt_matienphong, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_thoigianbatdau)
                    .addComponent(txt_thoigianketthuc)
                    .addComponent(txt_dongiadien)
                    .addComponent(txt_dongianuoc)
                    .addComponent(txt_tongtien, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_hinhthucthanhtoan)
                            .addComponent(txt_ngaythanhtoan, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_thanhtoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_tenphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txt_thoigianbatdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(txt_hinhthucthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txt_thoigianketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(txt_ngaythanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_thanhtoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_sodien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txt_dongiadien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_sonuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txt_dongianuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_dichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txt_matienphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timkiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jTabbedPane5.addTab("Tien phong", jPanel3);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setText("Đổi mật khẩu");

        jLabel30.setText("Tài khoản");

        jLabel31.setText("Mật khẩu cũ");

        jLabel32.setText("Mật khẩu mới ");

        jLabel33.setText("Nhập lại mật khẩu");

        txtMkCu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMkCuActionPerformed(evt);
            }
        });

        btnLuuMK.setText("Lưu thay đổi");
        btnLuuMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuMKActionPerformed(evt);
            }
        });

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tên TK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTable);

        jButton3.setText("Clear");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTaiKhoan)
                            .addComponent(txtMkCu)
                            .addComponent(txtNhapLaiMK, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(txtMkMoi)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel24))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnLuuMK)
                        .addGap(90, 90, 90)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel24)
                .addGap(34, 34, 34)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMkCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(28, 28, 28)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMkMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNhapLaiMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(41, 41, 41)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuuMK)
                    .addComponent(jButton3))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(657, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Doi mat khau", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ngaysinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngaysinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngaysinhActionPerformed

    private void txt_diachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_diachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_diachiActionPerformed

    private void tb_bangdichvuphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangdichvuphongMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_bangdichvuphongMouseClicked

    private TienPhong getTienPhong() throws ParseException {
        Phong p = new Phong();
        String ma = txt_matienphong.getText().toString();
        String tenp = txt_tenphong.getText().toString();
        String hinhthucthanhtoan = txt_hinhthucthanhtoan.getText().trim();
        Date ngaythanhtoan = java.util.Calendar.getInstance().getTime();
        Date ngaytao = sdf.parse(txt_ngaytao.getText().toString());
        String trangthai = "Da thanh toan";
        String ghichu = "";
        UUID id = tpR.findByIdTienPhong(ma);

        UUID idp = tpR.findByIdPhong(tenp);
        p.setId(idp);

        TienPhong tienPhong = new TienPhong(id, p, ma, hinhthucthanhtoan, ngaytao, ngaythanhtoan, trangthai, ghichu);
        return tienPhong;

    }

    private void btn_thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhtoanActionPerformed
        try {
            // TODO add your handling code here:
            TienPhong tp = getTienPhong();

            String ma = txt_matienphong.getText().toString();
            tp.setId(tpR.findByIdTienPhong(ma));

            tpR.update(tp);
            JOptionPane.showMessageDialog(this, "thanh cong");
            LoadChiTietTienPhong(cttpR.getAllData());
        } catch (ParseException ex) {
            Logger.getLogger(NguoiThueView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_thanhtoanActionPerformed

    public void fillSinhVienLenForm(ChiTietTienPhong sv) {
        ImageIcon imgIcon = new ImageIcon("E:/GitHub/PRO1041_IT17309_NHom8/Da1_Nhom7/src/main/java/images/" + sv.getHinhAnhDien());
        Image img = imgIcon.getImage();
        lbl_anhsodien.setIcon(new ImageIcon(img.getScaledInstance(lbl_anhsodien.getWidth(), lbl_anhsodien.getHeight(), 0)));
    }

    public void fillSinhVienLenForm1(ChiTietTienPhong sv) {
        ImageIcon imgIcon1 = new ImageIcon("E:/GitHub/PRO1041_IT17309_NHom8/Da1_Nhom7/src/main/java/images/" + sv.getHinhAnhNuoc());
        Image img1 = imgIcon1.getImage();
        lbl_anhsonuoc.setIcon(new ImageIcon(img1.getScaledInstance(lbl_anhsonuoc.getWidth(), lbl_anhsonuoc.getHeight(), 0)));
    }

    public ChiTietTienPhong show(String maSV) {
        for (ChiTietTienPhong sv : cttpR.getAllData()) {
            if (sv.getTienPhong().getMa().equalsIgnoreCase(maSV)) {
                return sv;
            }
        }
        return null;
    }

    private void tb_chitiettienphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_chitiettienphongMouseClicked
        // TODO add your handling code here:
        int row = tb_chitiettienphong.getSelectedRow();
        if (row == -1) {
            return;
        }
        txt_tenphong.setText(tb_chitiettienphong.getValueAt(row, 0).toString());
        txt_ngaytao.setText(tb_chitiettienphong.getValueAt(row, 1).toString());
        txt_sodien.setText(tb_chitiettienphong.getValueAt(row, 2).toString());
        txt_dongiadien.setText(tb_chitiettienphong.getValueAt(row, 3).toString());
        txt_sonuoc.setText(tb_chitiettienphong.getValueAt(row, 4).toString());
        txt_dongianuoc.setText(tb_chitiettienphong.getValueAt(row, 5).toString());
        txt_dichvu.setText(tb_chitiettienphong.getValueAt(row, 6).toString());
        txt_thoigianbatdau.setText(tb_chitiettienphong.getValueAt(row, 7).toString());
        txt_thoigianketthuc.setText(tb_chitiettienphong.getValueAt(row, 8).toString());
        txt_tongtien.setText(tb_chitiettienphong.getValueAt(row, 9).toString());
        txt_matienphong.setText(tb_chitiettienphong.getValueAt(row, 15).toString());
        int id = tb_chitiettienphong.rowAtPoint(evt.getPoint());
        String masv = tb_chitiettienphong.getValueAt(id, 15).toString();
        ChiTietTienPhong sv = show(masv);
        fillSinhVienLenForm(sv);
        fillSinhVienLenForm1(sv);
        txt_trangthai.setText(tb_chitiettienphong.getValueAt(row, 14).toString());
        txt_hinhthucthanhtoan.setText(tb_chitiettienphong.getValueAt(row, 12).toString());
        txt_ngaythanhtoan.setText(tb_chitiettienphong.getValueAt(row, 13).toString());


    }//GEN-LAST:event_tb_chitiettienphongMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            SuCoKH sckh = new SuCoKH();
            Phong p = new Phong();
            ChuNha cn = new ChuNha();

            String ma = "SCKH " + ntR.findSo();

            String tenphong = txtPhongSCKH.getText().trim();
            Date ngay = sdf.parse(txtTimeSuCo.getText().trim());
            String mota = txtMoTaSuCo.getText().trim();
            String tensuco = txtTenSuCoKH.getText().trim();
            String trangthai = "đang sửa";
            String tenchunha = "admin";

            UUID idphong = sckhR.findByIdPhong(tenphong);
            p.setId(idphong);

            UUID idchunha = nR.findByIdCN(tenchunha);
            cn.setId(idchunha);

            sckh.setMa(ma);
            sckh.setPhong(p);
            sckh.setChuNha(cn);
            sckh.setTenSuCo(tensuco);
            sckh.setThoiGianThongBao(ngay);
            sckh.setMoTa(mota);
            sckh.setTrangThai(trangthai);
            sckh.setChuNha(cn);
            sckh.setMa(ma);
            sckhR.save(sckh);
            JOptionPane.showMessageDialog(this, "thanh cong");
            LoadSuCoKH(sckhR.getAllData());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int index = tb_SuCoKH.getSelectedRow();
        SuCoKH sckh = sckhR.getAllData().get(index);
        String trangthai = "sửa xong";
        sckh.setTrangThai(trangthai);
        sckhR.update(sckh);
        JOptionPane.showMessageDialog(this, "thanh cong");
        LoadSuCoKH(sckhR.getAllData());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tb_SuCoKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SuCoKHMouseClicked

    }//GEN-LAST:event_tb_SuCoKHMouseClicked

    private void txt_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyReleased
        // TODO add your handling code here:
        DefaultTableModel dmt = (DefaultTableModel) tb_chitiettienphong.getModel();
        String search = txt_timkiem.getText().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_chitiettienphong.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txt_timkiemKeyReleased

    private void txtMkCuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMkCuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMkCuActionPerformed

    private void btnLuuMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuMKActionPerformed
        if (txtTaiKhoan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tài khoản!");
            return;
        }
        if (txtMkCu.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu cũ!");
            return;
        }
        if (txtMkMoi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mật khẩu mới!");
            return;
        }
        if (txtNhapLaiMK.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập lại mật khẩu mới !");
        }

        NguoiThue nt = new NguoiThue();
        TaiKhoan tk = new TaiKhoan();
        String tk1 = txtTaiKhoan.getText().trim();
        String mkcu = txtMkCu.getText().trim();
        String mkmoi1 = txtMkMoi.getText().trim();
        String mkmoi2 = txtNhapLaiMK.getText().trim();
        boolean ktra = mkmoi1.equals(mkmoi2);
        String mk = ntR.findMK(dataNguoiThue);
        UUID nguoithueid = ntR.findidNguoiThue(txt_ma.getText());
        String vaitro = ntR.findVaiTro(txt_ma.getText());
        String tentk = ntR.findTenTK(txt_ma.getText());
        UUID id = ntR.findidTK(txt_ma.getText());
        UUID idNT = ntR.findidNguoiThue(txt_ma.getText());
        if (mkcu == mk) {
            JOptionPane.showMessageDialog(this, "mat khau sai");
        } else if (ktra == false) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không trùng nhau");
        } else {
            nt.setId(idNT);
            tk.setVaiTro(vaitro);
            tk.setTenTaiKhoan(tentk);
            tk.setId(id);
            tk.setMatKhau(mkmoi2);
            tk.setNguoiThue(nt);
            tkR.update(tk);

            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
        }
    }//GEN-LAST:event_btnLuuMKActionPerformed

    private void tblTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableMouseClicked
        int index = tblTable.getSelectedRow();
        TaiKhoan sp = tkR.getAllData().get(index);
        txtTaiKhoan.setText(sp.getTenTaiKhoan());
    }//GEN-LAST:event_tblTableMouseClicked

    private HopDong getHopDong() throws ParseException {

        ChuNha cn = new ChuNha();
        NguoiThue nt = new NguoiThue();
        Phong p = new Phong();

        UUID idhd = traphongR.findIdHopDong(dataNguoiThue);
        String ma = traphongR.findMaHopDong(dataNguoiThue);
        String tencn = "admin";
        UUID idnt = traphongR.findNguoiThue(dataNguoiThue);
        UUID idp = traphongR.findPhong(dataNguoiThue);
        int giaphong = traphongR.findGiaPhong(dataNguoiThue);
        String noithat = traphongR.findNoiThat(dataNguoiThue);
        int soxe = traphongR.findSoXe(dataNguoiThue);
        String hientrang = traphongR.findHienTrangThue(dataNguoiThue);
        String anhhientrang = traphongR.findAnhHienTrangThue(dataNguoiThue);
        String hientrangtra = "";
        String anhhientrangtra = "";
        Date ngaybatdau = traphongR.findNgayBatDau(dataNguoiThue);
        Date ngayhethan = traphongR.findNgayHetHan(dataNguoiThue);
        String noidung = traphongR.findNoiDung(dataNguoiThue);
        String trangthai = "Dang xu li";
        int tiencoc = traphongR.findTienCoc(dataNguoiThue);
        Date ngaysua = java.util.Calendar.getInstance().getTime();

        UUID idcn = nhatroR.findByIdCN(tencn);
        cn.setId(idcn);

        nt.setId(idnt);
        p.setId(idp);

        HopDong hd = new HopDong(idhd, cn, p, nt, ma, giaphong, tiencoc, noithat, hientrang, anhhientrang, hientrangtra, anhhientrangtra, soxe, noidung, ngaybatdau, ngayhethan, ngaysua, trangthai);

        return hd;

    }

    private void btn_traphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_traphongActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Ban muon thong bao chu nha tra phong ?");

            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            HopDong hd = getHopDong();

            UUID idhd = traphongR.findIdHopDong(dataNguoiThue);
            hd.setId(idhd);
            hdR.update(hd);
            JOptionPane.showMessageDialog(this, "thanh cong");
        } catch (ParseException ex) {
            Logger.getLogger(QLNhaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_traphongActionPerformed

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
            java.util.logging.Logger.getLogger(NguoiThueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NguoiThueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NguoiThueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NguoiThueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NguoiThueView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuuMK;
    private javax.swing.JButton btn_thanhtoan;
    private javax.swing.JButton btn_traphong;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JLabel lbl_anhsodien;
    private javax.swing.JLabel lbl_anhsonuoc;
    private javax.swing.JTable tb_SuCoKH;
    private javax.swing.JTable tb_bangdichvuphong;
    private javax.swing.JTable tb_chitiettienphong;
    private javax.swing.JTable tblTable;
    private javax.swing.JTextField txtMaSCKH;
    private javax.swing.JPasswordField txtMkCu;
    private javax.swing.JPasswordField txtMkMoi;
    private javax.swing.JTextField txtMoTaSuCo;
    private javax.swing.JPasswordField txtNhapLaiMK;
    private javax.swing.JTextField txtPhongSCKH;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtTenSuCoKH;
    private javax.swing.JTextField txtTimeSuCo;
    private javax.swing.JTextField txtTrangThaiSuCo;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_dichvu;
    private javax.swing.JTextField txt_dixe;
    private javax.swing.JTextField txt_dongiadien;
    private javax.swing.JTextField txt_dongianuoc;
    private javax.swing.JTextField txt_gioitinh;
    private javax.swing.JTextField txt_hinhthucthanhtoan;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_matienphong;
    private javax.swing.JTextField txt_ngaysinh;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_ngaythanhtoan;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_sodien;
    private javax.swing.JTextField txt_sonuoc;
    private javax.swing.JTextField txt_tenphong;
    private javax.swing.JTextField txt_thoigianbatdau;
    private javax.swing.JTextField txt_thoigianketthuc;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JTextField txt_tongtien;
    private javax.swing.JTextField txt_trangthai;
    // End of variables declaration//GEN-END:variables
}
