/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Alterar;

import View.Cadastrar.*;
import DAO.AssuntoDAO;
import DAO.DificuldadeDAO;
import DAO.DisciplinaDAO;
import DAO.ProfessorDisciplinaDAO;
import DAO.QuestaoDAO;
import Model.Assunto;
import Model.Dificuldade;
import Model.Disciplina;
import Model.Questao;
import Model.QuestaoDescritiva;
import Model.QuestaoMultiplaEscolha;
import Model.Session;
import View.Cadastrar.*;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author adria
 */
public class AlterarQuestao extends javax.swing.JInternalFrame {
//A0BEF18FEB

    /**
     * Creates new form CadastroQuestao
     *
     * @param questaoId
     */
    QuestaoDescritiva a;

    public AlterarQuestao(int questaoId) {
        initComponents();
        prepararCombos();
        a = new QuestaoDAO().getQuestaoById(questaoId);
        prepararCampos();

    }

    private void prepararCampos() {

        TAresposta.setText(a.getResposta());
        EnunciadoArea.setText(a.getEnunciado());
        setSelectedCombos();

    }

    private void setSelectedCombos() {
        int i;
        for (i = 0; i <= ComboDisc.getItemCount(); i++) {
            Disciplina disc = ComboDisc.getItemAt(i);
            if (disc.getId() == new DisciplinaDAO().getDisciplinaIdByAssuntoId(a.getIdAssunto())) {
                break;
            }
        }
        ComboDisc.setSelectedIndex(i);
        for (i = 0; i <= ComboAssunto.getItemCount(); i++) {
            Assunto as = ComboAssunto.getItemAt(i);
            if (as.getIdAssunto() == a.getIdAssunto()) {
                break;
            }
        }
        ComboAssunto.setSelectedIndex(i);
        for (i = 0; i <= ComboNivel.getItemCount(); i++) {
            Dificuldade dif = ComboNivel.getItemAt(i);
            if (dif.getId() == a.getDificuldade()) {
                break;
            }
        }
        ComboNivel.setSelectedIndex(i);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSpinner1 = new javax.swing.JSpinner();
        GrupoTipo = new javax.swing.ButtonGroup();
        itemCorreto = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboAssunto = new javax.swing.JComboBox<>();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EnunciadoArea = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        Descricao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TAresposta = new javax.swing.JTextArea();
        cadastrarDescritivaButton = new javax.swing.JButton();
        ComboDisc = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        ComboNivel = new javax.swing.JComboBox<>();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(840, 573));
        setMinimumSize(new java.awt.Dimension(840, 573));
        setPreferredSize(new java.awt.Dimension(840, 573));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 119, 36));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Alteração de Questão");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel1)
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 850, 64);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Disciplina :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Assunto :");

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        EnunciadoArea.setColumns(20);
        EnunciadoArea.setLineWrap(true);
        EnunciadoArea.setRows(5);
        jScrollPane1.setViewportView(EnunciadoArea);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Enunciado", jPanel5);

        Descricao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Descricao.setText("Resposta Descritiva");
        Descricao.setToolTipText("Ativar \" Resposta Descritiva \"");
        Descricao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Descricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DescricaoMouseClicked(evt);
            }
        });

        TAresposta.setColumns(20);
        TAresposta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TAresposta.setLineWrap(true);
        TAresposta.setRows(5);
        jScrollPane2.setViewportView(TAresposta);

        cadastrarDescritivaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        cadastrarDescritivaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarDescritivaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(Descricao)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cadastrarDescritivaButton))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Descricao)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrarDescritivaButton)
                .addGap(20, 20, 20))
        );

        jTabbedPane2.addTab("Descritiva", jPanel6);

        ComboDisc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboDiscItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Nivel");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboDisc, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboNivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboDisc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(ComboAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ComboNivel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(48, 48, 48)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 65, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 60, 850, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prepararCombos() {
        prepararComboDisciplina();
        prepararComboAssunto();
        prepararComboNivel();

    }

    private void prepararComboDisciplina() {
        int id = Session.getInstance().getUsuario().getIdUsuario();

        for (Disciplina disc : new ProfessorDisciplinaDAO().ListarDisciplinaDeProfessor(id)) {
            ComboDisc.addItem(disc);

        }

    }

    private void prepararComboAssunto() {
        ComboAssunto.removeAllItems();
        Disciplina disc = (Disciplina) ComboDisc.getSelectedItem();
        List<Assunto> assuntos = new AssuntoDAO().listarAssuntoByIdDisciplina(disc.getId());
        for (Assunto as : assuntos) {
            ComboAssunto.addItem(as);
        }
    }

    private void prepararComboNivel() {

        List<Dificuldade> dificuldades = new DificuldadeDAO().ListarDificuldades();
        for (Dificuldade dif : dificuldades) {
            ComboNivel.addItem(dif);

        }

    }


    private void ComboDiscItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboDiscItemStateChanged
        // TODO add your handling code here:
        prepararComboAssunto();
    }//GEN-LAST:event_ComboDiscItemStateChanged

    private void cadastrarDescritivaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarDescritivaButtonActionPerformed
        // TODO add your handling code here:
        boolean isEmpty = (EnunciadoArea.getText().trim().isEmpty() || TAresposta.getText().trim().isEmpty());

        //        System.out.println(isEmpty);
        //        System.out.println(hasOnlyWhiteSpace);
        if (!isEmpty && ComboAssunto.getItemCount() > 0) {
            String enunciado = EnunciadoArea.getText();
            String resposta = TAresposta.getText();
            QuestaoDescritiva quest = new QuestaoDescritiva();
            quest.setIdQuestao(a.getIdQuestao());
            quest.setEnunciado(enunciado);
            quest.setResposta(resposta);
            quest.setIdAssunto(((Assunto) ComboAssunto.getSelectedItem()).getIdAssunto());
            quest.setDificuldade(((Dificuldade) ComboNivel.getSelectedItem()).getId());
            new QuestaoDAO().atualizarQuestaoDescritiva(quest);

        } else {
            String erro = "Não é possivel atualizar com campos vazios";
            JOptionPane.showMessageDialog(rootPane, erro, title, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cadastrarDescritivaButtonActionPerformed

    private void DescricaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DescricaoMouseClicked
        // TODO add your handling code here:
        //limpando item selecionado

        //desativando o textArea e dando o foco
        TAresposta.setEnabled(true);
        TAresposta.requestFocus();

        Descricao.setForeground(Color.black);
    }//GEN-LAST:event_DescricaoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Assunto> ComboAssunto;
    private javax.swing.JComboBox<Disciplina> ComboDisc;
    private javax.swing.JComboBox<Dificuldade> ComboNivel;
    private javax.swing.JLabel Descricao;
    private javax.swing.JTextArea EnunciadoArea;
    private javax.swing.ButtonGroup GrupoTipo;
    private javax.swing.JTextArea TAresposta;
    private javax.swing.JButton cadastrarDescritivaButton;
    private javax.swing.ButtonGroup itemCorreto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
