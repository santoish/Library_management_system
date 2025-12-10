public class Books {
    private int id;
    private String title;
    private String author;
    private boolean borrowed;


    public Books(int b_Id, String b_title, String b_author){
        this.id = b_Id;
        this.title = b_title;
        this.author = b_author;
        this.borrowed = false;
    }

    @Override
    public String toString(){
        return "ID  : "+ id +" | Title : " + title + " | Author : " + author + " | Status : " + getStatus();
    }
    public int getId(){return id;}
    public String getTitle(){return title;}
    public boolean isBorrowed(){return borrowed;}
    public void setBorrowed(boolean borrow){this.borrowed = borrow;}

    public String getStatus(){return  borrowed ? "Borrowed" : "Available" ;}


}
