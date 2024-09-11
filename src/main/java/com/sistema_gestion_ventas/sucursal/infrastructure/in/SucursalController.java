package com.sistema_gestion_ventas.sucursal.infrastructure.in;

import com.sistema_gestion_ventas.sucursal.domain.entity.Sucursal;
import com.sistema_gestion_ventas.sucursal.infrastructure.out.SucursalRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class SucursalController {

    private SucursalRepository sucursalRepository;

    public SucursalController() {
        this.sucursalRepository = new SucursalRepository();
        crearVentanaGestionDeSucursal();
    }

    private void crearVentanaGestionDeSucursal() {
        JFrame gestionDeSucursalFrame = new JFrame("Gestión de Sucursal");
        gestionDeSucursalFrame.setSize(600, 500);
        gestionDeSucursalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeSucursalFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField sucursalIdField = new JTextField(20);
        sucursalIdField.setPreferredSize(new Dimension(200, 30));
        JTextField direccionIdField = new JTextField(20);
        direccionIdField.setPreferredSize(new Dimension(200, 30));
        JTextField descripcionField = new JTextField(20);
        descripcionField.setPreferredSize(new Dimension(200, 30));
        
        JButton btnCrear = new JButton("Crear Sucursal");
        JButton btnActualizar = new JButton("Actualizar Sucursal");
        JButton btnEliminar = new JButton("Eliminar Sucursal");
        JButton btnListar = new JButton("Listar Sucursals");
        JButton btnBuscarPorId = new JButton("Buscar Sucursal por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int direccionId = Integer.parseInt(direccionIdField.getText());
                    String descripcion = descripcionField.getText();
                    if (!descripcion.trim().isEmpty()) {
                        Sucursal sucursal = new Sucursal();
                        sucursal.setDireccionId(direccionId);
                        sucursal.setDescripcion(descripcion);
                        sucursalRepository.createSucursal(sucursal);
                        JOptionPane.showMessageDialog(null, "Sucursal creado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de dirección inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int sucursalId = Integer.parseInt(sucursalIdField.getText());
                    int direccionId = Integer.parseInt(direccionIdField.getText());
                    String descripcion = descripcionField.getText();
                    if (!descripcion.trim().isEmpty()) {
                        Sucursal sucursal = new Sucursal();
                        sucursal.setSucursalId(sucursalId);
                        sucursal.setDireccionId(direccionId);
                        sucursal.setDescripcion(descripcion);
                        sucursalRepository.updateSucursal(sucursal);
                        JOptionPane.showMessageDialog(null, "Sucursal actualizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de sucursal o dirección inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int sucursalId = Integer.parseInt(sucursalIdField.getText());
                    sucursalRepository.deleteSucursal(sucursalId);
                    JOptionPane.showMessageDialog(null, "Sucursal eliminado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de sucursal inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Sucursal> sucursalList = sucursalRepository.getAllSucursal();
                StringBuilder sb = new StringBuilder("Lista de Sucursals:\n");
                for (Sucursal sucursal : sucursalList) {
                    sb.append("ID: ").append(sucursal.getSucursalId()).append(", ");
                    sb.append("Direccion ID: ").append(sucursal.getDireccionId()).append(", ");
                    sb.append("Descripción: ").append(sucursal.getDescripcion()).append(", ");
                    sb.append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int sucursalId = Integer.parseInt(sucursalIdField.getText());
                    Optional<Sucursal> sucursalOptional = sucursalRepository.findSucursalById(sucursalId);
                    if (sucursalOptional.isPresent()) {
                        Sucursal sucursal = sucursalOptional.get();
                        JOptionPane.showMessageDialog(null, "Sucursal encontrado:\nID: " + sucursal.getSucursalId() +
                            ", Direccion ID: " + sucursal.getDireccionId() +
                            ", Descripción: " + sucursal.getDescripcion());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró Sucursal con ID: " + sucursalId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de sucursal inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(new JLabel("ID de Sucursal:"));
        panel.add(sucursalIdField);
        panel.add(new JLabel("Direccion ID:"));
        panel.add(direccionIdField);
        panel.add(new JLabel("Descripción:"));
        panel.add(descripcionField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeSucursalFrame.add(panel);
        gestionDeSucursalFrame.setVisible(true);
    }
}

