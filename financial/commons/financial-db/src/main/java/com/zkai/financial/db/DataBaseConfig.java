package com.zkai.financial.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig implements EnvironmentAware {

	private RelaxedPropertyResolver dbPropertyResolver;
 
	
	@Override
	public void setEnvironment(Environment environment) {
		this.dbPropertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
	}

	/**
	 * 写库
	 * 
	 * @return
	 */
	@Primary
	@Bean(name = "writeDataSource", destroyMethod = "close", initMethod = "init")
	public DataSource writeDataSource() {
		
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(dbPropertyResolver.getProperty("master.url"));
		datasource.setDriverClassName(dbPropertyResolver.getProperty("master.driver"));
		datasource.setUsername(dbPropertyResolver.getProperty("master.username"));
		datasource.setPassword(dbPropertyResolver.getProperty("master.password"));
		
		return datasource;
	}

	/**
	 * 读库
	 * 
	 * @return
	 */
	@Bean(name = "readDataSource", destroyMethod = "close", initMethod = "init")
	public DataSource readOneDataSource() {
		
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(dbPropertyResolver.getProperty("slave.url"));
		datasource.setDriverClassName(dbPropertyResolver.getProperty("slave.driver"));
		datasource.setUsername(dbPropertyResolver.getProperty("slave.username"));
		datasource.setPassword(dbPropertyResolver.getProperty("slave.password"));
		
		return datasource;
	}
}
