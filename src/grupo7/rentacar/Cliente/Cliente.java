package grupo7.rentacar.Cliente;

public class Cliente {
    private String nombre;
    private String apellidos;
    private int cedula;
    private String correoElec;
    private String fechaNaci;
    private Categoria categoria;
    private int categoriaLevel;

    public Cliente(String nombre, String apellidos, int cedula, String correoElec, String fechaNaci, Categoria categoria) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.correoElec = correoElec;
        this.fechaNaci = fechaNaci;
        this.categoria = categoria;
        setCategoriaLevel();
    }
    public void subirCategoria(){
        switch(categoria.name()){
            case "Bronce":
                categoria = Categoria.Plata;
                break;
            case "Plata":
                categoria = Categoria.Oro;
                break;
            case "Oro":
                categoria = Categoria.Zafiro;
                break;
                
        }
        setCategoriaLevel();
    }
    public void bajarCategoria(){
        switch(categoria.name()){
            case "Plata":
                categoria = Categoria.Bronce;
                break;
            case "Oro":
                categoria = Categoria.Plata;
                break;
            case "Zafiro":
                categoria = Categoria.Oro;
                break;
                
        }
        setCategoriaLevel();
    }

    private void setCategoriaLevel(){
        switch(categoria.name()){
            case "Bronce":
                categoriaLevel =0;
                break;
            case "Plata":
                categoriaLevel =1;
                break;
            case "Oro":
                categoriaLevel =2;
                break;
            case "Zafiro":
                categoriaLevel =3;
                break;
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCorreoElec() {
        return correoElec;
    }

    public void setCorreoElec(String correoElec) {
        this.correoElec = correoElec;
    }

    public String getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(String fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        setCategoriaLevel();
    }
    public int getCategorialevel(){
        return categoriaLevel;
    }
}
