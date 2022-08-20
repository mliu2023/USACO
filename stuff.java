import java.util.*;

class Farmer{

  private int price;
  private int amount;

  public Farmer(int price, int amount){
    this.price = price;
    this.amount = amount;
  }
  public int getPrice(){
    return price;
  }
  public int getAmount(){
    return amount;
  }
}

public class stuff{
  public static void main(String[] args){
    Farmer x = new Farmer(1, 1);
    System.out.println(x.getPrice());
    System.out.println((2*-1)%5);
  }
}
