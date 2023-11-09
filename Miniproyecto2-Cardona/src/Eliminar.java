import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Eliminar extends JFrame {
    private List<String> listaCandidatos;
    private JTextField nombreField;

    public Eliminar() {
        listaCandidatos = new ArrayList<>();
        listaCandidatos.add("Cesar");
        listaCandidatos.add("Manuel");
        listaCandidatos.add("Juan");

        setTitle("Eliminar Candidato");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nombreField = new JTextField(20);
        JButton eliminarButton = new JButton("Eliminar");
        JButton salirButton = new JButton("Salir");

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                eliminarCandidato(nombre);
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(new JLabel("Nombre del Candidato a Eliminar:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Extiende el componente hasta el final de la fila
        panel.add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Volver a establecer el ancho del componente a 1
        panel.add(eliminarButton, gbc);

        gbc.gridx = 1;
        panel.add(salirButton, gbc);

        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints mainGbc = new GridBagConstraints();
        mainGbc.gridx = 0;
        mainGbc.gridy = 0;
        getContentPane().add(panel, mainGbc);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void eliminarCandidato(String nombre) {
        //VALIDAMOS
        if (nombre.isEmpty()) {
            mostrarMensaje("Por favor, ingrese un nombre de candidato para eliminar.");
            return;
        }

        if (listaCandidatos.contains(nombre)) {
            listaCandidatos.remove(nombre);
            mostrarMensaje("Se ha eliminado el candidato " + nombre);
        } else {
            mostrarMensaje("No se encontró ningún candidato con el nombre proporcionado.");
        }
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Eliminar();
            }
        });
    }
}
