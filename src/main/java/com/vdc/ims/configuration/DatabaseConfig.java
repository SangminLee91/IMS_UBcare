package com.vdc.ims.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import com.vdc.ims.common.logger.MybatisInterceptor;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableConfigurationProperties
public class DatabaseConfig {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    // DataSource Main
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfigMain() {
        return new HikariConfig();
    }

    @Bean
    @Primary
    public DataSource DataSourceMain() {
        return new HikariDataSource(hikariConfigMain());
    }

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactoryMain() throws Exception {
        logger.debug("SqlSessionFactory Main Start");

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(DataSourceMain());

        //mybatis mapper
        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/**/*.xml");
        factoryBean.setMapperLocations(res);

        //mybatis interceptor
        factoryBean.setPlugins(new MybatisInterceptor());

        return factoryBean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionMain() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryMain());
    }


    // DataSource Sub
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari2")
    public HikariConfig hikariConfigSub() {
        return new HikariConfig();
    }

    public DataSource DataSourceSub() {
        return new HikariDataSource(hikariConfigSub());
    }



    @Bean
    public SqlSessionFactory sqlSessionFactorySub() throws Exception {
        logger.debug("SqlSessionFactory Sub Start");

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(DataSourceSub());

        //mybatis mapper
        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/**/*.xml");
        factoryBean.setMapperLocations(res);

        return factoryBean.getObject();
    }
    @Bean
    public SqlSessionTemplate sqlSessionSub() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactorySub());
    }


    @Bean
    public MybatisInterceptor mybatisInterceptor() { return new MybatisInterceptor(); }

}
