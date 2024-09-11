package com.sistema_gestion_ventas.tipo_pedido.infrastructure.in;

import com.sistema_gestion_ventas.tipo_pedido.domain.entity.TipoPedido;
import com.sistema_gestion_ventas.tipo_pedido.infrastructure.out.TipoPedidoRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class TipoPedidoController {

    private TipoPedidoRepository tipoPedidoRepository;

    public TipoPedidoController() {
        this.tipoPedidoRepository = new TipoPedidoRepository();
        crearVentanaGestionDeTipoPedido();
    }

    private void crearVentanaGestionDeTipoPedido() {
        JFrame gestionDeTipoPedidoFrame = new JFrame("Gestión de TipoPedido");
        gestionDeTipoPedidoFrame.setSize(600, 500);
        gestionDeTipoPedidoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeTipoPedidoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField tipoPedidoIdField = new JTextField(20);
        JTextField descripcionField = new JTextField(20);

        JButton btnCrear = new JButton("Crear TipoPedido");
        JButton btnActualizar = new JButton("Actualizar TipoPedido");
        JButton btnEliminar = new JButton("Eliminar TipoPedido");
        JButton btnListar = new JButton("Listar TipoPedidos");
        JButton btnBuscarPorId = new JButton("Buscar TipoPedido por ID");

        // Layout configuration
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID de TipoPedido:"), gbc);
        gbc.gridx = 1;
        panel.add(tipoPedidoIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Descripción:"), gbc);
        gbc.gridx = 1;
        panel.add(descripcionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(btnCrear, gbc);
        gbc.gridx = 1;
        panel.add(btnActualizar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(btnEliminar, gbc);
        gbc.gridx = 1;
        panel.add(btnListar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(btnBuscarPorId, gbc);

        // Action for Crear
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = descripcionField.getText();
                if (!descripcion.trim().isEmpty()) {
                    TipoPedido tipoPedido = new TipoPedido();
                    tipoPedido.setDescripcion(descripcion);
                    tipoPedidoRepository.createTipoPedido(tipoPedido);
                    JOptionPane.showMessageDialog(null, "TipoPedido creado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Descripción es obligatoria.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Actualizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descripcion = descripcionField.getText();
                String tipoPedidoIdStr = tipoPedidoIdField.getText();
                if (!descripcion.trim().isEmpty() && !tipoPedidoIdStr.trim().isEmpty()) {
                    try {
                        int tipoPedidoId = Integer.parseInt(tipoPedidoIdStr);
                        TipoPedido tipoPedido = new TipoPedido();
                        tipoPedido.setTipoPedidoId(tipoPedidoId);
                        tipoPedido.setDescripcion(descripcion);
                        tipoPedidoRepository.updateTipoPedido(tipoPedido);
                        JOptionPane.showMessageDialog(null, "TipoPedido actualizado exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoPedidoIdStr = tipoPedidoIdField.getText();
                if (!tipoPedidoIdStr.trim().isEmpty()) {
                    try {
                        int tipoPedidoId = Integer.parseInt(tipoPedidoIdStr);
                        tipoPedidoRepository.deleteTipoPedido(tipoPedidoId);
                        JOptionPane.showMessageDialog(null, "TipoPedido eliminado exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Listar
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<TipoPedido> tipoPedidoList = tipoPedidoRepository.getAllTipoPedido();
                StringBuilder sb = new StringBuilder("Lista de TipoPedidos:\n");
                for (TipoPedido tipoPedido : tipoPedidoList) {
                    sb.append("ID: ").append(tipoPedido.getTipoPedidoId()).append(", ");
                    sb.append("Descripción: ").append(tipoPedido.getDescripcion()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        // Action for Buscar por ID
        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipoPedidoIdStr = tipoPedidoIdField.getText();
                if (!tipoPedidoIdStr.trim().isEmpty()) {
                    try {
                        int tipoPedidoId = Integer.parseInt(tipoPedidoIdStr);
                        Optional<TipoPedido> tipoPedidoOptional = tipoPedidoRepository.findTipoPedidoById(tipoPedidoId);
                        if (tipoPedidoOptional.isPresent()) {
                            TipoPedido tipoPedido = tipoPedidoOptional.get();
                            String message = "TipoPedido encontrado:\n";
                            message += "ID: " + tipoPedido.getTipoPedidoId() + "\n";
                            message += "Descripción: " + tipoPedido.getDescripcion();
                            JOptionPane.showMessageDialog(null, message);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró TipoPedido con ID: " + tipoPedidoId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gestionDeTipoPedidoFrame.add(panel);
        gestionDeTipoPedidoFrame.setVisible(true);
    }
}

