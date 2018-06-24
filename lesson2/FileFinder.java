package lesson2;

import java.io.File;
import java.util.ArrayList;

public class FileFinder {
    private ArrayList<File> files = new ArrayList<File>();

    public void fileFinder(File folder) {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                fileFinder(entry);
                continue;
            } else {
                files.add(entry);
                // System.out.println(entry.getPath());
            }
        }

    }

    public ArrayList<File> getFiles() {
        return files;
    }
}
