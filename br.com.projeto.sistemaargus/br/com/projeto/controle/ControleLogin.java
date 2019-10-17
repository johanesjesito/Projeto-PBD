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
import br.com.projeto.visao.TelaLogin;

public class ControleLogin {

	TelaLogin telaLogin;
	TelaAreaDeTrabalho areaDeTrabalho;
	DateTimeFormatter formatter;
	Usuario usuario;

	public ControleLogin(TelaLogin telaLogin, TelaAreaDeTrabalho areaDeTrabalho) {
		this.telaLogin = telaLogin;
		this.areaDeTrabalho = areaDeTrabalho;
		
		TelaCadastro telaCadastro = new TelaCadastro();
		areaDeTrabalho.getjAreaTrabalho().add(telaCadastro);
		
		telaLogin.getBtnLogin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					usuario = Facade.getInstance().getBoUsuario().buscarUsuario(telaLogin.getTxtLogin().getText(), telaLogin.getTxtSenha().getText());
					
					if(usuario.getTipo().equalsIgnoreCase("Administrador")) {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						Mensagem.exibir("Bem Vindo Administrador");						
					}
					else {
						telaLogin.setVisible(false);
						areaDeTrabalho.getMnArquivos().setVisible(true);
						Mensagem.exibir("Login efetuado com sucesso");						
					}
					
				} catch (DAOException e1) {
					// TODO Auto-generated catch block
					Mensagem.exibir(e1.getMessage());
				}
				
			}
		});
		
		telaLogin.getBtnCriar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				telaLogin.setVisible(false);
				telaCadastro.setVisible(true);
			}
		});
		
		telaCadastro.getBtnVolta().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				telaCadastro.setVisible(false);		
				telaLogin.setVisible(true);
			}
		});
		
		telaCadastro.getBtnConfirmar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
				
					Usuario usuario = new Usuario();

					usuario.setNome(telaCadastro.getTxtNome().getText());
					usuario.setLogin(telaCadastro.getTxtLogin().getText());
					usuario.setSenha(telaCadastro.getTxtSenha().getText());
					usuario.setNaturalidade(telaCadastro.getTxtNaturalidade().getText());				

					if(telaCadastro.getRdbtnAluno().isSelected()==true)
						usuario.setTipo("Aluno");
					else if(telaCadastro.getRdbtnPais().isSelected()==true)
						usuario.setTipo("Pais");
					else if(telaCadastro.getRdbtnPedagogo().isSelected()==true)
						usuario.setTipo("Pedagogo");
					else if(telaCadastro.getRdbtnProfessor().isSelected()==true)
						usuario.setTipo("Professor");
					
					formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					Date date = new Date();
					date = telaCadastro.getTxtDataNascimento().getDate();
					usuario.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
					
					usuario.setResetSenha(false);
					
					Facade.getInstance().inserir(usuario);
					
					Mensagem.exibir("Cadastrado com Sucesso");
				} catch (ValidacaoException e) {
					// TODO Auto-generated catch block
					Mensagem.exibir(e.getMessage());
				}
			}
		});
	}
	
	
	
}
