package gui;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class BookFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if(f.isDirectory()) {
            return true;
        }

        String name = f.getName();

        String extension = Utils.getFileExtension(name);

        if(extension == null) {
            return false;
        }

        if(extension.equals("ber")) {
            return true;
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "Library database files (*.ber)";
    }
}
