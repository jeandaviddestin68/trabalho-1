import java.util.ArrayList;
import java.util.List;

public class CaixaEletronica {
    int id; // (Primary key) identificador da caixa eletronica.
    List<Cartao> conta;
    private float saldo;

    public float saque(float quantia) {
        this.saldo = this.saldo - quantia;
        return this.saldo;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public List<Cartao> getCartao() {
        return conta;
    }


    public void setCartao(List<Cartao> cartao) {
        this.conta = cartao;
    }


    public CaixaEletronica() {
        this.id = 0;
        this.conta = new ArrayList<>(); 
    }
}

