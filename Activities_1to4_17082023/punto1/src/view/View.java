package view;

import javax.swing.*;
import java.awt.*;
import presenter.Presenter;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;

public class View {
    private Presenter presenter;
    private JFrame frame = new JFrame("Asignador de tareas");
    private JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    private JButton button = new JButton("Asignar tareas");
    private JButton button1 = new JButton("Ver lista");
    private JLabel label = new JLabel("Nombre de usuario: ");
    private JLabel label1= new JLabel("Titulo de la Tarea: ");
    private JLabel label2= new JLabel("Descripcion de la Tarea: ");
    private JLabel label3= new JLabel("Fecha de vencimiento : ");
    private JTextField userName = new JTextField(10);
    private JTextField taskName = new JTextField(10);
    private JTextField description = new JTextField(10);
    private JDateChooser due_date = new JDateChooser();
    private JTextArea taskListArea = new JTextArea(100, 100);

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void showView(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.setSize(400, 400);
        due_date.setDateFormatString("dd/MM/yyyy");
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
        panel.add(userName);
        panel.add(label1);
        panel.add(taskName);
        panel.add(label2);
        panel.add(description);
        panel.add(label3);
        panel.add(due_date);
        jPanel.add(button);
        jPanel.add(button1);
        panel1.add(taskListArea);
        setButton();
        setButton1();
        frame.add(panel);
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER,panel1);
        frame.getContentPane().add(BorderLayout.SOUTH, jPanel);
        frame.setVisible(true);
    }

    public String getUserName(){
        return userName.getText();
    }

    public String getTaskName(){
        return taskName.getText();
    }

    public String getDescription(){
        return description.getText();
    }

    public String getDueDate(){
        Date selectedDate = due_date.getDate();
        String dueDate = null;
        if (selectedDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String selectedDateString = sdf.format(selectedDate);
            dueDate = selectedDateString;
        } else {
            JOptionPane.showMessageDialog(frame, "Seleccione una fecha primero.");
        }
        return dueDate;
    }

    public void setButton() {
        button.addActionListener(e -> {
            String userName = getUserName();
            String taskName = getTaskName();
            String description = getDescription();
            String dueDate = getDueDate();
            presenter.assignTask(userName, taskName, description,dueDate);
            showMessage("Tarea asignada correctamente.");
        });
    }

    public void setButton1(){
        button1.addActionListener(e -> {
            String taskList = presenter.getTaskList();
            taskListArea.setText(taskList);
            panel1.add(taskListArea);
            frame.add(panel1);
            frame.setVisible(true);
        });
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
}