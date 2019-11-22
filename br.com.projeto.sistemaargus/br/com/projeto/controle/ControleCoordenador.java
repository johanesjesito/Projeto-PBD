package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import br.com.projeto.entidade.Aluno;
import br.com.projeto.entidade.Nota;
import br.com.projeto.entidade.Pedagogo;
import br.com.projeto.entidade.TurmaAluno;
import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.DAOException;
import br.com.projeto.exceptions.ValidacaoException;
import br.com.projeto.fachada.Facade;
import br.com.projeto.visao.Mensagem;
import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaEditarPedagogo;
import br.com.projeto.visao.TelaGerarRelatorioPedagogo;
import br.com.projeto.visao.TelaPedagogo;

public class ControleCoordenador {
	
	TelaAreaDeTrabalho areaDeTrabalho;
	DateTimeFormatter formatter;
	List<Usuario> usuarios;
	List<TurmaAluno> turmaAlunos;
	List<AcompPedagogo> acompPedagogos;
	AcompPedagogo acompPedagogo;
	Usuario usuario, usuario2;

	public ControleCoordenador(TelaAreaDeTrabalho areaDeTrabalho) {
		this.areaDeTrabalho = areaDeTrabalho;
		
		areaDeTrabalho.getMntmListaDeAcompanhamento().addActionListener(new ActionListener() {
			
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
			
		areaDeTrabalho.getMntmGerarRelatorioPedagogo().addActionListener(new ActionListener() {
			
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
							turmaAlunos = Facade.getInstance().getboTurmaAluno().buscarListaTurmaAluno(telaGerarRelatorioPedagogo.getTxtTurma().getSelectedItem().toString(), Integer.parseInt(telaGerarRelatorioPedagogo.getTxtAnoLetivo().getText()));
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
									telaGerarRelatorioPedagogo.getTxtPedagogo().getSelectedItem().toString(), "Pedagogo");
							usuario2 = Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(
									telaGerarRelatorioPedagogo.getTxtAluno().getSelectedItem().toString(), "Aluno");
							acompPedagogos = Facade.getInstance().getBoAcompPedagogo().buscarAcompPedagogo(usuario.getId(), usuario2.getId());
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
								cell.addElement(new Phrase( "Pedagogo: " + usuario.getNome(),
										new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK)));
								cell.setColspan(4);
								table2.addCell(cell);	
								cell = new PdfPCell();
								cell.addElement(new Phrase( "Seção: " + acompPedagogo.getSecao(),
										new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK)));
								cell.setColspan(1);
								table2.addCell(cell);	
								cell = new PdfPCell();
								cell.addElement(new Phrase( "Data: " + acompPedagogo.getData(),
										new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK)));
								cell.setColspan(2);
								table2.addCell(cell);
								cell = new PdfPCell();
								cell.addElement(new Phrase( "Situação: " + acompPedagogo.getSituacao(),
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
		
		areaDeTrabalho.getMntmAcompanhamento().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaPedagogo telaPedagogo = new TelaPedagogo();
				areaDeTrabalho.getjAreaTrabalho().add(telaPedagogo);
				telaPedagogo.setVisible(true);

				
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
				telaPedagogo.getTxtPedagogo().setModel(combo);	
				
				telaPedagogo.getTxtTurma().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						final DefaultComboBoxModel combo = new DefaultComboBoxModel();
						
						try {
							turmaAlunos = Facade.getInstance().getboTurmaAluno().buscarListaTurmaAluno(telaPedagogo.getTxtTurma().getSelectedItem().toString(), Integer.parseInt(telaPedagogo.getTxtAnoLetivo().getText()));
						} catch (NumberFormatException | DAOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}						
						for (TurmaAluno turmaAluno : turmaAlunos) {
							combo.addElement(turmaAluno.getAluno().getNome());
						}
						telaPedagogo.getTxtAluno().setModel(combo);		
					}
				});
				
				telaPedagogo.getBtnConfirmar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							AcompPedagogo acompPedagogo = new AcompPedagogo();
							acompPedagogo.setSituacao(telaPedagogo.getTxtSituacao().getSelectedItem().toString());
							acompPedagogo.setSecao(telaPedagogo.getTxtSecao().getText());
							usuario = Facade.getInstance().getBoUsuario()
									.buscarUsuarioPorNomeTipo(telaPedagogo.getTxtAluno().getSelectedItem().toString(), "Aluno");
							acompPedagogo.setAluno((Aluno) usuario);
							acompPedagogo.setRelatorio_Acomp_Aluno(telaPedagogo.getTxtRelatorio1().getText());
							formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							Date date = new Date();
							date = telaPedagogo.getTxtData().getDate();
							acompPedagogo.setData(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
							usuario = Facade.getInstance().getBoUsuario()
									.buscarUsuarioPorNomeTipo(telaPedagogo.getTxtPedagogo().getSelectedItem().toString(), "Pedagogo");
							acompPedagogo.setPedagogo((Pedagogo) usuario);
							
							Facade.getInstance().inserir(acompPedagogo);
							
							Mensagem.exibir("Cadastrado com Sucesso");
						} catch (ValidacaoException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}

					}
				});

			}
		});
	}

}
