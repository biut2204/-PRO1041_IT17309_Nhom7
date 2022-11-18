package HibernateUntils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Models.ChiTietTienPhong;
import Models.ChuNha;
import Models.DichVu;
import Models.HopDong;
import Models.NguoiThue;
import Models.NhaTro;
import Models.Phong;
import Models.SuCoKH;
import Models.SuCoNhaTro;
import Models.TaiKhoan;
import Models.TienPhong;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author admin
 */
public class HibernateUtils {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=DUAN1_Nhom8");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "220401");
        properties.put(Environment.SHOW_SQL, "true");   
        //gen DB t? �?ng
        //properties.put(Environment.HBM2DDL_AUTO, "create");

        conf.setProperties(properties);
        conf.addAnnotatedClass(TaiKhoan.class);
        conf.addAnnotatedClass(ChuNha.class);
        conf.addAnnotatedClass(NguoiThue.class);
        conf.addAnnotatedClass(NhaTro.class);
        conf.addAnnotatedClass(Phong.class);
        conf.addAnnotatedClass(SuCoNhaTro.class);
        conf.addAnnotatedClass(DichVu.class);
        conf.addAnnotatedClass(SuCoKH.class);
        conf.addAnnotatedClass(TienPhong.class);
        conf.addAnnotatedClass(ChiTietTienPhong.class);
        conf.addAnnotatedClass(HopDong.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }
}
