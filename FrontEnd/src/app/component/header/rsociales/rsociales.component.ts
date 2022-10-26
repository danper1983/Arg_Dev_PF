import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-rsociales',
  templateUrl: './rsociales.component.html',
  styleUrls: ['./rsociales.component.css']
})
export class RsocialesComponent implements OnInit {

  isLogged = false;
  constructor(private router: Router, private tokenService: TokenService) { }

  ngOnInit(): void {
    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }
onLoggOut(): void{
  this.tokenService.logout();
  window.location.reload();
}


login(){
  this.router.navigate(['/login'])
}
}
