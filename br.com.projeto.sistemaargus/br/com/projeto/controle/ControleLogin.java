package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.DAOException;
import br.com.projeto.exceptions.ValidacaoException;
import br.com.projeto.fachada.Facade;
import br.com.projeto.visao.Mensagem;
import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaCadastro;
import br.com.projeto.visao.TelaCadastroAdministrador;
import br.com.projeto.visao.TelaLogin;
import br.com.projeto.visao.TelaPerfil;
import br.com.projeto.visao.TelaResetarSenha;

public class ControleLogin {

	TelaLogin telaLogin;
	TelaAreaDeTrabalho areaDeTrabalho;
	DateTimeFormatter formatter;
	Usuario usuario;
	private String tempSenha;

	public ControleLogin(TelaLogin telaLogin, TelaAreaDeTrabalho areaDeTrabalho) {
		this.telaLogin = telaLogin;
		this.areaDeTrabalho = areaDeTrabalho;
				
//		TelaResetarSenha resetarSenha = new TelaResetarSenha("Nome");
//		areaDeTrabalho.getjAreaTrabalho().add(resetarSenha);
//		resetarSenha.setVisible(true);
		
		telaLogin.getBtnLogin().addActionListener(new ActionListener() {
			
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
						Mensagem.exibir("Bem Vindo Administrador");
												
					} else if (usuario.getTipo().equalsIgnoreCase("Coordenador")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnCoordenador().setVisible(true);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					} else if (usuario.getTipo().equalsIgnoreCase("Diretor")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnDiretor().setVisible(true);
						Mensagem.exibir("Bem vindo " + usuario.getNome());
					} else if (usuario.getTipo().equalsIgnoreCase("Funcionario")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						areaDeTrabalho.getMnFuncionario().setVisible(true);
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

				telaPerfil.getTxtNome().setText(usuario.getNome());
				telaPerfil.getTxtLogin().setText(usuario.getLogin());
				telaPerfil.getTxtNaturalidade().setText(usuario.getNaturalidade());
				telaPerfil.getTxtSenha().setText(tempSenha);
				telaPerfil.getTxtDataNascimento().setDate(
						Date.from(usuario.getDataDeNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant()));

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
							
							tempSenha = userTemp.getSenha();
							
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
