import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DesafioJAVA {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<String> segmentos = new ArrayList<>();
        ArrayList<String> marcas = new ArrayList<>();
        ArrayList<Double> valores = new ArrayList<>();

        while(true){
            String menu = "Escolha uma opção:\n" +
                          "1. Cadastrar um produto\n" +
                          "2. Listar nomes\n" +
                          "3. Atualizar nome\n" +
                          "4. Remover nome\n" +
                          "5. Sair";

        
            String opcao = JOptionPane.showInputDialog(null, menu);

            switch(opcao){
                case "1":
                String nomeAdicionar = JOptionPane.showInputDialog("Digite o nome do produto");
                nomes.add(nomeAdicionar);

                String segmentoAdicionar = JOptionPane.showInputDialog("Digite o segmento do produto");
                segmentos.add(segmentoAdicionar);

                String marcaAdicionar = JOptionPane.showInputDialog("Digite a marca do produto");
                marcas.add(marcaAdicionar);

                Double valorAdicionar = Double.parseDouble(JOptionPane.showInputDialog("Digite a marca do produto"));
                valores.add(valorAdicionar);
                JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
                break;

                case "2":
                    if (nomes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há nenhum produto cadastrado.");
                    } else {
                        String listaProdutos = "Lista de produtos:\n";
                        for (int i = 0; i < nomes.size(); i++) {
                            listaProdutos += (i + 1) + ". Nome: " + nomes.get(i) +
                                             ", Segmento: " + segmentos.get(i) +
                                             ", Marca: " + marcas.get(i) +
                                             ", Valor: R$" + valores.get(i) + "\n";
                        }
                        JOptionPane.showMessageDialog(null, listaProdutos);
                    }
                    break;

                    case "3":
                    if (nomes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Não há produtos cadastrados para filtrar.");
                    } else {
                        String tipoFiltro = JOptionPane.showInputDialog("Deseja filtrar por:\n1. Marca\n2. Segmento");
                
                        if (tipoFiltro.equals("1")) {
                            String marcaFiltro = JOptionPane.showInputDialog("Digite o nome da marca para filtrar:");
                            String resultado = "Produtos da marca " + marcaFiltro + ":\n";
                
                            for (int i = 0; i < marcas.size(); i++) {
                                if (marcas.get(i).equalsIgnoreCase(marcaFiltro)) {
                                    resultado += (i + 1) + ". Nome: " + nomes.get(i) +
                                                 ", Segmento: " + segmentos.get(i) +
                                                 ", Valor: R$" + valores.get(i) + "\n";
                                }
                            }
                            } else if (tipoFiltro.equals("2")) {
                            String segmentoFiltro = JOptionPane.showInputDialog("Digite o nome do segmento para filtrar:");
                            String resultado = "Produtos do segmento " + segmentoFiltro + ":\n";
                
                            for (int i = 0; i < segmentos.size(); i++) {
                                if (segmentos.get(i).equalsIgnoreCase(segmentoFiltro)) {
                                    resultado += (i + 1) + ". Nome: " + nomes.get(i) +
                                                 ", Marca: " + marcas.get(i) +
                                                 ", Valor: R$" + valores.get(i) + "\n";
                                }
                            }
                            } else {
                                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado com esse segmento.");
                            }

                    }
                    break;
            }
        }
    }
}
