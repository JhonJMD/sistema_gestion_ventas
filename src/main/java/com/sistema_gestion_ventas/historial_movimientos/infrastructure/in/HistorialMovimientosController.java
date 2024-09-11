package com.sistema_gestion_ventas.historial_movimientos.infrastructure.in;

import com.sistema_gestion_ventas.historial_movimientos.domain.entity.HistorialMovimientos;
import com.sistema_gestion_ventas.historial_movimientos.infrastructure.out.HistorialMovimientosRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class HistorialMovimientosController {

    private HistorialMovimientosRepository historial_movimientosRepository;

    public HistorialMovimientosController() {
        this.historial_movimientosRepository = new HistorialMovimientosRepository();
        crearVentanaGestionDeHistorialMovimientos();
    }

    private void crearVentanaGestionDeHistorialMovimientos() {
        JFrame gestionDeHistorialMovimientosFrame = new JFrame("Gestión de HistorialMovimientos");
        gestionDeHistorialMovimientosFrame.setSize(600, 500);
        gestionDeHistorialMovimientosFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeHistorialMovimientosFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField productoIdField = new JTextField(20);
        JTextField sucursalIdField = new JTextField(20);
        JTextField tipoMovimientoIdField = new JTextField(20);
        JTextField cantidadField = new JTextField(20);
        JTextField fechaMovimientoField = new JTextField(20);
        JTextField movimientoIdField = new JTextField(20);
        
        JButton btnCrear = new JButton("Crear HistorialMovimientos");
        JButton btnActualizar = new JButton("Actualizar HistorialMovimientos");
        JButton btnEliminar = new JButton("Eliminar HistorialMovimientos");
        JButton btnListar = new JButton("Listar HistorialMovimientos");
        JButton btnBuscarPorId = new JButton("Buscar HistorialMovimientos por ID");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("productoId:"), gbc);
        gbc.gridx = 1;
        panel.add(productoIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("sucursalId:"), gbc);
        gbc.gridx = 1;
        panel.add(sucursalIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("tipoMovimientoId:"), gbc);
        gbc.gridx = 1;
        panel.add(tipoMovimientoIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("cantidad:"), gbc);
        gbc.gridx = 1;
        panel.add(cantidadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("fechaMovimiento:"), gbc);
        gbc.gridx = 1;
        panel.add(fechaMovimientoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("ID de HistorialMovimientos (para Actualizar/Eliminar/Buscar):"), gbc);
        gbc.gridx = 1;
        panel.add(movimientoIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(btnCrear, gbc);
        gbc.gridx = 1;
        panel.add(btnActualizar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(btnEliminar, gbc);
        gbc.gridx = 1;
        panel.add(btnListar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        panel.add(btnBuscarPorId, gbc);

        // Action for Crear
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int productoId = Integer.parseInt(productoIdField.getText().trim());
                    int sucursalId = Integer.parseInt(sucursalIdField.getText().trim());
                    int tipoMovimientoId = Integer.parseInt(tipoMovimientoIdField.getText().trim());
                    int cantidad = Integer.parseInt(cantidadField.getText().trim());
                    Date fechaMovimiento = Date.valueOf(fechaMovimientoField.getText().trim());  // Expect yyyy-MM-dd

                    HistorialMovimientos historial_movimientos = new HistorialMovimientos();
                    historial_movimientos.setProductoId(productoId);
                    historial_movimientos.setSucursalId(sucursalId);
                    historial_movimientos.setTipoMovimientoId(tipoMovimientoId);
                    historial_movimientos.setCantidad(cantidad);
                    historial_movimientos.setFechaMovimiento(fechaMovimiento);
                    historial_movimientosRepository.createHistorialMovimientos(historial_movimientos);
                    JOptionPane.showMessageDialog(null, "HistorialMovimientos creado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en los datos ingresados. Verifique que todos los campos sean válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el formato de la fecha. Debe ser yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Actualizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int movimientoId = Integer.parseInt(movimientoIdField.getText().trim());
                    int productoId = Integer.parseInt(productoIdField.getText().trim());
                    int sucursalId = Integer.parseInt(sucursalIdField.getText().trim());
                    int tipoMovimientoId = Integer.parseInt(tipoMovimientoIdField.getText().trim());
                    int cantidad = Integer.parseInt(cantidadField.getText().trim());
                    Date fechaMovimiento = Date.valueOf(fechaMovimientoField.getText().trim());  // Expect yyyy-MM-dd

                    HistorialMovimientos historial_movimientos = new HistorialMovimientos();
                    historial_movimientos.setMovimientoId(movimientoId);
                    historial_movimientos.setProductoId(productoId);
                    historial_movimientos.setSucursalId(sucursalId);
                    historial_movimientos.setTipoMovimientoId(tipoMovimientoId);
                    historial_movimientos.setCantidad(cantidad);
                    historial_movimientos.setFechaMovimiento(fechaMovimiento);
                    historial_movimientosRepository.updateHistorialMovimientos(historial_movimientos);
                    JOptionPane.showMessageDialog(null, "HistorialMovimientos actualizado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en los datos ingresados. Verifique que todos los campos sean válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el formato de la fecha. Debe ser yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int movimientoId = Integer.parseInt(movimientoIdField.getText().trim());
                    historial_movimientosRepository.deleteHistorialMovimientos(movimientoId);
                    JOptionPane.showMessageDialog(null, "HistorialMovimientos eliminado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Listar
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<HistorialMovimientos> historial_movimientosList = historial_movimientosRepository.getAllHistorialMovimientos();
                StringBuilder sb = new StringBuilder("Lista de HistorialMovimientos:\n");
                for (HistorialMovimientos historial_movimientos : historial_movimientosList) {
                    sb.append("ID: ").append(historial_movimientos.getMovimientoId()).append(", ");
                    sb.append("productoId: ").append(historial_movimientos.getProductoId()).append(", ");
                    sb.append("sucursalId: ").append(historial_movimientos.getSucursalId()).append(", ");
                    sb.append("tipoMovimientoId: ").append(historial_movimientos.getTipoMovimientoId()).append(", ");
                    sb.append("cantidad: ").append(historial_movimientos.getCantidad()).append(", ");
                    sb.append("fechaMovimiento: ").append(historial_movimientos.getFechaMovimiento()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        // Action for Buscar por ID
        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int movimientoId = Integer.parseInt(movimientoIdField.getText().trim());
                    Optional<HistorialMovimientos> historial_movimientosOptional = historial_movimientosRepository.findHistorialMovimientosById(movimientoId);
                    if (historial_movimientosOptional.isPresent()) {
                        HistorialMovimientos historial_movimientos = historial_movimientosOptional.get();
                        String message = "HistorialMovimientos encontrado:\n";
                        message += "ID: " + historial_movimientos.getMovimientoId() + "\n";
                        message += "productoId: " + historial_movimientos.getProductoId() + "\n";
                        message += "sucursalId: " + historial_movimientos.getSucursalId() + "\n";
                        message += "tipoMovimientoId: " + historial_movimientos.getTipoMovimientoId() + "\n";
                        message += "cantidad: " + historial_movimientos.getCantidad() + "\n";
                        message += "fechaMovimiento: " + historial_movimientos.getFechaMovimiento();
                        JOptionPane.showMessageDialog(null, message);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró HistorialMovimientos con ID: " + movimientoId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gestionDeHistorialMovimientosFrame.add(panel);
        gestionDeHistorialMovimientosFrame.setVisible(true);
    }
}

