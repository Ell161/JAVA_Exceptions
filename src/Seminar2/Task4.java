package Seminar2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        try {
            inputString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void inputString() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Ввод: ");
        String value = input.nextLine();
        if(value == null || value.isEmpty()){
            throw new Exception("Ввод пустой строки не допускается");
        } else {
            System.out.println(value);
        }
    }
}
