/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Models.ChiTietTienPhong;
import Models.DichVu;
import Models.DichVuPhong;
import Models.Phong;
import Models.TienPhong;
import Repo.TienPhongRepo;
import Service.IsvCttpImpl;
import Service.IsvDichVuPhongImpl;
import Service.IsvTienPhongImpl;
import Service.impl.CttpImpl;
import Service.impl.DichVuPhongImpl;
import Service.impl.TienPhongImpl;
import com.sun.xml.bind.v2.schemagen.Util;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
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
public class QLTienPhongView extends javax.swing.JFrame {

    ButtonGroup buttonGroup = new ButtonGroup();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DefaultTableModel dtm;
    private IsvTienPhongImpl tpR = new TienPhongImpl();
    private IsvCttpImpl cttpR = new CttpImpl();
    private IsvDichVuPhongImpl dvpR = new DichVuPhongImpl();
    private TienPhongRepo tprepo = new TienPhongRepo();

    /**
     * Creates new form QLPhongView
     */
    public QLTienPhongView() {
        initComponents();
        LoadTienPhong(tpR.getAllData());
        LoadDichVuPhong(dvpR.getAllData());
        LoadChiTietTienPhong(cttpR.getAllData());
        LoadThongKe(cttpR.getAllData());
        tongthongke();
        rdTinhTrang();
    }

    void rdTinhTrang() {
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rd_tatca);
        buttonGroup.add(rd_daongtien);
        buttonGroup.add(rd_chuadongtien);
    }

    private void LoadTienPhong(List<TienPhong> list) {
        dtm = (DefaultTableModel) tb_tienphong.getModel();
        dtm.setRowCount(0);
        for (TienPhong tp : list) {
            dtm.addRow(new Object[]{
                tp.getMa(), tp.getPhong().getTenPhong(), tp.getNgayTao(), tp.getHinhThucThanhToan(),
                tp.getNgayThanhToan(), tp.getTrangThai(), tp.getGhiChu()});
        }
    }

    private void LoadChiTietTienPhong(List<ChiTietTienPhong> list) {
        dtm = (DefaultTableModel) tb_chitiettienphong.getModel();
        dtm.setRowCount(0);
        for (ChiTietTienPhong cttp : list) {
            dtm.addRow(new Object[]{
                cttp.getTienPhong().getMa(), cttp.getBangKeDien(), cttp.getDonGiaDien(),
                cttp.getBangKeNuoc(), cttp.getDonGiaNuoc(), cttp.getDichVu(),
                cttp.getThoiGianBatDau(), cttp.getThoiGianKetThuc(), cttp.getDonGia(), cttp.getHinhAnhDien(), cttp.getHinhAnhNuoc()});
        }
    }

    private void LoadThongKe(List<ChiTietTienPhong> list) {
        dtm = (DefaultTableModel) tb_thongke.getModel();
        dtm.setRowCount(0);
        for (ChiTietTienPhong cttp : list) {
            dtm.addRow(new Object[]{
                cttp.getTienPhong().getPhong().getTenPhong(), cttp.getTienPhong().getNgayThanhToan(),
                cttp.getDonGia(), cttp.getTienPhong().getTrangThai()
            });
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

    private void tongthongke() {
//                dtm = (DefaultTableModel) tb_thongke.getModel();
        DecimalFormat x = new DecimalFormat("###,###,###");
        int Tong = 0;
        for (int i = 0; i < tb_thongke.getRowCount(); i++) {
            Tong += Integer.parseInt(tb_thongke.getValueAt(i, 2).toString());
        }
        jlbThongKe.setText("Tổng tiền : " + x.format(Tong) + " " + "VND");
    }
        private void tongchuathanhtoan() {
//                dtm = (DefaultTableModel) tb_thongke.getModel();
        DecimalFormat x = new DecimalFormat("###,###,###");
        int Tong = 0;
        for (int i = 0; i < tb_thongke.getRowCount(); i++) {
            Tong += Integer.parseInt(tb_thongke.getValueAt(i, 2).toString());
        }
        jlbThongKe.setText("Tổng tiền chưa thanh toán : " + x.format(Tong) + " " + "VND");
    }
            private void tongdathanhtoan() {
//                dtm = (DefaultTableModel) tb_thongke.getModel();
        DecimalFormat x = new DecimalFormat("###,###,###");
        int Tong = 0;
        for (int i = 0; i < tb_thongke.getRowCount(); i++) {
            Tong += Integer.parseInt(tb_thongke.getValueAt(i, 2).toString());
        }
        jlbThongKe.setText("Tổng doanh thu : " + x.format(Tong) + " " + "VND");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btn_tao1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_tienphong = new javax.swing.JTable();
        rd_tatca = new javax.swing.JRadioButton();
        rd_chuadongtien = new javax.swing.JRadioButton();
        rd_daongtien = new javax.swing.JRadioButton();
        txt_timkiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb_chitiettienphong = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_matienphong = new javax.swing.JTextField();
        txt_sodien = new javax.swing.JTextField();
        txt_dongiadien = new javax.swing.JTextField();
        txt_sonuoc = new javax.swing.JTextField();
        txt_dongianuoc = new javax.swing.JTextField();
        txt_dongiadichvu = new javax.swing.JTextField();
        txt_thoigianbatdau = new javax.swing.JTextField();
        txt_thoaigianketthuc = new javax.swing.JTextField();
        txt_tongtien = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_tienphong = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lbl_anhsodien = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbl_anhsonuoc = new javax.swing.JLabel();
        btn_taotienphong = new javax.swing.JButton();
        btn_suatienphong = new javax.swing.JButton();
        btn_cleartienphong = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_bangdichvuphong = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_thongke = new javax.swing.JTable();
        txt_tkThongKe = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jlbThongKe = new javax.swing.JLabel();
        rd_DaThanhToan = new javax.swing.JRadioButton();
        rd_ChuaThanhToan = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        btn_tao1.setText("Tao");
        btn_tao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tao1ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tien phong"));

        tb_tienphong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma", "Phong", "Ngay tao", "Hinh thuc thanh toan", "Ngay thanh toan", "Trang thai", "Ghi chu"
            }
        ));
        tb_tienphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_tienphongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_tienphong);

        rd_tatca.setText("Tat ca");

        rd_chuadongtien.setText("Chua dong tien");
        rd_chuadongtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_chuadongtienActionPerformed(evt);
            }
        });

        rd_daongtien.setText("Da dong tien");
        rd_daongtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_daongtienActionPerformed(evt);
            }
        });

        jButton1.setText("Tim kiem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(rd_tatca, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rd_daongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rd_chuadongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_tatca)
                    .addComponent(rd_chuadongtien)
                    .addComponent(rd_daongtien)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiet tien phong"));

        tb_chitiettienphong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma tien phong", "So dien", "Don gia dien", "So nuoc", "Don gia nuoc", "Don gia dich vu", "Thoi gian bat dau", "Thoi gian ket thuc", "Tong tien", "Anh so dien", "Anh so nuoc"
            }
        ));
        tb_chitiettienphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_chitiettienphongMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tb_chitiettienphong);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Ma tien phong :");

        jLabel2.setText("So dien :");

        jLabel3.setText(" Don gia dien :");

        jLabel4.setText("So nuoc :");

        jLabel5.setText("Don gia nuoc");

        jLabel6.setText("Don gia dich vu :");

        jLabel7.setText("Thoi gian bat dau :");

        jLabel8.setText("Thoi gian ket thuc :");

        jLabel9.setText("Tong tien :");

        txt_sodien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_sodienKeyReleased(evt);
            }
        });

        txt_dongiadien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dongiadienActionPerformed(evt);
            }
        });
        txt_dongiadien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dongiadienKeyReleased(evt);
            }
        });

        txt_sonuoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_sonuocKeyReleased(evt);
            }
        });

        txt_dongianuoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dongianuocKeyReleased(evt);
            }
        });

        txt_tongtien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tongtienKeyReleased(evt);
            }
        });

        jLabel10.setText("Tien phong :");

        txt_tienphong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tienphongKeyReleased(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Anh so dien"));

        lbl_anhsodien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhsodienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhsodien, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhsodien, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Anh so nuoc"));

        lbl_anhsonuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhsonuocMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhsonuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_anhsonuoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_tienphong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(txt_thoaigianketthuc, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_matienphong, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_sodien, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dongiadien, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_sonuoc, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dongianuoc, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dongiadichvu, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_thoigianbatdau, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tongtien))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_matienphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_sodien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_dongiadien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_sonuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_dongianuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_dongiadichvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_thoigianbatdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(39, 39, 39)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_thoaigianketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_tienphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_taotienphong.setText("Tao");
        btn_taotienphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taotienphongActionPerformed(evt);
            }
        });

        btn_suatienphong.setText("Sua");
        btn_suatienphong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suatienphongActionPerformed(evt);
            }
        });

        btn_cleartienphong.setText("CLear");

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
                .addComponent(jScrollPane3)
                .addGap(15, 15, 15))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_tao1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btn_taotienphong)
                        .addGap(61, 61, 61)
                        .addComponent(btn_suatienphong)
                        .addGap(66, 66, 66)
                        .addComponent(btn_cleartienphong))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_taotienphong)
                            .addComponent(btn_suatienphong)
                            .addComponent(btn_cleartienphong))
                        .addContainerGap(64, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_tao1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );

        jTabbedPane1.addTab("Tinh tien phong", jPanel1);

        tb_thongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Phòng", "Ngày thanh toán", "Thành tiền", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(tb_thongke);

        jButton2.setText("Tìm kiếm ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jlbThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbThongKe.setText("Tổng tiền :");

        buttonGroup1.add(rd_DaThanhToan);
        rd_DaThanhToan.setText("Đã thanh toán");
        rd_DaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_DaThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rd_ChuaThanhToan);
        rd_ChuaThanhToan.setText("Chưa thanh toán");
        rd_ChuaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_ChuaThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txt_tkThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jButton2))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(rd_DaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(rd_ChuaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jlbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(647, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tkThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_DaThanhToan)
                    .addComponent(rd_ChuaThanhToan))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jlbThongKe)
                .addGap(87, 87, 87))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1369, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Thong ke", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_tienphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_tienphongMouseClicked
        // TODO add your handling code here:
        int row = tb_tienphong.getSelectedRow();
        if (row == -1) {
            return;
        }
        txt_matienphong.setText(tb_tienphong.getValueAt(row, 0).toString());
        String phong = tb_tienphong.getValueAt(row, 1).toString();
        txt_tienphong.setText(String.valueOf(tpR.findTienPhong(phong)));

        DefaultTableModel dmt = (DefaultTableModel) tb_chitiettienphong.getModel();
        String search = tb_tienphong.getValueAt(row, 0).toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_chitiettienphong.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

        DefaultTableModel dmt1 = (DefaultTableModel) tb_bangdichvuphong.getModel();
        String search1 = tb_tienphong.getValueAt(row, 1).toString();
        TableRowSorter<DefaultTableModel> tr1 = new TableRowSorter<DefaultTableModel>(dmt1);
        tb_bangdichvuphong.setRowSorter(tr1);
        tr1.setRowFilter(RowFilter.regexFilter(search1));
    }//GEN-LAST:event_tb_tienphongMouseClicked

    private void rd_chuadongtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_chuadongtienActionPerformed
        // TODO add your handling code here:
        if (rd_chuadongtien.isSelected()) {
            DefaultTableModel dmt = (DefaultTableModel) tb_tienphong.getModel();
            String search = "chua thanh toan";
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
            tb_tienphong.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(search));
        }
    }//GEN-LAST:event_rd_chuadongtienActionPerformed

    private void txt_dongiadienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dongiadienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dongiadienActionPerformed

    private void btn_tao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tao1ActionPerformed
        // TODO add your handling code here:
        try {
            TienPhong tp = new TienPhong();
            Phong p = new Phong();

            int index = tb_tienphong.getRowCount() + 1;
            String ma = "HD" + String.valueOf(index);
            String tenphong = JOptionPane.showInputDialog("Nhap ten phong :");
            String trangthai = "chua thanh toan";
            Date ngaytao = sdf.parse(JOptionPane.showInputDialog("Ngay tao :"));

            UUID idp = tpR.findByIdPhong(tenphong);
            p.setId(idp);

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
            String a = dateFormat.format(ngaytao);
            int a1 = Integer.parseInt(a);
            
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy");
            String b = dateFormat1.format(ngaytao);
            int b1 = Integer.parseInt(b);
            try {
                int test = tpR.checkTienThang(tenphong, a1);
                int test1 = tprepo.checkNam(tenphong, b1);
                if (a1 == test && b1 == test1) {
                    JOptionPane.showMessageDialog(this, "tháng - "+a1+" năm -  " +b1+" phòng - " + tenphong + " đã có hóa đơn ");
                }
            } catch (Exception e) {
                e.printStackTrace();

                JOptionPane.showMessageDialog(this, "thanh cong");
                tp.setNgayTao(ngaytao);
                tp.setMa(ma);
                tp.setPhong(p);
                tp.setTrangThai(trangthai);
                tpR.save(tp);
                LoadTienPhong(tpR.getAllData());

                DefaultTableModel dmt = (DefaultTableModel) tb_bangdichvuphong.getModel();
                String search = tenphong;
                TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
                tb_bangdichvuphong.setRowSorter(tr);
                tr.setRowFilter(RowFilter.regexFilter(search));
                LoadDichVuPhong(dvpR.getAllData());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_tao1ActionPerformed

    private void rd_daongtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_daongtienActionPerformed
        // TODO add your handling code here:
        if (rd_daongtien.isSelected()) {
            DefaultTableModel dmt = (DefaultTableModel) tb_tienphong.getModel();
            String search = "Da thanh toan";
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
            tb_tienphong.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(search));
        }
    }//GEN-LAST:event_rd_daongtienActionPerformed

    String hinhdien = null;
    String hinhnuoc = null;

    private void btn_taotienphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taotienphongActionPerformed

        try {
            // TODO add your handling code here:
            ChiTietTienPhong cttp = new ChiTietTienPhong();
            TienPhong tp = new TienPhong();

            String ma = txt_matienphong.getText().toString();
            int index = tb_chitiettienphong.getRowCount() + 1;
            String macttp = "CTTP" + String.valueOf(index)+1;
            int sodien = Integer.parseInt(txt_sodien.getText().toString());
            int sonuoc = Integer.parseInt(txt_sonuoc.getText().toString());
            int dongiadien = Integer.parseInt(txt_dongiadien.getText().toString());
            int dongianuoc = Integer.parseInt(txt_dongianuoc.getText().toString());
            int dichvu = Integer.parseInt(txt_dongiadichvu.getText().toString());
            Date ngaybatdau = sdf.parse(txt_thoigianbatdau.getText().trim());
            Date ngayhethan = sdf.parse(txt_thoigianbatdau.getText().trim());
            int tienphong = Integer.parseInt(txt_tienphong.getText().toString());
            int tongtien = Integer.parseInt(txt_tongtien.getText().toString());

            UUID idtienphong = tpR.findByIdTienPhong(ma);
            tp.setId(idtienphong);

            cttp.setMa(macttp);
            cttp.setTienPhong(tp);
            cttp.setBangKeDien(sodien);
            cttp.setBangKeNuoc(sonuoc);
            cttp.setDonGiaDien(dongiadien);
            cttp.setDonGiaNuoc(dongianuoc);
            cttp.setDichVu(dichvu);
            cttp.setThoiGianBatDau(ngaybatdau);
            cttp.setThoiGianKetThuc(ngayhethan);
            cttp.setDonGia(tongtien);
            cttp.setHinhAnhDien(hinhdien);
            cttp.setHinhAnhNuoc(hinhnuoc);
            cttpR.save(cttp);
            JOptionPane.showMessageDialog(this, "thanh cong");
            LoadChiTietTienPhong(cttpR.getAllData());

        } catch (ParseException ex) {
            Logger.getLogger(QLTienPhongView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taotienphongActionPerformed

    private void txt_tienphongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tienphongKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_tienphongKeyReleased
    private void TongTien() {
        int tienphong = Integer.parseInt(txt_tienphong.getText().toString());
        String sodien = txt_sodien.getText().toString();
        String sonuoc = txt_sonuoc.getText().toString();
        String dongiadien = txt_dongiadien.getText().toString();
        String dongianuoc = txt_dongianuoc.getText().toString();
        if (sodien.length() == 0 || sonuoc.length() == 0 || dongiadien.length() == 0 || dongianuoc.length() == 0) {
            int a = tienphong;
            txt_tongtien.setText(String.valueOf(a));
        } else {
            int sdien = Integer.parseInt(sodien);
            int snuoc = Integer.parseInt(sonuoc);
            int dgiadien = Integer.parseInt(dongiadien);
            int dgianuoc = Integer.parseInt(dongianuoc);
            int a = tienphong + (dgiadien * sdien) + (dgianuoc * snuoc);
            txt_tongtien.setText(String.valueOf(a));
        }
    }
    private void txt_sodienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sodienKeyReleased
        // TODO add your handling code here:
        TongTien();
    }//GEN-LAST:event_txt_sodienKeyReleased

    private void txt_tongtienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tongtienKeyReleased

    }//GEN-LAST:event_txt_tongtienKeyReleased

    private void txt_dongiadienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dongiadienKeyReleased
        // TODO add your handling code here:
        TongTien();
    }//GEN-LAST:event_txt_dongiadienKeyReleased

    private void txt_sonuocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sonuocKeyReleased
        // TODO add your handling code here:
        TongTien();
    }//GEN-LAST:event_txt_sonuocKeyReleased

    private void txt_dongianuocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dongianuocKeyReleased
        // TODO add your handling code here:
        TongTien();
    }//GEN-LAST:event_txt_dongianuocKeyReleased

    private void lbl_anhsodienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhsodienMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("E:\\GitHub\\PRO1041_IT17309_NHom8\\Da1_Nhom7");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            hinhdien = file.getName();
            lbl_anhsodien.setText("");
            int width = lbl_anhsodien.getWidth();
            int height = lbl_anhsodien.getHeight();
            lbl_anhsodien.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("ERROR" + ex.toString());
        }
    }//GEN-LAST:event_lbl_anhsodienMouseClicked

    private void lbl_anhsonuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhsonuocMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser("E:\\GitHub\\PRO1041_IT17309_NHom8\\Da1_Nhom7");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            hinhnuoc = file.getName();
            lbl_anhsonuoc.setText("");
            int width = lbl_anhsonuoc.getWidth();
            int height = lbl_anhsonuoc.getHeight();
            lbl_anhsonuoc.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("ERROR" + ex.toString());
        }
    }//GEN-LAST:event_lbl_anhsonuocMouseClicked

    private void tb_bangdichvuphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_bangdichvuphongMouseClicked
        // TODO add your handling code here:
        int row = tb_bangdichvuphong.getSelectedRow();
        if (row == -1) {
            return;
        }
        int dongia = Integer.parseInt(tb_bangdichvuphong.getValueAt(row, 2).toString());
        if (txt_dongiadichvu.getText().length() == 0) {
            txt_dongiadichvu.setText(String.valueOf(dongia));
        } else {
            int a = Integer.parseInt(txt_dongiadichvu.getText().toString());
            int b = a + dongia;
            txt_dongiadichvu.setText(String.valueOf(b));
        }
    }//GEN-LAST:event_tb_bangdichvuphongMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dmt = (DefaultTableModel) tb_tienphong.getModel();
        String search = txt_timkiem.getText().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_tienphong.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jButton1ActionPerformed

    public void fillSinhVienLenForm(ChiTietTienPhong sv) {
        ImageIcon imgIcon = new ImageIcon("E:/GitHub/PRO1041_IT17309_NHom8/Da1_Nhom7/src/main/java/images/" + sv.getHinhAnhDien());
        Image img = imgIcon.getImage();
        lbl_anhsodien.setIcon(new ImageIcon(img.getScaledInstance(lbl_anhsodien.getWidth(), lbl_anhsodien.getHeight(), 0)));

        ImageIcon imgIcon1 = new ImageIcon("E:/GitHub/PRO1041_IT17309_NHom8/Da1_Nhom7/src/main/java/images/" + sv.getHinhAnhNuoc());
        Image img1 = imgIcon.getImage();
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
        txt_matienphong.setText(tb_chitiettienphong.getValueAt(row, 0).toString());
        txt_sodien.setText(tb_chitiettienphong.getValueAt(row, 1).toString());
        txt_dongiadien.setText(tb_chitiettienphong.getValueAt(row, 2).toString());
        txt_sonuoc.setText(tb_chitiettienphong.getValueAt(row, 3).toString());
        txt_dongianuoc.setText(tb_chitiettienphong.getValueAt(row, 4).toString());
        txt_dongiadichvu.setText(tb_chitiettienphong.getValueAt(row, 5).toString());
        txt_thoigianbatdau.setText(tb_chitiettienphong.getValueAt(row, 6).toString());
        txt_thoaigianketthuc.setText(tb_chitiettienphong.getValueAt(row, 7).toString());
        txt_tongtien.setText(tb_chitiettienphong.getValueAt(row, 8).toString());
        int id = tb_chitiettienphong.rowAtPoint(evt.getPoint());
        String masv = tb_chitiettienphong.getValueAt(id, 0).toString();
        ChiTietTienPhong sv = show(masv);
        fillSinhVienLenForm(sv);
    }//GEN-LAST:event_tb_chitiettienphongMouseClicked

    private void btn_suatienphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suatienphongActionPerformed
        try {
            // TODO add your handling code here:
            int index = tb_chitiettienphong.getSelectedRow();
            ChiTietTienPhong cttp = cttpR.getAllData().get(index);
            TienPhong tp = new TienPhong();

            String ma = txt_matienphong.getText().toString();
            int sodien = Integer.parseInt(txt_sodien.getText().toString());
            int sonuoc = Integer.parseInt(txt_sonuoc.getText().toString());
            int dongiadien = Integer.parseInt(txt_dongiadien.getText().toString());
            int dongianuoc = Integer.parseInt(txt_dongianuoc.getText().toString());
            int dichvu = Integer.parseInt(txt_dongiadichvu.getText().toString());
            Date ngaybatdau = sdf.parse(txt_thoigianbatdau.getText().trim());
            Date ngayhethan = sdf.parse(txt_thoigianbatdau.getText().trim());
            int tienphong = Integer.parseInt(txt_tienphong.getText().toString());
            int tongtien = Integer.parseInt(txt_tongtien.getText().toString());

            UUID idtienphong = tpR.findByIdTienPhong(ma);
            tp.setId(idtienphong);

            cttp.setTienPhong(tp);
            cttp.setBangKeDien(sodien);
            cttp.setBangKeNuoc(sonuoc);
            cttp.setDonGiaDien(dongiadien);
            cttp.setDonGiaNuoc(dongianuoc);
            cttp.setDichVu(dichvu);
            cttp.setThoiGianBatDau(ngaybatdau);
            cttp.setThoiGianKetThuc(ngayhethan);
            cttp.setDonGia(tongtien);
            cttp.setHinhAnhDien(hinhdien);
            cttp.setHinhAnhNuoc(hinhnuoc);
            cttpR.update(cttp);
            JOptionPane.showMessageDialog(this, "thanh cong");
            LoadChiTietTienPhong(cttpR.getAllData());
        } catch (ParseException ex) {
            Logger.getLogger(QLTienPhongView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_suatienphongActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dmt = (DefaultTableModel) tb_thongke.getModel();
        String search = txt_tkThongKe.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_thongke.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
        tongthongke();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rd_tatcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_tatcaActionPerformed
        // TODO add your handling code here:
        if (rd_tatca.isSelected()) {
            DefaultTableModel dmt = (DefaultTableModel) tb_tienphong.getModel();
            String search = "HD";
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
            tb_tienphong.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(search));
        }
    }//GEN-LAST:event_rd_tatcaActionPerformed

    private void rd_DaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_DaThanhToanActionPerformed
        // TODO add your handling code here:
            if (rd_DaThanhToan.isSelected()) {
            DefaultTableModel dmt = (DefaultTableModel) tb_thongke.getModel();
            String search = "Da thanh toan";
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
            tb_thongke.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(search));
            tongdathanhtoan();
        }
    }//GEN-LAST:event_rd_DaThanhToanActionPerformed

    private void rd_ChuaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_ChuaThanhToanActionPerformed
        // TODO add your handling code here:
            if (rd_ChuaThanhToan.isSelected()) {
            DefaultTableModel dmt = (DefaultTableModel) tb_thongke.getModel();
            String search = "chua thanh toan";
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
            tb_thongke.setRowSorter(tr);
            tr.setRowFilter(RowFilter.regexFilter(search));
            tongchuathanhtoan();
        }
    }//GEN-LAST:event_rd_ChuaThanhToanActionPerformed

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
            java.util.logging.Logger.getLogger(QLTienPhongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLTienPhongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLTienPhongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLTienPhongView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLTienPhongView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cleartienphong;
    private javax.swing.JButton btn_suatienphong;
    private javax.swing.JButton btn_tao1;
    private javax.swing.JButton btn_taotienphong;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlbThongKe;
    private javax.swing.JLabel lbl_anhsodien;
    private javax.swing.JLabel lbl_anhsonuoc;
    private javax.swing.JRadioButton rd_ChuaThanhToan;
    private javax.swing.JRadioButton rd_DaThanhToan;
    private javax.swing.JRadioButton rd_chuadongtien;
    private javax.swing.JRadioButton rd_daongtien;
    private javax.swing.JRadioButton rd_tatca;
    private javax.swing.JTable tb_bangdichvuphong;
    private javax.swing.JTable tb_chitiettienphong;
    private javax.swing.JTable tb_thongke;
    private javax.swing.JTable tb_tienphong;
    private javax.swing.JTextField txt_dongiadichvu;
    private javax.swing.JTextField txt_dongiadien;
    private javax.swing.JTextField txt_dongianuoc;
    private javax.swing.JTextField txt_matienphong;
    private javax.swing.JTextField txt_sodien;
    private javax.swing.JTextField txt_sonuoc;
    private javax.swing.JTextField txt_thoaigianketthuc;
    private javax.swing.JTextField txt_thoigianbatdau;
    private javax.swing.JTextField txt_tienphong;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JTextField txt_tkThongKe;
    private javax.swing.JTextField txt_tongtien;
    // End of variables declaration//GEN-END:variables
}
