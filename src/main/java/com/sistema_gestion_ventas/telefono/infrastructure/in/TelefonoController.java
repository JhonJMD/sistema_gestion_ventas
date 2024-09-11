package com.sistema_gestion_ventas.telefono.infrastructure.in;

import com.sistema_gestion_ventas.telefono.domain.entity.Telefono;
import com.sistema_gestion_ventas.telefono.infrastructure.out.TelefonoRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class TelefonoController {

    private TelefonoRepository telefonoRepository;

    public TelefonoController() {
        this.telefonoRepository = new TelefonoRepository();
        crearVentanaGestionDeTelefono();
    }

    private void crearVentanaGestionDeTelefono() {
        JFrame gestionDeTelefonoFrame = new JFrame("Gestión de Telefono");
        gestionDeTelefonoFrame.setSize(600, 500);
        gestionDeTelefonoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeTelefonoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField tipoTelefonoIdField = new JTextField(20);
        tipoTelefonoIdField.setPreferredSize(new Dimension(200, 30));
        JTextField telefonoField = new JTextField(20);
        telefonoField.setPreferredSize(new Dimension(200, 30));
        JTextField telefonoIdField = new JTextField(20);
        telefonoIdField.setPreferredSize(new Dimension(200, 30)); // Added this field

        JButton btnCrear = new JButton("Crear Telefono");
        JButton btnActualizar = new JButton("Actualizar Telefono");
        JButton btnEliminar = new JButton("Eliminar Telefono");
        JButton btnListar = new JButton("Listar Telefonos");
        JButton btnBuscarPorId = new JButton("Buscar Telefono por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tipoTelefonoId = Integer.parseInt(tipoTelefonoIdField.getText());
                    String telefono = telefonoField.getText();
                    if (!telefono.trim().isEmpty()) {
                        Telefono newTelefono = new Telefono();
                        newTelefono.setTipoTelefonoId(tipoTelefonoId);
                        newTelefono.setTelefono(telefono);
                        telefonoRepository.createTelefono(newTelefono);
                        JOptionPane.showMessageDialog(null, "Telefono creado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tipoTelefonoId = Integer.parseInt(tipoTelefonoIdField.getText());
                    String telefono = telefonoField.getText();
                    if (!telefono.trim().isEmpty()) {
                        Telefono updatedTelefono = new Telefono();
                        updatedTelefono.setTipoTelefonoId(tipoTelefonoId);
                        updatedTelefono.setTelefono(telefono);
                        telefonoRepository.updateTelefono(updatedTelefono);
                        JOptionPane.showMessageDialog(null, "Telefono actualizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int telefonoId = Integer.parseInt(telefonoIdField.getText());
                    telefonoRepository.deleteTelefono(telefonoId);
                    JOptionPane.showMessageDialog(null, "Telefono eliminado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Telefono> telefonoList = telefonoRepository.getAllTelefono();
                StringBuilder sb = new StringBuilder("Lista de Telefonos:\n");
                for (Telefono telefono : telefonoList) {
                    sb.append("ID: ").append(telefono.getTelefonoId()).append(", ");
                    sb.append("tipoTelefonoId: ").append(telefono.getTipoTelefonoId()).append(", ");
                    sb.append("telefono: ").append(telefono.getTelefono()).append(", ");
                    sb.append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int telefonoId = Integer.parseInt(telefonoIdField.getText());
                    Optional<Telefono> telefonoOptional = telefonoRepository.findTelefonoById(telefonoId);
                    if (telefonoOptional.isPresent()) {
                        Telefono telefono = telefonoOptional.get();
                        JOptionPane.showMessageDialog(null, "Telefono encontrado:\nID: " + telefono.getTelefonoId() +
                                "\nTipoTelefonoId: " + telefono.getTipoTelefonoId() +
                                "\nTelefono: " + telefono.getTelefono());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró Telefono con ID: " + telefonoId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(new JLabel("TipoTelefonoId de Telefono:"));
        panel.add(tipoTelefonoIdField);
        panel.add(new JLabel("Telefono de Telefono:"));
        panel.add(telefonoField);
        panel.add(new JLabel("ID de Telefono (para eliminar y buscar):")); // Added label for ID field
        panel.add(telefonoIdField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeTelefonoFrame.add(panel);
        gestionDeTelefonoFrame.setVisible(true);
    }
}
