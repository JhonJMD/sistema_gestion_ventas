package com.sistema_gestion_ventas.producto.infrastructure.in;

import com.sistema_gestion_ventas.producto.domain.entity.Producto;
import com.sistema_gestion_ventas.producto.infrastructure.out.ProductoRepository;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class ProductoController {

    private ProductoRepository productoRepository;

    public ProductoController() {
        this.productoRepository = new ProductoRepository();
        crearVentanaGestionDeProducto();
    }

    private void crearVentanaGestionDeProducto() {
        JFrame gestionDeProductoFrame = new JFrame("Gestión de Producto");
        gestionDeProductoFrame.setSize(600, 500);
        gestionDeProductoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeProductoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField codigoBarrasField = new JTextField(20);
        JTextField nombreField = new JTextField(20);
        JTextField descripcionField = new JTextField(20);
        JTextField precioField = new JTextField(20);
        JTextField categoriaProductoIdField = new JTextField(20);
        JTextField productoIdField = new JTextField(20); // Añadir campo para ID del producto

        JButton btnCrear = new JButton("Crear Producto");
        JButton btnActualizar = new JButton("Actualizar Producto");
        JButton btnEliminar = new JButton("Eliminar Producto");
        JButton btnListar = new JButton("Listar Productos");
        JButton btnBuscarPorId = new JButton("Buscar Producto por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String codigoBarras = codigoBarrasField.getText().trim();
                    String nombre = nombreField.getText().trim();
                    String descripcion = descripcionField.getText().trim();
                    double precio = Double.parseDouble(precioField.getText().trim());
                    int categoriaProductoId = Integer.parseInt(categoriaProductoIdField.getText().trim());

                    if (!codigoBarras.isEmpty() && !nombre.isEmpty() && !descripcion.isEmpty() && !precioField.getText().isEmpty() && !categoriaProductoIdField.getText().isEmpty()) {
                        Producto producto = new Producto();
                        producto.setCodigoBarras(codigoBarras);
                        producto.setNombre(nombre);
                        producto.setDescripcion(descripcion);
                        producto.setPrecio(precio);
                        producto.setCategoriaProductoId(categoriaProductoId);
                        productoRepository.createProducto(producto);
                        JOptionPane.showMessageDialog(null, "Producto creado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de número inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String codigoBarras = codigoBarrasField.getText().trim();
                    String nombre = nombreField.getText().trim();
                    String descripcion = descripcionField.getText().trim();
                    double precio = Double.parseDouble(precioField.getText().trim());
                    int categoriaProductoId = Integer.parseInt(categoriaProductoIdField.getText().trim());

                    if (!codigoBarras.isEmpty() && !nombre.isEmpty() && !descripcion.isEmpty() && !precioField.getText().isEmpty() && !categoriaProductoIdField.getText().isEmpty()) {
                        Producto producto = new Producto();
                        producto.setCodigoBarras(codigoBarras);
                        producto.setNombre(nombre);
                        producto.setDescripcion(descripcion);
                        producto.setPrecio(precio);
                        producto.setCategoriaProductoId(categoriaProductoId);
                        productoRepository.updateProducto(producto);
                        JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de número inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int productoId = Integer.parseInt(productoIdField.getText().trim());
                    productoRepository.deleteProducto(productoId);
                    JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Producto> productoList = productoRepository.getAllProducto();
                StringBuilder sb = new StringBuilder("Lista de Productos:\n");
                for (Producto producto : productoList) {
                    sb.append(String.format("ID: %d, codigoBarras: %s, nombre: %s, descripcion: %s, precio: %.2f, categoriaProductoId: %d%n",
                            producto.getProductoId(),
                            producto.getCodigoBarras(),
                            producto.getNombre(),
                            producto.getDescripcion(),
                            producto.getPrecio(),
                            producto.getCategoriaProductoId()));
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int productoId = Integer.parseInt(productoIdField.getText().trim());
                    Optional<Producto> productoOptional = productoRepository.findProductoById(productoId);
                    if (productoOptional.isPresent()) {
                        Producto producto = productoOptional.get();
                        String message = String.format("Producto encontrado:\nID: %d\ncodigoBarras: %s\nnombre: %s\ndescripcion: %s\nprecio: %.2f\ncategoriaProductoId: %d",
                                producto.getProductoId(),
                                producto.getCodigoBarras(),
                                producto.getNombre(),
                                producto.getDescripcion(),
                                producto.getPrecio(),
                                producto.getCategoriaProductoId());
                        JOptionPane.showMessageDialog(null, message);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró Producto con ID: " + productoId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(new JLabel("Código de Barras:"));
        panel.add(codigoBarrasField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Descripción:"));
        panel.add(descripcionField);
        panel.add(new JLabel("Precio:"));
        panel.add(precioField);
        panel.add(new JLabel("Categoría Producto ID:"));
        panel.add(categoriaProductoIdField);
        panel.add(new JLabel("ID del Producto:")); // Añadir etiqueta para el campo ID
        panel.add(productoIdField); // Añadir campo para ID del producto
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeProductoFrame.add(panel);
        gestionDeProductoFrame.setVisible(true);
    }
}

