package task_with_tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PoolConnection.class)
public class PoolConnectionTest {

    @Mock
    Connection conn;
    @Test
    public void createConnectionSucces() throws SQLException{
        PowerMockito.mockStatic(DriverManager.class);
        when(DriverManager.getConnection(anyString(),anyString(),anyString())).thenReturn(conn);
        assertEquals(conn, PoolConnection.createConnection());
    }

    @Test
    public void createConnectionFailure() throws SQLException{
        PowerMockito.mockStatic(DriverManager.class);
        when(DriverManager.getConnection(anyString(),anyString(),anyString())).thenThrow(new SQLException());
        assertEquals(null, PoolConnection.createConnection());
    }

    @Test
    public void getConnection() {
    }
}