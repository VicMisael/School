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
 * @author Misael
 */
public class AlterarQuestaoMultiplaEscolha extends javax.swing.JInternalFrame {
//A0BEF18FEB

    /**
     * Creates new form CadastroQuestao
     *
     * @param questaoid
     */
    QuestaoMultiplaEscolha a;

    public AlterarQuestaoMultiplaEscolha(int questaoid) {
        initComponents();
        prepararCombos();
        a = new QuestaoDAO().getQuestaoMultiplaEscolha(questaoid);
        prepararCampos();

    }

    private void prepararCampos() {

        EnunciadoArea.setText(a.getEnunciado());
        String[] itens = a.getItens();
        AField.setText(itens[0]);
        BField.setText(itens[1]);
        CField.setText(itens[2]);
        DField.setText(itens[3]);
        EField.setText(itens[4]);
        char item = a.getGabarito();
        setSelectedButton(item);

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
        e = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DField = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        BField = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        CField = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        AField = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        EField = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        cadastrarQuestaoMultiplaButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        AButton = new javax.swing.JRadioButton();
        BButton = new javax.swing.JRadioButton();
        CButton = new javax.swing.JRadioButton();
        DButton = new javax.swing.JRadioButton();
        EButton = new javax.swing.JRadioButton();
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

        jLabel5.setText("A)");

        jLabel6.setText("B)");

        jLabel7.setText("C)");

        jLabel8.setText("D)");

        jLabel9.setText("E)");

        DField.setColumns(20);
        DField.setLineWrap(true);
        DField.setRows(3);
        jScrollPane3.setViewportView(DField);

        BField.setColumns(20);
        BField.setRows(3);
        jScrollPane4.setViewportView(BField);

        CField.setColumns(20);
        CField.setRows(3);
        jScrollPane5.setViewportView(CField);

        AField.setColumns(20);
        AField.setRows(3);
        jScrollPane6.setViewportView(AField);

        EField.setColumns(20);
        EField.setRows(3);
        jScrollPane7.setViewportView(EField);

        jLabel10.setText("E)");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cadastrarQuestaoMultiplaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        cadastrarQuestaoMultiplaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarQuestaoMultiplaButtonActionPerformed(evt);
            }
        });

        jLabel12.setText("Item Correto");

        itemCorreto.add(AButton);
        AButton.setText("A");

        itemCorreto.add(BButton);
        BButton.setText("B");

        itemCorreto.add(CButton);
        CButton.setText("C");

        itemCorreto.add(DButton);
        DButton.setText("D");

        itemCorreto.add(EButton);
        EButton.setText("E");

        javax.swing.GroupLayout eLayout = new javax.swing.GroupLayout(e);
        e.setLayout(eLayout);
        eLayout.setHorizontalGroup(
            eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, eLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(eLayout.createSequentialGroup()
                        .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(eLayout.createSequentialGroup()
                                .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane7)
                                    .addComponent(jScrollPane5)
                                    .addGroup(eLayout.createSequentialGroup()
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(32, 32, 32)
                                .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3)
                                    .addGroup(eLayout.createSequentialGroup()
                                        .addComponent(AButton)
                                        .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(eLayout.createSequentialGroup()
                                                .addGap(99, 99, 99)
                                                .addComponent(jLabel12)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(eLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(BButton)
                                                .addGap(51, 51, 51)
                                                .addComponent(CButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(DButton)
                                                .addGap(53, 53, 53)
                                                .addComponent(EButton))))))
                            .addGroup(eLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cadastrarQuestaoMultiplaButton)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(27, 27, 27))))
        );
        eLayout.setVerticalGroup(
            eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(eLayout.createSequentialGroup()
                        .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jLabel8)))
                    .addGroup(eLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(cadastrarQuestaoMultiplaButton)
                        .addGap(72, 72, 72)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(eLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(24, 24, 24)
                                .addGroup(eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(AButton)
                                    .addComponent(BButton)
                                    .addComponent(CButton)
                                    .addComponent(DButton)
                                    .addComponent(EButton))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(139, 139, 139))
        );

        jTabbedPane2.addTab("Multipla Escolha", e);

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
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(ComboNivel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(48, 48, 48)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 67, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 60, 850, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboDiscItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboDiscItemStateChanged
        // TODO add your handling code here:
        prepararComboAssunto();
    }//GEN-LAST:event_ComboDiscItemStateChanged

    private void cadastrarQuestaoMultiplaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarQuestaoMultiplaButtonActionPerformed
        // TODO add your handling code here:
        boolean areFieldsEmpty = (AField.getText().trim().isEmpty()
                || BField.getText().trim().isEmpty()
                || CField.getText().trim().isEmpty()
                || DField.getText().trim().isEmpty()
                || EField.getText().trim().isEmpty());
        boolean isButtonNotSelected = ((getSelectedButton() == -1));
        boolean isEnunciadoEmpty = EnunciadoArea.getText().trim().isEmpty();

        if (!(areFieldsEmpty || isButtonNotSelected || isEnunciadoEmpty)) {
            String itens[] = {AField.getText(), BField.getText(),
                CField.getText(), DField.getText(),
                EField.getText()};
            a.setEnunciado(EnunciadoArea.getText());
            a.setDificuldade(((Dificuldade) ComboNivel.getSelectedItem()).getId());
            a.setIdAssunto(((Assunto) ComboAssunto.getSelectedItem()).getIdAssunto());
            a.setGabarito(getSelectedButtonChar());
            //System.out.println(getSelectedButtonChar());
            a.setItens(itens);
            new QuestaoDAO().alterarQuestaoMultiplaEscolha(a);
        } else {
            String erro = "Não é possivel cadastrar com campos vazios \n"
                    + " e/ou nenhum gabarito selecionado";
            JOptionPane.showMessageDialog(rootPane, erro, title, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cadastrarQuestaoMultiplaButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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

    private void setSelectedButton(char item) {
        if (item == 'a') {
            AButton.setSelected(true);
            return;
        }
        if (item == 'b') {
            BButton.setSelected(true);
            return;
        }
        if (item == 'c') {
            CButton.setSelected(true);
            return;
        }
        if (item == 'd') {
            DButton.setSelected(true);
            return;
        }
        if (item == 'e') {
            EButton.setSelected(true);
            return;
        }
        JOptionPane.showMessageDialog(rootPane, "Erro ao colocar gabarito",
                title, JOptionPane.ERROR_MESSAGE);
    }

    private int getSelectedButton() {
        int i = -1;
        if (AButton.isSelected()) {
            i = 1;
        }
        if (BButton.isSelected()) {
            i = 2;
        }
        if (CButton.isSelected()) {
            i = 3;
        }
        if (DButton.isSelected()) {
            i = 4;
        }
        if (EButton.isSelected()) {
            i = 5;
        }
        return i;
    }

    private char getSelectedButtonChar() {
        char item = Character.MIN_VALUE;
        switch (getSelectedButton()) {
            case 1: {
                item = 'a';
                break;
            }
            case 2: {
                item = 'b';
                break;
            }
            case 3: {
                item = 'c';
                break;
            }
            case 4: {
                item = 'd';
                break;
            }
            case 5: {
                item = 'e';
                break;
            }

        }
        return item;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AButton;
    private javax.swing.JTextArea AField;
    private javax.swing.JRadioButton BButton;
    private javax.swing.JTextArea BField;
    private javax.swing.JRadioButton CButton;
    private javax.swing.JTextArea CField;
    private javax.swing.JComboBox<Assunto> ComboAssunto;
    private javax.swing.JComboBox<Disciplina> ComboDisc;
    private javax.swing.JComboBox<Dificuldade> ComboNivel;
    private javax.swing.JRadioButton DButton;
    private javax.swing.JTextArea DField;
    private javax.swing.JRadioButton EButton;
    private javax.swing.JTextArea EField;
    private javax.swing.JTextArea EnunciadoArea;
    private javax.swing.ButtonGroup GrupoTipo;
    private javax.swing.JButton cadastrarQuestaoMultiplaButton;
    private javax.swing.JPanel e;
    private javax.swing.ButtonGroup itemCorreto;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}