import { Component, OnInit } from '@angular/core';
import { Route } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-neweducacion',
  templateUrl: './neweducacion.component.html',
  styleUrls: ['./neweducacion.component.css']
})
export class NeweducacionComponent implements OnInit {
  nombreE: string;
  descripcionE: string;

  constructor(private Seducacion: EducacionService, private router: Route) {

   }

  ngOnInit(): void {
  }

  onCreate(): void{
    const educacion = new Educacion(this.nombreE, this.descripcionE);

    this.Seducacion.save(educacion).subscribe(
      data =>{
        alert("Educación agregada correctamente");
        this.router.navigate(['']);
      }, err =>{
        alert("No pudo agregarse el campo");
        this.router.navigate(['']);
      }
    )
  }
}
