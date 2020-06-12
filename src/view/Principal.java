package view;

import java.io.File;
import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {
	public static void main(String[] args) {

		IArquivosController arqCont = new ArquivosController();
		String path = new File("").getAbsolutePath() + "\\Relatorio";
		//String path = "C:\\TEMP\\aula";
		String nome = "relatorio";
		try {
			//arqCont.readDir(dirWin);
			//arqCont.createFile(path, nome);
			arqCont.convertFile(path, nome);
			arqCont.openFile(path, nome);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
