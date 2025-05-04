package library;

import java.util.LinkedList;

class Book {

     private LinkedList<String> authors;
     private String title;
     private String content;
     private Object cover;

    public Book(LinkedList<String> authors, String title, String content, Object cover) {
        this.authors = authors;
        this.title = title;
        this.content = content;
        this.cover = cover;
    }

    public Book (Builder builder){
        this.authors = builder.authors;
        this.title = builder.title;
        this.content = builder.content;
        this.cover = builder.cover;
    }

    protected String getContent(){
        return this.content;
    }

    static class Builder{
        private LinkedList<String> authors = new LinkedList<>();
        private String title;
        private String content;
        private Object cover;

        Builder setAuthors(String author){
            this.authors.add(author);
            return this;
        }

        Builder setTitle(String title){
            this.title = title;
            return this;
        }

        Builder setContent(String content){
            this.content = content;
            return this;
        }

        Builder setCover (Object cover){
            this.cover = cover;
            return this;
        }

        Book build(){
            return new Book(this);
        }
    }
}
