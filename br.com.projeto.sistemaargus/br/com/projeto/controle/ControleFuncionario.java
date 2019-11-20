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
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.projeto.entidade.Aluno;
import br.com.projeto.entidade.Curriculo;
import br.com.projeto.entidade.Disciplina;
import br.com.projeto.entidade.Nota;
import br.com.projeto.entidade.Professor;
import br.com.projeto.entidade.TurmaAluno;
import br.com.projeto.entidade.TurmaDisciplina;
import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.DAOException;
import br.com.projeto.exceptions.ValidacaoException;
import br.com.projeto.fachada.Facade;
import br.com.projeto.visao.Mensagem;
import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaCadastrarAlunoTurma;
import br.com.projeto.visao.TelaCadastrarCurriculo;
import br.com.projeto.visao.TelaCadastrarDiscProfTurma;
import br.com.projeto.visao.TelaCadastrarDisciplina;
import br.com.projeto.visao.TelaCadastrarNota;
import br.com.projeto.visao.TelaGerarCurriculoPDF;

public class ControleFuncionario {
	
	TelaAreaDeTrabalho areaDeTrabalho;
	List<Disciplina> disciplinas;
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

	public ControleFuncionario(TelaAreaDeTrabalho areaDeTrabalho) {
		this.areaDeTrabalho = areaDeTrabalho;
		
		areaDeTrabalho.getMntmCadastrarAlunosNa().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				TelaCadastrarAlunoTurma alunoTurma = new TelaCadastrarAlunoTurma();
				areaDeTrabalho.getjAreaTrabalho().add(alunoTurma);
				alunoTurma.setVisible(true);
				
				final DefaultComboBoxModel combo = new DefaultComboBoxModel();						

				try {
					usuarios = Facade.getInstance().getBoUsuario().buscarUsuarioPorTipo("Aluno");
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (Usuario usuario : usuarios) {
					combo.addElement(usuario.getNome());
				}
				alunoTurma.getTxtAluno().setModel(combo);
				
				alunoTurma.getBtnConfirmar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							TurmaAluno turmaAluno = new TurmaAluno();
							usuario = Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(
									alunoTurma.getTxtAluno().getSelectedItem().toString(), "Aluno");
							turmaAluno.setAluno((Aluno) usuario);
							turmaAluno.setAno_letivo(Integer.parseInt(alunoTurma.getTxtAnoLetivo().getText()));
							turmaAluno.setTurma(alunoTurma.getTxtTurma().getSelectedItem().toString());
							Facade.getInstance().inserir(turmaAluno);
							Mensagem.exibir("Cadastrado com Sucesso!");
						} catch (ValidacaoException e) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e.getMessage());
						}
					}
				});
				
			}
		});
		
		areaDeTrabalho.getMntmGerarCurriculoDo().addActionListener(new ActionListener() {
			
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
		
		areaDeTrabalho.getMntmCadastrarDisciplinasNa().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaCadastrarDiscProfTurma telaCadastrarDiscProfTurma = new TelaCadastrarDiscProfTurma();
				areaDeTrabalho.getjAreaTrabalho().add(telaCadastrarDiscProfTurma);
				telaCadastrarDiscProfTurma.setVisible(true);
				
				
				final DefaultComboBoxModel combo = new DefaultComboBoxModel();
				final DefaultComboBoxModel combo2 = new DefaultComboBoxModel();
				
				try {
					usuarios = Facade.getInstance().getBoUsuario().buscarUsuarioPorTipo("Professor");
				} catch (DAOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (Usuario usuario : usuarios) {
					combo.addElement(usuario.getNome());					
				}	
				
				try {
					disciplinas = Facade.getInstance().getBoDisciplina().buscarALL();
				} catch (DAOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (Disciplina disciplina : disciplinas) {
					combo2.addElement(disciplina.getNome());					
				}		
		
				telaCadastrarDiscProfTurma.getTxtProfessor().setModel(combo);
				telaCadastrarDiscProfTurma.getTxtDisciplina().setModel(combo2);
				
				telaCadastrarDiscProfTurma.getBtnConfirmar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
						TurmaDisciplina turma = new TurmaDisciplina();					
						usuario = Facade.getInstance().getBoUsuario()
								.buscarUsuarioPorNomeTipo(telaCadastrarDiscProfTurma.getTxtProfessor().getSelectedItem().toString(), "Professor");
						turma.setProfessor((Professor) usuario);
						disciplina = Facade.getInstance().getBoDisciplina().buscarDisciplina(telaCadastrarDiscProfTurma.getTxtDisciplina().getSelectedItem().toString());
						turma.setDisciplina(disciplina);
						turma.setTurma(telaCadastrarDiscProfTurma.getTxtTurma().getSelectedItem().toString());
						Facade.getInstance().inserir(turma);
						Mensagem.exibir("Cadastrado com sucesso");
						} catch (ValidacaoException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
					}
				});
			}
		});
		
		areaDeTrabalho.getMntmCadastrarNotas().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaCadastrarNota telaCadastrarNota = new TelaCadastrarNota();
				areaDeTrabalho.getjAreaTrabalho().add(telaCadastrarNota);
				telaCadastrarNota.setVisible(true);
	
				telaCadastrarNota.getTxtTurma().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						final DefaultComboBoxModel combo = new DefaultComboBoxModel();
						
						try {
							turmaAlunos = Facade.getInstance().getboTurmaAluno().buscarListaTurmaAluno(telaCadastrarNota.getTxtTurma().getSelectedItem().toString(), Integer.parseInt(telaCadastrarNota.getTxtAnoLetivo().getText()));
						} catch (NumberFormatException | DAOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}						
						for (TurmaAluno turmaAluno : turmaAlunos) {
							combo.addElement(turmaAluno.getAluno().getNome());
						}
						telaCadastrarNota.getTxtAluno().setModel(combo);		
					}
				});
								
				telaCadastrarNota.getTxtTurma().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						final DefaultComboBoxModel combo2 = new DefaultComboBoxModel();

						try {
							turmaDisciplinas = Facade.getInstance().getboTurmaDisciplina()
									.buscarListaTurma(telaCadastrarNota.getTxtTurma().getSelectedItem().toString());
						} catch (DAOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						for (TurmaDisciplina turma : turmaDisciplinas) {
							combo2.addElement(turma.getDisciplina().getNome());
						}
						
						telaCadastrarNota.getTxtDisciplina().setModel(combo2);
					}
				});
				
				telaCadastrarNota.getBtnConfirmar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							Nota nota = new Nota();
							nota.setMedia_parcial(mediaparcial);
							nota.setMedia_geral(mediafinal);
							nota.setNota1(nota1);
							nota.setNota2(nota2);
							nota.setNota3(nota3);
							if (telaCadastrarNota.getRdbtnBimestral().isSelected() == true) {
								nota.setNota4(nota4);						
							} 
							if (telaCadastrarNota.getRdbtnBimestral().isSelected() == true) {
								nota.setBimestral_trimestral("Bimestral");
							} else {
								nota.setBimestral_trimestral("Trimestral");
							}
							nota.setAno_letivo(Integer.parseInt(telaCadastrarNota.getTxtAnoLetivo().getText()));
							usuario = Facade.getInstance().getBoUsuario()
									.buscarUsuarioPorNomeTipo(telaCadastrarNota.getTxtAluno().getSelectedItem().toString(), "Aluno");
							turmaAluno = Facade.getInstance().getboTurmaAluno().buscarTurma(usuario.getId(), Integer.parseInt(telaCadastrarNota.getTxtAnoLetivo().getText()));
							disciplina = Facade.getInstance().getBoDisciplina().buscarDisciplina(telaCadastrarNota.getTxtDisciplina().getSelectedItem().toString());
							turmaDisciplina = Facade.getInstance().getboTurmaDisciplina().buscarTurma(telaCadastrarNota.getTxtTurma().getSelectedItem().toString(), disciplina.getId());
							nota.setTurmaaluno(turmaAluno);
							nota.setTurmaDisciplina(turmaDisciplina);
							if(mediaparcial<7 && mediaparcial>=3) {
								nota.setNotaFinal(notafinal);
							}
							if(mediaparcial>=7) {
								nota.setSituacao("Aprovado por Media");
							}
							else if(mediaparcial<7 && mediafinal>=5) {
								nota.setSituacao("Aprovado");
							}
							else {
								nota.setSituacao("Reprovado");								
							}
							Facade.getInstance().inserir(nota);
							Mensagem.exibir("Cadastrado com Sucesso");
							nota1=0;
							nota2=0;
							nota3=0;
							nota4=0;
							notafinal=0;
							mediaparcial=0;
							mediafinal=0;
							telaCadastrarNota.getTxtNota1().setText("");
							telaCadastrarNota.getTxtNota2().setText("");
							telaCadastrarNota.getTxtNota3().setText("");
							telaCadastrarNota.getTxtNota4().setText("");
							telaCadastrarNota.getTxtNotaFinal().setText("");
							telaCadastrarNota.getTxtMediaParcial().setText("");
							telaCadastrarNota.getTxtMediaFinal().setText("");
							telaCadastrarNota.getTxtNotaFinal().setEditable(false);
						} catch (ValidacaoException e) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e.getMessage());
						}
					}
				});
				
				telaCadastrarNota.getRdbtnBimestral().addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						telaCadastrarNota.getLblNota4().setVisible(true);
						telaCadastrarNota.getTxtNota4().setVisible(true);
					}
				});
				telaCadastrarNota.getRdbtnTrimestral().addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						telaCadastrarNota.getLblNota4().setVisible(false);
						telaCadastrarNota.getTxtNota4().setVisible(false);
					}
				});
				
				telaCadastrarNota.getTxtNota1().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (telaCadastrarNota.getRdbtnBimestral().isSelected() == true) {
							nota1 = Double.parseDouble(telaCadastrarNota.getTxtNota1().getText());
							mediaparcial = (nota1 + nota2 + nota3 + nota4) / 4;
							mediafinal = mediaparcial;
							DecimalFormat fmt = new DecimalFormat("#0.0");
							String mediaparcial2 = fmt.format(mediaparcial);
							DecimalFormat fmt2 = new DecimalFormat("#0.0");
							String mediafinal2 = fmt2.format(mediafinal);
							telaCadastrarNota.getTxtMediaParcial().setText(mediaparcial2);
							telaCadastrarNota.getTxtMediaFinal().setText(mediafinal2);
						} else {
							nota1 = Double.parseDouble(telaCadastrarNota.getTxtNota1().getText());
							mediaparcial = (nota1 + nota2 + nota3) / 3;
							mediafinal = mediaparcial;
							DecimalFormat fmt = new DecimalFormat("#0.0");
							String mediaparcial2 = fmt.format(mediaparcial);
							DecimalFormat fmt2 = new DecimalFormat("#0.0");
							String mediafinal2 = fmt2.format(mediafinal);
							telaCadastrarNota.getTxtMediaParcial().setText(mediaparcial2);
							telaCadastrarNota.getTxtMediaFinal().setText(mediafinal2);
						}
						if (mediaparcial >= 3 && mediaparcial < 7) {
							telaCadastrarNota.getTxtNotaFinal().setEditable(true);
						} else {
							telaCadastrarNota.getTxtNotaFinal().setEditable(false);
						}
					}
				});	
				telaCadastrarNota.getTxtNota2().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(telaCadastrarNota.getRdbtnBimestral().isSelected()==true) {
						nota2=Double.parseDouble(telaCadastrarNota.getTxtNota2().getText());
						mediaparcial=(nota1+nota2+nota3+nota4)/4;
						mediafinal=mediaparcial;
						DecimalFormat fmt = new DecimalFormat("#0.0");
						String mediaparcial2 = fmt.format(mediaparcial);
						DecimalFormat fmt2 = new DecimalFormat("#0.0");
						String mediafinal2 = fmt2.format(mediafinal);
						telaCadastrarNota.getTxtMediaParcial().setText(mediaparcial2);
						telaCadastrarNota.getTxtMediaFinal().setText(mediafinal2);
						} else {
							nota2=Double.parseDouble(telaCadastrarNota.getTxtNota2().getText());
							mediaparcial=(nota1+nota2+nota3)/3;
							mediafinal=mediaparcial;
							DecimalFormat fmt = new DecimalFormat("#0.0");
							String mediaparcial2 = fmt.format(mediaparcial);
							DecimalFormat fmt2 = new DecimalFormat("#0.0");
							String mediafinal2 = fmt2.format(mediafinal);
							telaCadastrarNota.getTxtMediaParcial().setText(mediaparcial2);
							telaCadastrarNota.getTxtMediaFinal().setText(mediafinal2);
						}
						if(mediaparcial>=3 && mediaparcial<7) {
							telaCadastrarNota.getTxtNotaFinal().setEditable(true);
						} else {
							telaCadastrarNota.getTxtNotaFinal().setEditable(false);							
						}
					}
				});	
				telaCadastrarNota.getTxtNota3().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(telaCadastrarNota.getRdbtnBimestral().isSelected()==true) {
						nota3=Double.parseDouble(telaCadastrarNota.getTxtNota3().getText());
						mediaparcial=(nota1+nota2+nota3+nota4)/4;
						mediafinal=mediaparcial;
						DecimalFormat fmt = new DecimalFormat("#0.0");
						String mediaparcial2 = fmt.format(mediaparcial);
						DecimalFormat fmt2 = new DecimalFormat("#0.0");
						String mediafinal2 = fmt2.format(mediafinal);
						telaCadastrarNota.getTxtMediaParcial().setText(mediaparcial2);
						telaCadastrarNota.getTxtMediaFinal().setText(mediafinal2);
						} else {
							nota3=Double.parseDouble(telaCadastrarNota.getTxtNota3().getText());
							mediaparcial=(nota1+nota2+nota3)/3;
							mediafinal=mediaparcial;
							DecimalFormat fmt = new DecimalFormat("#0.0");
							String mediaparcial2 = fmt.format(mediaparcial);
							DecimalFormat fmt2 = new DecimalFormat("#0.0");
							String mediafinal2 = fmt2.format(mediafinal);
							telaCadastrarNota.getTxtMediaParcial().setText(mediaparcial2);
							telaCadastrarNota.getTxtMediaFinal().setText(mediafinal2);
						}
						if(mediaparcial>=3 && mediaparcial<7) {
							telaCadastrarNota.getTxtNotaFinal().setEditable(true);
						} else {
							telaCadastrarNota.getTxtNotaFinal().setEditable(false);							
						}
					}
				});	
				telaCadastrarNota.getTxtNota4().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(telaCadastrarNota.getRdbtnBimestral().isSelected()==true) {
						nota4=Double.parseDouble(telaCadastrarNota.getTxtNota4().getText());
						mediaparcial=(nota1+nota2+nota3+nota4)/4;
						mediafinal=mediaparcial;
						DecimalFormat fmt = new DecimalFormat("#0.0");
						String mediaparcial2 = fmt.format(mediaparcial);
						DecimalFormat fmt2 = new DecimalFormat("#0.0");
						String mediafinal2 = fmt2.format(mediafinal);
						telaCadastrarNota.getTxtMediaParcial().setText(mediaparcial2);
						telaCadastrarNota.getTxtMediaFinal().setText(mediafinal2);
						} 
						if(mediaparcial>=3 && mediaparcial<7) {
							telaCadastrarNota.getTxtNotaFinal().setEditable(true);
						} else {
							telaCadastrarNota.getTxtNotaFinal().setEditable(false);	
						}
					}
				});
				
				telaCadastrarNota.getTxtNotaFinal().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						notafinal=Double.parseDouble(telaCadastrarNota.getTxtNotaFinal().getText());
						mediafinal = (mediaparcial + notafinal) / 2;
						DecimalFormat fmt = new DecimalFormat("#0.0");
						String mediafinal2 = fmt.format(mediafinal);
						telaCadastrarNota.getTxtMediaFinal().setText(mediafinal2);
					}
				});
			}
		});
		
		areaDeTrabalho.getMntmCadastrarDisciplina().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaCadastrarDisciplina telaCadastrarDisciplina = new TelaCadastrarDisciplina();
				areaDeTrabalho.getjAreaTrabalho().add(telaCadastrarDisciplina);
				telaCadastrarDisciplina.setVisible(true);
												
				telaCadastrarDisciplina.getBtnConfirmar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							Disciplina disciplina = new Disciplina();

							disciplina.setNome(telaCadastrarDisciplina.getTxtNome().getText());
							disciplina.setCargaHoraria(
									Integer.parseInt(telaCadastrarDisciplina.getTxtCargaHoraria().getText()));
							disciplina.setStatus_disciplina(telaCadastrarDisciplina.getTxtStatus().getText());

							Facade.getInstance().inserir(disciplina);
							Mensagem.exibir("Disciplina Cadastrado com Sucesso");
						} catch (ValidacaoException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
					}
				});
			}
		});
		
		areaDeTrabalho.getMntmCadastrarCurriculoAluno().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaCadastrarCurriculo telaCadastrarCurriculo = new TelaCadastrarCurriculo();
				areaDeTrabalho.getjAreaTrabalho().add(telaCadastrarCurriculo);
				telaCadastrarCurriculo.setVisible(true);
				
				telaCadastrarCurriculo.getTxtTurma().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						final DefaultComboBoxModel combo = new DefaultComboBoxModel();
						
						try {
							turmaAlunos = Facade.getInstance().getboTurmaAluno().buscarListaTurmaAluno(telaCadastrarCurriculo.getTxtTurma().getSelectedItem().toString(), Integer.parseInt(telaCadastrarCurriculo.getTxtAnoLetivo().getText()));
						} catch (NumberFormatException | DAOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}						
						for (TurmaAluno turmaAluno : turmaAlunos) {
							combo.addElement(turmaAluno.getAluno().getNome());
						}
						telaCadastrarCurriculo.getTxtAluno().setModel(combo);		
					}
				});
												
				final DefaultTableModel modelo = new DefaultTableModel(new Object[][] {{"Disciplina", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Media Parcial", "Nota Final", "Media Geral", "Situação"}}, new String[] {"Disciplina", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Media Parcial", "Nota Final", "Media Geral", "Situação"});
				telaCadastrarCurriculo.getTblNotaDisciplina().setModel(modelo);	

				telaCadastrarCurriculo.getTxtTurma().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						final DefaultComboBoxModel combo = new DefaultComboBoxModel();
						
						try {
							turmaAlunos = Facade.getInstance().getboTurmaAluno().buscarListaTurmaAluno(telaCadastrarCurriculo.getTxtTurma().getSelectedItem().toString(), Integer.parseInt(telaCadastrarCurriculo.getTxtAnoLetivo().getText()));
						} catch (NumberFormatException | DAOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}						
						for (TurmaAluno turmaAluno : turmaAlunos) {
							combo.addElement(turmaAluno.getAluno().getNome());
						}
						telaCadastrarCurriculo.getTxtAluno().setModel(combo);		
					}
				});
				
				telaCadastrarCurriculo.getTxtAluno().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						telaCadastrarCurriculo.getTxtSituacao().setText("Aprovado");
						try {
							usuario = Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(
									telaCadastrarCurriculo.getTxtAluno().getSelectedItem().toString(), "Aluno");

							turmaAluno = Facade.getInstance().getboTurmaAluno().buscarTurma(usuario.getId(), Integer.parseInt(telaCadastrarCurriculo.getTxtAnoLetivo().getText()));
							
							notas = Facade.getInstance().getBoNota().buscarNota(turmaAluno.getId(),
									Integer.parseInt(telaCadastrarCurriculo.getTxtAnoLetivo().getText()));

							modelo.setRowCount(0);
							modelo.addRow(new Object[] { "Disciplina", "Nota 1", "Nota 2", "Nota 3", "Nota 4", "Media Parcial", "Nota Final", "Media Geral", "Situação" });

							for (Nota nota : notas) {

								if (telaCadastrarCurriculo.getTxtTurma().getSelectedItem().toString()
										.equals(nota.getTurmaaluno().getTurma())) {
									DecimalFormat fmt = new DecimalFormat("#0.0");
									String nota1 = fmt.format(nota.getNota1());
									String nota2 = fmt.format(nota.getNota2());
									String nota3 = fmt.format(nota.getNota3());
									String nota4 = fmt.format(nota.getNota4());
									String mediaparcial = fmt.format(nota.getMedia_parcial());
									String notafinal;
									if(nota.getMedia_parcial()<7 && nota.getMedia_parcial()>=3) {
										notafinal = fmt.format(nota.getNotaFinal());
									}
									else {
										notafinal = "";
									}
									String mediafinal = fmt.format(nota.getMedia_geral());
									if(nota.getBimestral_trimestral().equals("Bimestral"))
										modelo.addRow(
											new Object[] { nota.getTurmaDisciplina().getDisciplina().getNome(), nota1,nota2,nota3,nota4, mediaparcial, notafinal, mediafinal,nota.getSituacao()});
									else
										modelo.addRow(
												new Object[] { nota.getTurmaDisciplina().getDisciplina().getNome(), nota1,nota2,nota3,"", mediaparcial, notafinal, mediafinal,nota.getSituacao()});										
									telaCadastrarCurriculo.getTblNotaDisciplina().setModel(modelo);
									if (nota.getMedia_geral() < 5) {
										telaCadastrarCurriculo.getTxtSituacao().setText("Reprovado");
									}
								}

							}
							if (!telaCadastrarCurriculo.getTxtSituacao().getText().equals("Reprovado")) {
								telaCadastrarCurriculo.getTxtSituacao().setText("Aprovado");
							}

						} catch (DAOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
					}
				});
					
				telaCadastrarCurriculo.getBtnCadastrar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							Curriculo curriculo = new Curriculo();		
							usuario = Facade.getInstance().getBoUsuario()
								.buscarUsuarioPorNomeTipo(telaCadastrarCurriculo.getTxtAluno().getSelectedItem().toString(), "Aluno");
							turmaAluno = Facade.getInstance().getboTurmaAluno().buscarTurma(usuario.getId(), Integer.parseInt(telaCadastrarCurriculo.getTxtAnoLetivo().getText()));
							curriculo.setTurmaAluno(turmaAluno);
							curriculo.setAno_letivo(Integer.parseInt(telaCadastrarCurriculo.getTxtAnoLetivo().getText()));
							curriculo.setSituacao(telaCadastrarCurriculo.getTxtSituacao().getText());
							curriculo.setTurma(telaCadastrarCurriculo.getTxtTurma().getSelectedItem().toString());
							
							Facade.getInstance().inserir(curriculo);
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
