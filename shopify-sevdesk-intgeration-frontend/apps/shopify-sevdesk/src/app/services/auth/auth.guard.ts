// src/app/auth.guard.ts
import {CanActivateFn} from '@angular/router';
import {inject} from '@angular/core';
import {KeycloakService} from 'keycloak-angular';
import {Router} from '@angular/router';

export const authGuard: CanActivateFn = async (route, state) => {
  const keycloak: KeycloakService = inject(KeycloakService);
  const token = decodeTokenPayload(keycloak.getKeycloakInstance().token)
  localStorage.setItem('USER_ROLE', token.resource_access['login-app']?.roles[0])

  const isAuthenticated = await keycloak.isLoggedIn();
  if (!isAuthenticated) {

    await keycloak.login({
      redirectUri: window.location.origin + state.url,
    });
    return false;
  }
  return true;
};

export const decodeTokenPayload: any = (token: string) => {
  const tokenParts = token.split('.');
  if (tokenParts.length === 3) {
    const payloadBase64 = tokenParts[1];
    const decodedPayload = atob(payloadBase64);
    return JSON.parse(decodedPayload);
  }
  return null;
}
