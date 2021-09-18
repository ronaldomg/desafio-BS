package br.com.bluesoft.desafio.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.ProdutoPedido;
import br.com.bluesoft.desafio.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping
    public Iterable<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @PostMapping
    public Iterable<Pedido> setPedido(HashSet<ProdutoPedido> produtos){
        HashSet<Pedido> pedidos = new HashSet<>();
        PedidoGenerator pedidoGenerator = new PedidoGenerator(produtos);
        pedidos.addAll(pedidoGenerator.getPedidos());
        if (pedidos.size() == 0){

        }else{
            pedidoRepository.saveAll(pedidos);
        }
        return pedidos;
    }
    
}
