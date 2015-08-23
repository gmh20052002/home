package com.gmh.wzz.core.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gmh.wzz.api.entity.Order;
import com.gmh.wzz.api.entity.Page;
import com.gmh.wzz.api.entity.Sort;
import com.gmh.wzz.api.entity.WzzBusinessClassEntity;
import com.gmh.wzz.api.service.WzzService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-servlet.xml" })
public class WzzServiceImplTest {
	@Autowired
	ApplicationContext ctx;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindWzzBusinessClass() {

		WzzService wzzService = (WzzService) ctx.getBean("wzzService");
		try {
			WzzBusinessClassEntity condition = new WzzBusinessClassEntity();
			// condition.setName("xxx");
			Order order = new Order("name", Sort.DESC);
			order.setOrderBy("remark", Sort.DESC);
			Page<WzzBusinessClassEntity> results = wzzService
					.findWzzBusinessClass(condition, order, 1, 10);

			System.out.println(results);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
