import com.moviemanager.model.Movie;
import com.moviemanager.service.MovieManager;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Movie m1 = new Movie(1,"yjhd", "Romance", 2022);
        Movie m2 = new Movie(2,"Kill", "Action", 2023);
        Movie m3 = new Movie(3,"Dhurandhar", "Action", 2012);
        Movie m4 = new Movie(4,"kriis", "Action", 2006);

        try{
//            FileWriter writer = new FileWriter("data/movies");
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/movies"));
            writer.write(m1.toFileString());
            writer.close();
            System.out.println(m1.toFileString());

            BufferedReader reader = new BufferedReader(new FileReader("data/movies"));
            String line;
            while((line = reader.readLine()) != null){
//                line = reader.readLine();

                String[] token = line.split("\\|");

                int id = Integer.parseInt(token[0]);
                String title = token[1];
                String genre = token[2];
                int year = Integer.parseInt(token[3]);

                Movie movie = new Movie(id, title, genre, year);
                System.out.println(movie);
            }


        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
