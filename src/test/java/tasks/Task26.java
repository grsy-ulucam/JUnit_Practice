package tasks;

import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Task26 extends BaseTest {

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));
        String projectRoot=System.getProperty("user.dir");
        String filePath="C:\\Users\\Acer\\IdeaProjects\\JUnit_Practice\\src\\test\\java\\resources\\file";

        if (Files.exists(Paths.get(filePath))){
            System.out.println("It is here");
        }else System.out.println("It is not here");

    }
        }


