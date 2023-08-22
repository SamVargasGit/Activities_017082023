package presenter;
import model.*;
import view.View;

import java.util.PriorityQueue;
public class Presenter {
    private View view;
    private Paciente paciente;
    private PriorityQueue<Paciente> pacientes = new PriorityQueue<>(new Comparate());
    public Presenter(View view) {
        this.view = view;
    }
    public void showView(){
        view.showView();
    }

    public void asign(String article,int cost){
        paciente = new Paciente(article,cost);
        pacientes.add(paciente);
    }

    public String getPacients() {
        StringBuilder pacientList = new StringBuilder();
        pacientList.append("\n\n   LISTA DE ESPERA \n\n");
        for (Paciente pac : pacientes) {
            pacientList.append("   Nombre del paciente: ").append(pac.getName()).append("\n");
            pacientList.append("   Prioridad: ").append(pac.getPriority()).append("\n");
        }
        return pacientList.toString();
    }
    public static void main(String[] args){
        View view = new View();
        Presenter presenter = new Presenter(view);
        view.setPresenter(presenter);
        view.showView();
    }
}
