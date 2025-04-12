package Task4;


public class Rating <T extends Number>{

    private T rate;

    public Rating(T number){
        this.rate = number;
    }


    public T getRate(){
        return this.rate;
    }

    public void setRate(T rate){
        this.rate = rate;
    }
}
