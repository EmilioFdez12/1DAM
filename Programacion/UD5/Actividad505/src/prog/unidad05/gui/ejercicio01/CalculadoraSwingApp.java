package prog.unidad05.gui.ejercicio01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraSwingApp {

  private JFrame frame;
  private JTextField txtPrimerOperando;
  private JTextField txtSegundoOperando;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          CalculadoraSwingApp window = new CalculadoraSwingApp();
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
  public CalculadoraSwingApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(500, 250, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JLabel lblOperando1 = new JLabel("Primer Operando:");
    lblOperando1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
    
    JLabel lblOperando2 = new JLabel("Segundo Operando:");
    lblOperando2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
    
    txtPrimerOperando = new JTextField();
    txtPrimerOperando.setColumns(10);
    
    txtSegundoOperando = new JTextField();
    txtSegundoOperando.setColumns(10);
    
    JLabel lblResultado = new JLabel("0.0");
    lblResultado.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
    
    JLabel txtResultado = new JLabel("RESULTADO:");
    txtResultado.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
    
    JButton btnSuma = new JButton("SUMA");
    btnSuma.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
        double operando1 = Double.parseDouble(txtPrimerOperando.getText());
        double operando2 = Double.parseDouble(txtSegundoOperando.getText());
        
        double resultado = operando1 + operando2;      
        lblResultado.setText(Double.toString(resultado));   
        } catch (NumberFormatException e1) {
          // Para que salga mensaje de er
          JOptionPane.showMessageDialog(null , "Inserte un número porfavor");
        }
      }
    });
    
    
    JButton btnResta = new JButton("RESTA");
    btnResta.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        double operando1 = Double.parseDouble(txtPrimerOperando.getText());
        double operando2 = Double.parseDouble(txtSegundoOperando.getText());
        
        double resultado = operando1 - operando2;      
        lblResultado.setText(Double.toString(resultado));   
      }
    });
    
    JButton btnProducto = new JButton("PRODUCTO");
    btnProducto.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        double operando1 = Double.parseDouble(txtPrimerOperando.getText());
        double operando2 = Double.parseDouble(txtSegundoOperando.getText());
        
        double resultado = operando1 * operando2;      
        lblResultado.setText(Double.toString(resultado));  
      }
    });
    
    JButton btnDivision = new JButton("DIVISION");
    btnDivision.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        double operando1 = Double.parseDouble(txtPrimerOperando.getText());
        double operando2 = Double.parseDouble(txtSegundoOperando.getText());
        

        
        double resultado = operando1 / operando2;      
        lblResultado.setText(Double.toString(resultado));  
      }
    });
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(10)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(lblOperando1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
              .addGap(7)
              .addComponent(txtPrimerOperando, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
              .addGap(23)
              .addComponent(btnSuma))
            .addGroup(groupLayout.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(lblOperando2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(txtSegundoOperando, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
              .addGap(18)
              .addComponent(btnResta))
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(txtResultado)
              .addGap(10)
              .addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
              .addGap(119)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addGap(10)
                  .addComponent(btnDivision))
                .addComponent(btnProducto)))))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(28)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(1)
              .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(txtPrimerOperando, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblOperando1)))
            .addComponent(btnSuma))
          .addGap(32)
          .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
              .addComponent(txtSegundoOperando, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addComponent(btnResta))
            .addComponent(lblOperando2))
          .addGap(27)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(11)
              .addComponent(txtResultado, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(20)
              .addComponent(lblResultado))
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(btnDivision)
              .addGap(22)
              .addComponent(btnProducto))))
    );
    frame.getContentPane().setLayout(groupLayout);
  }
}
