package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import br.com.projeto.entidade.Pedagogo;
import br.com.projeto.entidade.Professor;
import br.com.projeto.entidade.Responsavel;
import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.ValidacaoException;
import br.com.projeto.fachada.Facade;
import br.com.projeto.visao.Mensagem;
import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaCadastro;

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
								responsavel.setTipo("Responsavel");								
								responsavel.setNome(telaCadastro.getTxtNome().getText());
								responsavel.setNaturalidade(telaCadastro.getTxtNaturalidade().getText());				
								formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								Date date = new Date();
								date = telaCadastro.getTxtDataNascimento().getDate();
								responsavel.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
								Facade.getInstance().inserir(responsavel);
							}
							else if(telaCadastro.getRdbtnPedagogo().isSelected()==true) {
								Pedagogo pedagogo = new Pedagogo();
								pedagogo.setCpf(telaCadastro.getTxtCpf().getText());
								pedagogo.setTipo("Pedagogo");								
								pedagogo.setNome(telaCadastro.getTxtNome().getText());
								pedagogo.setNaturalidade(telaCadastro.getTxtNaturalidade().getText());				
								formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								Date date = new Date();
								date = telaCadastro.getTxtDataNascimento().getDate();
								pedagogo.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
								Facade.getInstance().inserir(pedagogo);
							}
							else if(telaCadastro.getRdbtnProfessor().isSelected()==true) {
								Professor professor = new Professor();
								professor.setCpf(telaCadastro.getTxtCpf().getText());
								professor.setTipo("Professor");								
								professor.setNome(telaCadastro.getTxtNome().getText());
								professor.setNaturalidade(telaCadastro.getTxtNaturalidade().getText());				
								formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
								Date date = new Date();
								date = telaCadastro.getTxtDataNascimento().getDate();
								professor.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
								
								professor.setResetSenha(false);

								Facade.getInstance().inserir(professor);
							}
//							else if(telaCadastro.getRdbtnAluno().isSelected()==true)
//							usuario.setTipo("Aluno");
																					
							Mensagem.exibir("Cadastrado com Sucesso");
						} catch (ValidacaoException e) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e.getMessage());
						}
					}
				});
				
			}
		});
		
	}

}
