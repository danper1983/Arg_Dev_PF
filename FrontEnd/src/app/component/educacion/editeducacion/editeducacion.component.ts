import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route} from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-editeducacion',
  templateUrl: './editeducacion.component.html',
  styleUrls: ['./editeducacion.component.css']
})
export class EditeducacionComponent implements OnInit {
  educacion: Educacion = null;

  constructor(private Seducacion: EducacionService, private activateRouter: ActivatedRoute, private router: Route) { }

  ngOnInit(): void {
    const id = this.activateRouter.snapshot.params['id'];
    this.Seducacion.detail(id).subscribe(
      data =>{
        this.educacion = data;
      }, err =>{
        alert("No se pudo modificar el campo");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate():void{
    const id = this.activateRouter.snapshot.params['id'];
    this.Seducacion.update(id, this.educacion).subscribe(
      data=>{
        this.router.navigate(['']);
      }, err =>{
          alert("No pudo editarse el campo");
          this.router.navigate(['']);
      }
    )
  }
}
