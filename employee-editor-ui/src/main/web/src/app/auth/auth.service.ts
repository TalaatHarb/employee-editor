import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { loginUrl } from '../../environments/environment';
import { Router, ActivatedRoute } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loggedIn: boolean;

  constructor(private httpClient: HttpClient, private router: Router, private route: ActivatedRoute) { }

  isLoggedIn(): boolean {
    this.loggedIn = sessionStorage.getItem('loggedIn') === 'true';
    return this.loggedIn;
  }

  loginUrl(url: string, username: string, password: string) {
    const httpHeaders = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });

    this.httpClient.post(url, `username=${username}&password=${password}`, { headers: httpHeaders, withCredentials: true }).subscribe(
      () => {
        this.loggedIn = true;
        sessionStorage.setItem('loggedIn', `${this.loggedIn}`);
        this.router.navigate([this.route.snapshot.queryParams.returnUrl || '/']);
      },
      () => {
        this.loggedIn = false;
        sessionStorage.setItem('loggedIn', `${this.loggedIn}`);
        this.route.queryParams
          .subscribe(params => {
            this.router.navigate(['login'], { queryParams: { returnUrl: params.returnUrl, badcredintials: true } });
          });
      }
    );
  }

  login(username: string, password: string) {
    this.loginUrl(loginUrl, username, password);
  }

  logout() {
    this.loggedIn = false;
    sessionStorage.setItem('loggedIn', `${this.loggedIn}`);
  }

  reset(){
    sessionStorage.clear();
  }

}
