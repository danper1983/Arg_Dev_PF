export class Persona{
    id?: number;
    nombre: String;
    apellido: String;
    descripcion: String;
    image: String;

    constructor(nombre: String, apellido: String, descripcion: String, image: String){
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.image = image;
    }
}