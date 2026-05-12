import padroesestruturais.composite.*;

public class LojaBicicletasCompositeManualTest {

    public static void main(String[] args) {
        deveRetornarPrecoDeItemIndividual();
        deveCalcularPrecoDeKitDeAcessorios();
        deveCalcularPrecoDeComboComKitDentroDeKit();
        deveRemoverProdutoDoKit();
        deveUsarLojaParaCalcularTotalDoPedido();
        deveRetornarValorZeroParaKitVazio();
        System.out.println("Todos os testes manuais passaram com sucesso!");
    }

    private static void deveRetornarPrecoDeItemIndividual() {
        ProdutoLoja capacete = new ItemBicicleta("Capacete", "Capacete de segurança", 150.00);
        validarDouble(150.00, capacete.getPreco(), "deveRetornarPrecoDeItemIndividual");
    }

    private static void deveCalcularPrecoDeKitDeAcessorios() {
        KitBicicleta kit = new KitBicicleta("Kit de Acessórios", "Pacote de acessórios");
        kit.adicionarProduto(new ItemBicicleta("Capacete", "Capacete de segurança", 150.00));
        kit.adicionarProduto(new ItemBicicleta("Farol LED", "Farol dianteiro", 80.00));
        kit.adicionarProduto(new ItemBicicleta("Suporte para Garrafa", "Suporte instalado no quadro", 45.00));

        validarDouble(275.00, kit.getPreco(), "deveCalcularPrecoDeKitDeAcessorios");
        validarInt(3, kit.getQuantidadeItens(), "deveCalcularQuantidadeDeItensDeKitDeAcessorios");
    }

    private static void deveCalcularPrecoDeComboComKitDentroDeKit() {
        ProdutoLoja mountainBike = new ItemBicicleta("Mountain Bike Aro 29", "Bicicleta para trilhas", 2500.00);

        KitBicicleta kitAcessorios = new KitBicicleta("Kit de Acessórios", "Pacote de acessórios");
        kitAcessorios.adicionarProduto(new ItemBicicleta("Capacete", "Capacete de segurança", 150.00));
        kitAcessorios.adicionarProduto(new ItemBicicleta("Farol LED", "Farol dianteiro", 80.00));
        kitAcessorios.adicionarProduto(new ItemBicicleta("Suporte para Garrafa", "Suporte instalado no quadro", 45.00));

        KitBicicleta combo = new KitBicicleta("Combo Trilha", "Combo completo para trilhas");
        combo.adicionarProduto(mountainBike);
        combo.adicionarProduto(kitAcessorios);

        validarDouble(2775.00, combo.getPreco(), "deveCalcularPrecoDeComboComKitDentroDeKit");
        validarInt(4, combo.getQuantidadeItens(), "deveCalcularQuantidadeDeItensDeComboComKitDentroDeKit");
    }

    private static void deveRemoverProdutoDoKit() {
        ProdutoLoja capacete = new ItemBicicleta("Capacete", "Capacete de segurança", 150.00);
        ProdutoLoja farol = new ItemBicicleta("Farol LED", "Farol dianteiro", 80.00);

        KitBicicleta kit = new KitBicicleta("Kit de Acessórios", "Pacote de acessórios");
        kit.adicionarProduto(capacete);
        kit.adicionarProduto(farol);
        kit.removerProduto(farol);

        validarDouble(150.00, kit.getPreco(), "deveRemoverProdutoDoKit");
        validarInt(1, kit.getQuantidadeItens(), "deveRemoverProdutoDoKitQuantidade");
    }

    private static void deveUsarLojaParaCalcularTotalDoPedido() {
        LojaBicicletas loja = new LojaBicicletas();
        KitBicicleta pedido = new KitBicicleta("Pedido Cliente João", "Pedido completo do cliente");
        pedido.adicionarProduto(new ItemBicicleta("Speed Bike Carbon", "Bicicleta de estrada", 4200.00));
        pedido.adicionarProduto(new ItemBicicleta("Caramanhola", "Garrafa para hidratação", 60.00));

        validarDouble(4260.00, loja.calcularTotalPedido(pedido), "deveUsarLojaParaCalcularTotalDoPedido");
        validarInt(2, loja.calcularQuantidadeItensPedido(pedido), "deveUsarLojaParaCalcularQuantidadeDoPedido");
    }

    private static void deveRetornarValorZeroParaKitVazio() {
        KitBicicleta kitVazio = new KitBicicleta("Kit Vazio", "Kit sem produtos");
        validarDouble(0.00, kitVazio.getPreco(), "deveRetornarValorZeroParaKitVazio");
        validarInt(0, kitVazio.getQuantidadeItens(), "deveRetornarQuantidadeZeroParaKitVazio");
    }

    private static void validarDouble(double esperado, double atual, String nomeTeste) {
        if (Math.abs(esperado - atual) > 0.0001) {
            throw new AssertionError(nomeTeste + " falhou. Esperado: " + esperado + ", atual: " + atual);
        }
        System.out.println("OK - " + nomeTeste);
    }

    private static void validarInt(int esperado, int atual, String nomeTeste) {
        if (esperado != atual) {
            throw new AssertionError(nomeTeste + " falhou. Esperado: " + esperado + ", atual: " + atual);
        }
        System.out.println("OK - " + nomeTeste);
    }
}
