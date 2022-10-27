import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';


@Component({
  selector: 'app-edit-experiencia',
  templateUrl: './edit-experiencia.component.html',
  styleUrls: ['./edit-experiencia.component.css']
})
export class EditExperienciaComponent implements OnInit {

  expLab: Experiencia = null;

  constructor(private sExperiencia: SExperienciaService, private activateRouter: ActivatedRoute, private router: Route) { }

  ngOnInit(): void {
    const id = this.activateRouter.snapshot.params['id'];
    this.sExperiencia.detail(id).subscribe(
      data => {
        this.expLab=data;
      }, err => {
        alert("Ups no se guardaron los datos")
        this.router.navigate(['']);
      }
      )
  }

  onUpdate(): void{
    const id = this.activateRouter.snapshot.params['id'];
    this.sExperiencia.update(id, this.expLab).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Ups no se guardaron los datos")
        this.router.navigate(['']);
      }
    )
  }
}
