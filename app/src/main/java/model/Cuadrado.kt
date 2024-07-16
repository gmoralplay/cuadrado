package model

class Cuadrado(var color:Int, var ancho:Int, var alto: Int, var x:Float, var y:Float) {
    // Cordenadas iniciales. Props



    // Comportamientos. Metodos

    fun moverArriba() {
        if(y<10){
            y-=10;
        }

    }

    fun moverAbajo() {
        y+=10;
    }

    fun moverDerecha() {
        x+=10;
    }

    fun moverIzquierda() {
        x-=10;
    }

    fun cambiarTamano(nuevoAncho:Int, nuevoAlto:Int){
        this.ancho=nuevoAncho;
        this.alto=nuevoAlto;

    }

    fun cambiarColor(color:Int){
        this.color = color
    }
}