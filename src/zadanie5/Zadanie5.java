
package zadanie5;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafał Dobosiewicz
 * This project presents currency converter to EURO, USD, GBP
 * 
 */
public class Zadanie5 extends JFrame{
    

    
    
    
    public Zadanie5(){
        super("Przelicznik walut");
        //zmienne
        int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
        int wys = Toolkit.getDefaultToolkit().getScreenSize().height;
        int szerRamki = this.getSize().width;
        int wysRamki = this.getSize().height;
    
        this.setLocation((szer-szerRamki)/2, (wys-wysRamki)/2);
        
        this.setDefaultCloseOperation(3);

        initComponents();

        
        pack();
    }

   
     
    public void initComponents(){
        //zmienne
        int szer = Toolkit.getDefaultToolkit().getScreenSize().height;
        int wys = Toolkit.getDefaultToolkit().getScreenSize().width;
        
        
        //komponenty
        kwota = new javax.swing.JTextField();
        waluty = new javax.swing.JComboBox();
        przelacznik1 = new javax.swing.JRadioButton("EUR");
        przelacznik2 = new javax.swing.JRadioButton("USD");
        przelacznik3 = new javax.swing.JRadioButton("GBP");
        przelicz = new javax.swing.JButton("Przelicz");
        wysWynikPrzewalutowania = new JLabel();
        groupSize = new ButtonGroup();
        waluty.addItem(new String("EUR"));
        waluty.addItem(new String("USD"));
        waluty.addItem(new String("CHF"));
        waluty.addItem(new String("GBP"));
        waluty.addItem(new String("JPY"));
        waluty.addItem(new String("ISK"));
        waluty.addItem(new String("PLN"));
        
        
        
        //ustaw rozmiar
        kwota.setPreferredSize(new Dimension (200,30));
        panel1.setPreferredSize(new Dimension (300,100));
        panel2.setPreferredSize(new Dimension (300,30));
        panel3.setPreferredSize(new Dimension (300,100));
        
        
        
        
        //dodawanie do szybki
        Container kontener = this.getContentPane();
        kontener.add(panel1, BorderLayout.PAGE_START);
        kontener.add(panel2, BorderLayout.CENTER);
        kontener.add(panel3, BorderLayout.PAGE_END);
        panel1.add(coWpisac);
        panel1.add(kwota);
        panel1.add(doWybrania);
        panel1.add(waluty);
        panel2.add(doPrzewalutowania);
        panel3.add(przelacznik1);
        panel3.add(przelacznik2);
        panel3.add(przelacznik3);
        panel3.add(przelicz);
        panel3.add(wysWynikPrzewalutowania);
        
        
        //grupa przełaczników
        groupSize.add(przelacznik1);
        groupSize.add(przelacznik2);
        groupSize.add(przelacznik3);
        

        
        //sluchacz klasy wewnetrznej 
        SluchaczWaluty x= new SluchaczWaluty();
        SluchaczWaluty2 y= new SluchaczWaluty2();
        waluty.addActionListener(x);
        przelacznik1.addActionListener(y);
        przelacznik2.addActionListener(y);
        przelacznik3.addActionListener(y);
        
        //abstrakcyjne metody
        //this method calculate the current value of the currency
        przelicz.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                double kwotaDoPrzeliczenia = Double.parseDouble(kwota.getText());
                //wartość walut na dzien 02-02-2019r.
                double przelicznik, wynik = 0;
                char mojaWaluta;
                
                
                
                
                
                char jakaWaluta = y.k.charAt(0);
                mojaWaluta = x.w.charAt(0);
                
                
                
                
                switch(mojaWaluta){
                    case'E':
                        if(jakaWaluta=='E') {
                            JOptionPane.showMessageDialog(null, "Nie możesz wykonać tej operacji"); break;
                        }
                        if(jakaWaluta=='U') {
                            przelicznik = 1.1467;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                        if(jakaWaluta=='G') {
                            przelicznik = 0.8789;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                    case'U':
                        if(jakaWaluta=='E') {
                            przelicznik = 0.8721;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                        if(jakaWaluta=='U') {
                            JOptionPane.showMessageDialog(null, "Nie możesz wykonać tej operacji");  break;
                        }
                        if(jakaWaluta=='G') {
                            przelicznik = 0.7665;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                    case'C':
                        if(jakaWaluta=='E') {
                            przelicznik = 0.8783;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                        if(jakaWaluta=='U') {
                            przelicznik = 1.0071;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                        if(jakaWaluta=='G') {
                            przelicznik = 0.7722;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                    case'G':
                        if(jakaWaluta=='E') {
                            przelicznik = 1.143;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                        if(jakaWaluta=='U') {
                            przelicznik = 1.143;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                        if(jakaWaluta=='G') {
                            JOptionPane.showMessageDialog(null, "Nie możesz wykonać tej operacji"); break;
                        }
                    case'J':
                        if(jakaWaluta=='E') {
                            przelicznik = 0.008;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                        if(jakaWaluta=='U') {
                            przelicznik = 0.0092;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                        if(jakaWaluta=='G') {
                            przelicznik = 0.007;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                    case'I':
                        if(jakaWaluta=='E') {
                            przelicznik = 0.0073;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                        if(jakaWaluta=='U') {
                            przelicznik = 0.0083;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                        if(jakaWaluta=='G') {
                            przelicznik = 0.0064;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                    case'P':
                        if(jakaWaluta=='E') {
                            przelicznik = 0.2342;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                        if(jakaWaluta=='U') {
                            przelicznik = 0.2685;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                        if(jakaWaluta=='G') {
                            przelicznik = 0.2058;
                            wynik = kwotaDoPrzeliczenia*przelicznik;
                            break;
                        }
                    default: JOptionPane.showMessageDialog(null, "Coś poszło nie tak... sprawdź opcje wyboru");  break;
                    
                    
                    
                }
                //zaokrąglenie liczby do dwóch miejsc po przecinku
                wynik*=100;
                wynik=Math.round(wynik);
                wynik=wynik/100;
                
                wyswietlWynik(wynik,jakaWaluta,mojaWaluta);
                
                
            }
        });
        //this abstract method catches what write in the text window
        kwota.addKeyListener(new java.awt.event.KeyAdapter() {
            
            
            public void keyPressed(java.awt.event.KeyEvent evt) {
           
                nieWklej(evt);
            
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                oknoTextowe(evt);
            }
        });
        
        
    }
    
    //metody
    //this method convert your chooses and writes on the panel3
    private void wyswietlWynik(double wynik, char jakaWaluta, char mojaWaluta){
        
        double w = wynik;
        String jw="";
        String mw="";
        
        if(mojaWaluta=='E') mw="EURO";
        if(mojaWaluta=='U') mw="USD";
        if(mojaWaluta=='C') mw="CHF";
        if(mojaWaluta=='G') mw="GBP";
        if(mojaWaluta=='J') mw="JPY";
        if(mojaWaluta=='I') mw="ISK";
        if(mojaWaluta=='P') mw="PLN";
        if(jakaWaluta=='E') jw="EURO";
        if(jakaWaluta=='U') jw="USD";
        if(jakaWaluta=='G') jw="GBP";
        
        wysWynikPrzewalutowania.setText("Wartość twojej waluty "+mw+" wynosi: "+w+" "+jw);
        
        
        
    }

    private void oknoTextowe(java.awt.event.KeyEvent evt){
        
        if(!czyLiczba(evt.getKeyChar())) 
            evt.consume();

    }
    //this method catches paste letters and prevent to writes them in the text window
    private void nieWklej(java.awt.event.KeyEvent evt){
    
        
        if(evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V){
            
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String schowek = "";
            
            
            
            try {
                schowek = (String) clipboard.getData(DataFlavor.stringFlavor);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Wystąpił błąd na wejsciu/wyjsciu"); 
            } catch (UnsupportedFlavorException ex) {
                JOptionPane.showMessageDialog(null, "To nie jest liczba"); 
            }
            
            for(int i=0; i<schowek.length(); i++){
                
                if(!czyLiczba(schowek.charAt(i))){
                
                    evt.consume();
                    
                }
            }
        }
    }
    
    //this method check what you writes in the text window - you can write only number
    private boolean czyLiczba(char zn){
        
        if( zn >= '0' && zn <= '9') return true;
        else if (zn == '.') return true;
        return false;
        
    }
    
    
    public static void main(String[] args) {
        
        new Zadanie5().setVisible(true);
        
    
    }
    
    //komponenty
    private JTextField kwota;
    private JComboBox waluty;
    private JRadioButton przelacznik1;
    private JRadioButton przelacznik2;
    private JRadioButton przelacznik3;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel coWpisac = new JLabel("Wpisz kwotę do przeliczenia(np: 123.56):");
    JLabel doWybrania = new JLabel("W jakiej walucie:");
    JLabel doPrzewalutowania = new JLabel("Wybierz walute do przewalutowania: ");
    JLabel wysWynikPrzewalutowania;
    ButtonGroup groupSize;
    JButton przelicz; 

    
    //klasy wewnętrzne
    
    //this listener hear which currency is you want to the other currency for conversion
    class SluchaczWaluty2 implements ActionListener{
        
        String k;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            k =(String)(((JRadioButton)e.getSource()).getText());
            
           
        }
    
        
    }
     //this listnere hear which currency is your
    class SluchaczWaluty implements ActionListener{
        
        String w="E";
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
     
                w =(String)(((JComboBox)e.getSource()).getSelectedItem());
                 
            }
        
    }
    
}