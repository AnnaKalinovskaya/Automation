package library;

 class BookProxy {
    private Book book;
    private String content;


    BookProxy(Book book){
        this.book = book;
    }

    protected String showContent(){
        if (this.content == null){
            this.content = this.book.getContent();
        }
        return this.content;
    }
}
