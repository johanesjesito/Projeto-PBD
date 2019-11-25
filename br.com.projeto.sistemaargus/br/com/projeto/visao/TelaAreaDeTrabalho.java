package br.com.projeto.visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;


import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class TelaAreaDeTrabalho extends JFrame {
	
	private JPanel contentPane;
	private JDesktopPane jAreaTrabalho;
	private JMenu mnArquivos;
	private JMenuItem mntmSair;
	private JMenuItem mntmPerfil;
	private JMenu mnAdministrador;
	private JMenuItem mntmCadastroDeUsuario;
	private JMenu mnFuncionario;
	private JMenu mnCoordenador;
	private JMenu mnSecretario;
	private JMenu mnDiretor;
	private JMenuItem mntmCadastro;
	private JMenuItem mntmCadastrarAluno;
	private JMenuItem mntmAcompanhamento;
	private JMenuItem mntmCadastrarDisciplina;
	private JMenuItem mntmCadastrarNotas;
	private JMenuItem mntmCadastrarCurriculoAluno;
	private JMenuItem mntmCadastrarDisciplinasNa;
	private JMenuItem mntmGerarCurriculoDo;
	private JMenuItem mntmCadastrarAlunosNa;
	private JMenuItem mntmGerarCurriculoDoSecre;
	private JMenuItem mntmGerarCurriculoDoDire;
	private JMenuItem mntmGerarRelatorioPedagogo;
	private JMenuItem mntmGerarRelatorioPedagogoDire;
	private JMenuItem mntmListaDeAcompanhamento;
	private JMenuItem mntmListaDeAcompanhamentoDire;
	private JMenuItem mntmEditarNotas;
	private JMenuItem mntmParcelaDoAluno;
	private JMenuItem mntmParcelaDoAluno2;
	private JMenuItem mntmListaDeUsuarios;
	private JMenuItem mntmListaDeParcelas;
	private JMenuItem mntmListaDeParcelas2;
	
	public TelaAreaDeTrabalho() {
		setResizable(false);
		setTitle("ARGUS");
				
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
		} catch (ClassNotFoundException e) {
		    // handle exception
		} catch (InstantiationException e) {
		    // handle exception
		} catch (IllegalAccessException e) {
		    // handle exception
		}		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 50, 1000, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jAreaTrabalho = new JDesktopPane();
		jAreaTrabalho.setBounds(0, 21, 994, 451);		
		contentPane.add(jAreaTrabalho);
		
		JMenuBar telaMenuBar = new JMenuBar();
		telaMenuBar.setBounds(0, 0, 994, 21);
		contentPane.add(telaMenuBar);
		
		mnArquivos = new JMenu("Arquivos");
		telaMenuBar.add(mnArquivos);
		
		mntmPerfil = new JMenuItem("Perfil");
		mnArquivos.add(mntmPerfil);
		
		mntmSair = new JMenuItem("Sair");
		mnArquivos.add(mntmSair);
		
		mnAdministrador = new JMenu("Administrador");
		telaMenuBar.add(mnAdministrador);
		
		mntmCadastroDeUsuario = new JMenuItem("Cadastro de Usuario");
		mnAdministrador.add(mntmCadastroDeUsuario);
		
		mnFuncionario = new JMenu("Funcionario");
		telaMenuBar.add(mnFuncionario);
		
		mntmCadastrarDisciplina = new JMenuItem("Cadastrar Disciplina");
		mnFuncionario.add(mntmCadastrarDisciplina);
		
		mntmCadastrarDisciplinasNa = new JMenuItem("Cadastrar Disciplinas na Turma");
		mnFuncionario.add(mntmCadastrarDisciplinasNa);
		
		mntmCadastrarAlunosNa = new JMenuItem("Cadastrar Alunos na Turma");
		mnFuncionario.add(mntmCadastrarAlunosNa);
		
		mntmCadastrarNotas = new JMenuItem("Cadastrar Notas");
		mnFuncionario.add(mntmCadastrarNotas);
		
		mntmEditarNotas = new JMenuItem("Editar Notas");
		mnFuncionario.add(mntmEditarNotas);
		
		mntmCadastrarCurriculoAluno = new JMenuItem("Cadastrar Curriculo do Aluno");
		mnFuncionario.add(mntmCadastrarCurriculoAluno);
		
		mntmGerarCurriculoDo = new JMenuItem("Gerar Boletim do Aluno");
		mnFuncionario.add(mntmGerarCurriculoDo);
		
		mntmParcelaDoAluno2 = new JMenuItem("Parcela do Aluno");
		mnFuncionario.add(mntmParcelaDoAluno2);
		
		mnCoordenador = new JMenu("Coordenador");
		telaMenuBar.add(mnCoordenador);
		
		mntmAcompanhamento = new JMenuItem("Acompanhamento");
		mnCoordenador.add(mntmAcompanhamento);
		
		mntmListaDeAcompanhamento = new JMenuItem("Lista de Acompanhamento");
		mnCoordenador.add(mntmListaDeAcompanhamento);
		
		mntmGerarRelatorioPedagogo = new JMenuItem("Gerar Relatorio Pedagogo");
		mnCoordenador.add(mntmGerarRelatorioPedagogo);
		
		mnSecretario = new JMenu("Secretario");
		telaMenuBar.add(mnSecretario);
		
		mntmCadastro = new JMenuItem("Cadastro");
		mnSecretario.add(mntmCadastro);
		
		mntmCadastrarAluno = new JMenuItem("Cadastrar Aluno");
		mnSecretario.add(mntmCadastrarAluno);
		
		mntmGerarCurriculoDoSecre = new JMenuItem("Gerar Boletim do Aluno");
		mnSecretario.add(mntmGerarCurriculoDoSecre);
		
		mntmParcelaDoAluno = new JMenuItem("Parcela do Aluno");
		mnSecretario.add(mntmParcelaDoAluno);
		
		mntmListaDeParcelas2 = new JMenuItem("Lista de Parcelas");
		mnSecretario.add(mntmListaDeParcelas2);
		
		mnDiretor = new JMenu("Diretor");
		telaMenuBar.add(mnDiretor);
		
		mntmListaDeAcompanhamentoDire = new JMenuItem("Lista de Acompanhamento");
		mnDiretor.add(mntmListaDeAcompanhamentoDire);
		
		mntmGerarCurriculoDoDire = new JMenuItem("Gerar Boletim do Aluno");
		mnDiretor.add(mntmGerarCurriculoDoDire);
		
		mntmGerarRelatorioPedagogoDire = new JMenuItem("Gerar Relatorio Pedagogo");
		mnDiretor.add(mntmGerarRelatorioPedagogoDire);
		
		mntmListaDeUsuarios = new JMenuItem("Lista de Usuarios");
		mnDiretor.add(mntmListaDeUsuarios);
		
		mntmListaDeParcelas = new JMenuItem("Lista de Parcelas");
		mnDiretor.add(mntmListaDeParcelas);
		
		JLabel lblAreaDeTrabalho = new JLabel("");
		lblAreaDeTrabalho.setBackground(Color.WHITE);
		lblAreaDeTrabalho.setIcon(new ImageIcon("files/Arena de Trabalho.png"));
		lblAreaDeTrabalho.setBounds(0, 0, 994, 451);
		jAreaTrabalho.add(lblAreaDeTrabalho);
	}

	public JDesktopPane getjAreaTrabalho() {
		return jAreaTrabalho;
	}

	public JMenu getMnArquivos() {
		return mnArquivos;
	}

	public JMenuItem getMntmSair() {
		return mntmSair;
	}

	public JMenuItem getMntmPerfil() {
		return mntmPerfil;
	}

	public JMenu getMnAdministrador() {
		return mnAdministrador;
	}

	public JMenuItem getMntmCadastroDeUsuario() {
		return mntmCadastroDeUsuario;
	}

	public JMenu getMnFuncionario() {
		return mnFuncionario;
	}

	public JMenu getMnCoordenador() {
		return mnCoordenador;
	}

	public JMenu getMnSecretario() {
		return mnSecretario;
	}

	public JMenu getMnDiretor() {
		return mnDiretor;
	}

	public JMenuItem getMntmCadastro() {
		return mntmCadastro;
	}

	public JMenuItem getMntmCadastrarAluno() {
		return mntmCadastrarAluno;
	}

	public JMenuItem getMntmAcompanhamento() {
		return mntmAcompanhamento;
	}

	public JMenuItem getMntmCadastrarDisciplina() {
		return mntmCadastrarDisciplina;
	}

	public JMenuItem getMntmCadastrarNotas() {
		return mntmCadastrarNotas;
	}

	public JMenuItem getMntmCadastrarCurriculoAluno() {
		return mntmCadastrarCurriculoAluno;
	}

	public JMenuItem getMntmCadastrarDisciplinasNa() {
		return mntmCadastrarDisciplinasNa;
	}

	public JMenuItem getMntmGerarCurriculoDo() {
		return mntmGerarCurriculoDo;
	}

	public JMenuItem getMntmCadastrarAlunosNa() {
		return mntmCadastrarAlunosNa;
	}

	public JMenuItem getMntmGerarCurriculoDoSecre() {
		return mntmGerarCurriculoDoSecre;
	}

	public JMenuItem getMntmGerarCurriculoDoDire() {
		return mntmGerarCurriculoDoDire;
	}

	public JMenuItem getMntmGerarRelatorioPedagogo() {
		return mntmGerarRelatorioPedagogo;
	}

	public JMenuItem getMntmGerarRelatorioPedagogoDire() {
		return mntmGerarRelatorioPedagogoDire;
	}

	public JMenuItem getMntmListaDeAcompanhamento() {
		return mntmListaDeAcompanhamento;
	}

	public JMenuItem getMntmListaDeAcompanhamentoDire() {
		return mntmListaDeAcompanhamentoDire;
	}

	public JMenuItem getMntmEditarNotas() {
		return mntmEditarNotas;
	}

	public JMenuItem getMntmParcelaDoAluno() {
		return mntmParcelaDoAluno;
	}

	public JMenuItem getMntmParcelaDoAluno2() {
		return mntmParcelaDoAluno2;
	}

	public JMenuItem getMntmListaDeUsuarios() {
		return mntmListaDeUsuarios;
	}

	public JMenuItem getMntmListaDeParcelas() {
		return mntmListaDeParcelas;
	}

	public JMenuItem getMntmListaDeParcelas2() {
		return mntmListaDeParcelas2;
	}
	
}
