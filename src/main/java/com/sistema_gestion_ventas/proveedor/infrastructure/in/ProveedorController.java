package com.sistema_gestion_ventas.proveedor.infrastructure.in;

import com.sistema_gestion_ventas.proveedor.domain.entity.Proveedor;
import com.sistema_gestion_ventas.proveedor.infrastructure.out.ProveedorRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class ProveedorController {

    private ProveedorRepository proveedorRepository;

    public ProveedorController() {
        this.proveedorRepository = new ProveedorRepository();
        crearVentanaGestionDeProveedor();
    }

    private void crearVentanaGestionDeProveedor() {
        JFrame gestionDeProveedorFrame = new JFrame("Gestión de Proveedor");
        gestionDeProveedorFrame.setSize(600, 500);
        gestionDeProveedorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeProveedorFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField proveedorIdField = new JTextField(20);
        proveedorIdField.setPreferredSize(new Dimension(200, 30));
        JTextField tipoDocumentoIdField = new JTextField(20);
        tipoDocumentoIdField.setPreferredSize(new Dimension(200, 30));
        JTextField tipoPersonaIdField = new JTextField(20);
        tipoPersonaIdField.setPreferredSize(new Dimension(200, 30));
        JTextField nombreField = new JTextField(20);
        nombreField.setPreferredSize(new Dimension(200, 30));
        JTextField direccionIdField = new JTextField(20);
        direccionIdField.setPreferredSize(new Dimension(200, 30));
        JTextField telefonoIdField = new JTextField(20);
        telefonoIdField.setPreferredSize(new Dimension(200, 30));
        JTextField emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(200, 30));
        JButton btnCrear = new JButton("Crear Proveedor");
        JButton btnActualizar = new JButton("Actualizar Proveedor");
        JButton btnEliminar = new JButton("Eliminar Proveedor");
        JButton btnListar = new JButton("Listar Proveedores");
        JButton btnBuscarPorId = new JButton("Buscar Proveedor por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tipoDocumentoId = Integer.parseInt(tipoDocumentoIdField.getText());
                    int tipoPersonaId = Integer.parseInt(tipoPersonaIdField.getText());
                    String nombre = nombreField.getText().trim();
                    int direccionId = Integer.parseInt(direccionIdField.getText());
                    int telefonoId = Integer.parseInt(telefonoIdField.getText());
                    String email = emailField.getText().trim();
                    
                    if (!tipoDocumentoIdField.getText().trim().isEmpty() &&
                        !tipoPersonaIdField.getText().trim().isEmpty() &&
                        !nombre.isEmpty() &&
                        !direccionIdField.getText().trim().isEmpty() &&
                        !telefonoIdField.getText().trim().isEmpty() &&
                        !email.isEmpty()) {

                        Proveedor proveedor = new Proveedor();
                        proveedor.setTipoDocumentoId(tipoDocumentoId);
                        proveedor.setTipoPersonaId(tipoPersonaId);
                        proveedor.setNombre(nombre);
                        proveedor.setDireccionId(direccionId);
                        proveedor.setTelefonoId(telefonoId);
                        proveedor.setEmail(email);
                        proveedorRepository.createProveedor(proveedor);
                        JOptionPane.showMessageDialog(null, "Proveedor creado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String proveedorId = proveedorIdField.getText().trim();
                    int tipoDocumentoId = Integer.parseInt(tipoDocumentoIdField.getText());
                    int tipoPersonaId = Integer.parseInt(tipoPersonaIdField.getText());
                    String nombre = nombreField.getText().trim();
                    int direccionId = Integer.parseInt(direccionIdField.getText());
                    int telefonoId = Integer.parseInt(telefonoIdField.getText());
                    String email = emailField.getText().trim();
                    
                    if (!proveedorId.isEmpty() &&
                        !tipoDocumentoIdField.getText().trim().isEmpty() &&
                        !tipoPersonaIdField.getText().trim().isEmpty() &&
                        !nombre.isEmpty() &&
                        !direccionIdField.getText().trim().isEmpty() &&
                        !telefonoIdField.getText().trim().isEmpty() &&
                        !email.isEmpty()) {

                        Proveedor proveedor = new Proveedor();
                        proveedor.setProveedorId(proveedorId);
                        proveedor.setTipoDocumentoId(tipoDocumentoId);
                        proveedor.setTipoPersonaId(tipoPersonaId);
                        proveedor.setNombre(nombre);
                        proveedor.setDireccionId(direccionId);
                        proveedor.setTelefonoId(telefonoId);
                        proveedor.setEmail(email);
                        proveedorRepository.updateProveedor(proveedor);
                        JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String proveedorId = proveedorIdField.getText().trim();
                if (!proveedorId.isEmpty()) {
                    proveedorRepository.deleteProveedor(proveedorId);
                    JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "ID de proveedor es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Proveedor> proveedorList = proveedorRepository.getAllProveedor();
                StringBuilder sb = new StringBuilder("Lista de Proveedores:\n");
                for (Proveedor proveedor : proveedorList) {
                    sb.append("ID: ").append(proveedor.getProveedorId()).append(", ");
                    sb.append("Tipo Documento ID: ").append(proveedor.getTipoDocumentoId()).append(", ");
                    sb.append("Tipo Persona ID: ").append(proveedor.getTipoPersonaId()).append(", ");
                    sb.append("Nombre: ").append(proveedor.getNombre()).append(", ");
                    sb.append("Direccion ID: ").append(proveedor.getDireccionId()).append(", ");
                    sb.append("Telefono ID: ").append(proveedor.getTelefonoId()).append(", ");
                    sb.append("Email: ").append(proveedor.getEmail()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String proveedorId = proveedorIdField.getText().trim();
                if (!proveedorId.isEmpty()) {
                    Optional<Proveedor> proveedorOptional = proveedorRepository.findProveedorById(proveedorId);
                    if (proveedorOptional.isPresent()) {
                        Proveedor proveedor = proveedorOptional.get();
                        String message = String.format("Proveedor encontrado:\nID: %s\nTipo Documento ID: %d\nTipo Persona ID: %d\nNombre: %s\nDireccion ID: %d\nTelefono ID: %d\nEmail: %s",
                            proveedor.getProveedorId(),
                            proveedor.getTipoDocumentoId(),
                            proveedor.getTipoPersonaId(),
                            proveedor.getNombre(),
                            proveedor.getDireccionId(),
                            proveedor.getTelefonoId(),
                            proveedor.getEmail());
                        JOptionPane.showMessageDialog(null, message);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró Proveedor con ID: " + proveedorId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID de proveedor es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(new JLabel("ID de Proveedor:"));
        panel.add(proveedorIdField);
        panel.add(new JLabel("Tipo Documento ID de Proveedor:"));
        panel.add(tipoDocumentoIdField);
        panel.add(new JLabel("Tipo Persona ID de Proveedor:"));
        panel.add(tipoPersonaIdField);
        panel.add(new JLabel("Nombre de Proveedor:"));
        panel.add(nombreField);
        panel.add(new JLabel("Direccion ID de Proveedor:"));
        panel.add(direccionIdField);
        panel.add(new JLabel("Telefono ID de Proveedor:"));
        panel.add(telefonoIdField);
        panel.add(new JLabel("Email de Proveedor:"));
        panel.add(emailField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeProveedorFrame.add(panel);
        gestionDeProveedorFrame.setVisible(true);
    }
}


