/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.SuCoKH;
import Models.ChuNha;
import Models.DichVu;
import Models.DichVuPhong;
import Models.HopDong;
import Models.NguoiThue;
import Models.NhaTro;
import Models.Phong;
import Models.SuCoNhaTro;
import Repo.PhongRepo;
import Repo.TraPhongRepo;
import Service.IsvDichVuImpl;
import Service.IsvDichVuPhongImpl;
import Service.IsvHopDongImpl;
import Service.IsvNhaTroImpl;
import Service.IsvPhongImpl;
import Service.IsvSuCoKH;
import Service.IsvSuCoNhaTroImpl;
import Service.IsvTienPhongImpl;

import Service.impl.DichVuImpl;
import Service.impl.DichVuPhongImpl;
import Service.impl.HopDongImpl;
import Service.impl.NhaTroImpl;
import Service.impl.PhongImpl;
import Service.impl.SuCoNhaTroImpl;
import Service.impl.TienPhongImpl;
import Service.impl.SuCoKHImpl;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author MSI
 */
public class QLNhaView extends javax.swing.JFrame {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DefaultTableModel dtm;
    private IsvNhaTroImpl ntR = new NhaTroImpl();
    private IsvPhongImpl pR = new PhongImpl();
    private IsvSuCoNhaTroImpl scntR = new SuCoNhaTroImpl();
    private IsvDichVuImpl dvR = new DichVuImpl();
    private IsvHopDongImpl hdR = new HopDongImpl();
    private IsvTienPhongImpl tpR = new TienPhongImpl();
    private IsvDichVuPhongImpl dvpR = new DichVuPhongImpl();
    private IsvSuCoKH sckhR = new SuCoKHImpl();
    private PhongRepo test = new PhongRepo();
    private SuCoKH sckh;
    private TraPhongRepo traphongR = new TraPhongRepo();

    /**
     * Creates new form QLNhaView
     */
    public QLNhaView() {
        initComponents();
        LoadPhong(pR.getAllData());
        LoadHopDong(hdR.getAllData());
        LoadDichVu(dvR.getAllData());
        LoadDichVuPhong(dvpR.getAllData());
        LoadSuCoNhaTro(scntR.getAllData());
        LoadSuCoKH(sckhR.getAllData());
        Icon();
        LoadTraPhong(hdR.getAllData());
        LoadDaTraPhong(hdR.getAllData());
        shotDangxuli();
        shotDaTraPhong();
    }

    private void Icon() {
        Icon icon = new ImageIcon("timkiem.png");
        this.btn_timkiemphong.setIcon(icon);
        Icon icon1 = new ImageIcon("new.png");
        this.btn_themphong.setIcon(icon1);
        Icon icon2 = new ImageIcon("save_1.png");
        this.btn_suaphong.setIcon(icon2);
        Icon icon3 = new ImageIcon("delete.png");
        this.btn_clearphong.setIcon(icon3);
        Icon icon4 = new ImageIcon("update2.png");
        this.btn_lamhopdong.setIcon(icon4);
        Icon icon5 = new ImageIcon("new.png");
        this.btn_themdichvu.setIcon(icon5);
        Icon icon6 = new ImageIcon("save_1.png");
        this.btn_updatedichvu.setIcon(icon6);
        Icon icon7 = new ImageIcon("delete.png");
        this.btn_cleardichvu.setIcon(icon7);
        Icon icon8 = new ImageIcon("thongbao.png");
        this.btn_thongbao.setIcon(icon8);
        Icon icon9 = new ImageIcon("suachuaxong.png");
        this.btn_suachuaxong.setIcon(icon8);
        Icon icon10 = new ImageIcon("clear1.png");
        this.btn_clearsuco.setIcon(icon10);
        this.btnSua.setIcon(icon4);
        this.btnClear.setIcon(icon3);
        this.btn_timkiem.setIcon(icon);
        this.btn_clearhopdong.setIcon(icon3);
        Icon icon11 = new ImageIcon("obama.png");
        this.lbl_anhphong.setIcon(icon11);
    }

    private void LoadPhong(List<Phong> list) {
        dtm = (DefaultTableModel) tb_bangphong.getModel();
        dtm.setRowCount(0);
        for (Phong phong : list) {
            dtm.addRow(new Object[]{
                phong.getTenPhong(), phong.getDienTich(), phong.getTinhTrang(), phong.getAnhPhong(), phong.getMa(), phong.getNhaTro().getTenNha()});
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

    private void LoadSuCoNhaTro(List<SuCoNhaTro> list) {
        dtm = (DefaultTableModel) tb_bangsuconhatro.getModel();
        dtm.setRowCount(0);
        for (SuCoNhaTro scnt : list) {
            dtm.addRow(new Object[]{
                scnt.getTenSuCo(), scnt.getThoiGianThongBao(), scnt.getMoTa(), scnt.getChiPhiSuaChua(), scnt.getTrangThai(),
                scnt.getNhaTro().getTenNha(), scnt.getChuNha().getHoTen(), scnt.getMa()});
        }
    }

    private void LoadHopDong(List<HopDong> list) {
        dtm = (DefaultTableModel) tb_banghopdong.getModel();
        dtm.setRowCount(0);
        for (HopDong hd : list) {
            dtm.addRow(new Object[]{
                hd.getChuNha().getHoTen(), hd.getNguoiThue().getHoTen(), hd.getPhong().getTenPhong(), hd.getGiaPhong(), hd.getNoiThatPhong(),
                hd.getHienTrang(), hd.getSoXe(), hd.getNoiDung(), hd.getNgayBatDau(), hd.getNgayHetHan(), hd.getNgaySua(), hd.getTrangThai(), hd.getNguoiThue().getCmtnd()});
        }
    }

    private void LoadTraPhong(List<HopDong> list) {
        dtm = (DefaultTableModel) tb_dangxuli.getModel();
        dtm.setRowCount(0);
        for (HopDong hd : list) {
            dtm.addRow(new Object[]{
                hd.getPhong().getTenPhong(), hd.getNguoiThue().getHoTen(), hd.getNguoiThue().getCmtnd(), hd.getGiaPhong(), hd.getTienCoc(), hd.getNgayBatDau(),
                hd.getNgayHetHan(), hd.getNoiThatPhong(), hd.getHienTrang(), hd.getHienTrangTraPhong(), hd.getSoXe(), hd.getNgaySua(), hd.getTrangThai()});
        }
    }

    private void LoadDaTraPhong(List<HopDong> list) {
        dtm = (DefaultTableModel) tb_datraphong.getModel();
        dtm.setRowCount(0);
        for (HopDong hd : list) {
            dtm.addRow(new Object[]{
                hd.getPhong().getTenPhong(), hd.getNguoiThue().getHoTen(), hd.getNguoiThue().getCmtnd(), hd.getGiaPhong(), hd.getTienCoc(), hd.getNgayBatDau(),
                hd.getNgayHetHan(), hd.getNoiThatPhong(), hd.getHienTrang(), hd.getHienTrangTraPhong(), hd.getSoXe(), hd.getNgaySua(), hd.getTrangThai()});
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
                sckh.getMa(), sckh.getPhong().getTenPhong(), sckh.getTenSuCo(), sckh.getThoiGianThongBao(), sckh.getMoTa(), sckh.getChiPhiSuaChua(), sckh.getTrangThai()});
        }
    }

    private void shotDangxuli() {
        DefaultTableModel dmt = (DefaultTableModel) tb_dangxuli.getModel();
        String search = "Dang xu li";
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_dangxuli.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }

    private void shotDaTraPhong() {
        DefaultTableModel dmt = (DefaultTableModel) tb_datraphong.getModel();
        String search = "Da tra phong";
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_datraphong.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        pa_trangchu = new javax.swing.JTabbedPane();
        Hello = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pa_phong = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_bangphong = new javax.swing.JTable();
        cb_loaiphong = new javax.swing.JComboBox<>();
        btn_timkiemphong = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tenphong = new javax.swing.JTextField();
        txt_dientich = new javax.swing.JTextField();
        cb_tinhtrang = new javax.swing.JComboBox<>();
        btn_themphong = new javax.swing.JButton();
        btn_suaphong = new javax.swing.JButton();
        btn_clearphong = new javax.swing.JButton();
        lbl_anhphong = new javax.swing.JLabel();
        btn_lamhopdong = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_min = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_max = new javax.swing.JTextField();
        pa_dichvu = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_tendichvu = new javax.swing.JTextField();
        txt_dongiadichvu = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_bangdichvu = new javax.swing.JTable();
        btn_themdichvu = new javax.swing.JButton();
        btn_updatedichvu = new javax.swing.JButton();
        btn_cleardichvu = new javax.swing.JButton();
        pa_suconhatro = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_tensuco = new javax.swing.JTextField();
        txt_motasuco = new javax.swing.JTextField();
        txt_thoigianthongbao = new javax.swing.JTextField();
        txt_trangthaisuco = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_chiphisuachuanhatro = new javax.swing.JTextField();
        btn_thongbao = new javax.swing.JButton();
        btn_suachuaxong = new javax.swing.JButton();
        btn_clearsuco = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb_bangsuconhatro = new javax.swing.JTable();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtMaSCKH = new javax.swing.JTextField();
        txtTrangThaiSCKH = new javax.swing.JTextField();
        txtMoTaSC = new javax.swing.JTextField();
        txtThoiGianThongBaoSC = new javax.swing.JTextField();
        txtPhongSCKH = new javax.swing.JTextField();
        txtTenSuCo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_chiphisuaphong = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_SuCoKH = new javax.swing.JTable();
        txt_timkiemsckh = new javax.swing.JTextField();
        btn_timkiemsckh = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
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
        jLabel5 = new javax.swing.JLabel();
        txt_noithathopdong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_hientranghopdong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_giaphonghopdong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_soxehopdong = new javax.swing.JTextField();
        cb_trangthai = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txt_tiencoc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_chungminhthu = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tb_banghopdong = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_bangdichvuphong = new javax.swing.JTable();
        btn_clearhopdong = new javax.swing.JButton();
        txt_timkiem = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        lbl_anhhientrangthue = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txt_traphong_tenphong = new javax.swing.JTextField();
        txt_traphong_nguoithue = new javax.swing.JTextField();
        txt_traphong_cmt = new javax.swing.JTextField();
        txt_traphong_giaphong = new javax.swing.JTextField();
        txt_traphong_tiencoc = new javax.swing.JTextField();
        txt_traphong_soxe = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txt_traphong_batdau = new javax.swing.JTextField();
        txt_traphong_ketthuc = new javax.swing.JTextField();
        txt_traphong_noithat = new javax.swing.JTextField();
        txt_traphong_hientrangthue = new javax.swing.JTextField();
        txt_traphong_hientrangtra = new javax.swing.JTextField();
        txt_traphong_ngaytra = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        lbl_anhlucthue = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        lbl_anhluctra = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel27 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tb_dangxuli = new javax.swing.JTable();
        txt_timkiemdangxuli = new javax.swing.JTextField();
        btn_timkiemdangxuli = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tb_datraphong = new javax.swing.JTable();
        cb_TKthang = new javax.swing.JComboBox<>();
        cb_TKnam = new javax.swing.JComboBox<>();
        btn_thongketheothang = new javax.swing.JButton();
        btn_thongketheonam = new javax.swing.JButton();
        btn_suahopdong1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pa_trangchu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pa_trangchu.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Hello");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(472, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 311, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Hello.addTab("Trang chu", jPanel2);

        pa_trangchu.addTab("Trang chu", Hello);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tb_bangphong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ten phong", "Dien tich", "Tinh trang", "Anh phong"
            }
        ));
        tb_bangphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bangphongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_bangphong);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cb_loaiphong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Phòng trống", "Đã có người thuê", " " }));

        btn_timkiemphong.setText("Tim kiem");
        btn_timkiemphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemphongActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Ten phong :");

        jLabel2.setText("Tinh trang :");

        jLabel3.setText("Dien tich :");

        cb_tinhtrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phòng trống", "Đã có người thuê" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_tenphong)
                    .addComponent(cb_tinhtrang, 0, 166, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_dientich, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txt_tenphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dientich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_tinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        btn_themphong.setText("Them");
        btn_themphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themphongActionPerformed(evt);
            }
        });

        btn_suaphong.setText("Sua");
        btn_suaphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaphongActionPerformed(evt);
            }
        });

        btn_clearphong.setText("Clear");

        lbl_anhphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhphongMouseClicked(evt);
            }
        });

        btn_lamhopdong.setText("Lam hop dong");
        btn_lamhopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lamhopdongActionPerformed(evt);
            }
        });

        jLabel9.setText("Min :");

        txt_min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_minActionPerformed(evt);
            }
        });

        jLabel10.setText("Max :");

        txt_max.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(cb_loaiphong, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_min, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_max)
                            .addGap(18, 18, 18)
                            .addComponent(btn_timkiemphong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27))
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_themphong, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btn_suaphong, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btn_clearphong, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_lamhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(lbl_anhphong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_loaiphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiemphong)
                    .addComponent(jLabel9)
                    .addComponent(txt_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_themphong)
                            .addComponent(btn_suaphong)
                            .addComponent(btn_clearphong)
                            .addComponent(btn_lamhopdong)))
                    .addComponent(lbl_anhphong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pa_phong.addTab("Phòng", jPanel4);

        pa_trangchu.addTab("Phòng", pa_phong);

        jPanel9.setBackground(new java.awt.Color(51, 255, 255));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setText("Ten dich vu :");

        jLabel21.setText("Don gia :");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_tendichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_dongiadichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(txt_tendichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dongiadichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

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

        btn_themdichvu.setText("Them");
        btn_themdichvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themdichvuActionPerformed(evt);
            }
        });

        btn_updatedichvu.setText("Update");

        btn_cleardichvu.setText("Clear");
        btn_cleardichvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cleardichvuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btn_themdichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(btn_updatedichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btn_cleardichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(513, 513, 513))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themdichvu)
                    .addComponent(btn_cleardichvu)
                    .addComponent(btn_updatedichvu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pa_dichvu.addTab("Dich vu", jPanel5);

        pa_trangchu.addTab("Dich Vu", pa_dichvu);

        jPanel6.setBackground(new java.awt.Color(102, 255, 204));

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setText("Ten su co :");

        jLabel17.setText("Thoi gian thong bao :");

        jLabel18.setText("Mo ta :");

        jLabel19.setText("Trang thai :");

        jLabel13.setText("Chi phi sua :");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tensuco)
                    .addComponent(txt_motasuco, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(txt_chiphisuachuanhatro))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_trangthaisuco))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_thoigianthongbao, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(txt_tensuco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_thoigianthongbao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(txt_motasuco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_trangthaisuco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_chiphisuachuanhatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        btn_thongbao.setText("Thong bao");
        btn_thongbao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongbaoActionPerformed(evt);
            }
        });

        btn_suachuaxong.setText("Sua chua xong");
        btn_suachuaxong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suachuaxongActionPerformed(evt);
            }
        });

        btn_clearsuco.setText("Clear");
        btn_clearsuco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearsucoActionPerformed(evt);
            }
        });

        tb_bangsuconhatro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ten su co", "Thoi gian thong bao", "Mo ta", "Chi phi sua chua", "Trang thai"
            }
        ));
        tb_bangsuconhatro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_bangsuconhatroMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tb_bangsuconhatro);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(btn_thongbao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btn_suachuaxong, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btn_clearsuco, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_thongbao)
                    .addComponent(btn_suachuaxong)
                    .addComponent(btn_clearsuco))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pa_suconhatro.addTab("Su co nha tro", jPanel6);

        pa_trangchu.addTab("Su co nha tro", pa_suconhatro);

        jPanel16.setBackground(new java.awt.Color(204, 204, 204));

        jLabel30.setText("Mã");

        jLabel31.setText("Phòng");

        jLabel32.setText("Tên sự cố");

        jLabel33.setText("Thời gian thông báo");

        jLabel34.setText("Mô tả");

        jLabel35.setText("Trạng thái");

        txtMaSCKH.setBackground(new java.awt.Color(204, 204, 204));

        txtTrangThaiSCKH.setBackground(new java.awt.Color(204, 204, 204));

        txtMoTaSC.setBackground(new java.awt.Color(204, 204, 204));
        txtMoTaSC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoTaSCActionPerformed(evt);
            }
        });

        txtThoiGianThongBaoSC.setBackground(new java.awt.Color(204, 204, 204));

        txtPhongSCKH.setBackground(new java.awt.Color(204, 204, 204));

        txtTenSuCo.setBackground(new java.awt.Color(204, 204, 204));

        jLabel14.setText("Chi phi sua :");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_chiphisuaphong))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenSuCo))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSCKH, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhongSCKH, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTrangThaiSCKH, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtThoiGianThongBaoSC, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMoTaSC, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel33)
                    .addComponent(txtMaSCKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThoiGianThongBaoSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtPhongSCKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(txtMoTaSC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtTenSuCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(txtTrangThaiSCKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_chiphisuaphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tb_SuCoKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Phòng", "Tên Sự Cố", "Thời gian thông báo", "Mô tả", "Chi phi sua", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_SuCoKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SuCoKHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_SuCoKH);

        btn_timkiemsckh.setText("Tim kiem");
        btn_timkiemsckh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemsckhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(txt_timkiemsckh, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_timkiemsckh, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiemsckh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiemsckh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(btnSua)
                        .addGap(301, 301, 301)
                        .addComponent(btnClear))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(367, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("tab1", jPanel16);

        pa_trangchu.addTab("Su co phong", jTabbedPane6);

        jPanel13.setBackground(new java.awt.Color(255, 255, 204));

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setText("Chu nha :");

        jLabel23.setText("Nguoi thue :");

        jLabel24.setText("Phong ;");

        jLabel25.setText("Ngay bat dau :");

        jLabel26.setText("Ngay het han :");

        jLabel27.setText("Ngay sua :");

        jLabel28.setText("Trang thai :");

        jLabel29.setText("Noi dung :");

        txt_nguoithuehopdong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nguoithuehopdongKeyReleased(evt);
            }
        });

        txt_noidunghopdong.setColumns(20);
        txt_noidunghopdong.setRows(5);
        jScrollPane6.setViewportView(txt_noidunghopdong);

        jLabel5.setText("Noi that :");

        jLabel6.setText("Hien trang :");

        jLabel7.setText("Gia phong :");

        jLabel8.setText("So xe :");

        cb_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang ở", "Đã dọn đi" }));

        jLabel11.setText("Tien coc :");

        jLabel12.setText("Chung minh thu :");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_chunhahopdong, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(txt_nguoithuehopdong)
                    .addComponent(txt_phonghopdong)
                    .addComponent(txt_noithathopdong)
                    .addComponent(txt_hientranghopdong)
                    .addComponent(cb_trangthai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_soxehopdong))
                .addGap(55, 55, 55)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ngaybatdauhopdong)
                    .addComponent(txt_ngayhethanhopdong)
                    .addComponent(txt_ngaysuahopdong)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(txt_giaphonghopdong)
                    .addComponent(txt_tiencoc)
                    .addComponent(txt_chungminhthu))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txt_chunhahopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_chungminhthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txt_nguoithuehopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txt_ngaybatdauhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txt_phonghopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(txt_ngayhethanhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_noithathopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_giaphonghopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_soxehopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_tiencoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(cb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29)))
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txt_hientranghopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(txt_ngaysuahopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tb_banghopdong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Chu nha", "Nguoi thue", "Phong", "Gia phong", "Noi that phong", "Hien trang", "So xe", "Noi dung", "Ngay bat dau", "Ngay het han", "Ngay sua", "Trang thai", "cmt"
            }
        ));
        tb_banghopdong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_banghopdongMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tb_banghopdongMouseEntered(evt);
            }
        });
        jScrollPane7.setViewportView(tb_banghopdong);

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
        jScrollPane2.setViewportView(tb_bangdichvuphong);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        btn_clearhopdong.setText("Clear");
        btn_clearhopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearhopdongActionPerformed(evt);
            }
        });

        btn_timkiem.setText("Tim kiem");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        lbl_anhhientrangthue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhhientrangthueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhhientrangthue, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhhientrangthue, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(btn_clearhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_clearhopdong)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_timkiem)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel12);

        pa_trangchu.addTab("Danh sach hop dong", jTabbedPane1);

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel15.setText("Phong :");

        jLabel36.setText("Nguoi thue :");

        jLabel37.setText("Can cuoc :");

        jLabel38.setText("Gia phong :");

        jLabel39.setText("Tien coc :");

        jLabel40.setText("So xe :");

        jLabel41.setText("Thoi gian bat dau :");

        jLabel42.setText("Thoi gian ket thuc :");

        jLabel43.setText("Noi that :");

        jLabel44.setText("Hien trang luc thue :");

        jLabel45.setText("Hien trang luc tra :");

        jLabel46.setText("Ngay tra :");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_traphong_tenphong)
                    .addComponent(txt_traphong_nguoithue)
                    .addComponent(txt_traphong_cmt)
                    .addComponent(txt_traphong_giaphong)
                    .addComponent(txt_traphong_tiencoc)
                    .addComponent(txt_traphong_soxe, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_traphong_batdau)
                    .addComponent(txt_traphong_ketthuc)
                    .addComponent(txt_traphong_noithat)
                    .addComponent(txt_traphong_hientrangthue)
                    .addComponent(txt_traphong_hientrangtra)
                    .addComponent(txt_traphong_ngaytra, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_traphong_tenphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(txt_traphong_batdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txt_traphong_nguoithue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(txt_traphong_ketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txt_traphong_cmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(txt_traphong_noithat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txt_traphong_giaphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(txt_traphong_hientrangthue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txt_traphong_tiencoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(txt_traphong_hientrangtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txt_traphong_soxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(txt_traphong_ngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("Hiện trạng phòng lúc thuê"));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhlucthue, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhlucthue, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Hiện trạng phòng lúc trả phòng"));

        lbl_anhluctra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhluctraMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhluctra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhluctra, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );

        tb_dangxuli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Phong", "Nguoi thue", "Can cuoc", "Gia phong", "Tien coc", "Thoi gian bat dau", "Thoi gian ket thuc", "Noi that", "Hien trang luc thue", "Hien trang luc tra", "So xe", "Ngay tra", "Trang thai"
            }
        ));
        tb_dangxuli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_dangxuliMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tb_dangxuli);

        btn_timkiemdangxuli.setText("Tim kiem");
        btn_timkiemdangxuli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemdangxuliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1033, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txt_timkiemdangxuli, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_timkiemdangxuli)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiemdangxuli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_timkiemdangxuli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Dang xu li", jPanel27);

        tb_datraphong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Phong", "Nguoi thue", "Can cuoc", "Gia phong", "Tien coc", "Thoi gian bat dau", "Thoi gian ket thuc", "Noi that", "Hien trang luc thue", "Hien trang luc tra", "So xe", "Ngay tra", "Trang thai"
            }
        ));
        tb_datraphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_datraphongMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tb_datraphong);

        cb_TKthang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cb_TKnam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Năm", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));

        btn_thongketheothang.setText("Thong ke theo thang");
        btn_thongketheothang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongketheothangActionPerformed(evt);
            }
        });

        btn_thongketheonam.setText("Thong ke theo nam");
        btn_thongketheonam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongketheonamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(cb_TKthang, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cb_TKnam, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btn_thongketheothang)
                        .addGap(18, 18, 18)
                        .addComponent(btn_thongketheonam, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 1033, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_TKthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_TKnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_thongketheothang)
                    .addComponent(btn_thongketheonam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Da tra phong", jPanel28);

        btn_suahopdong1.setText("OK");
        btn_suahopdong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suahopdong1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(btn_suahopdong1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTabbedPane3)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(84, 84, 84))))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btn_suahopdong1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pa_trangchu.addTab("Danh sach tra phong", jPanel19);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pa_trangchu)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pa_trangchu, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String hinh = null;
    private void btn_themphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themphongActionPerformed
        // TODO add your handling code here:
        Boolean checkTenPhong = false;
        for (Phong p : pR.getAllData()) {
            if (txt_tenphong.getText().equalsIgnoreCase(p.getTenPhong())) {
                checkTenPhong = true;
            }
        }
        if (checkTenPhong == true) {
            JOptionPane.showMessageDialog(this, "Tên phòng đã tồn tại");
            return;
        }
        Phong phong = new Phong();
        NhaTro nhatro = new NhaTro();

        String ma = "Ma" + String.valueOf(ntR.DemPhong() + 1);
        String tennha = "Nhom 7";
        String tenphong = txt_tenphong.getText().trim();
        String tinhtrang = cb_tinhtrang.getSelectedItem().toString();
        Float dientich = Float.valueOf(txt_dientich.getText());
        UUID idnha = pR.findByIdNhaTro(tennha);
        nhatro.setId(idnha);

        phong.setMa(ma);
        phong.setNhaTro(nhatro);
        phong.setTenPhong(tenphong);
        phong.setDienTich(dientich);
        phong.setTinhTrang(tinhtrang);
        phong.setAnhPhong(hinh);
        pR.save(phong);
        JOptionPane.showMessageDialog(this, "thanh cong");
        LoadPhong(pR.getAllData());
    }//GEN-LAST:event_btn_themphongActionPerformed

    private void lbl_anhphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhphongMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("E:\\GitHub\\PRO1041_IT17309_NHom8\\Da1_Nhom7");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            hinh = file.getName();
            lbl_anhphong.setText("");
            int width = lbl_anhphong.getWidth();
            int height = lbl_anhphong.getHeight();
            lbl_anhphong.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("ERROR" + ex.toString());
        }
    }//GEN-LAST:event_lbl_anhphongMouseClicked

    private Phong getPhong() {
        NhaTro nhatro = new NhaTro();

        UUID id = null;
        String tennha = "Nhom 7";
        String tenphong = txt_tenphong.getText().trim();
        String tinhtrang = cb_tinhtrang.getSelectedItem().toString();
        String ma = test.findMaPhong(tenphong);
        Float dientich = Float.valueOf(txt_dientich.getText());
        UUID idnha = pR.findByIdNhaTro(tennha);
        nhatro.setId(idnha);

        Phong phong = new Phong(id, nhatro, ma, tenphong, dientich, tinhtrang, hinh);

        return phong;
    }

    private void btn_suaphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaphongActionPerformed
        // TODO add your handling code here:
        Phong phong = getPhong();

        String tenphong = txt_tenphong.getText().toString();

        phong.setId(tpR.findByIdPhong(tenphong));
        pR.update(phong);
        JOptionPane.showMessageDialog(this, "thanh cong");
        LoadPhong(pR.getAllData());
    }//GEN-LAST:event_btn_suaphongActionPerformed

    public void fillSinhVienLenForm(Phong sv) {
        txt_tenphong.setText(sv.getTenPhong());
        txt_dientich.setText(String.valueOf(sv.getDienTich()));
        cb_tinhtrang.setSelectedItem(sv.getTinhTrang());
        ImageIcon imgIcon = new ImageIcon("E:/GitHub/PRO1041_IT17309_NHom8/Da1_Nhom7/src/main/java/images/" + sv.getAnhPhong());
        Image img = imgIcon.getImage();
        lbl_anhphong.setIcon(new ImageIcon(img.getScaledInstance(lbl_anhphong.getWidth(), lbl_anhphong.getHeight(), 0)));
    }

    public Phong show(String maSV) {
        for (Phong sv : pR.getAllData()) {
            if (sv.getTenPhong().equalsIgnoreCase(maSV)) {
                return sv;
            }
        }
        return null;
    }

    private void tb_bangphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangphongMouseClicked
        // TODO add your handling code here:
        int id = tb_bangphong.rowAtPoint(evt.getPoint());
        String masv = tb_bangphong.getValueAt(id, 0).toString();
        Phong sv = show(masv);
        fillSinhVienLenForm(sv);
    }//GEN-LAST:event_tb_bangphongMouseClicked

    private void btn_themdichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themdichvuActionPerformed
        // TODO add your handling code here:
        DichVu dv = new DichVu();
        NhaTro nt = new NhaTro();

        String ten = txt_tendichvu.getText().trim();
        int dongia = Integer.parseInt(txt_dongiadichvu.getText().trim());
        String tennha = "Nhom 7";
        String ma = "DichVu" + String.valueOf(ntR.DemDichVu() + 1);

        UUID idnha = pR.findByIdNhaTro(tennha);
        nt.setId(idnha);

        dv.setTenDichVu(ten);
        dv.setDonGia(dongia);
        dv.setMa(ma);
        dv.setNhaTro(nt);
        dvR.save(dv);
        JOptionPane.showMessageDialog(this, "thanh cong");
        LoadDichVu(dvR.getAllData());
    }//GEN-LAST:event_btn_themdichvuActionPerformed

    private void btn_cleardichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cleardichvuActionPerformed
        // TODO add your handling code here:
        txt_tendichvu.setText("");
        txt_dongiadichvu.setText("");
    }//GEN-LAST:event_btn_cleardichvuActionPerformed

    private void tb_bangdichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangdichvuMouseClicked
        // TODO add your handling code here:
        int row = tb_bangdichvu.getSelectedRow();
        if (row == -1) {
            return;
        }
        txt_tendichvu.setText(tb_bangdichvu.getValueAt(row, 0).toString());
        txt_dongiadichvu.setText(tb_bangdichvu.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tb_bangdichvuMouseClicked

    private void btn_thongbaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongbaoActionPerformed
        try {
            // TODO add your handling code here:
            SuCoNhaTro scnt = new SuCoNhaTro();
            NhaTro nt = new NhaTro();
            ChuNha cn = new ChuNha();

            int index = tb_bangsuconhatro.getRowCount() + 1;
            String ma = "SuCo" + String.valueOf(index);
            String ten = txt_tensuco.getText().trim();
            Date ngay = sdf.parse(txt_thoigianthongbao.getText().trim());
            String mota = txt_motasuco.getText().trim();
            String trangthai = "đang sửa";

            String tennha = "Nhom 7";
            String tenchunha = "admin";

            UUID idnha = pR.findByIdNhaTro(tennha);
            nt.setId(idnha);

            UUID idchunha = ntR.findByIdCN(tenchunha);
            cn.setId(idchunha);

            scnt.setTenSuCo(ten);
            scnt.setThoiGianThongBao(ngay);
            scnt.setMoTa(mota);
            scnt.setTrangThai(trangthai);
            scnt.setNhaTro(nt);
            scnt.setChuNha(cn);
            scnt.setMa(ma);
            scntR.save(scnt);
            JOptionPane.showMessageDialog(this, "thanh cong");
            LoadSuCoNhaTro(scntR.getAllData());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_thongbaoActionPerformed

    private void btn_suachuaxongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suachuaxongActionPerformed
        // TODO add your handling code here:
        int index = tb_bangsuconhatro.getSelectedRow();
        SuCoNhaTro scnt = scntR.getAllData().get(index);
        int chiphi = Integer.parseInt(txt_chiphisuachuanhatro.getText().toString());
        String trangthai = "sửa xong";
        scnt.setChiPhiSuaChua(chiphi);
        scnt.setTrangThai(trangthai);
        scntR.update(scnt);
        JOptionPane.showMessageDialog(this, "thanh cong");
        LoadSuCoNhaTro(scntR.getAllData());
    }//GEN-LAST:event_btn_suachuaxongActionPerformed

    private void btn_clearsucoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearsucoActionPerformed
        // TODO add your handling code here:
        txt_tensuco.setText("");
        txt_thoigianthongbao.setText("");
        txt_motasuco.setText("");
        txt_trangthaisuco.setText("");
    }//GEN-LAST:event_btn_clearsucoActionPerformed

    private void tb_bangsuconhatroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangsuconhatroMouseClicked
        // TODO add your handling code here:
        int index = tb_bangsuconhatro.getSelectedRow();
        SuCoNhaTro scnt = scntR.getAllData().get(index);
        txt_tensuco.setText(scnt.getTenSuCo());
        txt_thoigianthongbao.setText(String.valueOf(scnt.getThoiGianThongBao()));
        txt_motasuco.setText(scnt.getMoTa());
        txt_trangthaisuco.setText(scnt.getTrangThai());
    }//GEN-LAST:event_tb_bangsuconhatroMouseClicked

    private void btn_lamhopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamhopdongActionPerformed
        // TODO add your handling code here:
        String masv = txt_tenphong.getText().trim();
        HopDongView f = new HopDongView(masv);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_lamhopdongActionPerformed


    private void btn_clearhopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearhopdongActionPerformed

        xoaTrang();
    }//GEN-LAST:event_btn_clearhopdongActionPerformed
    private void xoaTrang() {
        txt_chunhahopdong.setText("");
        txt_nguoithuehopdong.setText("");
        txt_phonghopdong.setText("");
        txt_ngaybatdauhopdong.setText("");
        txt_ngayhethanhopdong.setText("");
        txt_ngaysuahopdong.setText("");
        txt_noidunghopdong.setText("");
        cb_trangthai.setSelectedItem(0);
    }
    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dmt = (DefaultTableModel) tb_banghopdong.getModel();
        DefaultTableModel dmt1 = (DefaultTableModel) tb_bangdichvuphong.getModel();
        String search = txt_timkiem.getText().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        TableRowSorter<DefaultTableModel> tr1 = new TableRowSorter<DefaultTableModel>(dmt1);
        tb_banghopdong.setRowSorter(tr);
        tb_bangdichvuphong.setRowSorter(tr1);
        tr.setRowFilter(RowFilter.regexFilter(search));
        tr1.setRowFilter(RowFilter.regexFilter(search));

    }//GEN-LAST:event_btn_timkiemActionPerformed

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
        txt_chungminhthu.setText(hd.getNguoiThue().getCmtnd());
        txt_tiencoc.setText(String.valueOf(hd.getTienCoc()));
    }//GEN-LAST:event_tb_banghopdongMouseClicked

    private void btn_timkiemphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemphongActionPerformed
        // TODO add your handling code here:
        if (cb_loaiphong.getSelectedItem().toString() == "Tất cả") {
            DefaultTableModel dmt = (DefaultTableModel) tb_bangphong.getModel();
            String search = "P";
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
            tb_bangphong.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(search));
            float min = Float.valueOf(txt_min.getText());
            float max = Float.valueOf(txt_max.getText());
            LoadPhong(test.test(min, max));
        } else {
            DefaultTableModel dmt = (DefaultTableModel) tb_bangphong.getModel();
            String search = cb_loaiphong.getSelectedItem().toString();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
            tb_bangphong.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(search));
            float min = Float.valueOf(txt_min.getText());
            float max = Float.valueOf(txt_max.getText());
            LoadPhong(test.test(min, max));
        }
    }//GEN-LAST:event_btn_timkiemphongActionPerformed

    private void tb_banghopdongMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_banghopdongMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_banghopdongMouseEntered

    private void tb_SuCoKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SuCoKHMouseClicked
        int index = tb_SuCoKH.getSelectedRow();
        sckh = sckhR.getAllData().get(index);
        txtMaSCKH.setText(sckh.getMa());
        txtPhongSCKH.setText(sckh.getPhong().getTenPhong());
        txtTenSuCo.setText(sckh.getTenSuCo());
        txtThoiGianThongBaoSC.setText(String.valueOf(sckh.getThoiGianThongBao()));
        txtMoTaSC.setText(sckh.getMoTa());
        txtTrangThaiSCKH.setText(sckh.getTrangThai());

    }//GEN-LAST:event_tb_SuCoKHMouseClicked
    private void clear() {
        txtMaSCKH.setText("");
        txtPhongSCKH.setText("");
        txtTenSuCo.setText("");
        txtThoiGianThongBaoSC.setText("");
        txtMoTaSC.setText("");
        txtTrangThaiSCKH.setText("");

    }
    private void txtMoTaSCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMoTaSCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMoTaSCActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int index = tb_SuCoKH.getSelectedRow();
        SuCoKH sckh = sckhR.getAllData().get(index);
        int chiphi = Integer.parseInt(txt_chiphisuaphong.getText().toString());
        String trangthai = "sửa xong";
        sckh.setChiPhiSuaChua(chiphi);
        sckh.setTrangThai(trangthai);
        sckhR.update(sckh);
        JOptionPane.showMessageDialog(this, "thanh cong");
        LoadSuCoKH(sckhR.getAllData());
        clear();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txt_minActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_minActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_minActionPerformed

    private void txt_maxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maxActionPerformed

    private void tb_bangdichvuphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangdichvuphongMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_bangdichvuphongMouseClicked

    private void txt_nguoithuehopdongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nguoithuehopdongKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_nguoithuehopdongKeyReleased

    private HopDong getHopDong() throws ParseException {
        String dataNguoiThue = traphongR.findMaNguoiThue(txt_traphong_nguoithue.getText().toString());
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
        String hientrangtra = txt_traphong_hientrangtra.getText().toString();
        String anhhientrangtra = hinh2;
        Date ngaybatdau = traphongR.findNgayBatDau(dataNguoiThue);
        Date ngayhethan = traphongR.findNgayHetHan(dataNguoiThue);
        String noidung = traphongR.findNoiDung(dataNguoiThue);
        String trangthai = "Da tra phong";
        int tiencoc = traphongR.findTienCoc(dataNguoiThue);
        Date ngaysua = java.util.Calendar.getInstance().getTime();

        UUID idcn = ntR.findByIdCN(tencn);
        cn.setId(idcn);

        nt.setId(idnt);
        p.setId(idp);

        HopDong hd = new HopDong(idhd, cn, p, nt, ma, giaphong, tiencoc, noithat, hientrang, anhhientrang, hientrangtra, anhhientrangtra, soxe, noidung, ngaybatdau, ngayhethan, ngaysua, trangthai);

        return hd;

    }

    private void btn_suahopdong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suahopdong1ActionPerformed
        // TODO add your handling code here:
        String dataNguoiThue = traphongR.findMaNguoiThue(txt_traphong_nguoithue.getText().toString());
        try {
            // TODO add your handling code here:
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Xac nhan cho tra phong ?");

            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            HopDong hd = getHopDong();

            UUID idhd = traphongR.findIdHopDong(dataNguoiThue);
            hd.setId(idhd);
            hdR.update(hd);
            JOptionPane.showMessageDialog(this, "thanh cong");
            LoadTraPhong(hdR.getAllData());
        } catch (ParseException ex) {
            Logger.getLogger(QLNhaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_suahopdong1ActionPerformed

    public void fillSinhVienLenForm1(HopDong hd) {
        txt_traphong_tenphong.setText(hd.getPhong().getTenPhong());
        txt_traphong_nguoithue.setText(hd.getNguoiThue().getHoTen());
        txt_traphong_cmt.setText(hd.getNguoiThue().getCmtnd());
        txt_traphong_giaphong.setText(String.valueOf(hd.getGiaPhong()));
        txt_traphong_tiencoc.setText(String.valueOf(hd.getTienCoc()));
        txt_traphong_batdau.setText(String.valueOf(hd.getNgayBatDau()));
        txt_traphong_ketthuc.setText(String.valueOf(hd.getNgayHetHan()));
        txt_traphong_noithat.setText(hd.getNoiThatPhong());
        txt_traphong_hientrangthue.setText(hd.getHienTrang());
        txt_traphong_hientrangtra.setText(hd.getHienTrangTraPhong());
        txt_traphong_soxe.setText(String.valueOf(hd.getSoXe()));
        txt_traphong_ngaytra.setText(String.valueOf(hd.getNgaySua()));
        ImageIcon imgIcon = new ImageIcon("E:/GitHub/PRO1041_IT17309_NHom8/Da1_Nhom7/src/main/java/images/" + hd.getAnhHienTrang());
        Image img = imgIcon.getImage();
        lbl_anhlucthue.setIcon(new ImageIcon(img.getScaledInstance(lbl_anhlucthue.getWidth(), lbl_anhlucthue.getHeight(), 0)));

        ImageIcon imgIcon1 = new ImageIcon("E:/GitHub/PRO1041_IT17309_NHom8/Da1_Nhom7/src/main/java/images/" + hd.getAnhHienTrangTraPhong());
        Image img1 = imgIcon1.getImage();
        lbl_anhluctra.setIcon(new ImageIcon(img1.getScaledInstance(lbl_anhluctra.getWidth(), lbl_anhluctra.getHeight(), 0)));
    }

    public HopDong show1(String maSV) {
        for (HopDong hd : hdR.getAllData()) {
            if (hd.getPhong().getTenPhong().equalsIgnoreCase(maSV)) {
                return hd;
            }
        }
        return null;
    }

    private void tb_datraphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_datraphongMouseClicked
        // TODO add your handling code here:
        int id = tb_datraphong.rowAtPoint(evt.getPoint());
        String masv = tb_datraphong.getValueAt(id, 0).toString();
        HopDong sv = show1(masv);
        fillSinhVienLenForm1(sv);
    }//GEN-LAST:event_tb_datraphongMouseClicked

    private void tb_dangxuliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_dangxuliMouseClicked
        // TODO add your handling code here:
        int id = tb_dangxuli.rowAtPoint(evt.getPoint());
        String masv = tb_dangxuli.getValueAt(id, 0).toString();
        HopDong sv = show1(masv);
        fillSinhVienLenForm1(sv);
    }//GEN-LAST:event_tb_dangxuliMouseClicked

    String hinh2 = null;
    private void lbl_anhluctraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhluctraMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("E:\\GitHub\\PRO1041_IT17309_NHom8\\Da1_Nhom7");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            hinh2 = file.getName();
            lbl_anhluctra.setText("");
            int width = lbl_anhluctra.getWidth();
            int height = lbl_anhluctra.getHeight();
            lbl_anhluctra.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("ERROR" + ex.toString());
        }
    }//GEN-LAST:event_lbl_anhluctraMouseClicked

    String hinh1 = null;
    private void lbl_anhhientrangthueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhhientrangthueMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("E:\\GitHub\\PRO1041_IT17309_NHom8\\Da1_Nhom7");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            hinh1 = file.getName();
            lbl_anhhientrangthue.setText("");
            int width = lbl_anhhientrangthue.getWidth();
            int height = lbl_anhhientrangthue.getHeight();
            lbl_anhhientrangthue.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("ERROR" + ex.toString());
        }
    }//GEN-LAST:event_lbl_anhhientrangthueMouseClicked

    private void btn_thongketheonamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongketheonamActionPerformed
        // TODO add your handling code here:
        if (cb_TKnam.getSelectedItem().toString() == "Năm") {
            JOptionPane.showMessageDialog(this, "Chua chon thoi gian thong ke");
            return;
        }
        DefaultTableModel dmt = (DefaultTableModel) tb_datraphong.getModel();
        String b = cb_TKnam.getSelectedItem().toString();
        String search = b;
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_datraphong.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_btn_thongketheonamActionPerformed

    private void btn_thongketheothangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongketheothangActionPerformed
        // TODO add your handling code here:
        if (cb_TKthang.getSelectedItem().toString() == "Tháng" || cb_TKnam.getSelectedItem().toString() == "Năm") {
            JOptionPane.showMessageDialog(this, "Chua chon thoi gian thong ke");
            return;
        }
        DefaultTableModel dmt = (DefaultTableModel) tb_datraphong.getModel();
        String a = cb_TKthang.getSelectedItem().toString();
        String b = cb_TKnam.getSelectedItem().toString();
        String search = b + "-" + a;
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_datraphong.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_btn_thongketheothangActionPerformed

    private void btn_timkiemdangxuliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemdangxuliActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dmt = (DefaultTableModel) tb_dangxuli.getModel();
        String search = txt_timkiemdangxuli.getText().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_dangxuli.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_btn_timkiemdangxuliActionPerformed

    private void btn_timkiemsckhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemsckhActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dmt = (DefaultTableModel) tb_SuCoKH.getModel();
        String search = txt_timkiemsckh.getText().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_SuCoKH.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_btn_timkiemsckhActionPerformed

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
            java.util.logging.Logger.getLogger(QLNhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNhaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Hello;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btn_cleardichvu;
    private javax.swing.JButton btn_clearhopdong;
    private javax.swing.JButton btn_clearphong;
    private javax.swing.JButton btn_clearsuco;
    private javax.swing.JButton btn_lamhopdong;
    private javax.swing.JButton btn_suachuaxong;
    private javax.swing.JButton btn_suahopdong1;
    private javax.swing.JButton btn_suaphong;
    private javax.swing.JButton btn_themdichvu;
    private javax.swing.JButton btn_themphong;
    private javax.swing.JButton btn_thongbao;
    private javax.swing.JButton btn_thongketheonam;
    private javax.swing.JButton btn_thongketheothang;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_timkiemdangxuli;
    private javax.swing.JButton btn_timkiemphong;
    private javax.swing.JButton btn_timkiemsckh;
    private javax.swing.JButton btn_updatedichvu;
    private javax.swing.JComboBox<String> cb_TKnam;
    private javax.swing.JComboBox<String> cb_TKthang;
    private javax.swing.JComboBox<String> cb_loaiphong;
    private javax.swing.JComboBox<String> cb_tinhtrang;
    private javax.swing.JComboBox<String> cb_trangthai;
    private javax.swing.JDesktopPane jDesktopPane1;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JLabel lbl_anhhientrangthue;
    private javax.swing.JLabel lbl_anhlucthue;
    private javax.swing.JLabel lbl_anhluctra;
    private javax.swing.JLabel lbl_anhphong;
    private javax.swing.JTabbedPane pa_dichvu;
    private javax.swing.JTabbedPane pa_phong;
    private javax.swing.JTabbedPane pa_suconhatro;
    private javax.swing.JTabbedPane pa_trangchu;
    private javax.swing.JTable tb_SuCoKH;
    private javax.swing.JTable tb_bangdichvu;
    private javax.swing.JTable tb_bangdichvuphong;
    private javax.swing.JTable tb_banghopdong;
    private javax.swing.JTable tb_bangphong;
    private javax.swing.JTable tb_bangsuconhatro;
    private javax.swing.JTable tb_dangxuli;
    private javax.swing.JTable tb_datraphong;
    private javax.swing.JTextField txtMaSCKH;
    private javax.swing.JTextField txtMoTaSC;
    private javax.swing.JTextField txtPhongSCKH;
    private javax.swing.JTextField txtTenSuCo;
    private javax.swing.JTextField txtThoiGianThongBaoSC;
    private javax.swing.JTextField txtTrangThaiSCKH;
    private javax.swing.JTextField txt_chiphisuachuanhatro;
    private javax.swing.JTextField txt_chiphisuaphong;
    private javax.swing.JTextField txt_chungminhthu;
    private javax.swing.JTextField txt_chunhahopdong;
    private javax.swing.JTextField txt_dientich;
    private javax.swing.JTextField txt_dongiadichvu;
    private javax.swing.JTextField txt_giaphonghopdong;
    private javax.swing.JTextField txt_hientranghopdong;
    private javax.swing.JTextField txt_max;
    private javax.swing.JTextField txt_min;
    private javax.swing.JTextField txt_motasuco;
    private javax.swing.JTextField txt_ngaybatdauhopdong;
    private javax.swing.JTextField txt_ngayhethanhopdong;
    private javax.swing.JTextField txt_ngaysuahopdong;
    private javax.swing.JTextField txt_nguoithuehopdong;
    private javax.swing.JTextArea txt_noidunghopdong;
    private javax.swing.JTextField txt_noithathopdong;
    private javax.swing.JTextField txt_phonghopdong;
    private javax.swing.JTextField txt_soxehopdong;
    private javax.swing.JTextField txt_tendichvu;
    private javax.swing.JTextField txt_tenphong;
    private javax.swing.JTextField txt_tensuco;
    private javax.swing.JTextField txt_thoigianthongbao;
    private javax.swing.JTextField txt_tiencoc;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JTextField txt_timkiemdangxuli;
    private javax.swing.JTextField txt_timkiemsckh;
    private javax.swing.JTextField txt_trangthaisuco;
    private javax.swing.JTextField txt_traphong_batdau;
    private javax.swing.JTextField txt_traphong_cmt;
    private javax.swing.JTextField txt_traphong_giaphong;
    private javax.swing.JTextField txt_traphong_hientrangthue;
    private javax.swing.JTextField txt_traphong_hientrangtra;
    private javax.swing.JTextField txt_traphong_ketthuc;
    private javax.swing.JTextField txt_traphong_ngaytra;
    private javax.swing.JTextField txt_traphong_nguoithue;
    private javax.swing.JTextField txt_traphong_noithat;
    private javax.swing.JTextField txt_traphong_soxe;
    private javax.swing.JTextField txt_traphong_tenphong;
    private javax.swing.JTextField txt_traphong_tiencoc;
    // End of variables declaration//GEN-END:variables
}
