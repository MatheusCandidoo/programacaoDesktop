package revisao.capitulo5.exercicio6;

public class TestaAluno2 {

    public static void main(String[] args) {
        Aluno2 aluno = new Aluno2();

        aluno.recebeNota1(6);
        aluno.recebeNota2(7);
        aluno.recebeNota3(7);
        aluno.recebeNota4(8);

        aluno.imprimeMédia();
    }
}
