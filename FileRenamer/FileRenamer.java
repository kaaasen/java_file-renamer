import java.io.File;

public class FileRenamer {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\Kim\\Downloads"; // Replace with the actual folder path

        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            renameFilesAndFolders(folder);
        } else {
            System.out.println("Invalid folder path.");
        }
    }

    private static void renameFilesAndFolders(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String newFileName = fileName.replaceAll("\\.(?!\\w+$)", "_").replaceAll(" ", "_").toLowerCase();
                    File newFile = new File(file.getParentFile(), newFileName);

                    if (file.renameTo(newFile)) {
                        System.out.println("Renamed: " + fileName + " -> " + newFileName);
                    } else {
                        System.out.println("Failed to rename: " + fileName);
                    }
                }
                if (file.isDirectory()) {
                    String folderName = file.getName();
                    String newFolderName = folderName.replaceAll("\\.(?!\\w+$)", "_").replaceAll(" ", "_").toLowerCase();
                    File newFolder = new File(file.getParentFile(), newFolderName);

                    if (file.renameTo(newFolder)) {
                        System.out.println("Renamed folder: " + folderName + " -> " + newFolderName);
                    } else {
                        System.out.println("Failed to rename folder: " + folderName);
                    }
                }
            }
        }
    }
}
