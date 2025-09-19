package org.develcorp.learn.library.infrastructure.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import lombok.Getter;

/**
 * Singleton class for managing database connections using R2DBC.
 * This class provides a connection pool for efficient database access.
 */
@Getter
public class DatabaseConnection {

    private final ConnectionPool connectionPool;

    private DatabaseConnection(DatabaseConfig databaseConfig) {
        ConnectionFactory connectionFactory = ConnectionFactories.get(ConnectionFactoryOptions.builder()
            .option(ConnectionFactoryOptions.DRIVER, databaseConfig.getDriver())
            .option(ConnectionFactoryOptions.PROTOCOL, databaseConfig.getProtocol())
            .option(ConnectionFactoryOptions.DATABASE, databaseConfig.getDatabase())
            .build());

        ConnectionPoolConfiguration configuration = ConnectionPoolConfiguration.builder(connectionFactory)
            .maxIdleTime(java.time.Duration.ofMinutes(30)) // Maximum idle time
            .maxSize(10)
            .build();

        this.connectionPool = new ConnectionPool(configuration);
    }
    
    private static class Holder {
        private static final ApplicationContext CONTEXT = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        private static final DatabaseConnection INSTANCE = new DatabaseConnection(CONTEXT.getBean(DatabaseConfig.class));
    }

    public static DatabaseConnection getInstance() {
        return Holder.INSTANCE;
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    public void close() {
        connectionPool.dispose();
    }
}