package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.projeto.entidade.AcompPedagogo;
import br.com.projeto.entidade.Curriculo;
import br.com.projeto.entidade.Disciplina;
import br.com.projeto.entidade.Nota;
import br.com.projeto.entidade.TurmaAluno;
import br.com.projeto.entidade.TurmaDisciplina;
import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.DAOException;
import br.com.projeto.fachada.Facade;
import br.com.projeto.visao.Mensagem;
import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaEditarPedagogo;
import br.com.projeto.visao.TelaGerarCurriculoPDF;
import br.com.projeto.visao.TelaGerarRelatorioPedagogo;

public class ControleDiretor {

	TelaAreaDeTrabalho areaDeTrabalho;
	List<Usuario> usuarios;
	List<Nota> notas;
	List<TurmaDisciplina> turmaDisciplinas;
	List<TurmaAluno> turmaAlunos;
	List<Curriculo> curriculos;
	List<AcompPedagogo> acompPedagogos;
	Curriculo curriculo;
	Usuario usuario, usuario2;
	Disciplina disciplina;
	TurmaAluno turmaAluno;
	TurmaDisciplina turmaDisciplina;
	AcompPedagogo acompPedagogo;
	double nota1 = 0;
	double nota2 = 0;
	double nota3 = 0;
	double nota4 = 0;
	double mediaparcial = 0;
	double notafinal = 0;
	double mediafinal = 0;

	public ControleDiretor(TelaAreaDeTrabalho areaDeTrabalho) {
		this.areaDeTrabalho = areaDeTrabalho;

		areaDeTrabalho.getMntmGerarRelatorioPedagogoDire().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TelaGerarRelatorioPedagogo telaGerarRelatorioPedagogo = new TelaGerarRelatorioPedagogo();
				areaDeTrabalho.getjAreaTrabalho().add(telaGerarRelatorioPedagogo);
				telaGerarRelatorioPedagogo.setVisible(true);

				final DefaultComboBoxModel combo = new DefaultComboBoxModel();

				try {
					usuarios = Facade.getInstance().getBoUsuario().buscarUsuarioPorTipo("Pedagogo");
					for (Usuario usuario2 : usuarios) {
						combo.addElement(usuario2.getNome());
					}
				} catch (DAOException e2) {
					// TODO Auto-generated catch block
					Mensagem.exibir(e2.getMessage());
				}
				telaGerarRelatorioPedagogo.getTxtPedagogo().setModel(combo);

				telaGerarRelatorioPedagogo.getTxtTurma().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						final DefaultComboBoxModel combo = new DefaultComboBoxModel();

						try {
							turmaAlunos = Facade.getInstance().getboTurmaAluno().buscarListaTurmaAluno(
									telaGerarRelatorioPedagogo.getTxtTurma().getSelectedItem().toString(),
									Integer.parseInt(telaGerarRelatorioPedagogo.getTxtAnoLetivo().getText()));
						} catch (NumberFormatException | DAOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
						for (TurmaAluno turmaAluno : turmaAlunos) {
							combo.addElement(turmaAluno.getAluno().getNome());
						}
						telaGerarRelatorioPedagogo.getTxtAluno().setModel(combo);
					}
				});

				telaGerarRelatorioPedagogo.getBtnGerar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							usuario = Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(
									telaGerarRelatorioPedagogo.getTxtPedagogo().getSelectedItem().toString(),
									"Pedagogo");
							usuario2 = Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(
									telaGerarRelatorioPedagogo.getTxtAluno().getSelectedItem().toString(), "Aluno");
							acompPedagogos = Facade.getInstance().getBoAcompPedagogo()
									.buscarAcompPedagogo(usuario.getId(), usuario2.getId());
						} catch (NumberFormatException | DAOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
						Document document = new Document();
						try {
							PdfWriter.getInstance(document, new FileOutputStream("Documento/PDF_DevMedia2.pdf"));
							document.open();

							PdfPTable table1 = new PdfPTable(9);
							PdfPCell cell;
							cell = new PdfPCell(new Phrase("Relatorios do Acompanhamento do Aluno:",
									new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK)));
							cell.setColspan(9);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table1.addCell(cell);
							cell = new PdfPCell(new Phrase(usuario2.getNome(),
									new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK)));
							cell.setColspan(9);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table1.addCell(cell);
							document.add(table1);
							document.add(new Paragraph(" "));
							for (AcompPedagogo acompPedagogo : acompPedagogos) {
								PdfPTable table2 = new PdfPTable(9);
								cell = new PdfPCell();
								cell.addElement(new Phrase("Pedagogo: " + usuario.getNome(),
										new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK)));
								cell.setColspan(4);
								table2.addCell(cell);
								cell = new PdfPCell();
								cell.addElement(new Phrase("Seção: " + acompPedagogo.getSecao(),
										new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK)));
								cell.setColspan(1);
								table2.addCell(cell);
								cell = new PdfPCell();
								cell.addElement(new Phrase("Data: " + acompPedagogo.getData(),
										new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK)));
								cell.setColspan(2);
								table2.addCell(cell);
								cell = new PdfPCell();
								cell.addElement(new Phrase("Situação: " + acompPedagogo.getSituacao(),
										new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK)));
								cell.setColspan(2);
								table2.addCell(cell);
								document.add(table2);
								document.add(new Paragraph(" "));
								document.add(new Paragraph("       " + acompPedagogo.getRelatorio_Acomp_Aluno()));
								document.add(new Paragraph(" "));
							}

						} catch (DocumentException de) {
							Mensagem.exibir(de.getMessage());
						} catch (IOException ioe) {
							Mensagem.exibir(ioe.getMessage());
						}
						document.close();
						Mensagem.exibir("PDF GERADO");
						try {
							Runtime.getRuntime()
									.exec(new String[] { "cmd.exe", "/c", "start", "Documento/PDF_DevMedia2.pdf" });
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}

					}
				});

				telaGerarRelatorioPedagogo.getBtnGerarProfissional().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							usuario = Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(
									telaGerarRelatorioPedagogo.getTxtPedagogo().getSelectedItem().toString(),
									"Pedagogo");
							acompPedagogos = Facade.getInstance().getBoAcompPedagogo()
									.buscarAcompPedagogo(usuario.getId());
						} catch (NumberFormatException | DAOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
						Document document = new Document();
						try {
							PdfWriter.getInstance(document, new FileOutputStream("Documento/PDF_DevMedia3.pdf"));
							document.open();

							PdfPTable table1 = new PdfPTable(9);
							PdfPCell cell;
							cell = new PdfPCell(new Phrase("Relatorio do Profissonal:",
									new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK)));
							cell.setColspan(9);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table1.addCell(cell);
							cell = new PdfPCell(new Phrase(usuario.getNome(),
									new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK)));
							cell.setColspan(9);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table1.addCell(cell);
							for (AcompPedagogo acompPedagogo : acompPedagogos) {
								cell = new PdfPCell();
								cell.addElement(new Phrase("Aluno: " + acompPedagogo.getAluno().getNome(),
										new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK)));
								cell.setColspan(4);
								table1.addCell(cell);
								cell = new PdfPCell();
								cell.addElement(new Phrase("Seção: " + acompPedagogo.getSecao(),
										new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK)));
								cell.setColspan(1);
								table1.addCell(cell);
								cell = new PdfPCell();
								cell.addElement(new Phrase("Data: " + acompPedagogo.getData(),
										new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK)));
								cell.setColspan(2);
								table1.addCell(cell);
								cell = new PdfPCell();
								cell.addElement(new Phrase("Situação: " + acompPedagogo.getSituacao(),
										new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK)));
								cell.setColspan(2);
								table1.addCell(cell);
							}
							document.add(table1);
						} catch (DocumentException de) {
							Mensagem.exibir(de.getMessage());
						} catch (IOException ioe) {
							Mensagem.exibir(ioe.getMessage());
						}
						document.close();
						Mensagem.exibir("PDF GERADO");
						try {
							Runtime.getRuntime()
									.exec(new String[] { "cmd.exe", "/c", "start", "Documento/PDF_DevMedia3.pdf" });
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
					}
				});
			}
		});
		
		areaDeTrabalho.getMntmListaDeAcompanhamentoDire().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaEditarPedagogo editarPedagogo = new TelaEditarPedagogo();
				areaDeTrabalho.getjAreaTrabalho().add(editarPedagogo);
				editarPedagogo.setVisible(true);

				final DefaultComboBoxModel combo = new DefaultComboBoxModel();

				try {
					usuarios = Facade.getInstance().getBoUsuario().buscarUsuarioPorTipo("Pedagogo");
					for (Usuario usuario2 : usuarios) {
						combo.addElement(usuario2.getNome());
					}
				} catch (DAOException e2) {
					// TODO Auto-generated catch block
					Mensagem.exibir(e2.getMessage());
				}
				editarPedagogo.getTxtPedagogo().setModel(combo);

				editarPedagogo.getTxtTurma().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						final DefaultComboBoxModel combo = new DefaultComboBoxModel();

						try {
							turmaAlunos = Facade.getInstance().getboTurmaAluno().buscarListaTurmaAluno(
									editarPedagogo.getTxtTurma().getSelectedItem().toString(),
									Integer.parseInt(editarPedagogo.getTxtAnoLetivo().getText()));
						} catch (NumberFormatException | DAOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
						for (TurmaAluno turmaAluno : turmaAlunos) {
							combo.addElement(turmaAluno.getAluno().getNome());
						}
						editarPedagogo.getTxtAluno().setModel(combo);
					}
				});
				
				final DefaultTableModel modelo = new DefaultTableModel(
						new Object[][] { { "Aluno", "Data", "Seção", "Situação" } },
						new String[] { "Aluno", "Data", "Seção", "Situação" });
				editarPedagogo.getTxtPedagogo().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						modelo.setRowCount(0);
						final DefaultTableModel modelo = new DefaultTableModel(
								new Object[][] { { "Aluno", "Data", "Seção", "Situação" } },
								new String[] { "Aluno", "Data", "Seção", "Situação" });

						try {
							usuario = Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(
									editarPedagogo.getTxtPedagogo().getSelectedItem().toString(), "Pedagogo");
							acompPedagogos = Facade.getInstance().getBoAcompPedagogo()
									.buscarAcompPedagogo(usuario.getId());
						} catch (DAOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						modelo.setRowCount(0);
						modelo.addRow(new Object[] { "Aluno", "Data", "Seção", "Situação" });

						for (AcompPedagogo acompPedagogo : acompPedagogos) {
							modelo.addRow(new Object[] { acompPedagogo.getAluno().getNome(), acompPedagogo.getData(),
									acompPedagogo.getSecao(), acompPedagogo.getSituacao() });
							editarPedagogo.getTxtAcompanhamento().setModel(modelo);
						}

					}
				});

				editarPedagogo.getTxtAluno().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						modelo.setRowCount(0);
						final DefaultTableModel modelo = new DefaultTableModel(
								new Object[][] { { "Aluno", "Data", "Seção", "Situação" } },
								new String[] { "Aluno", "Data", "Seção", "Situação" });

						try {
							usuario = Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(
									editarPedagogo.getTxtPedagogo().getSelectedItem().toString(), "Pedagogo");
							usuario2 = Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(
									editarPedagogo.getTxtAluno().getSelectedItem().toString(), "Aluno");
							acompPedagogos = Facade.getInstance().getBoAcompPedagogo()
									.buscarAcompPedagogo(usuario.getId(), usuario2.getId());
						} catch (DAOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						modelo.setRowCount(0);
						modelo.addRow(new Object[] { "Aluno", "Data", "Seção", "Situação" });

						for (AcompPedagogo acompPedagogo : acompPedagogos) {
							modelo.addRow(new Object[] { acompPedagogo.getAluno().getNome(), acompPedagogo.getData(),
									acompPedagogo.getSecao(), acompPedagogo.getSituacao() });
							editarPedagogo.getTxtAcompanhamento().setModel(modelo);
						}

					}
				});
			}
		});

		areaDeTrabalho.getMntmGerarCurriculoDoDire().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaGerarCurriculoPDF telaGerarCurriculoPDF = new TelaGerarCurriculoPDF();
				areaDeTrabalho.getjAreaTrabalho().add(telaGerarCurriculoPDF);
				telaGerarCurriculoPDF.setVisible(true);

				telaGerarCurriculoPDF.getTxtTurma().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						final DefaultComboBoxModel combo = new DefaultComboBoxModel();

						try {
							turmaAlunos = Facade.getInstance().getboTurmaAluno().buscarListaTurmaAluno(
									telaGerarCurriculoPDF.getTxtTurma().getSelectedItem().toString(),
									Integer.parseInt(telaGerarCurriculoPDF.getTxtAnoLetivo().getText()));
						} catch (NumberFormatException | DAOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
						for (TurmaAluno turmaAluno : turmaAlunos) {
							combo.addElement(turmaAluno.getAluno().getNome());
						}
						telaGerarCurriculoPDF.getTxtAluno().setModel(combo);
					}
				});

				telaGerarCurriculoPDF.getBtnGerar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							usuario = Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(
									telaGerarCurriculoPDF.getTxtAluno().getSelectedItem().toString(), "Aluno");
							turmaAluno = Facade.getInstance().getboTurmaAluno().buscarTurma(usuario.getId(),
									Integer.parseInt(telaGerarCurriculoPDF.getTxtAnoLetivo().getText()));
							notas = Facade.getInstance().getBoNota().buscarNota(turmaAluno.getId(),
									Integer.parseInt(telaGerarCurriculoPDF.getTxtAnoLetivo().getText()));
							curriculo = Facade.getInstance().getBoCurriculo().buscarCurriculo(turmaAluno.getId(),
									Integer.parseInt(telaGerarCurriculoPDF.getTxtAnoLetivo().getText()));
						} catch (NumberFormatException | DAOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
						Document document = new Document();
						try {
							PdfWriter.getInstance(document, new FileOutputStream("Documento/PDF_DevMedia.pdf"));
							document.open();

							PdfPTable table = new PdfPTable(9);
							PdfPCell cell = new PdfPCell(new Phrase("Aluno: " + usuario.getNome(),
									new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK)));
							cell.setColspan(6);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table.addCell(cell);
							cell = new PdfPCell();
							cell.addElement(new Phrase(
									"Turma: " + telaGerarCurriculoPDF.getTxtTurma().getSelectedItem().toString(),
									new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK)));
							cell.setColspan(7);
							table.addCell(cell);
							cell = new PdfPCell();
							cell.addElement(new Phrase("Disciplina",
									new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE)));
							cell.setColspan(2);
							table.addCell(cell);
							cell = new PdfPCell();
							cell.addElement(new Phrase("Nota 1",
									new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE)));
							table.addCell(cell);
							cell = new PdfPCell();
							cell.addElement(new Phrase("Nota 2",
									new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE)));
							table.addCell(cell);
							cell = new PdfPCell();
							cell.addElement(new Phrase("Nota 3",
									new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE)));
							table.addCell(cell);
							cell = new PdfPCell();
							cell.addElement(new Phrase("Nota 4 (Bim)",
									new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE)));
							table.addCell(cell);
							cell = new PdfPCell();
							cell.addElement(new Phrase("Media Parcial",
									new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE)));
							table.addCell(cell);
							cell = new PdfPCell();
							cell.addElement(new Phrase("Nota Final",
									new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE)));
							table.addCell(cell);
							cell = new PdfPCell();
							cell.addElement(new Phrase("Media Geral",
									new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE)));
							table.addCell(cell);
							for (Nota nota : notas) {
								cell = new PdfPCell();
								cell.addElement(new Phrase(nota.getTurmaDisciplina().getDisciplina().getNome()));
								cell.setColspan(2);
								table.addCell(cell);
								cell = new PdfPCell();
								DecimalFormat fmt = new DecimalFormat("#0.0");
								String nota1 = fmt.format(nota.getNota1());
								cell.addElement(new Phrase(nota1));
								table.addCell(cell);
								cell = new PdfPCell();
								String nota2 = fmt.format(nota.getNota2());
								cell.addElement(new Phrase(nota2));
								table.addCell(cell);
								cell = new PdfPCell();
								String nota3 = fmt.format(nota.getNota3());
								cell.addElement(new Phrase(nota3));
								table.addCell(cell);
								if (nota.getBimestral_trimestral().equals("Bimestral")) {
									cell = new PdfPCell();
									String nota4 = fmt.format(nota.getNota4());
									cell.addElement(new Phrase(nota4));
									table.addCell(cell);
								} else {
									cell = new PdfPCell();
									String nota4 = "";
									cell.addElement(new Phrase(nota4));
									table.addCell(cell);
								}
								cell = new PdfPCell();
								String mediaParcial = fmt.format(nota.getMedia_parcial());
								cell.addElement(new Phrase(mediaParcial));
								table.addCell(cell);
								if (nota.getMedia_parcial() < 7 && nota.getMedia_parcial() >= 3) {
									cell = new PdfPCell();
									String notafinal = fmt.format(nota.getNotaFinal());
									cell.addElement(new Phrase(notafinal));
									table.addCell(cell);
								} else {
									cell = new PdfPCell();
									cell.addElement(new Phrase(""));
									table.addCell(cell);
								}
								cell = new PdfPCell();
								String mediaGeral = fmt.format(nota.getMedia_geral());
								cell.addElement(new Phrase(mediaGeral));
								table.addCell(cell);
							}
							cell = new PdfPCell();
							cell.addElement(new Phrase("Ano Letivo: " + curriculo.getAno_letivo(),
									new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE)));
							cell.setColspan(5);
							table.addCell(cell);
							cell = new PdfPCell();
							cell.addElement(new Phrase("Situação:",
									new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE)));
							cell.setColspan(2);
							table.addCell(cell);
							cell = new PdfPCell();
							cell.addElement(new Phrase(curriculo.getSituacao(),
									new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.RED)));
							cell.setColspan(2);
							table.addCell(cell);

							document.add(table);
						} catch (DocumentException de) {
							Mensagem.exibir(de.getMessage());
						} catch (IOException ioe) {
							Mensagem.exibir(ioe.getMessage());
						}
						document.close();
						Mensagem.exibir("PDF GERADO");
						try {
							Runtime.getRuntime()
									.exec(new String[] { "cmd.exe", "/c", "start", "Documento/PDF_DevMedia.pdf" });
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
					}
				});
			}
		});

	}

}
