package com.example;

import java.util.List;

public class Veterinaria {


private final RegistroMascota registro ;

    public Veterinaria(RegistroMascota registro) {
        this.registro = registro;
}
public void registrarMascota(String nombre, String tipo) {
    registro.agregarMascota(new Mascota(nombre, tipo));

}
public void registrarMascota(Mascota mascota) {
    registro.agregarMascota(mascota);
}
public List<Mascota> ListarMascotas() {
    return registro.obtenerMascota();

}

    void registrarMascota(Mascota NuevaMascota) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
///
///public void registrarMascota(Mascota nuevaMascota) {
    /// TODO Auto-generated method stub
   /// throw new UnsupportedOperationException("Unimplemented method 'registrarMascota'");
///}
}
