//package old;
//
//import java.awt.Component;
//
//import javax.swing.JOptionPane;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author arndts17
// */
//public class Fenster extends javax.swing.JFrame {
//    
//    /**
//     * Creates new form Fenster
//     */
//    public Fenster(Controller c) {
//    	controller = c;
//        initComponents();
//    }
//    
//    public Fenster() {
//		
//	}
//    
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    private void initComponents() {
//
//        jLabel4 = new javax.swing.JLabel();
//        jTabbedPane1 = new javax.swing.JTabbedPane();
//        auszahlung = new javax.swing.JPanel();
//        auszahlungText = new javax.swing.JTextField();
//        auszahlungButton = new javax.swing.JButton();
//        jLabel1 = new javax.swing.JLabel();
//        jLabel2 = new javax.swing.JLabel();
//        Konotstand = new javax.swing.JPanel();
//        kontostandButton = new javax.swing.JButton();
//        ueberweisung = new javax.swing.JPanel();
//        jLabel3 = new javax.swing.JLabel();
//        zielKontonummerText = new javax.swing.JTextField();
//        jLabel5 = new javax.swing.JLabel();
//        ueberweisungsBetragText = new javax.swing.JTextField();
//        jLabel6 = new javax.swing.JLabel();
//        ueberweisenButton = new javax.swing.JButton();
//
//        jLabel4.setText("jLabel4");
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setName("frame"); // NOI18N
//
//        jTabbedPane1.setMinimumSize(new java.awt.Dimension(100, 100));
//
//        auszahlungText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
//        auszahlungText.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                auszahlungTextActionPerformed(evt);
//            }
//        });
//
//        auszahlungButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
//        auszahlungButton.setText("Auszahlen");
//        auszahlungButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                auszahlungButtonActionPerformed(evt);
//            }
//        });
//
//        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
//        jLabel1.setText("Euro");
//
//        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
//        jLabel2.setText("Betrag der Auszahlung:");
//
//        javax.swing.GroupLayout auszahlungLayout = new javax.swing.GroupLayout(auszahlung);
//        auszahlung.setLayout(auszahlungLayout);
//        auszahlungLayout.setHorizontalGroup(
//            auszahlungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(auszahlungLayout.createSequentialGroup()
//                .addGap(30, 30, 30)
//                .addGroup(auszahlungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addGroup(auszahlungLayout.createSequentialGroup()
//                        .addGroup(auszahlungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                            .addComponent(auszahlungButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
//                            .addComponent(auszahlungText, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                .addContainerGap(147, Short.MAX_VALUE))
//        );
//        auszahlungLayout.setVerticalGroup(
//            auszahlungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, auszahlungLayout.createSequentialGroup()
//                .addGap(30, 30, 30)
//                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(18, 18, 18)
//                .addGroup(auszahlungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(auszahlungText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(18, 18, 18)
//                .addComponent(auszahlungButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(154, Short.MAX_VALUE))
//        );
//
//        jTabbedPane1.addTab("Auszahlung", auszahlung);
//
//        kontostandButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
//        kontostandButton.setText("Kontostand abfragen");
//        kontostandButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                kontostandButtonActionPerformed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout KonotstandLayout = new javax.swing.GroupLayout(Konotstand);
//        Konotstand.setLayout(KonotstandLayout);
//        KonotstandLayout.setHorizontalGroup(
//            KonotstandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(KonotstandLayout.createSequentialGroup()
//                .addGap(30, 30, 30)
//                .addComponent(kontostandButton)
//                .addContainerGap(209, Short.MAX_VALUE))
//        );
//        KonotstandLayout.setVerticalGroup(
//            KonotstandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(KonotstandLayout.createSequentialGroup()
//                .addGap(30, 30, 30)
//                .addComponent(kontostandButton)
//                .addContainerGap(253, Short.MAX_VALUE))
//        );
//
//        jTabbedPane1.addTab("Kontostand", Konotstand);
//
//        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
//        jLabel3.setText("Zielkontonummer:");
//
//        zielKontonummerText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
//
//        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
//        jLabel5.setText("Betrag der ueberweisung:");
//
//        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
//        jLabel6.setText("Euro");
//
//        ueberweisenButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
//        ueberweisenButton.setText("ueberweisen");
//        ueberweisenButton.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                ueberweisenButtonActionPerformed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout ueberweisungLayout = new javax.swing.GroupLayout(ueberweisung);
//        ueberweisung.setLayout(ueberweisungLayout);
//        ueberweisungLayout.setHorizontalGroup(
//            ueberweisungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(ueberweisungLayout.createSequentialGroup()
//                .addGap(30, 30, 30)
//                .addGroup(ueberweisungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(jLabel3)
//                    .addComponent(zielKontonummerText, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addGroup(ueberweisungLayout.createSequentialGroup()
//                        .addGroup(ueberweisungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                            .addComponent(ueberweisenButton)
//                            .addComponent(ueberweisungsBetragText, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
//                            .addComponent(jLabel5))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                .addContainerGap(171, Short.MAX_VALUE))
//        );
//        ueberweisungLayout.setVerticalGroup(
//            ueberweisungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(ueberweisungLayout.createSequentialGroup()
//                .addGap(30, 30, 30)
//                .addComponent(jLabel3)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(zielKontonummerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(35, 35, 35)
//                .addComponent(jLabel5)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(ueberweisungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(ueberweisungsBetragText))
//                .addGap(18, 18, 18)
//                .addComponent(ueberweisenButton)
//                .addContainerGap(111, Short.MAX_VALUE))
//        );
//
//        jTabbedPane1.addTab("ueberweisung", ueberweisung);
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//        );
//
//        pack();
//    }// </editor-fold>//GEN-END:initComponents
//
//    private void auszahlungTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auszahlungTextActionPerformed
//        
//    }//GEN-LAST:event_auszahlungTextActionPerformed
//
//    private void auszahlungButtonActionPerformed(java.awt.event.ActionEvent evt) {
//    	double betrag = -1;
//    	int status = -1;
//    	if(!auszahlungText.getText().matches("[0-9]+\\.?[0-9]{0,2}"))
//    		dialogFehlermeldung(1);
//    	else {
//    		betrag = Double.parseDouble(auszahlungText.getText());
//    		status = controller.abheben(betrag);
//    		if(status == 0) 
//    			dialogNachricht(betrag + " Euro wurden ausgezahlt.");
//    		else
//    			dialogFehlermeldung(status);
//    	}
//    }
//
//    private void kontostandButtonActionPerformed(java.awt.event.ActionEvent evt) {
//    	dialogNachricht("Dein Kontostand betraegt " + controller.getKontostand() + " Euro.");
//    }//GEN-LAST:event_kontostandButtonActionPerformed
//   
//    private void ueberweisenButtonActionPerformed(java.awt.event.ActionEvent evt) {
//    	int zielIban = -1;
//    	double betrag = -1;
//    	int status = -1;
//    	//Anleitung: http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
//    	//oder: http://www.vogella.com/tutorials/JavaRegularExpressions/article.html
//    	if(!zielKontonummerText.getText().matches("[0-9]+"))
//    		dialogFehlermeldung(1);
//    	else
//    		zielIban = Integer.parseInt(zielKontonummerText.getText());
//    	if(!ueberweisungsBetragText.getText().matches("[0-9]+\\.?[0-9]{0,2}"))
//    		dialogFehlermeldung(1);
//    	else
//    		betrag = Double.parseDouble(ueberweisungsBetragText.getText());
//    	
//    	if(zielIban != -1 && betrag != -1) {
//    		status = controller.ueberweisen(zielIban, betrag);
//    		if(status == 0)
//    			dialogNachricht(betrag + " Euro wurden an das Konto " + zielIban + " ueberwiesen.");
//    		else
//    			dialogFehlermeldung(status);
//    	}
//    	
//    }
//    
//    private void dialogNachricht(String text) {
//        JOptionPane.showMessageDialog(this, text);
//    }
//    
//    public void dialogFehlermeldung(int index) {
//        JOptionPane.showMessageDialog(this, fehlermeldungen[index - 1], "Fehler!", JOptionPane.ERROR_MESSAGE);
//    }
//    
//    /**
//     * @param args the command line arguments
//     */
//    public void guiStarten() {
//    	
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Fenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Fenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Fenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Fenster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Fenster(controller).setVisible(true);
//            } 
//        });
//    }
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JPanel Konotstand;
//    private javax.swing.JPanel auszahlung;
//    private javax.swing.JButton auszahlungButton;
//    private javax.swing.JTextField auszahlungText;
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel jLabel2;
//    private javax.swing.JLabel jLabel3;
//    private javax.swing.JLabel jLabel4;
//    private javax.swing.JLabel jLabel5;
//    private javax.swing.JLabel jLabel6;
//    private javax.swing.JTabbedPane jTabbedPane1;
//    private javax.swing.JButton kontostandButton;
//    private javax.swing.JTextField zielKontonummerText;
//    private javax.swing.JPanel ueberweisung;
//    private javax.swing.JButton ueberweisenButton;
//    private javax.swing.JTextField ueberweisungsBetragText;
//    // End of variables declaration//GEN-END:variables
//    // Fehlermedungen:
//    private String fehlermeldungen[] = {"Fehler1 ", "Fehler2", "Fehler3", "Fehler4", "Fehler5", "Fehler6", "Fehler7", "Fehler8"};
//    //Ende Fehlermeldungen
//    private Controller controller;
//    
//}
//
