package org.example;

import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String file = "/home/prog/IdeaProjects/ex/src/main/java/org/example/ex.xlsx";
        int input_data = scan.nextInt();

        Test temp = new Test();
        temp.Excele(file,input_data);
    }
}
final class Test {
    public void Excele(String file,int input_Data){
        try{
            XSSFWorkbook book = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet list = book.getSheet("Лист1");
            int i = 1;
            while (true){
                int f = 1;
                String line = "";
                XSSFRow row = list.getRow(i);
                if(row == null)
                    break;
                int result = (int) row.getCell(0).getNumericCellValue();
                if (result == input_Data){
                    while(row.getCell(f) != null){
                        line += row.getCell(f).getStringCellValue() + " ";
                        f++;
                    }
                    System.out.println(line);
                }
                i++;
            }
        }
        catch (Exception e){
            System.out.println("Ошибка! "+e.getMessage());
        }
    }
}