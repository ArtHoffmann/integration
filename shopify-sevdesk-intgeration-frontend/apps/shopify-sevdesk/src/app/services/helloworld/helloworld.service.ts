import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Configuration} from "../../core/config/Configuration";
import {KeycloakService} from "keycloak-angular";
import {HelloWorldModel} from "../../core/model/HelloWorldModel";

@Injectable({
  providedIn: 'root'
})
export class HelloworldService {

  private readonly httpClient = inject(HttpClient)
  private readonly authService = inject(KeycloakService)
  private readonly baseUrl = inject(Configuration).baseUrl;

  getHelloWorld(): Observable<HelloWorldModel> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${this.authService.getKeycloakInstance().idToken}`
    });
    return this.httpClient.get<HelloWorldModel>(`${this.baseUrl}/customers`, {headers});
  }

}
