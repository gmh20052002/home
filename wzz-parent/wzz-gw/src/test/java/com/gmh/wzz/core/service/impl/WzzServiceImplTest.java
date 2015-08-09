package com.gmh.wzz.core.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;
import com.gmh.wzz.api.service.WzzService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mybatis.xml" })
public class WzzServiceImplTest {
    @Autowired
    ApplicationContext ctx;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindWzzBusinessClass() {
		
		WzzService wzzService = (WzzService)ctx.getBean("wzzService");
		try {
			WzzBusinessClassEntity condition = new WzzBusinessClassEntity();
//			condition.setName("xxx");
			Page<WzzBusinessClassEntity> results = wzzService.findWzzBusinessClass(condition, 1, 10);
			
			System.out.println(results);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
