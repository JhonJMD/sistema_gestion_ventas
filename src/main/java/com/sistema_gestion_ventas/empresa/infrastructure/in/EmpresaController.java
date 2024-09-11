package com.sistema_gestion_ventas.empresa.infrastructure.in;

import com.sistema_gestion_ventas.empresa.domain.entity.Empresa;
import com.sistema_gestion_ventas.empresa.infrastructure.out.EmpresaRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class EmpresaController {

    private EmpresaRepository empresaRepository;

    public EmpresaController() {
        this.empresaRepository = new EmpresaRepository();
        crearVentanaGestionDeEmpresa();
    }

    private void crearVentanaGestionDeEmpresa() {
        JFrame gestionDeEmpresaFrame = new JFrame("Gestión de Empresa");
        gestionDeEmpresaFrame.setSize(600, 500);
        gestionDeEmpresaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDeEmpresaFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField empresaIdField = new JTextField(20);
        empresaIdField.setPreferredSize(new Dimension(200, 30));
        JTextField nombreField = new JTextField(20);
        nombreField.setPreferredSize(new Dimension(200, 30));
        JTextField direccionIdField = new JTextField(20);
        direccionIdField.setPreferredSize(new Dimension(200, 30));
        JTextField representanteLegalField = new JTextField(20);
        representanteLegalField.setPreferredSize(new Dimension(200, 30));

        JButton btnCrear = new JButton("Crear Empresa");
        JButton btnActualizar = new JButton("Actualizar Empresa");
        JButton btnEliminar = new JButton("Eliminar Empresa");
        JButton btnListar = new JButton("Listar Empresas");
        JButton btnBuscarPorId = new JButton("Buscar Empresa por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreField.getText();
                    int direccionId = Integer.parseInt(direccionIdField.getText());
                    String representanteLegal = representanteLegalField.getText();
                    if (!nombre.trim().isEmpty() && !representanteLegal.trim().isEmpty()) {
                        Empresa empresa = new Empresa();
                        empresa.setNombre(nombre);
                        empresa.setDireccionId(direccionId);
                        empresa.setRepresentanteLegal(representanteLegal);
                        empresaRepository.createEmpresa(empresa);
                        JOptionPane.showMessageDialog(null, "Empresa creada exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de dirección inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int empresaId = Integer.parseInt(empresaIdField.getText());
                    String nombre = nombreField.getText();
                    int direccionId = Integer.parseInt(direccionIdField.getText());
                    String representanteLegal = representanteLegalField.getText();
                    if (!nombre.trim().isEmpty() && !representanteLegal.trim().isEmpty()) {
                        Empresa empresa = new Empresa();
                        empresa.setEmpresaId(empresaId);
                        empresa.setNombre(nombre);
                        empresa.setDireccionId(direccionId);
                        empresa.setRepresentanteLegal(representanteLegal);
                        empresaRepository.updateEmpresa(empresa);
                        JOptionPane.showMessageDialog(null, "Empresa actualizada exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de empresa o dirección inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int empresaId = Integer.parseInt(empresaIdField.getText());
                    empresaRepository.deleteEmpresa(empresaId);
                    JOptionPane.showMessageDialog(null, "Empresa eliminada exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de empresa inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Empresa> empresaList = empresaRepository.getAllEmpresa();
                StringBuilder sb = new StringBuilder("Lista de Empresas:\n");
                for (Empresa empresa : empresaList) {
                    sb.append("ID: ").append(empresa.getEmpresaId()).append(", ");
                    sb.append("Nombre: ").append(empresa.getNombre()).append(", ");
                    sb.append("Dirección ID: ").append(empresa.getDireccionId()).append(", ");
                    sb.append("Representante Legal: ").append(empresa.getRepresentanteLegal()).append(", ");
                    sb.append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int empresaId = Integer.parseInt(empresaIdField.getText());
                    Optional<Empresa> empresaOptional = empresaRepository.findEmpresaById(empresaId);
                    if (empresaOptional.isPresent()) {
                        Empresa empresa = empresaOptional.get();
                        JOptionPane.showMessageDialog(null, "Empresa encontrada:\nID: " + empresa.getEmpresaId() +
                            ", Nombre: " + empresa.getNombre() +
                            ", Dirección ID: " + empresa.getDireccionId() +
                            ", Representante Legal: " + empresa.getRepresentanteLegal());
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró Empresa con ID: " + empresaId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID de empresa inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(new JLabel("ID de Empresa:"));
        panel.add(empresaIdField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Dirección ID:"));
        panel.add(direccionIdField);
        panel.add(new JLabel("Representante Legal:"));
        panel.add(representanteLegalField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDeEmpresaFrame.add(panel);
        gestionDeEmpresaFrame.setVisible(true);
    }
}
