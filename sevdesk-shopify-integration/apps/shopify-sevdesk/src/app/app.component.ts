import {Component, OnInit} from '@angular/core';
import {RouterModule} from '@angular/router';
import {NxWelcomeComponent} from './nx-welcome.component';
import {HelloworldService} from "./helloworld.service";
import {Observable} from "rxjs";
import {AsyncPipe, NgIf} from "@angular/common";

@Component({
  standalone: true,
  imports: [NxWelcomeComponent, RouterModule, NgIf, AsyncPipe],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent implements OnInit {

  test: Observable<any> | undefined;

  constructor(private helloWorldService: HelloworldService) {
  }

  title = 'shopify-sevdesk';

  ngOnInit(): void {
    this.helloWorldService.getHelloWorld().pipe(x => this.test = x)
  }
}
