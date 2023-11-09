import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actualizar extends JFrame {
    private JTextField nombreField, cedulaField;
    private JComboBox<String> orientacionComboBox, partidoComboBox, ciudadComboBox;

    public Actualizar() {
        setTitle("Actualización de Candidatos");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar el tipo de letra "Ebrima" para los componentes
        Font font = new Font("Ebrima", Font.PLAIN, 12);

        nombreField = new JTextField(20);
        nombreField.setFont(font);
        cedulaField = new JTextField(20);
        cedulaField.setFont(font);
        orientacionComboBox = new JComboBox<>(new String[]{"DERECHA", "IZQUIERDA"});
        orientacionComboBox.setFont(font);
        partidoComboBox = new JComboBox<>(new String[]{"AGRUPACION_POLITICA_EN_MARCHA", "INDEPENDIENTES", "MOVIMIENTO_SALVACION_NACIONAL", "MOVIMIENTO_ALIANZA_DEMOCRATICA_AMPLIA", "MOVIMIENTO_ALTERNATIVO_INDIGENA_Y_SOCIAL", "MOVIMIENTO_AUTORIDADES_INDIGENAS_DE_COLOMBIA", "MOVIMIENTO_ESPERANZA_PAZ_Y_LIBERTAD", "MOVIMIENTO_FUERZA_CIUDADANA", "MOVIMIENTO_POLITICO_COLOMBIA_HUMANA", "NUEVA_FUERZA_DEMOCRATICA", "PARTIDO_ALIANZA_SOCIAL_INDEPENDIENTE", "PARTIDO_ALIANZA_VERDE", "PARTIDO_CAMBIO_RADICAL", "PARTIDO_CENTRO_DEMOCRATICO", "PARTIDO_COLOMBIA_JUSTA_LIBRES", "PARTIDO_COLOMBIA_RENACIENTE", "PARTIDO_COMUNES", "PARTIDO_COMUNISTA_COLOMBIANO", "PARTIDO_CONSERVADO_COLOMBIANO", "PARTIDO_DE_LA_U",
        "PARTIDO_DEL_TRABAJO_DE_COLOMBIA_PTC", "PARTIDO_DEMOCRATA_COLOMBIANO", "PARTIDO_ECOLOGISTA_COLOMBIANO", "PARTIDO_LIBERAL_COLOMBIANO", "PARTIDO_LIGA_GOBERNANTES_ANTICORRUPCIÓN", "PARTIDO_NUEVO_LIBERALISMO", "PARTIDO_POLO_DEMOCRATICO_ALTERNATIVO", "PARTIDO_POLÍTICO_CREEMOS", "PARTIDO_POLÍTICO_DIGNIDAD", "PARTIDO_POLÍTICO_GENTE_EN_MOVIMIENTO", "PARTIDO_POLÍTICO_LA_FUERZA_DE_LA_PAZ", "PARTIDO_POLÍTICO_MIRA", "PARTIDO_UNIÓN_PATRIÓTICA", "PARTIDO_VERDE_OXIGENO", "TODOS_SOMOS_COLOMBIA"});
        partidoComboBox.setFont(font);
        ciudadComboBox = new JComboBox<>(new String[]{"ALCALA", "ANDALUCIA", "ANSERMANUEVO", "ARGELIA", "BOLIVAR", "BUENAVENTURA", "BUGA", "BUGALAGRANDE", "CAICEDONIA", "CALI", "CALIMA_DARIEN", "CANDELARIA", "CARTAGO", "DAGUA", "EL_AGUILA", "EL_CAIRO", "EL_CERRITO", "EL_DOVIO", "FLORIDA", "GINEBRA", "GUACARI", "JAMUNDI", "LA_CUMBRE", "LA_UNION", "LA_VICTORIA", "OBANDO", "PALMIRA", "PRADERA", "RESTREPO", "ROLDANILLO", "RIOFRIO", "SAN_PEDRO", "SEVILLA", "TORO", "TRUJILLO", "TULUA", "ULLOA", "VERSALLES", "VIJES", "YOTOCO", "YUMBO", "ZARZAL"});
        ciudadComboBox.setFont(font);

        JButton actualizarButton = new JButton("Actualizar");
        actualizarButton.setFont(font);
        JButton salirButton = new JButton("Salir");
        salirButton.setFont(font);
        
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String cedula = cedulaField.getText();
                String orientacion = (String) orientacionComboBox.getSelectedItem();
                String partido = (String) partidoComboBox.getSelectedItem();
                String ciudad = (String) ciudadComboBox.getSelectedItem();

                // Lógica para actualizar el candidato con los datos ingresados
                // Debes implementar esta función según tu lógica de negocios

                // Muestra el resultado en un cuadro de mensaje emergente (JOptionPane)
                mostrarMensaje("Candidato actualizado:\nNombre: " + nombre +
                        "\nCédula: " + cedula + "\nOrientación: " + orientacion +
                        "\nPartido: " + partido + "\nCiudad: " + ciudad);
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
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Cédula:"), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Orientación:"), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Partido:"), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Ciudad:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(nombreField, gbc);
        gbc.gridy++;
        panel.add(cedulaField, gbc);
        gbc.gridy++;
        panel.add(orientacionComboBox, gbc);
        gbc.gridy++;
        panel.add(partidoComboBox, gbc);
        gbc.gridy++;
        panel.add(ciudadComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(actualizarButton, gbc);
        gbc.gridx++;
        panel.add(salirButton, gbc);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Actualizar();
            }
        });
    }
}
