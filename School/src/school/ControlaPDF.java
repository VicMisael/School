/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;

import DAO.QuestaoDAO;
import Model.Prova;
import Model.Questao;
import Model.QuestaoDescritiva;
import Model.QuestaoMultiplaEscolha;
import Model.Session;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Misael
 */
public class ControlaPDF {

    public static void criarProva(String nome, Prova p) throws IOException, DocumentException {
        String PATH = "provas/" + Utils.getSalvableTextType(nome) + ".pdf";
        File file = new File(PATH);
        file.getParentFile().mkdirs();
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(PATH));
        document.addTitle(p.getNome());
        document.addAuthor(Session.getInstance().getUsuario().getNome());
        document.open();
        Font chapterFont = FontFactory.getFont(FontFactory.TIMES, 20, Font.BOLD);
        //Inicia o cabeçalho
        Paragraph cabecalho = new Paragraph("Nome da prova:" + nome, chapterFont);
        DottedLineSeparator dottedline = new DottedLineSeparator();
        dottedline.setOffset(-2);
        dottedline.setGap(1f);
        cabecalho.add(dottedline);
        document.add(cabecalho);
        chapterFont = FontFactory.getFont(FontFactory.TIMES, 20, Font.NORMAL);

        //Insere a data no cabeçalho
        Paragraph cabecalho2 = new Paragraph("Data de criação:" + p.getData(), chapterFont);
        cabecalho2.setSpacingBefore(2);
        DottedLineSeparator dottedline2 = new DottedLineSeparator();
        dottedline2.setOffset(-4);
        dottedline2.setGap(0f);
        cabecalho2.add(dottedline2);
        cabecalho2.setSpacingAfter(8f);
        document.add(cabecalho2);
        //Insere o campo de nome no cabeçalho
        cabecalho2 = new Paragraph("Nome:", chapterFont);
        cabecalho2.add(dottedline2);
        document.add(cabecalho2);
        // Inicia a adição das questões
        Font fontQuestoes = FontFactory.getFont(FontFactory.TIMES, 12, Font.NORMAL);
        for (Questao que : new QuestaoDAO().getQuestoesIdAndNumByProvaId(p.getIdProva())) {
            if (new QuestaoDAO().checkIfHasItens(que.getIdQuestao())) {
                QuestaoMultiplaEscolha q = new QuestaoDAO().getQuestaoMultiplaEscolha(que.getIdQuestao());

                String enunciadoText = que.getNumero() + ")" + q.getEnunciado();
                Paragraph enunciado = new Paragraph(enunciadoText, fontQuestoes);
                document.add(enunciado);
                String[] itens = q.getItens();
                Paragraph a = new Paragraph("A) " + itens[0], fontQuestoes);
                document.add(a);
                Paragraph b = new Paragraph("B) " + itens[1], fontQuestoes);
                document.add(b);
                Paragraph c = new Paragraph("C) " + itens[2], fontQuestoes);
                document.add(c);
                Paragraph d = new Paragraph("D) " + itens[3], fontQuestoes);
                document.add(d);
                Paragraph e = new Paragraph("E) " + itens[4], fontQuestoes);
                document.add(e);

            } else {
                QuestaoDescritiva q = new QuestaoDAO().getQuestaoById(que.getIdQuestao());
                String enunciado = que.getNumero() + ")" + q.getEnunciado();
                Paragraph descritiva = new Paragraph(enunciado, fontQuestoes);
                descritiva.setSpacingBefore(3f);
                descritiva.setSpacingAfter(9f);
                document.add(descritiva);
                DottedLineSeparator linha1 = new DottedLineSeparator();
                Paragraph espaco = new Paragraph("");//vou usar pra separar as linhas das descritivas
                espaco.setSpacingAfter(15f);

                linha1.setOffset(-4);
                linha1.setGap(0.2f);
                for (int a = 0; a <= 3; a++) {
                    document.add(espaco);
                    document.add(linha1);
                }
                document.add(espaco);
            }
            Paragraph espaco = new Paragraph("");//vou usar pra separar as linhas das descritivas
            espaco.setSpacingAfter(15f);
            DottedLineSeparator separadorQuestao = new DottedLineSeparator();
            separadorQuestao.setOffset(-4);
            separadorQuestao.setGap(0.5f);
            document.add(separadorQuestao);
            document.add(espaco);

        }
        //Termina a adição de questões

        document.close();
        JOptionPane.showMessageDialog(null, "O arquivo esta "
                + "localizado em " + file.toURI().toString().replace("file:/", ""), "Sistema de provas", JOptionPane.INFORMATION_MESSAGE);
        if (file.exists()) {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            }

        }
    }

    public void abrirManual() throws IOException {
        JOptionPane.showMessageDialog(null,"Not yet implemented");
      

    }
}
