package pangestu.nugraha.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionUtil {

    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://HOST:PORT:Nama_Table_Database?ServerTimezone=Asia/Jakarta");
        config.setUsername("root");
        config.setPassword("root");

        config.setMaximumPoolSize(10); //Contoh maksimal pool yang terbuka
        config.setMinimumIdle(5); //Contoh minimum pool yang tersedia ketika pool tidak terpakai
        config.setIdleTimeout(60_000); //Contoh maksimal waktu pool yang terbuka ketika tidak terpakai 60detik
        config.setMaxLifetime(10 * 60_000); //Cotoh maksimal pool yang terpakai selama 10 menit

        dataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource() {
        return dataSource;
    }
}
