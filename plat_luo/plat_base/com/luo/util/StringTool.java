package com.luo.util;

import java.util.UUID;

public class StringTool {

	public static String createPK() {
		UUID uuid =UUID.randomUUID();
		return uuid.toString();
	}

}
