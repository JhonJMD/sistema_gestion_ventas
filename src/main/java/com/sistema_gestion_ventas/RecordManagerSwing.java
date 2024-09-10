package com.sistema_gestion_ventas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class RecordManagerSwing extends JFrame {
    private JTextField searchField;
    private JTable recordTable;
    private DefaultTableModel tableModel;
    private JButton addButton;

    public RecordManagerSwing() {
        setTitle("Gestor de Registros");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de búsqueda
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Buscar");
        searchPanel.add(new JLabel("Buscar por ID:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.NORTH);

        // Tabla de registros
        String[] columnNames = {"ID", "Registro", "Editar", "Eliminar"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 1; // Solo la columna "Registro" es editable
            }
        };
        recordTable = new JTable(tableModel);

        // Configurar renderizadores y editores de botones
        recordTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        recordTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox()));
        recordTable.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        recordTable.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(recordTable);
        add(scrollPane, BorderLayout.CENTER);

        // Botón de agregar
        addButton = new JButton("+");
        addButton.setFont(new Font("Arial", Font.BOLD, 20));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(addButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Agregar algunos registros de ejemplo
        addRecord("1", "Registro 1");
        addRecord("2", "Registro 2");
        addRecord("3", "Registro 3");

        // Acción del botón de agregar
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newId = String.valueOf(tableModel.getRowCount() + 1);
                addRecord(newId, "Nuevo Registro " + newId);
            }
        });

        // Acción del botón de buscar
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchId = searchField.getText();
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    if (tableModel.getValueAt(i, 0).equals(searchId)) {
                        recordTable.setRowSelectionInterval(i, i);
                        recordTable.scrollRectToVisible(recordTable.getCellRect(i, 0, true));
                        return;
                    }
                }
                JOptionPane.showMessageDialog(RecordManagerSwing.this, "Registro no encontrado");
            }
        });
    }

    private void addRecord(String id, String record) {
        Vector<Object> row = new Vector<>();
        row.add(id);
        row.add(record);
        row.add("Editar");
        row.add("Eliminar");
        tableModel.addRow(row);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RecordManagerSwing().setVisible(true);
            }
        });
    }
}

// Clase para renderizar los botones
class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

// Clase para editar las celdas con botones
class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, button);  // Obtener la tabla correctamente
            if (label.equals("Editar")) {
                String newValue = JOptionPane.showInputDialog(button, "Editar registro:", table.getValueAt(table.getSelectedRow(), 1));
                if (newValue != null) {
                    table.setValueAt(newValue, table.getSelectedRow(), 1);
                }
            } else if (label.equals("Eliminar")) {
                int modelRow = table.convertRowIndexToModel(table.getSelectedRow());
                ((DefaultTableModel) table.getModel()).removeRow(modelRow);
            }
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
}
