import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField txtTexto;
    private JButton btnVerificar;


    public boolean balanceado(String codigo) throws Exception {
        Pila p= new Pila();
        for(int i=0; i<codigo.length();i++){
            //char caracter= codigo.charAt(i);
            //Busca el caracter y si lo encuentra lo inserta a la pila
            if (codigo.charAt(i) == '{'||codigo.charAt(i) == '['||codigo.charAt(i) == '(')
                p.insertar(codigo.charAt(i));

            else if(codigo.charAt(i)=='}'|| codigo.charAt(i)==']'|| codigo.charAt(i)==')'){
                   /* if (p.esVacia()){
                    return false;}*/
                    char charApertura= p.eliminar();
                    if(!((charApertura=='{'&& codigo.charAt(i)=='}')||(charApertura=='['&& codigo.charAt(i)==']')||(charApertura=='('&& codigo.charAt(i)==')'))){
                    return false;}
            }

        }
      return p.esVacia();
    }

    public Ventana() {

        btnVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String texto= txtTexto.getText();
                try {
                    if(balanceado(texto))
                        JOptionPane.showMessageDialog(null, "Codigo Equilibrado");
                    else
                        JOptionPane.showMessageDialog(null, "Codigo no Equilibrado");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Falta apertura " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
