package prog.unidad05.gui.ejercicio05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class GestionaComboSwingApp {

  private JFrame frame;
  private JTextField txtTexto;
  private JComboBox<String> cbLista;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GestionaComboSwingApp window = new GestionaComboSwingApp();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public GestionaComboSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 490, 197);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    cbLista = new JComboBox<>();

    txtTexto = new JTextField();
    txtTexto.setColumns(10);

    JButton btnAnyadir = new JButton("Añadir");
    btnAnyadir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String texto = txtTexto.getText();
        if (!texto.isBlank()) {
          DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) cbLista.getModel();
          modelo.addElement(texto);
        }

      }
    });

    JButton btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int elemento = cbLista.getSelectedIndex();
        // Si hay elemento seleccionado
        if (elemento >= 0) {
          // Obtiene el modelo
          DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel)cbLista.getModel();
          // Y elimina el elemento en la posición indicada
          modelo.removeElementAt(elemento);
        }
      }
    });
    

    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(10)
              .addComponent(txtTexto, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
              .addGap(23)
              .addComponent(btnAnyadir, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(372)
              .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addContainerGap()
              .addComponent(cbLista, GroupLayout.PREFERRED_SIZE, 441, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(13, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(cbLista, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
          .addGap(35)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(txtTexto, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(5)
              .addComponent(btnAnyadir)))
          .addGap(7)
          .addComponent(btnEliminar))
    );
    frame.getContentPane().setLayout(groupLayout);

  }
}
