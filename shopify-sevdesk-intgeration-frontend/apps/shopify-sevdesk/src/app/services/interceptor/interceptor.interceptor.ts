import {HttpInterceptorFn} from '@angular/common/http';
import {inject} from "@angular/core";
import {KeycloakService} from "keycloak-angular";

export const interceptorInterceptor: HttpInterceptorFn = (req, next) => {
  const keyCloakService = inject(KeycloakService);

  const token = keyCloakService.getKeycloakInstance().token;

  if (!token) {
    return next(req);
  }

  return next(
    req.clone({
      headers: req.headers.set('Authorization', `Bearer ${token}`),
    }),
  );
};
