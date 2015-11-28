package com.rhota.mcplugin.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
	public static List<String> read(Path loc) {
		try {
			return Files.lines(loc)
					.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public static List<String> read(String loc) {
		return read(Paths.get(loc));
	}
}
