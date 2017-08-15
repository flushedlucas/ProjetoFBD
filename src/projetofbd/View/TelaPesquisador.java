/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofbd.View;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import projetofbd.DAO.PesquisadorDAO;
import projetofbd.Model.Pesquisador;

/**
 *
 * @author WELLINGTON
 */
public class TelaPesquisador extends javax.swing.JFrame {

    ResultSet resultSet = null;

    /**
     * Creates new form TelaPesquisador
     */
    public TelaPesquisador() {
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesquisador = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtIdPesquisador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNomePesquisador = new javax.swing.JTextField();
        btnAdicionarPesquisador = new javax.swing.JButton();
        btnEditarPesquisador = new javax.swing.JButton();
        btnDeletarPesquisador = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUniversidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisador");
        setPreferredSize(new java.awt.Dimension(600, 430));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtBuscar.setPreferredSize(new java.awt.Dimension(40, 25));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tblPesquisador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Universidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPesquisador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesquisadorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPesquisador);
        tblPesquisador.setModel( new javax.swing.table.DefaultTableModel(

            new Object[][]{}, new String []{ "Nome", "Universidade"}

        ));

        jLabel2.setText("Numero: ");

        txtIdPesquisador.setEditable(false);

        jLabel3.setText("* Nome:");

        btnAdicionarPesquisador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetofbd/icones/add.png"))); // NOI18N
        btnAdicionarPesquisador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarPesquisadorActionPerformed(evt);
            }
        });

        btnEditarPesquisador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetofbd/icones/edit.png"))); // NOI18N
        btnEditarPesquisador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPesquisadorActionPerformed(evt);
            }
        });

        btnDeletarPesquisador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetofbd/icones/delete.png"))); // NOI18N
        btnDeletarPesquisador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarPesquisadorActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnVoltar)
                .addComponent(jLabel1))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetofbd/icones/lupa.png"))); // NOI18N

        jLabel5.setText("*Universidade:");

        txtUniversidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUniversidadeActionPerformed(evt);
            }
        });

        jLabel6.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(81, 81, 81)))
                        .addGap(119, 119, 119))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtIdPesquisador, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtUniversidade, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnAdicionarPesquisador, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(62, 62, 62)
                                            .addComponent(btnEditarPesquisador, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(64, 64, 64)
                                            .addComponent(btnDeletarPesquisador))
                                        .addComponent(txtNomePesquisador, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(139, 139, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdicionarPesquisador, btnDeletarPesquisador, btnEditarPesquisador});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdPesquisador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtUniversidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNomePesquisador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditarPesquisador)
                    .addComponent(btnAdicionarPesquisador)
                    .addComponent(btnDeletarPesquisador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(570, 460));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        voltar();

    }//GEN-LAST:event_btnVoltarActionPerformed

    private void voltar() {
        TelaPrincipal telaprincipal = new TelaPrincipal();
        telaprincipal.setVisible(true);
        this.dispose();
    }

    private void btnAdicionarPesquisadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarPesquisadorActionPerformed
        // Adcionar pesquisador
        try {
            if (validacao()) {
                JOptionPane.showMessageDialog(null, "Preencha todo os campos obrigátorios.");
            } else {
                Pesquisador pesquisador = new Pesquisador();
                pesquisador.setNome_Pesq(txtNomePesquisador.getText());
                pesquisador.setUniversidade(txtUniversidade.getText());
                PesquisadorDAO pesquisadorDAO = new PesquisadorDAO();
                int adicionadao = pesquisadorDAO.create(pesquisador);
                if (adicionadao > 0) {
                    JOptionPane.showMessageDialog(null, "Pesquisador Salva com sucesso.");
                    limparCampos();
                    listarTabelaPesquisador();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível adcionar o Pesquisador.");
                    limparCampos();
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuário já existe");
            limparCampos();
        }

    }//GEN-LAST:event_btnAdicionarPesquisadorActionPerformed

    private void btnEditarPesquisadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPesquisadorActionPerformed
        // TODO add your handling code here:
        if (validacao()) {
            JOptionPane.showMessageDialog(null, "Selecione um item, para poder editá-lo.");
        } else {
            Pesquisador pesquisador = new Pesquisador();
            int id = Integer.parseInt(txtIdPesquisador.getText());
            pesquisador.setCod_Pesq((id));
            pesquisador.setNome_Pesq(txtNomePesquisador.getText());
            pesquisador.setUniversidade(txtUniversidade.getText());
            PesquisadorDAO pesquisadorDAO = new PesquisadorDAO();
            int adicionadao = pesquisadorDAO.update(pesquisador);
            if (adicionadao > 0) {
                JOptionPane.showMessageDialog(null, "Pesquisador editado com sucesso.");
                limparCampos();
                listarTabelaPesquisador();
                btnAdicionarPesquisador.setEnabled(true);
                tblPesquisador.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Pesquisador não editado.");
            }
        }
    }//GEN-LAST:event_btnEditarPesquisadorActionPerformed
    public void setarCampos() {
        int setar = tblPesquisador.getSelectedRow();
        txtIdPesquisador.setText(tblPesquisador.getModel().getValueAt(setar, 0).toString());
        txtNomePesquisador.setText(tblPesquisador.getModel().getValueAt(setar, 1).toString());
        txtUniversidade.setText(tblPesquisador.getModel().getValueAt(setar, 2).toString());
        // A linha abaixo desabilitar o botão adicionar

    }

    private void btnBuscarPesquisadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPesquisadorActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_btnBuscarPesquisadorActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        try {
            listarTabelaPesquisador();
            tblPesquisador.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na transação");
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void listarTabelaPesquisador() {
        Pesquisador pesquisador = new Pesquisador();
        pesquisador.setNome_Pesq(txtBuscar.getText());
        PesquisadorDAO pesquisadorDAO = new PesquisadorDAO();
        resultSet = pesquisadorDAO.read(pesquisador);
        //usando a bibliboteca rs2xml.jar para preencher a tabela
        tblPesquisador.setModel(DbUtils.resultSetToTableModel(resultSet));
    }

    private void tblPesquisadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesquisadorMouseClicked
        // prencher os campos do pesquisador
        setarCampos();
        btnAdicionarPesquisador.setEnabled(false);
        tblPesquisador.setEnabled(false);
    }//GEN-LAST:event_tblPesquisadorMouseClicked

    private void btnDeletarPesquisadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarPesquisadorActionPerformed
        // TODO add your handling code here:
        if ((txtIdPesquisador.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Selecione um item, para poder excluí-lo.");
        } else {
            int remove = 0;
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certza que deseja excluir"
                    + " este cliente?", "Atenção!", JOptionPane.YES_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                Pesquisador pesquisador = new Pesquisador();
                int id = Integer.parseInt(txtIdPesquisador.getText());
                pesquisador.setCod_Pesq((id));
                pesquisador.setNome_Pesq(txtNomePesquisador.getText());
                int universidade = Integer.parseInt(txtIdPesquisador.getText());
                pesquisador.setUniversidade(txtUniversidade.getText());

                PesquisadorDAO pesquisadorDAO = new PesquisadorDAO();
                remove = pesquisadorDAO.delete(pesquisador);
                if (remove > 0) {
                    JOptionPane.showMessageDialog(null, "Pesquisador excluído com sucesso.");
                    limparCampos();
                    listarTabelaPesquisador();
                    btnAdicionarPesquisador.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível exluir o Pesquisador.");
                }
            }
        }
    }//GEN-LAST:event_btnDeletarPesquisadorActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Popular a tabela quando iniciar o form
        listarTabelaPesquisador();
        


    }//GEN-LAST:event_formWindowOpened

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // Halitar e limpar os campos do form
        btnAdicionarPesquisador.setEnabled(true);
        limparCampos();
        tblPesquisador.setEnabled(true);
        txtUniversidade.setEditable(true);

    }//GEN-LAST:event_formMouseClicked

    private void txtUniversidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUniversidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUniversidadeActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Voltar página principal
        this.voltar();
    }//GEN-LAST:event_formWindowClosing

    private void limparCampos() {
        txtIdPesquisador.setText(null);
        txtNomePesquisador.setText(null);
        txtUniversidade.setText(null);
        txtBuscar.setText(null);
    }

    private boolean validacao() {
        return (txtNomePesquisador.getText().isEmpty() || txtUniversidade.getText().isEmpty());
    }

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
            java.util.logging.Logger.getLogger(TelaPesquisador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPesquisador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarPesquisador;
    private javax.swing.JButton btnDeletarPesquisador;
    private javax.swing.JButton btnEditarPesquisador;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPesquisador;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdPesquisador;
    private javax.swing.JTextField txtNomePesquisador;
    private javax.swing.JTextField txtUniversidade;
    // End of variables declaration//GEN-END:variables
}
