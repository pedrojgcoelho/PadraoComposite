package padroesestruturais.composite;

public class LojaBicicletasCompositeDemo {

    public static void main(String[] args) {
        ProdutoLoja mountainBike = new ItemBicicleta(
                "Mountain Bike Aro 29",
                "Bicicleta para trilhas",
                2500.00
        );

        ProdutoLoja capacete = new ItemBicicleta(
                "Capacete",
                "Capacete de segurança",
                150.00
        );

        ProdutoLoja farolLed = new ItemBicicleta(
                "Farol LED",
                "Farol dianteiro para pedal noturno",
                80.00
        );

        ProdutoLoja suporteGarrafa = new ItemBicicleta(
                "Suporte para Garrafa",
                "Suporte instalado no quadro da bicicleta",
                45.00
        );

        KitBicicleta kitAcessorios = new KitBicicleta(
                "Kit de Acessórios",
                "Pacote de acessórios para bicicleta"
        );
        kitAcessorios.adicionarProduto(capacete);
        kitAcessorios.adicionarProduto(farolLed);
        kitAcessorios.adicionarProduto(suporteGarrafa);

        KitBicicleta comboTrilha = new KitBicicleta(
                "Combo Trilha",
                "Combo completo para trilhas"
        );
        comboTrilha.adicionarProduto(mountainBike);
        comboTrilha.adicionarProduto(kitAcessorios);

        LojaBicicletas loja = new LojaBicicletas();

        System.out.println(loja.gerarResumoPedido(comboTrilha));
        System.out.println("Quantidade de itens: " + loja.calcularQuantidadeItensPedido(comboTrilha));
        System.out.println("Valor total: R$ " + loja.calcularTotalPedido(comboTrilha));
    }
}
