package ru.geekbrains;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {

        //Создаем первый файл
        FileWriter writer = new FileWriter("/Users/maksimsemenakin/IdeaProjects/lesson6/newFile.txt");
        String text = "By and by, when we got up, we turned over the truck the gang had stole off of the wreck, and found boots," +
                " and blankets, and clothes, and all sorts of other things, and a lot of books, and a spyglass, and three boxes of seegars." +
                " We hadn't ever been this rich before in neither of our lives. The seegars was prime." +
                " We laid off all the afternoon in the woods talking, and me reading the books, and having a general good time. ";
        writer.write(text);
        writer.close();


        //Создаем второй файл
        FileWriter writer1 = new FileWriter("/Users/maksimsemenakin/IdeaProjects/lesson6/newFile2.txt");
        String text1 = "I told Jim all about what happened inside the wreck and at the ferryboat, and I said these kinds of things was adventures;" +
                " but he said he didn't want no more adventures. He said that when I went in the texas and he crawled back to get on the raft and" +
                " found her gone he nearly died, because he judged it was all up with HIM anyway it could be fixed; ";
        writer1.write(text1);
        writer1.close();


        //Читаем и записываем файлы со второго файла
        FileReader reader = new FileReader("/Users/maksimsemenakin/IdeaProjects/lesson6/newFile2.txt");
        int i;

        char[] buf = new char[2000];

        while ((i = reader.read(buf)) != -1) {
            String s = new String(buf);
            for (int j = 0; j < i; j++) {
                System.out.print(buf[j]);
            }
        }

        System.out.println("\nЧтение файла завершено!\n");
        reader.close();

        //Читаем и записываем данные из первого файла
        FileReader reader1 = new FileReader("/Users/maksimsemenakin/IdeaProjects/lesson6/newFile.txt");
        int j;

        char[] buf1 = new char[2000];

        while ((j = reader1.read(buf1)) != -1) {
            for (int k = 0; k < j; k++) {
                System.out.print(buf1[k]);
            }
        }
        System.out.println("\nЧтение файла завершено!");
        reader1.close();

        //Записываем данные из 2-х файлов в один
        FileWriter writer3 = new FileWriter("/Users/maksimsemenakin/IdeaProjects/lesson6/newFile3.txt");
        writer3.write(buf1);
        writer3.write(buf);

        System.out.println("\nСклейка 2-х файлов произошла");
        writer3.close();

        //Читаем данные из 3-его файла
        FileReader reader2 = new FileReader("/Users/maksimsemenakin/IdeaProjects/lesson6/newFile3.txt");
        int r2;

        System.out.println("Введите слово, которое хотите найти в файле: ");
        String guess = scanner.nextLine();

        char[] buf3 = new char[2000];

        while ((r2 = reader2.read(buf3)) != -1) {
            String s1 = new String(buf3, 0, r2);
            //Проверяем, содержится ли какое-либо слово в данном файле
            if (s1.contains(guess)) {
                System.out.println("Файл содержит " + guess);
            } else {
                System.out.println("Файл не содержит " + guess);
            }
        }
        reader2.close();

    }

}
