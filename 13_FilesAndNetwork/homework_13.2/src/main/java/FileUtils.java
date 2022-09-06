import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        // TODO: write code copy content of sourceDirectory to destinationDirectory

        File sourceFile = new File(sourceDirectory);
        File[] sourceFolder = sourceFile.listFiles();
        if (!sourceFile.isDirectory() || !sourceFile.exists()) {
            System.out.println("Исходная папка не существует");
        }
        File destinationFile = new File(destinationDirectory);

        if (!destinationFile.exists()){
            destinationFile.mkdir();
            System.out.println("Папка " + destinationDirectory + " не существует." +
                    " Папка была создана");
        }

        for (int i = 0; i < Objects.requireNonNull(sourceFolder).length; i++) {
            if (sourceFolder[i].isFile()) {
                try {
                    FileInputStream fis = new FileInputStream(sourceFolder[i]);
                    FileOutputStream out = new FileOutputStream(destinationFile
                            .getPath()
                            + File.separator + sourceFolder[i].getName());
                    int count = fis.available();
                    byte[] data = new byte[count];
                    if ((fis.read(data)) != -1) {
                        out.write(data);
                    }
                    out.close();
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (sourceFolder[i].isDirectory()) {
                File des = new File(destinationFile.getPath() + File.separator
                        + sourceFolder[i].getName());
                des.mkdir();
                copyFolder(sourceFolder[i].getAbsolutePath(), des.getAbsolutePath());
            }
        }
    }
}
