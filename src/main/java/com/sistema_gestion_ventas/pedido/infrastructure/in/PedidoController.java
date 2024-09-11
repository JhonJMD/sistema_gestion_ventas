package com.sistema_gestion_ventas.pedido.infrastructure.in;

import com.sistema_gestion_ventas.pedido.domain.entity.Pedido;
import com.sistema_gestion_ventas.pedido.infrastructure.out.PedidoRepository;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

public class PedidoController {

    private PedidoRepository pedidoRepository;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public PedidoController() {
        this.pedidoRepository = new PedidoRepository();
        crearVentanaGestionDePedido();
    }

    private void crearVentanaGestionDePedido() {
        JFrame gestionDePedidoFrame = new JFrame("Gestión de Pedido");
        gestionDePedidoFrame.setSize(600, 500);
        gestionDePedidoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gestionDePedidoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField pedidoIdField = new JTextField(20);
        pedidoIdField.setPreferredSize(new Dimension(200, 30));
        JTextField tipoPedidoIdField = new JTextField(20);
        tipoPedidoIdField.setPreferredSize(new Dimension(200, 30));
        JTextField clienteIdField = new JTextField(20);
        clienteIdField.setPreferredSize(new Dimension(200, 30));
        JTextField fechaPedidoField = new JTextField(20);
        fechaPedidoField.setPreferredSize(new Dimension(200, 30));
        JTextField estadoIdField = new JTextField(20);
        estadoIdField.setPreferredSize(new Dimension(200, 30));
        JTextField totalEstimadoField = new JTextField(20);
        totalEstimadoField.setPreferredSize(new Dimension(200, 30));
        JTextField fechaConfirmacionField = new JTextField(20);
        fechaConfirmacionField.setPreferredSize(new Dimension(200, 30));
        JTextField usuarioIdField = new JTextField(20);
        usuarioIdField.setPreferredSize(new Dimension(200, 30));
        JButton btnCrear = new JButton("Crear Pedido");
        JButton btnActualizar = new JButton("Actualizar Pedido");
        JButton btnEliminar = new JButton("Eliminar Pedido");
        JButton btnListar = new JButton("Listar Pedidos");
        JButton btnBuscarPorId = new JButton("Buscar Pedido por ID");

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tipoPedidoId = Integer.parseInt(tipoPedidoIdField.getText().trim());
                    String clienteId = clienteIdField.getText().trim();
                    Date fechaPedido = new Date(dateFormat.parse(fechaPedidoField.getText().trim()).getTime());
                    int estadoId = Integer.parseInt(estadoIdField.getText().trim());
                    double totalEstimado = Double.parseDouble(totalEstimadoField.getText().trim());
                    Date fechaConfirmacion = new Date(dateFormat.parse(fechaConfirmacionField.getText().trim()).getTime());
                    int usuarioId = Integer.parseInt(usuarioIdField.getText().trim());

                    if (!tipoPedidoIdField.getText().trim().isEmpty() && !clienteId.isEmpty() && fechaPedidoField.getText() != null && !fechaPedidoField.getText().trim().isEmpty()
                            && !estadoIdField.getText().trim().isEmpty() && !totalEstimadoField.getText().trim().isEmpty() && !fechaConfirmacionField.getText().trim().isEmpty()
                            && !usuarioIdField.getText().trim().isEmpty()) {
                        Pedido pedido = new Pedido();
                        pedido.setTipoPedidoId(tipoPedidoId);
                        pedido.setClienteId(clienteId);
                        pedido.setFechaPedido(fechaPedido);
                        pedido.setEstadoId(estadoId);
                        pedido.setTotalEstimado(totalEstimado);
                        pedido.setFechaConfirmacion(fechaConfirmacion);
                        pedido.setUsuarioId(usuarioId);
                        pedidoRepository.createPedido(pedido);
                        JOptionPane.showMessageDialog(null, "Pedido creado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException | ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el formato de datos. Verifique los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tipoPedidoId = Integer.parseInt(tipoPedidoIdField.getText().trim());
                    String clienteId = clienteIdField.getText().trim();
                    Date fechaPedido = new Date(dateFormat.parse(fechaPedidoField.getText().trim()).getTime());
                    int estadoId = Integer.parseInt(estadoIdField.getText().trim());
                    double totalEstimado = Double.parseDouble(totalEstimadoField.getText().trim());
                    Date fechaConfirmacion = new Date(dateFormat.parse(fechaConfirmacionField.getText().trim()).getTime());
                    int usuarioId = Integer.parseInt(usuarioIdField.getText().trim());

                    if (!tipoPedidoIdField.getText().trim().isEmpty() && !clienteId.isEmpty() && fechaPedidoField.getText() != null && !fechaPedidoField.getText().trim().isEmpty()
                            && !estadoIdField.getText().trim().isEmpty() && !totalEstimadoField.getText().trim().isEmpty() && !fechaConfirmacionField.getText().trim().isEmpty()
                            && !usuarioIdField.getText().trim().isEmpty()) {
                        Pedido pedido = new Pedido();
                        pedido.setTipoPedidoId(tipoPedidoId);
                        pedido.setClienteId(clienteId);
                        pedido.setFechaPedido(fechaPedido);
                        pedido.setEstadoId(estadoId);
                        pedido.setTotalEstimado(totalEstimado);
                        pedido.setFechaConfirmacion(fechaConfirmacion);
                        pedido.setUsuarioId(usuarioId);
                        pedidoRepository.updatePedido(pedido);
                        JOptionPane.showMessageDialog(null, "Pedido actualizado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException | ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el formato de datos. Verifique los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pedidoIdStr = pedidoIdField.getText();
                if (!pedidoIdStr.isEmpty()) {
                    try {
                        int pedidoId = Integer.parseInt(pedidoIdStr);
                        pedidoRepository.deletePedido(pedidoId);
                        JOptionPane.showMessageDialog(null, "Pedido eliminado exitosamente.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El campo ID de pedido no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Pedido> pedidoList = pedidoRepository.getAllPedido();
                StringBuilder sb = new StringBuilder("Lista de Pedidos:\n");
                for (Pedido pedido : pedidoList) {
                    sb.append(String.format("ID: %d, Tipo Pedido ID: %s, Cliente ID: %s, Fecha Pedido: %s, Estado ID: %s, Total Estimado: %.2f, Fecha Confirmacion: %s, Usuario ID: %s%n",
                            pedido.getPedidoId(),
                            pedido.getTipoPedidoId(),
                            pedido.getClienteId(),
                            pedido.getFechaPedido(),
                            pedido.getEstadoId(),
                            pedido.getTotalEstimado(),
                            pedido.getFechaConfirmacion(),
                            pedido.getUsuarioId()));
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pedidoIdStr = pedidoIdField.getText().trim();
                if (!pedidoIdStr.isEmpty()) {
                    try {
                        int pedidoId = Integer.parseInt(pedidoIdStr);
                        Optional<Pedido> pedidoOptional = pedidoRepository.findPedidoById(pedidoId);
                        if (pedidoOptional.isPresent()) {
                            Pedido pedido = pedidoOptional.get();
                            String message = String.format("Pedido encontrado:\nID: %d\nTipo Pedido ID: %s\nCliente ID: %s\nFecha Pedido: %s\nEstado ID: %s\nTotal Estimado: %.2f\nFecha Confirmacion: %s\nUsuario ID: %s",
                                    pedido.getPedidoId(),
                                    pedido.getTipoPedidoId(),
                                    pedido.getClienteId(),
                                    pedido.getFechaPedido(),
                                    pedido.getEstadoId(),
                                    pedido.getTotalEstimado(),
                                    pedido.getFechaConfirmacion(),
                                    pedido.getUsuarioId());
                            JOptionPane.showMessageDialog(null, message);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró Pedido con ID: " + pedidoId, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El campo ID de pedido no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(new JLabel("tipoPedidoId de Pedido:"));
        panel.add(tipoPedidoIdField);
        panel.add(new JLabel("clienteId de Pedido:"));
        panel.add(clienteIdField);
        panel.add(new JLabel("fechaPedido de Pedido (yyyy-MM-dd):"));
        panel.add(fechaPedidoField);
        panel.add(new JLabel("estadoId de Pedido:"));
        panel.add(estadoIdField);
        panel.add(new JLabel("totalEstimado de Pedido:"));
        panel.add(totalEstimadoField);
        panel.add(new JLabel("fechaConfirmacion de Pedido (yyyy-MM-dd):"));
        panel.add(fechaConfirmacionField);
        panel.add(new JLabel("usuarioId de Pedido:"));
        panel.add(usuarioIdField);
        panel.add(btnCrear);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnListar);
        panel.add(btnBuscarPorId);

        gestionDePedidoFrame.add(panel);
        gestionDePedidoFrame.setVisible(true);
    }
}

