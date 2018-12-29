/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Consultar;

import DAO.ProfessorDisciplinaDAO;
import DAO.ProvaDAO;
import DAO.QuestaoDAO;
import Model.Disciplina;
import Model.Prova;
import Model.QuestaoDescritiva;
import Model.QuestaoMultiplaEscolha;
import Model.Session;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import school.ControlaPDF;

/**
 *
 * @author adria
 */
public class ConsultaProva extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaProva
     */
    public ConsultaProva() {
        initComponents();
        botoesMostrar.add(mostrarProvasDeProfessor);
        botoesMostrar.add(mostrarProvasDasDisciplinasLecionadas);
        mostrarProvasDeProfessor.setSelected(true);
        Mostrar();
    }

    private int getSelectedButton() {
        int i = -1;
        if (mostrarProvasDeProfessor.isSelected()) {
            i = 1;
        } else if (mostrarProvasDasDisciplinasLecionadas.isSelected()) {
            i = 2;
        }
        return i;
    }

    private void Mostrar() {
        int selected = getSelectedButton();
        switch (selected) {
            case 1: {
                List<Prova> provas
                        = new ProvaDAO().selectProvasByIdProfessor(Session.getInstance().getUsuario().getIdUsuario());
                listaTable(provas);
                break;
            }
            case 2: {
                List<Disciplina> disciplinas
                        = new ProfessorDisciplinaDAO().ListarDisciplinaDeProfessor(Session.getInstance().getUsuario().getIdUsuario());
                int[] disciplinaIds = new int[disciplinas.size()];
                int a = 0;
                for (Disciplina d : disciplinas) {
                    disciplinaIds[a] = d.getId();
                    a++;
                }
                List<Integer> idProf = new ArrayList<>();//array sem nenhuma repetição
                List<Integer> idProfSorted = new ArrayList<>();
                for (int idDisc : disciplinaIds) {
                    idProf.addAll(new ProfessorDisciplinaDAO().getProfessorIdListByDisciplinaEnsinada(idDisc));
                    //Vai pegar o idProf por disciplina

                }
                for (int id : idProf) {
                    // System.out.println(id);
                    if (!idProfSorted.contains(id)) {
                        idProfSorted.add(id);
                    }
                }
                List<Prova> pruebas = new ArrayList<>();

                for (int id : idProfSorted) {

                    pruebas.addAll(new ProvaDAO().selectProvasByIdProfessor(id));
                }
                listaTable(pruebas);
                break;
            }
            case -1:
                JOptionPane.showMessageDialog(rootPane, "Selecione um botão ", title, JOptionPane.ERROR_MESSAGE);
                break;
            default:
                break;
        }

    }

    private void listaTable() {
        listaTable(null);
    }

    private void listaTable(List<Prova> provas) {
        DefaultTableModel model = (DefaultTableModel) TabelaProvas.getModel();
        model.setNumRows(0);
        for (Prova a : provas) {
            model.addRow(new Object[]{
                a.getIdProva(),
                a.getNome(),
                a.getData(),});

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botoesMostrar = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaProvas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        buttonImprimir = new javax.swing.JButton();
        mostrarProvasDeProfessor = new javax.swing.JRadioButton();
        mostrarProvasDasDisciplinasLecionadas = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(490, 430));
        setMinimumSize(new java.awt.Dimension(490, 430));
        setPreferredSize(new java.awt.Dimension(490, 430));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 119, 36));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consulta de Provas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel1)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 512, 89);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        TabelaProvas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Data"
            }
        ));
        jScrollPane2.setViewportView(TabelaProvas);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Questao32px.png"))); // NOI18N
        jButton1.setToolTipText("Ver a prova");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Impressora32px.png"))); // NOI18N
        buttonImprimir.setToolTipText("Gerar PDF");
        buttonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImprimirActionPerformed(evt);
            }
        });

        mostrarProvasDeProfessor.setText("Criadas por você");
        mostrarProvasDeProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarProvasDeProfessorActionPerformed(evt);
            }
        });

        mostrarProvasDasDisciplinasLecionadas.setText("Disciplinas que Ensina");
        mostrarProvasDasDisciplinasLecionadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarProvasDasDisciplinasLecionadasActionPerformed(evt);
            }
        });

        jLabel2.setText("Mostrar provas:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mostrarProvasDeProfessor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mostrarProvasDasDisciplinasLecionadas)))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mostrarProvasDeProfessor)
                    .addComponent(mostrarProvasDasDisciplinasLecionadas)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(buttonImprimir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 90, 490, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarProvasDasDisciplinasLecionadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarProvasDasDisciplinasLecionadasActionPerformed
        // TODO add your handling code here:
        Mostrar();
    }//GEN-LAST:event_mostrarProvasDasDisciplinasLecionadasActionPerformed

    private void mostrarProvasDeProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarProvasDeProfessorActionPerformed
        // TODO add your handling code here:
        Mostrar();
    }//GEN-LAST:event_mostrarProvasDeProfessorActionPerformed

    private void buttonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImprimirActionPerformed
        // TODO add your handling code here
        DefaultTableModel model = (DefaultTableModel) TabelaProvas.getModel();
        int valor = (int) model.getValueAt(TabelaProvas.getSelectedRow(), 0);
        Prova p=new ProvaDAO().getProva(valor);
        try {
            ControlaPDF.criarProva(p.getNome(),p);
        } catch (IOException ex) {
            Logger.getLogger(ConsultaProva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ConsultaProva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_buttonImprimirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) TabelaProvas.getModel();
        int valor = (int) model.getValueAt(TabelaProvas.getSelectedRow(), 0);
        ExibirProva eb = new ExibirProva(valor);
        Principal.Principal.Desktop.add(eb);
        eb.show();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaProvas;
    private javax.swing.ButtonGroup botoesMostrar;
    private javax.swing.JButton buttonImprimir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton mostrarProvasDasDisciplinasLecionadas;
    private javax.swing.JRadioButton mostrarProvasDeProfessor;
    // End of variables declaration//GEN-END:variables
}
