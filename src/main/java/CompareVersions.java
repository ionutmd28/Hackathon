import java.util.Comparator;

public class CompareVersions implements Comparator<FileLines> {

    public int compare(FileLines o1, FileLines o2) {
        return Integer.parseInt(o1.getVersion().replace(".", "")) - Integer.parseInt(o2.getVersion().replace(".", ""));
    }
}
