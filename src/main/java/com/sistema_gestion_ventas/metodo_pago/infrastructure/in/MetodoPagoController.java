package com.sistema_gestion_ventas.metodo_pago.infrastructure.in;

import com.sistema_gestion_ventas.metodo_pago.domain.entity.MetodoPago;
import com.sistema_gestion_ventas.metodo_pago.infrastructure.out.MetodoPagoRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class MetodoPagoController {

    private MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoController() {
        this.metodoPagoRepository = new MetodoPagoRepository();
        crearVentanaGestionDeMetodoPago();
    }

    private void crearVentanaGestionDeMetodoPago() {
        JFrame gestionDeMetodoPagoFrame = new JFrame("Gestión de MetodoPago");
        gestionDeMetodoPagoFrame.setSize(600, 500);
        gestionDeMetodoPagoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeMetodoPagoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField metodoPagoIdField = new JTextField(20);
        JTextField descripcionField = new JTextField(20);
        descripcionField.setPreferredSize(new Dimension(200, 30));
        
        JButton btnCrear = new JButton("Crear MetodoPago");
        JButton btnActualizar = new JButton("Actualizar MetodoPago");
        JButton btnEliminar = new JButton("Eliminar MetodoPago");
        JButton btnListar = new JButton("Listar MetodoPagos");
        JButton btnBuscarPorId = new JButton("Buscar MetodoPago por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = descripcionField.getText();
                if (isNotEmpty(descripcion)) {
                    MetodoPago metodoPago = new MetodoPago();
                    metodoPago.setDescripcion(descripcion);
                    metodoPagoRepository.createMetodoPago(metodoPago);
                    JOptionPane.showMessageDialog(null, "MetodoPago creado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = descripcionField.getText();
                if (isNotEmpty(descripcion)) {
                    try {
                        MetodoPago metodoPago = new MetodoPago();
                        metodoPago.setDescripcion(descripcion);
                        metodoPagoRepository.updateMetodoPago(metodoPago);
                        JOptionPane.showMessageDialog(null, "MetodoPago actualizado exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Error al actualizar MetodoPago.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String metodoPagoIdStr = metodoPagoIdField.getText();
                if (isNotEmpty(metodoPagoIdStr)) {
                    try {
                        int metodoPagoId = Integer.parseInt(metodoPagoIdStr);
                        metodoPagoRepository.deleteMetodoPago(metodoPagoId);
                        JOptionPane.showMessageDialog(null, "MetodoPago eliminado exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El campo ID es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<MetodoPago> metodoPagoList = metodoPagoRepository.getAllMetodoPago();
                StringBuilder sb = new StringBuilder("Lista de MetodoPagos:\n");
                for (MetodoPago metodoPago : metodoPagoList) {
                    sb.append("ID: ").append(metodoPago.getMetodoPagoId()).append(", ");
                    sb.append("descripcion: ").append(metodoPago.getDescripcion()).append(", ");
                    sb.append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String metodoPagoIdStr = metodoPagoIdField.getText();
                if (isNotEmpty(metodoPagoIdStr)) {
                    try {
                        int metodoPagoId = Integer.parseInt(metodoPagoIdStr);
                        Optional<MetodoPago> metodoPagoOptional = metodoPagoRepository.findMetodoPagoById(metodoPagoId);
                        if (metodoPagoOptional.isPresent()) {
                            MetodoPago metodoPago = metodoPagoOptional.get();
                            JOptionPane.showMessageDialog(null, String.format("MetodoPago encontrado:\nID: %d\nDescripcion: %s",
                                    metodoPago.getMetodoPagoId(), metodoPago.getDescripcion()));
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró MetodoPago con ID: " + metodoPagoId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El campo ID es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(new JLabel("ID de MetodoPago:"));
        panel.add(metodoPagoIdField);
        panel.add(new JLabel("Descripción de MetodoPago:"));
        panel.add(descripcionField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeMetodoPagoFrame.add(panel);
        gestionDeMetodoPagoFrame.setVisible(true);
    }

    private boolean isNotEmpty(String... values) {
        for (String value : values) {
            if (value == null || value.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
