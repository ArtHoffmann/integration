import {Component, OnInit} from '@angular/core';
import {RouterModule} from '@angular/router';
import {HelloworldService} from "./services/helloworld/helloworld.service";
import {Observable} from "rxjs";
import {AsyncPipe, NgIf} from "@angular/common";
import {KeycloakService} from "keycloak-angular";
import {HelloWorldModel} from "./model/HelloWorldModel";

@Component({
  standalone: true,
  imports: [RouterModule, NgIf, AsyncPipe],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent implements OnInit {
  title = 'shopify-sevdesk';
  test: HelloWorldModel | undefined;

  constructor(private helloWorldService: HelloworldService,
              private keycloakService: KeycloakService) {

  }

  ngOnInit(): void {
    this.helloWorldService.getHelloWorld().subscribe(
      data => {
        this.test = data;
        console.log('Data:', data);
      },
      error => {
        console.error('There was an error!', error);
      }
    );
  }

  public logout() {
    this.keycloakService.logout();
  }
}
