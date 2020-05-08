package org.example;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.stream.JsonGenerator;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonClass {

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("myJson.txt");
        JsonGenerator gen = Json.createGenerator(writer);

        gen.writeStartObject()
                .write("name", "Ionut")
                .write("age", "21")
                .write("universityName", "ULB")
                .write("year", "1998")
                .writeStartArray("teachers")
                    .write("Ion Andrei")
                    .write("Sergiu Nicolaescu")
                    .write("Cristina Radu")
                .writeEnd()
                .writeEnd();

        gen.close();

        System.out.println("The JSON file myJson.txt was completely generated.");

        JsonReader reader = Json.createReader(new FileInputStream("myJson.txt"));
        System.out.println(reader.read());

    }
}
