/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofbd.View;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import projetofbd.DAO.RevistaDAO;
import projetofbd.Model.Revista;

/**
 *
 * @author WELLINGTON
 */
public class TelaRevista extends javax.swing.JFrame {
      ResultSet resultSet = null;
    
    

    /**
     * Creates new form TelaRevista
     */
    public TelaRevista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRevista = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtIdRevista = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomeRevista = new javax.swing.JTextField();
        btnAdicionarRevista = new javax.swing.JButton();
        btnEditarRevista = new javax.swing.JButton();
        btnBuscarRevista = new javax.swing.JButton();
        btnDeletarRevista = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtISSN = new javax.swing.JTextField();
        txtEditora = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Revista");

        txtBuscar.setPreferredSize(new java.awt.Dimension(40, 25));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetofbd/icones/lupa.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("* Campos Obrigatórios");

        tblRevista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número", "Nome", "Editora", "ISSN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRevista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRevistaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRevista);

        jLabel2.setText("Numero: ");

        txtIdRevista.setEditable(false);

        jLabel3.setText("* Nome:");

        btnAdicionarRevista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetofbd/icones/add.png"))); // NOI18N
        btnAdicionarRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarRevistaActionPerformed(evt);
            }
        });

        btnEditarRevista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetofbd/icones/edit.png"))); // NOI18N
        btnEditarRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarRevistaActionPerformed(evt);
            }
        });

        btnBuscarRevista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetofbd/icones/search.png"))); // NOI18N
        btnBuscarRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRevistaActionPerformed(evt);
            }
        });

        btnDeletarRevista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetofbd/icones/delete.png"))); // NOI18N

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnVoltar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVoltar)
        );

        jLabel5.setText("Editora:");

        jLabel6.setText("ISSN:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdicionarRevista, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnEditarRevista, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarRevista, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btnDeletarRevista))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtISSN, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdRevista, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtNomeRevista)))))
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdRevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtISSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomeRevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditarRevista)
                    .addComponent(btnAdicionarRevista)
                    .addComponent(btnBuscarRevista)
                    .addComponent(btnDeletarRevista))
                .addGap(37, 37, 37)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        setSize(new java.awt.Dimension(576, 410));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        try {
            listarTabelaPesquisador();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na transação");
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tblRevistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRevistaMouseClicked
        // prencher os campos do pesquisador
        setarCampos();

    }//GEN-LAST:event_tblRevistaMouseClicked

    private void btnAdicionarRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarRevistaActionPerformed
        // Adcionar pesquisador
        try {if (validacao()){
            JOptionPane.showMessageDialog(null, "Preencha todo os campos obrigátorios.");
        }else{
            Revista revista = new Revista();
            revista.setNome_Revista(txtNomeRevista.getText());
            RevistaDAO revistaDAO = new RevistaDAO();
            revistaDAO.create(revista);
            limparCampos();
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Revista já existe");
            limparCampos();
        }

    }//GEN-LAST:event_btnAdicionarRevistaActionPerformed

    private void btnEditarRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarRevistaActionPerformed
        // TODO add your handling code here:
        Revista revista = new Revista();
        int id = Integer.parseInt(txtIdRevista.getText());
        revista.setCod_Revista((id));
        revista.setNome_Revista(txtNomeRevista.getText());
        revista.setEditora(txtEditora.getText());
        revista.setISSN(txtISSN.getText());
        RevistaDAO revistaDAO = new RevistaDAO();
        int adicionadao = revistaDAO.update(revista);
        if (adicionadao > 0){
            JOptionPane.showMessageDialog(null, "Revista editado com sucesso.");
            limparCampos();
            listarTabelaPesquisador();
            btnAdicionarRevista.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "Revista não editado.");
        }
    }//GEN-LAST:event_btnEditarRevistaActionPerformed
     public void setarCampos(){
        int setar = tblRevista.getSelectedRow();
        txtIdRevista.setText(tblRevista.getModel().getValueAt(setar, 0).toString());
        txtNomeRevista.setText(tblRevista.getModel().getValueAt(setar, 1).toString());
        txtEditora.setText(tblRevista.getModel().getValueAt(setar, 2).toString());
        txtISSN.setText(tblRevista.getModel().getValueAt(setar, 3).toString());
        // A linha abaixo desabilitar o botão adicionar
        btnAdicionarRevista.setEnabled(false);
    }
     
    private void limparCampos(){
     txtIdRevista.setText(null);
     txtNomeRevista.setText(null);
     txtBuscar.setText(null);
     txtEditora.setText(null);
     txtISSN.setText(null);
   }
    private boolean validacao() {
        return (txtNomeRevista.getText().isEmpty()||
                txtEditora.getText().isEmpty() ||
                txtISSN.getText().isEmpty());
    }
    
     private void listarTabelaPesquisador() {
        Revista revista = new Revista();
        revista.setNome_Revista(txtBuscar.getText());
        RevistaDAO revistaDAO = new RevistaDAO();
        resultSet =  revistaDAO.read(revista);
        //usando a bibliboteca rs2xml.jar para preencher a tabela
        tblRevista.setModel(DbUtils.resultSetToTableModel(resultSet));
    }
     
    
    private void btnBuscarRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRevistaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnBuscarRevistaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:

        TelaPrincipal telaprincipal = new TelaPrincipal();
        telaprincipal.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRevista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRevista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarRevista;
    private javax.swing.JButton btnBuscarRevista;
    private javax.swing.JButton btnDeletarRevista;
    private javax.swing.JButton btnEditarRevista;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRevista;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JTextField txtISSN;
    private javax.swing.JTextField txtIdRevista;
    private javax.swing.JTextField txtNomeRevista;
    // End of variables declaration//GEN-END:variables
}
