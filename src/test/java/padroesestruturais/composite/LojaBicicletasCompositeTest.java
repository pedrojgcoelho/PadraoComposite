package padroesestruturais.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LojaBicicletasCompositeTest {

    @Test
    public void deveRetornarPrecoDeItemIndividual() {
        ProdutoLoja capacete = new ItemBicicleta(
                "Capacete",
                "Capacete de segurança",
                150.00
        );

        assertEquals(150.00, capacete.getPreco());
    }

    @Test
    public void deveRetornarDescricaoDeItemIndividual() {
        ProdutoLoja farolLed = new ItemBicicleta(
                "Farol LED",
                "Farol dianteiro para pedal noturno",
                80.00
        );

        assertEquals("Farol dianteiro para pedal noturno", farolLed.getDescricao());
    }

    @Test
    public void deveCalcularPrecoDeKitDeAcessorios() {
        ProdutoLoja capacete = new ItemBicicleta("Capacete", "Capacete de segurança", 150.00);
        ProdutoLoja farolLed = new ItemBicicleta("Farol LED", "Farol dianteiro", 80.00);
        ProdutoLoja suporteGarrafa = new ItemBicicleta("Suporte para Garrafa", "Suporte instalado no quadro", 45.00);

        KitBicicleta kitAcessorios = new KitBicicleta(
                "Kit de Acessórios",
                "Pacote de acessórios para bicicleta"
        );
        kitAcessorios.adicionarProduto(capacete);
        kitAcessorios.adicionarProduto(farolLed);
        kitAcessorios.adicionarProduto(suporteGarrafa);

        assertEquals(275.00, kitAcessorios.getPreco());
    }

    @Test
    public void deveCalcularQuantidadeDeItensDeKitDeAcessorios() {
        ProdutoLoja capacete = new ItemBicicleta("Capacete", "Capacete de segurança", 150.00);
        ProdutoLoja farolLed = new ItemBicicleta("Farol LED", "Farol dianteiro", 80.00);
        ProdutoLoja suporteGarrafa = new ItemBicicleta("Suporte para Garrafa", "Suporte instalado no quadro", 45.00);

        KitBicicleta kitAcessorios = new KitBicicleta(
                "Kit de Acessórios",
                "Pacote de acessórios para bicicleta"
        );
        kitAcessorios.adicionarProduto(capacete);
        kitAcessorios.adicionarProduto(farolLed);
        kitAcessorios.adicionarProduto(suporteGarrafa);

        assertEquals(3, kitAcessorios.getQuantidadeItens());
    }

    @Test
    public void deveCalcularPrecoDeComboComKitDentroDeKit() {
        ProdutoLoja mountainBike = new ItemBicicleta("Mountain Bike Aro 29", "Bicicleta para trilhas", 2500.00);
        ProdutoLoja capacete = new ItemBicicleta("Capacete", "Capacete de segurança", 150.00);
        ProdutoLoja farolLed = new ItemBicicleta("Farol LED", "Farol dianteiro", 80.00);
        ProdutoLoja suporteGarrafa = new ItemBicicleta("Suporte para Garrafa", "Suporte instalado no quadro", 45.00);

        KitBicicleta kitAcessorios = new KitBicicleta("Kit de Acessórios", "Pacote de acessórios");
        kitAcessorios.adicionarProduto(capacete);
        kitAcessorios.adicionarProduto(farolLed);
        kitAcessorios.adicionarProduto(suporteGarrafa);

        KitBicicleta comboTrilha = new KitBicicleta("Combo Trilha", "Combo completo para trilhas");
        comboTrilha.adicionarProduto(mountainBike);
        comboTrilha.adicionarProduto(kitAcessorios);

        assertEquals(2775.00, comboTrilha.getPreco());
        assertEquals(4, comboTrilha.getQuantidadeItens());
    }

    @Test
    public void deveRemoverProdutoDoKit() {
        ProdutoLoja capacete = new ItemBicicleta("Capacete", "Capacete de segurança", 150.00);
        ProdutoLoja farolLed = new ItemBicicleta("Farol LED", "Farol dianteiro", 80.00);

        KitBicicleta kitAcessorios = new KitBicicleta("Kit de Acessórios", "Pacote de acessórios");
        kitAcessorios.adicionarProduto(capacete);
        kitAcessorios.adicionarProduto(farolLed);
        kitAcessorios.removerProduto(farolLed);

        assertEquals(150.00, kitAcessorios.getPreco());
        assertEquals(1, kitAcessorios.getQuantidadeItens());
    }

    @Test
    public void deveUsarLojaParaCalcularTotalDoPedido() {
        LojaBicicletas loja = new LojaBicicletas();
        ProdutoLoja speedBike = new ItemBicicleta("Speed Bike Carbon", "Bicicleta de estrada", 4200.00);
        ProdutoLoja caramanhola = new ItemBicicleta("Caramanhola", "Garrafa para hidratação", 60.00);

        KitBicicleta pedido = new KitBicicleta("Pedido Cliente João", "Pedido completo do cliente");
        pedido.adicionarProduto(speedBike);
        pedido.adicionarProduto(caramanhola);

        assertEquals(4260.00, loja.calcularTotalPedido(pedido));
        assertEquals(2, loja.calcularQuantidadeItensPedido(pedido));
    }

    @Test
    public void deveRetornarValorZeroParaKitVazio() {
        KitBicicleta kitVazio = new KitBicicleta("Kit Vazio", "Kit sem produtos");

        assertEquals(0.00, kitVazio.getPreco());
        assertEquals(0, kitVazio.getQuantidadeItens());
    }
}
