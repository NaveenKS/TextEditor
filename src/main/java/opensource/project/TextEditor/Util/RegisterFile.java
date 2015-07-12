package opensource.project.TextEditor.Util;

import java.util.HashMap;
import java.util.Map;

public class RegisterFile {

	static Map<Integer, String> fileListMap = new HashMap<Integer, String>();

	public static void addFilePath(int index, String path) {
		fileListMap.put(index, path);
	}

	public static String getFilePath(int index) {
		return fileListMap.get(index);
	}
	
	public static void removeEntry(int index) {
		fileListMap.remove(index);
	}
	
	public static void updateEntry(int index,String path) {
		removeEntry(index);
		addFilePath(index, path);
	}

}
