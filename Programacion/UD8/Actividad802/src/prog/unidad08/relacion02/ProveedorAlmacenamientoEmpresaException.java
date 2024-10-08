package prog.unidad08.relacion02;

import java.io.Serializable;

public class ProveedorAlmacenamientoEmpresaException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public ProveedorAlmacenamientoEmpresaException(String string) {
        super(string);
    }
}
