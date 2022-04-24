package com.example.springdemo.springassignment.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.springdemo.springassignment")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

    //setup variable to hold the properties
    @Autowired
    private Environment env; //hold data read from property files

    //setup a logger
    private Logger logger=Logger.getLogger(getClass().getName());

    @Bean
    public DataSource securityDataSource(){
        //create connection pool
        ComboPooledDataSource securityDataSource=new ComboPooledDataSource();

        // set the jdbc driver class
        try {
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        //log the connection props
        logger.info(">>>jdbc.driver---"+env.getProperty("jdbc.url"));
        logger.info(">>>jdbc.user---"+env.getProperty("jdbc.user"));

        //set database connection props
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));


        //set connection pool props
        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));

        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));

        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));

        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    // need a helper method
    // read environment property and convert to int
    private int getIntProperty(String propName){
        String propVal=env.getProperty(propName);

        //now convert to int
        return  Integer.parseInt(propVal);
    }

}
