export class persona{
    id?: number;
    nombre: String;
    apellido: String;
    image: String;

    constructor(nombre: String, apellido: String, image: String){
        this.nombre = nombre;
        this.apellido = apellido;
        this.image = image;
    }
}