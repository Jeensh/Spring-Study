package hello.jdbc.connection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import hello.jdbc.connection.ConnectionConst.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import static hello.jdbc.connection.ConnectionConst.*;

@Slf4j
public class ConnectionTest {
    @Test
    void driverManager() throws SQLException {
        Connection con1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Connection con2 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        log.info("connection={}, class{}", con1, con1.getClass());
        log.info("connection={}, class{}", con1, con1.getClass());
    }

    @Test
    void dataSourceDriverManager() {
        //DriverManagerDataSource - 항상 새로운 커넥션을 획득
        DataSource datasource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
    }

    private void useDataSource(DataSource dataSource) throws SQLException {
        Connection con1 = dataSource.getConnection();
        Connection con2 = dataSource.getConnection();
        log.info("connection={}, class{}", con1, con1.getClass());
        log.info("connection={}, class{}", con1, con1.getClass());
    }
}
