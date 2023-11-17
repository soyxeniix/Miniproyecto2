package views;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Controller;
import models.Candidato;
import utils.FocusVentana;

public class CrudWindow extends JFrame implements ActionListener {

    private Controller controller;
    private JButton[] buttons;

    public CrudWindow(Controller controller) {
        this.controller = controller;
        createUI();
    }

    private void createUI() {
        setTitle("Sistema de Gestión de Candidatos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 500);
        // Panel para el título
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Por favor ingrese la opción de su preferencia");
        titleLabel.setFont(new Font("Ebrima", Font.BOLD, 14));
        titlePanel.add(titleLabel);

        // Panel para los botones en una cuadrícula 3x3
        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        buttons = new JButton[9];

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Ebrima", Font.PLAIN, 12));
            buttons[i].setHorizontalAlignment(SwingConstants.CENTER);
            buttons[i].setVerticalAlignment(SwingConstants.CENTER);
            buttons[i].addActionListener(this);
            gridPanel.add(buttons[i]);
        }

        // Asignar texto a los botones
        buttons[0].setText("Insertar Candidato");
        buttons[1].setText("Actualizar Candidato");
        buttons[2].setText("Eliminar Candidato");
        buttons[3].setText("Buscar Candidato por nombre");
        buttons[4].setText("Listar Candidatos");
        buttons[5].setText("Candidato Ganador");
        buttons[6].setText("Acerca De");
        buttons[7].setText("Ayuda");
        buttons[8].setText("Salir");

        // Agregar paneles al frame
        add(titlePanel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
// Ajustar el tamaño del frame automáticamente

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                handleButtonClick(i + 1);  // Los botones son 1-indexed
                break;
            }
        }
    }

    private void handleButtonClick(int option) {
        try {
            switch (option) {
                case 1:
                    InsertWindow insert = new InsertWindow(controller);
                    setVisible(false);
                    FocusVentana.focus(insert, () -> setVisible(true));
                    break;
                case 2:
                    UpdateWindow update = new UpdateWindow(controller);
                    setVisible(false);
                    FocusVentana.focus(update, () -> setVisible(true));
                    break;
                case 3:
                    DeleteWindow delete = new DeleteWindow(controller);
                    setVisible(false);
                    FocusVentana.focus(delete, () -> setVisible(true));
                    break;
                case 4:
                    SearchWindow search = new SearchWindow(controller);
                    setVisible(false);
                    FocusVentana.focus(search, () -> setVisible(true));
                    break;
                case 5:
                    Lista lista = new Lista(controller);
                    setVisible(false);
                    FocusVentana.focus(lista, () -> setVisible(true));
                    break;
                case 6:
                    Candidato candidatoGanador = controller.getCandidatoGanador();
                    if(candidatoGanador == null){
                        JOptionPane.showMessageDialog(this, "No hay votos registrados");
                        break;
                    }
                    JOptionPane.showMessageDialog(this, "Candidato Ganador\n"+ controller.infoCandidato(candidatoGanador, false));
                    break;
                case 7:
                   acercaDe();
                    break;
                case 8:
                String mensaje = "Para ingresar un candidato debe ingresar los siguientes datos:\n"
                        + "Nombre: Nombre del candidato\n"
                        + "Cédula: Cédula del candidato\n"
                        + "Ciudad: Ciudad de origen del candidato\n"
                        + "Orientación: Orientación política del candidato\n"
                        + "Partido: Partido político al que pertenece el candidato\n"
                        + "Promesas: Promesas que el candidato hará si es elegido\n"
                        + "Puede actualizar los siguientes datos:\n"
                        + "Nombre: Nombre del candidato\n"
                        + "Cédula: Cédula del candidato\n"
                        + "Ciudad: Ciudad de origen del candidato\n"
                        + "Orientación: Orientación política del candidato\n"
                        + "Partido: Partido político al que pertenece el candidato\n"
                        + "Promesas: Promesas que el candidato hará si es elegido\n"
                        + "Para eliminar un candidato debe seleccionar uno\n"
                        + "Para buscar un candidato debe ingresar los siguientes datos:\n"
                        + "Nombre: Nombre del candidato\n"
                        + "Para listar los candidatos no necesita ingresar datos\n"
                        + "Para ver el candidato ganador no necesita ingresar datos\n"
                        + "Para ver la información de la aplicación no necesita ingresar datos\n"
                        + "Para ver la ayuda no necesita ingresar datos\n"
                        + "Para salir de la aplicación no necesita ingresar datos\n";
                    JOptionPane.showMessageDialog(this, mensaje, "Ayuda", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 9:
                    System.exit(0);  // Salir de la aplicación
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Opción no válida");
                    break;
            }
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error");
        }
    }
    public void acercaDe(){
        JOptionPane.showMessageDialog(this, "Desarrolladores:\nLUIS MANUEL CARDONA TROCHEZ \nJUAN DAVID GUTIERREZ FLOREZ\nCESAR DAVID PENARANDA MELO", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }
   
}
