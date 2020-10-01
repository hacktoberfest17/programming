//Show all files in a specific directory

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;

class showFilesInADirectory {
    static void exibeArquivos(Path pasta) throws IOException {
        DirectoryStream<Path> stream = Files.newDirectoryStream(pasta);
        for (Path file : stream) {
            if (Files.isDirectory(file)){
                System.out.println("\n" + "Pasta encontrada: " + file.getFileName() + "\nConteudo da pasta:" + "\n"); 
                exibeArquivos(file);
            }
            System.out.println(file.getFileName());
        }
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("Your Path");
        exibeArquivos(path);
    }
}
