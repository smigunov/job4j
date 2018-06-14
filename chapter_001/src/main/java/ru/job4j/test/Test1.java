package ru.job4j.test;

public class Test1{

    /*static void qq(String s) {
        System.out.println(s);
        //s = "Что-то новое..."; // Это ссылка или не ссылка меняется ?
        s = new String("тынц");
        System.out.println(s);
    }*/

    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[9] = 1;
        System.out.println(arr[100]);
    }
}
