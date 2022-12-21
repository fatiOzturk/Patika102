package BookSorter;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> book = new TreeSet<>();
        book.add(new Book("Kalplerin keşfi", 767, "İmam Gazali", 2022));
        book.add(new Book("Kehribar geçidi", 684, "Nazan Bekiroğlu", 2022));
        book.add(new Book("Başlangıç", 590, "Dan Brown", 2018));
        book.add(new Book("Derviş ve Ölüm", 486, "Mesa Selimoviç", 2015));
        book.add(new Book("Kuran Bana Ne Diyor", 855, "Veli Tahir Erdoğan", 2021));

        // sort by name
        System.out.println("Sort by name");
        System.out.println("---------------------------------------------------");

        for (Book k : book) {
            System.out.println("Kitap Adı    : " + k.getBookName() +
                    "\nSayfa Sayısı : " + k.getNumberOfPages() +
                    "\nYazar Adı    : " + k.getAuthorName() +
                    "\nYayın Tarihi : " + k.getReleaseDate());
            System.out.println("---------------------------------------------------");
        }


        TreeSet<Book> books = new TreeSet<Book>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getNumberOfPages() - o2.getNumberOfPages();
            }
        });
        books.addAll(book);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Sorted By Number Of Page");
        System.out.println("---------------------------------------------------");

        for (Book k : books) {
            System.out.println("Kitap Adı    : " + k.getBookName() +
                    "\nSayfa Sayısı : " + k.getNumberOfPages() +
                    "\nYazar Adı    : " + k.getAuthorName() +
                    "\nYayın Tarihi : " + k.getReleaseDate());
            System.out.println("---------------------------------------------------");
        }
    }
}
