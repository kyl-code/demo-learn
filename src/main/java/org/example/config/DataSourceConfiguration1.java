package org.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Author Adam_Guo
 * @Date 2020/4/25
 * @Version 1.0
 **/
//@Configuration
//@MapperScan(basePackages = "org.example.dao.test1", sqlSessionFactoryRef = "test1SqlSessionFactory")
public class DataSourceConfiguration1 {
/*    @Bean
    @ConfigurationProperties("test1.datasource")
    @Primary
    public DataSourceProperties test1DataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource test1DataSource(){
        DataSourceProperties dataSourceProperties = test1DataSourceProperties();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }*/

/*    @Bean
    @Resource
    @Primary
    public PlatformTransactionManager test1TxManager(DataSource test1DataSource){
        return new DataSourceTransactionManager(test1DataSource);
    }*/

    @Bean(name = "test1SqlSessionFactory")
    @Primary
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("test1DataSource") DataSource test1DataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(test1DataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:org.example.dao.test1"));
        return sessionFactory.getObject();
    }

}
