package Seminar3.Controller;

import Seminar3.Model.Error;
import Seminar3.Model.Person;
import Seminar3.Model.SaveFileException;
import Seminar3.Service.FileService;
import Seminar3.Service.ParsePersonalData;
import Seminar3.View.PersonalDataView;

public class DataController {
    ParsePersonalData parsePersonalData = new ParsePersonalData();
    FileService fileService = new FileService();
    PersonalDataView personalDataView = new PersonalDataView();

    public void getUserData() {
        Object listUserData = personalDataView.getPersonalData();
        if (listUserData instanceof String[]) {
            Person user = parsePersonalData.parseData((String[]) listUserData);
            if (user != null) {
                try {
                    fileService.saveToFile(user);
                } catch (SaveFileException e) {
                    System.out.println(e.getMessage());
                    e.getStackTrace();
                }

            }
        } else if (listUserData instanceof Error error) {
            System.out.println(error.toString());
        }
    }
}
