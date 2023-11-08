import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz {
    private Controller controller;

    public Interfaz() {
        controller = new Controller();
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Menu candidatos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton createButton = new JButton("Crear Candidato");
        JButton updateButton = new JButton("Actualizar Candidato");
        JButton deleteButton = new JButton("Eliminar Candidato");
        JButton searchButton = new JButton("Buscar Candidato");
        JButton listButton = new JButton("Lista de Candidatos");
        JButton voteButton = new JButton("Votar");

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Llama al método para crear candidato
                controller.crearCandidato();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Llama al método para actualizar candidato
                int index = controller.candidato_index();
                if (index != -1) {
                    controller.actualizarCandidato(index);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Llama al método para eliminar candidato 
                int index = controller.candidato_index();
                if (index != -1) {
                    controller.eliminarCandidato(index);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Llama al método para buscar candidato
                controller.buscarCandidato();
            }
        });

        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Llama al método para imprimir la lista de candidatos
                controller.imprimirListaCandidatos();
            }
        });

        voteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Llama al método para votar por un candidato aquí
                int index = controller.candidato_index();
                if (index != -1) {
                    controller.menuVotos();
                }
            }
        });

        panel.add(createButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(searchButton);
        panel.add(listButton);
        panel.add(voteButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Interfaz();
    }
}
    
