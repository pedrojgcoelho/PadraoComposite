package padroesestruturais.composite;

public class ItemBicicleta implements ProdutoLoja {

    private String nome;
    private String descricao;
    private double preco;

    public ItemBicicleta(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public int getQuantidadeItens() {
        return 1;
    }

    @Override
    public String getResumo() {
        return nome + " - " + descricao + " - R$ " + preco;
    }
}
