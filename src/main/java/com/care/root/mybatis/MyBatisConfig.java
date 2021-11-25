package com.care.root.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = { "com.care.root.dao" })
public class MyBatisConfig {
	@Bean
	public SqlSessionFactory seqSessionFactory(DataSource ds) throws Exception {	//datasource : .yaml에서 얻어온 데이터소스
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setDataSource(ds);
		return sf.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sf) {
		return new SqlSessionTemplate(sf);
	}
}
