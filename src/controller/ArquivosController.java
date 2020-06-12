package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {
		super();
	}
	
	@Override
	public void createFile(String path, String nome, String dado) throws IOException {
		File dir = new File(path);
		File arq = new File(path, nome+ ".csv");		
		if (dir.exists() && dir.isDirectory()) {		
			FileWriter fileWriter = new FileWriter(arq);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(dado);
			print.flush();
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretorio inválido");
		}
	}	

	@Override
	public void convertFile(String path, String nome) throws IOException {		
		File arq = new File(path, nome + ".txt");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			String linhaC = linha + "\r\n";
			while (linha != null) {
				linha = buffer.readLine();
				if (linha != null) {
					linhaC = linhaC + linha.replace(" ", ";") + "\r\n";
				}
			}
			createFile(path, nome, linhaC);
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}

	@Override
	public void openFile(String path, String nome) throws IOException {
		File arq = new File(path, nome + ".csv");
		if (arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}
}
