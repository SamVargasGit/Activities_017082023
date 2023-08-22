package model;

public class Car {
    String article;
    int cant;
    int cost;
    public Car(String article,int cost,int cant){
        this.article=article;
        this.cost=cost;
        this.cant=cant;
    }
    public String getArticle(){
        return article;
    }
    public int getCost(){
        return cost;
    }
    public int getCostTotal(){
        return cost*cant;
    }
    public int getCant(){
        return cant;
    }
}
