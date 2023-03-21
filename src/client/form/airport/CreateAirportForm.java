/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.form.airport;

import client.form.flight.*;
import client.form.tickets.*;
import client.communication.Communication;
import client.controller.ControllerCreateAirport;
import client.controller.ControllerCreatePilot;
import client.forme.OpstaEkranskaForma;
import domen.Aerodrom;
import domen.Country;
import domen.OpstiDomenskiObjekat;
import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Božidar
 */
public class CreateAirportForm extends OpstaEkranskaForma {

    Color whiteColor = Color.WHITE;
    Color blueColor = new Color(0, 94, 145);
    Color lightBlueColor = new Color(0, 104, 145);
    Color succesColor = new Color(75, 181, 67);
    Color errorColor = new Color(219, 31, 31);
    Color yellowColor = new Color(236, 183, 83);

    private Aerodrom aerodrom;
    private final ControllerCreateAirport contCreateAirport;

    /**
     * Creates new form CreateTicketForm
     */
    public CreateAirportForm() {
        initComponents();
        contCreateAirport = new ControllerCreateAirport(this);
        prepareForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTicket = new javax.swing.JPanel();
        lblNewTicket = new javax.swing.JLabel();
        jPanelMain = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanelFlight = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbDrzavaAerodrom = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtGradAerodrom = new javax.swing.JTextField();
        jPanelTime = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtImeAerodrom = new javax.swing.JTextField();
        btnCreateFlight = new javax.swing.JButton();
        txtIDAerodrom = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblNewTicket.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        lblNewTicket.setText("New Airport");

        javax.swing.GroupLayout jPanelTicketLayout = new javax.swing.GroupLayout(jPanelTicket);
        jPanelTicket.setLayout(jPanelTicketLayout);
        jPanelTicketLayout.setHorizontalGroup(
            jPanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTicketLayout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(lblNewTicket)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTicketLayout.setVerticalGroup(
            jPanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNewTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanelMain.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Airport", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel5.setText("Airport ID:");

        jPanelFlight.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Location", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 24), new java.awt.Color(247, 184, 84))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel1.setText("Country:");

        cmbDrzavaAerodrom.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel6.setText("City:");

        txtGradAerodrom.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        txtGradAerodrom.setForeground(new java.awt.Color(0, 94, 145));
        txtGradAerodrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGradAerodromActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFlightLayout = new javax.swing.GroupLayout(jPanelFlight);
        jPanelFlight.setLayout(jPanelFlightLayout);
        jPanelFlightLayout.setHorizontalGroup(
            jPanelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFlightLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbDrzavaAerodrom, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtGradAerodrom, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanelFlightLayout.setVerticalGroup(
            jPanelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFlightLayout.createSequentialGroup()
                .addGroup(jPanelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbDrzavaAerodrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jPanelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtGradAerodrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanelTime.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 24), new java.awt.Color(247, 184, 84))); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 94, 145));
        jLabel4.setText("Name:");

        txtImeAerodrom.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        txtImeAerodrom.setForeground(new java.awt.Color(0, 94, 145));
        txtImeAerodrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImeAerodromActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTimeLayout = new javax.swing.GroupLayout(jPanelTime);
        jPanelTime.setLayout(jPanelTimeLayout);
        jPanelTimeLayout.setHorizontalGroup(
            jPanelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimeLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtImeAerodrom, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanelTimeLayout.setVerticalGroup(
            jPanelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimeLayout.createSequentialGroup()
                .addGroup(jPanelTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtImeAerodrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnCreateFlight.setText("CREATE AIRPORT");
        btnCreateFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateFlightActionPerformed(evt);
            }
        });

        txtIDAerodrom.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        txtIDAerodrom.setText("111");

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtIDAerodrom)
                                .addGap(46, 46, 46))
                            .addComponent(jPanelFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jPanelTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(btnCreateFlight)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIDAerodrom))
                .addGap(38, 38, 38)
                .addComponent(jPanelFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnCreateFlight)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtImeAerodromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImeAerodromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImeAerodromActionPerformed

    private void txtGradAerodromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGradAerodromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGradAerodromActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        contCreateAirport.SOFindNextIDAirport();
    }//GEN-LAST:event_formWindowOpened

    private void btnCreateFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFlightActionPerformed
        try {
            contCreateAirport.SOCreateAirport();
        } catch (Exception ex) {
            Logger.getLogger(CreateAirportForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnCreateFlightActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateFlight;
    private javax.swing.JComboBox cmbDrzavaAerodrom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanelFlight;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelTicket;
    private javax.swing.JPanel jPanelTime;
    private javax.swing.JLabel lblNewTicket;
    private javax.swing.JTextField txtGradAerodrom;
    private javax.swing.JLabel txtIDAerodrom;
    private javax.swing.JTextField txtImeAerodrom;
    // End of variables declaration//GEN-END:variables

    private Country[] createCountryList() {
        String[] countryCodes = Locale.getISOCountries();
        Country[] listCountry = new Country[countryCodes.length];

        for (int i = 0; i < countryCodes.length; i++) {
            Locale locale = new Locale("", countryCodes[i]);
            String code = locale.getCountry();
            String name = locale.getDisplayCountry();

            listCountry[i] = new Country(code, name);
        }

        Arrays.sort(listCountry);

        return listCountry;
    }

    private void prepareForm() {
        getContentPane().setBackground(blueColor);

        jPanelMain.setBackground(blueColor);
        jPanelTicket.setBackground(yellowColor);
        jPanelFlight.setBackground(blueColor);
        jPanelTime.setBackground(blueColor);
        lblNewTicket.setForeground(whiteColor);

        jLabel4.setForeground(whiteColor);
        jLabel5.setForeground(whiteColor);
        jLabel6.setForeground(whiteColor);
        jLabel1.setForeground(whiteColor);

        cmbDrzavaAerodrom.setForeground(blueColor);
        cmbDrzavaAerodrom.setBackground(whiteColor);

        txtImeAerodrom.setForeground(blueColor);
        txtIDAerodrom.setForeground(blueColor);

        txtIDAerodrom.setForeground(yellowColor);

        Country[] listCountry = createCountryList();

        for (Country country : listCountry) {
            this.cmbDrzavaAerodrom.addItem(country.getName());
        }

        prepareButton();
    }

    private void prepareButton() {

        btnCreateFlight.setBackground(whiteColor);
        btnCreateFlight.setForeground(blueColor);
        btnCreateFlight.setFocusPainted(false);
        btnCreateFlight.setFont(new Font("Sans Serif", Font.BOLD, 22));

    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekat() {
        return new Aerodrom();
    }

    @Override
    public JLabel getStatusLabel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JLabel getTxtIDAerodrom() {
        return txtIDAerodrom;
    }

    public JTextField getTxtImeAerodrom() {
        return txtImeAerodrom;
    }

    public JTextField getTxtGradAerodrom() {
        return txtGradAerodrom;
    }

    public JComboBox<String> getCmbDrzavaAerodrom() {
        return cmbDrzavaAerodrom;
    }

}
