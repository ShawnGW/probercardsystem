package com.vtest.it.springclouduserservice.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.sql.SQLException;

@Configuration
@MapperScan(value = "com.vtest.it.springclouduserservice.dao.auth",sqlSessionTemplateRef = "sqlSessionTemplate")
public class UserDataBaseConfiguration {
    @Bean(name = "authDataSource",initMethod = "init",destroyMethod = "close")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DruidDataSource getDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        try {
            dataSource.setFilters("stat,log4j,wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
    @Bean("sqlSessionFactory")
    @Primary
    public SqlSessionFactory getSqlSessionFactory(@Autowired @Qualifier("authDataSource") DruidDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/config/*.xml"));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    @Bean("sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate getSqlSessionTemplate(@Autowired @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate sqlSessionTemplate=new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
    @Bean("dataSourceTransactionManager")
    @Primary
    public DataSourceTransactionManager getTransActionManager(@Autowired @Qualifier("authDataSource") DruidDataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
