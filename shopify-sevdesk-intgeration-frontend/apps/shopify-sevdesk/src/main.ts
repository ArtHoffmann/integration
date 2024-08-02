// src/main.ts
import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { KeycloakService, KeycloakAngularModule } from 'keycloak-angular';
import { APP_INITIALIZER } from '@angular/core';
import { provideHttpClient } from '@angular/common/http';
import {keycloakConfig} from "./keycloak.config";
import {ActivatedRoute, provideRouter} from "@angular/router";
import routes from "./app/app.routes";
import {Configuration} from "./app/config/Configuration";

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: keycloakConfig,
      initOptions: {
        onLoad: 'login-required',
        checkLoginIframe: false,
      },
    });
}

export function configurationFactory() {
  return new Configuration('http://localhost:8081')
}

bootstrapApplication(AppComponent, {
  providers: [
    KeycloakAngularModule,
    KeycloakService,
    provideRouter(routes),
    provideHttpClient(),
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService],
    },
    {
      provide: Configuration,
      useFactory: configurationFactory
    }
  ],
}).catch((err) => console.error(err));
