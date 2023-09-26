package org.example;
import java.util.*;

public class PhoneBook {
    private final HashMap<String, HashSet<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (contacts.containsKey(name)) {
            HashSet<String> phoneNumbers = contacts.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            HashSet<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        }
    }


    public void printContacts() {

        List<Map.Entry<String, HashSet<String>>> sortedContacts = new ArrayList<>(contacts.entrySet());


        sortedContacts.sort((o1, o2) -> o2.getValue().size() - o1.getValue().size());


        for (Map.Entry<String, HashSet<String>> entry : sortedContacts) {
            String name = entry.getKey();
            HashSet<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Иванов", "333-33-33");
        phoneBook.addContact("Петров", "223-22-22");
        phoneBook.addContact("Сидоров", "444-33-44");
        phoneBook.addContact("Иванов", "222-22-22");
        phoneBook.addContact("Иванов", "548-33-33");
        phoneBook.addContact("Федотов", "777-33-33");
        phoneBook.addContact("Сидоров", "878-12-16");
        phoneBook.addContact("Демьянов", "567-89-12");
        phoneBook.addContact("Иванов", "222-22-22");
        phoneBook.addContact("Демьянов", "567-89-12");

        phoneBook.printContacts();
    }
}