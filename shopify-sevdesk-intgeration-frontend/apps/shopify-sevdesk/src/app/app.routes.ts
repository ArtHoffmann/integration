// src/app/app.routes.ts
import { Routes } from '@angular/router';
import { authGuard } from './services/auth/auth.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import {AppComponent} from "./app.component";

const routes: Routes = [
  { path: 'home', component: HomeComponent, canActivate: [authGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'app', component: AppComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: '**', redirectTo: 'login', pathMatch: 'full' } // Wildcard route for a 404 page
];

export default routes;
