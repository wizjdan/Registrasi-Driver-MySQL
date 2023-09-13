package pangestu.nugraha.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    /*
    Untuk membuat connection harus diawali dengan membuat driver terlebih dahulu
     */

 /*
 Contoh 1 untuk membuat Driver
    static {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            //Kemudia registrasikan Driver yang sudah dibuat
            DriverManager.registerDriver(mysqlDriver);
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

  */

    //Contoh ke 2 membuat Driver menggunakan @BeforeAll
    @BeforeAll
    static void beforeAll() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Test
    void testConnection() {
        /*
        String jdbcUrl = "jdbc:mysql://HOST:PORT:Nama_Table_Database";
        String username = "usernamenya";
        String password = "passwordnya";

        Jika mengalami server eror Timezone maka harus ganti serverTimezonenya

        ?ServerTimezone=Asia/Jakarta | Tambahkan setelah nama database

        String jdbcUrl = "jdbc:mysql://HOST:PORT:Nama_Table_Database?ServerTimezone=Asia/Jakarta";

         */
        String jdbcUrl = "jdbc:mysql://localhost:3306:nama_database_table";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("Berhasil terhubung ke Database...");

        } catch (SQLException exception) {
            Assertions.fail(exception);
        }

    }

    @Test
    void testConnectionCloseManual() {
        String jdbcUrl = "jdbc:mysql://localhost:3306:nama_database_table";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("Berhasil terhubung ke Database...");

            connection.close(); //Diwajibkan untuk menutup koneksi database ketika sudah selesai
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void testConnectionCloseAuto() {
        String jdbcUrl = "jdbc:mysql://localhost:3306:nama_database_table";
        String username = "root";
        String password = "root";

        /*
        connection dimasukan ke dala try maka secara otomatis koneksi ke database akan di tutup.
        jadi tidak perlu melakukan connection.Close
         */

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);){

            System.out.println("Berhasil terhubung ke Database...");

        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }
}
