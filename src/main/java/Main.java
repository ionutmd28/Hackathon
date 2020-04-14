import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File myObj = new File("D:\\Hackathon\\src\\main\\resources\\inputFile.txt");
            Scanner myReader = new Scanner(myObj);

            ArrayList<String> listOfElements = new ArrayList<String>();
            ArrayList<FileLines> listOfLines = new ArrayList<FileLines>();
            int counter = 6;

            while (myReader.hasNext()) {
                listOfElements.add(myReader.next());
                if (listOfElements.size() == counter) {
                    String version = listOfElements.get(counter - 6);
                    String cluster = listOfElements.get(counter - 5);
                    String user = listOfElements.get(counter - 4);
                    String id = listOfElements.get(counter - 3);
                    String app = listOfElements.get(counter - 2);
                    String market = listOfElements.get(counter - 1);

                    listOfLines.add(new FileLines(id, cluster, version, user, app, market));
                    counter = counter + 6;
                }
            }
            Collections.sort(listOfLines, new CompareVersions());

            File file = new File("D:\\Hackathon\\src\\main\\resources\\outputFile.txt");
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (FileLines fileLines : listOfLines) {
                bufferedWriter.write(fileLines.toString());
            }

            bufferedWriter.close();
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("The File can't be read");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
