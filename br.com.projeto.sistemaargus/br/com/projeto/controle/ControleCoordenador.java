package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import br.com.projeto.entidade.AcompPedagogo;
import br.com.projeto.entidade.Aluno;
import br.com.projeto.entidade.Curriculo;
import br.com.projeto.entidade.Pedagogo;
import br.com.projeto.entidade.TurmaAluno;
import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.DAOException;
import br.com.projeto.exceptions.ValidacaoException;
import br.com.projeto.fachada.Facade;
import br.com.projeto.visao.Mensagem;
import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaPedagogo;

public class ControleCoordenador {
	
	TelaAreaDeTrabalho areaDeTrabalho;
	DateTimeFormatter formatter;
	List<Usuario> usuarios;
	List<TurmaAluno> turmaAlunos;
	Usuario usuario;

	public ControleCoordenador(TelaAreaDeTrabalho areaDeTrabalho) {
		this.areaDeTrabalho = areaDeTrabalho;
		
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
