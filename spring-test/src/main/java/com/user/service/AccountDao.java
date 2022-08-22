package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author: doudou
 * @since: 2022-08-11
 */
@Repository
public class AccountDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save() {
		jdbcTemplate.execute("INSERT INTO `mp`.`user`(`id`, `name`, `age`, `email`, `manager_id`, `create_time`, `update_time`, `version`, `deleted`) VALUES (777777, 'doudou', 40, 'boss@baomidou.com', NULL, 20190111142020, NULL, 1, 0);");
	}

}
