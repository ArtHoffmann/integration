import {Routes} from '@angular/router';
import {authGuard} from './services/auth/auth.guard';
import {AppDashboardComponent} from "./shared/components/app-dashboard/app-dashboard.component";
import {AppShopifyTableComponent} from "./shared/components/app-shopify-table/app-shopify-table.component";
import {AppShellComponent} from "./shared/components/app-shell/app-shell.component";

export const appRoutes: Routes = [
  {
    path: '',
    component: AppShellComponent,
    canActivate: [authGuard],
    children: [
      {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full',
      },
      {
        path: 'dashboard',
        component: AppDashboardComponent,
        providers: [],
      },
      {
        path: 'shopify',
        component: AppShopifyTableComponent,
        providers: [],
      },
    ]
  }
];
