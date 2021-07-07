package lesson3.examplebook.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan("lesson3.examplebook")
@PropertySource("lesson3/db-configure.properties")
@EnableTransactionManagement
public class ConfigExample {

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

    public Properties properties(){

        final Properties props = new Properties();
        props.put("hibernate.show_sql", "${hibernate.show_sql}");
        props.put("hibernate.format_sql","${hibernate.format_sql}");
        props.put("hibernate.dialect","${hibernate.dialect}");
        props.put("hibernate.hbm2ddl.auto", "${hibernate.hbm2ddl.auto}");
        return props;
    }

    @Bean
    @DependsOn("dataSource")
    public SessionFactory sessionFactory(
            final DataSource dataSource
    ) throws IOException {

        LocalSessionFactoryBean sessionFactoryBean =
                new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan("lesson3.examplebook");
        sessionFactoryBean.setHibernateProperties(properties());
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    @Bean
    @DependsOn("sessionFactory")
    public PlatformTransactionManager transactionManager(final SessionFactory sessionFactory){
        return new HibernateTransactionManager(sessionFactory);
    }
}
