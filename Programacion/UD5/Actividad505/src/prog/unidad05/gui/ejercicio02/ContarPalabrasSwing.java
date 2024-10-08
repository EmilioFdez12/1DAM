package prog.unidad05.gui.ejercicio02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContarPalabrasSwing {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ContarPalabrasSwing window = new ContarPalabrasSwing();
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
  public ContarPalabrasSwing() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 489, 328);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JScrollPane scrollPane = new JScrollPane();

    JTextArea txtTexto = new JTextArea();
    scrollPane.setViewportView(txtTexto);

    JLabel lblResultado = new JLabel("     ");

    JButton btnContar = new JButton("CONTAR");
    btnContar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        lblResultado.setText(contarPalabras(txtTexto.getText()));        
      }
    });
    btnContar.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(10)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(btnContar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(lblResultado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addGap(10))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(11)
          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
          .addGap(11)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(btnContar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
    );
    frame.getContentPane().setLayout(groupLayout);
  }

  private String contarPalabras(String texto) {
    // Se divide el texto por palabras; Un espacio o mas
    String[] palabras = texto.split("\\s+");

    Map<String, Integer> frecuencias = new HashMap<>();

    for (String palabra : palabras) {
      if (!frecuencias.containsKey(palabra)) {
        frecuencias.put(palabra, 0);
      }
      // Sumamos 1 a la frecuencia actual de la palabra
      frecuencias.put(palabra, frecuencias.get(palabra) + 1);
    }

    if (frecuencias.size() > 0) {
      String palabraMasRepetida = null;
      int frecuencia = 0;

      for (String palabra : frecuencias.keySet()) {
        // Si es la primera palabra o la frecuencia de la palabra es mayor que la actual
        if ((palabraMasRepetida == null) || (frecuencias.get(palabra) > frecuencia)) {
          // La tomamos como la más frecuente por ahora
          palabraMasRepetida = palabra;
          frecuencia = frecuencias.get(palabraMasRepetida);
        }
      }
      return String.format("La palabra más frecuente es: \"%s\"(%d)", palabraMasRepetida, frecuencia);
    } else {
      return "No hay palabras";
    }
  }
}
