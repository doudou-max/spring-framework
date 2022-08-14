package com.cycle.reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: doudou
 * @since: 2022-08-13
 */
@Service
public class BService {

	@Autowired
	private AService aService;

	public void bSay() {
		System.out.println("i am b");
	}

	public void aSay() {
		aService.aSay();
	}

}
