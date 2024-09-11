package com.sistema_gestion_ventas.inventario.infrastructure.in;

import com.sistema_gestion_ventas.inventario.domain.entity.Inventario;
import com.sistema_gestion_ventas.inventario.infrastructure.out.InventarioRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class InventarioController {

    private InventarioRepository inventarioRepository;

    public InventarioController() {
        this.inventarioRepository = new InventarioRepository();
        crearVentanaGestionDeInventario();
    }

    private void crearVentanaGestionDeInventario() {
        JFrame gestionDeInventarioFrame = new JFrame("Gestión de Inventario");
        gestionDeInventarioFrame.setSize(600, 500);
        gestionDeInventarioFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeInventarioFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JTextField sucursalIdField = new JTextField(20);
        JTextField stockField = new JTextField(20);
        JTextField productoIdField = new JTextField(20);
        
        JButton btnCrear = new JButton("Crear Inventario");
        JButton btnActualizar = new JButton("Actualizar Inventario");
        JButton btnEliminar = new JButton("Eliminar Inventario");
        JButton btnListar = new JButton("Listar Inventarios");
        JButton btnBuscarPorId = new JButton("Buscar Inventario por ID");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Sucursal ID:"), gbc);
        gbc.gridx = 1;
        panel.add(sucursalIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Stock:"), gbc);
        gbc.gridx = 1;
        panel.add(stockField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Producto ID (para Actualizar/Eliminar/Buscar):"), gbc);
        gbc.gridx = 1;
        panel.add(productoIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(btnCrear, gbc);
        gbc.gridx = 1;
        panel.add(btnActualizar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(btnEliminar, gbc);
        gbc.gridx = 1;
        panel.add(btnListar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(btnBuscarPorId, gbc);

        // Action for Crear
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int sucursalId = Integer.parseInt(sucursalIdField.getText().trim());
                    int stock = Integer.parseInt(stockField.getText().trim());

                    Inventario inventario = new Inventario();
                    inventario.setSucursalId(sucursalId);
                    inventario.setStock(stock);
                    inventarioRepository.createInventario(inventario);
                    JOptionPane.showMessageDialog(null, "Inventario creado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en los datos ingresados. Verifique que todos los campos sean válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Actualizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int productoId = Integer.parseInt(productoIdField.getText().trim());
                    int sucursalId = Integer.parseInt(sucursalIdField.getText().trim());
                    int stock = Integer.parseInt(stockField.getText().trim());

                    Inventario inventario = new Inventario();
                    inventario.setProductoId(productoId);
                    inventario.setSucursalId(sucursalId);
                    inventario.setStock(stock);
                    inventarioRepository.updateInventario(inventario);
                    JOptionPane.showMessageDialog(null, "Inventario actualizado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error en los datos ingresados. Verifique que todos los campos sean válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int productoId = Integer.parseInt(productoIdField.getText().trim());
                    inventarioRepository.deleteInventario(productoId);
                    JOptionPane.showMessageDialog(null, "Inventario eliminado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for Listar
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Inventario> inventarioList = inventarioRepository.getAllInventario();
                StringBuilder sb = new StringBuilder("Lista de Inventarios:\n");
                for (Inventario inventario : inventarioList) {
                    sb.append("ID: ").append(inventario.getProductoId()).append(", ");
                    sb.append("Sucursal ID: ").append(inventario.getSucursalId()).append(", ");
                    sb.append("Stock: ").append(inventario.getStock()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        // Action for Buscar por ID
        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int productoId = Integer.parseInt(productoIdField.getText().trim());
                    Optional<Inventario> inventarioOptional = inventarioRepository.findInventarioById(productoId);
                    if (inventarioOptional.isPresent()) {
                        Inventario inventario = inventarioOptional.get();
                        String message = "Inventario encontrado:\n";
                        message += "ID: " + inventario.getProductoId() + "\n";
                        message += "Sucursal ID: " + inventario.getSucursalId() + "\n";
                        message += "Stock: " + inventario.getStock();
                        JOptionPane.showMessageDialog(null, message);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró Inventario con ID: " + productoId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        gestionDeInventarioFrame.add(panel);
        gestionDeInventarioFrame.setVisible(true);
    }
}

