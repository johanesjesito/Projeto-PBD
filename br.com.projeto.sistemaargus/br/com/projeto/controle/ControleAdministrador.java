package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.ValidacaoException;
import br.com.projeto.fachada.Facade;
import br.com.projeto.visao.Mensagem;
import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaCadastroAdministrador;

public class ControleAdministrador {
	
	TelaAreaDeTrabalho areaDeTrabalho;
	DateTimeFormatter formatter;

	public ControleAdministrador(TelaAreaDeTrabalho areaDeTrabalho) {
		this.areaDeTrabalho = areaDeTrabalho;
			
		areaDeTrabalho.getMntmCadastroDeUsuario().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaCadastroAdministrador cadastroAdministrador = new TelaCadastroAdministrador();
				areaDeTrabalho.getjAreaTrabalho().add(cadastroAdministrador);
				cadastroAdministrador.setVisible(true);
				
				cadastroAdministrador.getBtnConfirmar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							
							Usuario usuario = new Usuario();

							usuario.setNome(cadastroAdministrador.getTxtNome().getText());
							usuario.setLogin(cadastroAdministrador.getTxtLogin().getText());
							usuario.setSenha(cadastroAdministrador.getTxtSenha().getText());
							usuario.setNaturalidade(cadastroAdministrador.getTxtNaturalidade().getText());				

							if(cadastroAdministrador.getRdbtnCoordenador().isSelected()==true)
								usuario.setTipo("Coordenador");
							else if(cadastroAdministrador.getRdbtnDiretor().isSelected()==true)
								usuario.setTipo("Diretor");
							else if(cadastroAdministrador.getRdbtnFuncionario().isSelected()==true)
								usuario.setTipo("Funcionario");
							else if(cadastroAdministrador.getRdbtnSecretario().isSelected()==true)
								usuario.setTipo("Secretario");
							
							formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							Date date = new Date();
							date = cadastroAdministrador.getTxtDataNascimento().getDate();
							usuario.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
							
							usuario.setResetSenha(false);
							
							Facade.getInstance().inserir(usuario);
							
							Mensagem.exibir("Cadastrado com Sucesso");
						} catch (ValidacaoException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
					}
				});
			}
		});
		
	};

}
