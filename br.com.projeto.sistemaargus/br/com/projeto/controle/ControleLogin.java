package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import br.com.projeto.entidade.Contato;
import br.com.projeto.entidade.Endereco;
import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.DAOException;
import br.com.projeto.exceptions.ValidacaoException;
import br.com.projeto.fachada.Facade;
import br.com.projeto.visao.Mensagem;
import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaLogin;
import br.com.projeto.visao.TelaPerfil;

public class ControleLogin {

	TelaLogin telaLogin;
	TelaAreaDeTrabalho areaDeTrabalho;
	DateTimeFormatter formatter;
	Usuario usuario;
	Endereco endereco;
	Contato contato;
	private String tempSenha;

	public ControleLogin(TelaLogin telaLogin, TelaAreaDeTrabalho areaDeTrabalho) {
		this.telaLogin = telaLogin;
		this.areaDeTrabalho = areaDeTrabalho;
						
		telaLogin.getTxtLogin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					usuario = Facade.getInstance().getBoUsuario().buscarUsuario(telaLogin.getTxtLogin().getText(),
							telaLogin.getTxtSenha().getText());
					tempSenha = telaLogin.getTxtSenha().getText();

					if(usuario.isResetSenha()==true) {
						try {
							Usuario userTemp = new Usuario();

							userTemp.setId(usuario.getId());
							userTemp.setAtivado(usuario.isAtivado());
							userTemp.setTipo(usuario.getTipo());
							userTemp.setResetSenha(false);
							userTemp.setNome(usuario.getNome());
							userTemp.setLogin(usuario.getLogin());
							userTemp.setNaturalidade(usuario.getNaturalidade());
							userTemp.setSenha(tempSenha);								
							userTemp.setDataDeNascimento(usuario.getDataDeNascimento());

							Facade.getInstance().atualizar(userTemp);

						} catch (ValidacaoException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}

					}
					
					if (usuario.getTipo().equalsIgnoreCase("Administrador")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnAdministrador().setVisible(true);
						areaDeTrabalho.getMnCoordenador().setVisible(true);
						areaDeTrabalho.getMnDiretor().setVisible(true);
						areaDeTrabalho.getMnFuncionario().setVisible(true);
						areaDeTrabalho.getMnSecretario().setVisible(true);						
						ControleAdministrador controleAdministrador = new ControleAdministrador(areaDeTrabalho);
						ControleSecretario controleSecretario = new ControleSecretario(areaDeTrabalho);
						ControleCoordenador controleCoordenador = new ControleCoordenador(areaDeTrabalho);
						ControleFuncionario controleFuncionario = new ControleFuncionario(areaDeTrabalho);
						ControleDiretor controleDiretor = new ControleDiretor(areaDeTrabalho);
						Mensagem.exibir("Bem Vindo Administrador");
												
					} else if (usuario.getTipo().equalsIgnoreCase("Coordenador")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnCoordenador().setVisible(true);
						ControleCoordenador controleCoordenador = new ControleCoordenador(areaDeTrabalho);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					} else if (usuario.getTipo().equalsIgnoreCase("Diretor")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnDiretor().setVisible(true);
						ControleDiretor controleDiretor = new ControleDiretor(areaDeTrabalho);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					} else if (usuario.getTipo().equalsIgnoreCase("Funcionario")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnFuncionario().setVisible(true);
						ControleFuncionario controleFuncionario = new ControleFuncionario(areaDeTrabalho);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					} else if (usuario.getTipo().equalsIgnoreCase("Secretario")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnSecretario().setVisible(true);
						ControleSecretario controleSecretario = new ControleSecretario(areaDeTrabalho);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					}							
				} catch (DAOException e1) {
					// TODO Auto-generated catch block
					Mensagem.exibir(e1.getMessage());
				}
			}
		});
		
		telaLogin.getTxtSenha().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					usuario = Facade.getInstance().getBoUsuario().buscarUsuario(telaLogin.getTxtLogin().getText(),
							telaLogin.getTxtSenha().getText());
					tempSenha = telaLogin.getTxtSenha().getText();

					if(usuario.isResetSenha()==true) {
						try {
							Usuario userTemp = new Usuario();

							userTemp.setId(usuario.getId());
							userTemp.setAtivado(usuario.isAtivado());
							userTemp.setTipo(usuario.getTipo());
							userTemp.setResetSenha(false);
							userTemp.setNome(usuario.getNome());
							userTemp.setLogin(usuario.getLogin());
							userTemp.setNaturalidade(usuario.getNaturalidade());
							userTemp.setSenha(tempSenha);								
							userTemp.setDataDeNascimento(usuario.getDataDeNascimento());

							Facade.getInstance().atualizar(userTemp);

						} catch (ValidacaoException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}

					}
					
					if (usuario.getTipo().equalsIgnoreCase("Administrador")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnAdministrador().setVisible(true);
						areaDeTrabalho.getMnCoordenador().setVisible(true);
						areaDeTrabalho.getMnDiretor().setVisible(true);
						areaDeTrabalho.getMnFuncionario().setVisible(true);
						areaDeTrabalho.getMnSecretario().setVisible(true);						
						ControleAdministrador controleAdministrador = new ControleAdministrador(areaDeTrabalho);
						ControleSecretario controleSecretario = new ControleSecretario(areaDeTrabalho);
						ControleCoordenador controleCoordenador = new ControleCoordenador(areaDeTrabalho);
						ControleFuncionario controleFuncionario = new ControleFuncionario(areaDeTrabalho);
						ControleDiretor controleDiretor = new ControleDiretor(areaDeTrabalho);
						Mensagem.exibir("Bem Vindo Administrador");
												
					} else if (usuario.getTipo().equalsIgnoreCase("Coordenador")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnCoordenador().setVisible(true);
						ControleCoordenador controleCoordenador = new ControleCoordenador(areaDeTrabalho);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					} else if (usuario.getTipo().equalsIgnoreCase("Diretor")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnDiretor().setVisible(true);
						ControleDiretor controleDiretor = new ControleDiretor(areaDeTrabalho);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					} else if (usuario.getTipo().equalsIgnoreCase("Funcionario")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnFuncionario().setVisible(true);
						ControleFuncionario controleFuncionario = new ControleFuncionario(areaDeTrabalho);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					} else if (usuario.getTipo().equalsIgnoreCase("Secretario")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnSecretario().setVisible(true);
						ControleSecretario controleSecretario = new ControleSecretario(areaDeTrabalho);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					}							
				} catch (DAOException e1) {
					// TODO Auto-generated catch block
					Mensagem.exibir(e1.getMessage());
				}
			}
		});
		
		telaLogin.getBtnLogin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

//				areaDeTrabalho.getMnArquivos().setVisible(true);
//				areaDeTrabalho.getMnAdministrador().setVisible(true);
//				areaDeTrabalho.getMnCoordenador().setVisible(true);
//				areaDeTrabalho.getMnDiretor().setVisible(true);
//				areaDeTrabalho.getMnFuncionario().setVisible(true);
//				areaDeTrabalho.getMnSecretario().setVisible(true);						
//				ControleAdministrador controleAdministrador = new ControleAdministrador(areaDeTrabalho);
//				ControleSecretario controleSecretario = new ControleSecretario(areaDeTrabalho);
//				Mensagem.exibir("Bem Vindo Administrador");
				
				try {
					usuario = Facade.getInstance().getBoUsuario().buscarUsuario(telaLogin.getTxtLogin().getText(),
							telaLogin.getTxtSenha().getText());
					tempSenha = telaLogin.getTxtSenha().getText();

					if(usuario.isResetSenha()==true) {
						try {
							Usuario userTemp = new Usuario();

							userTemp.setId(usuario.getId());
							userTemp.setAtivado(usuario.isAtivado());
							userTemp.setTipo(usuario.getTipo());
							userTemp.setResetSenha(false);
							userTemp.setNome(usuario.getNome());
							userTemp.setLogin(usuario.getLogin());
							userTemp.setNaturalidade(usuario.getNaturalidade());
							userTemp.setSenha(tempSenha);								
							userTemp.setDataDeNascimento(usuario.getDataDeNascimento());

							Facade.getInstance().atualizar(userTemp);

						} catch (ValidacaoException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}

					}
					
					if (usuario.getTipo().equalsIgnoreCase("Administrador")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnAdministrador().setVisible(true);
						areaDeTrabalho.getMnCoordenador().setVisible(true);
						areaDeTrabalho.getMnDiretor().setVisible(true);
						areaDeTrabalho.getMnFuncionario().setVisible(true);
						areaDeTrabalho.getMnSecretario().setVisible(true);						
						ControleAdministrador controleAdministrador = new ControleAdministrador(areaDeTrabalho);
						ControleSecretario controleSecretario = new ControleSecretario(areaDeTrabalho);
						ControleCoordenador controleCoordenador = new ControleCoordenador(areaDeTrabalho);
						ControleFuncionario controleFuncionario = new ControleFuncionario(areaDeTrabalho);
						ControleDiretor controleDiretor = new ControleDiretor(areaDeTrabalho);
						Mensagem.exibir("Bem Vindo Administrador");
												
					} else if (usuario.getTipo().equalsIgnoreCase("Coordenador")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnCoordenador().setVisible(true);
						ControleCoordenador controleCoordenador = new ControleCoordenador(areaDeTrabalho);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					} else if (usuario.getTipo().equalsIgnoreCase("Diretor")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnDiretor().setVisible(true);
						ControleDiretor controleDiretor = new ControleDiretor(areaDeTrabalho);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					} else if (usuario.getTipo().equalsIgnoreCase("Funcionario")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnFuncionario().setVisible(true);
						ControleFuncionario controleFuncionario = new ControleFuncionario(areaDeTrabalho);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					} else if (usuario.getTipo().equalsIgnoreCase("Secretario")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnSecretario().setVisible(true);
						ControleSecretario controleSecretario = new ControleSecretario(areaDeTrabalho);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					}							
				} catch (DAOException e1) {
					// TODO Auto-generated catch block
					Mensagem.exibir(e1.getMessage());
				}
			}
		});
		
		telaLogin.getBtnEsqueceuASenha().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					usuario = Facade.getInstance().getBoUsuario().buscarUsuario(telaLogin.getTxtLogin().getText());
				
					try {
						Usuario userTemp = new Usuario();

						userTemp.setId(usuario.getId());
						userTemp.setAtivado(usuario.isAtivado());
						userTemp.setTipo(usuario.getTipo());
						userTemp.setResetSenha(true);
						userTemp.setNome(usuario.getNome());
						userTemp.setLogin(usuario.getLogin());
						userTemp.setNaturalidade(usuario.getNaturalidade());
						userTemp.setSenha(usuario.getLogin());								
						userTemp.setDataDeNascimento(usuario.getDataDeNascimento());

						Facade.getInstance().atualizar(userTemp);
						
						Mensagem.exibir("Senha alterada para padrão e mensagem enviado para o Administrador");					

					} catch (ValidacaoException e1) {
						// TODO Auto-generated catch block
						Mensagem.exibir(e1.getMessage());
					}
					
				} catch (DAOException e1) {
					// TODO Auto-generated catch block
					Mensagem.exibir(e1.getMessage());
				}
			}
		});

		areaDeTrabalho.getMntmPerfil().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaPerfil telaPerfil = new TelaPerfil();
				areaDeTrabalho.getjAreaTrabalho().add(telaPerfil);
				telaPerfil.setVisible(true);

				telaPerfil.getTxtCep().setText("");
				telaPerfil.getTxtCidade().setText("");
				telaPerfil.getTxtEstado().setText("");
				telaPerfil.getTxtNumero().setText("");
				telaPerfil.getTxtRua().setText("");
				
				telaPerfil.getTxtCelular().setText("");
				telaPerfil.getTxtTelefone().setText("");				
				
				try {
					endereco = Facade.getInstance().getBoEndereco().buscarEndereco(usuario.getId());
				} catch (DAOException e2) {
					// TODO Auto-generated catch block
					Mensagem.exibir(e2.getMessage());
				}
				try {
					contato = Facade.getInstance().getBoContato().buscarContato(usuario.getId());
				} catch (DAOException e2) {
					// TODO Auto-generated catch block
					Mensagem.exibir(e2.getMessage());
				}

				telaPerfil.getTxtNome().setText(usuario.getNome());
				telaPerfil.getTxtLogin().setText(usuario.getLogin());
				telaPerfil.getTxtNaturalidade().setText(usuario.getNaturalidade());
				telaPerfil.getTxtSenha().setText(tempSenha);
				telaPerfil.getTxtDataNascimento().setDate(
						Date.from(usuario.getDataDeNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant()));

				if (endereco.getUsuario().getId() == usuario.getId()) {
					telaPerfil.getTxtCep().setText(endereco.getCep());
					telaPerfil.getTxtCidade().setText(endereco.getCidade());
					telaPerfil.getTxtEstado().setText(endereco.getEstado());
					telaPerfil.getTxtNumero().setText(Integer.toString(endereco.getNumero()));
					telaPerfil.getTxtRua().setText(endereco.getRua());
				}

				if (contato.getUsuario().getId() == usuario.getId()) {
					telaPerfil.getTxtCelular().setText(contato.getCelular());
					telaPerfil.getTxtTelefone().setText(contato.getTelefone());
				}

				telaPerfil.getBtnEditar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							Usuario userTemp = new Usuario();

							userTemp.setId(usuario.getId());
							userTemp.setAtivado(usuario.isAtivado());
							userTemp.setTipo(usuario.getTipo());
							userTemp.setResetSenha(usuario.isResetSenha());
							userTemp.setNome(telaPerfil.getTxtNome().getText());
							userTemp.setLogin(telaPerfil.getTxtLogin().getText());
							userTemp.setNaturalidade(telaPerfil.getTxtNaturalidade().getText());
							userTemp.setSenha(telaPerfil.getTxtSenha().getText());

							formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							Date date = new Date();
							date = telaPerfil.getTxtDataNascimento().getDate();
							userTemp.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

							Facade.getInstance().atualizar(userTemp);

							tempSenha = telaPerfil.getTxtSenha().getText();

							if (endereco.getUsuario().getId() != usuario.getId()) {
								if (!telaPerfil.getTxtCidade().getText().equals("")
										&& !telaPerfil.getTxtEstado().getText().equals("")
										&& !telaPerfil.getTxtRua().getText().equals("")
										&& !telaPerfil.getTxtNumero().getText().equals("")
										&& !telaPerfil.getTxtCep().getText().equals("")) {

									Endereco endereco = new Endereco();
									endereco.setCep(telaPerfil.getTxtCep().getText());
									endereco.setCidade(telaPerfil.getTxtCidade().getText());
									endereco.setEstado(telaPerfil.getTxtEstado().getText());
									endereco.setNumero(Integer.parseInt(telaPerfil.getTxtNumero().getText()));
									endereco.setRua(telaPerfil.getTxtRua().getText());
									endereco.setUsuario(usuario);

									Facade.getInstance().inserir(endereco);
								}
							} else {
								Endereco enderTemp = new Endereco();
								
								enderTemp.setId(endereco.getId());
								enderTemp.setUsuario(endereco.getUsuario());
								enderTemp.setCep(telaPerfil.getTxtCep().getText());
								enderTemp.setCidade(telaPerfil.getTxtCidade().getText());
								enderTemp.setEstado(telaPerfil.getTxtEstado().getText());
								enderTemp.setNumero(Integer.parseInt(telaPerfil.getTxtNumero().getText()));
								enderTemp.setRua(telaPerfil.getTxtRua().getText());

								Facade.getInstance().atualizar(enderTemp);
							}
							
							if (contato.getUsuario().getId() != usuario.getId()) {
								if (!telaPerfil.getTxtTelefone().getText().equals("")
										|| !telaPerfil.getTxtCelular().getText().equals("")) {

									Contato contato = new Contato();
									contato.setCelular(telaPerfil.getTxtCelular().getText());
									contato.setTelefone(telaPerfil.getTxtTelefone().getText());
									
									Facade.getInstance().inserir(contato);
								}
							}
							
							else {
								Contato contTemp = new Contato();
								
								contTemp.setId(contato.getId());
								contTemp.setUsuario(contato.getUsuario());
								contTemp.setCelular(telaPerfil.getTxtCelular().getText());
								contTemp.setTelefone(telaPerfil.getTxtTelefone().getText());

								Facade.getInstance().atualizar(contTemp);
							}

							Mensagem.exibir("Atualizado");
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
