package com.zkai.xxbs.db;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class DataSourceAspect{
	
	private List<String> items = new ArrayList<String>();

	public void setItems(List<String> items) {
		this.items = items;
	}

	public void changeDataSource(JoinPoint point)
    {
		
        try {

			String methodName = point.getSignature().getName();

			for(String item : items){

				if(methodName.startsWith(item)){

					DynamicDataSource.putDataSource(DynamicDataSource.SLAVE);

					log.debug(String.format(" 线程(%s:%s) 方法(%s)使用的数据源是：%s", Thread.currentThread().getId(),
							Thread.currentThread().getName(),
							point.getSignature(),
							DynamicDataSource.SLAVE));
					break;

				}else{

					DynamicDataSource.putDataSource(DynamicDataSource.MASTER);

					log.debug(String.format(" 线程(%s:%s) 方法(%s)使用的数据源是：%s", Thread.currentThread().getId(),
							Thread.currentThread().getName(),
							point.getSignature(),
							DynamicDataSource.MASTER));
				}
			}


            
        } catch (Exception e) {
        	log.error("主从数据源切换失败：",e);
        }


    }
}
