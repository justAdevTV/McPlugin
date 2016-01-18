package com.rhota.mcplugin.utility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DebugUtility {
	public static StackTraceElement getCallingClass() {
		Class c = new Object(){}.getClass().getEnclosingClass();
		String q = Arrays.stream(new Object(){}.getClass().getEnclosingClass().getName().split("\\."))
                .limit(2)
                .collect(Collectors.joining("."));
        return Arrays.stream(Thread.currentThread().getStackTrace())
				.filter((s) -> s.toString().startsWith(q) && !s.toString().startsWith(c.getName()))
                .collect(Collectors.toList())
				.get(0);
	}

	public static void toConsole(Object... message) {
		StringBuilder s = new StringBuilder();
		StackTraceElement q = getCallingClass();
		String[] w = q.getClassName().split("\\.");
		s.append("From ")
			.append(w[w.length - 1])
			.append("#")
			.append(q.getMethodName())
			.append(":")
			.append(q.getLineNumber())
			.append(": ");
		for (Object o : message) {
			s.append(o.toString());
		}
		System.out.println(s.toString());
	}
}
