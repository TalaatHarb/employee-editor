import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  username: string;
  password: string;
  badcredintials: boolean;

  constructor(public auth: AuthService, public route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParams
      .subscribe(params => {
        if (params.badcredintials) {
          this.badcredintials = true;
        } else {
          this.badcredintials = false;
        }
      });
  }

}
