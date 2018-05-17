package com.zkai.financial.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
@AutoConfigureAfter
public class WriteMybatisConfig implements EnvironmentAware {

	// 写库
	@Resource(name = "writeDataSource")
	private DataSource writeDataSource;
 
	private RelaxedPropertyResolver mybatisPropertyResolver;

	public static final Logger LOGGER = LoggerFactory.getLogger(WriteMybatisConfig.class);

	
	@Override
	public void setEnvironment(Environment environment) {
		this.mybatisPropertyResolver = new RelaxedPropertyResolver(environment, "mybatis.");
	}

	/**
	 * 可读可写sqlSessionFactory
	 * 
	 * @return
	 */
	@Bean(name = "writeSqlSessionFactory")
	public SqlSessionFactory writeSqlSessionFactory() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(writeDataSource);
		bean.setTypeAliasesPackage(mybatisPropertyResolver.getProperty("typeAliasesPackage"));

		// 分页插件
		/*
		 * PageHelper pageHelper = new PageHelper(); Properties properties = new
		 * Properties(); properties.setProperty("reasonable", "true");
		 * properties.setProperty("supportMethodsArguments", "true");
		 * properties.setProperty("returnPageInfo", "check");
		 * properties.setProperty("params", "count=countSql");
		 * pageHelper.setProperties(properties); bean.setPlugins(new
		 * Interceptor[]{pageHelper});
		 */

		// 添加mybatis配置文件
		PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
		bean.setConfigLocation(resourceResolver.getResource(mybatisPropertyResolver.getProperty("configLocation")));
		try {
			bean.setMapperLocations(
					resourceResolver.getResources(mybatisPropertyResolver.getProperty("mapperLocations")));
			return bean.getObject();
		} catch (IOException e) {
			LOGGER.error("获取mapper资源出现异常", e);
			throw new RuntimeException("获取mapper资源出现异常", e);
		} catch (Exception e) {
			LOGGER.error("初始化sqlSessionFactory时出现异常", e);
			throw new RuntimeException("初始化sqlSessionFactory时出现异常", e);
		}
	}

	
	/**
	 * 因为当前项目中有
	 * 
	 * @return
	 */
	@Bean(name = "writeTransactionManager")
	public DataSourceTransactionManager writeTransactionManager() {
		return new DataSourceTransactionManager(writeDataSource);
	}

	
	@Bean
	@ConditionalOnMissingBean
	public SqlSessionTemplate sqlSessionTemplate() {
		return new SqlSessionTemplate(writeSqlSessionFactory());
	}
	
}