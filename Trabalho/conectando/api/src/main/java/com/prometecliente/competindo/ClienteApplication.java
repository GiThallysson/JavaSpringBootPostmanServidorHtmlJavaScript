import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@RequestMapping("/clientes")
public class ClienteApplication {

    private List<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(ClienteApplication.class, args);
    }

    @GetMapping
    public List<Cliente> getClientes() {
        return clientes;
    }

    @GetMapping("/{nome}")
    public Cliente getClientePorNome(@PathVariable String nome) {
        return clientes.stream()
                .filter(cliente -> cliente.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public void adicionarCliente(@RequestBody Cliente cliente) {
        clientes.add(cliente);
    }

    @DeleteMapping("/{nome}")
    public void deletarCliente(@PathVariable String nome) {
        clientes.removeIf(cliente -> cliente.getNome().equals(nome));
    }
}