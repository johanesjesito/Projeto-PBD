package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import br.com.projeto.entidade.Aluno;
import br.com.projeto.entidade.Contato;
import br.com.projeto.entidade.Endereco;
import br.com.projeto.entidade.Pedagogo;
import br.com.projeto.entidade.Professor;
import br.com.projeto.entidade.Responsavel;
import br.com.projeto.exceptions.ValidacaoException;
import br.com.projeto.fachada.Facade;
import br.com.projeto.visao.Mensagem;
import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaCadastro;
import br.com.projeto.visao.TelaCadastroAluno;

public class ControleSecretario {
	
	TelaAreaDeTrabalho areaDeTrabalho;
	DateTimeFormatter formatter;

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

										responsavel.setTipo("Responsavel");								
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

										pedagogo.setTipo("Pedagogo");								
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

										professor.setTipo("Professor");								
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

							/* fazer metodo de chamar Responsavel */
//							aluno.setResponsavel(responsavel);
							/* fazer metodo de chamar Responsavel */

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

									aluno.setTipo("Responsavel");
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
		
	}

}
