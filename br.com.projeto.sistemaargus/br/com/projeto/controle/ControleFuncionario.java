package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaCadastrarNota;

public class ControleFuncionario {
	
	TelaAreaDeTrabalho areaDeTrabalho;
	double nota1 = 0;
	double nota2 = 0;
	double nota3 = 0;
	double nota4 = 0;
	double mediaparcial = 0;
	double notafinal = 0;
	double	mediafinal = 0;

	public ControleFuncionario(TelaAreaDeTrabalho areaDeTrabalho) {
		this.areaDeTrabalho = areaDeTrabalho;
		
		areaDeTrabalho.getMntmCadastrarNotas().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TelaCadastrarNota telaCadastrarNota = new TelaCadastrarNota();
				areaDeTrabalho.getjAreaTrabalho().add(telaCadastrarNota);
				telaCadastrarNota.setVisible(true);
				
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
		
	}	

}
