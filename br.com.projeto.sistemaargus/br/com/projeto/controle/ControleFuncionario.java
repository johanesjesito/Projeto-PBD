package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.entidade.Aluno;
import br.com.projeto.entidade.Curriculo;
import br.com.projeto.entidade.Disciplina;
import br.com.projeto.entidade.Nota;
import br.com.projeto.entidade.Professor;
import br.com.projeto.entidade.Turma;
import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.DAOException;
import br.com.projeto.exceptions.ValidacaoException;
import br.com.projeto.fachada.Facade;
import br.com.projeto.visao.Mensagem;
import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaCadastrarCurriculo;
import br.com.projeto.visao.TelaCadastrarDiscProfTurma;
import br.com.projeto.visao.TelaCadastrarDisciplina;
import br.com.projeto.visao.TelaCadastrarNota;

public class ControleFuncionario {
	
	TelaAreaDeTrabalho areaDeTrabalho;
	List<Disciplina> disciplinas;
	List<Usuario> usuarios;
	List<Nota> notas;
	List<Turma> turmas;
	Usuario usuario;
	Disciplina disciplina;
	double nota1 = 0;
	double nota2 = 0;
	double nota3 = 0;
	double nota4 = 0;
	double mediaparcial = 0;
	double notafinal = 0;
	double	mediafinal = 0;

	public ControleFuncionario(TelaAreaDeTrabalho areaDeTrabalho) {
		this.areaDeTrabalho = areaDeTrabalho;
		
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
						Turma turma = new Turma();					
						usuario = Facade.getInstance().getBoUsuario()
								.buscarUsuarioPorNome(telaCadastrarDiscProfTurma.getTxtProfessor().getSelectedItem().toString());
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
	
				final DefaultComboBoxModel combo = new DefaultComboBoxModel();
				
				try {
					usuarios = Facade.getInstance().getBoUsuario().buscarUsuarioPorTipo("Aluno");
				} catch (DAOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (Usuario usuario : usuarios) {
					combo.addElement(usuario.getNome());					
				}		
				
				telaCadastrarNota.getTxtAluno().setModel(combo);
				
				telaCadastrarNota.getTxtTurma().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						final DefaultComboBoxModel combo2 = new DefaultComboBoxModel();

						try {
							turmas = Facade.getInstance().getBoTurma()
									.buscarListaTurma(telaCadastrarNota.getTxtTurma().getSelectedItem().toString());
						} catch (DAOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						for (Turma turma : turmas) {
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
							if (telaCadastrarNota.getRdbtnBimestral().isSelected() == true) {
								nota.setBimestral_trimestral("Bimestral");
							} else {
								nota.setBimestral_trimestral("Trimestral");
							}
							nota.setAno_letivo(Integer.parseInt(telaCadastrarNota.getTxtAnoLetivo().getText()));
							usuario = Facade.getInstance().getBoUsuario()
									.buscarUsuarioPorNome(telaCadastrarNota.getTxtAluno().getSelectedItem().toString());
							nota.setAluno((Aluno) usuario);
							disciplina = Facade.getInstance().getBoDisciplina()
									.buscarDisciplina(telaCadastrarNota.getTxtDisciplina().getSelectedItem().toString());
							nota.setTurma(telaCadastrarNota.getTxtTurma().getSelectedItem().toString());
							nota.setDisciplina(disciplina);
							Facade.getInstance().inserir(nota);
							Mensagem.exibir("Cadastrado com Sucesso");
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
							DecimalFormat fmt = new DecimalFormat("#0.00");
							String mediaparcial2 = fmt.format(mediaparcial);
							DecimalFormat fmt2 = new DecimalFormat("#0.00");
							String mediafinal2 = fmt2.format(mediafinal);
							telaCadastrarNota.getTxtMediaParcial().setText(mediaparcial2);
							telaCadastrarNota.getTxtMediaFinal().setText(mediafinal2);
						} else {
							nota1 = Double.parseDouble(telaCadastrarNota.getTxtNota1().getText());
							mediaparcial = (nota1 + nota2 + nota3) / 3;
							mediafinal = mediaparcial;
							DecimalFormat fmt = new DecimalFormat("#0.00");
							String mediaparcial2 = fmt.format(mediaparcial);
							DecimalFormat fmt2 = new DecimalFormat("#0.00");
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
						DecimalFormat fmt = new DecimalFormat("#0.00");
						String mediaparcial2 = fmt.format(mediaparcial);
						DecimalFormat fmt2 = new DecimalFormat("#0.00");
						String mediafinal2 = fmt2.format(mediafinal);
						telaCadastrarNota.getTxtMediaParcial().setText(mediaparcial2);
						telaCadastrarNota.getTxtMediaFinal().setText(mediafinal2);
						} else {
							nota2=Double.parseDouble(telaCadastrarNota.getTxtNota2().getText());
							mediaparcial=(nota1+nota2+nota3)/3;
							mediafinal=mediaparcial;
							DecimalFormat fmt = new DecimalFormat("#0.00");
							String mediaparcial2 = fmt.format(mediaparcial);
							DecimalFormat fmt2 = new DecimalFormat("#0.00");
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
						DecimalFormat fmt = new DecimalFormat("#0.00");
						String mediaparcial2 = fmt.format(mediaparcial);
						DecimalFormat fmt2 = new DecimalFormat("#0.00");
						String mediafinal2 = fmt2.format(mediafinal);
						telaCadastrarNota.getTxtMediaParcial().setText(mediaparcial2);
						telaCadastrarNota.getTxtMediaFinal().setText(mediafinal2);
						} else {
							nota3=Double.parseDouble(telaCadastrarNota.getTxtNota3().getText());
							mediaparcial=(nota1+nota2+nota3)/3;
							mediafinal=mediaparcial;
							DecimalFormat fmt = new DecimalFormat("#0.00");
							String mediaparcial2 = fmt.format(mediaparcial);
							DecimalFormat fmt2 = new DecimalFormat("#0.00");
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
						DecimalFormat fmt = new DecimalFormat("#0.00");
						String mediaparcial2 = fmt.format(mediaparcial);
						DecimalFormat fmt2 = new DecimalFormat("#0.00");
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
						DecimalFormat fmt = new DecimalFormat("#0.00");
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
				
				final DefaultComboBoxModel combo = new DefaultComboBoxModel();
				
				try {
					usuarios = Facade.getInstance().getBoUsuario().buscarUsuarioPorTipo("Aluno");
				} catch (DAOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (Usuario usuario : usuarios) {
					combo.addElement(usuario.getNome());					
				}
				
				telaCadastrarCurriculo.getTxtAluno().setModel(combo);
				
				final DefaultTableModel modelo = new DefaultTableModel(new Object[][] {{"Disciplina", "Media Parcial", "Media Geral"}}, new String[] {"Disciplina", "Media Parcial", "Media Geral"});
				telaCadastrarCurriculo.getTblNotaDisciplina().setModel(modelo);	
				
				telaCadastrarCurriculo.getTxtAnoLetivo().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							usuario = Facade.getInstance().getBoUsuario().buscarUsuarioPorNome(
									telaCadastrarCurriculo.getTxtAluno().getSelectedItem().toString());

							notas = Facade.getInstance().getBoNota().buscarNota(usuario.getId(),
									Integer.parseInt(telaCadastrarCurriculo.getTxtAnoLetivo().getText()));

							modelo.setRowCount(0);
							modelo.addRow(new Object[] { "Disciplina", "Media Parcial", "Media Geral" });

							for (Nota nota : notas) {

								if (telaCadastrarCurriculo.getTxtTurma().getSelectedItem().toString()
										.equals(nota.getTurma())) {
									DecimalFormat fmt = new DecimalFormat("#0.00");
									String notafinal = fmt.format(nota.getMedia_geral());
									String mediaparcial = fmt.format(nota.getMedia_parcial());
									modelo.addRow(
											new Object[] { nota.getDisciplina().getNome(), mediaparcial, notafinal });
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
				
				telaCadastrarCurriculo.getTxtTurma().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							usuario = Facade.getInstance().getBoUsuario().buscarUsuarioPorNome(
									telaCadastrarCurriculo.getTxtAluno().getSelectedItem().toString());

							notas = Facade.getInstance().getBoNota().buscarNota(usuario.getId(),
									Integer.parseInt(telaCadastrarCurriculo.getTxtAnoLetivo().getText()));

							modelo.setRowCount(0);
							modelo.addRow(new Object[] { "Disciplina", "Media Parcial", "Media Geral" });

							for (Nota nota : notas) {

								if (telaCadastrarCurriculo.getTxtTurma().getSelectedItem().toString()
										.equals(nota.getTurma())) {
									DecimalFormat fmt = new DecimalFormat("#0.00");
									String notafinal = fmt.format(nota.getMedia_geral());
									String mediaparcial = fmt.format(nota.getMedia_parcial());
									modelo.addRow(
											new Object[] { nota.getDisciplina().getNome(), mediaparcial, notafinal });
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
									.buscarUsuarioPorNome(telaCadastrarCurriculo.getTxtAluno().getSelectedItem().toString());
							curriculo.setAluno((Aluno) usuario);
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
