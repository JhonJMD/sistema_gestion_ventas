package com.sistema_gestion_ventas.factura.infrastructure.in;

import com.sistema_gestion_ventas.factura.domain.entity.Factura;
import com.sistema_gestion_ventas.factura.infrastructure.out.FacturaRepository;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class FacturaController {

    private FacturaRepository facturaRepository;

    public FacturaController() {
        this.facturaRepository = new FacturaRepository();
        crearVentanaGestionDeFactura();
    }

    private void crearVentanaGestionDeFactura() {
        JFrame gestionDeFacturaFrame = new JFrame("Gestión de Factura");
        gestionDeFacturaFrame.setSize(600, 500);
        gestionDeFacturaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeFacturaFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField ventaIdField = new JTextField(20);
        JTextField fechaFacturaField = new JTextField(20);
        JTextField metodoPagoIdField = new JTextField(20);
        JTextField descuentoPorcentajeField = new JTextField(20);
        JTextField facturaIdField = new JTextField(20); // Added for ID management

        JButton btnCrear = new JButton("Crear Factura");
        JButton btnActualizar = new JButton("Actualizar Factura");
        JButton btnEliminar = new JButton("Eliminar Factura");
        JButton btnListar = new JButton("Listar Facturas");
        JButton btnBuscarPorId = new JButton("Buscar Factura por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ventaId = Integer.parseInt(ventaIdField.getText());
                    Date fechaFactura = Date.valueOf(fechaFacturaField.getText()); // Expected format yyyy-MM-dd
                    int metodoPagoId = Integer.parseInt(metodoPagoIdField.getText());
                    double descuentoPorcentaje = Double.parseDouble(descuentoPorcentajeField.getText());

                    if (!ventaIdField.getText().trim().isEmpty() &&
                        !fechaFacturaField.getText().trim().isEmpty() &&
                        !metodoPagoIdField.getText().trim().isEmpty() &&
                        !descuentoPorcentajeField.getText().trim().isEmpty()) {

                        Factura factura = new Factura();
                        factura.setVentaId(ventaId);
                        factura.setFechaFactura(fechaFactura);
                        factura.setMetodoPagoId(metodoPagoId);
                        factura.setDescuentoPorcentaje(descuentoPorcentaje);
                        facturaRepository.createFactura(factura);
                        JOptionPane.showMessageDialog(null, "Factura creada exitosamente.");

                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID o porcentaje inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Fecha inválida. Debe estar en formato yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ventaId = Integer.parseInt(ventaIdField.getText());
                    Date fechaFactura = Date.valueOf(fechaFacturaField.getText());
                    int metodoPagoId = Integer.parseInt(metodoPagoIdField.getText());
                    double descuentoPorcentaje = Double.parseDouble(descuentoPorcentajeField.getText());

                    if (!ventaIdField.getText().trim().isEmpty() &&
                        !fechaFacturaField.getText().trim().isEmpty() &&
                        !metodoPagoIdField.getText().trim().isEmpty() &&
                        !descuentoPorcentajeField.getText().trim().isEmpty()) {

                        Factura factura = new Factura();
                        factura.setVentaId(ventaId);
                        factura.setFechaFactura(fechaFactura);
                        factura.setMetodoPagoId(metodoPagoId);
                        factura.setDescuentoPorcentaje(descuentoPorcentaje);
                        facturaRepository.updateFactura(factura);
                        JOptionPane.showMessageDialog(null, "Factura actualizada exitosamente.");

                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID o porcentaje inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Fecha inválida. Debe estar en formato yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String facturaIdStr = facturaIdField.getText();
                if (!facturaIdStr.trim().isEmpty()) {
                    try {
                        int facturaId = Integer.parseInt(facturaIdStr);
                        facturaRepository.deleteFactura(facturaId);
                        JOptionPane.showMessageDialog(null, "Factura eliminada exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Factura> facturaList = facturaRepository.getAllFactura();
                StringBuilder sb = new StringBuilder("Lista de Facturas:\n");
                for (Factura factura : facturaList) {
                    sb.append("ID: ").append(factura.getFacturaId()).append(", ");
                    sb.append("Venta ID: ").append(factura.getVentaId()).append(", ");
                    sb.append("Fecha Factura: ").append(factura.getFechaFactura()).append(", ");
                    sb.append("Método de Pago ID: ").append(factura.getMetodoPagoId()).append(", ");
                    sb.append("Descuento: ").append(factura.getDescuentoPorcentaje()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String facturaIdStr = facturaIdField.getText();
                if (!facturaIdStr.trim().isEmpty()) {
                    try {
                        int facturaId = Integer.parseInt(facturaIdStr);
                        Optional<Factura> facturaOptional = facturaRepository.findFacturaById(facturaId);
                        if (facturaOptional.isPresent()) {
                            Factura factura = facturaOptional.get();
                            JOptionPane.showMessageDialog(null, "Factura encontrada:\n" +
                                "ID: " + factura.getFacturaId() + "\n" +
                                "Venta ID: " + factura.getVentaId() + "\n" +
                                "Fecha Factura: " + factura.getFechaFactura() + "\n" +
                                "Método de Pago ID: " + factura.getMetodoPagoId() + "\n" +
                                "Descuento: " + factura.getDescuentoPorcentaje());
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró Factura con ID: " + facturaId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        panel.add(new JLabel("ID de Factura:"));
        panel.add(facturaIdField);
        panel.add(new JLabel("Venta ID:"));
        panel.add(ventaIdField);
        panel.add(new JLabel("Fecha Factura (yyyy-MM-dd):"));
        panel.add(fechaFacturaField);
        panel.add(new JLabel("Método de Pago ID:"));
        panel.add(metodoPagoIdField);
        panel.add(new JLabel("Descuento (%) :"));
        panel.add(descuentoPorcentajeField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeFacturaFrame.add(panel);
        gestionDeFacturaFrame.setVisible(true);
    }
}

