/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neck.neck;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FolderZipper {

  public void zipFolder(String srcFolder, String destZipFile) throws Exception {
    ZipOutputStream zip = null;
    FileOutputStream fileWriter = null;

    fileWriter = new FileOutputStream(destZipFile);
    zip = new ZipOutputStream(fileWriter);

    addFolderToZip("", srcFolder, zip);
    zip.flush();
    zip.close();
  }

  static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
      throws Exception {

    File folder = new File(srcFile);
    if (folder.isDirectory()) {
      addFolderToZip(path, srcFile, zip);
    } else {
      byte[] buf = new byte[1024];
      int len;
      FileInputStream in = new FileInputStream(srcFile);
      zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
      while ((len = in.read(buf)) > 0) {
        zip.write(buf, 0, len);
      }
      in.close();
    }
  }

  static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
      throws Exception {
    File folder = new File(srcFolder);

    for (String fileName : folder.list()) {
      if (path.equals("") && fileName.endsWith(".log")) {
        addFileToZip("", srcFolder + "/" + fileName, zip);
      }
    }
  }
}
