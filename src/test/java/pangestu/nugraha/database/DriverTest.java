package pangestu.nugraha.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTest {

    @Test
    void testRegister1() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            //Registrasikan mysqlDriver dengan DriverManager.resgterDriver
            DriverManager.registerDriver(mysqlDriver);
        }catch (SQLException exception){
            Assertions.fail(exception); //Jika terjadi error
        }
    }
}
/*
Setiap kali ketika ingin membuat aplikasi yang terhubung dengan database harus meregristrasi Driver
terlebih dahulu. Contohnya seperti diatas. WAJIB!
 */
