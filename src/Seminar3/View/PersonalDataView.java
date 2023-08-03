package Seminar3.View;

import Seminar3.Model.Error;

import java.util.Scanner;

public class PersonalDataView {
    public Object getPersonalData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите данные (Фамилия Имя Отчество, дата рождения, номер телефона, пол):");
        String personalData = input.nextLine();
        if (!personalData.isEmpty()) {
            String[] listPersonalData = personalData.split(" ");
            if (listPersonalData.length != 6) {
                return Error.DATABASE;
            } else return listPersonalData;
        } else {
            return Error.DATABASE;
        }
    }
}
