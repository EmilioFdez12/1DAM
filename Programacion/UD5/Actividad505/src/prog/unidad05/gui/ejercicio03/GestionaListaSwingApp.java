package prog.unidad05.gui.ejercicio03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GestionaListaSwingApp {

  private JFrame frame;
  private JTextField txtTexto;
  private JList lstLista;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GestionaListaSwingApp window = new GestionaListaSwingApp();
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
  public GestionaListaSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JScrollPane scrollPane = new JScrollPane();
    
    lstLista = new JList();
    scrollPane.setViewportView(lstLista);
    // Definimos el modelo de la lista (Va a contener cadenas)
    lstLista.setModel(new DefaultListModel<String>());

    
    
    txtTexto = new JTextField();
    txtTexto.setColumns(10);
    
    JButton btnAñadir = new JButton("Añadir");
    btnAñadir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String texto = txtTexto.getText();       
        if (!texto.isBlank()) {
          DefaultListModel<String> modelo = (DefaultListModel<String>)lstLista.getModel();
          modelo.addElement(texto);
        }
        
      }
    });
    
    JButton btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
       String texto = txtTexto.getText();
       if (!texto.isBlank()) {
         DefaultListModel<String> modelo = (DefaultListModel<String>)lstLista.getModel();
         modelo.removeElement(texto);
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
              .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addContainerGap()
              .addComponent(txtTexto, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(btnAñadir, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(330)
              .addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(11)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
          .addGap(11)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(txtTexto, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAñadir))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(btnEliminar)
          .addGap(34))
    );
    frame.getContentPane().setLayout(groupLayout);
  }
}
