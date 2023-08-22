package view;

import javax.swing.*;
import java.awt.*;
import presenter.Presenter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class View {
    private Presenter presenter;
    private JFrame frame = new JFrame("Gestion de citas");
    private JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    private JButton button = new JButton("Ver cola");
    private JLabel label = new JLabel("Nombre del paciente: ");
    private JLabel label1= new JLabel("Prioridad: ");
    private JTextField name = new JTextField(10);
    private JTextField priority = new JTextField(10);
    private JTextArea ListArea = new JTextArea(30, 40);

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void showView(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.setSize(300, 300);
        JPanel jPanel = new JPanel();
        ListArea.setEditable(false);
        Font customFont = new Font("Arial", Font.PLAIN, 16);
        ListArea.setForeground(Color.WHITE);
        ListArea.setFont(customFont);
        panel.setBackground(Color.lightGray);
        jPanel.setBackground(Color.LIGHT_GRAY);
        panel1.setBackground(Color.LIGHT_GRAY);
        ListArea.setBackground(Color.GRAY);
        panel.add(label);
        panel.add(name);
        panel.add(label1);
        panel.add(priority);
        panel.add(button);
        panel1.add(ListArea);
        setButton();
        frame.add(panel);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER,panel1);
        frame.setVisible(true);
    }

    public String getArticle(){
        return name.getText();
    }

    public int getCost(){
        int costo = isNumber(priority.getText());
        return costo;
    }

    public int isNumber(String number){
        int cantidad=0;
        try {
            if (!number.isBlank()) {
                cantidad = Integer.parseInt(number);
            }else {
                showMessage("Un campo esta vacio");
            }
        }catch (NumberFormatException e){
            showMessage("Para la prioridad o tiempo ingrese numeros");
        }
        return cantidad;
    }

    public void setButton() {
        button.addActionListener(e -> {
            String name = getArticle();
            int priority = getCost();
            if(priority!=0) {
                presenter.asign(name, priority);
                showMessage("Paciente agregado a la cola.");
                String taskList = presenter.getPacients();
                ListArea.setText(taskList);
                panel1.add(ListArea);
                frame.add(panel1);
                frame.setVisible(true);
            }else {
                showMessage("No se puede agregar a la cola");
            }
        });
    }


    public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
}
