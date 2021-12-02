package controller;

import java.io.*;
import java.util.ArrayList;

/**
 * @author fabricio
 */
public class TextController {

    private File arquivo;

    public TextController(File arq) {
        arquivo = arq;
    }

    TextController() {
      }

    public ArrayList<String> lerArquivo() {
        ArrayList<String> aux2 = new ArrayList<>();
        String aux;
        try {
            BufferedReader leitorbuffer = new BufferedReader(new FileReader(arquivo));
            while (leitorbuffer.ready()) {
                aux = leitorbuffer.readLine();
                aux2.add(aux);
            }
            leitorbuffer.close();
        } catch (IOException erro) {
            System.err.println("Erro de leitura do arquivo." + erro);
        } finally {
            return (aux2);
        }
    }

    public void escreverArquivo(String aux, boolean append) {
        try {
            BufferedWriter escritorbuffer = new BufferedWriter(
                    new FileWriter(arquivo, append));
            escritorbuffer.write(aux);
            if (append) {
                escritorbuffer.newLine();                
            }
            escritorbuffer.close();
        } catch (IOException erro) {
            System.err.println("Erro ao escrever no arquivo. " + erro);
        }
    }

}
