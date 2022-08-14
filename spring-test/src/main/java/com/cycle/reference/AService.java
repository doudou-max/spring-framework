package com.cycle.reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: doudou
 * @since: 2022-08-13
 */
@Service
public class AService {

	@Autowired
	private BService bService;

	public void aSay() {
		System.out.println("i am a");
	}

	public void bSay() {
		bService.bSay();
	}

}
