package org.springframework.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: doudou
 * @since: 2021-10-19
 */
public class MainClass4 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
		for (Integer integer: list) {
			System.out.println(integer);
		}
	}

}
