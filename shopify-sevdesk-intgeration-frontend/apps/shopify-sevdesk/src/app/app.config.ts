import {ApplicationConfig, provideZoneChangeDetection} from '@angular/core';
import {provideRouter} from '@angular/router';
import routes from "./app.routes";
import {provideHttpClient, withFetch, withInterceptors} from "@angular/common/http";
import {interceptorInterceptor} from "./services/interceptor/interceptor.interceptor";
import {Configuration} from "./config/Configuration";

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({eventCoalescing: true}),
    provideRouter(routes),
    provideHttpClient(withInterceptors([interceptorInterceptor]), withFetch()),
    {
      provide: Configuration,
      useValue: new Configuration(
        'http://localhost:8081/',
      ),
    },
  ],
};
