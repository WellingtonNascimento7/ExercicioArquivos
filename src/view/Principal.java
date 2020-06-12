package view;

import java.io.File;
import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {
	public static void main(String[] args) {

		IArquivosController arqCont = new ArquivosController();
		String path = new File("").getAbsolutePath() + "\\Relatorio";
		String nome = "relatorio";
		try {		
			arqCont.convertFile(path, nome);
			arqCont.openFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
