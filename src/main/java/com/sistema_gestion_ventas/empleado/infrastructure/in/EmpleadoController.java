package com.sistema_gestion_ventas.empleado.infrastructure.in;

import com.sistema_gestion_ventas.empleado.domain.entity.Empleado;
import com.sistema_gestion_ventas.empleado.infrastructure.out.EmpleadoRepository;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class EmpleadoController {

    private EmpleadoRepository empleadoRepository;

    public EmpleadoController() {
        this.empleadoRepository = new EmpleadoRepository();
        crearVentanaGestionDeEmpleado();
    }

    private void crearVentanaGestionDeEmpleado() {
        JFrame gestionDeEmpleadoFrame = new JFrame("Gestión de Empleado");
        gestionDeEmpleadoFrame.setSize(600, 500);
        gestionDeEmpleadoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeEmpleadoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField empleadoIdField = new JTextField(20);
        JTextField tipoDocumentoIdField = new JTextField(20);
        JTextField nombreField = new JTextField(20);
        JTextField apellidoField = new JTextField(20);
        JTextField direccionIdField = new JTextField(20);
        JTextField sucursalIdField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JButton btnCrear = new JButton("Crear Empleado");
        JButton btnActualizar = new JButton("Actualizar Empleado");
        JButton btnEliminar = new JButton("Eliminar Empleado");
        JButton btnListar = new JButton("Listar Empleados");
        JButton btnBuscarPorId = new JButton("Buscar Empleado por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String empleadoId = empleadoIdField.getText().trim();
                    int tipoDocumentoId = Integer.parseInt(tipoDocumentoIdField.getText().trim());
                    String nombre = nombreField.getText().trim();
                    String apellido = apellidoField.getText().trim();
                    int direccionId = Integer.parseInt(direccionIdField.getText().trim());
                    int sucursalId = Integer.parseInt(sucursalIdField.getText().trim());
                    String email = emailField.getText().trim();

                    if (!nombre.isEmpty() && !apellido.isEmpty() && !email.isEmpty()) {
                        Empleado empleado = new Empleado();
                        empleado.setEmpleadoId(empleadoId);
                        empleado.setTipoDocumento(tipoDocumentoId);
                        empleado.setNombre(nombre);
                        empleado.setApellido(apellido);
                        empleado.setDireccionId(direccionId);
                        empleado.setSucursalId(sucursalId);
                        empleado.setEmail(email);
                        empleadoRepository.createEmpleado(empleado);
                        JOptionPane.showMessageDialog(null, "Empleado creado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de ID inválido. Asegúrese de ingresar números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String empleadoId = empleadoIdField.getText().trim();
                    int tipoDocumentoId = Integer.parseInt(tipoDocumentoIdField.getText().trim());
                    String nombre = nombreField.getText().trim();
                    String apellido = apellidoField.getText().trim();
                    int direccionId = Integer.parseInt(direccionIdField.getText().trim());
                    int sucursalId = Integer.parseInt(sucursalIdField.getText().trim());
                    String email = emailField.getText().trim();

                    if (!empleadoId.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty() && !email.isEmpty()) {
                        Empleado empleado = new Empleado();
                        empleado.setEmpleadoId(empleadoId);
                        empleado.setTipoDocumento(tipoDocumentoId);
                        empleado.setNombre(nombre);
                        empleado.setApellido(apellido);
                        empleado.setDireccionId(direccionId);
                        empleado.setSucursalId(sucursalId);
                        empleado.setEmail(email);
                        empleadoRepository.updateEmpleado(empleado);
                        JOptionPane.showMessageDialog(null, "Empleado actualizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de ID inválido. Asegúrese de ingresar números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String empleadoId = empleadoIdField.getText().trim();
                if (!empleadoId.isEmpty()) {
                    empleadoRepository.deleteEmpleado(empleadoId);
                    JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "ID de empleado es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Empleado> empleadoList = empleadoRepository.getAllEmpleado();
                StringBuilder sb = new StringBuilder("Lista de Empleados:\n");
                for (Empleado empleado : empleadoList) {
                    sb.append(String.format("ID: %s, Tipo Documento ID: %d, Nombre: %s, Apellido: %s, Direccion ID: %d, Sucursal ID: %d, Email: %s%n",
                            empleado.getEmpleadoId(),
                            empleado.getTipoDocumento(),
                            empleado.getNombre(),
                            empleado.getApellido(),
                            empleado.getDireccionId(),
                            empleado.getSucursalId(),
                            empleado.getEmail()));
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String empleadoId = empleadoIdField.getText().trim();
                if (!empleadoId.isEmpty()) {
                    Optional<Empleado> empleadoOptional = empleadoRepository.findEmpleadoById(empleadoId);
                    if (empleadoOptional.isPresent()) {
                        Empleado empleado = empleadoOptional.get();
                        String message = String.format("Empleado encontrado:\nID: %s\nTipo Documento ID: %d\nNombre: %s\nApellido: %s\nDireccion ID: %d\nSucursal ID: %d\nEmail: %s",
                                empleado.getEmpleadoId(),
                                empleado.getTipoDocumento(),
                                empleado.getNombre(),
                                empleado.getApellido(),
                                empleado.getDireccionId(),
                                empleado.getSucursalId(),
                                empleado.getEmail());
                        JOptionPane.showMessageDialog(null, message);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró Empleado con ID: " + empleadoId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID de empleado es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(new JLabel("ID de Empleado:"));
        panel.add(empleadoIdField);
        panel.add(new JLabel("Tipo Documento ID:"));
        panel.add(tipoDocumentoIdField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Apellido:"));
        panel.add(apellidoField);
        panel.add(new JLabel("Direccion ID:"));
        panel.add(direccionIdField);
        panel.add(new JLabel("Sucursal ID:"));
        panel.add(sucursalIdField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeEmpleadoFrame.add(panel);
        gestionDeEmpleadoFrame.setVisible(true);
    }
}



