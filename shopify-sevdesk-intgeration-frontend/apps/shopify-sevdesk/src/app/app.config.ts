import {ApplicationConfig, provideZoneChangeDetection} from '@angular/core';
import {provideRouter} from '@angular/router';
import {provideHttpClient, withFetch, withInterceptors} from '@angular/common/http';
import {interceptorInterceptor} from './services/interceptor/interceptor.interceptor';
import {Configuration} from './core/config/Configuration';
import {appRoutes} from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(appRoutes),
    provideHttpClient(withInterceptors([interceptorInterceptor]), withFetch()),
    {
      provide: Configuration,
      useValue: new Configuration('http://localhost:8081/'),
    },
  ],
};
