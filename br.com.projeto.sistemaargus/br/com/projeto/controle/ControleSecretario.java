package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.projeto.entidade.Aluno;
import br.com.projeto.entidade.Contato;
import br.com.projeto.entidade.Curriculo;
import br.com.projeto.entidade.Disciplina;
import br.com.projeto.entidade.Endereco;
import br.com.projeto.entidade.Nota;
import br.com.projeto.entidade.Parcela;
import br.com.projeto.entidade.Pedagogo;
import br.com.projeto.entidade.Professor;
import br.com.projeto.entidade.Responsavel;
import br.com.projeto.entidade.TurmaAluno;
import br.com.projeto.entidade.TurmaDisciplina;
import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.DAOException;
import br.com.projeto.exceptions.ValidacaoException;
import br.com.projeto.fachada.Facade;
import br.com.projeto.visao.Mensagem;
import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaBoletoBancario;
import br.com.projeto.visao.TelaCadastro;
import br.com.projeto.visao.TelaCadastroAluno;
import br.com.projeto.visao.TelaGerarCurriculoPDF;
import br.com.projeto.visao.TelaListaParcelas;

public class ControleSecretario {
	
	TelaAreaDeTrabalho areaDeTrabalho;
	List<Usuario> usuarios;
	List<Nota> notas;
	List<TurmaDisciplina> turmaDisciplinas;
	List<TurmaAluno> turmaAlunos;
	List<Curriculo> curriculos;
	List<Parcela> parcelas;
	Curriculo curriculo;
	Usuario usuario;
	Disciplina disciplina;
	TurmaAluno turmaAluno;
	TurmaDisciplina turmaDisciplina;
	Parcela parcela;
	Aluno aluno;
	double nota1 = 0;
	double nota2 = 0;
	double nota3 = 0;
	double nota4 = 0;
	double mediaparcial = 0;
	double notafinal = 0;
	double mediafinal = 0;

	public ControleSecretario(TelaAreaDeTrabalho areaDeTrabalho) {
		this.areaDeTrabalho = areaDeTrabalho;
		
		areaDeTrabalho.getMntmListaDeParcelas2().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaListaParcelas telaListaParcelas = new TelaListaParcelas();
				areaDeTrabalho.getjAreaTrabalho().add(telaListaParcelas);
				telaListaParcelas.setVisible(true);
				
				telaListaParcelas.getTxtTurma().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						final DefaultComboBoxModel combo = new DefaultComboBoxModel();

						try {
							turmaAlunos = Facade.getInstance().getboTurmaAluno().buscarListaTurmaAluno(
									telaListaParcelas.getTxtTurma().getSelectedItem().toString(),
									Integer.parseInt(telaListaParcelas.getTxtAnoLetivo().getText()));
						} catch (NumberFormatException | DAOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
						for (TurmaAluno turmaAluno : turmaAlunos) {
							combo.addElement(turmaAluno.getAluno().getNome());
						}
						telaListaParcelas.getTxtAluno().setModel(combo);

					}
				});
				
				telaListaParcelas.getTxtAluno().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						final DefaultTableModel modelo = new DefaultTableModel(
								new Object[][] { { "Resposavel", "Data inicial", "Vencimento", "Pendencia" } },
								new String[] { "Resposavel", "Data inicial", "Vencimento", "Pendencia" });
						modelo.setRowCount(0);
						modelo.addRow(new Object[] { "Resposavel", "Data inicial", "Vencimento", "Pendencia" });
						try {
							usuario = Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(telaListaParcelas.getTxtAluno().getSelectedItem().toString(), "Aluno");
							turmaAluno = Facade.getInstance().getboTurmaAluno().buscarTurma(usuario.getId(), Integer.parseInt(telaListaParcelas.getTxtAnoLetivo().getText()));
							parcelas = Facade.getInstance().getBoParcela().buscarParcela(turmaAluno.getId());
							for (Parcela parcela : parcelas) {
								modelo.addRow(new Object[] { parcela.getResponsavel().getNome(), parcela.getDataInicial(),
										parcela.getDataVencimento(), parcela.getPedente() });
								telaListaParcelas.getTxtAcompanhamento().setModel(modelo);
							}
						} catch (DAOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
					}
				});
			}
		});
		
		areaDeTrabalho.getMntmParcelaDoAluno().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaBoletoBancario telaBoletoBancario = new TelaBoletoBancario();
				areaDeTrabalho.getjAreaTrabalho().add(telaBoletoBancario);
				telaBoletoBancario.setVisible(true);
									
				telaBoletoBancario.getTxtTurma().addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						final DefaultComboBoxModel combo = new DefaultComboBoxModel();
						
						try {
							turmaAlunos = Facade.getInstance().getboTurmaAluno().buscarListaTurmaAluno(telaBoletoBancario.getTxtTurma().getSelectedItem().toString(), Integer.parseInt(telaBoletoBancario.getTxtAnoLetivo().getText()));
						} catch (NumberFormatException | DAOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}						
						for (TurmaAluno turmaAluno : turmaAlunos) {
							combo.addElement(turmaAluno.getAluno().getNome());
						}
						telaBoletoBancario.getTxtAluno().setModel(combo);		
					}
				});
				
				telaBoletoBancario.getBtnConfirmar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							parcela = new Parcela();
							Random gerador = new Random();
							int inteiro = gerador.nextInt(899999999) + 100000000;
							int inteiro2 = gerador.nextInt(899999999) + 100000000;
							int inteiro3 = gerador.nextInt(899999999) + 100000000;
							String codigo = Integer.toString(inteiro) + Integer.toString(inteiro2) + Integer.toString(inteiro3);
							aluno = (Aluno) Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(telaBoletoBancario.getTxtAluno().getSelectedItem().toString(), "Aluno");
							turmaAluno = Facade.getInstance().getboTurmaAluno().buscarTurma(aluno.getId(), Integer.parseInt(telaBoletoBancario.getTxtAnoLetivo().getText()));
							parcela.setCodigo(codigo);
							parcela.setTurmaAluno(turmaAluno);
							parcela.setResponsavel(aluno.getResponsavel());
							if(telaBoletoBancario.getTxtTurma().getSelectedItem().toString().equals("EM - 1º Ano") || telaBoletoBancario.getTxtTurma().getSelectedItem().toString().equals("EM - 2º Ano") || telaBoletoBancario.getTxtTurma().getSelectedItem().toString().equals("EM - 3º Ano")) {
								parcela.setValor(800.00);
							}
							else if(telaBoletoBancario.getTxtTurma().getSelectedItem().toString().equals("EF2 - 6º Ano") || telaBoletoBancario.getTxtTurma().getSelectedItem().toString().equals("EF2 - 7º Ano") || telaBoletoBancario.getTxtTurma().getSelectedItem().toString().equals("EF2 - 8º Ano") || telaBoletoBancario.getTxtTurma().getSelectedItem().toString().equals("EF2 - 9º Ano")) {
								parcela.setValor(600.00);								
							}
							else {
								parcela.setValor(400.00);
							}
							Date date = new Date();
							date = telaBoletoBancario.getTxtDataInicial().getDate();
							parcela.setDataInicial(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
							Date date2 = new Date();
							date2 = telaBoletoBancario.getTxtDataFinal().getDate();
							parcela.setDataVencimento(date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
							parcela.setPedente("Pedente");
							Facade.getInstance().inserir(parcela);
							Mensagem.exibir("Cadastrado");
						} catch (ValidacaoException e) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e.getMessage());
						}
						
					}
				});
				
				telaBoletoBancario.getBtnGerarBoleto().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						Document document = new Document();
						try {
							PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Documento/PDF_DevMedia4.pdf"));
							document.open();
							PdfPTable table = new PdfPTable(9);
							PdfPCell cell = new PdfPCell(new Phrase("BANCO",
									new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK)));
							cell.setColspan(2);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table.addCell(cell);
							cell = new PdfPCell(new Phrase("Codigo: " + parcela.getCodigo(),
									new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK)));
							cell.setColspan(7);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table.addCell(cell);
							cell = new PdfPCell(new Phrase("Pagavel em qualquer agência até a data do vencimento",
									new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK)));
							cell.setColspan(7);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table.addCell(cell);
							cell = new PdfPCell(new Phrase("Vecimento: " + parcela.getDataVencimento(),
									new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK)));
							cell.setColspan(2);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table.addCell(cell);
							cell = new PdfPCell(new Phrase("Responsavel: " + parcela.getResponsavel().getNome(),
									new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK)));
							cell.setColspan(7);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table.addCell(cell);
							cell = new PdfPCell(new Phrase("Data Inicial: " + parcela.getDataInicial(),
									new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK)));
							cell.setColspan(2);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table.addCell(cell);
							cell = new PdfPCell(new Phrase("Aluno: " + parcela.getTurmaAluno().getAluno().getNome(),
									new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK)));
							cell.setColspan(5);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table.addCell(cell);
							cell = new PdfPCell(new Phrase("Quantidade: 1",
									new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK)));
							cell.setColspan(2);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table.addCell(cell);
							cell = new PdfPCell(new Phrase("R$",
									new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK)));
							cell.setColspan(1);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table.addCell(cell);
							DecimalFormat fmt = new DecimalFormat("#0.00");
							String preco = fmt.format(parcela.getValor());
							cell = new PdfPCell(new Phrase(preco,
									new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK)));
							cell.setColspan(1);
							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
							table.addCell(cell);
							document.add(table);
							document.add(new Paragraph(" "));
							PdfContentByte cb = writer.getDirectContent();
							Barcode128 codeEAN = new Barcode128();
							codeEAN.setCodeType(codeEAN.CODE128);
							codeEAN.setCode(parcela.getCodigo());
							Image imageEAN = codeEAN.createImageWithBarcode(cb, null, null);
							Paragraph pTitulo = new Paragraph(new Phrase(new Chunk(imageEAN, 0, 0)));
							pTitulo.setAlignment(Element.ALIGN_CENTER);
							document.add(pTitulo);
						} catch (DocumentException de) {
							Mensagem.exibir(de.getMessage());
						} catch (IOException ioe) {
							Mensagem.exibir(ioe.getMessage());
						}
						document.close();
						Mensagem.exibir("PDF GERADO");
						try {
							Runtime.getRuntime()
									.exec(new String[] { "cmd.exe", "/c", "start", "Documento/PDF_DevMedia4.pdf" });
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
					}
				});
								
				telaBoletoBancario.getBtnPago().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try {
							parcela = Facade.getInstance().getBoParcela().buscarParcela(telaBoletoBancario.getTxtCodigo().getText());
							
							Parcela parceTemp = new Parcela();
							parceTemp.setId(parcela.getId());
							parceTemp.setCodigo(parcela.getCodigo());
							parceTemp.setDataInicial(parcela.getDataInicial());
							parceTemp.setDataVencimento(parcela.getDataVencimento());
							parceTemp.setPedente("Pago");
							parceTemp.setResponsavel(parcela.getResponsavel());
							parceTemp.setTurmaAluno(parcela.getTurmaAluno());
							parceTemp.setValor(parcela.getValor());
							
							Facade.getInstance().atualizar(parceTemp);
							Mensagem.exibir("Boleto pago com Sucesso");
						} catch (ValidacaoException e1) {
							// TODO Auto-generated catch block
							Mensagem.exibir(e1.getMessage());
						}
						
					}
				});
			}
		});
				
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
								Date date = new Date();
								date = telaCadastro.getTxtDataNascimento().getDate();
								responsavel.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
								responsavel.setTipo("Responsavel");								
								
								responsavel.setResetSenha(false);

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
								Date date = new Date();
								date = telaCadastro.getTxtDataNascimento().getDate();
								pedagogo.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
								pedagogo.setTipo("Pedagogo");								

								pedagogo.setResetSenha(false);
								
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
								Date date = new Date();
								date = telaCadastro.getTxtDataNascimento().getDate();
								professor.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
								professor.setTipo("Professor");								
								
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

				final DefaultComboBoxModel combo = new DefaultComboBoxModel();

				try {
					usuarios = Facade.getInstance().getBoUsuario().buscarUsuarioPorTipo("Responsavel");
					for (Usuario usuario2 : usuarios) {
						combo.addElement(usuario2.getNome());
					}		
				} catch (DAOException e2) {
					// TODO Auto-generated catch block
					Mensagem.exibir(e2.getMessage());
				}
				telaCadastrarAluno.getTxtResponsavel().setModel(combo);	
								
				telaCadastrarAluno.getBtnConfirmar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						try {
							Aluno aluno = new Aluno();
							aluno.setCpf(telaCadastrarAluno.getTxtCpf().getText());
							aluno.setNome(telaCadastrarAluno.getTxtNome().getText());
							aluno.setNaturalidade(telaCadastrarAluno.getTxtNaturalidade().getText());
							Date date = new Date();
							date = telaCadastrarAluno.getTxtDataNascimento().getDate();
							aluno.setDataDeNascimento(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
							aluno.setPai(telaCadastrarAluno.getTxtPai().getText());
							aluno.setMae(telaCadastrarAluno.getTxtMae().getText());

							usuario = Facade.getInstance().getBoUsuario().buscarUsuarioPorNomeTipo(telaCadastrarAluno.getTxtResponsavel().getSelectedItem().toString(), "Responsavel");
							
							aluno.setResponsavel((Responsavel) usuario);
							
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

									aluno.setTipo("Aluno");
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
		
		areaDeTrabalho.getMntmGerarCurriculoDoSecre().addActionListener(new ActionListener() {
			
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
	}

}
