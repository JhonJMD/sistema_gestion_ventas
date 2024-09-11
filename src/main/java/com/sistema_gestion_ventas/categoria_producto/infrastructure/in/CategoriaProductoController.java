package com.sistema_gestion_ventas.categoria_producto.infrastructure.in;

import com.sistema_gestion_ventas.categoria_producto.domain.entity.CategoriaProducto;
import com.sistema_gestion_ventas.categoria_producto.infrastructure.out.CategoriaProductoRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class CategoriaProductoController {

    private CategoriaProductoRepository categoriaProductoRepository;

    public CategoriaProductoController() {
        this.categoriaProductoRepository = new CategoriaProductoRepository();
        crearVentanaGestionDeCategoriaProducto();
    }

    private void crearVentanaGestionDeCategoriaProducto() {
        JFrame gestionDeCategoriaProductoFrame = new JFrame("Gestión de CategoriaProducto");
        gestionDeCategoriaProductoFrame.setSize(600, 500);
        gestionDeCategoriaProductoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeCategoriaProductoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField categoriaProductoIdField = new JTextField(20);
        categoriaProductoIdField.setPreferredSize(new Dimension(200, 30));
        JTextField nombreField = new JTextField(20);
        nombreField.setPreferredSize(new Dimension(200, 30));
        JTextField descripcionField = new JTextField(20);
        descripcionField.setPreferredSize(new Dimension(200, 30));

        JButton btnCrear = new JButton("Crear CategoriaProducto");
        JButton btnActualizar = new JButton("Actualizar CategoriaProducto");
        JButton btnEliminar = new JButton("Eliminar CategoriaProducto");
        JButton btnListar = new JButton("Listar CategoriaProductos");
        JButton btnBuscarPorId = new JButton("Buscar CategoriaProducto por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String descripcion = descripcionField.getText();
                if (!nombre.trim().isEmpty() && !descripcion.trim().isEmpty()) {
                    CategoriaProducto categoriaProducto = new CategoriaProducto();
                    categoriaProducto.setNombre(nombre);
                    categoriaProducto.setDescripcion(descripcion);
                    categoriaProductoRepository.createCategoriaProducto(categoriaProducto);
                    JOptionPane.showMessageDialog(null, "CategoriaProducto creado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int categoriaProductoId = Integer.parseInt(categoriaProductoIdField.getText());
                    String nombre = nombreField.getText();
                    String descripcion = descripcionField.getText();
                    if (!nombre.trim().isEmpty() && !descripcion.trim().isEmpty()) {
                        CategoriaProducto categoriaProducto = new CategoriaProducto();
                        categoriaProducto.setCategoriaProductoId(categoriaProductoId);
                        categoriaProducto.setNombre(nombre);
                        categoriaProducto.setDescripcion(descripcion);
                        categoriaProductoRepository.updateCategoriaProducto(categoriaProducto);
                        JOptionPane.showMessageDialog(null, "CategoriaProducto actualizado exitosamente.");
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
                    int categoriaProductoId = Integer.parseInt(categoriaProductoIdField.getText());
                    categoriaProductoRepository.deleteCategoriaProducto(categoriaProductoId);
                    JOptionPane.showMessageDialog(null, "CategoriaProducto eliminado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<CategoriaProducto> categoriaProductoList = categoriaProductoRepository.getAllCategoriaProducto();
                StringBuilder sb = new StringBuilder("Lista de CategoriaProductos:\n");
                for (CategoriaProducto categoriaProducto : categoriaProductoList) {
                    sb.append("ID: ").append(categoriaProducto.getCategoriaProductoId()).append(", ");
                    sb.append("Nombre: ").append(categoriaProducto.getNombre()).append(", ");
                    sb.append("Descripción: ").append(categoriaProducto.getDescripcion()).append(", ");
                    sb.append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int categoriaProductoId = Integer.parseInt(categoriaProductoIdField.getText());
                    Optional<CategoriaProducto> categoriaProductoOptional = categoriaProductoRepository.findCategoriaProductoById(categoriaProductoId);
                    if (categoriaProductoOptional.isPresent()) {
                        CategoriaProducto categoriaProducto = categoriaProductoOptional.get();
                        JOptionPane.showMessageDialog(null, "CategoriaProducto encontrado:\nID: " + categoriaProducto.getCategoriaProductoId() +
                            "\nNombre: " + categoriaProducto.getNombre() +
                            "\nDescripción: " + categoriaProducto.getDescripcion());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró CategoriaProducto con ID: " + categoriaProductoId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(new JLabel("ID de CategoriaProducto:"));
        panel.add(categoriaProductoIdField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Descripción:"));
        panel.add(descripcionField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeCategoriaProductoFrame.add(panel);
        gestionDeCategoriaProductoFrame.setVisible(true);
    }
}

