package com.zkai.financial.db;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageHelper;

@Configuration
@EnableTransactionManagement
@AutoConfigureAfter(WriteMybatisConfig.class)
public class ReadMybatisConfig implements EnvironmentAware {

	// 从库数据源
	@Resource(name = "readDataSource")
	private DataSource readDataSource;

	private RelaxedPropertyResolver mybatisPropertyResolver;

	/**
	 * 日志记录器
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ReadMybatisConfig.class);

	/**
	 * 获取配置信息
	 *  
	 * @param environment
	 */
	@Override
	public void setEnvironment(Environment environment) {
		this.mybatisPropertyResolver = new RelaxedPropertyResolver(environment, "mybatis.");
	}

	/**
	 * 只读sqlSessionFactory
	 * 
	 * @return
	 */
	@Bean(name = "readSqlSessionFactory")
	public SqlSessionFactory readSqlSessionFactory() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(readDataSource);
		bean.setTypeAliasesPackage(mybatisPropertyResolver.getProperty("typeAliasesPackage"));

		// 分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		pageHelper.setProperties(properties);
		bean.setPlugins(new Interceptor[] { pageHelper });

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

}