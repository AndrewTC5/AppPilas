package VistaBuscador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FormBuscador {
    private BuscadorPila buscador;
    private JTextField tfBusqueda;
    private JButton bBuscar;
    private JButton bEliminar;
    private JLabel lOperacion;
    private JPanel fBuscador;
    private DefaultListModel<String> listModel;
    private JList<String> stackView;
    private JButton salirButton;

    public FormBuscador() {
        buscador= new BuscadorPila();
        listModel = new DefaultListModel<>();

        stackView.setModel(listModel);
        bBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busqueda = tfBusqueda.getText();
                if (!busqueda.isEmpty()) {
                    buscador.agregar(busqueda);
                    tfBusqueda.setText("");
                    lOperacion.setText("Busqueda Almacenada en el Historial");
                    lOperacion.setForeground(Color.BLUE);
                } else {
                    lOperacion.setText("Busqueda invalida");
                    lOperacion.setForeground(Color.getHSBColor(1, 0.8f, 1f));
                }
                actualizar();
            }
        });

        bEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    buscador.quitar();
                actualizar();
            }
        });


        tfBusqueda.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                lOperacion.setText("");
            }
        });

        bEliminar.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                lOperacion.setText("");
            }
        });


        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    private void actualizar() {
        listModel.clear();
        for (int i = buscador.getPila().size()-1; i >= 0 ; i--) {
            listModel.addElement(buscador.getPila().get(i));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormBuscador");
        frame.setContentPane(new FormBuscador().fBuscador);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 520);
    }
}