package pangestu.nugraha.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

    /*
    Cara membuat Pool menggunaka HikariCP
     */

    @Test
    void testHikariCP() {
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://HOST:PORT:Nama_Table_Database?ServerTimezone=Asia/Jakarta");
        config.setUsername("root");
        config.setPassword("root");

        config.setMaximumPoolSize(10); //Contoh maksimal pool yang terbuka
        config.setMinimumIdle(5); //Contoh minimum pool yang tersedia ketika pool tidak terpakai
        config.setIdleTimeout(60_000); //Contoh maksimal waktu pool yang terbuka ketika tidak terpakai 60detik
        config.setMaxLifetime(10 * 60_000); //Cotoh maksimal pool yang terpakai selama 10 menit

        try {
            HikariDataSource dataSource = new HikariDataSource(config);
            Connection connection = dataSource.getConnection();
            connection.close();
            dataSource.close();
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    /*
    Agar lebih mudah. Buat ConnectionUtil kemudian buat confignya, setMaximumPollSize, SetMinimumIdle,
    setidleTimeout, setMaxLifetime
     */

    @Test
    void testUtil() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
    }
}
