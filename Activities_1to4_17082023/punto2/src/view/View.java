package view;

import javax.swing.*;
import java.awt.*;
import presenter.Presenter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class View {
    private Presenter presenter;
    private JFrame frame = new JFrame("Carrito de compras");
    private JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    private JButton button = new JButton("Ver carrito");
    private JLabel label = new JLabel("Articulo: ");
    private JLabel label1= new JLabel("Precio: ");
    private JLabel label2= new JLabel("Cantidad: ");
    private JTextField article = new JTextField(10);
    private JTextField cost = new JTextField(10);
    private JTextField cant = new JTextField(10);
    private JTextArea taskListArea = new JTextArea(30, 40);

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void showView(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.setSize(300, 300);
        JPanel jPanel = new JPanel();
        taskListArea.setEditable(false);
        Font customFont = new Font("Arial", Font.PLAIN, 16);
        taskListArea.setForeground(Color.WHITE);
        taskListArea.setFont(customFont);
        panel.setBackground(Color.lightGray);
        jPanel.setBackground(Color.LIGHT_GRAY);
        panel1.setBackground(Color.LIGHT_GRAY);
        taskListArea.setBackground(Color.GRAY);
        panel.add(label);
        panel.add(article);
        panel.add(label1);
        panel.add(cost);
        panel.add(label2);
        panel.add(cant);
        panel.add(button);
        panel1.add(taskListArea);
        setButton();
        frame.add(panel);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER,panel1);
        frame.setVisible(true);
    }

    public String getArticle(){
        return article.getText();
    }

    public int getCost(){
        int costo = isNumber(cost.getText());
        return costo;
    }
    public int getCant(){
        int cantidad = isNumber(cant.getText());
        return cantidad;
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
            showMessage("El costo o contidad no es valido");
        }
        return cantidad;
    }

    public void setButton() {
        button.addActionListener(e -> {
            String article = getArticle();
            int cost = getCost();
            int cant = getCant();
            if(cost!=0 || cant!=0) {
                presenter.shop(article, cost, cant);
                showMessage("Agregado al carrito.");
                String taskList = presenter.getCar();
                taskListArea.setText(taskList);
                panel1.add(taskListArea);
                frame.add(panel1);
                frame.setVisible(true);
            }else {
                showMessage("No se puede agregar al carrito");
            }
        });
    }


    public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
}
