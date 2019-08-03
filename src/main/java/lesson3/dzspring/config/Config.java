package lesson3.dzspring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@ComponentScan("lesson3.dzspring")
@PropertySource("classpath:lesson3/db-configure.properties")
@EnableTransactionManagement
public class Config {

    @Bean
    public DataSource dataSource(
            @Value("${datasource.driver}") final String dataSourceDriver,
            @Value("${datasource.url}") final String dataSourceUrl,
            @Value("${datasource.user}") final String dataSourceUser,
            @Value("${datasource.password}") final String dataSourcePassword
    ){
        final DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(dataSourceDriver);
        driverManagerDataSource.setUrl(dataSourceUrl);
        driverManagerDataSource.setUsername(dataSourceUser);
        driverManagerDataSource.setPassword(dataSourcePassword);
        return driverManagerDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            final DataSource dataSource,
            @Value("${hibernate.show_sql}") final String strShowSql,
            @Value("${hibernate.format_sql}") final String strFormatSql,
            @Value("${hibernate.dialect}") final String strDialect,
            @Value("${hibernate.hbm2ddl.auto}") final String strAuto
    ){

        final LocalContainerEntityManagerFactoryBean factoryBean;
        factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setPackagesToScan("lesson3.dzspring");
        final Properties props = new Properties();
        props.put("hibernate.show_sql", strShowSql);
        props.put("hibernate.format_sql",strFormatSql);
        props.put("hibernate.dialect",strDialect);
        props.put("hibernate.hbm2ddl.auto", strAuto);
        factoryBean.setJpaProperties(props);
        return factoryBean;
    }

    /**
     * Автоматическое оформления транзакций (в паре с @EnableTransactionManagement)
     * */
    @Bean
    public PlatformTransactionManager transactionManager(
            final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){

        final JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());
        return jpaTransactionManager;
    }
}
