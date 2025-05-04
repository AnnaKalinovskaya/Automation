package library;

public class Main {

    public static void main (String[] args){
        Book book = new Book.Builder().setAuthors("A1")
                .setTitle("T1")
                .setContent("jhjfsjfhoidjfijefijskdncjfi")
                .build();

        BookProxy proxy = new BookProxy(book);
        System.out.println(proxy.showContent());
    }
}
