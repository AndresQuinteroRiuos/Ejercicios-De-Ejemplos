

public class persona {
    //atributos
    public String nombre;
    public int edad;
    private cuentaBancaria cuenta;
    public persona(String nombre, int edad, cuentaBancaria cuenta) {
        this.nombre = nombre;
        this.edad = edad;
        this.cuenta = cuenta;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        if (edad>0) {
            this.edad = edad;
        }
       
    }

    public void setCuenta(cuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }
    
    public cuentaBancaria accesocuenta() {
        return cuenta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("persona{");
        sb.append("nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append(", cuenta=").append(cuenta);
        sb.append('}');
        return sb.toString();
    }


}
