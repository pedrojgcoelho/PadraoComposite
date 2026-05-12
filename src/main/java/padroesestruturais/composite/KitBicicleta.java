package padroesestruturais.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KitBicicleta implements ProdutoLoja {

    private String nome;
    private String descricao;
    private List<ProdutoLoja> produtos;

    public KitBicicleta(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(ProdutoLoja produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(ProdutoLoja produto) {
        this.produtos.remove(produto);
    }

    public List<ProdutoLoja> getProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDescricao() {
        if (produtos.isEmpty()) {
            return descricao + " sem produtos.";
        }

        String nomesProdutos = produtos.stream()
                .map(ProdutoLoja::getNome)
                .collect(Collectors.joining(", "));

        return descricao + " composto por: " + nomesProdutos + ".";
    }

    @Override
    public double getPreco() {
        double total = 0.0;

        for (ProdutoLoja produto : produtos) {
            total += produto.getPreco();
        }

        return total;
    }

    @Override
    public int getQuantidadeItens() {
        int quantidade = 0;

        for (ProdutoLoja produto : produtos) {
            quantidade += produto.getQuantidadeItens();
        }

        return quantidade;
    }

    @Override
    public String getResumo() {
        return montarResumo("");
    }

    private String montarResumo(String nivel) {
        StringBuilder resumo = new StringBuilder();
        resumo.append(nivel)
                .append(nome)
                .append(" - ")
                .append(descricao)
                .append(" - Total: R$ ")
                .append(getPreco());

        for (ProdutoLoja produto : produtos) {
            resumo.append("\n");

            if (produto instanceof KitBicicleta) {
                resumo.append(((KitBicicleta) produto).montarResumo(nivel + "  "));
            } else {
                resumo.append(nivel)
                        .append("  ")
                        .append(produto.getResumo());
            }
        }

        return resumo.toString();
    }
}
