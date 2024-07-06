package med.voll.api.domain.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private String calle;
    private String numero;
    private String complemento;
    private String distrito;
    private String ciudad;

    public String getCalle() {
        return calle;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getDistrito() {
        return distrito;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Direccion(DatosDireccion direccion) {
        this.calle= direccion.calle();
        this.numero=direccion.numero();
        this.complemento= direccion.complemento();
        this.distrito=direccion.distrito();
        this.ciudad= direccion.ciudad();

    }

    public Direccion actualizarDatos(DatosDireccion direccion) {
        this.calle= direccion.calle();
        this.numero=direccion.numero();
        this.complemento= direccion.complemento();
        this.distrito=direccion.distrito();
        this.ciudad= direccion.ciudad();
        return this;
    }
}
