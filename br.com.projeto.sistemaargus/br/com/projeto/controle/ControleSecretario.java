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

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.projeto.entidade.Aluno;
import br.com.projeto.entidade.Contato;
import br.com.projeto.entidade.Curriculo;
import br.com.projeto.entidade.Disciplina;
import br.com.projeto.entidade.Endereco;
import br.com.projeto.entidade.Nota;
import br.com.projeto.entidade.Pedagogo;
import br.com.projeto.entidade.Professor;
import br.com.projeto.entidade.Responsavel;
import br.com.projeto.entidade.TurmaAluno;
import br.com.projeto.entidade.TurmaDisciplina;
import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.DAOException;
import br.com.projeto.exceptions.ValidacaoException;
import br.com.projeto.fachada.Facade;
import br.com.projeto.visao.Mensagem;
import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaCadastro;
import br.com.projeto.visao.TelaCadastroAluno;
import br.com.projeto.visao.TelaGerarCurriculoPDF;

public class ControleSecretario {
	
	TelaAreaDeTrabalho areaDeTrabalho;
	DateTimeFormatter formatter;
	List<Usuario> usuarios;
	List<Nota> notas;
	List<TurmaDisciplina> turmaDisciplinas;
	List<TurmaAluno> turmaAlunos;
	List<Curriculo> curriculos;
	Curriculo curriculo;
	Usuario usuario;
	Disciplina disciplina;
	TurmaAluno turmaAluno;
	TurmaDisciplina turmaDisciplina;
	double nota1 = 0;
	double nota2 = 0;
	double nota3 = 0;
	double nota4 = 0;
	double mediaparcial = 0;
	double notafinal = 0;
	double mediafinal = 0;

	public ControleSecretario(TelaAreaDeTrabalho areaDeTrabalho) {
		this.areaDeTrabalho = areaDeTrabalho;
				
		areaDeTrabalho.getMntmCadastro().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TelaCadastro telaCadastro = new TelaCadastro();
				areaDeTrabalho.getjAreaTrabalho().add(telaCadastro);
				telaCadastro.setVisible(true);
								
				telaCadastro.getBtnConfirmar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
													
							if(telaCadastro.getRdbtnResponsavel().isSelected()==true) {
								Responsavel responsavel = new Responsavel();
								responsavel.setCpf(telaCadastro.getTxtCpf().getText());
								responsavel.setNome(telaCadastro.getTxtNome().getText());
								responsavel.setNaturalidade(telaCadastro.getTxtNaturalidade().getText());				
								formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								Date date = new Date();
								date = telaCadastro.getTxtDataNascimento().getDate();
								responsavel.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
								responsavel.setTipo("Responsavel");								
								
								responsavel.setResetSenha(false);

								if (!telaCadastro.getTxtCidade().getText().equals("")
										&& !telaCadastro.getTxtEstado().getText().equals("")
										&& !telaCadastro.getTxtRua().getText().equals("")
										&& !telaCadastro.getTxtNumero().getText().equals("")
										&& !telaCadastro.getTxtCep().getText().equals("")) {

									Endereco endereco = new Endereco();
									endereco.setCep(telaCadastro.getTxtCep().getText());
									endereco.setCidade(telaCadastro.getTxtCidade().getText());
									endereco.setEstado(telaCadastro.getTxtEstado().getText());
									endereco.setNumero(Integer.parseInt(telaCadastro.getTxtNumero().getText()));
									endereco.setRua(telaCadastro.getTxtRua().getText());
																		
									if (!telaCadastro.getTxtCelular().getText().equals("")
											|| !telaCadastro.getTxtTelefone().getText().equals("")) {
										
										Contato contato = new Contato();
										
										contato.setCelular(telaCadastro.getTxtCelular().getText());
										contato.setTelefone(telaCadastro.getTxtTelefone().getText());

										Facade.getInstance().inserir(responsavel);																		
										endereco.setUsuario(responsavel);
										contato.setUsuario(responsavel);

										Facade.getInstance().inserir(endereco);	
										Facade.getInstance().inserir(contato);								
									}
								}	
									
							}
							else if(telaCadastro.getRdbtnPedagogo().isSelected()==true) {
								Pedagogo pedagogo = new Pedagogo();
								pedagogo.setCpf(telaCadastro.getTxtCpf().getText());
								pedagogo.setNome(telaCadastro.getTxtNome().getText());
								pedagogo.setNaturalidade(telaCadastro.getTxtNaturalidade().getText());				
								formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								Date date = new Date();
								date = telaCadastro.getTxtDataNascimento().getDate();
								pedagogo.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
								pedagogo.setTipo("Pedagogo");								

								pedagogo.setResetSenha(false);
								
								if (!telaCadastro.getTxtCidade().getText().equals("")
										&& !telaCadastro.getTxtEstado().getText().equals("")
										&& !telaCadastro.getTxtRua().getText().equals("")
										&& !telaCadastro.getTxtNumero().getText().equals("")
										&& !telaCadastro.getTxtCep().getText().equals("")) {

									Endereco endereco = new Endereco();
									endereco.setCep(telaCadastro.getTxtCep().getText());
									endereco.setCidade(telaCadastro.getTxtCidade().getText());
									endereco.setEstado(telaCadastro.getTxtEstado().getText());
									endereco.setNumero(Integer.parseInt(telaCadastro.getTxtNumero().getText()));
									endereco.setRua(telaCadastro.getTxtRua().getText());
																		
									if (!telaCadastro.getTxtCelular().getText().equals("")
											|| !telaCadastro.getTxtTelefone().getText().equals("")) {
										
										Contato contato = new Contato();
										
										contato.setCelular(telaCadastro.getTxtCelular().getText());
										contato.setTelefone(telaCadastro.getTxtTelefone().getText());

										Facade.getInstance().inserir(pedagogo);																			
										contato.setUsuario(pedagogo);
										endereco.setUsuario(pedagogo);

										Facade.getInstance().inserir(endereco);	
										Facade.getInstance().inserir(contato);								
									}
								}
							}
							else if(telaCadastro.getRdbtnProfessor().isSelected()==true) {
								Professor professor = new Professor();
								professor.setCpf(telaCadastro.getTxtCpf().getText());
								professor.setNome(telaCadastro.getTxtNome().getText());
								professor.setNaturalidade(telaCadastro.getTxtNaturalidade().getText());				
								formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								Date date = new Date();
								date = telaCadastro.getTxtDataNascimento().getDate();
								professor.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
								professor.setTipo("Professor");								
								
								professor.setResetSenha(false);

								if (!telaCadastro.getTxtCidade().getText().equals("")
										&& !telaCadastro.getTxtEstado().getText().equals("")
										&& !telaCadastro.getTxtRua().getText().equals("")
										&& !telaCadastro.getTxtNumero().getText().equals("")
										&& !telaCadastro.getTxtCep().getText().equals("")) {

									Endereco endereco = new Endereco();
									endereco.setCep(telaCadastro.getTxtCep().getText());
									endereco.setCidade(telaCadastro.getTxtCidade().getText());
									endereco.setEstado(telaCadastro.getTxtEstado().getText());
									endereco.setNumero(Integer.parseInt(telaCadastro.getTxtNumero().getText()));
									endereco.setRua(telaCadastro.getTxtRua().getText());
																		
									if (!telaCadastro.getTxtCelular().getText().equals("")
											|| !telaCadastro.getTxtTelefone().getText().equals("")) {
										
										Contato contato = new Contato();
										
										contato.setCelular(telaCadastro.getTxtCelular().getText());
										contato.setTelefone(telaCadastro.getTxtTelefone().getText());

										Facade.getInstance().inserir(professor);
										contato.setUsuario(professor);
										endereco.setUsuario(professor);

										Facade.getInstance().inserir(endereco);	
										Facade.getInstance().inserir(contato);								
									}
								}

							}
							
							Mensagem.exibir("Cadastrado com Sucesso");
						} catch (ValidacaoException e) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e.getMessage());
						}
					}
				});
				
			}
		});
		
		areaDeTrabalho.getMntmCadastrarAluno().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				TelaCadastroAluno telaCadastrarAluno = new TelaCadastroAluno();
				areaDeTrabalho.getjAreaTrabalho().add(telaCadastrarAluno);
				telaCadastrarAluno.setVisible(true);

				final DefaultComboBoxModel combo = new DefaultComboBoxModel();

				try {
					usuarios = Facade.getInstance().getBoUsuario().buscarUsuarioPorTipo("Responsavel");
					for (Usuario usuario2 : usuarios) {
						combo.addElement(usuario2.getNome());
					}		
				} catch (DAOException e2) {
					// TODO Auto-generated catch block
					Mensagem.exibir(e2.getMessage());
				}
				telaCadastrarAluno.getTxtResponsavel().setModel(combo);	
								
				telaCadastrarAluno.getBtnConfirmar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						try {
							Aluno aluno = new Aluno();
							aluno.setCpf(telaCadastrarAluno.getTxtCpf().getText());
							aluno.setNome(telaCadastrarAluno.getTxtNome().getText());
							aluno.setNaturalidade(telaCadastrarAluno.getTxtNaturalidade().getText());
							formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							Date date = new Date();
							date = telaCadastrarAluno.getTxtDataNascimento().getDate();
							aluno.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
							aluno.setPai(telaCadastrarAluno.getTxtPai().getText());
							aluno.setMae(telaCadastrarAluno.getTxtMae().getText());

							usuario = Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(telaCadastrarAluno.getTxtResponsavel().getSelectedItem().toString(), "Responsavel");
							
							aluno.setResponsavel((Responsavel) usuario);
							
							if (!telaCadastrarAluno.getTxtCidade().getText().equals("")
									&& !telaCadastrarAluno.getTxtEstado().getText().equals("")
									&& !telaCadastrarAluno.getTxtRua().getText().equals("")
									&& !telaCadastrarAluno.getTxtNumero().getText().equals("")
									&& !telaCadastrarAluno.getTxtCep().getText().equals("")) {

								Endereco endereco = new Endereco();
								endereco.setCep(telaCadastrarAluno.getTxtCep().getText());
								endereco.setCidade(telaCadastrarAluno.getTxtCidade().getText());
								endereco.setEstado(telaCadastrarAluno.getTxtEstado().getText());
								endereco.setNumero(Integer.parseInt(telaCadastrarAluno.getTxtNumero().getText()));
								endereco.setRua(telaCadastrarAluno.getTxtRua().getText());

								if (!telaCadastrarAluno.getTxtCelular().getText().equals("")
										|| !telaCadastrarAluno.getTxtTelefone().getText().equals("")) {

									Contato contato = new Contato();

									contato.setCelular(telaCadastrarAluno.getTxtCelular().getText());
									contato.setTelefone(telaCadastrarAluno.getTxtTelefone().getText());

									aluno.setTipo("Aluno");
									Facade.getInstance().inserir(aluno);
									endereco.setUsuario(aluno);
									contato.setUsuario(aluno);

									Facade.getInstance().inserir(endereco);
									Facade.getInstance().inserir(contato);
								}

							}

							Mensagem.exibir("Cadastrado com Sucesso");
						} catch (ValidacaoException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
					}
				});
				
			}
		});
		
		areaDeTrabalho.getMntmGerarCurriculoDoSecre().addActionListener(new ActionListener() {
			
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
							turmaAlunos = Facade.getInstance().getboTurmaAluno().buscarListaTurmaAluno(telaGerarCurriculoPDF.getTxtTurma().getSelectedItem().toString(), Integer.parseInt(telaGerarCurriculoPDF.getTxtAnoLetivo().getText()));
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
							turmaAluno = Facade.getInstance().getboTurmaAluno().buscarTurma(usuario.getId(), Integer.parseInt(telaGerarCurriculoPDF.getTxtAnoLetivo().getText()));
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
