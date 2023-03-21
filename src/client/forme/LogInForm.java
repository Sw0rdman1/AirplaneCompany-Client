/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.forme;

import client.controller.ControllerLogIn;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Božidar
 */
public class LogInForm extends OpstaEkranskaForma {

    private final ControllerLogIn controllerLogIn;

    Color whiteColor = Color.WHITE;
    Color blueColor = new Color(0, 94, 145);
    Color lightBlueColor = new Color(0, 104, 145);
    Color succesColor = new Color(75, 181, 67);
    Color errorColor = new Color(219, 31, 31);
    Color yellowColor = new Color(236, 183, 83);

    /**
     * Creates new form LogInForm
     */
    public LogInForm() {
        initComponents();
        prepareForm();
        controllerLogIn = new ControllerLogIn(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsername = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblInvalidUsername = new javax.swing.JLabel();
        lblInvalidPassword = new javax.swing.JLabel();
        jPanelBlue = new javax.swing.JPanel();
        btnLogIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(420, 270));

        lblUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Log In", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 24), new java.awt.Color(0, 74, 145))); // NOI18N
        lblUsername.setPreferredSize(new java.awt.Dimension(420, 270));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 74, 145));
        jLabel1.setText("Email:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 74, 145));
        jLabel2.setText("Password:");

        txtEmail.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 74, 145));
        txtEmail.setText("vujasinovicb@gmail.com");

        txtPassword.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 74, 145));
        txtPassword.setText("admin");

        lblInvalidUsername.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblInvalidUsername.setText(" ");

        lblInvalidPassword.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblInvalidPassword.setText(" ");

        btnLogIn.setText("Log In");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBlueLayout = new javax.swing.GroupLayout(jPanelBlue);
        jPanelBlue.setLayout(jPanelBlueLayout);
        jPanelBlueLayout.setHorizontalGroup(
            jPanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBlueLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBlueLayout.setVerticalGroup(
            jPanelBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBlueLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogIn)
                .addContainerGap())
        );

        javax.swing.GroupLayout lblUsernameLayout = new javax.swing.GroupLayout(lblUsername);
        lblUsername.setLayout(lblUsernameLayout);
        lblUsernameLayout.setHorizontalGroup(
            lblUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblUsernameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblUsernameLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(lblUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInvalidPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword)))
                    .addGroup(lblUsernameLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(lblInvalidUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addGroup(lblUsernameLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(txtEmail)))
                .addContainerGap())
            .addComponent(jPanelBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lblUsernameLayout.setVerticalGroup(
            lblUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblUsernameLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(lblUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(lblInvalidUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(lblUsernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInvalidPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanelBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed

        validateForm();

        if (controllerLogIn.SOLogIn()) {
            MainForm mf = new MainForm();
            mf.setVisible(true);
            mf.setLocationRelativeTo(null);

        }

    }//GEN-LAST:event_btnLogInActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelBlue;
    private javax.swing.JLabel lblInvalidPassword;
    private javax.swing.JLabel lblInvalidUsername;
    private javax.swing.JPanel lblUsername;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        setSize(420, 330);
        getContentPane().setBackground(whiteColor);
        lblUsername.setBackground(whiteColor);
        jPanelBlue.setBackground(blueColor);

        /*
        JLabel background;
        
        ImageIcon img = new ImageIcon("Background.jpg");
        
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 400, 320);
        add(background);
         */
        prepareButton();

    }

    private void prepareButton() {

        btnLogIn.setBackground(whiteColor);
        btnLogIn.setForeground(blueColor);
        btnLogIn.setFocusPainted(false);
        btnLogIn.setFont(new Font("Sans Serif", Font.BOLD, 16));
    }

    private void validateForm() {

        resetForm();

        if (txtEmail.getText().isEmpty()) {
            txtEmail.setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new LineBorder(errorColor, 2)));
            lblInvalidUsername.setText("Please enter your username!");
            lblInvalidUsername.setForeground(errorColor);
        }

        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
            txtPassword.setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new LineBorder(errorColor, 2)));
            lblInvalidPassword.setText("Please enter your password!");
            lblInvalidPassword.setForeground(errorColor);
        }

    }

    private void resetForm() {
        lblInvalidUsername.setText("");
        lblInvalidPassword.setText("");
        txtPassword.setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new LineBorder(blueColor, 1)));
        txtEmail.setBorder(new CompoundBorder(new EmptyBorder(1, 1, 1, 1), new LineBorder(blueColor, 1)));

    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    @Override
    public OpstiDomenskiObjekat kreirajObjekat() {
        return new Korisnik();
    }

    @Override
    public JLabel getStatusLabel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
