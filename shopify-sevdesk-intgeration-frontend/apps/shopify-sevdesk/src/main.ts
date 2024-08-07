import {bootstrapApplication} from '@angular/platform-browser';
import {AppComponent} from './app/app.component';
import {KeycloakAngularModule, KeycloakService} from 'keycloak-angular';
import {APP_INITIALIZER} from '@angular/core';
import {keycloakConfig} from "./keycloak.config";
import {provideRouter} from "@angular/router";
import {Configuration} from "./app/core/config/Configuration";
import {appRoutes} from "./app/app.routes";
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async';

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
  return new Configuration('http://localhost:8081');
}

bootstrapApplication(AppComponent, {
  providers: [
    KeycloakAngularModule,
    KeycloakService,
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService],
    },
    {
      provide: Configuration,
      useFactory: configurationFactory,
    },
    // provideHttpClient(withInterceptors([interceptorInterceptor]), withFetch()),
    provideRouter(appRoutes),
    provideAnimationsAsync()
  ],
}).catch((err) => console.error(err));
