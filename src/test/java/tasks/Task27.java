package tasks;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;

public class Task27 {

    @Test
    public void fileExists() {

       File f=new File("C:\\Users\\Acer\\OneDrive\\Masaüstü\\Frelance.txt");

       if (f.exists()){
           System.out.println("It is here");
       }else
        System.out.println("It is not here");
    }
    @Test
    public  void pngTest(){

        System.out.println(System.getProperty("user.home"));
        String homePath = System.getProperty("user.home");
        String filePath = "\\OneDrive\\Masaüstü\\Ekran görüntüsü 2023-08-31 153302.png";
        String fullPath = homePath + filePath;
        File image = new File(fullPath);
        Assert.assertTrue(image.exists());

    }
}