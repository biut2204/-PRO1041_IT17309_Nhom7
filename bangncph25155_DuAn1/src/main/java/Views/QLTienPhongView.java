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
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import jdk.jshell.spi.ExecutionControl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
    private DefaultComboBoxModel dccbm;

    /**
     * Creates new form QLPhongView
     */
    public QLTienPhongView() {
        initComponents();
        LoadTienPhong(tpR.getAllData());
        LoadDichVuPhong(dvpR.getAllData());
        LoadChiTietTienPhong(cttpR.getAllData());
        LoadThongKe(cttpR.getAllData());
        rdTinhTrang();
        loadDSPhong(tprepo.listPhong("Đã có người thuê"));
        Anh();
    }
    
    private void Anh(){
        Icon icon1 = new ImageIcon("delete.png");
        this.lbl_anhsodien.setIcon(icon1);
        this.lbl_anhsonuoc.setIcon(icon1);
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

    public void loadDSPhong(List<String> list) {
        dccbm = (DefaultComboBoxModel) cb_danhsachphong.getModel();
        cb_danhsachphong.removeAllItems();
        for (String string : list) {
            dccbm.addElement(string);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        btn_taonhanh = new javax.swing.JButton();
        cb_danhsachphong = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_thongke = new javax.swing.JTable();
        txt_tkThongKe = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        cb_ThongKe = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        cb_thang = new javax.swing.JComboBox<>();
        cb_nam = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_tongtienchuathu = new javax.swing.JTextField();
        txt_tongtiendathu = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cb_TKthang = new javax.swing.JComboBox<>();
        cb_TKnam = new javax.swing.JComboBox<>();
        btn_thongketheothang = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txt_tongdoanhthu = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        btn_thongketheonam = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_chiphiscnt = new javax.swing.JTextField();
        txt_chiphisckh = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        btn_tao1.setText("Tao thu cong");
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        btn_taonhanh.setText("Tao nhanh");
        btn_taonhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taonhanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_tao1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cb_danhsachphong, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_taonhanh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
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
                .addContainerGap(54, Short.MAX_VALUE))
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
                        .addContainerGap(86, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_tao1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_taonhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_danhsachphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        cb_ThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Da thanh toan", "chua thanh toan" }));

        jButton4.setText("Loc");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cb_thang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cb_nam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));

        jLabel11.setText("Tong tien chua thu :");

        jLabel12.setText("Tong tien da thu :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("Thong ke ");

        cb_TKthang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cb_TKnam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Năm", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));

        btn_thongketheothang.setText("Thong ke theo thang");
        btn_thongketheothang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongketheothangActionPerformed(evt);
            }
        });

        jLabel14.setText("Tong doanh thu :");

        jButton5.setText("Exprot Excel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btn_thongketheonam.setText("Thong ke theo nam");
        btn_thongketheonam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongketheonamActionPerformed(evt);
            }
        });

        jLabel15.setText("Chi phi sua su co nha :");

        jLabel16.setText("Chi phi sua chua phong :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(cb_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(cb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txt_tkThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jButton2))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_tongtienchuathu, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_tongtiendathu, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                                            .addComponent(txt_tongdoanhthu))))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_chiphisckh, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(txt_chiphiscnt))))
                        .addContainerGap(183, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(cb_TKthang, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(cb_TKnam, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btn_thongketheothang)
                                .addGap(18, 18, 18)
                                .addComponent(btn_thongketheonam, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButton5)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(txt_tkThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(cb_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_TKthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_TKnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_thongketheothang)
                    .addComponent(jButton5)
                    .addComponent(btn_thongketheonam))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_tongtienchuathu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txt_chiphiscnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_tongtiendathu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txt_chiphisckh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_tongdoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1369, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 85, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 85, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
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
        String dien = "Tien dien";
        String nuoc = "Tien nuoc";
        txt_tienphong.setText(String.valueOf(tpR.findTienPhong(phong)));
        txt_dongiadichvu.setText(String.valueOf(tpR.TongDichVu(phong) - tpR.Dien(dien) - tpR.Nuoc(nuoc)));
        txt_dongiadien.setText(String.valueOf(tpR.Dien(dien)));
        txt_dongianuoc.setText(String.valueOf(tpR.Nuoc(nuoc)));

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

            String ma = "HD" + String.valueOf(tpR.DemTienPhong() + 1);
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
                    JOptionPane.showMessageDialog(this, "tháng - " + a1 + " năm -  " + b1 + " phòng - " + tenphong + " đã có hóa đơn ");
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
            String macttp = "CTTP" + String.valueOf(cttpR.DemCttp() + 1);
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

    private ChiTietTienPhong chiTietTienPhong() throws ParseException {
        TienPhong tp = new TienPhong();

        String ma = txt_matienphong.getText().toString();
        int index = tb_chitiettienphong.getRowCount() + 1;
        String macttp = "CTTP" + String.valueOf(index);
        int sodien = Integer.parseInt(txt_sodien.getText().toString());
        int sonuoc = Integer.parseInt(txt_sonuoc.getText().toString());
        int dongiadien = Integer.parseInt(txt_dongiadien.getText().toString());
        int dongianuoc = Integer.parseInt(txt_dongianuoc.getText().toString());
        int dichvu = Integer.parseInt(txt_dongiadichvu.getText().toString());
        Date ngaybatdau = sdf.parse(txt_thoigianbatdau.getText().trim());
        Date ngayhethan = sdf.parse(txt_thoigianbatdau.getText().trim());
        int tienphong = Integer.parseInt(txt_tienphong.getText().toString());
        int tongtien = Integer.parseInt(txt_tongtien.getText().toString());
        UUID id = tpR.findByIdChiTietTienPhong(ma);

        UUID idtienphong = tpR.findByIdTienPhong(ma);
        tp.setId(idtienphong);

        ChiTietTienPhong cttp = new ChiTietTienPhong(id, tp, dichvu, ma, dongiadien, dongianuoc, dongiadien, dongianuoc, ngaybatdau, ngayhethan, tongtien, hinhdien, hinhnuoc);
        return cttp;
    }

    private void btn_suatienphongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suatienphongActionPerformed

        try {
            // TODO add your handling code here:
            ChiTietTienPhong cttp = chiTietTienPhong();
            String ma = txt_matienphong.getText().toString();
            cttp.setId(tpR.findByIdChiTietTienPhong(ma));

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dmt = (DefaultTableModel) tb_thongke.getModel();
        String search = cb_ThongKe.getSelectedItem().toString();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmt);
        tb_thongke.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

        DefaultTableModel dmt1 = (DefaultTableModel) tb_thongke.getModel();
        String a = cb_thang.getSelectedItem().toString();
        String b = cb_nam.getSelectedItem().toString();
        String search1 = b + "-" + a;
        TableRowSorter<DefaultTableModel> tr1 = new TableRowSorter<DefaultTableModel>(dmt1);
        tb_thongke.setRowSorter(tr1);
        tr1.setRowFilter(RowFilter.regexFilter(search1));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_taonhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taonhanhActionPerformed
        try {
            Date ngaytao = sdf.parse(JOptionPane.showInputDialog("Ngay tao :"));
            // TODO add your handling code here:
            for (int i = 0; i <= 10; i++) {
                TienPhong tp = new TienPhong();
                Phong p = new Phong();

                String ma = "HD" + String.valueOf(tpR.DemTienPhong() + 1);
                String tenphong = cb_danhsachphong.getItemAt(i);
                String trangthai = "chua thanh toan";

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
                        JOptionPane.showMessageDialog(this, "tháng - " + a1 + " năm -  " + b1 + " phòng - " + tenphong + " đã có hóa đơn ");
                    }
                } catch (Exception e) {
                    tp.setNgayTao(ngaytao);
                    tp.setMa(ma);
                    tp.setPhong(p);
                    tp.setTrangThai(trangthai);
                    tpR.save(tp);
                    LoadTienPhong(tpR.getAllData());
                }

            }
        } catch (ParseException ex) {
            Logger.getLogger(QLTienPhongView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_taonhanhActionPerformed

    private void btn_thongketheothangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongketheothangActionPerformed
        // TODO add your handling code here:
        if (cb_TKthang.getSelectedItem().toString() == "Tháng" || cb_TKnam.getSelectedItem().toString() == "Năm") {
            JOptionPane.showMessageDialog(this, "Chua chon thoi gian thong ke");
            return;
        } else {
            String a = "chua thanh toan";
            String b = "Da thanh toan";
            int thang = Integer.parseInt(cb_TKthang.getSelectedItem().toString());
            int nam = Integer.parseInt(cb_TKnam.getSelectedItem().toString());
            txt_tongtienchuathu.setText(String.valueOf(tpR.ThongKe(a, thang, nam)));
            txt_tongtiendathu.setText(String.valueOf(tpR.ThongKe(b, thang, nam)));
            txt_tongdoanhthu.setText(String.valueOf(tpR.ThongKeTong(thang, nam)));
            txt_chiphisckh.setText(String.valueOf(tpR.ThongKeThangSckh(thang, nam)));
            txt_chiphiscnt.setText(String.valueOf(tpR.ThongKeThangScnt(thang, nam)));
        }
    }//GEN-LAST:event_btn_thongketheothangActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        In();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_thongketheonamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongketheonamActionPerformed
        // TODO add your handling code here:
        if (cb_TKnam.getSelectedItem().toString() == "Năm") {
            JOptionPane.showMessageDialog(this, "Chua chon thoi gian thong ke");
            return;
        } else {
            String a = "chua thanh toan";
            String b = "Da thanh toan";
            int nam = Integer.parseInt(cb_TKnam.getSelectedItem().toString());
            txt_tongtienchuathu.setText(String.valueOf(tpR.ThongKeTheoNam(a, nam)));
            txt_tongtiendathu.setText(String.valueOf(tpR.ThongKeTheoNam(b, nam)));
            try {
                txt_tongdoanhthu.setText(String.valueOf(tpR.ThongKeTheoNamTong(nam).toString()));
            } catch (Exception e) {
                txt_tongdoanhthu.setText("null");
            }
            txt_chiphisckh.setText(String.valueOf(tpR.ThongKeNamSckh(nam)));
            txt_chiphiscnt.setText(String.valueOf(tpR.ThongKeNamScnt(nam)));
        }
    }//GEN-LAST:event_btn_thongketheonamActionPerformed
    private void In() {
        //ArrayList<ChiTietTienPhong> cttp = new ArrayList<ChiTietTienPhong>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Danh sach");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(3);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Phong");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Ngay thanh toan");
            
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Thanh tien");
            
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Trang thai");

            for (int i = 0; i < cttpR.getAllData().size(); i++) {
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(cttpR.getAllData().get(i).getTienPhong().getPhong().getTenPhong());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(sdf.format(cttpR.getAllData().get(i).getTienPhong().getNgayThanhToan()));

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(cttpR.getAllData().get(i).getDonGia());
                
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(cttpR.getAllData().get(i).getTienPhong().getTrangThai());
            }
            
            File f = new File("C://Users//MSI//Documents//Duan1//test.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);
                workbook.write(fis);
                fis.close();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        JOptionPane.showMessageDialog(this, "thanh cong");
    }

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
    private javax.swing.JButton btn_taonhanh;
    private javax.swing.JButton btn_taotienphong;
    private javax.swing.JButton btn_thongketheonam;
    private javax.swing.JButton btn_thongketheothang;
    private javax.swing.JComboBox<String> cb_TKnam;
    private javax.swing.JComboBox<String> cb_TKthang;
    private javax.swing.JComboBox<String> cb_ThongKe;
    private javax.swing.JComboBox<String> cb_danhsachphong;
    private javax.swing.JComboBox<String> cb_nam;
    private javax.swing.JComboBox<String> cb_thang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel lbl_anhsodien;
    private javax.swing.JLabel lbl_anhsonuoc;
    private javax.swing.JRadioButton rd_chuadongtien;
    private javax.swing.JRadioButton rd_daongtien;
    private javax.swing.JRadioButton rd_tatca;
    private javax.swing.JTable tb_bangdichvuphong;
    private javax.swing.JTable tb_chitiettienphong;
    private javax.swing.JTable tb_thongke;
    private javax.swing.JTable tb_tienphong;
    private javax.swing.JTextField txt_chiphisckh;
    private javax.swing.JTextField txt_chiphiscnt;
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
    private javax.swing.JTextField txt_tongdoanhthu;
    private javax.swing.JTextField txt_tongtien;
    private javax.swing.JTextField txt_tongtienchuathu;
    private javax.swing.JTextField txt_tongtiendathu;
    // End of variables declaration//GEN-END:variables
}
