package presenter;
import model.Car;
import view.View;
import java.util.Vector;
public class Presenter {
    private View view;
    private Car car;
    private Vector<Car> vector = new Vector<Car>();
    public Presenter(View view) {
        this.view = view;
    }
    public void showView(){
        view.showView();
    }

    public void shop(String article,int cost,int cant){
        car = new Car(article,cost,cant);
        vector.add(car);
    }

    public String getCar() {
        StringBuilder carList = new StringBuilder();
        int total=0;
        for (int i=0;i<vector.size();i++ ){
            total=total+vector.elementAt(i).getCostTotal();
        }
        for (Car car : vector) {
            carList.append("\n\n   Articulo: ").append(car.getArticle()).append("\n");
            carList.append("   Precio: ").append(car.getCost()).append("\n");
            carList.append("   Cantidad: ").append(car.getCant()).append("\n");
            carList.append("   Total carrito: ").append(total).append("\n\n");
        }
        return carList.toString();
    }
    public static void main(String[] args){
        View view = new View();
        Presenter presenter = new Presenter(view);
        view.setPresenter(presenter);
        view.showView();
    }
}
