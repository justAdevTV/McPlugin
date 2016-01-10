package com.rhota.mcplugin.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtility {
	public static List<String> read(Path loc) {
		try {
			return Files.readAllLines(loc);
		} catch (IOException e) {
			DebugUtility.toConsole(e.getMessage());
			return null;
		}
	}
	
	public static List<String> read(String loc) {
		return read(Paths.get(loc));
	}

	public static void recursive_delete(File loc) {
		try {
			/**
			 * Copy pasta from
			 * http://stackoverflow.com/a/8685959
			 */
			Files.walkFileTree(loc.toPath(), new SimpleFileVisitor<Path>()
            {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                        throws IOException
                {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException
                {
                    // try to delete the file anyway, even if its attributes
                    // could not be read, since delete-only access is
                    // theoretically possible
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
                {
                    if (exc == null)
                    {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }
                    else
                    {
                        // directory iteration failed; propagate exception
                        throw exc;
                    }
                }
            });
		} catch (IOException e) {
			DebugUtility.toConsole(e.getMessage());
		}
	}
}
