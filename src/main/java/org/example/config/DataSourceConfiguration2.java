package org.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Author Adam_Guo
 * @Date 2020/4/25
 * @Version 1.0
 **/
//@Configuration
//@MapperScan(basePackages = "org.example.dao.test2",sqlSessionFactoryRef = "test2SqlSessionFactory")
public class DataSourceConfiguration2 {
/*    @Bean
    @ConfigurationProperties("test2.datasource")
    public DataSourceProperties test2DataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource test2DataSource(){
        DataSourceProperties dataSourceProperties = test2DataSourceProperties();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager test2TxManager(DataSource test2DataSource){
        return new DataSourceTransactionManager(test2DataSource());
    }*/

    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("test2DataSource") DataSource test2DataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(test2DataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:org.example.dao.test2"));
        return sessionFactory.getObject();
    }
}
