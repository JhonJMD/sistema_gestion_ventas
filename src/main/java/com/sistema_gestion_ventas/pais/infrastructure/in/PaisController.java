package com.sistema_gestion_ventas.pais.infrastructure.in;

import com.sistema_gestion_ventas.pais.domain.entity.Pais;
import com.sistema_gestion_ventas.pais.infrastructure.out.PaisRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class PaisController {

    private PaisRepository paisRepository;

    public PaisController() {
        this.paisRepository = new PaisRepository();
        crearVentanaGestionDePaises();
    }

    private void crearVentanaGestionDePaises() {
        JFrame gestionDePaisesFrame = new JFrame("Gestión de Países");
        gestionDePaisesFrame.setSize(600, 500);
        gestionDePaisesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDePaisesFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField idField = new JTextField(20);
        idField.setPreferredSize(new Dimension(200, 30));
        JTextField nombreField = new JTextField(20);
        nombreField.setPreferredSize(new Dimension(200, 30));

        JButton btnCrear = new JButton("Crear País");
        JButton btnActualizar = new JButton("Actualizar País");
        JButton btnEliminar = new JButton("Eliminar País");
        JButton btnListar = new JButton("Listar Países");
        JButton btnBuscarPorId = new JButton("Buscar País por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                if (nombre != null && !nombre.trim().isEmpty()) {
                    Pais pais = new Pais();
                    pais.setNombre(nombre);
                    paisRepository.createPais(pais);
                    JOptionPane.showMessageDialog(null, "País creado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre del país no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = idField.getText();
                String nombre = nombreField.getText();
                if (idStr != null && !idStr.trim().isEmpty()) {
                    try {
                        int paisId = Integer.parseInt(idStr);
                        if (nombre != null && !nombre.trim().isEmpty()) {
                            Pais pais = new Pais();
                            pais.setPaisId(paisId);
                            pais.setNombre(nombre);
                            paisRepository.updatePais(pais);
                            JOptionPane.showMessageDialog(null, "País actualizado exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "El nombre del país no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID del país inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = idField.getText();
                if (idStr != null && !idStr.trim().isEmpty()) {
                    try {
                        int paisId = Integer.parseInt(idStr);
                        paisRepository.deletePais(paisId);
                        JOptionPane.showMessageDialog(null, "País eliminado exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID del país inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Pais> paisList = paisRepository.getAllPais();
                StringBuilder sb = new StringBuilder("Lista de Países:\n");
                for (Pais pais : paisList) {
                    sb.append("ID: ").append(pais.getPaisId()).append(", Nombre: ").append(pais.getNombre()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = idField.getText();
                if (idStr != null && !idStr.trim().isEmpty()) {
                    try {
                        int paisId = Integer.parseInt(idStr);
                        Optional<Pais> paisOptional = paisRepository.findPaisById(paisId);
                        if (paisOptional.isPresent()) {
                            Pais pais = paisOptional.get();
                            JOptionPane.showMessageDialog(null, "País encontrado:\nID: " + pais.getPaisId() + ", Nombre: " + pais.getNombre());
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró el país con ID: " + paisId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID del país inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        panel.add(new JLabel("ID del País:"));
        panel.add(idField);
        panel.add(new JLabel("Nombre del País:"));
        panel.add(nombreField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDePaisesFrame.add(panel);
        gestionDePaisesFrame.setVisible(true);
    }
}
