package Seminar3.Service;

import Seminar3.Model.Person;

public class ParsePersonalData {
    public Person parseData(String[] listData) throws IllegalArgumentException {
        Person person = new Person();
        for (String data : listData) {
            if (data != null) {
                if (checkBirthday(data)) person.setBirthday(data);
                else if (checkPhone(data)) person.setPhone(data);
                else if (checkGender(data)) person.setGender(data);
                else if (checkName(data)) {
                    if (person.getLastName() == null) {
                        person.setLastName(data);
                    } else if (person.getFirstName() == null) {
                        person.setFirstName(data);
                    } else if (person.getPatronymic() == null) {
                        person.setPatronymic(data);
                    }
                } else throw new IllegalArgumentException("Unknown format in data: " + data);
            } else throw new IllegalArgumentException("Unknown data format. Value not found.");
        }
        if (person.getGender() == null)
            throw new IllegalArgumentException("Unknown data format. Value gender not found.");
        return person;
    }

    private boolean checkBirthday(String data) {
        if (data.matches("^(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((?:19|20)[0-9][0-9])$")) {
            return true;
        } else return false;
    }

    private boolean checkPhone(String data) {
        if (data.matches("^([0-9]{10,14})$")) {
            return true;
        } else return false;
    }

    private boolean checkGender(String data) {
        if (data.equals("f") || data.equals("m")) {
            return true;
        } else return false;
    }

    private boolean checkName(String data) {
        if (data.matches("^[а-яА-Я]{3,}$")) {
            return true;
        } else return false;
    }
}
