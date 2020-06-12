package controller;

import java.io.IOException;

public interface IArquivosController {

	public void createFile(String path, String nome, String dado) throws IOException;
	public void convertFile(String path, String nome) throws IOException;
	public void openFile(String path, String nome) throws IOException;
}
