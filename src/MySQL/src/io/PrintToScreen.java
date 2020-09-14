package io;

import java.sql.SQLOutput;

public class PrintToScreen {
    public static void getChoice() {
        System.out.println(MessagesRepository.getChoice());
    }

    public static void invalidInput() {
        System.out.println(MessagesRepository.invalidInput());
    }

    public static void displayTrac(String tracName, int numPages) {
        System.out.println(MessagesRepository.displayTrac(tracName, numPages));
    }

    public static void getTracName() {
        System.out.println(MessagesRepository.getTracName());
    }

    public static void getTracPages() {
        System.out.println(MessagesRepository.getTracPages());
    }

    public static void invalidNumPages() {
        System.out.println(MessagesRepository.invalidNumPages());
    }

    public static void tracAlreadyExists() {
        System.out.println(MessagesRepository.tracAlreadyExists());
    }

    public static void tracNotFound() {
        System.out.println(MessagesRepository.tracNotFound());
    }

    public static void displayStudent(int id, String name) {
        System.out.println(MessagesRepository.displayStudent(id, name));
    }

    public static void getDay() {
        System.out.println(MessagesRepository.getDay());
    }

    public static void getMonth() {
        System.out.println(MessagesRepository.getMonth());
    }

    public static void getYear() {
        System.out.println(MessagesRepository.getYear());
    }

    public static void dateInvalid() {
        System.out.println(MessagesRepository.dateInvalid());
    }

    public static void tryAgain() {
        System.out.println(MessagesRepository.tryAgain());
    }

    public static void getPersonalName() {
        System.out.println(MessagesRepository.getPersonalName());
    }

    public static void getFamilyName() {
        System.out.println(MessagesRepository.getFamilyName());
    }

    public static void shouldGetDate() {
        System.out.println(MessagesRepository.shouldGetDate());
    }

    public static void yForYes(){
        System.out.println(MessagesRepository.yForYes());
    }

    public static void goodbye() {
        System.out.println(MessagesRepository.goodbye());
    }

    public static void getDaf() {
        System.out.println(MessagesRepository.getDaf());
    }

    public static void getAmud() {
        System.out.println(MessagesRepository.getAmud());
    }

    public static void studentNotFound() {
        System.out.println(MessagesRepository.studentNotFound());
    }

    public static void getOldStudentName() {
        System.out.println(MessagesRepository.getOldStudentName());
    }

    public static void getNewStudentName() {
        System.out.println(MessagesRepository.getNewStudentName());
    }

    public static void getDateUnit(String type) {
        System.out.println(MessagesRepository.getDateUnit(type));
    }
}