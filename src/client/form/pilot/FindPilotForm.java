/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.form.pilot;

import client.form.airport.*;
import client.form.flight.*;
import client.form.tickets.*;
import client.communication.Communication;
import client.controller.ControllerDeletePilot;
import client.controller.ControllerFindAllPilots;
import client.controller.ControllerFindSpecificPilot;
import client.forme.OpstaEkranskaForma;
import domen.OpstiDomenskiObjekat;
import domen.Pilot;
import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Božidar
 */
public class FindPilotForm extends OpstaEkranskaForma {

    Color whiteColor = Color.WHITE;
    Color blueColor = new Color(0, 94, 145);
    Color lightBlueColor = new Color(0, 104, 145);
    Color succesColor = new Color(75, 181, 67);
    Color errorColor = new Color(219, 31, 31);
    Color yellowColor = new Color(236, 183, 83);

    private final ControllerFindAllPilots contFindAllPilots;
    private final ControllerFindSpecificPilot contFindSpecificPilots;
    private final ControllerDeletePilot contDeletePilot;

    /**
     * Creates new form CreateTicketForm
     */
    public FindPilotForm() {
        contFindAllPilots = new ControllerFindAllPilots(this);
        contFindSpecificPilots = new ControllerFindSpecificPilot(this);
        contDeletePilot = new ControllerDeletePilot(this);
        initComponents();
        prepareForm();
        contFindAllPilots.prepareTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNaslov = new javax.swing.JPanel();
        lblNaslov = new javax.swing.JLabel();
        jPanelTicket = new javax.swing.JPanel();
        lblNewTicket = new javax.swing.JLabel();
        jPanelMain = new javax.swing.JPanel();
        jPanelFullTicket = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPilots = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        jPanelFilter = new javax.swing.JPanel();
        rbFirstName = new javax.swing.JRadioButton();
        txtFirstName = new javax.swing.JTextField();
        rbLastName = new javax.swing.JRadioButton();
        txtLastName = new javax.swing.JTextField();
        rbID = new javax.swing.JRadioButton();
        txtID = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblNaslov.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblNaslov.setText("PS AIRWAYS");

        javax.swing.GroupLayout jPanelNaslovLayout = new javax.swing.GroupLayout(jPanelNaslov);
        jPanelNaslov.setLayout(jPanelNaslovLayout);
        jPanelNaslovLayout.setHorizontalGroup(
            jPanelNaslovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNaslovLayout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(lblNaslov)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNaslovLayout.setVerticalGroup(
            jPanelNaslovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNaslovLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNaslov)
                .addContainerGap())
        );

        lblNewTicket.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        lblNewTicket.setText("Pilot");

        javax.swing.GroupLayout jPanelTicketLayout = new javax.swing.GroupLayout(jPanelTicket);
        jPanelTicket.setLayout(jPanelTicketLayout);
        jPanelTicketLayout.setHorizontalGroup(
            jPanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTicketLayout.createSequentialGroup()
                .addGap(389, 389, 389)
                .addComponent(lblNewTicket)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTicketLayout.setVerticalGroup(
            jPanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNewTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanelMain.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pilots", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 24), new java.awt.Color(236, 183, 83))); // NOI18N

        jPanelFullTicket.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "All Pilots", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 22), new java.awt.Color(243, 187, 87))); // NOI18N

        tblPilots.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        tblPilots.setForeground(new java.awt.Color(255, 255, 255));
        tblPilots.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Pilot ID", "First Name", "Last Name", "Passport number", "Adress", "Date of Birth"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPilots.setRowHeight(35);
        jScrollPane1.setViewportView(tblPilots);
        if (tblPilots.getColumnModel().getColumnCount() > 0) {
            tblPilots.getColumnModel().getColumn(0).setResizable(false);
            tblPilots.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblPilots.getColumnModel().getColumn(1).setResizable(false);
            tblPilots.getColumnModel().getColumn(2).setResizable(false);
            tblPilots.getColumnModel().getColumn(3).setResizable(false);
            tblPilots.getColumnModel().getColumn(4).setResizable(false);
            tblPilots.getColumnModel().getColumn(5).setResizable(false);
        }

        btnCreate.setText("ADD NEW");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setText("SHOW ALL");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblStatus.setBackground(new java.awt.Color(153, 255, 153));
        lblStatus.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblStatus.setText("  ");

        javax.swing.GroupLayout jPanelFullTicketLayout = new javax.swing.GroupLayout(jPanelFullTicket);
        jPanelFullTicket.setLayout(jPanelFullTicketLayout);
        jPanelFullTicketLayout.setHorizontalGroup(
            jPanelFullTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFullTicketLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(jPanelFullTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addGap(121, 121, 121))
            .addGroup(jPanelFullTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFullTicketLayout.setVerticalGroup(
            jPanelFullTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFullTicketLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus)
                .addGap(0, 19, Short.MAX_VALUE))
            .addGroup(jPanelFullTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUpdate)
                .addGap(63, 63, 63)
                .addComponent(btnCreate)
                .addGap(57, 57, 57)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Specific search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 22), new java.awt.Color(255, 255, 255))); // NOI18N

        rbFirstName.setBackground(new java.awt.Color(0, 94, 145));
        rbFirstName.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rbFirstName.setForeground(new java.awt.Color(236, 183, 83));
        rbFirstName.setText("First Name");
        rbFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFirstNameActionPerformed(evt);
            }
        });

        txtFirstName.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        rbLastName.setBackground(new java.awt.Color(0, 94, 145));
        rbLastName.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rbLastName.setForeground(new java.awt.Color(236, 183, 83));
        rbLastName.setText("Last Name");
        rbLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLastNameActionPerformed(evt);
            }
        });

        txtLastName.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        rbID.setBackground(new java.awt.Color(0, 94, 145));
        rbID.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        rbID.setForeground(new java.awt.Color(236, 183, 83));
        rbID.setText("Pilot ID");
        rbID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbIDActionPerformed(evt);
            }
        });

        txtID.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        btnFind.setText("FIND");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFilterLayout = new javax.swing.GroupLayout(jPanelFilter);
        jPanelFilter.setLayout(jPanelFilterLayout);
        jPanelFilterLayout.setHorizontalGroup(
            jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilterLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFilterLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(rbLastName))
                    .addGroup(jPanelFilterLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71)
                .addGroup(jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rbID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(btnFind)
                .addGap(55, 55, 55))
        );
        jPanelFilterLayout.setVerticalGroup(
            jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFilterLayout.createSequentialGroup()
                .addGroup(jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFilterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFilterLayout.createSequentialGroup()
                                .addComponent(rbLastName)
                                .addGap(18, 18, 18)
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelFilterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelFilterLayout.createSequentialGroup()
                                    .addComponent(rbFirstName)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelFilterLayout.createSequentialGroup()
                                    .addComponent(rbID)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanelFilterLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnFind)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelFullTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanelFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelFullTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNaslov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanelNaslov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
         }//GEN-LAST:event_txtFirstNameActionPerformed

    private void rbFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFirstNameActionPerformed

        if (rbFirstName.isSelected()) {
            txtFirstName.setEnabled(true);
            txtFirstName.setBackground(whiteColor);
        } else {
            txtFirstName.setEnabled(false);
            txtFirstName.setBackground(blueColor);
            txtFirstName.setText("");
        }    }//GEN-LAST:event_rbFirstNameActionPerformed

    private void rbLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLastNameActionPerformed
        if (rbLastName.isSelected()) {
            txtLastName.setEnabled(true);
            txtLastName.setBackground(whiteColor);
        } else {
            txtLastName.setEnabled(false);
            txtLastName.setBackground(blueColor);
            txtLastName.setText("");
        }
    }//GEN-LAST:event_rbLastNameActionPerformed

    private void rbIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbIDActionPerformed
        if (rbID.isSelected()) {
            txtID.setEnabled(true);
            txtID.setBackground(whiteColor);
        } else {
            txtID.setEnabled(false);
            txtID.setBackground(blueColor);
            txtID.setText("");
        }
    }//GEN-LAST:event_rbIDActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        CreatePilotForm caf = new CreatePilotForm();
        caf.setVisible(true);
        caf.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnCreateActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        contFindAllPilots.SOLoadListPilots();
        contFindAllPilots.fillTable();

    }//GEN-LAST:event_formWindowOpened

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        contFindSpecificPilots.prepareTable();
        contFindSpecificPilots.SOFindSpecificPilots();
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        if (!tblPilots.getSelectionModel().isSelectionEmpty()) {

            int input = JOptionPane.showConfirmDialog(null,
                    "Do you want to proceed to delete this pilot?", "Select an Option...", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                contDeletePilot.SODeletePilot();
                contFindSpecificPilots.prepareTable();
                contFindAllPilots.SOLoadListPilots();
                contFindAllPilots.fillTable();
            } else {
                return;
            }
        } else {
            lblStatus.setForeground(Color.WHITE);
            lblStatus.setBackground(new Color(219, 31, 31));
            lblStatus.setOpaque(true);
            lblStatus.setText("You didnt select any row!");
            lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
            lblStatus.setVerticalAlignment(SwingConstants.CENTER);

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        contFindSpecificPilots.prepareTable();
        contFindAllPilots.SOLoadListPilots();
        contFindAllPilots.fillTable();

        lblStatus.setForeground(Color.WHITE);
        lblStatus.setBackground(new Color(75, 181, 67));
        lblStatus.setOpaque(true);
        lblStatus.setText("All pilots are showed!");
        lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
        lblStatus.setVerticalAlignment(SwingConstants.CENTER);

    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanelFilter;
    private javax.swing.JPanel jPanelFullTicket;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelNaslov;
    private javax.swing.JPanel jPanelTicket;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNaslov;
    private javax.swing.JLabel lblNewTicket;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JRadioButton rbFirstName;
    private javax.swing.JRadioButton rbID;
    private javax.swing.JRadioButton rbLastName;
    private javax.swing.JTable tblPilots;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        getContentPane().setBackground(blueColor);

        jPanelNaslov.setBackground(yellowColor);
        lblNaslov.setForeground(whiteColor);

        jPanelMain.setBackground(blueColor);
        jPanelTicket.setBackground(whiteColor);
        jPanelFilter.setBackground(blueColor);
        jPanelFullTicket.setBackground(blueColor);
        lblNewTicket.setForeground(yellowColor);
        tblPilots.setBackground(whiteColor);
        tblPilots.setForeground(blueColor);

        txtID.setEnabled(false);
        txtID.setBackground(blueColor);
        txtID.setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new LineBorder(blueColor, 2)));
        txtID.setHorizontalAlignment(SwingConstants.CENTER);

        txtFirstName.setEnabled(false);
        txtFirstName.setBackground(blueColor);
        txtFirstName.setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new LineBorder(blueColor, 2)));
        txtFirstName.setHorizontalAlignment(SwingConstants.CENTER);

        txtLastName.setEnabled(false);
        txtLastName.setBackground(blueColor);
        txtLastName.setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new LineBorder(blueColor, 2)));
        txtLastName.setHorizontalAlignment(SwingConstants.CENTER);

        prepareButton();
    }

    private void prepareButton() {

        btnCreate.setBackground(whiteColor);
        btnCreate.setForeground(blueColor);
        btnCreate.setFocusPainted(false);
        btnCreate.setFont(new Font("Sans Serif", Font.BOLD, 18));

        btnDelete.setBackground(whiteColor);
        btnDelete.setForeground(blueColor);
        btnDelete.setFocusPainted(false);
        btnDelete.setFont(new Font("Sans Serif", Font.BOLD, 18));

        btnUpdate.setBackground(whiteColor);
        btnUpdate.setForeground(blueColor);
        btnUpdate.setFocusPainted(false);
        btnUpdate.setFont(new Font("Sans Serif", Font.BOLD, 18));

        btnFind.setBackground(yellowColor);
        btnFind.setForeground(whiteColor);
        btnFind.setFocusPainted(false);
        btnFind.setFont(new Font("Sans Serif", Font.BOLD, 22));

    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekat() {
        return new Pilot();
    }

    public JTable getTblPilots() {
        return tblPilots;
    }

    void azurirajTabelu(Pilot pilot) {
        contFindAllPilots.updateTable(pilot);
    }

    public JRadioButton getRbID() {
        return rbID;
    }

    public JRadioButton getRbFirstName() {
        return rbFirstName;
    }

    public JRadioButton getRbLastName() {
        return rbLastName;
    }

    public JTextField getTxtID() {
        return txtID;
    }

    public JTextField getTxtLastName() {
        return txtLastName;
    }

    public JTextField getTxtFirstName() {
        return txtFirstName;
    }

    @Override
    public JLabel getStatusLabel() {
        return lblStatus;
    }

}
