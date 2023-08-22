package model;

import java.util.Comparator;

public class Comparate implements Comparator<Paciente> {
    @Override
    public int compare(Paciente task1, Paciente task2) {
        if (task1.getPriority() != task2.getPriority()) {
            return Integer.compare(task2.getPriority(), task1.getPriority());
        } else {
            return Integer.compare(task1.getTime(), task2.getTime());
        }
    }
}
