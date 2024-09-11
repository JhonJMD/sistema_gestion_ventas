package com.sistema_gestion_ventas.cliente.infrastructure.in;

import com.sistema_gestion_ventas.cliente.domain.entity.Cliente;
import com.sistema_gestion_ventas.cliente.infrastructure.out.ClienteRepository;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController() {
        this.clienteRepository = new ClienteRepository();
        crearVentanaGestionDeCliente();
    }

    private void crearVentanaGestionDeCliente() {
        JFrame gestionDeClienteFrame = new JFrame("Gestión de Cliente");
        gestionDeClienteFrame.setSize(600, 500);
        gestionDeClienteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeClienteFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField clienteIdField = new JTextField(20);
        JTextField tipoDocumentoIdField = new JTextField(20);
        JTextField tipoPersonaIdField = new JTextField(20);
        JTextField nombreField = new JTextField(20);
        JTextField apellidoField = new JTextField(20);
        JTextField direccionIdField = new JTextField(20);
        JTextField telefonoIdField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JTextField totalGastadoField = new JTextField(20);
        JTextField comprasRealizadasField = new JTextField(20);
        
        JButton btnCrear = new JButton("Crear Cliente");
        JButton btnActualizar = new JButton("Actualizar Cliente");
        JButton btnEliminar = new JButton("Eliminar Cliente");
        JButton btnListar = new JButton("Listar Clientes");
        JButton btnBuscarPorId = new JButton("Buscar Cliente por ID");

        btnCrear.addActionListener(e -> {
            try {
                String clienteId = clienteIdField.getText();
                int tipoDocumentoId = Integer.parseInt(tipoDocumentoIdField.getText());
                int tipoPersonaId = Integer.parseInt(tipoPersonaIdField.getText());
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                int direccionId = Integer.parseInt(direccionIdField.getText());
                int telefonoId = Integer.parseInt(telefonoIdField.getText());
                String email = emailField.getText();
                double totalGastado = Double.parseDouble(totalGastadoField.getText());
                int comprasRealizadas = Integer.parseInt(comprasRealizadasField.getText());

                if (isAnyFieldEmpty(clienteIdField, tipoDocumentoIdField, tipoPersonaIdField, nombreField, apellidoField, direccionIdField, telefonoIdField, emailField, totalGastadoField, comprasRealizadasField)) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Cliente cliente = new Cliente();
                cliente.setClienteId(clienteId);
                cliente.setTipoDocumentoId(tipoDocumentoId);
                cliente.setTipoPersonaId(tipoPersonaId);
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setDireccionId(direccionId);
                cliente.setTelefonoId(telefonoId);
                cliente.setEmail(email);
                cliente.setTotalGastado(totalGastado);
                cliente.setComprasRealizadas(comprasRealizadas);
                clienteRepository.createCliente(cliente);
                JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error en los campos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnActualizar.addActionListener(e -> {
            try {
                String clienteId = clienteIdField.getText();
                int tipoDocumentoId = Integer.parseInt(tipoDocumentoIdField.getText());
                int tipoPersonaId = Integer.parseInt(tipoPersonaIdField.getText());
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                int direccionId = Integer.parseInt(direccionIdField.getText());
                int telefonoId = Integer.parseInt(telefonoIdField.getText());
                String email = emailField.getText();
                double totalGastado = Double.parseDouble(totalGastadoField.getText());
                int comprasRealizadas = Integer.parseInt(comprasRealizadasField.getText());

                if (isAnyFieldEmpty(clienteIdField, tipoDocumentoIdField, tipoPersonaIdField, nombreField, apellidoField, direccionIdField, telefonoIdField, emailField, totalGastadoField, comprasRealizadasField)) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Cliente cliente = new Cliente();
                cliente.setClienteId(clienteId);
                cliente.setTipoDocumentoId(tipoDocumentoId);
                cliente.setTipoPersonaId(tipoPersonaId);
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setDireccionId(direccionId);
                cliente.setTelefonoId(telefonoId);
                cliente.setEmail(email);
                cliente.setTotalGastado(totalGastado);
                cliente.setComprasRealizadas(comprasRealizadas);
                clienteRepository.updateCliente(cliente);
                JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error en los campos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnEliminar.addActionListener(e -> {
            try {
                String clienteId = clienteIdField.getText();
                clienteRepository.deleteCliente(clienteId);
                JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnListar.addActionListener(e -> {
            List<Cliente> clienteList = clienteRepository.getAllCliente();
            StringBuilder sb = new StringBuilder("Lista de Clientes:\n");
            for (Cliente cliente : clienteList) {
                sb.append("ID: ").append(cliente.getClienteId()).append(", ");
                sb.append("tipoDocumentoId: ").append(cliente.getTipoDocumentoId()).append(", ");
                sb.append("tipoPersonaId: ").append(cliente.getTipoPersonaId()).append(", ");
                sb.append("nombre: ").append(cliente.getNombre()).append(", ");
                sb.append("apellido: ").append(cliente.getApellido()).append(", ");
                sb.append("direccionId: ").append(cliente.getDireccionId()).append(", ");
                sb.append("telefonoId: ").append(cliente.getTelefonoId()).append(", ");
                sb.append("email: ").append(cliente.getEmail()).append(", ");
                sb.append("totalGastado: ").append(cliente.getTotalGastado()).append(", ");
                sb.append("comprasRealizadas: ").append(cliente.getComprasRealizadas()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        });

        btnBuscarPorId.addActionListener(e -> {
            String clienteId = clienteIdField.getText();
            Optional<Cliente> clienteOptional = clienteRepository.findClienteById(clienteId);
            if (clienteOptional.isPresent()) {
                Cliente cliente = clienteOptional.get();
                String info = String.format("Cliente encontrado:\nID: %s\nTipo Documento ID: %d\nTipo Persona ID: %d\nNombre: %s\nApellido: %s\nDireccion ID: %d\nTelefono ID: %d\nEmail: %s\nTotal Gastado: %.2f\nCompras Realizadas: %d",
                        cliente.getClienteId(), cliente.getTipoDocumentoId(), cliente.getTipoPersonaId(), cliente.getNombre(), cliente.getApellido(), cliente.getDireccionId(), cliente.getTelefonoId(), cliente.getEmail(), cliente.getTotalGastado(), cliente.getComprasRealizadas());
                JOptionPane.showMessageDialog(null, info);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró Cliente con ID: " + clienteId, "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(new JLabel("ID de Cliente:"));
        panel.add(clienteIdField);
        panel.add(new JLabel("tipoDocumentoId de Cliente:"));
        panel.add(tipoDocumentoIdField);
        panel.add(new JLabel("tipoPersonaId de Cliente:"));
        panel.add(tipoPersonaIdField);
        panel.add(new JLabel("nombre de Cliente:"));
        panel.add(nombreField);
        panel.add(new JLabel("apellido de Cliente:"));
        panel.add(apellidoField);
        panel.add(new JLabel("direccionId de Cliente:"));
        panel.add(direccionIdField);
        panel.add(new JLabel("telefonoId de Cliente:"));
        panel.add(telefonoIdField);
        panel.add(new JLabel("email de Cliente:"));
        panel.add(emailField);
        panel.add(new JLabel("totalGastado de Cliente:"));
        panel.add(totalGastadoField);
        panel.add(new JLabel("comprasRealizadas de Cliente:"));
        panel.add(comprasRealizadasField);

        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeClienteFrame.add(panel);
        gestionDeClienteFrame.setVisible(true);
    }

    private boolean isAnyFieldEmpty(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}


