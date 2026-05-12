package padroesestruturais.composite;

public class LojaBicicletas {

    public double calcularTotalPedido(ProdutoLoja produto) {
        return produto.getPreco();
    }

    public int calcularQuantidadeItensPedido(ProdutoLoja produto) {
        return produto.getQuantidadeItens();
    }

    public String gerarResumoPedido(ProdutoLoja produto) {
        return produto.getResumo();
    }
}
