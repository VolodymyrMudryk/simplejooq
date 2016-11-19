package com.mudryk.simplejooq.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

@Configuration
public class JooqConfiguration {

    public DefaultConfiguration defaultConfiguration(Settings settings, DataSourceConnectionProvider dataSourceConnectionProvider) {
        DefaultConfiguration defaultConfiguration = new DefaultConfiguration();
        defaultConfiguration.set(settings);
        defaultConfiguration.set(dataSourceConnectionProvider);
        defaultConfiguration.set(SQLDialect.MYSQL);
        return defaultConfiguration;
    }

    @Bean
    public TransactionAwareDataSourceProxy transactionAwareDataSource(DataSource dataSource) {
        return new TransactionAwareDataSourceProxy(dataSource);
    }

    @Bean
    public DataSourceConnectionProvider connectionProvider(TransactionAwareDataSourceProxy transactionAwareDataSource) {
        return new DataSourceConnectionProvider(transactionAwareDataSource);
    }

    @Bean
    public DefaultDSLContext dslContext(Settings jooqSettings, DataSourceConnectionProvider dataSourceConnectionProvider) {
        return new DefaultDSLContext(defaultConfiguration(jooqSettings, dataSourceConnectionProvider));
    }

    @Bean
    public Settings jooqSettings() {
        Settings settings = new Settings();
        settings.setRenderSchema(false);
        return settings;
    }
}
