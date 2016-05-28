package dto;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public class Contacto {

    private int contactoId;
    private String nombre;
    private String telefono;

    public Contacto() {
        ;
    }

    public void setContactoId(int contactoId) {
        this.contactoId = contactoId;
    }

    public int getContactoId() {
        return this.contactoId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return this.telefono;
    }

}
