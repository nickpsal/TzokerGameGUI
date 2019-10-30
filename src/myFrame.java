import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class myFrame extends JFrame {
    private int noumero1;
    private int noumero2;
    private int noumero3;
    private int noumero4;
    private int noumero5;
    private int noumerotzoker;

    private int[] TzokerNumbers = new int[5];
    private int tzoker;
    private int counter=0;
    private boolean gettzoker = false;
    private int temp;
    private Random rd = new Random();


    private JPanel panel;
    private JLabel topLabel1;
    private JLabel topLabel2;
    private JTextField noumerο1;
    private JTextField noumerο2;
    private JTextField noumerο3;
    private JTextField noumerο4;
    private JTextField noumerο5;
    private JTextField noumerοtzoker;
    private JButton buttonNumber;
    private JButton buttonInfo;

    public myFrame() {
        panel = new JPanel();

        topLabel1 = new JLabel();
        topLabel1.setText("Δώστε 5 νούμερα απο το 1 εωσ το 45");
        topLabel2 = new JLabel();
        topLabel2.setText("Δώστε 1 νούμερο απο το 1 εωσ το 20");
        noumerο1 = new JTextField(2);
        noumerο2 = new JTextField(2);
        noumerο3 = new JTextField(2);
        noumerο4 = new JTextField(2);
        noumerο5 = new JTextField(2);
        noumerοtzoker = new JTextField(2);
        buttonNumber = new JButton("Κάνε την Κλήρωση");
        buttonInfo = new JButton("Πληροφορίες");

        panel.add(topLabel1);
        panel.add(noumerο1);
        panel.add(noumerο2);
        panel.add(noumerο3);
        panel.add(noumerο4);
        panel.add(noumerο5);
        panel.add(topLabel2);
        panel.add(noumerοtzoker);
        panel.add(buttonNumber);
        panel.add(buttonInfo);

        this.setContentPane(panel);

        ButtonListener listener = new ButtonListener();
        buttonNumber.addActionListener(listener);
        buttonInfo.addActionListener(listener);

        this.setVisible(true);
        this.setSize(400,400);
        this.setTitle("Παίχνιδι Tzoker!!!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonNumber) {
                noumero1 = Integer.parseInt(noumerο1.getText());
                noumero2 = Integer.parseInt(noumerο2.getText());
                noumero3 = Integer.parseInt(noumerο3.getText());
                noumero4 = Integer.parseInt(noumerο4.getText());
                noumero5 = Integer.parseInt(noumerο5.getText());
                noumerotzoker = Integer.parseInt(noumerοtzoker.getText());
                counter = 0;
                if ((noumerο1.getText().equals(" ")) || (noumerο2.getText().equals(" ")) || (noumerο3.getText().equals(" ")) || (noumerο4.getText().equals(" ")) || (noumerο5.getText().equals(" ")) || (noumerοtzoker.getText().equals(" "))) {
                    JOptionPane.showMessageDialog(panel, "Δεν μπορεί να είναι κενό.",
                            "ΣΦΑΛΜΑ", JOptionPane.INFORMATION_MESSAGE);
                }else if ((noumero1 < 1) || (noumero1 > 45) || (noumero2 < 1) || (noumero2 > 45) || (noumero3 < 1) || (noumero3 > 45) || (noumero4 < 1) || (noumero4 > 45) || (noumero5 < 1) || (noumero5 > 45)) {
                    JOptionPane.showMessageDialog(panel, "Λάθος Είσοδος. Δώσε ένα νούμερο απο το 1 εως το 45",
                            "ΣΦΑΛΜΑ", JOptionPane.INFORMATION_MESSAGE);
                }else if ((noumero1 == noumero2) || (noumero1 == noumero3) || (noumero1 == noumero4) || (noumero1 == noumero5) || (noumero2 == noumero3) || (noumero2 == noumero4) || (noumero2 == noumero5) || (noumero3 == noumero4) || (noumero3 == noumero5) || (noumero4 == noumero5) ) {
                    JOptionPane.showMessageDialog(panel, "Λάθος Είσοδος οι αριθμοι δεν μπορουν να ειναι ιδιοι. Δώσε ένα νούμερο απο το 1 εως το 45",
                            "ΣΦΑΛΜΑ", JOptionPane.INFORMATION_MESSAGE);
                }else if ((noumerotzoker < 1) || (noumerotzoker > 20))  {
                    JOptionPane.showMessageDialog(panel, "Λάθος Είσοδος Τζοκερ. Δώσε ένα νούμερο απο το 1 εως το 20",
                            "ΣΦΑΛΜΑ", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    //Κλήρωση Αριθμων Τζοκερ και έλεγχος να μην είναι κανενας 0 και να μην είνια ιδιος με τον προηγουμενο
                    TzokerNumbers[0] = rd.nextInt(45);
                    for (int i = 1; i<TzokerNumbers.length ; i++) {
                        do {
                            temp =  rd.nextInt(45);
                        }while ((temp == TzokerNumbers[(i-1)]) || (temp <=0));
                        TzokerNumbers[i] =  temp;
                    }
                    Arrays.sort(TzokerNumbers);
                    tzoker = rd.nextInt(20);

                    //Έλεγχος αν κέρδισε ο Χρήστης
                    for (int j=0; j<TzokerNumbers.length; j++) {
                        if((TzokerNumbers[j] == noumero1) || (
                                TzokerNumbers[j]== noumero2) || (TzokerNumbers[j] == noumero3) || (TzokerNumbers[j] == noumero4) || (TzokerNumbers[j] == noumero5)) {
                            counter++;
                        }
                    }
                    if (tzoker == noumerotzoker) {
                        gettzoker=true;
                    }
                    JOptionPane.showMessageDialog(panel, "Οι Τυχεροί αριθμοί είναι οι \n" + TzokerNumbers[0] + " " + TzokerNumbers[1] + " " +  TzokerNumbers[2] + " " +  TzokerNumbers[3] + " " +  TzokerNumbers[4]
                                    + "\nΟ Αριθμός Τζόκερ ειναι ο " + tzoker,
                            "ΑΠΟΤΕΛΕΣΜΑΤΑ", JOptionPane.INFORMATION_MESSAGE);
                    if (gettzoker) {
                        if(counter == 0) {
                            JOptionPane.showMessageDialog(panel, "Δεν κερδίσατε. Βρήκατε μόνο τον αριθμό τζοκερ",
                                    "ΑΠΟΤΕΛΕΣΜΑΤΑ", JOptionPane.INFORMATION_MESSAGE);
                        }else {
                            JOptionPane.showMessageDialog(panel, "Βρήκατε " + counter + " + 1",
                                    "ΑΠΟΤΕΛΕΣΜΑΤΑ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else {
                        if (counter == 0 ) {
                            JOptionPane.showMessageDialog(panel, "Δεν κερδίσατε. Δεν βρήκατε κανένα νούμερο",
                                    "ΑΠΟΤΕΛΕΣΜΑΤΑ", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(panel, "Βρήκατε " + counter,
                                    "ΑΠΟΤΕΛΕΣΜΑΤΑ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }else {
                JOptionPane.showMessageDialog(panel, "Προγραμματιστης : Ψαλτακης Νικολαος StormRideR "
                                + "(c)2019 \nΠρόγραμμα Προσομοίωσης του παιχνιδιού ΤΖΟΚΕΡ του ΟΠΑΠ\n" + "Το Πρόγραμμα έχιε φτιαχτεί για εκπαιδευιτκούς σκοπούς και καμία "
                                + "Σχέση δεν έχει με το επίσημο πρόγραμμα του ΟΠΑΠ",
                        "ΠΛΗΡΟΦΟΡΙΕΣ", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
