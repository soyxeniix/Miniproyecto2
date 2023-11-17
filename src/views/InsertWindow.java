package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import models.Candidato;
import models.Ciudades;
import models.Orientacion;
import models.Partido;
import utils.FocusVentana;
import utils.Validacion;
import controller.Controller;

public class InsertWindow extends JFrame implements ActionListener, ItemListener {
    Controller controller;
    private Candidato infocandidato;

    private JButton save;
    private JButton addVotesButton;
    private JButton addProposalsButton;
    private JComboBox<Orientacion> orientation;
    private JComboBox<Ciudades> city;
    private JComboBox<Partido> partiPoli;
    private JLabel nombreLabel;
    private JLabel ciudadLabel;
    private JLabel cedulaLabel;
    private JLabel orientacionLabel;
    private JLabel partidoLabel;
    private JTextField nombreField;
    private JTextField cedulaField;
    private Candidato candidato;

    DefaultComboBoxModel<Ciudades> lista = new DefaultComboBoxModel<>(Ciudades.values());
    DefaultComboBoxModel<Orientacion> orientacionModel = new DefaultComboBoxModel<>(Orientacion.values());
    DefaultComboBoxModel<Partido> partidoModel = new DefaultComboBoxModel<>(Partido.values());

    public InsertWindow(Controller controller, Candidato candidato) {
        this.controller = controller;
        infocandidato = candidato;
        insertComponents();
        inicializarCandidato(candidato);
    }

    public InsertWindow(Controller controller) {
        this.controller = controller;
        insertComponents();
    }

    private void inicializarCandidato(Candidato candidato) {
        nombreField.setText(candidato.getNombre());
        cedulaField.setText(candidato.getCedula());
        city.setSelectedItem(candidato.getCiudad());
        partiPoli.setSelectedItem(candidato.getPartido());
        orientation.setSelectedItem(candidato.getOrientacion());
    }

    private void insertComponents() {
        nombreField = new JTextField();
        nombreLabel = new JLabel();
        ciudadLabel = new JLabel();
        cedulaLabel = new JLabel();
        orientacionLabel = new JLabel();
        cedulaField = new JTextField();
        partidoLabel = new JLabel();
        orientation = new JComboBox<>(orientacionModel);
        city = new JComboBox<>(lista);
        partiPoli = new JComboBox<>(partidoModel);
        save = new JButton();
        addVotesButton = new JButton("Agregar Votos");
        addProposalsButton = new JButton("Agregar Propuestas");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        nombreField.setToolTipText("");

        nombreLabel.setFont(new java.awt.Font("Ebrima", 0, 12));
        nombreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreLabel.setText("Nombre de candidato");

        ciudadLabel.setFont(new java.awt.Font("Ebrima", 0, 12));
        ciudadLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ciudadLabel.setText("Ciudad");

        cedulaLabel.setFont(new java.awt.Font("Ebrima", 0, 12));
        cedulaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cedulaLabel.setText("Numero de cedula");

        orientacionLabel.setFont(new java.awt.Font("Ebrima", 0, 12));
        orientacionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orientacionLabel.setText("Orientacion");

        cedulaField.setToolTipText("");

        partidoLabel.setFont(new java.awt.Font("Ebrima", 0, 12));
        partidoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        partidoLabel.setText("Partido");

        save.setText("Save");
        save.addActionListener(this);

        addVotesButton.addActionListener(this);
        addProposalsButton.addActionListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(partidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(132, 132, 132))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nombreField)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ciudadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(city, 0, 216, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cedulaField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cedulaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(orientacionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(orientation, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(19, 19, 19))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(partiPoli, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(139, 139, 139))
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(addVotesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(addProposalsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cedulaLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cedulaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(nombreLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(orientacionLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(orientation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ciudadLabel)
                            .addGap(50, 50, 50)))
                    .addComponent(partidoLabel)
                    .addGap(4, 4, 4)
                    .addComponent(partiPoli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(save)
                        .addComponent(addVotesButton)
                        .addComponent(addProposalsButton))
                    .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == save) {
            if(guardarCandidato(true) != null){
                dispose();
            }
        } else if (e.getSource() == addVotesButton) {
            agregarVotos(guardarCandidato(false));
        } else if (e.getSource() == addProposalsButton) {
            agregarPropuestas(guardarCandidato(false));
        }
    }

    private Candidato guardarCandidato(boolean save) {
       
        String nombresave = nombreField.getText();
        String cedulasave = cedulaField.getText();
        Ciudades ciudadsave = (Ciudades) city.getSelectedItem();
        Orientacion orientasave = (Orientacion) orientation.getSelectedItem();
        Partido partidosave = (Partido) partiPoli.getSelectedItem();

        if (!Validacion.validarDatos(nombresave, cedulasave)) {
            if(save)
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
            return null;
        }
        
        Candidato candidato = this.candidato != null ? this.candidato : new Candidato(nombresave, cedulasave, ciudadsave, orientasave, partidosave);
        if(this.candidato != null && this.infocandidato != null){
            this.infocandidato = this.candidato;
        }else if(this.infocandidato != null){
            candidato.setPromesas(this.infocandidato.getPromesas());
            candidato.setVotos(this.infocandidato.getVotos());
        }
        if(save){
            if (infocandidato == null) {
                String mensaje = controller.addCandidato(candidato) ? "Candidato agregado" : "No se pudo agregar el candidato";
                JOptionPane.showMessageDialog(this, mensaje);
            } else {
                String mensaje = controller.updateCandidato(infocandidato, candidato) ? "Candidato actualizado" : "No se pudo actualizar el candidato";
                JOptionPane.showMessageDialog(this, mensaje);
            }
        this.candidato = null;
        }
        
        return candidato;
    }

    private void agregarVotos(Candidato candidato) {
        if(candidato == null){
            JOptionPane.showMessageDialog(this, "Ingresa los datos del candidato primero");
            return;
        }
        String votos = JOptionPane.showInputDialog(this, "Votos actuales: "+candidato.getVotos(), candidato.getVotos());
        if(votos != null && votos.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese un numero de votos");
            return;
        }
        try {
            int numeroVotos = Integer.parseInt(votos);
            candidato.setVotos(numeroVotos);
            JOptionPane.showMessageDialog(this, "Votos agregados");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un numero de votos valido");
        }
        this.candidato = candidato;
    }

    private void agregarPropuestas(Candidato candidato) {
         if(candidato == null){
            JOptionPane.showMessageDialog(this, "Ingresa los datos del candidato primero");
            return;
        }
        this.candidato = candidato;
        PropuestasCandidato propuestas = new PropuestasCandidato(controller, this.candidato);
        setVisible(false);
        FocusVentana.focus(propuestas, () -> setVisible(true));
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'itemStateChanged'");
    }

}
