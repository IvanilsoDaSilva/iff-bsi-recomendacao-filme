import java.nio.file.Paths;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Main {
    public static void main(String[] args) {
        // Define o caminho do arquivo FCL
        String fileName = Paths.get("src/recomendacaofilme.fcl").toAbsolutePath().toString();

        // Carrega o arquivo FCL
        FIS fis = FIS.load(fileName, true);

        // Verifica se houve erro ao carregar
        if (fis == null) {
            System.err.println("Nao foi possivel carregar o arquivo: '" + fileName + "'");
            return;
        }

        // Define as variáveis de entrada
        fis.setVariable("avaliacao", 90);  // Define a avaliação
        fis.setVariable("duracao", 70);    // Define a duração
        fis.setVariable("popularidade", 80); // Define a popularidade

        // Avalia
        fis.evaluate();

        // Obtém e mostra a variável de saída
        Variable recomendacao = fis.getVariable("recomendacao");
        JFuzzyChart.get().chart(fis);

        // Imprime o conjunto de regras
        System.out.println(fis);
        
        // Imprime a solução
        System.out.println("Valor da recomendação: "+recomendacao.getValue()); 
    }
}
