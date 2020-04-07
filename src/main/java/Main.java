import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public class FileElements {

        String id, cluster, version, user, app, market;

        public FileElements(String id, String cluster, String version, String user, String app, String market) {
            this.id = id;
            this.cluster = cluster;
            this.version = version;
            this.user = user;
            this.app = app;
            this.market = market;
        }

        @Override
        public String toString() {
            return  this.id + "      " +
                    this.cluster + "      " +
                    this.version + "      " +
                    this.user + "      " +
                    this.app + "      " +
                    this.market;
        }
    }
    public static void main(String[] args) {
        try {
            File myObj = new File("D:\\Hackathon\\src\\main\\resources\\inputFile.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> listOfElements = new ArrayList<String>();
            int counter = 6;
            while (myReader.hasNext()) {
                listOfElements.add(myReader.next());
                if(listOfElements.size() == counter) {
                    String version = listOfElements.get(counter - 6);
                    String user = listOfElements.get(counter - 4);
                    String id = listOfElements.get(counter - 3);
                    listOfElements.set(counter-6, id);
                    listOfElements.set(counter-4, version);
                    listOfElements.set(counter-3, user);
                    counter = counter + 6;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The File can't be read");
            e.printStackTrace();
        }
    }
}
