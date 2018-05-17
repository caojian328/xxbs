package com.zkai.financial.db;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisMapperScannerConfig {

	/**
	 * 扫描读写模式-mapper,只有在basePackage包下且继承自BaseWriterMapper的mapper才会被扫描到
	 * @return
	 */ 
	@Bean(name = "writeMapperScanner")
	public MapperScannerConfigurer writeMapperScanner(){
		
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setBasePackage("com.zkai.financial.dao");
		configurer.setMarkerInterface(BaseWriteMapper.class);
		configurer.setSqlSessionFactoryBeanName("writeSqlSessionFactory");
		
		return configurer;
	}

	/**
	 * 扫描只读模式-mapper,只有在basePackage包下且继承自BaseReadMapper的mapper才会被扫描到
	 * @return
	 */
	@Bean(name = "readMapperScanner")
	public MapperScannerConfigurer readMapperScanner(){
		
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setBasePackage("com.zkai.financial.dao");
		configurer.setMarkerInterface(BaseReadMapper.class);
		configurer.setSqlSessionFactoryBeanName("readSqlSessionFactory");
		
		return configurer;
	}
}
